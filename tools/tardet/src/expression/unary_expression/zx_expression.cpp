/*
 * zx_expression.cpp
 *
 *  Created on: Aug 7, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string>
#include "../../util.hpp"
#include "zx_expression.h"

zx_expression::zx_expression(shared_ptr<expression> operand, size_t to_size) :
		expression(to_size) {
	this->operand = operand;
}

zx_expression::~zx_expression() {
	// TODO Auto-generated destructor stub
}

char zx_expression::contains(struct rreil_variable *variable) {
	return operand->contains(variable);
}

bool zx_expression::substitute(struct rreil_variable *old, shared_ptr<expression> &new_) {
	if(operand->substitute(old, new_)) {
		new_ = shared_ptr<expression>(new zx_expression(new_, get_size()));
		return true;
	}
}

char zx_expression::evaluate(uint64_t *result) {
	*result = 0;
	return operand->evaluate(result);
}

string zx_expression::print_inner() {
	return string_format("([%lu->u%lu] %s", operand->get_size(), get_size(), operand->print_inner().c_str());
}
