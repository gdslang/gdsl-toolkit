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
		struct rreil_variable *variable, struct data data) {
	if(bit_length)
		simulator_register_write(context, variable->id, data, variable->offset);
}

static void simulator_variable_read(struct context *context,
		struct rreil_variable *variable, size_t bit_length, uint8_t *buffer) {
	struct data data;
	data.data = buffer;
	data.bit_length = bit_length;

	simulator_register_read(context, variable->id, data, variable->offset);
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
					bit_length, (uint8_t*)&linear->scale.imm);
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

static void simulator_branch_simulate(struct context *context,
		struct rreil_address *target) {
	uint8_t *address = NULL;
	simulator_linear_simulate(context, &address, target->address, target->size);
	char equal = 1;
	for(size_t j = 0; j < target->size / 8; ++j) {
		if(context->x86_registers[X86_ID_IP].data[j] != address[j]) {
			equal = 0;
			break;
		}
	}
	if(!equal) {
		context->memory.jump(address, target->size);
		struct rreil_variable ip;
		struct rreil_id ip_id;
		ip_id.type = RREIL_ID_TYPE_X86;
		ip_id.x86 = X86_ID_IP;
		ip.id = &ip_id;
		ip.offset = 0;
		simulator_variable_write(context, &ip, target->size, address);
	}
	free(address);
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
			context->memory.load(&buffer, address, statement->load.address->size,
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
			context->memory.store(buffer, address, statement->store.address->size,
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
			uint8_t *buffer = NULL;
			/*
			 * Todo: Fix size
			 */
			simulator_sexpr_simulate(context, &buffer, statement->cbranch.cond, 1);
			if(*buffer & 0x01)
				simulator_branch_simulate(context, statement->cbranch.target_true);
			else
				simulator_branch_simulate(context, statement->cbranch.target_false);
			break;
		}
		case RREIL_STATEMENT_TYPE_BRANCH: {
			simulator_branch_simulate(context, statement->branch.target);
			break;
		}
	}
}

void simulator_statements_simulate(struct context *context,
		struct rreil_statements *statements) {
	for(size_t i = 0; i < statements->statements_length; ++i)
		simulator_statement_simulate(context, statements->statements[i]);
}
