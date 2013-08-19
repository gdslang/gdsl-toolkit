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

class expression : public enable_shared_from_this<expression> {
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

	virtual uint64_t get_size() {
		return size;
	}

	string print();
	virtual string print_inner() = 0;

	virtual char contains(struct rreil_variable *variable) = 0;
	virtual bool substitute(struct rreil_variable *old, shared_ptr<expression> &new_) = 0;
	virtual char evaluate(uint64_t *result) = 0;
//	virtual void require_size(uint64_t size);
	virtual shared_ptr<expression> simplify() {
		return shared_from_this();
	}
	virtual bool is_dead() {
		return false;
	}
	virtual bool is_trivial() {
		return false;
	}

	static shared_ptr<expression> true_;
	static shared_ptr<expression> false_;
	static shared_ptr<expression> not_(shared_ptr<expression> other);

	static shared_ptr<expression> from_rreil_linear(struct rreil_linear *linear, uint64_t size);
	static shared_ptr<expression> from_rreil_op(struct rreil_op *op);
	static shared_ptr<expression> from_rreil_compare_op(struct rreil_comparator *cmp);
	static shared_ptr<expression> from_rreil_sexpr(struct rreil_sexpr *sexpr, uint64_t size);

	uint64_t size_get() {
		return size;
	}
};

#endif /* EXPRESSION_H_ */
