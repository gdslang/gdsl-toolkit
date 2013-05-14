/*
 * tester.c
 *
 *  Created on: 13.05.2013
 *      Author: jucs
 */

#define _GNU_SOURCE
#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <simulator.h>
#include <simulator_tracking.h>
#include <rreil/rreil.h>

static uint8_t tester_register_to_binary(enum rreil_id_x86 register_) {
	switch(register_) {
		case RREIL_ID_X86_R8:
		case RREIL_ID_X86_AX: {
			return 0b000;
		}
		case RREIL_ID_X86_R9:
		case RREIL_ID_X86_CX: {
			return 0b001;
		}
		case RREIL_ID_X86_DX: {
			return 0b010;
		}
		case RREIL_ID_X86_BX: {
			return 0b011;
		}
		case RREIL_ID_X86_SP: {
			return 0b100;
		}
		case RREIL_ID_X86_BP: {
			return 0b101;
		}
		case RREIL_ID_X86_SI: {
			return 0b110;
		}
		case RREIL_ID_X86_DI: {
			return 0b111;
		}
		default:
			return 0;
	}
}

static void tester_push_pop_rex_generate(FILE *stream,
		enum rreil_id_x86 register_) {
	switch(register_) {
		case RREIL_ID_X86_R8:
		case RREIL_ID_X86_R9:
		case RREIL_ID_X86_R10:
		case RREIL_ID_X86_R11:
		case RREIL_ID_X86_R12:
		case RREIL_ID_X86_R13:
		case RREIL_ID_X86_R14:
		case RREIL_ID_X86_R15: {
			uint8_t rex = 0x41;
			fwrite(&rex, 1, sizeof(rex), stream);
			break;
		}
		default:
			break;
	}
}

static void tester_push_generate(FILE *stream, enum rreil_id_x86 register_) {
	tester_push_pop_rex_generate(stream, register_);
	uint8_t push[] = { 0x50 + tester_register_to_binary(register_) };
	fwrite(push, 1, sizeof(push), stream);
}

static void tester_push_rflags_generate(FILE *stream) {
	uint8_t pushfq[] = { 0x9c };
	fwrite(pushfq, 1, sizeof(pushfq), stream);
}

static void tester_pop_generate(FILE *stream, enum rreil_id_x86 register_) {
	tester_push_pop_rex_generate(stream, register_);
	uint8_t pop[] = { 0x58 + tester_register_to_binary(register_) };
	fwrite(pop, 1, sizeof(pop), stream);
}

static void tester_pop_rflags_generate(FILE *stream) {
	uint8_t popfq[] = { 0x48, 0x9d };
	fwrite(popfq, 1, sizeof(popfq), stream);
}

static void tester_mov_memory_to_register_generate(FILE *stream,
		enum rreil_id_x86 register_, uint64_t *address) {
	// mov r8, address
	uint8_t mov_r8_address[] = { 0x49, 0xb8 };
	fwrite(mov_r8_address, 1, sizeof(mov_r8_address), stream);
	fwrite(address, 8, 1, stream);

	// mov register, [r8]
	uint8_t mov_reg_dr8[] = { 0x49, 0x8b, tester_register_to_binary(register_)
			<< 3 };
	fwrite(mov_reg_dr8, 1, sizeof(mov_reg_dr8), stream);
}

static void tester_mov_memory_to_rflags_generate(FILE *stream,
		uint64_t *address) {
	// mov r8, address
	uint8_t mov_r8_address[] = { 0x49, 0xb8 };
	fwrite(mov_r8_address, 1, sizeof(mov_r8_address), stream);
	fwrite(address, 8, 1, stream);

	// mov r8, [r8]
	uint8_t mov_r8_dr8[] = { 0x4d, 0x8b, 0x00 };
	fwrite(mov_r8_dr8, 1, sizeof(mov_r8_dr8), stream);

	// push r8
	uint8_t push_r8[] = { 0x41, 0x50 };
	fwrite(push_r8, 1, sizeof(push_r8), stream);

	tester_pop_rflags_generate(stream);
}

