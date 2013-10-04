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
#include <utime.h>
#include <x86.h>
#include <util.h>

static void simulator_variable_write(struct context *context, struct rreil_variable *variable, struct data data) {
	if(data.bit_length)
		simulator_register_write(context, variable->id, data, variable->offset);
}

static void simulator_variable_limited_write(struct context *context, struct rreil_variable_limited *varl, struct data data) {
	if(data.bit_length)
		simulator_register_write(context, varl->id, data, varl->offset);
}

static void simulator_variable_read(struct context *context, struct rreil_variable *variable, struct data data) {
	simulator_register_read(context, variable->id, data, variable->offset);
}

static void simulator_variable_limited_read(struct context *context, struct rreil_variable_limited *varl, struct data data) {
	simulator_register_read(context, varl->id, data, varl->offset);
}

struct data simulator_variable_simulate(struct context *context, struct rreil_variable *variable, size_t bit_length) {
	struct data result;

	result.data = (uint8_t*)malloc(bit_length / 8 + 1);
	result.defined = (uint8_t*)malloc(bit_length / 8 + 1);
	result.bit_length = bit_length;
	simulator_variable_read(context, variable, result);

	return result;
}

struct data simulator_variable_limited_simulate(struct context *context, struct rreil_variable_limited *varl) {
	struct data result;

	result.data = (uint8_t*)malloc(varl->size / 8 + 1);
	result.defined = (uint8_t*)malloc(varl->size / 8 + 1);
	result.bit_length = varl->size;
	simulator_variable_limited_read(context, varl, result);

	return result;
}

