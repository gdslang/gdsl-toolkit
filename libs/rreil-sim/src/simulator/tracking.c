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
#include <simulator/simulator.h>
#include <simulator/regacc.h>
#include <simulator/tracking.h>
#include <util.h>
#include <x86.h>

enum simulator_access_type {
	SIMULATOR_ACCESS_TYPE_READ, SIMULATOR_ACCESS_TYPE_WRITE, SIMULATOR_ACCESS_TYPE_DEREFERENCE
};

static void tracking_variable_access_trace(struct tracking_trace *trace, struct rreil_variable *variable,
		size_t bit_length, enum simulator_access_type type) {
	if(variable->id->type != RREIL_ID_TYPE_X86)
		return;

	{
		struct rreil_variable new_;
		struct rreil_id new_id;
		new_id.type = RREIL_ID_TYPE_X86;
		new_id.x86 = X86_ID_FLAGS;
		new_.id = &new_id;

		switch(variable->id->x86) {
			case X86_ID_VIRT_LEU: {
				new_.offset = X86_FLAGS_CARRY;
				tracking_variable_access_trace(trace, &new_, 1, type);
				new_.offset = X86_FLAGS_ZERO;
				tracking_variable_access_trace(trace, &new_, 1, type);
				return;
			}
			case X86_ID_VIRT_LES: {
				new_.offset = X86_FLAGS_ZERO;
				tracking_variable_access_trace(trace, &new_, 1, type);
			}
			case X86_ID_VIRT_LTS: {
				new_.offset = X86_FLAGS_SIGN;
				tracking_variable_access_trace(trace, &new_, 1, type);
				new_.offset = X86_FLAGS_OVERFLOW;
				tracking_variable_access_trace(trace, &new_, 1, type);
				return;
			}
			default:
				break;
		}
	}

	struct register_access *access;
	switch(type) {
		case SIMULATOR_ACCESS_TYPE_READ: {
			access = &trace->reg.read;
			break;
		}
		case SIMULATOR_ACCESS_TYPE_WRITE: {
			access = &trace->reg.written;
			break;
		}
		case SIMULATOR_ACCESS_TYPE_DEREFERENCE: {
			access = &trace->reg.dereferenced;
			break;
		}
	}

	uint8_t *buffer = (uint8_t*)malloc(bit_length / 8 + 1);
	for(size_t i = 0; i < bit_length / 8 + 1; ++i)
		buffer[i] = 0xff;

	struct data data;
	data.data = buffer;
	data.bit_length = bit_length;
	context_data_define(&data);

//	printf("+++\n");
//	rreil_id_print(stdout, variable->id);
//	printf("\n+++\n");
	fflush(stdout);
	simulator_register_generic_write(&access->x86_registers[variable->id->x86], data, variable->offset);

	context_data_clear(&data);

	size_t index = variable->id->x86;
	char found = 0;
	for(size_t i = 0; i < access->x86_indices_length; ++i)
		if(access->x86_indices[i] == index) {
			found = 1;
			break;
		}
	if(!found)
		util_array_generic_add((void**)&access->x86_indices, &index, sizeof(index), &access->x86_indices_length,
				&access->x86_indices_size);
}

//static void tracking_variable_define(struct tracking_trace *trace,
//		struct rreil_variable *variable, uint8_t *mask, size_t bit_length) {
//
//}

