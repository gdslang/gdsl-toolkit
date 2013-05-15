/*
 * context.c
 *
 *  Created on: 15.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <rreil/rreil.h>
#include <x86.h>
#include <context.h>

struct context *context_init() {
	struct context *context = (struct context*)malloc(
			sizeof(struct context));
	/*
	 * Todo: ...
	 */
	context->virtual_registers = (struct register_*)calloc(RREIL_ID_VIRTUAL_COUNT,
			sizeof(struct register_));
	context->x86_registers = (struct register_*)calloc(X86_ID_COUNT,
			sizeof(struct register_));
	context->temporary_registers = (struct register_*)calloc(
			RREIL_ID_TEMPORARY_COUNT, sizeof(struct register_));

	return context;
}

struct context *context_copy(
		struct context *source) {
	struct context *context = (struct context*)malloc(
			sizeof(struct context));

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
			X86_ID_COUNT * sizeof(struct register_));
	copy_registers(X86_ID_COUNT, context->x86_registers,
			source->x86_registers);
	context->temporary_registers = (struct register_*)malloc(
			RREIL_ID_TEMPORARY_COUNT * sizeof(struct register_));
	copy_registers(RREIL_ID_TEMPORARY_COUNT, context->temporary_registers,
			source->temporary_registers);

	return context;
}

static void register_clear(struct register_ *register_) {
	if(register_)
		free(register_->data);
}

void context_free(struct context *context) {
	if(context) {
		/*
		 * Todo: ...
		 */
		for(size_t i = 0; i < RREIL_ID_VIRTUAL_COUNT; ++i)
			register_clear(&context->virtual_registers[i]);
		free(context->virtual_registers);
		for(size_t i = 0; i < X86_ID_COUNT; ++i)
			register_clear(&context->x86_registers[i]);
		free(context->x86_registers);
		for(size_t i = 0; i < RREIL_ID_TEMPORARY_COUNT; ++i)
			register_clear(&context->temporary_registers[i]);
		free(context->temporary_registers);
		free(context);
	}
}

void context_x86_print(struct context *context) {
	for(size_t i = 0; i < X86_ID_COUNT; ++i) {
		enum x86_id id_x86 = (enum x86_id)i;
		struct register_ *reg = &context->x86_registers[id_x86];

		if(!reg->data_bit_length)
			continue;

		/*
		 * Todo: Extra function for printing
		 */
		printf("Register ");
		x86_id_print(id_x86);
		printf(": ");

		size_t rest = 0;
		size_t reg_size = x86_amd64_sizeof(id_x86);
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
