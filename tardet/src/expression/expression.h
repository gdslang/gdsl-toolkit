/*
 * expression.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef EXPRESSION_H_
#define EXPRESSION_H_

#include <tr1/memory>
#include <stdlib.h>
extern "C" {
#include <rreil/rreil_linear.h>
}

using namespace std::tr1;

class expression {
private:
	uint64_t size;

public:
	void print();
	void print_size();
	virtual void print_inner() = 0;
	expression(uint64_t size) {
		this->size = size;
	}
	virtual ~expression() {
	}

	virtual char contains(struct rreil_variable *variable) = 0;
	virtual bool substitute(struct rreil_id *old,
			shared_ptr<expression> new_) = 0;

	static shared_ptr<expression> from_rreil_linear(struct rreil_linear* linear,
			uint64_t size);

	uint64_t size_get() {
		return size;
	}
};

#endif /* EXPRESSION_H_ */
