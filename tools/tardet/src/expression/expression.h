/*
 * expression.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef EXPRESSION_H_
#define EXPRESSION_H_

#include <memory>
#include <string>
#include <stdint.h>
#include <stdlib.h>
extern "C" {
#include <rreil/rreil_linear.h>
}

using namespace std;

class expression {
private:
	uint64_t size;

public:
	expression(uint64_t size) {
		if(size > 64)
			throw new string("Maximum size is 64 :-(.");
		this->size = size;
	}
	virtual ~expression() {
	}

	uint64_t get_size() {
		return size;
	}

	void print();
	void print_size();
	virtual void print_inner() = 0;

	virtual char contains(struct rreil_variable *variable) = 0;
	virtual bool substitute(struct rreil_variable *old,
			shared_ptr<expression> &new_) = 0;
	virtual char evaluate(uint64_t *result) = 0;

	static shared_ptr<expression> from_rreil_linear(struct rreil_linear *linear,
			uint64_t size);
	static shared_ptr<expression> from_rreil_op(struct rreil_op *op);

	uint64_t size_get() {
		return size;
	}
};

#endif /* EXPRESSION_H_ */
