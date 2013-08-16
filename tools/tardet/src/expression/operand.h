/*
 * operand.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef OPERAND_H_
#define OPERAND_H_

#include <memory>
#include <stdint.h>
extern "C" {
#include <rreil/rreil.h>
}
#include "expression.h"

using namespace std;

class variable: public expression {
private:
	struct rreil_id id;
	uint64_t offset;

public:
	variable(struct rreil_id id, uint64_t offset, uint64_t size);
	~variable() {
	}
	void print_inner();
	char contains(struct rreil_variable *variable);
	bool substitute(struct rreil_variable *old, shared_ptr<expression> &new_);
	char evaluate(uint64_t *result) {
		return 0;
	}
};

class immediate: public expression {
private:
	uint64_t immediate_;

public:
	immediate(uint64_t immediate, uint64_t size);
	~immediate() {
	}
	void print_inner();

	char contains(struct rreil_variable *variable) {
		return 0;
	}
	bool substitute(struct rreil_variable *old, shared_ptr<expression> &new_) {
		return 0;
	}
	char evaluate(uint64_t *result) {
		*result = immediate_;
		return 1;
	}
	virtual bool is_trivial() {
		return true;
	}
};

#endif /* OPERAND_H_ */
