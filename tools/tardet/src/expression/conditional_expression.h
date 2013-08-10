/*
 * conditional_expression.h
 *
 *  Created on: Aug 10, 2013
 *      Author: jucs
 */

#ifndef CONDITIONAL_EXPRESSION_H_
#define CONDITIONAL_EXPRESSION_H_

#include <memory>
#include "expression.h"

using namespace std;

class conditional_expression: public expression {
private:
	shared_ptr<expression> condition;
	shared_ptr<expression> inner;

public:
	conditional_expression(shared_ptr<expression> condition, shared_ptr<expression> inner, uint64_t size);
	virtual ~conditional_expression();

	void print_inner();

	char contains(struct rreil_variable *variable);
	bool substitute(struct rreil_variable *old, shared_ptr<expression> &new_);
	char evaluate(uint64_t *result);
};
#endif /* CONDITIONAL_EXPRESSION_H_ */

