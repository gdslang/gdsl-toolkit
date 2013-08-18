/*
 * addition.h
 *
 *  Created on: Aug 7, 2013
 *      Author: jucs
 */

#ifndef ADDITION_H_
#define ADDITION_H_

#include <string.h>
#include <stdint.h>
#include "binary_expression.h"

class addition: public binary_expression {
public:
	addition(shared_ptr<expression> left, shared_ptr<expression> right,
			uint64_t size) :
			binary_expression(left, right, size) {
	}
	uint64_t evaluate(uint64_t a, uint64_t b);
	expression *construct(shared_ptr<expression> left,
				shared_ptr<expression> right);
	string print_inner();
};

#endif /* ADDITION_H_ */
