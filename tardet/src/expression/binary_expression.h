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

class binary_expression: public expression {
protected:
	operand *left;
	operand *right;

	void print(char op);

public:
	binary_expression(operand *left, operand *right) {
		this->left = left;
		this->right = right;
	}
	virtual ~binary_expression() {
		delete left;
		delete right;
	}
};

class addition: public binary_expression {
public:
	addition(operand *left, operand *right) :
			binary_expression(left, right) {
	}
	void print();
};

class subtraction: public binary_expression {
public:
	subtraction(operand *left, operand *right) :
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
