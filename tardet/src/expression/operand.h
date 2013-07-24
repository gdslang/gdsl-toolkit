/*
 * operand.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef OPERAND_H_
#define OPERAND_H_

#include <stdint.h>
extern "C" {
#include <rreil/rreil.h>
}
#include "expression.h"

class variable: public expression {
private:
	struct rreil_variable *variable_;

public:
	variable(struct rreil_variable *variable, uint64_t size);
	~variable() {
	}
	void print();
	char contains(struct rreil_variable *variable);
	bool substitute(struct rreil_id *old, shared_ptr<expression> new_);
};

class immediate: public expression {
private:
	uint64_t immediate_;

public:
	immediate(uint64_t immediate, uint64_t size);
	~immediate() {
	}
	void print();

	char contains(struct rreil_variable *variable) {
		return 0;
	}
	bool substitute(struct rreil_id *old, shared_ptr<expression> new_) {
		return 0;
	}
};

#endif /* OPERAND_H_ */