static void tracking_linear_trace(struct tracking_trace *trace, enum simulator_access_type access_type,
		struct rreil_linear *linear, size_t bit_length) {
//	void linear_trace(struct rreil_linear *linear, size_t bit_length) {
//		tracking_linear_trace(trace, access_type, linear, bit_length);
//	}

	switch(linear->type) {
		case RREIL_LINEAR_TYPE_VARIABLE: {
			tracking_variable_access_trace(trace, linear->variable, bit_length, access_type);
			break;
		}
		case RREIL_LINEAR_TYPE_IMMEDIATE: {
			break;
		}
		case RREIL_LINEAR_TYPE_SUM: {
			tracking_linear_trace(trace, access_type, linear->sum.opnd1, bit_length);
			tracking_linear_trace(trace, access_type, linear->sum.opnd2, bit_length);
			break;
		}
		case RREIL_LINEAR_TYPE_DIFFERENCE: {
			tracking_linear_trace(trace, access_type, linear->difference.opnd1, bit_length);
			tracking_linear_trace(trace, access_type, linear->difference.opnd2, bit_length);
			break;
		}
		case RREIL_LINEAR_TYPE_SCALE: {
			tracking_linear_trace(trace, access_type, linear->scale.opnd, bit_length);
			break;
		}
	}
}

static size_t tracking_comparator_trace(struct tracking_trace *trace, struct rreil_comparator *comparator) {
	tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, comparator->arity2.opnd1, comparator->arity2.size);
	tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, comparator->arity2.opnd2, comparator->arity2.size);
	return 1;
}

static void tracking_sexpr_trace(struct tracking_trace *trace, struct rreil_sexpr *sexpr, size_t bit_length) {
	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_LIN: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, sexpr->lin, bit_length);
			break;
		}
		case RREIL_SEXPR_TYPE_CMP: {
			tracking_comparator_trace(trace, sexpr->cmp);
			break;
		}
		case RREIL_SEXPR_TYPE_ARB: {
			break;
		}
	}
}

static size_t tracking_expr_trace(struct tracking_trace *trace, struct rreil_expr *expr) {
//	void linear_trace(struct rreil_linear *linear, size_t bit_length) {
//		tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, linear,
//				bit_length);
//	}

	switch(expr->type) {
		case RREIL_EXPR_TYPE_SEXPR: {
			tracking_sexpr_trace(trace, expr->sexpr.opnd1, expr->sexpr.size);
			return expr->sexpr.size;
		}
		case RREIL_EXPR_TYPE_MUL: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->mul.opnd1, expr->mul.size);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->mul.opnd2, expr->mul.size);
			return expr->mul.size;
		}
		case RREIL_EXPR_TYPE_DIV: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->div.opnd1, expr->div.size);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->div.opnd2, expr->div.size);
			return expr->div.size;
		}
		case RREIL_EXPR_TYPE_DIVS: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->divs.opnd1, expr->divs.size);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->divs.opnd2, expr->divs.size);
			return expr->divs.size;
		}
		case RREIL_EXPR_TYPE_MOD: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->mod.opnd1, expr->mod.size);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->mod.opnd2, expr->mod.size);
			return expr->mod.size;
		}
		case RREIL_EXPR_TYPE_SHL: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->shl.opnd1, expr->shl.size);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->shl.opnd2, expr->shl.size);
			return expr->shl.size;
		}
		case RREIL_EXPR_TYPE_SHR: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->shr.opnd1, expr->shr.size);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->shr.opnd2, expr->shr.size);
			return expr->shr.size;
		}
		case RREIL_EXPR_TYPE_SHRS: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->shrs.opnd1, expr->shrs.size);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->shrs.opnd2, expr->shrs.size);
			return expr->shrs.size;
		}
		case RREIL_EXPR_TYPE_AND: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->and_.opnd1, expr->and_.size);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->and_.opnd2, expr->and_.size);
			return expr->and_.size;
		}
		case RREIL_EXPR_TYPE_OR: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->or_.opnd1, expr->or_.size);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->or_.opnd2, expr->or_.size);
			return expr->or_.size;
		}
		case RREIL_EXPR_TYPE_XOR: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->xor_.opnd1, expr->xor_.size);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->xor_.opnd2, expr->xor_.size);
			return expr->xor_.size;
		}
		case RREIL_EXPR_TYPE_SX: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->sx.opnd, expr->sx.fromsize);
			return expr->sx.size;
		}
		case RREIL_EXPR_TYPE_ZX: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_READ, expr->zx.opnd, expr->zx.fromsize);
			return expr->zx.size;
		}
		default:
			return 0;
	}
}

