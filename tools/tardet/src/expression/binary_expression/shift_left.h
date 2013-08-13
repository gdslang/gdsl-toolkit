/*
 * shift_left.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef SHIFT_LEFT_H_
#define SHIFT_LEFT_H_

#include <stdint.h>
#include "binary_expression.h"

class shift_left: public binary_expression {
public:
	shift_left(shared_ptr<expression> left, shared_ptr<expression> right,
			uint64_t size) :
			binary_expression(left, right, size) {
	}
	uint64_t evaluate(uint64_t a, uint64_t b);
	expression *construct(shared_ptr<expression> left,
				shared_ptr<expression> right);
	void print_inner();
};

#endif /* SHIFT_LEFT_H_ */
