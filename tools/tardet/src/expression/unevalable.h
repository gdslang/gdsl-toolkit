/*
 * unevalable.h
 *
 *  Created on: Aug 16, 2013
 *      Author: jucs
 */

#ifndef UNEVALABLE_H_
#define UNEVALABLE_H_

#include <stdint.h>
#include <string>
#include "expression.h"

class unevalable : public expression {
public:
	unevalable() :
			expression(0) {
	}
	virtual ~unevalable() {
	}

	string print_inner();

	char contains(struct rreil_variable *variable);
	bool substitute(struct rreil_variable *old, shared_ptr<expression> &new_);
	char evaluate(uint64_t *result);

	virtual bool is_dead() {
		return true;
	}
};

#endif /* UNEVALABLE_H_ */
