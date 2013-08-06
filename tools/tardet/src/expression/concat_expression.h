/*
 * concat_expression.h
 *
 *  Created on: Aug 6, 2013
 *      Author: jucs
 */

#ifndef CONCAT_EXPRESSION_H_
#define CONCAT_EXPRESSION_H_

#include <vector>
#include <memory>
#include "expression.h"

using namespace std;

struct concat_element {
	shared_ptr<class expression> expression;
	size_t size;
};

class concat_expression: public expression {
private:
	vector<struct concat_element> elements;

public:
	concat_expression(vector<struct concat_element> elements, size_t size);
	virtual ~concat_expression();

	void print_inner();

	virtual char contains(struct rreil_variable *variable);
	virtual bool substitute(struct rreil_variable *old,
			shared_ptr<expression> &new_);
	virtual char evaluate(uint64_t *result);
};
#endif /* CONCAT_EXPRESSION_H_ */