static struct data simulator_linear_simulate(struct context *context, struct rreil_linear *linear, size_t bit_length) {
	struct data result;
	switch(linear->type) {
		case RREIL_LINEAR_TYPE_VARIABLE: {
			result = simulator_variable_simulate(context, linear->variable, bit_length);
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
			struct data opnd1 = simulator_linear_simulate(context, linear->sum.opnd1, bit_length);
			struct data opnd2 = simulator_linear_simulate(context, linear->sum.opnd2, bit_length);
			result = simulator_op_add(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_DIFFERENCE: {
			struct data opnd1 = simulator_linear_simulate(context, linear->difference.opnd1, bit_length);
			struct data opnd2 = simulator_linear_simulate(context, linear->difference.opnd2, bit_length);
			result = simulator_op_sub(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_SCALE: {
			struct data opnd = simulator_linear_simulate(context, linear->scale.opnd, bit_length);

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

static struct data simulator_comparator_simulate(struct context *context, struct rreil_comparator *comparator,
		uint64_t size) {
	struct data opnd1 = simulator_linear_simulate(context, comparator->arity2.opnd1, size);
	struct data opnd2 = simulator_linear_simulate(context, comparator->arity2.opnd2, size);

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

static struct data simulator_sexpr_simulate(struct context *context, struct rreil_sexpr *sexpr, uint64_t size) {
	struct data result;
	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_LIN: {
			result = simulator_linear_simulate(context, sexpr->lin, size);
			break;
		}
		case RREIL_SEXPR_TYPE_CMP: {
			result = simulator_comparator_simulate(context, sexpr->cmp, size);
			break;
		}
		case RREIL_SEXPR_TYPE_ARB: {
			result.data = (uint8_t*)calloc(size / 8 + 1, 1);
			result.bit_length = size;
			context_data_undefine(&result);
			break;
		}
	}
	return result;
}

static struct data simulator_expr_simulate(struct context *context, struct rreil_expr *expr, uint64_t size) {
	struct data result;
	switch(expr->type) {
		case RREIL_EXPR_TYPE_SEXPR: {
			result = simulator_sexpr_simulate(context, expr->sexpr, size);
			break;
		}
		case RREIL_EXPR_TYPE_MUL: {
			struct data opnd1 = simulator_linear_simulate(context, expr->mul.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->mul.opnd2, size);
			result = simulator_op_mul(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_DIV: {
			struct data opnd1 = simulator_linear_simulate(context, expr->div.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->div.opnd2, size);
			result = simulator_op_div(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_DIVS: {
			struct data opnd1 = simulator_linear_simulate(context, expr->divs.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->divs.opnd2, size);
			result = simulator_op_divs(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_MOD: {
			struct data opnd1 = simulator_linear_simulate(context, expr->mod.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->mod.opnd2, size);
			result = simulator_op_mod(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_MODS: {
			struct data opnd1 = simulator_linear_simulate(context, expr->mods.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->mods.opnd2, size);
			result = simulator_op_mods(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_SHL: {
			struct data opnd1 = simulator_linear_simulate(context, expr->shl.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->shl.opnd2, size);
			result = simulator_op_shl(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_SHR: {
			struct data opnd1 = simulator_linear_simulate(context, expr->shr.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->shr.opnd2, size);
			result = simulator_op_shr(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_SHRS: {
			struct data opnd1 = simulator_linear_simulate(context, expr->shrs.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->shrs.opnd2, size);
			result = simulator_op_shrs(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_AND: {
			struct data opnd1 = simulator_linear_simulate(context, expr->and_.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->and_.opnd2, size);
			result = simulator_op_and(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_OR: {
			struct data opnd1 = simulator_linear_simulate(context, expr->or_.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->or_.opnd2, size);
			result = simulator_op_or(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_XOR: {
			struct data opnd1 = simulator_linear_simulate(context, expr->xor_.opnd1, size);
			struct data opnd2 = simulator_linear_simulate(context, expr->xor_.opnd2, size);
			result = simulator_op_xor(opnd1, opnd2);
			context_data_clear(&opnd1);
			context_data_clear(&opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_SX: {
			struct data opnd = simulator_linear_simulate(context, expr->sx.opnd, expr->sx.fromsize);
			result = simulator_op_sx(size, opnd);
			context_data_clear(&opnd);
			break;
		}
		case RREIL_EXPR_TYPE_ZX: {
			struct data opnd = simulator_linear_simulate(context, expr->zx.opnd, expr->zx.fromsize);
			result = simulator_op_zx(size, opnd);
			context_data_clear(&opnd);
			break;
		}
	}
	return result;
}

static void simulator_branch_simulate(struct context *context, struct rreil_address *target) {
	struct data address = simulator_linear_simulate(context, target->address, target->size);
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
			context->memory.jump(context->memory.closure, address.data, target->size);
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

static enum simulator_error simulator_prim_simulate(struct context *context, char *op, struct rreil_variable_limited_tuple *lhs,
		struct rreil_variable_limited_tuple *rhs) {
//	if(!strcmp(op, "mods")) {
//		if(lhs->variables_length != 1 || rhs->variables_length != 2)
//			return SIMULATOR_ERROR_PRIMITIVE_SIGNATURE_INVALID;
//
//		uint64_t size = lhs->variables[0]->size;
//		if(size != rhs->variables[0]->size || size != rhs->variables[1]->size)
//			return SIMULATOR_ERROR_PRIMITIVE_SIGNATURE_INVALID;
//
//		struct data opnd1 = simulator_variable_limited_simulate(context, rhs->variables[0]);
//		struct data opnd2 = simulator_variable_limited_simulate(context, rhs->variables[1]);
//		struct data result = simulator_op_mods(opnd1, opnd2);
//		context_data_clear(&opnd1);
//		context_data_clear(&opnd2);
//
//		simulator_variable_limited_write(context, lhs->variables[0], result);
//		context_data_clear(&result);
//
//		return SIMULATOR_ERROR_NONE;
//	}

	return SIMULATOR_ERROR_PRIMITIVE_UNKNOWN;
}

static enum simulator_error simulator_statement_simulate(struct context *context, struct rreil_statement *statement) {
	enum simulator_error error = SIMULATOR_ERROR_NONE;
	switch(statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			struct data data = simulator_expr_simulate(context, statement->assign.rhs, statement->assign.size);
			simulator_variable_write(context, statement->assign.lhs, data);
			context_data_clear(&data);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			struct data address = simulator_linear_simulate(context, statement->load.address->address,
					statement->load.address->size);
			for(size_t i = 0; i < address.bit_length / 8; ++i)
				if(address.defined[i] != 0xff) {
					printf("Warning: Aborting load because of undefined address bits.\n");
					error |= SIMULATOR_ERROR_UNDEFINED_ADDRESS;
					goto end;
				}

			uint8_t *buffer = NULL;
			context->memory.load(context->memory.closure, &buffer, address.data, statement->load.address->size,
					statement->load.size);

			struct data data;
			data.data = buffer;
			data.bit_length = statement->load.size;
			context_data_define(&data);

			simulator_variable_write(context, statement->load.lhs, data);

			/*
			 * Important (and ugly): data.data is still is use by the allocation
			 */
			free(data.defined);
			end: context_data_clear(&address);
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			struct data data = simulator_expr_simulate(context, statement->store.rhs, statement->store.size);
			if(data.bit_length % 8) {
				printf("Warning: Unable to store unaligned (8 Bit) data.\n");
				error |= SIMULATOR_ERROR_UNALIGNED_STORE;
				goto end_1;
			}
			for(size_t i = 0; i < data.bit_length / 8; ++i)
				if(data.defined[i] != 0xff) {
					printf("Warning: Aborting store because of undefined data bits.\n");
					error |= SIMULATOR_ERROR_UNDEFINED_STORE;
					goto end_1;
				}
			struct data address = simulator_linear_simulate(context, statement->store.address->address,
					statement->store.address->size);
			for(size_t i = 0; i < address.bit_length / 8; ++i)
				if(address.defined[i] != 0xff) {
					printf("Warning: Aborting store because of undefined address bits.\n");
					error |= SIMULATOR_ERROR_UNDEFINED_ADDRESS;
					goto end_0;
				}
			context->memory.store(context->memory.closure, data.data, address.data, statement->store.address->size,
					data.bit_length);
			end_0: context_data_clear(&address);
			end_1: context_data_clear(&data);
			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {
			/*
			 * Todo: Fix size
			 */
			struct data data = simulator_sexpr_simulate(context, statement->ite.cond, 1);

			if(!(data.defined[0] & 0x01)) {
				printf("Warning: Undefined condition in if statement.\n");
				error |= SIMULATOR_ERROR_UNDEFINED_BRANCH;
			}
			if(!(data.defined[0] & 0x01) || (data.data[0] & 0x01))
				error |= simulator_statements_simulate(context, statement->ite.then_branch);
			else
				error |= simulator_statements_simulate(context, statement->ite.else_branch);

			context_data_clear(&data);
			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {
			/*
			 * Todo: Fix size
			 */
			struct data data = simulator_sexpr_simulate(context, statement->while_.cond, 1);
			/*
			 * Todo: Handle undefined value
			 */
			uint32_t max = 0x0fff;
			uint32_t i = 0;
			if(!(data.defined[0] & 0x01)) {
				printf("Warning: Undefined condition in while statement.\n");
				error |= SIMULATOR_ERROR_UNDEFINED_BRANCH;
				goto error_while;
			}
			while(data.data[0] & 0x01) {
				error |= simulator_statements_simulate(context, statement->while_.body);
				context_data_clear(&data);
				data = simulator_sexpr_simulate(context, statement->while_.cond, 1);

				i++;
				if(i == max) {
					printf("Warning: Aborting loop after %u iterations.\n", max);
					error |= SIMULATOR_ERROR_MAX_LOOP_ITERATIONS_COUNT_EXCEEDED;
					break;
				}
			}
			error_while: context_data_clear(&data);
			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {
			/*
			 * Todo: Fix size
			 */
			struct data data = simulator_sexpr_simulate(context, statement->cbranch.cond, 1);
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
		case RREIL_STATEMENT_TYPE_PRIM: {
			error = simulator_prim_simulate(context, statement->prim.op, statement->prim.lhs, statement->prim.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_THROW: {
			error |= SIMULATOR_ERROR_EXCEPTION;
			break;
		}
			/*
			 * Todo: Primitives, Floating point operations
			 */
	}
	return error;
}

enum simulator_error simulator_statements_simulate(struct context *context, struct rreil_statements *statements) {
	enum simulator_error error = SIMULATOR_ERROR_NONE;
	for(size_t i = 0; i < statements->statements_length; ++i)
		error |= simulator_statement_simulate(context, statements->statements[i]);
	return error;
}
