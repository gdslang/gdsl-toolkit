/*
 * multiplication.h
 *
 *  Created on: Aug 7, 2013
 *      Author: jucs
 */

#ifndef MULTIPLICATION_H_
#define MULTIPLICATION_H_

#include <stdint.h>
#include "binary_expression.h"

class multiplication: public binary_expression {
public:
	multiplication(shared_ptr<expression> left, shared_ptr<expression> right,
			uint64_t size);
	virtual ~multiplication();
	uint64_t evaluate(uint64_t a, uint64_t b);
	expression *construct(shared_ptr<expression> left,
				shared_ptr<expression> right);
	void print_inner();
};
#endif /* MULTIPLICATION_H_ */

