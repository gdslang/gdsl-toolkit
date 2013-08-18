/*
 * arb_expression.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef ARB_EXPRESSION_H_
#define ARB_EXPRESSION_H_

#include <stdint.h>
#include "expression.h"

class arb_expression : public expression {
public:
	arb_expression(uint64_t size) :
			expression(size) {
	}
	virtual ~arb_expression() {
	}

	string print_inner();

	char contains(struct rreil_variable *variable);
	bool substitute(struct rreil_variable *old, shared_ptr<expression> &new_);
	char evaluate(uint64_t *result);
};

#endif /* ARB_EXPRESSION_H_ */

