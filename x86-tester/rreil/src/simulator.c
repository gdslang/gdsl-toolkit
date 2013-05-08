/*
 * simulator.c
 *
 *  Created on: 07.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <rreil/rreil.h>
#include <simulator.h>
#include <simulator_regacc.h>
#include <simulator_ops.h>
#include <simulator_tools.h>

void rreil_variable_write(struct simulator_context *context,
		struct rreil_variable *variable, size_t bit_length, uint8_t *buffer) {
	simulator_register_write(context, variable->id, buffer, bit_length,
			variable->offset);
}

void rreil_variable_read(struct simulator_context *context,
		struct rreil_variable *variable, size_t bit_length, uint8_t *buffer) {
	simulator_register_read(context, variable->id, buffer, bit_length,
			variable->offset);
}

void rreil_linear_simulate(struct simulator_context *context, uint8_t **buffer,
		struct rreil_linear *linear, size_t bit_length) {
	switch(linear->type) {
		case RREIL_LINEAR_TYPE_VARIABLE: {
			*buffer = (uint8_t*)malloc(bit_length / 8 + 1);
			rreil_variable_read(context, linear->variable, bit_length, *buffer);
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
			rreil_linear_simulate(context, &opnd1, linear->sum.opnd1, bit_length);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, linear->sum.opnd2, bit_length);
			*buffer = simulator_op_add(opnd1, opnd2, bit_length);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_DIFFERENCE: {
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, linear->difference.opnd1,
					bit_length);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, linear->difference.opnd2,
					bit_length);
			*buffer = simulator_op_sub(opnd1, opnd2, bit_length);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_SCALE: {
			uint8_t *opnd;
			rreil_linear_simulate(context, &opnd, linear->scale.opnd, bit_length);
			uint8_t *scale = simulator_op_sx(sizeof(linear->scale.imm) * 8,
					bit_length, (uint8_t*)linear->scale.imm);
			*buffer = simulator_op_mul(scale, opnd, bit_length);
			free(opnd);
			break;
		}
	}
}

size_t rreil_op_simulate(struct simulator_context *context, uint8_t **buffer,
		struct rreil_op *op) {
	size_t size;
	switch(op->type) {
		case RREIL_OP_TYPE_LIN: {
//			*buffer = (uint8_t*)malloc(op->lin.size / 8 + 1);
			rreil_linear_simulate(context, buffer, op->lin.opnd1, op->lin.size);
			size = op->lin.size;
			break;
		}
		case RREIL_OP_TYPE_MUL: {
			break;
		}
		case RREIL_OP_TYPE_DIV: {
			break;
		}
		case RREIL_OP_TYPE_DIVS: {
			break;
		}
		case RREIL_OP_TYPE_MOD: {
			break;
		}
		case RREIL_OP_TYPE_SHL: {
			break;
		}
		case RREIL_OP_TYPE_SHR: {
			break;
		}
		case RREIL_OP_TYPE_SHRS: {
			break;
		}
		case RREIL_OP_TYPE_AND: {
			break;
		}
		case RREIL_OP_TYPE_OR: {
			break;
		}
		case RREIL_OP_TYPE_XOR: {
			break;
		}
		case RREIL_OP_TYPE_SX: {
			break;
		}
		case RREIL_OP_TYPE_ZX: {
			break;
		}
		case RREIL_OP_TYPE_CMP: {
			break;
		}
		case RREIL_OP_TYPE_ARB: {
			break;
		}
	}
	return size;
}

void rreil_statement_simulate(struct simulator_context *context,
		struct rreil_statement *statement) {
	switch(statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			uint8_t *buffer;
			size_t bit_length = rreil_op_simulate(context, &buffer,
					statement->assign.rhs);
			rreil_variable_write(context, statement->assign.lhs, bit_length, buffer);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {

			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {

			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {

			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {

			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {

			break;
		}
		case RREIL_STATEMENT_TYPE_BRANCH: {

			break;
		}
	}
}

void rreil_statements_simulate(struct simulator_context *context,
		struct rreil_statements *statements) {
	for(size_t i = 0; i < statements->statements_length; ++i)
		rreil_statement_simulate(context, statements->statements[i]);
}

struct simulator_context *simulator_context_init() {
	struct simulator_context *context = (struct simulator_context*)malloc(
			sizeof(struct simulator_context));
	/*
	 * Todo: ...
	 */
	context->virtual_registers = (struct register_*)calloc(6,
			sizeof(struct register_));
	context->x86_registers = (struct register_*)calloc(200,
			sizeof(struct register_));
	context->temporary_registers = (struct register_*)calloc(TEMPS,
			sizeof(struct register_));

	return context;
}
