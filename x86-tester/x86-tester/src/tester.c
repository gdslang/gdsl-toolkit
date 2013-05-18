/*
 * tester.c
 *
 *  Created on: 15.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <time.h>
#include <sys/mman.h>
#include <rreil/rreil.h>
#include <x86.h>
#include <context.h>
#include <simulator/simulator.h>
#include <simulator/regacc.h>
#include <simulator/tracking.h>
#include "tbgen.h"

static void tester_access_init(struct context *context,
		struct register_access *access, void (*k)(uint8_t *, size_t)) {
	for(size_t i = 0; i < access->indices_length; ++i) {
		size_t index = access->indices[i];
		enum x86_id reg = (enum x86_id)index;

		size_t length = x86_amd64_sizeof(reg);
		uint8_t *data = (uint8_t*)malloc(length / 8 + 1);
		k(data, length);

		simulator_register_generic_write(&context->x86_registers[reg], data, length,
				0);

		free(data);
	}
}

/*
 * Clean up RFLAGS
 */
static void tester_rflags_clean(struct context *context) {
	uint64_t rflags_mask = 0x0000000000244cd5;
	uint8_t *rflags_mask_ptr = (uint8_t*)&rflags_mask;

	for(size_t i = 0;
			i < context->x86_registers[X86_ID_FLAGS].data_bit_length / 8; ++i) {
		context->x86_registers[X86_ID_FLAGS].data[i] &= rflags_mask_ptr[i];
	}
}

static void tester_instruction_execute(uint8_t *instruction,
		size_t instruction_length, struct simulator_trace *trace,
		struct context *context) {
	uint8_t* buffer;
	size_t buffer_size = tbgen_code_generate(&buffer, instruction,
			instruction_length, trace, context);
	void *mem_exec = mmap(NULL, buffer_size, PROT_READ | PROT_WRITE | PROT_EXEC,
			MAP_PRIVATE | MAP_ANONYMOUS, 0, 0);
	memcpy(mem_exec, buffer, buffer_size);
	free(buffer);
	((void (*)(void))mem_exec)();
	munmap(mem_exec, buffer_size);
}

static void tester_contexts_compare(struct simulator_trace *trace,
		struct context *context, struct context *context_rreil) {
	char found = 0;
	for(size_t i = 0; i < trace->reg.written.indices_length; ++i) {
		size_t index = trace->reg.written.indices[i];
		enum x86_id reg = (enum x86_id)index;
		struct register_ *reg_cpu = &context->x86_registers[index];
		struct register_ *reg_rreil = &context_rreil->x86_registers[index];
		for(size_t j = 0; j < reg_cpu->data_bit_length / 8; ++j)
			if(reg_cpu->data[j] != reg_rreil->data[j]) {
				if(found)
					printf(", ");

				x86_id_print(reg);
				found = 1;
				break;
			}
	}

	if(!found)
		printf("None\n");
	else
		printf("\n");
}
void tester_test(struct rreil_statements *statements, uint8_t *instruction,
		size_t instruction_length) {
//	for(size_t i = 0; i < 200; ++i) {
//		uint64_t *x;
//		for(size_t i = 0; i < 100; ++i) {
//			x = (uint64_t)x ^ rand() << i;
//		}
//		void *mem = mmap(x, 10*4096, PROT_READ | PROT_WRITE,
//				MAP_PRIVATE | MAP_ANONYMOUS, 0, 0);
////		if(mem != (x & (-1 ^ 0xfff)))
//			printf("%lu\n", x);
//	}
//	uint64_t *x = 0x3FFFFFFFF000;
//	uint64_t *mem = mmap(x, 4096, PROT_READ | PROT_WRITE, MAP_PRIVATE | MAP_ANONYMOUS | MAP_FIXED, 0, 0);
////		if(mem != (x & (-1 ^ 0xfff)))
//	*mem = 37;
//		printf("%lu\n", *mem);

	srand(time(NULL));

	rreil_statements_print(statements);

	struct context *context = context_init();

//			uint64_t value = 0x2b3481cfef1194ba;
//			uint64_t value = 0x2b3481cfef1194ba;
//			uint64_t value = 22;
//			struct rreil_id id;
//			id.type = RREIL_ID_TYPE_X86;
//			id.x86 = RREIL_ID_X86_AX;
//			simulator_register_write_64(context, &id, value, 0);
//
//			value = 0;
//			id.x86 = RREIL_ID_X86_FLAGS;
//			simulator_register_write_64(context, &id, value, 0);
//
//			value = 0x1100000000000052;
//			id.x86 = RREIL_ID_X86_CX;
//			simulator_register_write_64(context, &id, value, 0);
//
//			simulator_context_x86_print(context);

	struct simulator_trace *trace = tracking_trace_init();
	tracking_statements_trace(trace, statements);

	printf("------------------\n");
	tracking_trace_print(trace);

	void zero_buffer(uint8_t *data, size_t bit_length) {
		for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
			data[i] = 0;
	}

	void rand_buffer(uint8_t *data, size_t bit_length) {
		for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
			data[i] = rand();
	}

	void rand_address_buffer(uint8_t *data, size_t bit_length) {
		for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i) {
			if(i < 5)
				data[i] = rand();
			else
				data[i] = 0;
		}
	}

	tester_access_init(context, &trace->reg.written, &zero_buffer);
	tester_access_init(context, &trace->reg.read, &rand_buffer);
	tester_access_init(context, &trace->reg.dereferenced, &rand_address_buffer);

	struct context *context_rreil = context_copy(context);

	tester_rflags_clean(context);
	tester_rflags_clean(context_rreil);

	printf("------------------\n");
	context_x86_print(context);

	simulator_statements_simulate(context_rreil, statements);

	tester_instruction_execute(instruction, instruction_length, trace, context);

	tester_rflags_clean(context);

	printf("------------------\n");
	printf("CPU:\n");
	context_x86_print(context);
	printf("Rreil simulator:\n");
	context_x86_print(context_rreil);

	printf("------------------\n");
	printf("Failing Registers:\n");
	tester_contexts_compare(trace, context, context_rreil);

	tracking_trace_free(trace);

	context_free(context);
	context_free(context_rreil);
}
