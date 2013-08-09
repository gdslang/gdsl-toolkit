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
#include "bbgraph.h"
#include "bbgraph_node.h"

void bbgraph::print_dot() {
	printf("digraph G {\n");
	printf("\tnode [shape=box];\n");
	printf("\tcompound=true;\n");
	root->print_dot();
	printf("}\n");
}

bbgraph *bbgraph::from_rreil_statements(struct rreil_statements *stmts, size_t address) {
	size_t counter = 0;

	function<tuple<shared_ptr<bbgraph_node>, shared_ptr<bbgraph_node>>(struct rreil_statements*)> connect_nodes =
			[&](struct rreil_statements *stmts) {
				shared_ptr<bbgraph_node> current;
				struct rreil_statements acc;
				auto next = [&]() {
					acc.statements_length = 0;
					acc.statements_size = stmts->statements_size;
					acc.statements = (struct rreil_statement**)malloc(sizeof(struct rreil_statement*)*acc.statements_size);
					printf("...\n");

					current = shared_ptr<bbgraph_node>(new bbgraph_node(new bbgraph_id(address, counter++), acc));
				};

				next();
				shared_ptr<bbgraph_node> me = current;

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

							current->add_child(then_start);
							current->add_child(else_start);

							next();

							then_end->add_child(current);
							else_end->add_child(current);
							break;
						}
						case RREIL_STATEMENT_TYPE_WHILE: {
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

	shared_ptr<bbgraph_node> root;
	tie(root, ignore) = connect_nodes(stmts);

	return new bbgraph(root);
}
