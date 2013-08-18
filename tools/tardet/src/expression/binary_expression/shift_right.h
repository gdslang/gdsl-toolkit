
#ifndef SHIFT_RIGHT_H_
#define SHIFT_RIGHT_H_

#include <stdint.h>
#include <string>
#include "binary_expression.h"

class shift_right: public binary_expression {
public:
	shift_right(shared_ptr<expression> left, shared_ptr<expression> right,
			uint64_t size) :
			binary_expression(left, right, size) {
	}
	uint64_t evaluate(uint64_t a, uint64_t b);
	expression *construct(shared_ptr<expression> left,
				shared_ptr<expression> right);
	string print_inner();
//	void require_size(uint64_t size) {
//	}
};

#endif /* SHIFT_RIGHT_H_ */
