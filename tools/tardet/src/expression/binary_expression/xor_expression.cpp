
#include <stdint.h>
#include "xor_expression.h"

uint64_t xor_expression::evaluate(uint64_t a, uint64_t b) {
	return a ^ b;
}

expression *xor_expression::construct(shared_ptr<expression> left,
		shared_ptr<expression> right) {
	return new xor_expression(left, right, size_get());
}

void xor_expression::print_inner() {
	binary_expression::print_inner("^");
}

