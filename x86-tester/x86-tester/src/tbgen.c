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
#include <simulator/simulator.h>
#include <simulator/tracking.h>
#include <rreil/rreil.h>
#include <util.h>

static uint8_t tbgen_register_to_binary(enum x86_id register_) {
	switch(register_) {
		case X86_ID_R8:
		case X86_ID_AX: {
			return 0b000;
		}
		case X86_ID_R9:
		case X86_ID_CX: {
			return 0b001;
		}
		case X86_ID_R10:
		case X86_ID_DX: {
			return 0b010;
		}
		case X86_ID_R11:
		case X86_ID_BX: {
			return 0b011;
		}
		case X86_ID_R12:
		case X86_ID_SP: {
			return 0b100;
		}
		case X86_ID_R13:
		case X86_ID_BP: {
			return 0b101;
		}
		case X86_ID_R14:
		case X86_ID_SI: {
			return 0b110;
		}
		case X86_ID_R15:
		case X86_ID_DI: {
			return 0b111;
		}
		default:
			return 0;
	}
}

static void tbgen_push_pop_rex_generate(FILE *stream, enum x86_id register_) {
	switch(register_) {
		case X86_ID_R8:
		case X86_ID_R9:
		case X86_ID_R10:
		case X86_ID_R11:
		case X86_ID_R12:
		case X86_ID_R13:
		case X86_ID_R14:
		case X86_ID_R15: {
			uint8_t rex = 0x41;
			fwrite(&rex, 1, sizeof(rex), stream);
			break;
		}
		default:
			break;
	}
}

static void tbgen_push_generate(FILE *stream, enum x86_id register_) {
	tbgen_push_pop_rex_generate(stream, register_);
	uint8_t push[] = { 0x50 + tbgen_register_to_binary(register_) };
	fwrite(push, 1, sizeof(push), stream);
}

static void tbgen_mov_generate(FILE *stream, enum x86_id from, enum x86_id to) {
	uint8_t mov[] = { 0x48, 0x89, tbgen_register_to_binary(to)
			| (tbgen_register_to_binary(from) << 3) };
	fwrite(mov, 1, sizeof(mov), stream);
}

struct tbgen_register_allocation {
	enum x86_id *registers;
	size_t registers_length;
	size_t registers_size;

	char sp_allocated;
	enum x86_id sp_backup;
	enum x86_id sp_mirror;
};

static struct tbgen_register_allocation *tbgen_register_allocation_init() {
	struct tbgen_register_allocation *allocation =
			(struct tbgen_register_allocation*)malloc(
					sizeof(struct tbgen_register_allocation));
	allocation->registers = NULL;
	allocation->registers_length = 0;
	allocation->registers_size = 0;

	allocation->sp_allocated = 0;
}

static void tbgen_allocate_fixed(struct tbgen_register_allocation *allocation,
		enum x86_id reg) {
	if(reg == X86_ID_SP) {
		allocation->sp_allocated = 1;
		return;
	}
	for(size_t i = 0; i < allocation->registers_length; ++i)
		if(allocation->registers[i] == reg)
			return;
	util_array_generic_add((void**)&allocation->registers, &reg, sizeof(reg),
			&allocation->registers_length, &allocation->registers_size);
}

static enum x86_id tbgen_allocate_dynamic(
		struct tbgen_register_allocation *allocation, FILE *stream) {
	enum x86_id reg = X86_ID_R8;
	next: if(reg == X86_ID_R15)
		return 0; //Todo: Handle error
	for(size_t i = 0; i < allocation->registers_length; ++i)
		if(allocation->registers[i] == reg) {
			reg++;
			goto next;
		}
	util_array_generic_add((void**)&allocation->registers, &reg, sizeof(reg),
			&allocation->registers_length, &allocation->registers_size);
	if(allocation->sp_allocated) {
		tbgen_mov_generate(stream, X86_ID_SP, allocation->sp_mirror);
		tbgen_mov_generate(stream, allocation->sp_backup, X86_ID_SP);
	}
	tbgen_push_generate(stream, reg);
	if(allocation->sp_allocated) {
		tbgen_mov_generate(stream, X86_ID_SP, allocation->sp_backup);
		tbgen_mov_generate(stream, allocation->sp_mirror, X86_ID_SP);
	}
}

static void tbgen_fixed_commit(struct tbgen_register_allocation *allocation,
		FILE *stream) {
	for(size_t i = 0; i < allocation->registers_length; ++i)
		tbgen_push_generate(stream, allocation->registers[i]);
	if(allocation->sp_allocated) {
		allocation->sp_backup = tbgen_allocate_dynamic(allocation, stream);
		allocation->sp_mirror = tbgen_allocate_dynamic(allocation, stream);
		tbgen_mov_generate(stream, X86_ID_SP, allocation->sp_backup);
	}
}

static void tbgen_registers_free(struct tbgen_register_allocation *allocation,
		FILE *stream) {

}

static void tbgen_register_allocation_free(
		struct tbgen_register_allocation *allocation) {

}

