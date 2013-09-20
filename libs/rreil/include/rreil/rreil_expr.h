/*
 * rreil_op.h
 *
 *  Created on: 03.05.2013
 *      Author: jucs
 */

#ifndef RREIL_OP_H_
#define RREIL_OP_H_

#include <stdint.h>
#include <stdlib.h>
#include <rreil/rreil_arity.h>
#include <rreil/rreil_comparator.h>

enum rreil_expr_type {
	RREIL_EXPR_TYPE_SEXPR,
	RREIL_EXPR_TYPE_MUL,
	RREIL_EXPR_TYPE_DIV,
	RREIL_EXPR_TYPE_DIVS,
	RREIL_EXPR_TYPE_MOD,
	RREIL_EXPR_TYPE_SHL,
	RREIL_EXPR_TYPE_SHR,
	RREIL_EXPR_TYPE_SHRS,
	RREIL_EXPR_TYPE_AND,
	RREIL_EXPR_TYPE_OR,
	RREIL_EXPR_TYPE_XOR,
	RREIL_EXPR_TYPE_SX,
	RREIL_EXPR_TYPE_ZX,
	RREIL_EXPR_TYPE_ARB
};

struct rreil_size_change {
	uint64_t size;
	uint64_t fromsize;
	struct rreil_linear *opnd;
};

struct rreil_expr {
	enum rreil_expr_type type;
	union {
		struct rreil_arity1_sexpr sexpr;
		struct rreil_arity2 mul;
		struct rreil_arity2 div;
		struct rreil_arity2 divs;
		struct rreil_arity2 mod;
		struct rreil_arity2 shl;
		struct rreil_arity2 shr;
		struct rreil_arity2 shrs;
		struct rreil_arity2 and_;
		struct rreil_arity2 or_;
		struct rreil_arity2 xor_;
		struct rreil_size_change sx;
		struct rreil_size_change zx;
		struct {
			uint64_t size;
		} arb;
	};
};

#endif /* RREIL_OP_H_ */
