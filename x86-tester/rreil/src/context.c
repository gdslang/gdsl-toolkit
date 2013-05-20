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

struct memory_allocation *memory_allocation_init(void *address) {
	struct memory_allocation *allocation = (struct memory_allocation*)malloc(
			sizeof(struct memory_allocation));
	allocation->address = address;
	allocation->data = NULL;
	allocation->data_size = 0;
	return allocation;
}

struct context *context_init(context_load_t *load, context_store_t *store,
		context_jump_t *jump) {
	struct context *context = (struct context*)malloc(sizeof(struct context));
	context->virtual_registers = (struct register_*)calloc(RREIL_ID_VIRTUAL_COUNT,
			sizeof(struct register_));
	context->x86_registers = (struct register_*)calloc(X86_ID_COUNT,
			sizeof(struct register_));
	context->temporary_registers = (struct register_*)calloc(
			RREIL_ID_TEMPORARY_COUNT, sizeof(struct register_));

	context->memory.allocations = NULL;
	context->memory.allocations_length = 0;
	context->memory.allocations_size = 0;
	context->memory.load = load;
	context->memory.store = store;
	context->memory.jump = jump;

	return context;
}

struct context *context_copy(struct context *source) {
	struct context *context = (struct context*)malloc(sizeof(struct context));

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
	copy_registers(X86_ID_COUNT, context->x86_registers, source->x86_registers);
	context->temporary_registers = (struct register_*)malloc(
			RREIL_ID_TEMPORARY_COUNT * sizeof(struct register_));
	copy_registers(RREIL_ID_TEMPORARY_COUNT, context->temporary_registers,
			source->temporary_registers);

	context->memory.allocations = (struct memory_allocation *)malloc(
			source->memory.allocations_size * sizeof(struct memory_allocation));
	context->memory.allocations_length = source->memory.allocations_length;
	context->memory.allocations_size = source->memory.allocations_size;
	for(size_t i = 0; i < context->memory.allocations_length; ++i) {
		struct memory_allocation *source_a = &source->memory.allocations[i];
		struct memory_allocation *destination_a = &context->memory.allocations[i];

		destination_a->address = source_a->address;
		destination_a->data_size = source_a->data_size;
		destination_a->data = (uint8_t*)malloc(destination_a->data_size);
		memcpy(destination_a->data, source_a->data, source_a->data_size);
		destination_a->type = source_a->type;
	}
	context->memory.load = source->memory.load;
	context->memory.store = source->memory.store;
	context->memory.jump = source->memory.jump;

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

		/*
		 * Todo: Unmapping ;-)
		 */
		for(size_t i = 0; i < context->memory.allocations_length; ++i)
			free(context->memory.allocations[i].data);
		free(context->memory.allocations);

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
	for(size_t i = 0; i < context->memory.allocations_length; ++i) {
		struct memory_allocation *allocation = &context->memory.allocations[i];

		/*
		 * Todo Combine with compare-thing
		 */
		printf("Memory access (@0x");
		for(size_t i = sizeof(allocation->address); i > 0; --i) {
			uint8_t *addr_ptr = (uint8_t*)&allocation->address;
			printf("%02x", addr_ptr[i - 1]);
		}
		printf("): ");

		if(allocation->type == MEMORY_ALLOCATION_TYPE_ACCESS)
			for(size_t i = allocation->data_size; i > 0; --i)
				printf("%02x", allocation->data[i - 1]);
		else
			printf("JUMP");

		printf("\n");
	}
}
