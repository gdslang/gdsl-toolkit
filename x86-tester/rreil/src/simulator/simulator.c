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
	if(data.bit_length)
		simulator_register_write(context, variable->id, data, variable->offset);
}

static void simulator_variable_read(struct context *context,
		struct rreil_variable *variable, struct data data) {
	simulator_register_read(context, variable->id, data, variable->offset);
}

static struct data simulator_linear_simulate(struct context *context,
		struct rreil_linear *linear, size_t bit_length) {
	struct data result;
	switch(linear->type) {
		case RREIL_LINEAR_TYPE_VARIABLE: {
			result.data = (uint8_t*)malloc(bit_length / 8 + 1);
			result.defined = (uint8_t*)malloc(bit_length / 8 + 1);
			result.bit_length = bit_length;
			simulator_variable_read(context, linear->variable, result);
			break;
		}
		case RREIL_LINEAR_TYPE_IMMEDIATE: {
			struct data opnd;
			opnd.bit_length = sizeof(linear->immediate) * 8;
			opnd.data = (uint8_t*)&linear->immediate;
			context_data_define(&opnd);
			result = simulator_op_sx(bit_length, opnd);
			free(opnd.defined);
//			memcpy(buffer, result, bit_length / 8 + (bit_length % 8 > 0));
//			free(result);
			break;
		}
		case RREIL_LINEAR_TYPE_SUM: {
			struct data opnd1 = simulator_linear_simulate(context, linear->sum.opnd1,
					bit_length);
			struct data opnd2 = simulator_linear_simulate(context, linear->sum.opnd2,
					bit_length);
			result = simulator_op_add(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_DIFFERENCE: {
			struct data opnd1 = simulator_linear_simulate(context,
					linear->difference.opnd1, bit_length);
			struct data opnd2 = simulator_linear_simulate(context,
					linear->difference.opnd2, bit_length);
			result = simulator_op_sub(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_SCALE: {
			struct data opnd = simulator_linear_simulate(context, linear->scale.opnd,
					bit_length);

			struct data scale;
			scale.bit_length = sizeof(linear->scale.imm) * 8;
			scale.data = (uint8_t*)&linear->scale.imm;
			context_data_define(&scale);
			struct data scale_sx = simulator_op_sx(bit_length, scale);

			result = simulator_op_mul(scale_sx, opnd);

			context_data_clear(&opnd);
			free(scale.defined);
			context_data_clear(&scale_sx);

			break;
		}
	}
	return result;
}

static struct data simulator_comparator_simulate(struct context *context,
		struct rreil_comparator *comparator) {
	uint64_t size = comparator->arity2.size;
	struct data opnd1 = simulator_linear_simulate(context,
			comparator->arity2.opnd1, size);
	struct data opnd2 = simulator_linear_simulate(context,
			comparator->arity2.opnd2, size);

	struct data data;
	switch(comparator->type) {
		case RREIL_COMPARATOR_TYPE_EQ: {
			data = simulator_op_cmp_eq(opnd1, opnd2);
			break;
		}
		case RREIL_COMPARATOR_TYPE_NEQ: {
			data = simulator_op_cmp_neq(opnd1, opnd2);
			break;
		}
		case RREIL_COMPARATOR_TYPE_LES: {
			data = simulator_op_cmp_les(opnd1, opnd2);
			break;
		}
		case RREIL_COMPARATOR_TYPE_LEU: {
			data = simulator_op_cmp_leu(opnd1, opnd2);
			break;
		}
		case RREIL_COMPARATOR_TYPE_LTS: {
			data = simulator_op_cmp_lts(opnd1, opnd2);
			break;
		}
		case RREIL_COMPARATOR_TYPE_LTU: {
			data = simulator_op_cmp_ltu(opnd1, opnd2);
			break;
		}
	}
	context_data_clear(&opnd1);
	context_data_clear(&opnd2);

	return data;
}

static struct data simulator_sexpr_simulate(struct context *context,
		struct rreil_sexpr *sexpr, size_t bit_length) {
	struct data result;
	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_LIN: {
			result = simulator_linear_simulate(context, sexpr->lin, bit_length);
			break;
		}
		case RREIL_SEXPR_TYPE_CMP: {
			result = simulator_comparator_simulate(context, sexpr->cmp);
			break;
		}
	}
	return result;
}

static struct data simulator_op_simulate(struct context *context,
		struct rreil_op *op) {
	size_t size;
	struct data result;
	switch(op->type) {
		case RREIL_OP_TYPE_LIN: {
			size = op->lin.size;
			result = simulator_linear_simulate(context, op->lin.opnd1, size);
			break;
		}
		case RREIL_OP_TYPE_MUL: {
			size = op->mul.size;
			struct data opnd1 = simulator_linear_simulate(context, op->mul.opnd1,
					size);
			struct data opnd2 = simulator_linear_simulate(context, op->mul.opnd2,
					size);
			result = simulator_op_mul(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_OP_TYPE_DIV: {
			size = op->div.size;
			struct data opnd1 = simulator_linear_simulate(context, op->div.opnd1,
					size);
			struct data opnd2 = simulator_linear_simulate(context, op->div.opnd2,
					size);
			result = simulator_op_div(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_OP_TYPE_DIVS: {
			size = op->divs.size;
			struct data opnd1 = simulator_linear_simulate(context, op->divs.opnd1,
					size);
			struct data opnd2 = simulator_linear_simulate(context, op->divs.opnd2,
					size);
			result = simulator_op_divs(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_OP_TYPE_MOD: {
			size = op->mod.size;
			struct data opnd1 = simulator_linear_simulate(context, op->mod.opnd1,
					size);
			struct data opnd2 = simulator_linear_simulate(context, op->mod.opnd2,
					size);
			result = simulator_op_mod(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_OP_TYPE_SHL: {
			size = op->shl.size;
			struct data opnd1 = simulator_linear_simulate(context, op->shl.opnd1,
					size);
			struct data opnd2 = simulator_linear_simulate(context, op->shl.opnd2,
					size);
			result = simulator_op_shl(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_OP_TYPE_SHR: {
			size = op->shr.size;
			struct data opnd1 = simulator_linear_simulate(context, op->shr.opnd1,
					size);
			struct data opnd2 = simulator_linear_simulate(context, op->shr.opnd2,
					size);
			result = simulator_op_shr(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_OP_TYPE_SHRS: {
			size = op->shrs.size;
			struct data opnd1 = simulator_linear_simulate(context, op->shrs.opnd1,
					size);
			struct data opnd2 = simulator_linear_simulate(context, op->shrs.opnd2,
					size);
			result = simulator_op_shrs(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_OP_TYPE_AND: {
			size = op->and.size;
			struct data opnd1 = simulator_linear_simulate(context, op->and.opnd1,
					size);
			struct data opnd2 = simulator_linear_simulate(context, op->and.opnd2,
					size);
			result = simulator_op_and(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_OP_TYPE_OR: {
			size = op->or.size;
			struct data opnd1 = simulator_linear_simulate(context, op->or.opnd1,
					size);
			struct data opnd2 = simulator_linear_simulate(context, op->or.opnd2,
					size);
			result = simulator_op_or(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_OP_TYPE_XOR: {
			size = op->xor.size;
			struct data opnd1 = simulator_linear_simulate(context, op->xor.opnd1,
					size);
			struct data opnd2 = simulator_linear_simulate(context, op->xor.opnd2,
					size);
			result = simulator_op_xor(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_OP_TYPE_SX: {
			size = op->sx.size;
			struct data opnd = simulator_linear_simulate(context, op->sx.opnd,
					op->sx.fromsize);
			result = simulator_op_sx(size, opnd);
			context_data_clear(&opnd);
			break;
		}
		case RREIL_OP_TYPE_ZX: {
			size = op->zx.size;
			struct data opnd = simulator_linear_simulate(context, op->zx.opnd,
					op->zx.fromsize);
			result = simulator_op_zx(size, opnd);
			context_data_clear(&opnd);
			break;
		}
		case RREIL_OP_TYPE_CMP: {
			result = simulator_comparator_simulate(context, op->cmp);
			break;
		}
		case RREIL_OP_TYPE_ARB: {
			size = op->arb.size;
			result.data = (uint8_t*)calloc(size / 8 + 1, 1);
			result.bit_length = size;
			context_data_undefine(&result);
			break;
		}
	}
	return result;
}

static void simulator_branch_simulate(struct context *context,
		struct rreil_address *target) {
	struct data address = simulator_linear_simulate(context, target->address,
			target->size);
	char defined = 1;
	for(size_t j = 0; j < target->size / 8; ++j)
		if(address.defined[j] != 0xff)
			defined = 0;

	if(defined) {
		char equal = 1;
		for(size_t j = 0; j < target->size / 8; ++j) {
			if(context->x86_registers[X86_ID_IP].data[j] != address.data[j]) {
				equal = 0;
				break;
			}
		}
		if(!equal)
			context->memory.jump(address.data, target->size);
	}

	struct rreil_variable ip;
	struct rreil_id ip_id;
	ip_id.type = RREIL_ID_TYPE_X86;
	ip_id.x86 = X86_ID_IP;
	ip.id = &ip_id;
	ip.offset = 0;
	simulator_variable_write(context, &ip, address);

	context_data_clear(&address);
}

static enum simulator_error simulator_statement_simulate(struct context *context,
		struct rreil_statement *statement) {
	enum simulator_error error = SIMULATOR_ERROR_NONE;
	switch(statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			struct data data = simulator_op_simulate(context, statement->assign.rhs);
			simulator_variable_write(context, statement->assign.lhs, data);
			context_data_clear(&data);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			struct data address = simulator_linear_simulate(context,
					statement->load.address->address, statement->load.address->size);
			uint8_t *buffer = NULL;
			context->memory.load(&buffer, address.data, statement->load.address->size,
					statement->load.size);
			context_data_clear(&address);

			struct data data;
			data.data = buffer;
			data.bit_length = statement->load.size;
			context_data_define(&data);

			simulator_variable_write(context, statement->load.lhs, data);

			/*
			 * Important (and ugly): data.data is still is use by the allocation
			 */
			free(data.defined);
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			struct data data = simulator_op_simulate(context, statement->store.rhs);
			if(data.bit_length % 8) {
				printf("Warning: Unable to store unaligned (8 Bit) data.\n");
				error |= SIMULATOR_ERROR_UNALIGNED_STORE;
				goto end;
			}
			for (size_t i = 0; i < data.bit_length/8; ++i)
				if(data.defined[i] != 0xff) {
					printf("Warning: Aborting store because of undefined bits.\n");
					error |= SIMULATOR_ERROR_UNDEFINED_ADDRESS;
					goto end;
				}
			struct data address = simulator_linear_simulate(context,
					statement->store.address->address, statement->store.address->size);
			context->memory.store(data.data, address.data,
					statement->store.address->size, data.bit_length);
			context_data_clear(&address);
			end:
			context_data_clear(&data);
			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {
			/*
			 * Todo: Fix size
			 */
			struct data data = simulator_sexpr_simulate(context, statement->ite.cond,
					1);

			if(!(data.defined[0] & 0x01)) {
				printf("Warning: Undefined condition in if statement.\n");
				error |= SIMULATOR_ERROR_UNDEFINED_BRANCH;
			}
			if(!(data.defined[0] & 0x01) || (data.data[0] & 0x01))
				simulator_statements_simulate(context, statement->ite.then_branch);
			else
				simulator_statements_simulate(context, statement->ite.else_branch);

			context_data_clear(&data);
			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {
			/*
			 * Todo: Fix size
			 */
			struct data data = simulator_sexpr_simulate(context,
					statement->while_.cond, 1);
			/*
			 * Todo: Handle undefined value
			 */
			uint16_t max = 0xff;
			uint16_t i = 0;
			if(!(data.defined[0] & 0x01)) {
				printf("Warning: Undefined condition in while statement.\n");
				error |= SIMULATOR_ERROR_UNDEFINED_BRANCH;
				goto error_while;
			}
			while(data.data[0] & 0x01) {
				simulator_statements_simulate(context, statement->while_.body);
				context_data_clear(&data);
				data = simulator_sexpr_simulate(context, statement->while_.cond, 1);

				i++;
				if(i == max) {
					printf("Warning: Aborting loop after %u iterations.\n", max);
					break;
				}
			}
			error_while:
			context_data_clear(&data);
			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {
			/*
			 * Todo: Fix size
			 */
			struct data data = simulator_sexpr_simulate(context,
					statement->cbranch.cond, 1);
			if(!(data.defined[0] & 0x01)) {
				printf("Warning: Undefined condition in cbranch statement.\n");
				error |= SIMULATOR_ERROR_UNDEFINED_BRANCH;
			}
			if(!(data.defined[0] & 0x01) || (data.data[0] & 0x01))
				simulator_branch_simulate(context, statement->cbranch.target_true);
			else
				simulator_branch_simulate(context, statement->cbranch.target_false);
			context_data_clear(&data);
			break;
		}
		case RREIL_STATEMENT_TYPE_BRANCH: {
			simulator_branch_simulate(context, statement->branch.target);
			break;
		}
	}
	return error;
}

enum simulator_error simulator_statements_simulate(struct context *context,
		struct rreil_statements *statements) {
	enum simulator_error error = SIMULATOR_ERROR_NONE;
	for(size_t i = 0; i < statements->statements_length; ++i)
		error |= simulator_statement_simulate(context, statements->statements[i]);
	return error;
}
