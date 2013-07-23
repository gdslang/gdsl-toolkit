/*
 * binary_expression.cpp
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include "binary_expression.h"

void binary_expression::print(char op) {
	left->print();
	printf(" %c ", op);
	right->print();
}

char binary_expression::contains(rreil_variable *variable, size_t size) {
	return left->contains(variable, size) || right->contains(variable, size);
}

void addition::print() {
	binary_expression::print('+');
}

void subtraction::print() {
	binary_expression::print('-');
}

