/*
 * multiplication.cpp
 *
 *  Created on: Aug 7, 2013
 *      Author: jucs
 */

#include "multiplication.h"

multiplication::multiplication(shared_ptr<expression> left,
		shared_ptr<expression> right, uint64_t size) :
		binary_expression(left, right, size) {
}

multiplication::~multiplication() {
	// TODO Auto-generated destructor stub
}

uint64_t multiplication::evaluate(uint64_t a, uint64_t b) {
	return a * b;
}

expression *multiplication::construct(shared_ptr<expression> left,
		shared_ptr<expression> right) {
	return new multiplication(left, right, size_get());
}

void multiplication::print_inner() {
	binary_expression::print_inner('*');
}
