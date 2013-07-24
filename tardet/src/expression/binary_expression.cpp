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

void binary_expression::print(char op) {
	left->print();
	printf(" %c ", op);
	right->print();
}

char binary_expression::contains(rreil_variable *variable) {
	return left->contains(variable) || right->contains(variable);
}

void addition::print() {
	binary_expression::print('+');
	expression::print();
}

void subtraction::print() {
	binary_expression::print('-');
	expression::print();
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

