/*
 * conditional.cpp
 *
 *  Created on: Aug 10, 2013
 *      Author: jucs
 */

#include <stdint.h>
#include <memory>
#include <string>
#include "../util.hpp"
#include "expression.h"
#include "expressions.h"
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

string conditional_expression::print_inner() {
	return string_format("if %s => %s", condition->print_inner().c_str(), inner->print_inner().c_str());
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

shared_ptr<expression> conditional_expression::simplify() {
	uint64_t cond_r;
	bool cond_eval = condition->evaluate(&cond_r);
	if(cond_eval)
		if(cond_r & 1)
			return inner->simplify();
		else
			return make_shared<unevalable>();
	condition = condition->simplify();
	inner = inner->simplify();
	return shared_from_this();
}
