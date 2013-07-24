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
private:
	uint64_t size;

public:
	virtual void print();
	expression(uint64_t size) {
		this->size = size;
	}
	virtual ~expression() {
	}

	virtual char contains(struct rreil_variable *variable) = 0;

	static expression *from_rreil_linear(struct rreil_linear* linear,
			uint64_t size);

	uint64_t size_get() {
		return size;
	}
};

#endif /* EXPRESSION_H_ */
