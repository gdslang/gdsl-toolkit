/*
 * expression.cpp
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <functional>
#include <memory>
#include "expression.h"
extern "C" {
#include <rreil/rreil.h>
}

#include "binary_expression.h"
#include "operand.h"

using namespace std;

void expression::print() {
	print_inner();
	print_size();
}

void expression::print_size() {
	printf(":%lu", size);
}

shared_ptr<expression> expression::from_rreil_linear(
		struct rreil_linear* linear, uint64_t size) {
	function<shared_ptr<expression>(struct rreil_linear*)> handle_linear =
			[&](struct rreil_linear *linear) {
				shared_ptr<expression> exp;
				switch(linear->type) {
					case RREIL_LINEAR_TYPE_VARIABLE: {
						exp = shared_ptr<expression>(new variable(linear->variable->id, size, linear->variable->offset));
						break;
					}
					case RREIL_LINEAR_TYPE_IMMEDIATE: {
						exp = shared_ptr<expression>(new immediate(linear->immediate, size));
						break;
					}
					case RREIL_LINEAR_TYPE_SUM: {
						exp = shared_ptr<expression>(new addition(handle_linear(linear->sum.opnd1), handle_linear(linear->sum.opnd2), size));
						break;
					}
					case RREIL_LINEAR_TYPE_DIFFERENCE: {
						exp = shared_ptr<expression>(new subtraction(handle_linear(linear->sum.opnd1), handle_linear(linear->sum.opnd2), size));
					}
					case RREIL_LINEAR_TYPE_SCALE: {
						printf("Scale :-(...\n");
						break;
					}
				}
				return exp;
			};
	return handle_linear(linear);
}

shared_ptr<expression> expression::from_rreil_op(struct rreil_op *op) {
	switch(op->type) {
		case RREIL_OP_TYPE_LIN: {
			return expression::from_rreil_linear(op->lin.opnd1, op->lin.size);
		}
	}
	return shared_ptr<expression>();
}
