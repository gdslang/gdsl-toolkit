
#ifndef DIVISION_SIGNED_H_
#define DIVISION_SIGNED_H_

#include <stdint.h>
#include "binary_expression.h"

class division_signed: public binary_expression {
public:
	division_signed(shared_ptr<expression> left, shared_ptr<expression> right,
			uint64_t size) :
			binary_expression(left, right, size) {
	}
	uint64_t evaluate(uint64_t a, uint64_t b);
	expression *construct(shared_ptr<expression> left,
				shared_ptr<expression> right);
	void print_inner();
//	void require_size(uint64_t size) {
//	}
};

#endif /* DIVISION_SIGNED_H_ */
