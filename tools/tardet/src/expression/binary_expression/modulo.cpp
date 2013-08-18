
#include <stdint.h>
#include <string>
#include "modulo.h"

uint64_t modulo::evaluate(uint64_t a, uint64_t b) {
	return a % b;
}

expression *modulo::construct(shared_ptr<expression> left,
		shared_ptr<expression> right) {
	return new modulo(left, right, size_get());
}

string modulo::print_inner() {
	return binary_expression::print_inner("%");
}
