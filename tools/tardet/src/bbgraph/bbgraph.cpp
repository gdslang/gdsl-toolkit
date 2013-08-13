/*
 * bbgraph.cpp
 *
 *  Created on: Aug 9, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <memory>
#include <vector>
#include <map>
#include <functional>
#include <tuple>
#include "../expression/expression.h"
#include "bbgraph.h"
#include "bbgraph_node.h"

using namespace std;

shared_ptr<bbgraph_node> bbgraph::get_root() {
	if(addr_map.find(0) == addr_map.end())
		return NULL;
	vector<shared_ptr<bbgraph_node>> base = addr_map[0];
	if(!base.size())
		return NULL;
	return base.front();
}

void bbgraph::print_dot() {
	printf("digraph G {\n");
	printf("\tnode [shape=box];\n");
	printf("\tcompound=true;\n");
	get_root()->print_dot();
	printf("}\n");
}

vector<shared_ptr<bbgraph_rrnode>> bbgraph::from_rreil_statements(
		struct rreil_statements *stmts, size_t address) {
	size_t counter = 0;
	vector<shared_ptr<bbgraph_rrnode>> nodes = vector<shared_ptr<bbgraph_rrnode>>();

	function<tuple<shared_ptr<bbgraph_rrnode>, shared_ptr<bbgraph_rrnode>>(struct rreil_statements*)> connect_nodes =
			[&](struct rreil_statements *stmts) {
				shared_ptr<bbgraph_rrnode> current;

				auto next = [&]() {
					struct rreil_statements acc;
					acc.statements_length = 0;
					acc.statements_size = stmts->statements_size;
					acc.statements = (struct rreil_statement**)malloc(sizeof(struct rreil_statement*)*acc.statements_size);

					current = shared_ptr<bbgraph_rrnode>(new bbgraph_rrnode(new bbgraph_id(address, counter++), acc));
					nodes.push_back(current);
//					printf("Constructed: %s\n", current->get_id()->to_string().c_str());
				};

				next();
				shared_ptr<bbgraph_rrnode> me = current;

				auto connect = [&](shared_ptr<bbgraph_rrnode> a, shared_ptr<bbgraph_rrnode> b, shared_ptr<expression> condition) {
					a->add_child(b, condition);
					b->add_parent(a, condition);
				};

				for (size_t i = 0; i < stmts->statements_length; ++i) {
					struct rreil_statement *stmt = stmts->statements[i];

					switch(stmt->type) {
						case RREIL_STATEMENT_TYPE_ITE: {
							shared_ptr<bbgraph_rrnode> then_start;
							shared_ptr<bbgraph_rrnode> then_end;
							tie(then_start, then_end) = connect_nodes(stmt->ite.then_branch);

							shared_ptr<bbgraph_rrnode> else_start;
							shared_ptr<bbgraph_rrnode> else_end;
							tie(else_start, else_end) = connect_nodes(stmt->ite.else_branch);

							connect(current, then_start, expression::from_rreil_sexpr(stmt->ite.cond, 1 /* Todo: fix */));
							connect(current, else_start, expression::not_(expression::from_rreil_sexpr(stmt->ite.cond, 1 /* Todo: fix */)));

							next();

							connect(then_end, current, expression::true_);
							connect(else_end, current, expression::true_);
							break;
						}
						case RREIL_STATEMENT_TYPE_WHILE: {
							shared_ptr<bbgraph_rrnode> body_start;
							shared_ptr<bbgraph_rrnode> body_end;
							tie(body_start, body_end) = connect_nodes(stmt->while_.body);

							connect(current, body_start, expression::from_rreil_sexpr(stmt->while_.cond, 1 /* Todo: fix */));
							shared_ptr<bbgraph_rrnode> backup = current;
							next();
							connect(backup, current, expression::not_(expression::from_rreil_sexpr(stmt->while_.cond, 1 /* Todo: fix */)));
							connect(body_end, body_start, expression::from_rreil_sexpr(stmt->while_.cond, 1 /* Todo: fix */));
							connect(body_end, current, expression::not_(expression::from_rreil_sexpr(stmt->while_.cond, 1 /* Todo: fix */)));
							break;
						}
						default: {
							struct rreil_statements *acc = current->get_stmts();
							acc->statements[acc->statements_length++] = stmt;
							break;
						}
					}
				}

				return tuple<shared_ptr<bbgraph_rrnode>, shared_ptr<bbgraph_rrnode>>(me, current);
			};

	connect_nodes(stmts);

	return nodes;
}

void bbgraph::rreil_add(struct rreil_statements *statements, int64_t offset) {
	vector<shared_ptr<bbgraph_rrnode>> nodes = bbgraph::from_rreil_statements(statements, offset);
}
