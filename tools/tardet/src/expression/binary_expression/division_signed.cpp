
#include <stdint.h>
#include "division_signed.h"

uint64_t division_signed::evaluate(uint64_t a, uint64_t b) {
	return (uint64_t)(((int64_t)a) / ((int64_t)b));
}

expression *division_signed::construct(shared_ptr<expression> left,
		shared_ptr<expression> right) {
	return new division_signed(left, right, size_get());
}

void division_signed::print_inner() {
	binary_expression::print_inner("/s");
}

