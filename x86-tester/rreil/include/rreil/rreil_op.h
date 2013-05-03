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

enum rreil_op_type {
	RREIL_OP_TYPE_LIN,
	RREIL_OP_TYPE_MUL,
	RREIL_OP_TYPE_DIV,
	RREIL_OP_TYPE_DIVS,
	RREIL_OP_TYPE_MOD,
	RREIL_OP_TYPE_SHL,
	RREIL_OP_TYPE_SHR,
	RREIL_OP_TYPE_SHRS,
	RREIL_OP_TYPE_AND,
	RREIL_OP_TYPE_OR,
	RREIL_OP_TYPE_XOR,
	RREIL_OP_TYPE_SX,
	RREIL_OP_TYPE_ZX,
	RREIL_OP_TYPE_CMP,
	RREIL_OP_TYPE_ARB
};

struct rreil_size_change {
	uint64_t size;
	uint64_t fromsize;
	struct rreil_linear *opnd1;
};

struct rreil_op {
	enum rreil_op_type type;
	union {
		struct rreil_arity1 lin;
		struct rreil_arity2 mul;
		struct rreil_arity2 div;
		struct rreil_arity2 divs;
		struct rreil_arity2 mod;
		struct rreil_arity2 shl;
		struct rreil_arity2 shr;
		struct rreil_arity2 shrs;
		struct rreil_arity2 and;
		struct rreil_arity2 or;
		struct rreil_arity2 xor;
		struct rreil_size_change sx;
		struct rreil_size_change zx;
		struct rreil_comparator cmp;
		struct {
			uint64_t size;
		} arb;
	};
};

#endif /* RREIL_OP_H_ */
