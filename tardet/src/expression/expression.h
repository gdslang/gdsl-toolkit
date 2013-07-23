/*
 * expression.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef EXPRESSION_H_
#define EXPRESSION_H_

#include <stdlib.h>
extern "C" {
#include <rreil/rreil_linear.h>
}

class expression {
public:
	virtual void print() = 0;
	virtual ~expression() {
	}

	virtual char contains(rreil_variable *variable, size_t size) = 0;

	static expression *from_rreil_linear(struct rreil_linear* linear);
};

#endif /* EXPRESSION_H_ */
