
#include <stdint.h>
#include "shift_right.h"
extern "C" {
#include <context.h>
#include <simulator/ops.h>
}

uint64_t shift_right::evaluate(uint64_t a, uint64_t b) {
	uint64_t defined = 0;

	struct data a_data;
	a_data.data = (uint8_t*)&a;
	a_data.defined = (uint8_t*)&defined;
	a_data.bit_length = get_size();

	struct data b_data;
	b_data.data = (uint8_t*)&b;
	b_data.defined = (uint8_t*)&defined;
	b_data.bit_length = get_size();

	struct data result_data = simulator_op_shr(a_data, b_data);

	uint64_t result;

	result = *((uint64_t*)result_data.data);
	free(result_data.data);
	free(result_data.defined);

	return result;
}

expression *shift_right::construct(shared_ptr<expression> left,
		shared_ptr<expression> right) {
	return new shift_right(left, right, size_get());
}

void shift_right::print_inner() {
	binary_expression::print_inner(">>u");
}
