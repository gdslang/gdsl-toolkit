
#include <stdint.h>
#include <string>
#include "subtraction.h"

uint64_t subtraction::evaluate(uint64_t a, uint64_t b) {
	return a - b;
}

string subtraction::print_inner() {
	return binary_expression::print_inner("-");
}

expression *subtraction::construct(shared_ptr<expression> left,
		shared_ptr<expression> right) {
	return new subtraction(left, right, size_get());
}
