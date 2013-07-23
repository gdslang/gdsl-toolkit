/*
 * binary_expression.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef BINARY_EXPRESSION_H_
#define BINARY_EXPRESSION_H_

#include "expression.h"
#include "operand.h"

class binary_expression : public expression {
protected:
	expression *left;
	expression *right;

	void print(char op);

public:
	binary_expression(expression *left, expression *right) {
		this->left = left;
		this->right = right;
	}
	virtual ~binary_expression() {
		delete left;
		delete right;
	}
};

class addition : public binary_expression {
public:
	addition(expression *left, expression *right) :
			binary_expression(left, right) {
	}
	void print();
};

class subtraction : public binary_expression {
public:
	subtraction(expression *left, expression *right) :
			binary_expression(left, right) {
	}
	void print();
};

//class division : public binary_expression {
//
//};
//
//class multiplication : public binary_expression {
//
//};

#endif /* BINARY_EXPRESSION_H_ */
