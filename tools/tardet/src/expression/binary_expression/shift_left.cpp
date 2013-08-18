/*
 * shift_left.cpp
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#include <stdint.h>
#include <string>
#include "shift_left.h"
extern "C" {
#include <context.h>
#include <simulator/ops.h>
}

uint64_t shift_left::evaluate(uint64_t a, uint64_t b) {
	uint64_t defined = 0;

	struct data a_data;
	a_data.data = (uint8_t*)&a;
	a_data.defined = (uint8_t*)&defined;
	a_data.bit_length = get_size();

	struct data b_data;
	b_data.data = (uint8_t*)&b;
	b_data.defined = (uint8_t*)&defined;
	b_data.bit_length = get_size();

	struct data result_data = simulator_op_shl(a_data, b_data);

	uint64_t result;

	result = *((uint64_t*)result_data.data);
	free(result_data.data);
	free(result_data.defined);

	return result;
}

expression *shift_left::construct(shared_ptr<expression> left,
		shared_ptr<expression> right) {
	return new shift_left(left, right, size_get());
}

string shift_left::print_inner() {
	return binary_expression::print_inner("<<");
}
