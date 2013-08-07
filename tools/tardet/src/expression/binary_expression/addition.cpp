/*
 * addition.cpp
 *
 *  Created on: Aug 7, 2013
 *      Author: jucs
 */

#include <stdint.h>
#include "addition.h"

uint64_t addition::evaluate(uint64_t a, uint64_t b) {
	return a + b;
}

expression *addition::construct(shared_ptr<expression> left,
		shared_ptr<expression> right) {
	return new addition(left, right, size_get());
}

void addition::print_inner() {
	binary_expression::print_inner('+');
}

