/*
 * conditional.cpp
 *
 *  Created on: Aug 10, 2013
 *      Author: jucs
 */

#include <memory>
#include "expression.h"
#include "conditional_expression.h"

using namespace std;

conditional_expression::conditional_expression(shared_ptr<expression> condition, shared_ptr<expression> inner,
		uint64_t size) :
		expression(size) {
	this->condition = condition;
	this->inner = inner;
}

conditional_expression::~conditional_expression() {
	// TODO Auto-generated destructor stub
}

void conditional_expression::print_inner() {
	printf("if ");
	condition->print_inner();
	printf(" => ");
	inner->print_inner();
}

char conditional_expression::contains(struct rreil_variable *variable) {
	return condition->contains(variable) || inner->contains(variable);
}

bool conditional_expression::substitute(struct rreil_variable *old, shared_ptr<expression> &new_) {
	shared_ptr<expression> new_condition = new_;
	bool condition_substituted = condition->substitute(old, new_condition);
	if(!condition_substituted)
		new_condition = this->condition;
	shared_ptr<expression> new_inner = new_;
	bool inner_substituted = inner->substitute(old, new_inner);
	if(!inner_substituted)
		new_inner = this->inner;
	if(condition_substituted || inner_substituted) {
		new_ = shared_ptr<expression>(new conditional_expression(new_condition, new_inner, get_size()));
		return true;
	} else
		return false;
}

char conditional_expression::evaluate(uint64_t *result) {
	uint64_t cond_r;
	bool cond_eval = condition->evaluate(&cond_r);
	if(cond_eval && (cond_r & 1))
		return inner->evaluate(result);
	else
		return false;
}

shared_ptr<expression> conditional_expression::reduce() {
	uint64_t cond_r;
	bool cond_eval = condition->evaluate(&cond_r);
	if(cond_eval)
		if(cond_r)
			return inner;
		else
			return NULL;
	return shared_from_this();
}
