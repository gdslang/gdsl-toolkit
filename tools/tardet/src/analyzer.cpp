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
#include "expression/expressions.h"
#include "bbgraph/bbgraph.h"
#include "bbgraph/bbgraph_id.h"
#include "bbgraph/bbgraph_node.h"
#include "analyzer.h"

using namespace std;

static vector<struct analysis_result> initial(rreil_statement *last) {
	auto results = vector<struct analysis_result>();

	switch(last->type) {
		case RREIL_STATEMENT_TYPE_BRANCH: {
			shared_ptr<expression> exp = expression::from_rreil_linear(last->branch.target->address,
					last->branch.target->size);
			results.push_back( { conditional_expression::true_, exp });
			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {
			auto condition = expression::from_rreil_sexpr(last->cbranch.cond, 1 /* Todo: fix */);
			auto target_true = expression::from_rreil_linear(last->cbranch.target_true->address,
					last->cbranch.target_true->size);
			auto target_false = expression::from_rreil_linear(last->cbranch.target_false->address,
					last->cbranch.target_false->size);

			results.push_back( { condition, target_true });
			results.push_back( { conditional_expression::not_(condition), target_false });
		}
		default: {
			break; //handle error
		}
	}

	return results;
}

//void analyze(struct rreil_statements statements, vector<struct analysis_result> &results) {
//	for(size_t i = statements.statements_length; i > 0; --i) {
//		rreil_statement *current = statements.statements[i - 1];
//
////		root->print();
//
//		switch(current->type) {
//			case RREIL_STATEMENT_TYPE_ASSIGN: {
//				struct rreil_variable *lhs = current->assign.lhs;
//				shared_ptr<expression> new_ = expression::from_rreil_op(current->assign.rhs);
//
//				auto subst = [&](shared_ptr<expression> exp) {
//					if(exp->contains(lhs)) {
//						exp->print();
//						printf("\n");
//						fflush(stdout);
//
//						shared_ptr<expression> exp_subst = new_;
//						bool substituted = exp->substitute(current->assign.lhs, exp_subst);
//						if(substituted)
//						return exp_subst;
//					}
//					return exp;
//				};
//
//				for(size_t i = 0; i < results.size(); ++i) {
//					results[i].condition = subst(results[i].condition);
//					results[i].exp = subst(results[i].exp);
//				}
//				break;
//			}
//			default:
//				break;
//		}
//	}
//}

static shared_ptr<expression> analyze(struct rreil_statements statements, shared_ptr<expression> exp) {

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

vector<struct analysis_result> analyze(bbgraph *graph, shared_ptr<bbgraph_rrnode> sp) {
	auto analyze_one = [&](shared_ptr<expression> exp) {
		graph->reset_all();

		sp->set_expression(exp);

//	size_t count = 0;

			queue<shared_ptr<bbgraph_rrnode>> nodes = queue<shared_ptr<bbgraph_rrnode>>();
			nodes.push(sp);

			while(!nodes.empty()) {
				shared_ptr<bbgraph_rrnode> next = nodes.front();
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

//		printf("%zu\n", count++);

				exp->print();
				printf("\n");

				fflush(stdout);

				auto parents = next->get_parents();
				for(size_t i = 0; i < parents.size(); ++i) {
					shared_ptr<conditional_expression> exp_cond = shared_ptr<conditional_expression>(
							new conditional_expression(parents[i].condition, exp, exp->get_size()));
//			printf("cond:\n");
//			parents[i].condition->print();
//			printf("\n++\n");
//			shared_ptr<expression> reduced =
//			exp_cond->reduce((shared_ptr<expression>&)exp_cond);
//			if(exp_cond)
//				exp_new = exp_cond;
//			else
//				exp_new = exp;
					shared_ptr<expression> exp_new = exp_cond->reduce();
					if(!exp_new)
					exp_new = exp;

					/*
					 * Todo: Fix cast
					 */
					shared_ptr<bbgraph_rrnode> parent = parents[i].dst.lock();
					parent->add_expression(exp_new);
					nodes.push(parent);
				}

				next->mark();
			}

			return exp;
		};

	struct rreil_statements statements_sp = *sp->get_stmts();
	rreil_statement *last = statements_sp.statements[statements_sp.statements_length - 1];
//	shared_ptr<expression> exp = initial(last);
	auto analysis_results = initial(last);
//	if(!exp)
//		return NULL;
	for(size_t i = 0; i < analysis_results.size(); ++i) {
		analysis_results[i].condition = analyze_one(analysis_results[i].condition);
		analysis_results[i].exp = analyze_one(analysis_results[i].exp);
	}
}
