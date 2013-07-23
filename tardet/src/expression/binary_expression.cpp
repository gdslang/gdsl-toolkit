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

void addition::print() {
	binary_expression::print('+');
}

void subtraction::print() {
	binary_expression::print('-');
}

