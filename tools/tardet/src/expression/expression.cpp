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
extern "C" {
#include <rreil/rreil.h>
}
#include "expression.h"
#include "expressions.h"

using namespace std;

void expression::print() {
	print_inner();
	print_size();
}

void expression::print_size() {
	printf(":%lu", size);
}

shared_ptr<expression> expression::from_rreil_linear(struct rreil_linear* linear, uint64_t size) {
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
						exp = shared_ptr<expression>(new multiplication(shared_ptr<expression>(new immediate(linear->scale.imm, size)), handle_linear(linear->scale.opnd), size));
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
		case RREIL_OP_TYPE_MUL: {
			return shared_ptr<expression>(
					new multiplication(from_rreil_linear(op->mul.opnd1, op->mul.size),
							from_rreil_linear(op->mul.opnd1, op->mul.size), op->mul.size));
		}
		case RREIL_OP_TYPE_ZX: {
			return shared_ptr<expression>(new zx_expression(from_rreil_linear(op->zx.opnd, op->zx.fromsize), op->zx.size));
		}
		case RREIL_OP_TYPE_SX: {
			return shared_ptr<expression>(new sx_expression(from_rreil_linear(op->zx.opnd, op->zx.fromsize), op->zx.size));
		}
	}
	return shared_ptr<expression>();
}
