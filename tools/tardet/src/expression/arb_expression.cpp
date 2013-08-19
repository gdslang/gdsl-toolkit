/*
 * arb_expression.cpp
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#include "arb_expression.h"

string arb_expression::print_inner() {
	return "$arbitrary";
}

char arb_expression::contains(struct rreil_variable *variable) {
	return 0;
}

bool arb_expression::substitute(struct rreil_variable *old, shared_ptr<expression>& new_) {
	return 0;
}

char arb_expression::evaluate(uint64_t *result) {
	return 0;
}
