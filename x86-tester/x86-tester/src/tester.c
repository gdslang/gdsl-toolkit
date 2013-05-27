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
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>
#include <unistd.h>
#include <setjmp.h>
#include <rreil/rreil.h>
#include <rreil/gdrr_builder.h>
#include <x86.h>
#include <context.h>
#include <simulator/simulator.h>
#include <simulator/regacc.h>
#include <simulator/tracking.h>
#include <memory.h>
#include <util.h>
#include <stack.h>
#include <tbgen.h>
#include <tester.h>
#include <gdsl.h>
#include <dis.h>
#include <gdrr.h>

#include <context.h>
#include <executor.h>

static void tester_access_init(struct context *context,
		struct register_access *access, void (*k)(uint8_t *, size_t)) {
	for(size_t i = 0; i < access->x86_indices_length; ++i) {
		size_t index = access->x86_indices[i];
		enum x86_id reg = (enum x86_id)index;

		size_t length = x86_amd64_sizeof(reg);
		uint8_t *buffer = (uint8_t*)malloc(length / 8 + 1);
		k(buffer, length);

		struct data data;
		data.data = buffer;
		data.bit_length = length;
		context_data_define(&data);

		simulator_register_generic_write(&context->x86_registers[reg], data, 0);

		context_data_clear(&data);
	}
}

enum tester_result tester_test_translated(struct rreil_statements *statements,
		uint8_t *instruction, size_t instruction_length) {
	enum tester_result result = TESTER_RESULT_SUCCESS;

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
//	mem += 0x00f0000000000000;
//	mem[1] = 42;
//		if(mem != (x & (-1 ^ 0xfff)))
//	*mem = 37;
//		printf("%lu\n", *mem);

	rreil_statements_print(statements);

	struct context *context_cpu;
	struct context *context_rreil;
	struct tracking_trace *trace = tracking_trace_init();

	void load(uint8_t **buffer, uint8_t *address, uint64_t address_size,
			uint64_t access_size) {
		uint8_t *source = (uint8_t*)malloc(access_size / 8);
		for(size_t i = 0; i < access_size / 8; ++i)
			source[i] = rand();
		memory_load(context_rreil, buffer, address, address_size, access_size,
				source);
		memory_load(context_cpu, buffer, address, address_size, access_size,
				source);
		free(source);
	}
	void store(uint8_t *buffer, uint8_t *address, uint64_t address_size,
			uint64_t access_size) {
		memory_store(context_rreil, buffer, address, address_size, access_size);
		struct memory_access access;
		access.address = memory_ptr_get(address, address_size);
		access.data_size = access_size / 8;
		tracking_trace_memory_write_add(trace, access);
	}
	void jump(uint8_t *address, uint64_t address_size) {
		memory_jump(context_rreil, address, address_size);
		memory_jump(context_cpu, address, address_size);
	}

	context_rreil = context_init(&load, &store, &jump);

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

	tracking_statements_trace(trace, statements);

	if(!trace->reg.dereferenced.x86_indices_length
			&& !trace->reg.read.x86_indices_length
			&& !trace->reg.written.x86_indices_length && !trace->mem.used) {
		printf("Instruction without any effects, aborting...\n");
		goto cu_b;
	}

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
		if(bit_length != 64) {
			rand_buffer(data, bit_length);
			return;
		}

		for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i) {
			if(!i)
				data[i] = rand() & 0xf0;
			else if(i < 5)
				data[i] = rand();
			else
				data[i] = 0;
		}
	}

	tester_access_init(context_rreil, &trace->reg.written, &zero_buffer);
//	tester_access_init(context_rreil, &trace->reg.read, &rand_buffer);

	void (*rand)(uint8_t*, size_t);
	if(trace->mem.used)
		rand = &rand_address_buffer;
	else
		rand = &rand_buffer;

	tester_access_init(context_rreil, &trace->reg.read, rand);
	tester_access_init(context_rreil, &trace->reg.dereferenced, rand);

	executor_rflags_clean(context_rreil);

	context_cpu = context_copy(context_rreil);

	void *code;
	void *next_instruction_address;
	struct tbgen_result tbgen_result = executor_instruction_mapped_generate(
			instruction, instruction_length, trace, context_cpu, &code,
			&next_instruction_address);

	struct data insn_address;
	insn_address.data = (uint8_t*)&next_instruction_address;
	insn_address.bit_length = sizeof(next_instruction_address) * 8;
	context_data_define(&insn_address);

	simulator_register_generic_write(&context_cpu->x86_registers[X86_ID_IP],
			insn_address, 0);
	simulator_register_generic_write(&context_rreil->x86_registers[X86_ID_IP],
			insn_address, 0);

	free(insn_address.defined);

	printf("------------------\n");
	context_x86_print(context_rreil);

	if(simulator_statements_simulate(context_rreil, statements)
			!= SIMULATOR_ERROR_NONE) {
		result = TESTER_RESULT_SIMULATION_ERROR;
		goto cu_a;
	}

