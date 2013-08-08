/*
 * zx_expression.h
 *
 *  Created on: Aug 7, 2013
 *      Author: jucs
 */

#ifndef SX_EXPRESSION_H_
#define SX_EXPRESSION_H_

#include "../expression.h"

class sx_expression: public expression {
private:
	shared_ptr<expression> operand;

public:
	sx_expression(shared_ptr<expression> operand, size_t to_size);
	virtual ~sx_expression();

	char contains(struct rreil_variable *variable);
	bool substitute(struct rreil_variable *old,
				shared_ptr<expression> &new_);
	char evaluate(uint64_t *result);
	void print_inner();
};
#endif /* SX_EXPRESSION_H_ */

