
#include <stdint.h>
#include <string>
#include "and_expression.h"

uint64_t and_expression::evaluate(uint64_t a, uint64_t b) {
	return a & b;
}

expression *and_expression::construct(shared_ptr<expression> left,
		shared_ptr<expression> right) {
	return new and_expression(left, right, size_get());
}

string and_expression::print_inner() {
	return binary_expression::print_inner("&");
}

