
#ifndef OR_EXPRESSION_H_
#define OR_EXPRESSION_H_

#include <stdint.h>
#include "binary_expression.h"

class or_expression: public binary_expression {
public:
	or_expression(shared_ptr<expression> left, shared_ptr<expression> right,
			uint64_t size) :
			binary_expression(left, right, size) {
	}
	uint64_t evaluate(uint64_t a, uint64_t b);
	expression *construct(shared_ptr<expression> left,
				shared_ptr<expression> right);
	void print_inner();
};

#endif /* OR_EXPRESSION_H_ */
