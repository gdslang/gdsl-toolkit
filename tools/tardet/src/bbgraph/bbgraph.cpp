/*
 * bbgraph.cpp
 *
 *  Created on: Aug 9, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <memory>
#include <functional>
#include <tuple>
#include "../expression/expression.h"
#include "bbgraph.h"
#include "bbgraph_node.h"

using namespace std;

void bbgraph::print_dot() {
	printf("digraph G {\n");
	printf("\tnode [shape=box];\n");
	printf("\tcompound=true;\n");
	root->print_dot();
	printf("}\n");
}

tuple<vector<shared_ptr<bbgraph_node>>, shared_ptr<bbgraph_node>, shared_ptr<bbgraph_node>> bbgraph::from_rreil_statements(
		struct rreil_statements *stmts, size_t address) {
	size_t counter = 0;
	vector<shared_ptr<bbgraph_node>> nodes = vector<shared_ptr<bbgraph_node>>();

	function<tuple<shared_ptr<bbgraph_node>, shared_ptr<bbgraph_node>>(struct rreil_statements*)> connect_nodes =
			[&](struct rreil_statements *stmts) {
				shared_ptr<bbgraph_node> current;
				struct rreil_statements acc;
				auto next = [&]() {
					acc.statements_length = 0;
					acc.statements_size = stmts->statements_size;
					acc.statements = (struct rreil_statement**)malloc(sizeof(struct rreil_statement*)*acc.statements_size);

					current = shared_ptr<bbgraph_node>(new bbgraph_node(new bbgraph_id(address, counter++), acc));
					nodes.push_back(current);
//					printf("Constructed: %s\n", current->get_id()->to_string().c_str());
				};

				next();
				shared_ptr<bbgraph_node> me = current;

				auto connect = [&](shared_ptr<bbgraph_node> a, shared_ptr<bbgraph_node> b, shared_ptr<expression> condition) {
					a->add_child(b, condition);
					b->add_parent(a);
				};

				for (size_t i = 0; i < stmts->statements_length; ++i) {
					struct rreil_statement *stmt = stmts->statements[i];

					switch(stmt->type) {
						case RREIL_STATEMENT_TYPE_ITE: {
							shared_ptr<bbgraph_node> then_start;
							shared_ptr<bbgraph_node> then_end;
							tie(then_start, then_end) = connect_nodes(stmt->ite.then_branch);

							shared_ptr<bbgraph_node> else_start;
							shared_ptr<bbgraph_node> else_end;
							tie(else_start, else_end) = connect_nodes(stmt->ite.else_branch);

							connect(current, then_start, expression::true_);
							connect(current, else_start, expression::true_);

							next();

							connect(then_end, current, expression::true_);
							connect(else_end, current, expression::true_);
							break;
						}
						case RREIL_STATEMENT_TYPE_WHILE: {
							shared_ptr<bbgraph_node> body_start;
							shared_ptr<bbgraph_node> body_end;
							tie(body_start, body_end) = connect_nodes(stmt->while_.body);

							connect(current, body_start, expression::true_);
							shared_ptr<bbgraph_node> backup = current;
							next();
							connect(backup, current, expression::true_);
							connect(body_start, body_end, expression::true_);
							connect(body_end, current, expression::true_);
							break;
						}
						default: {
							acc.statements[acc.statements_length++] = stmt;
							break;
						}
					}
				}

				return tuple<shared_ptr<bbgraph_node>, shared_ptr<bbgraph_node>>(me, current);
			};

	return tuple_cat(tuple<vector<shared_ptr<bbgraph_node>>>(nodes), connect_nodes(stmts));
}
