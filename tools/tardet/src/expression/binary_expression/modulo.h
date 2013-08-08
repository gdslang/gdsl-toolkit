
#ifndef MODULO_H_
#define MODULO_H_

#include <stdint.h>
#include "binary_expression.h"

class modulo: public binary_expression {
public:
	modulo(shared_ptr<expression> left, shared_ptr<expression> right,
			uint64_t size) :
			binary_expression(left, right, size) {
	}
	uint64_t evaluate(uint64_t a, uint64_t b);
	expression *construct(shared_ptr<expression> left,
				shared_ptr<expression> right);
	void print_inner();
};

#endif /* MODULO_H_ */
