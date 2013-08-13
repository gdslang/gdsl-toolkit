
#include <stdint.h>
#include "or_expression.h"

uint64_t or_expression::evaluate(uint64_t a, uint64_t b) {
	return a | b;
}

expression *or_expression::construct(shared_ptr<expression> left,
		shared_ptr<expression> right) {
	return new or_expression(left, right, size_get());
}

void or_expression::print_inner() {
	binary_expression::print_inner("|");
}

