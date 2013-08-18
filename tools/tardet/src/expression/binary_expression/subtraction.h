/*
 * subtraction.h
 *
 *  Created on: Aug 7, 2013
 *      Author: jucs
 */

#ifndef SUBTRACTION_H_
#define SUBTRACTION_H_

#include <stdint.h>
#include <string>
#include "binary_expression.h"

class subtraction: public binary_expression {
public:
	subtraction(shared_ptr<expression> left, shared_ptr<expression> right,
			uint64_t size) :
			binary_expression(left, right, size) {
	}
	uint64_t evaluate(uint64_t a, uint64_t b);
	expression *construct(shared_ptr<expression> left,
				shared_ptr<expression> right);
	string print_inner();
};

#endif /* SUBTRACTION_H_ */
