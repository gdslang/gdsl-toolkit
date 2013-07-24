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
		left.swap(new_);
	bool new_right = right->substitute(old, new_);
	if(new_right)
		right.swap(new_);
	return 0;
}

void addition::print_inner() {
	binary_expression::print_inner('+');
}

void subtraction::print_inner() {
	binary_expression::print_inner('-');
}
