/*
 * simulator_tracking.c
 *
 *  Created on: 11.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <rreil/rreil.h>
#include <simulator.h>
#include <simulator_regacc.h>
#include <simulator_tracking.h>

enum simulator_access_type {
	SIMULATOR_ACCESS_TYPE_READ, SIMULATOR_ACCESS_TYPE_WRITE
};

void rreil_variable_access(struct simulator_trace *trace,
		struct rreil_variable *variable, size_t bit_length,
		enum simulator_access_type *type) {
	if(variable->id->type != RREIL_ID_TYPE_X86)
		return;

	struct register_access *access;
	if(type == SIMULATOR_ACCESS_TYPE_READ)
		access = &trace->read;
	else
		access = &trace->written;

	uint8_t *data = (uint8_t*)malloc(bit_length / 8 + 1);
	for(size_t i = 0; i < bit_length / 8 + 1; ++i)
		data[i] = 0xff;

	simulator_register_generic_write(&access->x86_registers[variable->id], data,
			bit_length, variable->offset);
}

void rreil_linear_trace(struct simulator_trace *trace,
		struct rreil_linear *linear, size_t bit_length) {
	switch(linear->type) {
		case RREIL_LINEAR_TYPE_VARIABLE: {
			break;
		}
		case RREIL_LINEAR_TYPE_IMMEDIATE: {
			break;
		}
		case RREIL_LINEAR_TYPE_SUM: {
			break;
		}
		case RREIL_LINEAR_TYPE_DIFFERENCE: {
			break;
		}
		case RREIL_LINEAR_TYPE_SCALE: {
			break;
		}
	}
}

size_t rreil_comparator_trace(struct simulator_trace *trace,
		struct rreil_comparator *comparator) {
	switch(comparator->type) {
		case RREIL_COMPARATOR_TYPE_EQ: {
			break;
		}
		case RREIL_COMPARATOR_TYPE_NEQ: {
			break;
		}
		case RREIL_COMPARATOR_TYPE_LES: {
			break;
		}
		case RREIL_COMPARATOR_TYPE_LEU: {
			break;
		}
		case RREIL_COMPARATOR_TYPE_LTS: {
			break;
		}
		case RREIL_COMPARATOR_TYPE_LTU: {
			break;
		}
	}
}

void rreil_sexpr_trace(struct simulator_trace *trace, struct rreil_sexpr *sexpr,
		size_t bit_length) {
	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_LIN: {
			break;
		}
		case RREIL_SEXPR_TYPE_CMP: {
			break;
		}
	}
}

size_t rreil_op_trace(struct simulator_trace *trace, struct rreil_op *op) {
	switch(op->type) {
		case RREIL_OP_TYPE_LIN: {
			rreil_linear_trace(trace, op->lin.opnd1, op->lin.size);
			return op->lin.size;
		}
		case RREIL_OP_TYPE_MUL: {
			rreil_linear_trace(trace, op->mul.opnd1, op->mul.size);
			rreil_linear_trace(trace, op->mul.opnd2, op->mul.size);
			return op->mul.size;
		}
		case RREIL_OP_TYPE_DIV: {
			rreil_linear_trace(trace, op->div.opnd1, op->div.size);
			rreil_linear_trace(trace, op->div.opnd2, op->div.size);
			return op->div.size;
		}
		case RREIL_OP_TYPE_DIVS: {
			rreil_linear_trace(trace, op->divs.opnd1, op->divs.size);
			rreil_linear_trace(trace, op->divs.opnd2, op->divs.size);
			return op->divs.size;
		}
		case RREIL_OP_TYPE_MOD: {
			rreil_linear_trace(trace, op->mod.opnd1, op->mod.size);
			rreil_linear_trace(trace, op->mod.opnd2, op->mod.size);
			return op->mod.size;
		}
		case RREIL_OP_TYPE_SHL: {
			rreil_linear_trace(trace, op->shl.opnd1, op->shl.size);
			rreil_linear_trace(trace, op->shl.opnd2, op->shl.size);
			return op->shl.size;
		}
		case RREIL_OP_TYPE_SHR: {
			rreil_linear_trace(trace, op->shr.opnd1, op->shr.size);
			rreil_linear_trace(trace, op->shr.opnd2, op->shr.size);
			return op->shr.size;
		}
		case RREIL_OP_TYPE_SHRS: {
			rreil_linear_trace(trace, op->shrs.opnd1, op->shrs.size);
			rreil_linear_trace(trace, op->shrs.opnd2, op->shrs.size);
			return op->shrs.size;
		}
		case RREIL_OP_TYPE_AND: {
			rreil_linear_trace(trace, op->and.opnd1, op->and.size);
			rreil_linear_trace(trace, op->and.opnd2, op->and.size);
			return op->and.size;
		}
		case RREIL_OP_TYPE_OR: {
			rreil_linear_trace(trace, op->or.opnd1, op->or.size);
			rreil_linear_trace(trace, op->or.opnd2, op->or.size);
			return op->or.size;
		}
		case RREIL_OP_TYPE_XOR: {
			rreil_linear_trace(trace, op->xor.opnd1, op->xor.size);
			rreil_linear_trace(trace, op->xor.opnd2, op->xor.size);
			return op->xor.size;
		}
		case RREIL_OP_TYPE_SX: {
			rreil_linear_trace(trace, op->sx.opnd, op->sx.fromsize);
			return op->sx.size;
		}
		case RREIL_OP_TYPE_ZX: {
			rreil_linear_trace(trace, op->zx.opnd, op->zx.fromsize);
			return op->zx.size;
		}
		case RREIL_OP_TYPE_CMP: {
			return rreil_comparator_trace(trace, op->cmp);
		}
		case RREIL_OP_TYPE_ARB: {
			return op->arb.size;
		}
		default:
			return 0;
	}
}

void rreil_statement_trace(struct simulator_trace *trace,
		struct rreil_statement *statement) {
	switch(statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			size_t bits = rreil_op_trace(trace, statement->assign.rhs);
			rreil_variable_access(trace, statement->assign.lhs, bits,
					SIMULATOR_ACCESS_TYPE_WRITE);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			fprintf(stderr,
					"Simulator: Unable to trace RREIL_STATEMENT_TYPE_LOAD, not implemented.\n");
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			fprintf(stderr,
					"Simulator: Unable to trace RREIL_STATEMENT_TYPE_STORE, not implemented.\n");
			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {
			/*
			 * Todo: fix size
			 */
			rreil_sexpr_trace(trace, statement->ite.cond, 1);
			rreil_statements_trace(trace, statement->ite.then_branch);
			rreil_statements_trace(trace, statement->ite.else_branch);
			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {
			rreil_sexpr_trace(trace, statement->while_.cond, 1);
			rreil_statements_trace(trace, statement->while_.body);
			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {
			fprintf(stderr,
					"Simulator: Unable to track RREIL_STATEMENT_TYPE_CBRANCH, not implemented.\n");
			break;
		}
		case RREIL_STATEMENT_TYPE_BRANCH: {
			fprintf(stderr,
					"Simulator: Unable to track RREIL_STATEMENT_TYPE_BRANCH, not implemented.\n");
			break;
		}
	}
}

void rreil_statements_trace(struct simulator_trace *trace,
		struct rreil_statements *statements) {
	for(size_t i = 0; i < statements->statements_length; ++i)
		rreil_statement_track(trace, statements->statements[i]);
}

void simulator_register_access_register_add(struct register_access *access,
		enum rreil_id_x86 id) {
	if(access->indices_length >= access->indices_size) {
		access->indices_size = access->indices_size ? access->indices_size << 1 : 8;
		access->indices = (size_t*)realloc(access->indices,
				sizeof(size_t) * access->indices_size);
	}
	access->indices[access->indices_length++] = id;
}

struct simulator_trace *simulator_trace_init() {
	struct simulator_trace *trace = (struct simulator_trace*)malloc(
			sizeof(struct simulator_trace));

	void init_rw(struct register_access *access) {
		access->x86_registers = (struct register_)malloc(
				sizeof(struct register_) * RREIL_ID_X86_COUNT);
		access->indices = NULL;
		access->indices_length = 0;
		access->indices_size = 0;
	}

	init_rw(&trace->read);
	init_rw(trace->written);

	return trace;
}
