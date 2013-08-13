/*
 * analyzer.cpp
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#include <memory>
#include <stdlib.h>
#include <stdio.h>
#include <queue>
#include <vector>
extern "C" {
#include <rreil/rreil.h>
}
#include "expression/expression.h"
#include "bbgraph/bbgraph.h"
#include "bbgraph/bbgraph_id.h"
#include "bbgraph/bbgraph_node.h"

using namespace std;

static shared_ptr<expression> initial(rreil_statement *last) {
	shared_ptr<expression> exp = NULL;

	switch(last->type) {
		case RREIL_STATEMENT_TYPE_BRANCH: {
			exp = expression::from_rreil_linear(last->branch.target->address, last->branch.target->size);
			break;
		}
//		case RREIL_STATEMENT_TYPE_CBRANCH: {
//			shared_ptr<class expression> exp = expression::from_rreil_linear(last->cbranch.target->address);
//			root = new itree(exp, 0, last->cbranch.target->size - 1);
//			break;
//		}
		default: {
			break; //handle error
		}
	}

	return exp;
}

shared_ptr<expression> analyze(struct rreil_statements statements, shared_ptr<expression> exp) {

	for(size_t i = statements.statements_length; i > 0; --i) {
		rreil_statement *current = statements.statements[i - 1];

//		root->print();

		switch(current->type) {
			case RREIL_STATEMENT_TYPE_ASSIGN: {
				struct rreil_variable *lhs = current->assign.lhs;

				if(exp->contains(lhs)) {
					exp->print();
					printf("\n");
					fflush(stdout);

					shared_ptr<expression> new_ = expression::from_rreil_op(current->assign.rhs);
					bool substituted = exp->substitute(current->assign.lhs, new_);
					if(substituted)
						exp = new_;
				}
				break;
			}
			default:
				break;
		}
	}

	return exp;
}

shared_ptr<expression> analyze(bbgraph *graph, shared_ptr<bbgraph_node> sp) {
	graph->unmark_all();

	queue<shared_ptr<bbgraph_node>> nodes = queue<shared_ptr<bbgraph_node>>();
	nodes.push(sp);

	struct rreil_statements statements_sp = *sp->get_stmts();
	rreil_statement *last = statements_sp.statements[statements_sp.statements_length - 1];
	shared_ptr<expression> exp = initial(last);
	if(!exp)
		return NULL;
	sp->add_expression(exp);

	size_t count = 0;

	while(!nodes.empty()) {
		shared_ptr<bbgraph_node> next = nodes.front();
		nodes.pop();

		if(next->is_marked())
			continue;

		auto children = next->get_children();

		bool _continue = false;
		for (size_t i = 0; i < children.size(); ++i) {
			shared_ptr<bbgraph_node> child = children[i].dst.lock();
			if(!child->is_marked()) {
				_continue = true;
				break;
			}
		}
		if(_continue)
			continue;

		exp = analyze(*next->get_stmts(), next->get_uexp());

		printf("%zu\n", count++);

		exp->print();
		printf("\n");

		fflush(stdout);

		auto parents = next->get_parents();
		for(size_t i = 0; i < parents.size(); ++i) {
			shared_ptr<expression> exp_new;

			shared_ptr<conditional_expression> exp_cond = shared_ptr<conditional_expression>(
					new conditional_expression(parents[i].condition, exp, exp->get_size()));
//			printf("cond:\n");
//			parents[i].condition->print();
//			printf("\n++\n");
//			shared_ptr<expression> reduced =
			exp_cond->reduce((shared_ptr<expression>&)exp_cond);
			if(exp_cond)
				exp_new = exp_cond;
			else
				exp_new = exp;

			shared_ptr<bbgraph_node> parent = parents[i].dst.lock();
			parent->add_expression(exp_new);
			nodes.push(parent);
		}

		next->mark();
	}

	return exp;
}
