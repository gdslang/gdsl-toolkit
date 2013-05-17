/*
 * tbgen_alloc.c
 *
 *  Created on: 17.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <util.h>
#include "tbgen.h"
#include "tbgen_alloc.h"

void tbgen_allocated_push_generate(FILE *stream,
		struct tbgen_register_allocation *allocation, enum x86_id register_) {
	if(allocation->sp_allocated) {
		tbgen_mov_standard_old_register_generate(stream, X86_ID_SP, allocation->sp_mirror);
		tbgen_mov_standard_old_register_generate(stream, allocation->sp_backup, X86_ID_SP);
	}
	if(register_ == X86_ID_FLAGS)
		tbgen_push_rflags_generate(stream);
	else
		tbgen_push_generate(stream, register_);
	if(allocation->sp_allocated) {
		tbgen_mov_standard_old_register_generate(stream, X86_ID_SP, allocation->sp_backup);
		tbgen_mov_standard_old_register_generate(stream, allocation->sp_mirror, X86_ID_SP);
	}
}

void tbgen_allocated_pop_generate(FILE *stream,
		struct tbgen_register_allocation *allocation, enum x86_id register_) {
	if(allocation->sp_allocated) {
		tbgen_mov_standard_old_register_generate(stream, X86_ID_SP, allocation->sp_mirror);
		tbgen_mov_standard_old_register_generate(stream, allocation->sp_backup, X86_ID_SP);
	}
	if(register_ == X86_ID_FLAGS)
		tbgen_pop_rflags_generate(stream);
	else
		tbgen_pop_generate(stream, register_);
	if(allocation->sp_allocated) {
		tbgen_mov_standard_old_register_generate(stream, X86_ID_SP, allocation->sp_backup);
		tbgen_mov_standard_old_register_generate(stream, allocation->sp_mirror, X86_ID_SP);
	}
}

struct tbgen_register_allocation *tbgen_allocation_init() {
	struct tbgen_register_allocation *allocation =
			(struct tbgen_register_allocation*)malloc(
					sizeof(struct tbgen_register_allocation));
	allocation->registers = NULL;
	allocation->registers_length = 0;
	allocation->registers_size = 0;

	allocation->sp_allocated = 0;

	return allocation;
}

void tbgen_allocate_fixed(struct tbgen_register_allocation *allocation,
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

enum x86_id tbgen_allocate_dynamic(
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
	tbgen_allocated_push_generate(stream, allocation, reg);
	return reg;
}

void tbgen_allocation_fixed_commit(struct tbgen_register_allocation *allocation,
		FILE *stream) {
	for(size_t i = 0; i < allocation->registers_length; ++i)
		tbgen_push_generate(stream, allocation->registers[i]);
	if(allocation->sp_allocated) {
		/*
		 * Todo: Not aesthetic :-(
		 */
		allocation->sp_allocated = 0;
		allocation->sp_backup = tbgen_allocate_dynamic(allocation, stream);
		allocation->sp_mirror = tbgen_allocate_dynamic(allocation, stream);
		tbgen_mov_standard_old_register_generate(stream, X86_ID_SP, allocation->sp_backup);
		allocation->sp_allocated = 1;
	}
}

void tbgen_allocation_registers_free(struct tbgen_register_allocation *allocation,
		FILE *stream) {
	if(allocation->sp_allocated)
		tbgen_mov_standard_old_register_generate(stream, allocation->sp_backup, X86_ID_SP);
	for(size_t i = allocation->registers_length; i > 0; --i)
		tbgen_pop_generate(stream, allocation->registers[i - 1]);
}

void tbgen_allocation_free(
		struct tbgen_register_allocation *allocation) {
	if(allocation) {
		free(allocation->registers);
		free(allocation);
	}
}
