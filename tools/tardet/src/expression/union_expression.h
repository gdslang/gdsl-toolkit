/*
 * union_expression.h
 *
 *  Created on: Aug 10, 2013
 *      Author: jucs
 */

#ifndef UNION_EXPRESSION_H_
#define UNION_EXPRESSION_H_

#include <stdint.h>
#include <memory>
#include <vector>
#include <string>
#include "expression.h"

using namespace std;

class union_expression: public expression {
private:
	vector<shared_ptr<expression>> children;
public:
	union_expression(vector<shared_ptr<expression>> children, uint64_t size);
	union_expression(uint64_t size);
	virtual ~union_expression();

	void add(shared_ptr<expression> exp);

	string print_inner();

	char contains(struct rreil_variable *variable);
	bool substitute(struct rreil_variable *old, shared_ptr<expression> &new_);
	char evaluate(uint64_t *result);
	virtual shared_ptr<expression> simplify();
};
#endif /* UNION_EXPRESSION_H_ */

