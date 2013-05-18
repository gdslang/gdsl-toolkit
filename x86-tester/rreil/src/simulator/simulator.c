/*
 * simulator.c
 *
 *  Created on: 07.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <rreil/rreil.h>
#include <simulator/simulator.h>
#include <simulator/regacc.h>
#include <simulator/ops.h>
#include <simulator/tools.h>
#include <x86.h>
#include <util.h>

static void simulator_variable_write(struct context *context,
		struct rreil_variable *variable, size_t bit_length, uint8_t *buffer) {
	if(bit_length)
		simulator_register_write(context, variable->id, buffer, bit_length,
				variable->offset);
}

static void simulator_variable_read(struct context *context,
		struct rreil_variable *variable, size_t bit_length, uint8_t *buffer) {
	simulator_register_read(context, variable->id, buffer, bit_length,
			variable->offset);
}

static struct memory_allocation *simulator_allocation_get(
		struct context *context, void *ptr) {
	struct memory_allocation *allocation = NULL;
	for(size_t i = 0; i < context->memory.allocations_length; ++i)
		if(ptr >= context->memory.allocations[i].address
				&& ptr
						<= context->memory.allocations[i].address
								+ context->memory.allocations[i].data_size) {
			allocation = &context->memory.allocations[i];
			break;
		}
	if(!allocation) {
		if(context->memory.allocations_length + 1
				> context->memory.allocations_size) {
			context->memory.allocations_size =
					context->memory.allocations_size ? context->memory.allocations_size
							<< 1 :
							8;
			context->memory.allocations = (struct memory_allocation*)realloc(
					context->memory.allocations,
					context->memory.allocations_size * sizeof(struct memory_allocation));
		}
		allocation =
				&context->memory.allocations[context->memory.allocations_length++];
		allocation->address = ptr;
		allocation->data = NULL;
		allocation->data_size = 0;
	}
	return allocation;
}

static void *simulator_ptr_get(uint8_t *address, uint64_t address_size) {
	void *ptr = NULL;
	for(size_t i = 0; i < sizeof(ptr) && i < address_size / 8; ++i) {
		uint8_t *ptr_u8 = (uint8_t*)&ptr;
		ptr_u8[i] = address[i];
	}
	return ptr;
}

static void simulator_allocation_resize(struct memory_allocation *allocation,
		uint64_t access_size, void *ptr) {
	size_t diff = (size_t)(ptr - allocation->address);
	if(diff + access_size / 8 > allocation->data_size) {
		allocation->data_size = diff + access_size / 8;
		allocation->data = (uint8_t*)realloc(allocation->data,
				allocation->data_size);
	}
}

static void simulator_load(struct context *context, uint8_t **buffer,
		uint8_t *address, uint64_t address_size, uint64_t access_size) {
	void *ptr = simulator_ptr_get(address, address_size);
	struct memory_allocation *allocation = simulator_allocation_get(context, ptr);

	size_t old_size = allocation->data_size;
	simulator_allocation_resize(allocation, access_size, ptr);

	size_t diff = (size_t)(ptr - allocation->address);
	*buffer = &allocation->data[diff];
	for(size_t i = 0; i < allocation->data_size - old_size; ++i)
		allocation->data[old_size + i] = context->memory.byte_read(
				allocation->address + old_size + i);
}

static void simulator_store(struct context *context, uint8_t *buffer,
		uint8_t *address, uint64_t address_size, uint64_t access_size) {
	void *ptr = simulator_ptr_get(address, address_size);
	struct memory_allocation *allocation = simulator_allocation_get(context, ptr);

	simulator_allocation_resize(allocation, access_size, ptr);

	size_t diff = (size_t)(ptr - allocation->address);
	uint8_t *to = &allocation->data[diff];

	memcpy(to, buffer, access_size / 8);
}

static void simulator_linear_simulate(struct context *context, uint8_t **buffer,
		struct rreil_linear *linear, size_t bit_length) {
	switch(linear->type) {
		case RREIL_LINEAR_TYPE_VARIABLE: {
			*buffer = (uint8_t*)malloc(bit_length / 8 + 1);
			simulator_variable_read(context, linear->variable, bit_length, *buffer);
			break;
		}
		case RREIL_LINEAR_TYPE_IMMEDIATE: {
			*buffer = simulator_op_sx(sizeof(linear->immediate) * 8, bit_length,
					(uint8_t*)&linear->immediate);
//			memcpy(buffer, result, bit_length / 8 + (bit_length % 8 > 0));
//			free(result);
			break;
		}
		case RREIL_LINEAR_TYPE_SUM: {
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, linear->sum.opnd1, bit_length);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, linear->sum.opnd2, bit_length);
			*buffer = simulator_op_add(opnd1, opnd2, bit_length);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_DIFFERENCE: {
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, linear->difference.opnd1,
					bit_length);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, linear->difference.opnd2,
					bit_length);
			*buffer = simulator_op_sub(opnd1, opnd2, bit_length);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_SCALE: {
			uint8_t *opnd;
			simulator_linear_simulate(context, &opnd, linear->scale.opnd, bit_length);
			uint8_t *scale = simulator_op_sx(sizeof(linear->scale.imm) * 8,
					bit_length, (uint8_t*)linear->scale.imm);
			*buffer = simulator_op_mul(scale, opnd, bit_length);
			free(opnd);
			break;
		}
	}
}

static size_t simulator_comparator_simulate(struct context *context,
		uint8_t **buffer, struct rreil_comparator *comparator) {
	uint64_t size = comparator->arity2.size;
	uint8_t *opnd1;
	simulator_linear_simulate(context, &opnd1, comparator->arity2.opnd1, size);
	uint8_t *opnd2;
	simulator_linear_simulate(context, &opnd2, comparator->arity2.opnd2, size);
	switch(comparator->type) {
		case RREIL_COMPARATOR_TYPE_EQ: {
			*buffer = (uint8_t*)malloc(1);
			**buffer = simulator_op_cmp_eq(opnd1, opnd2, size);
			break;
		}
		case RREIL_COMPARATOR_TYPE_NEQ: {
			*buffer = (uint8_t*)malloc(1);
			**buffer = simulator_op_cmp_neq(opnd1, opnd2, size);
			break;
		}
		case RREIL_COMPARATOR_TYPE_LES: {
			*buffer = (uint8_t*)malloc(1);
			**buffer = simulator_op_cmp_les(opnd1, opnd2, size);
			break;
		}
		case RREIL_COMPARATOR_TYPE_LEU: {
			*buffer = (uint8_t*)malloc(1);
			**buffer = simulator_op_cmp_leu(opnd1, opnd2, size);
			break;
		}
		case RREIL_COMPARATOR_TYPE_LTS: {
			*buffer = (uint8_t*)malloc(1);
			**buffer = simulator_op_cmp_lts(opnd1, opnd2, size);
			break;
		}
		case RREIL_COMPARATOR_TYPE_LTU: {
			*buffer = (uint8_t*)malloc(1);
			**buffer = simulator_op_cmp_ltu(opnd1, opnd2, size);
			break;
		}
	}
	free(opnd1);
	free(opnd2);
	return 1;
}

static void simulator_sexpr_simulate(struct context *context, uint8_t **buffer,
		struct rreil_sexpr *sexpr, size_t bit_length) {
	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_LIN: {
			simulator_linear_simulate(context, buffer, sexpr->lin, bit_length);
			break;
		}
		case RREIL_SEXPR_TYPE_CMP: {
			simulator_comparator_simulate(context, buffer, sexpr->cmp);
			break;
		}
	}
}

static size_t simulator_op_simulate(struct context *context, uint8_t **buffer,
		struct rreil_op *op) {
	size_t size;
	switch(op->type) {
		case RREIL_OP_TYPE_LIN: {
			size = op->lin.size;
			simulator_linear_simulate(context, buffer, op->lin.opnd1, size);
			break;
		}
		case RREIL_OP_TYPE_MUL: {
			size = op->mul.size;
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, op->mul.opnd1, size);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, op->mul.opnd2, size);
			*buffer = simulator_op_mul(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_DIV: {
			size = op->div.size;
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, op->div.opnd1, size);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, op->div.opnd2, size);
			*buffer = simulator_op_div(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_DIVS: {
			size = op->divs.size;
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, op->divs.opnd1, size);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, op->divs.opnd2, size);
			*buffer = simulator_op_divs(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_MOD: {
			size = op->mod.size;
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, op->mod.opnd1, size);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, op->mod.opnd2, size);
			*buffer = simulator_op_mod(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_SHL: {
			size = op->shl.size;
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, op->shl.opnd1, size);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, op->shl.opnd2, size);
			*buffer = simulator_op_shl(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_SHR: {
			size = op->shr.size;
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, op->shr.opnd1, size);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, op->shr.opnd2, size);
			*buffer = simulator_op_shr(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_SHRS: {
			size = op->shrs.size;
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, op->shrs.opnd1, size);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, op->shrs.opnd2, size);
			*buffer = simulator_op_shrs(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_AND: {
			size = op->and.size;
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, op->and.opnd1, size);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, op->and.opnd2, size);
			*buffer = simulator_op_and(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_OR: {
			size = op->or.size;
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, op->or.opnd1, size);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, op->or.opnd2, size);
			*buffer = simulator_op_or(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_XOR: {
			size = op->xor.size;
			uint8_t *opnd1;
			simulator_linear_simulate(context, &opnd1, op->xor.opnd1, size);
			uint8_t *opnd2;
			simulator_linear_simulate(context, &opnd2, op->xor.opnd2, size);
			*buffer = simulator_op_xor(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_SX: {
			size = op->sx.size;
			uint8_t *opnd;
			simulator_linear_simulate(context, &opnd, op->sx.opnd, size);
			*buffer = simulator_op_sx(op->sx.fromsize, size, opnd);
			free(opnd);
			break;
		}
		case RREIL_OP_TYPE_ZX: {
			size = op->zx.size;
			uint8_t *opnd;
			simulator_linear_simulate(context, &opnd, op->zx.opnd, size);
			*buffer = simulator_op_zx(op->zx.fromsize, size, opnd);
			free(opnd);
			break;
		}
		case RREIL_OP_TYPE_CMP: {
			size = simulator_comparator_simulate(context, buffer, op->cmp);
			break;
		}
		case RREIL_OP_TYPE_ARB: {
//			size = op->arb.size;
//			*buffer = (uint8_t*)malloc(size / 8 + 1);
//			for(size_t i = 0; i <= size / 8; ++i)
//				(*buffer)[i] = (uint8_t)rand();
			size = 0;
			break;
		}
	}
	return size;
}

static void simulator_statement_simulate(struct context *context,
		struct rreil_statement *statement) {
	switch(statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			uint8_t *buffer = NULL;
			size_t bit_length = simulator_op_simulate(context, &buffer,
					statement->assign.rhs);
			simulator_variable_write(context, statement->assign.lhs, bit_length,
					buffer);
			free(buffer);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			uint8_t *address = NULL;
			simulator_linear_simulate(context, &address,
					statement->load.address->address, statement->load.address->size);
			uint8_t *buffer = NULL;
			simulator_load(context, &buffer, address, statement->load.address->size,
					statement->load.size);
			free(address);
			simulator_variable_write(context, statement->load.lhs,
					statement->load.size, buffer);
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			uint8_t *buffer = NULL;
			size_t bit_length = simulator_op_simulate(context, &buffer,
					statement->store.rhs);
			uint8_t *address = NULL;
			simulator_linear_simulate(context, &address,
					statement->store.address->address, statement->store.address->size);
			simulator_store(context, buffer, address, statement->store.address->size,
					bit_length);
			free(address);
			free(buffer);
			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {
			uint8_t *buffer = NULL;
			/*
			 * Todo: Fix size
			 */
			simulator_sexpr_simulate(context, &buffer, statement->ite.cond, 1);
			if(*buffer & 0x01)
				simulator_statements_simulate(context, statement->ite.then_branch);
			else
				simulator_statements_simulate(context, statement->ite.else_branch);

			free(buffer);

			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {
			uint8_t *buffer = NULL;
			/*
			 * Todo: Fix size
			 */
			simulator_sexpr_simulate(context, &buffer, statement->while_.cond, 1);
			while(*buffer & 0x01) {
				simulator_statements_simulate(context, statement->while_.body);
				free(buffer);
				simulator_sexpr_simulate(context, &buffer, statement->while_.cond, 1);
			}
			free(buffer);
			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {
			fprintf(stderr,
					"Simulator: Unable to simulate RREIL_STATEMENT_TYPE_CBRANCH, not implemented.\n");
			break;
		}
		case RREIL_STATEMENT_TYPE_BRANCH: {
			fprintf(stderr,
					"Simulator: Unable to simulate RREIL_STATEMENT_TYPE_BRANCH, not implemented.\n");
			break;
		}
	}
}

void simulator_statements_simulate(struct context *context,
		struct rreil_statements *statements) {
	for(size_t i = 0; i < statements->statements_length; ++i)
		simulator_statement_simulate(context, statements->statements[i]);
}