//	char *k = malloc(900);
//	memcpy(k, context_cpu->memory.allocations[0].data, context_cpu->memory.allocations[0].data_size);

//	tester_rflags_clean(context_rreil);

	char retval = executor_instruction_execute(instruction, instruction_length,
			trace, context_cpu, code, tbgen_result);
	if(retval) {
		result = TESTER_RESULT_EXECUTION_ERROR;
		goto cu_a;
	}

//	tester_rflags_clean(context_cpu);

	printf("------------------\n");
	printf("CPU:\n");
	context_x86_print(context_cpu);
	printf("Rreil simulator:\n");
	context_x86_print(context_rreil);

	printf("------------------\n");
	if(!retval) {
		retval = context_compare(trace, context_cpu, context_rreil);
		if(retval)
			result = TESTER_RESULT_COMPARISON_ERROR;
	} else
		printf(
				"Comparison skipped because of the failure to execute the test function.\n");

	cu_a: ;

	free(tbgen_result.buffer);
	free(tbgen_result.jump_marker);

	munmap(code, tbgen_result.buffer_length);

	context_free(context_cpu);

	cu_b: ;
	tracking_trace_free(trace);
	context_free(context_rreil);

	return result;
}

enum tester_result tester_test_binary(void (*name)(char *), char fork_,
		__char *data, size_t data_size) {
	enum tester_result result = TESTER_RESULT_SUCCESS;

	__obj state = gdsl_create_state(data, data_size);

	__obj insn;
	if(gdsl_decode(&insn, &state)) {
		printf("Decode failed\n");
		fflush(stderr);
		fflush(stdout);
		result = TESTER_RESULT_DECODING_ERROR;
		goto cu;
	}

	data_size = gdsl_decoded(&state);

	printf("Instruction bytes:");
	for(size_t i = 0; i < data_size; ++i)
		printf(" %02x", (int)(data[i]) & 0xff);
	printf("\n");

	char *str = gdsl_x86_pretty(insn, GSDL_X86_PRINT_MODE_FULL);
	if(str)
		puts(str);
	else
		printf("NULL\n");
	free(str);

	str = gdsl_x86_pretty(insn, GSDL_X86_PRINT_MODE_SIMPLE);
	if(str) {
		puts(str);
		if(name)
			name(str);
	} else
		printf("NULL\n");
	free(str);

	printf("---------------------------\n");

	__obj rreil;
	if(gdsl_translate(&rreil, insn, &state)) {
		printf("Translate failed\n");
		fflush(stderr);
		fflush(stdout);
		result = TESTER_RESULT_TRANSLATION_ERROR;
		goto cu;
	}

	struct gdrr_config *config = rreil_gdrr_builder_config_get();
	struct rreil_statements *statements = (struct rreil_statements*)gdrr_convert(
			rreil, config);
	free(config);

	if(fork_) {
		enum tester_result *translated_result = mmap(NULL,
				sizeof(enum tester_result), PROT_READ | PROT_WRITE,
				MAP_SHARED | MAP_ANONYMOUS, 0, 0);
		*translated_result = TESTER_RESULT_CRASH;

		pid_t pid = fork();
		if(!pid) {
			*translated_result = tester_test_translated(statements, data, data_size);
			exit(0);
		} else
			waitpid(pid, NULL, 0);
		result = *translated_result;
		munmap(translated_result, sizeof(enum tester_result));
	} else
		result = tester_test_translated(statements, data, data_size);

	rreil_statements_free(statements);

	cu: ;

	gdsl_reset();

	return result;
}

void tester_result_print(enum tester_result result) {
	switch(result) {
		case TESTER_RESULT_SUCCESS: {
			printf("TESTER_RESULT_SUCCESS");
			break;
		}
		case TESTER_RESULT_DECODING_ERROR: {
			printf("TESTER_RESULT_DECODING_ERROR");
			break;
		}
		case TESTER_RESULT_TRANSLATION_ERROR: {
			printf("TESTER_RESULT_TRANSLATION_ERROR");
			break;
		}
		case TESTER_RESULT_SIMULATION_ERROR: {
			printf("TESTER_RESULT_SIMULATION_ERROR");
			break;
		}
		case TESTER_RESULT_EXECUTION_ERROR: {
			printf("TESTER_RESULT_EXECUTION_ERROR");
			break;
		}
		case TESTER_RESULT_COMPARISON_ERROR: {
			printf("TESTER_RESULT_COMPARISON_ERROR");
			break;
		}
		case TESTER_RESULT_CRASH: {
			printf("TESTER_RESULT_CRASH");
			break;
		}
	}
}