static void tracking_branch_trace(struct tracking_trace *trace, struct rreil_address *target) {

	tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_DEREFERENCE, target->address, target->size);
	struct rreil_variable ip;
	struct rreil_id ip_id;
	ip_id.type = RREIL_ID_TYPE_X86;
	ip_id.x86 = X86_ID_IP;
	ip.id = &ip_id;
	ip.offset = 0;
	tracking_variable_access_trace(trace, &ip, target->size, SIMULATOR_ACCESS_TYPE_WRITE);
}

static void tracking_statement_trace(struct tracking_trace *trace, struct rreil_statement *statement) {
	switch(statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			size_t bits = tracking_expr_trace(trace, statement->assign.rhs);
			tracking_variable_access_trace(trace, statement->assign.lhs, bits, SIMULATOR_ACCESS_TYPE_WRITE);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_DEREFERENCE, statement->load.address->address,
					statement->load.address->size);
			tracking_variable_access_trace(trace, statement->load.lhs, statement->load.size, SIMULATOR_ACCESS_TYPE_WRITE);
			trace->mem.used = 1;
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			tracking_expr_trace(trace, statement->store.rhs);
			tracking_linear_trace(trace, SIMULATOR_ACCESS_TYPE_DEREFERENCE, statement->store.address->address,
					statement->store.address->size);
			trace->mem.used = 1;
			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {
			/*
			 * Todo: fix size
			 */
			tracking_sexpr_trace(trace, statement->ite.cond, 1);
			tracking_statements_trace(trace, statement->ite.then_branch);
			tracking_statements_trace(trace, statement->ite.else_branch);
			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {
			tracking_sexpr_trace(trace, statement->while_.cond, 1);
			tracking_statements_trace(trace, statement->while_.body);
			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {
			tracking_sexpr_trace(trace, statement->cbranch.cond, 1);
			tracking_branch_trace(trace, statement->cbranch.target_true);
			tracking_branch_trace(trace, statement->cbranch.target_false);
			trace->mem.used = 1;
			break;
		}
		case RREIL_STATEMENT_TYPE_BRANCH: {
			tracking_branch_trace(trace, statement->branch.target);
			trace->mem.used = 1;
			break;
		}
		/*
		 * Todo: Primitives, Floating point operations
		 */
	}
}

void tracking_statements_trace(struct tracking_trace *trace, struct rreil_statements *statements) {
	for(size_t i = 0; i < statements->statements_length; ++i)
		tracking_statement_trace(trace, statements->statements[i]);
}

//void simulator_register_access_register_add(struct register_access *access,
//		enum rreil_id_x86 id) {
//	if(access->indices_length >= access->indices_size) {
//		access->indices_size = access->indices_size ? access->indices_size << 1 : 8;
//		access->indices = (size_t*)realloc(access->indices,
//				sizeof(size_t) * access->indices_size);
//	}
//	access->indices[access->indices_length++] = id;
//}

static void init_register(struct register_access *access, enum x86_id x86) {
	size_t size = x86_amd64_sizeof(x86);
	struct register_ *reg = &access->x86_registers[x86];
	reg->data = (uint8_t*)calloc(size / 8 + (size % 8 > 0), 1);
	reg->defined = (uint8_t*)calloc(size / 8 + (size % 8 > 0), 1);
	reg->bit_length = size;
//			reg->data_size = size / 8;
}

static void init_rw(struct register_access *access) {
	access->x86_registers = (struct register_*)calloc(X86_ID_COUNT, sizeof(struct register_));

	for(size_t i = 0; i < X86_ID_COUNT; ++i)
		init_register(access, (enum x86_id)i);

	access->x86_indices = NULL;
	access->x86_indices_length = 0;
	access->x86_indices_size = 0;
}

struct tracking_trace *tracking_trace_init() {
	struct tracking_trace *trace = (struct tracking_trace*)malloc(sizeof(struct tracking_trace));

	init_rw(&trace->reg.read);
	init_rw(&trace->reg.written);
	init_rw(&trace->reg.dereferenced);

	trace->mem.written.accesses = NULL;
	trace->mem.written.accesses_length = 0;
	trace->mem.written.accesses_size = 0;

	trace->mem.used = 0;

//	trace->defined.x86_registers = (struct register_*)calloc(X86_ID_COUNT,
//			sizeof(struct register_));
//	for(size_t i = 0; i < X86_ID_COUNT; ++i) {
//		enum x86_id x86_id = (enum x86_id)i;
//		size_t size = x86_amd64_sizeof(x86_id);
//		struct register_ *reg = &trace->defined.x86_registers[i];
//
//		reg->data = (uint8_t*)malloc(size / 8);
//		for(size_t i = 0; i < size / 8; ++i)
//			reg->data[i] = 0xff;
//		reg->data_bit_length = size;
//	}
//	trace->defined.virtual_registers = (struct register_*)calloc(
//			RREIL_ID_VIRTUAL_COUNT, sizeof(struct register_));
//	trace->defined.temporary_registers = (struct register_*)calloc(
//			RREIL_ID_TEMPORARY_COUNT, sizeof(struct register_));

	return trace;
}

static void registers_free(struct register_ *registers, size_t length) {
	for(size_t i = 0; i < length; ++i) {
		struct register_ *reg = &registers[i];
		free(reg->data);
		free(reg->defined);
	}
}

static void access_clear(struct register_access *access) {
	registers_free(access->x86_registers, X86_ID_COUNT);
	free(access->x86_indices);
	free(access->x86_registers);
}

void tracking_trace_free(struct tracking_trace *trace) {
	access_clear(&trace->reg.read);
	access_clear(&trace->reg.written);
	access_clear(&trace->reg.dereferenced);

//	registers_free(trace->defined.x86_registers, X86_ID_COUNT);
//	registers_free(trace->defined.virtual_registers, RREIL_ID_VIRTUAL_COUNT);
//	registers_free(trace->defined.temporary_registers, RREIL_ID_TEMPORARY_COUNT);

	free(trace->mem.written.accesses);

	free(trace);
}

void tracking_trace_memory_write_add(struct tracking_trace *trace, struct memory_access access) {
	util_array_generic_add((void**)&trace->mem.written.accesses, &access, sizeof(access),
			&trace->mem.written.accesses_length, &trace->mem.written.accesses_size);
}

static void access_print(struct register_access *access) {
	for(size_t i = 0; i < access->x86_indices_length; ++i) {
		enum x86_id id_x86 = (enum x86_id)access->x86_indices[i];
		struct register_ *reg = &access->x86_registers[id_x86];

		printf("Register ");
		x86_id_print(stdout, id_x86);
		printf(": ");

		size_t rest = 0;
		size_t reg_size = x86_amd64_sizeof(id_x86);
		if(reg_size > reg->bit_length)
			rest = reg_size - reg->bit_length;
		for(size_t i = 0; i < rest / 8; ++i)
			printf("00");
		if(reg->bit_length) {
			if(reg->bit_length % 8) {
				uint8_t top = reg->data[reg->bit_length / 8];
				uint8_t mask = (1 << (reg->bit_length % 8)) - 1;
				printf("%02x", (top & mask));
			}
			for(size_t i = reg->bit_length / 8; i > 0; --i)
				printf("%02x", reg->data[i - 1]);
		}
		printf("\n");
	}
}

void tracking_trace_print(struct tracking_trace *trace) {
	printf("Read registers:\n");
	access_print(&trace->reg.read);
	printf("Written registers:\n");
	access_print(&trace->reg.written);
	printf("Dereferenced registers:\n");
	access_print(&trace->reg.dereferenced);
}
