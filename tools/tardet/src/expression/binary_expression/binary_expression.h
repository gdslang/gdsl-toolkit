/*
 * binary_expression.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef BINARY_EXPRESSION_H_
#define BINARY_EXPRESSION_H_

#include <string>
#include <memory>
#include "../expression.h"
#include "../operand.h"

using namespace std;

class binary_expression: public expression {
protected:
	shared_ptr<expression> left;
	shared_ptr<expression> right;

	void print_inner(string op);
public:
	binary_expression(shared_ptr<expression> left, shared_ptr<expression> right,
			uint64_t size) :
			expression(size) {
		this->left = left;
		this->right = right;
	}
	virtual ~binary_expression() {
	}
	char contains(rreil_variable *variable);
	bool substitute(struct rreil_variable *old, shared_ptr<expression> &new_);
	char evaluate(uint64_t *result);
	virtual uint64_t evaluate(uint64_t a, uint64_t b) = 0;
	virtual expression *construct(shared_ptr<expression> left,
			shared_ptr<expression> right) = 0;
};

//class division : public binary_expression {
//
//};
//
//class multiplication : public binary_expression {
//
//};

#endif /* BINARY_EXPRESSION_H_ */
