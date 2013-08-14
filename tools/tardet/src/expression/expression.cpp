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

shared_ptr<expression> expression::true_ = shared_ptr<expression>(new immediate(1, 1));
shared_ptr<expression> expression::false_ = shared_ptr<expression>(new immediate(0, 1));

shared_ptr<expression> expression::not_(shared_ptr<expression> other) {
	return shared_ptr<expression>(new xor_expression(other, shared_ptr<expression>(new immediate(1, 1)), 1));
}

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
						exp = shared_ptr<expression>(new variable(*linear->variable->id, size, linear->variable->offset));
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

shared_ptr<expression> expression::from_rreil_compare_op(struct rreil_comparator *cmp) {
	compare_op *op;
	switch(cmp->type) {
		case RREIL_COMPARATOR_TYPE_EQ: {
			op = new compare_eq();
			break;
		}
		case RREIL_COMPARATOR_TYPE_NEQ: {
			op = new compare_neq();
			break;
		}
		case RREIL_COMPARATOR_TYPE_LES: {
			op = new compare_les();
			break;
		}
		case RREIL_COMPARATOR_TYPE_LEU: {
			op = new compare_leu();
			break;
		}
		case RREIL_COMPARATOR_TYPE_LTS: {
			op = new compare_lts();
			break;
		}
		case RREIL_COMPARATOR_TYPE_LTU: {
			op = new compare_ltu();
			break;
		}
	}
	return shared_ptr<expression>(
			new compare(from_rreil_linear(cmp->arity2.opnd1, cmp->arity2.size),
					from_rreil_linear(cmp->arity2.opnd2, cmp->arity2.size), cmp->arity2.size, shared_ptr<compare_op>(op)));

}

shared_ptr<expression> expression::from_rreil_op(struct rreil_op *op) {
	switch(op->type) {
		case RREIL_OP_TYPE_LIN: {
			return expression::from_rreil_linear(op->lin.opnd1, op->lin.size);
		}
		case RREIL_OP_TYPE_MUL: {
			return shared_ptr<expression>(
					new multiplication(from_rreil_linear(op->mul.opnd1, op->mul.size),
							from_rreil_linear(op->mul.opnd2, op->mul.size), op->mul.size));
		}
		case RREIL_OP_TYPE_ZX: {
			return shared_ptr<expression>(new zx_expression(from_rreil_linear(op->zx.opnd, op->zx.fromsize), op->zx.size));
		}
		case RREIL_OP_TYPE_SX: {
			return shared_ptr<expression>(new sx_expression(from_rreil_linear(op->zx.opnd, op->zx.fromsize), op->zx.size));
		}
		case RREIL_OP_TYPE_DIV: {
			return shared_ptr<expression>(
					new division_unsigned(from_rreil_linear(op->div.opnd1, op->div.size),
							from_rreil_linear(op->div.opnd2, op->div.size), op->div.size));
		}
		case RREIL_OP_TYPE_DIVS: {
			return shared_ptr<expression>(
					new division_signed(from_rreil_linear(op->divs.opnd1, op->divs.size),
							from_rreil_linear(op->divs.opnd2, op->divs.size), op->divs.size));
		}
		case RREIL_OP_TYPE_MOD: {
			return shared_ptr<expression>(
					new modulo(from_rreil_linear(op->mod.opnd1, op->mod.size), from_rreil_linear(op->mod.opnd2, op->mod.size),
							op->mod.size));
		}
		case RREIL_OP_TYPE_SHL: {
			return shared_ptr<expression>(
					new shift_left(from_rreil_linear(op->shl.opnd1, op->shl.size), from_rreil_linear(op->shl.opnd2, op->shl.size),
							op->shl.size));
		}
		case RREIL_OP_TYPE_SHR: {
			return shared_ptr<expression>(
					new shift_right(from_rreil_linear(op->shr.opnd1, op->shr.size),
							from_rreil_linear(op->shr.opnd2, op->shr.size), op->shr.size));
		}
		case RREIL_OP_TYPE_SHRS: {
			return shared_ptr<expression>(
					new shift_right_signed(from_rreil_linear(op->shrs.opnd1, op->shrs.size),
							from_rreil_linear(op->shrs.opnd2, op->shrs.size), op->shrs.size));
		}
		case RREIL_OP_TYPE_AND: {
			return shared_ptr<expression>(
					new and_expression(from_rreil_linear(op->and_.opnd1, op->and_.size),
							from_rreil_linear(op->and_.opnd2, op->and_.size), op->and_.size));
		}
		case RREIL_OP_TYPE_OR: {
			return shared_ptr<expression>(
					new or_expression(from_rreil_linear(op->or_.opnd1, op->or_.size),
							from_rreil_linear(op->or_.opnd2, op->or_.size), op->or_.size));
		}
		case RREIL_OP_TYPE_XOR: {
			return shared_ptr<expression>(
					new xor_expression(from_rreil_linear(op->xor_.opnd1, op->xor_.size),
							from_rreil_linear(op->xor_.opnd2, op->xor_.size), op->xor_.size));
		}
		case RREIL_OP_TYPE_CMP: {
			return from_rreil_compare_op(op->cmp);
		}
		case RREIL_OP_TYPE_ARB: {
			return shared_ptr<expression>(new arb_expression(op->arb.size));
		}
	}
	return shared_ptr<expression>();
}

shared_ptr<expression> expression::from_rreil_sexpr(struct rreil_sexpr *sexpr, uint64_t size) {
	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_CMP: {
			return from_rreil_compare_op(sexpr->cmp);
		}
		case RREIL_SEXPR_TYPE_LIN: {
			return from_rreil_linear(sexpr->lin, size);
		}
	}
}

//void expression::require_size(uint64_t size) {
//	if(size > this->size)
//		throw new string("Cannot grow expression!");
//	this->size = size;
//}
