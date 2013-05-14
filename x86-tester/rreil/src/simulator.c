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

size_t rreil_comparator_simulate(struct simulator_context *context,
		uint8_t **buffer, struct rreil_comparator *comparator) {
	uint64_t size = comparator->arity2.size;
	uint8_t *opnd1;
	rreil_linear_simulate(context, &opnd1, comparator->arity2.opnd1, size);
	uint8_t *opnd2;
	rreil_linear_simulate(context, &opnd2, comparator->arity2.opnd2, size);
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

void rreil_sexpr_simulate(struct simulator_context *context, uint8_t **buffer,
		struct rreil_sexpr *sexpr, size_t bit_length) {
	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_LIN: {
			rreil_linear_simulate(context, buffer, sexpr->lin, bit_length);
			break;
		}
		case RREIL_SEXPR_TYPE_CMP: {
			rreil_comparator_simulate(context, buffer, sexpr->cmp);
			break;
		}
	}
}

size_t rreil_op_simulate(struct simulator_context *context, uint8_t **buffer,
		struct rreil_op *op) {
	size_t size;
	switch(op->type) {
		case RREIL_OP_TYPE_LIN: {
			size = op->lin.size;
			rreil_linear_simulate(context, buffer, op->lin.opnd1, size);
			break;
		}
		case RREIL_OP_TYPE_MUL: {
			size = op->mul.size;
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, op->mul.opnd1, size);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, op->mul.opnd2, size);
			*buffer = simulator_op_mul(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_DIV: {
			size = op->div.size;
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, op->div.opnd1, size);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, op->div.opnd2, size);
			*buffer = simulator_op_div(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_DIVS: {
			size = op->divs.size;
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, op->divs.opnd1, size);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, op->divs.opnd2, size);
			*buffer = simulator_op_divs(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_MOD: {
			size = op->mod.size;
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, op->mod.opnd1, size);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, op->mod.opnd2, size);
			*buffer = simulator_op_mod(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_SHL: {
			size = op->shl.size;
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, op->shl.opnd1, size);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, op->shl.opnd2, size);
			*buffer = simulator_op_shl(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_SHR: {
			size = op->shr.size;
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, op->shr.opnd1, size);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, op->shr.opnd2, size);
			*buffer = simulator_op_shr(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_SHRS: {
			size = op->shrs.size;
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, op->shrs.opnd1, size);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, op->shrs.opnd2, size);
			*buffer = simulator_op_shrs(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_AND: {
			size = op->and.size;
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, op->and.opnd1, size);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, op->and.opnd2, size);
			*buffer = simulator_op_and(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_OR: {
			size = op->or.size;
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, op->or.opnd1, size);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, op->or.opnd2, size);
			*buffer = simulator_op_or(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_XOR: {
			size = op->xor.size;
			uint8_t *opnd1;
			rreil_linear_simulate(context, &opnd1, op->xor.opnd1, size);
			uint8_t *opnd2;
			rreil_linear_simulate(context, &opnd2, op->xor.opnd2, size);
			*buffer = simulator_op_xor(opnd1, opnd2, size);
			free(opnd1);
			free(opnd2);
			break;
		}
		case RREIL_OP_TYPE_SX: {
			size = op->sx.size;
			uint8_t *opnd;
			rreil_linear_simulate(context, &opnd, op->sx.opnd, size);
			*buffer = simulator_op_sx(op->sx.fromsize, size, opnd);
			free(opnd);
			break;
		}
		case RREIL_OP_TYPE_ZX: {
			size = op->zx.size;
			uint8_t *opnd;
			rreil_linear_simulate(context, &opnd, op->zx.opnd, size);
			*buffer = simulator_op_zx(op->zx.fromsize, size, opnd);
			free(opnd);
			break;
		}
		case RREIL_OP_TYPE_CMP: {
			size = rreil_comparator_simulate(context, buffer, op->cmp);
			break;
		}
		case RREIL_OP_TYPE_ARB: {
			size = op->arb.size;
			*buffer = (uint8_t*)malloc(size / 8 + 1);
			for(size_t i = 0; i <= size / 8; ++i)
				(*buffer)[i] = (uint8_t)rand();
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
			free(buffer);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			fprintf(stderr,
					"Simulator: Unable to simulate RREIL_STATEMENT_TYPE_LOAD, not implemented.\n");
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			fprintf(stderr,
					"Simulator: Unable to simulate RREIL_STATEMENT_TYPE_STORE, not implemented.\n");
			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {
			uint8_t *buffer;
			/*
			 * Todo: Fix size
			 */
			rreil_sexpr_simulate(context, &buffer, statement->ite.cond, 1);
			if(*buffer & 0x01)
				rreil_statements_simulate(context, statement->ite.then_branch);
			else
				rreil_statements_simulate(context, statement->ite.else_branch);

			free(buffer);

			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {
			uint8_t *buffer;
			/*
			 * Todo: Fix size
			 */
			rreil_sexpr_simulate(context, &buffer, statement->while_.cond, 1);
			while(*buffer & 0x01) {
				rreil_statements_simulate(context, statement->while_.body);
				free(buffer);
				rreil_sexpr_simulate(context, &buffer, statement->while_.cond, 1);
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
	context->virtual_registers = (struct register_*)calloc(RREIL_ID_VIRTUAL_COUNT,
			sizeof(struct register_));
	context->x86_registers = (struct register_*)calloc(RREIL_ID_X86_COUNT,
			sizeof(struct register_));
	context->temporary_registers = (struct register_*)calloc(
			RREIL_ID_TEMPORARY_COUNT, sizeof(struct register_));

	return context;
}

struct simulator_context *simulator_context_copy(
		struct simulator_context *source) {
	struct simulator_context *context = (struct simulator_context*)malloc(
			sizeof(struct simulator_context));

	void copy_registers(size_t count, struct register_ *registers,
			struct register_ *registers_source) {
		for(size_t i = 0; i < count; ++i) {
			registers[i].data_bit_length = registers_source[i].data_bit_length;
			registers[i].data_size = registers_source[i].data_size;
			registers[i].data = (uint8_t*)malloc(registers[i].data_size);
			memcpy(registers[i].data, registers_source[i].data,
					registers[i].data_size);
		}
	}

	context->virtual_registers = (struct register_*)malloc(
			RREIL_ID_VIRTUAL_COUNT * sizeof(struct register_));
	copy_registers(RREIL_ID_VIRTUAL_COUNT, context->virtual_registers,
			source->virtual_registers);
	context->x86_registers = (struct register_*)malloc(
			RREIL_ID_X86_COUNT * sizeof(struct register_));
	copy_registers(RREIL_ID_X86_COUNT, context->x86_registers,
			source->x86_registers);
	context->temporary_registers = (struct register_*)malloc(
			RREIL_ID_TEMPORARY_COUNT * sizeof(struct register_));
	copy_registers(RREIL_ID_TEMPORARY_COUNT, context->temporary_registers,
			source->temporary_registers);

	return context;
}

static void simulator_register_clear(struct register_ *register_) {
	if(register_)
		free(register_->data);
}

void simulator_context_free(struct simulator_context *context) {
	if(context) {
		/*
		 * Todo: ...
		 */
		for(size_t i = 0; i < RREIL_ID_VIRTUAL_COUNT; ++i)
			simulator_register_clear(&context->virtual_registers[i]);
		free(context->virtual_registers);
		for(size_t i = 0; i < RREIL_ID_X86_COUNT; ++i)
			simulator_register_clear(&context->x86_registers[i]);
		free(context->x86_registers);
		for(size_t i = 0; i < RREIL_ID_TEMPORARY_COUNT; ++i)
			simulator_register_clear(&context->temporary_registers[i]);
		free(context->temporary_registers);
		free(context);
	}
}

void simulator_context_x86_print(struct simulator_context *context) {
	for(size_t i = 0; i < RREIL_ID_X86_COUNT; ++i) {
		enum rreil_id_x86 id_x86 = (enum rreil_id_x86)i;
		struct register_ *reg = &context->x86_registers[id_x86];

		if(!reg->data_bit_length)
			continue;

		/*
		 * Todo: Extra function for printing
		 */
		printf("Register ");
		rreil_id_x86_print(id_x86);
		printf(": ");

		size_t rest = 0;
		size_t reg_size = rreil_x86_amd64_sizeof(id_x86);
		if(reg_size > reg->data_bit_length)
			rest = reg_size - reg->data_bit_length;
		for(size_t i = 0; i < rest / 8; ++i)
			printf("00");
		if(reg->data_bit_length) {
			if(reg->data_bit_length % 8) {
				uint8_t top = reg->data[reg->data_bit_length / 8];
				uint8_t mask = (1 << (reg->data_bit_length % 8)) - 1;
				printf("%02x", (top & mask));
			}
			for(size_t i = reg->data_bit_length / 8; i > 0; --i)
				printf("%02x", reg->data[i - 1]);
		}
		printf("\n");
	}
}
