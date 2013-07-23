/*
 * expression.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef EXPRESSION_H_
#define EXPRESSION_H_

extern "C" {
#include <rreil/rreil_linear.h>
}

class expression {
public:
	virtual void print() = 0;
	virtual ~expression() {
	}

	static expression *from_rreil_linear(struct rreil_linear* linear);
};

#endif /* EXPRESSION_H_ */