static static void tbgen_push_rflags_generate(FILE *stream) {
	uint8_t pushfq[] = { 0x9c };
	fwrite(pushfq, 1, sizeof(pushfq), stream);
}

static void tbgen_pop_generate(FILE *stream, enum x86_id register_) {
	tbgen_push_pop_rex_generate(stream, register_);
	uint8_t pop[] = { 0x58 + tbgen_register_to_binary(register_) };
	fwrite(pop, 1, sizeof(pop), stream);
}

static void tbgen_pop_rflags_generate(FILE *stream) {
	uint8_t popfq[] = { 0x48, 0x9d };
	fwrite(popfq, 1, sizeof(popfq), stream);
}

static void tbgen_mov_memory_to_register_generate(FILE *stream,
		enum x86_id register_, uint64_t *address) {
	// mov r8, address
	uint8_t mov_r8_address[] = { 0x49, 0xb8 };
	fwrite(mov_r8_address, 1, sizeof(mov_r8_address), stream);
	fwrite(address, 8, 1, stream);

	// mov register, [r8]
	uint8_t mov_reg_dr8[] =
			{ 0x49, 0x8b, tbgen_register_to_binary(register_) << 3 };
	fwrite(mov_reg_dr8, 1, sizeof(mov_reg_dr8), stream);
}

static void tbgen_mov_memory_to_rflags_generate(FILE *stream, uint64_t *address) {
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

	tbgen_pop_rflags_generate(stream);
}

static void tbgen_mov_register_to_memory_generate(FILE *stream,
		enum x86_id register_, uint64_t *address) {
	// mov r8, address
	uint8_t mov_r8_address[] = { 0x49, 0xb8 };
	fwrite(mov_r8_address, 1, sizeof(mov_r8_address), stream);
	fwrite(address, 8, 1, stream);

	// mov [r8], register
	uint8_t mov_dr8_reg[] =
			{ 0x49, 0x89, tbgen_register_to_binary(register_) << 3 };
	fwrite(mov_dr8_reg, 1, sizeof(mov_dr8_reg), stream);
}

static void tbgen_mov_rflags_to_memory_generate(FILE *stream, uint64_t *address) {
	tbgen_push_rflags_generate(stream);

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

static void tbgen_registers_backup(FILE *stream, struct simulator_trace *trace) {
	void access_handle(struct register_access *access) {
		for(size_t i = 0; i < access->indices_length; ++i) {
			enum x86_id reg = (enum x86_id)access->indices[i];
			if(reg == X86_ID_FLAGS)
				continue;
			tbgen_push_generate(stream, reg);
		}
	}

	access_handle(&trace->read);
	access_handle(&trace->written);
}

static void tbgen_registers_restore(FILE *stream, struct simulator_trace *trace) {
	void access_handle(struct register_access *access) {
		for(size_t i = access->indices_length; i > 0; --i) {
			enum x86_id reg = (enum x86_id)access->indices[i - 1];
			if(reg == X86_ID_FLAGS)
				continue;
			tbgen_pop_generate(stream, reg);
		}
	}

	access_handle(&trace->written);
	access_handle(&trace->read);
}

void tbgen_header_generate(FILE *stream) {
}

void tbgen_trailer_generate(FILE *stream) {
	uint8_t retq[] = { 0xc3 };

	fwrite(retq, 1, sizeof(retq), stream);
}

size_t tbgen_code_generate(uint8_t **buffer, uint8_t *instruction,
		size_t instruction_length, struct simulator_trace *trace,
		struct context *context) {
	size_t size;

	FILE *stream = open_memstream((char**)buffer, &size);

	tbgen_header_generate(stream);

	tbgen_registers_backup(stream, trace);
	tbgen_push_generate(stream, X86_ID_R8);
	tbgen_push_generate(stream, X86_ID_R9);
	tbgen_push_rflags_generate(stream);

	for(size_t i = 0; i < trace->read.indices_length; ++i) {
		size_t index = trace->read.indices[i];
		enum x86_id reg = (enum x86_id)index;
		if(reg == X86_ID_FLAGS)
			tbgen_mov_memory_to_rflags_generate(stream,
					(uint64_t*)&context->x86_registers[index].data);
		else
			tbgen_mov_memory_to_register_generate(stream, reg,
					(uint64_t*)&context->x86_registers[index].data);
	}

	fwrite(instruction, 1, instruction_length, stream);

	for(size_t i = 0; i < trace->written.indices_length; ++i) {
		size_t index = trace->written.indices[i];
		enum x86_id reg = (enum x86_id)index;
		if(reg == X86_ID_FLAGS)
			tbgen_mov_rflags_to_memory_generate(stream,
					(uint64_t*)&context->x86_registers[index].data);
		else
			tbgen_mov_register_to_memory_generate(stream, reg,
					(uint64_t*)&context->x86_registers[index].data);
	}

	tbgen_pop_rflags_generate(stream);
	tbgen_pop_generate(stream, X86_ID_R9);
	tbgen_pop_generate(stream, X86_ID_R8);
	tbgen_registers_restore(stream, trace);

	tbgen_trailer_generate(stream);

	fclose(stream);
	return size;
}