static void tester_mov_register_to_memory_generate(FILE *stream,
		enum rreil_id_x86 register_, uint64_t *address) {
	// mov r8, address
	uint8_t mov_r8_address[] = { 0x49, 0xb8 };
	fwrite(mov_r8_address, 1, sizeof(mov_r8_address), stream);
	fwrite(address, 8, 1, stream);

	// mov [r8], register
	uint8_t mov_dr8_reg[] = { 0x49, 0x89, tester_register_to_binary(register_)
			<< 3 };
	fwrite(mov_dr8_reg, 1, sizeof(mov_dr8_reg), stream);
}

static void tester_mov_rflags_to_memory_generate(FILE *stream,
		uint64_t *address) {
	tester_push_rflags_generate(stream);

	// pop r9
	uint8_t pop_r9[] = { 0x41, 0x59 };
	fwrite(pop_r9, 1, sizeof(pop_r9), stream);

	// mov r8, address
	uint8_t mov_r8_address[] = { 0x49, 0xb8 };
	fwrite(mov_r8_address, 1, sizeof(mov_r8_address), stream);
	fwrite(address, 8, 1, stream);

	// mov [r8], r9
	uint8_t mov_dr8_r9[] = { 0x4d, 0x89, 0x08 };
	fwrite(mov_dr8_r9, 1, sizeof(mov_dr8_r9), stream);
}

static void tester_registers_backup(FILE *stream, struct simulator_trace *trace) {
	void access_handle(struct register_access *access) {
		for(size_t i = 0; i < access->indices_length; ++i) {
			enum rreil_id_x86 reg = (enum rreil_id_x86)access->indices[i];
			if(reg == RREIL_ID_X86_FLAGS)
				continue;
			tester_push_generate(stream, reg);
		}
	}

	access_handle(&trace->read);
	access_handle(&trace->written);
}

static void tester_registers_restore(FILE *stream,
		struct simulator_trace *trace) {
	void access_handle(struct register_access *access) {
		for(size_t i = access->indices_length; i > 0; --i) {
			enum rreil_id_x86 reg = (enum rreil_id_x86)access->indices[i - 1];
			if(reg == RREIL_ID_X86_FLAGS)
				continue;
			tester_pop_generate(stream, reg);
		}
	}

	access_handle(&trace->written);
	access_handle(&trace->read);
}

void tester_header_generate(FILE *stream) {
}

void tester_trailer_generate(FILE *stream) {
	uint8_t retq[] = { 0xc3 };

	fwrite(retq, 1, sizeof(retq), stream);
}

size_t tester_code_generate(uint8_t **buffer, uint8_t *instruction,
		size_t instruction_length, struct simulator_trace *trace,
		struct simulator_context *context) {
	size_t size;

	FILE *stream = open_memstream((char**)buffer, &size);

	tester_header_generate(stream);

	tester_registers_backup(stream, trace);
	tester_push_generate(stream, RREIL_ID_X86_R8);
	tester_push_generate(stream, RREIL_ID_X86_R9);
	tester_push_rflags_generate(stream);

	for(size_t i = 0; i < trace->read.indices_length; ++i) {
		size_t index = trace->read.indices[i];
		enum rreil_id_x86 reg = (enum rreil_id_x86)index;
		if(reg == RREIL_ID_X86_FLAGS)
			tester_mov_memory_to_rflags_generate(stream,
					(uint64_t*)&context->x86_registers[index].data);
		else
			tester_mov_memory_to_register_generate(stream, reg,
					(uint64_t*)&context->x86_registers[index].data);
	}

	fwrite(instruction, 1, instruction_length, stream);

	for(size_t i = 0; i < trace->written.indices_length; ++i) {
		size_t index = trace->written.indices[i];
		enum rreil_id_x86 reg = (enum rreil_id_x86)index;
		if(reg == RREIL_ID_X86_FLAGS)
			tester_mov_rflags_to_memory_generate(stream,
					(uint64_t*)&context->x86_registers[index].data);
		else
			tester_mov_register_to_memory_generate(stream, reg,
					(uint64_t*)&context->x86_registers[index].data);
	}

	tester_pop_rflags_generate(stream);
	tester_pop_generate(stream, RREIL_ID_X86_R9);
	tester_pop_generate(stream, RREIL_ID_X86_R8);
	tester_registers_restore(stream, trace);

	tester_trailer_generate(stream);

	fclose(stream);
	return size;
}
