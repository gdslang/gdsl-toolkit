/*
 * tester.c
 *
 *  Created on: 15.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <rreil/rreil.h>
#include <rreil/gdrr_builder.h>
#include <gdrr.h>
#include <x86.h>
#include <simulator/simulator.h>
#include <simulator/regacc.h>
#include <simulator/tracking.h>
#include <memory.h>
#include <util.h>
#include <tbgen.h>
#include <gdwrap.h>
#include <gdsl.h>
#include <context.h>
#include <executor.h>
#include <tester.h>

static void tester_register_fill(struct context *context, enum x86_id reg,
		void (*filler)(uint8_t *, size_t)) {
	size_t length = x86_amd64_sizeof(reg);
	uint8_t *buffer = (uint8_t*)malloc(length / 8 + 1);
	filler(buffer, length);

	struct data data;
	data.data = buffer;
	data.bit_length = length;
	context_data_define(&data);

	simulator_register_generic_write(&context->x86_registers[reg], data, 0);

	context_data_clear(&data);
}

static void tester_access_init(struct context *context,
		struct register_access *access, void (*filler)(uint8_t *, size_t)) {
	for(size_t i = 0; i < access->x86_indices_length; ++i) {
		size_t index = access->x86_indices[i];
		enum x86_id reg = (enum x86_id)index;

		tester_register_fill(context, reg, filler);
	}
}

static void registers_x86_rreil_init(struct context *context_rreil,
		struct tracking_trace *trace, char test_unused) {
	void zero_buffer(uint8_t *data, size_t bit_length) {
		for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
			data[i] = 0;
	}

	void rand_buffer(uint8_t *data, size_t bit_length) {
		for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
			data[i] = rand() * (rand() > RAND_MAX / 4);
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
//			else if(i == 6)
//				data[i] = 0x7f;
			else
				data[i] = 0;
		}
	}

	void (*rand)(uint8_t*, size_t);
	if(trace->mem.used)
		rand = &rand_address_buffer;
	else
		rand = &rand_buffer;

	if(test_unused) {
		for(size_t i = 0; i < X86_ID_COUNT; ++i)
			tester_register_fill(context_rreil, (enum x86_id)i, rand);
	} else {
		tester_access_init(context_rreil, &trace->reg.written, &zero_buffer);
//	tester_access_init(context_rreil, &trace->reg.read, &rand_buffer);

		tester_access_init(context_rreil, &trace->reg.read, rand);
		tester_access_init(context_rreil, &trace->reg.dereferenced, rand);
	}

	executor_rflags_clean(context_rreil);
}

static void ip_set(struct context *context_rreil, struct context *context_cpu,
		void *next_instruction_address) {
	struct data insn_address;
	insn_address.data = (uint8_t*)&next_instruction_address;
	insn_address.bit_length = sizeof(next_instruction_address) * 8;
	context_data_define(&insn_address);

	simulator_register_generic_write(&context_cpu->x86_registers[X86_ID_IP],
			insn_address, 0);
	simulator_register_generic_write(&context_rreil->x86_registers[X86_ID_IP],
			insn_address, 0);

	free(insn_address.defined);
}

struct tester_result tester_test_translated(struct rreil_statements *statements,
		uint8_t *instruction, size_t instruction_length, char test_unused) {
	struct tester_result result;
	result.type = TESTER_RTYPE_SUCCESS;

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

	tracking_statements_trace(trace, statements);

	if(!trace->reg.dereferenced.x86_indices_length
			&& !trace->reg.read.x86_indices_length
			&& !trace->reg.written.x86_indices_length && !trace->mem.used) {
		printf("Instruction without any effects, aborting...\n");
		goto cu_b;
	}

	printf("------------------\n");
	tracking_trace_print(trace);

	registers_x86_rreil_init(context_rreil, trace, test_unused);

	context_cpu = context_copy(context_rreil);

	void *code;
	void *next_instruction_address;
	struct tbgen_result tbgen_result = executor_instruction_mapped_generate(
			instruction, instruction_length, trace, context_cpu, &code,
			&next_instruction_address, test_unused);

	ip_set(context_rreil, context_cpu, next_instruction_address);

	printf("------------------\n");
	context_x86_print(context_rreil);

	enum simulator_error simulation_error = simulator_statements_simulate(
			context_rreil, statements);
	if(simulation_error != SIMULATOR_ERROR_NONE) {
		result.type = TESTER_RTYPE_SIMULATION_ERROR;
		result.simulator_error = simulation_error;
		goto cu_a;
	}

	struct execution_result execution_result = executor_instruction_execute(
			instruction, instruction_length, trace, context_cpu, code, tbgen_result);
	if(execution_result.type != EXECUTION_RTYPE_SUCCESS) {
		result.type = TESTER_RTYPE_EXECUTION_ERROR;
		result.execution_result = execution_result;
		goto cu_a;
	}

//	tester_rflags_clean(context_cpu);

	printf("------------------\n");
	printf("CPU:\n");
	context_x86_print(context_cpu);
	printf("Rreil simulator:\n");
	context_x86_print(context_rreil);

	printf("------------------\n");
//	if(!retval) {
	char retval = context_compare_print(trace, context_cpu, context_rreil,
			test_unused);
	if(retval)
		result.type = TESTER_RTYPE_COMPARISON_ERROR;
//	} else
//		printf(
//				"Comparison skipped because of the failure to execute the test function.\n");

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

static struct tester_result tester_forked_test_translated(char fork_,
		struct rreil_statements *statements, uint8_t *instruction,
		size_t instruction_length, char test_unused) {
	struct tester_result result;
	if(fork_) {
		struct tester_result *translated_result = mmap(NULL,
				sizeof(enum tester_result_type), PROT_READ | PROT_WRITE,
				MAP_SHARED | MAP_ANONYMOUS, 0, 0);
		translated_result->type = TESTER_RTYPE_CRASH;

		pid_t pid = fork();
		if(!pid) {
			*translated_result = tester_test_translated(statements, instruction,
					instruction_length, test_unused);
			exit(0);
		} else
			waitpid(pid, NULL, 0);
		result = *translated_result;
		munmap(translated_result, sizeof(enum tester_result_type));
	} else
		result = tester_test_translated(statements, instruction, instruction_length,
				test_unused);

	return result;
}

struct tester_result tester_test_binary(void (*name)(char *), char fork_,
		uint8_t *data, size_t data_size, char test_unused) {
	struct tester_result result;
	result.type = TESTER_RTYPE_SUCCESS;

	state_t state = gdsl_init();
	gdsl_set_code(state, (char*)data, data_size, 0);

	obj_t insn;
	int_t features;
	if(gdwrap_decode(state, &insn)) {
		printf("Decode failed\n");
		fflush(stderr);
		fflush(stdout);
		result.type = TESTER_RTYPE_DECODING_ERROR;
		goto cu;
	}

	printf("Instruction bytes:");
	for(size_t i = 0; i < data_size; ++i)
		printf(" %02x", (int)(data[i]) & 0xff);
	printf("\n");

	fflush(stdout);
	data_size = gdsl_get_ip_offset(state);
	features = gdsl_features_get(state, insn);

	char *str = gdwrap_x86_pretty(state, insn, GDSL_X86_PRINT_MODE_FULL);
	if(str)
		puts(str);
	else
		printf("NULL\n");
//	free(str);

	str = gdwrap_x86_pretty(state, insn, GDSL_X86_PRINT_MODE_SIMPLE);
	if(str) {
		puts(str);
		if(name)
			name(str);
	} else
		printf("NULL\n");
//	free(str);

	printf("---------------------------\n");

	obj_t rreil;
	if(gdwrap_translate(state, &rreil, insn)) {
		printf("Translate failed\n");
		fflush(stderr);
		fflush(stdout);
		result.type = TESTER_RTYPE_TRANSLATION_ERROR;
		goto cu;
	}

	struct gdrr_config *config = rreil_gdrr_builder_config_get(state);
	struct rreil_statements *statements = (struct rreil_statements*)gdrr_convert(
			rreil, config);
	free(config);

	result = tester_forked_test_translated(fork_, statements, data, data_size,
			test_unused);

	rreil_statements_free(statements);

	cu: ;

	gdsl_destroy(state);

	result.features = features;
	return result;
}

void tester_result_type_print(enum tester_result_type result_type) {
	switch(result_type) {
		case TESTER_RTYPE_SUCCESS: {
			printf("TESTER_RESULT_SUCCESS");
			break;
		}
		case TESTER_RTYPE_DECODING_ERROR: {
			printf("TESTER_RESULT_DECODING_ERROR");
			break;
		}
		case TESTER_RTYPE_TRANSLATION_ERROR: {
			printf("TESTER_RESULT_TRANSLATION_ERROR");
			break;
		}
		case TESTER_RTYPE_SIMULATION_ERROR: {
			printf("TESTER_RESULT_SIMULATION_ERROR");
			break;
		}
		case TESTER_RTYPE_EXECUTION_ERROR: {
			printf("TESTER_RESULT_EXECUTION_ERROR");
			break;
		}
		case TESTER_RTYPE_COMPARISON_ERROR: {
			printf("TESTER_RESULT_COMPARISON_ERROR");
			break;
		}
		case TESTER_RTYPE_CRASH: {
			printf("TESTER_RESULT_CRASH");
			break;
		}
	}
}
