/*
 * unevalable.cpp
 *
 *  Created on: Aug 16, 2013
 *      Author: jucs
 */

#include <stdint.h>
#include <string>
#include "unevalable.h"

string unevalable::print_inner() {
	return "$unevalable";
}

char unevalable::contains(struct rreil_variable *variable) {
	return 0;
}

bool unevalable::substitute(struct rreil_variable *old, shared_ptr<expression>& new_) {
	return 0;
}

char unevalable::evaluate(uint64_t *result) {
	return 0;
}
