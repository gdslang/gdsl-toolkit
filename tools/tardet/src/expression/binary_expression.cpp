/*
 * binary_expression.cpp
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#include <tr1/memory>
#include <stdlib.h>
#include <stdio.h>
#include "binary_expression.h"

using namespace std::tr1;

void binary_expression::print_inner(char op) {
	printf("(");
	left->print_inner();
	printf(" %c ", op);
	right->print_inner();
	printf(")");
}

char binary_expression::contains(rreil_variable *variable) {
	return left->contains(variable) || right->contains(variable);
}

bool binary_expression::substitute(struct rreil_id *old,
		shared_ptr<expression> new_) {
	bool new_left = left->substitute(old, new_);
	if(new_left)
		left = new_;
	bool new_right = right->substitute(old, new_);
	if(new_right)
		right = new_;
	return 0;
}

char binary_expression::evaluate(uint64_t *result) {
	uint64_t left_result;
	char evalable = left->evaluate(&left_result);
	if(!evalable)
		return 0;
	uint64_t right_result;
	evalable = right->evaluate(&right_result);
	if(!evalable)
		return 0;
	*result = evaluate(left_result, right_result);
	return 1;
}

uint64_t addition::evaluate(uint64_t a, uint64_t b) {
	return a + b;
}

void addition::print_inner() {
	binary_expression::print_inner('+');
}

uint64_t subtraction::evaluate(uint64_t a, uint64_t b) {
	return a - b;
}

void subtraction::print_inner() {
	binary_expression::print_inner('-');
}
