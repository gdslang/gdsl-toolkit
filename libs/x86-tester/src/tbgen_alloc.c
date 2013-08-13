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
#include <tbgen.h>
#include <tbgen_alloc.h>

void tbgen_allocated_push_generate(FILE *stream,
		struct tbgen_register_allocation *allocation, enum x86_id register_) {
	if(allocation->sp_allocated) {
//		tbgen_mov_standard_old_register_generate(stream, X86_ID_SP,
//				allocation->sp_mirror);
//		tbgen_mov_standard_old_register_generate(stream, allocation->sp_backup,
//				X86_ID_SP);
		tbgen_xchg_rsp_generate(stream, allocation->sp_backup);
	}
	if(register_ == X86_ID_FLAGS)
		tbgen_push_rflags_generate(stream);
	else
		tbgen_push_generate(stream, register_);
	if(allocation->sp_allocated) {
//		tbgen_mov_standard_old_register_generate(stream, X86_ID_SP,
//				allocation->sp_backup);
//		tbgen_mov_standard_old_register_generate(stream, allocation->sp_mirror,
//				X86_ID_SP);
		tbgen_xchg_rsp_generate(stream, allocation->sp_backup);
	}
}

void tbgen_allocated_pop_generate(FILE *stream,
		struct tbgen_register_allocation *allocation, enum x86_id register_) {
	if(allocation->sp_allocated) {
//		tbgen_mov_standard_old_register_generate(stream, X86_ID_SP,
//				allocation->sp_mirror);
//		tbgen_mov_standard_old_register_generate(stream, allocation->sp_backup,
//				X86_ID_SP);
		tbgen_xchg_rsp_generate(stream, allocation->sp_backup);
	}
	if(register_ == X86_ID_FLAGS)
		tbgen_pop_rflags_generate(stream);
	else
		tbgen_pop_generate(stream, register_);
	if(allocation->sp_allocated) {
//		tbgen_mov_standard_old_register_generate(stream, X86_ID_SP,
//				allocation->sp_backup);
//		tbgen_mov_standard_old_register_generate(stream, allocation->sp_mirror,
//				X86_ID_SP);
		tbgen_xchg_rsp_generate(stream, allocation->sp_backup);
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

char tbgen_allocate_dynamic(enum x86_id *result,
		struct tbgen_register_allocation *allocation, FILE *stream) {
	enum x86_id reg = X86_ID_R8;
	/*
	 * Todo: Dynamically allocate stack pointer
	 */
	char next() {
		switch(reg) {
			case X86_ID_AX:
			case X86_ID_BX:
			case X86_ID_CX:
			case X86_ID_DX:
			case X86_ID_SI:
			case X86_ID_R8:
			case X86_ID_R9:
			case X86_ID_R10:
			case X86_ID_R11:
			case X86_ID_R12:
			case X86_ID_R13:
			case X86_ID_R14: {
				reg++;
				break;
			}
			case X86_ID_R15: {
				reg = X86_ID_AX;
				break;
			}
			case X86_ID_DI: {
				reg = X86_ID_BP;
				break;
			}
			default: {
				return 1;
			}
		}
		return 0;
	}
	start: for(size_t i = 0; i < allocation->registers_length; ++i)
		if(allocation->registers[i] == reg) {
			if(next())
				return 1;
			goto start;
		}
	util_array_generic_add((void**)&allocation->registers, &reg, sizeof(reg),
			&allocation->registers_length, &allocation->registers_size);
	tbgen_allocated_push_generate(stream, allocation, reg);
	*result = reg;
	return 0;
}

void tbgen_allocation_fixed_commit(struct tbgen_register_allocation *allocation,
		FILE *stream) {
	for(size_t i = 0; i < allocation->registers_length; ++i)
		if(allocation->registers[i] == X86_ID_FLAGS)
			tbgen_push_rflags_generate(stream);
		else
			tbgen_push_generate(stream, allocation->registers[i]);
	if(allocation->sp_allocated) {
		/*
		 * Todo: Not aesthetic :-(
		 */
		allocation->sp_allocated = 0;
		tbgen_allocate_dynamic(&allocation->sp_backup, allocation, stream);
//		tbgen_allocate_dynamic(&allocation->sp_mirror, allocation, stream);
		tbgen_mov_standard_old_register_generate(stream, X86_ID_SP,
				allocation->sp_backup);
		allocation->sp_allocated = 1;
	}
}

void tbgen_allocation_registers_free(
		struct tbgen_register_allocation *allocation, FILE *stream) {
	if(allocation->sp_allocated)
		tbgen_mov_standard_old_register_generate(stream, allocation->sp_backup,
				X86_ID_SP);
	for(size_t i = allocation->registers_length; i > 0; --i)
		if(allocation->registers[i - 1] == X86_ID_FLAGS)
			tbgen_pop_rflags_generate(stream);
		else
			tbgen_pop_generate(stream, allocation->registers[i - 1]);
}

void tbgen_allocation_free(struct tbgen_register_allocation *allocation) {
	if(allocation) {
		free(allocation->registers);
		free(allocation);
	}
}
