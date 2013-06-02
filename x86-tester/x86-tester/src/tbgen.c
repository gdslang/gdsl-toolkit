/*
 * tbgen.c
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
#include <tbgen.h>
#include <tbgen_alloc.h>

static uint8_t tbgen_register_to_binary(enum x86_id register_) {
	switch(register_) {
		case X86_ID_XMM8:
		case X86_ID_XMM0:
		case X86_ID_MM0:
		case X86_ID_R8:
		case X86_ID_AX: {
			return 0b000;
		}
		case X86_ID_XMM9:
		case X86_ID_XMM1:
		case X86_ID_MM1:
		case X86_ID_R9:
		case X86_ID_CX: {
			return 0b001;
		}
		case X86_ID_XMM10:
		case X86_ID_XMM2:
		case X86_ID_MM2:
		case X86_ID_R10:
		case X86_ID_DX: {
			return 0b010;
		}
		case X86_ID_XMM11:
		case X86_ID_XMM3:
		case X86_ID_MM3:
		case X86_ID_R11:
		case X86_ID_BX: {
			return 0b011;
		}
		case X86_ID_XMM12:
		case X86_ID_XMM4:
		case X86_ID_MM4:
		case X86_ID_R12:
		case X86_ID_SP: {
			return 0b100;
		}
		case X86_ID_XMM13:
		case X86_ID_XMM5:
		case X86_ID_MM5:
		case X86_ID_R13:
		case X86_ID_BP: {
			return 0b101;
		}
		case X86_ID_XMM14:
		case X86_ID_XMM6:
		case X86_ID_MM6:
		case X86_ID_R14:
		case X86_ID_SI: {
			return 0b110;
		}
		case X86_ID_XMM15:
		case X86_ID_XMM7:
		case X86_ID_MM7:
		case X86_ID_R15:
		case X86_ID_DI: {
			return 0b111;
		}
		default:
			return 0;
	}
}

/*
 * Todo: Hacky...
 */
static void tbgen_rex_generic_generate(FILE *stream, uint8_t rex_flags,
		enum x86_id register_) {
	uint8_t rex = 0x40 | (rex_flags & X86_REX_W);
	switch(register_) {
		case X86_ID_XMM8:
		case X86_ID_XMM9:
		case X86_ID_XMM10:
		case X86_ID_XMM11:
		case X86_ID_XMM12:
		case X86_ID_XMM13:
		case X86_ID_XMM14:
		case X86_ID_XMM15:
		case X86_ID_R8:
		case X86_ID_R9:
		case X86_ID_R10:
		case X86_ID_R11:
		case X86_ID_R12:
		case X86_ID_R13:
		case X86_ID_R14:
		case X86_ID_R15: {
			rex |= (rex_flags & X86_REX_R);
			rex |= (rex_flags & X86_REX_X);
			rex |= (rex_flags & X86_REX_B);
			break;
		}
		default:
			break;
	}
	if(rex != 0x40)
		fwrite(&rex, 1, sizeof(rex), stream);
}

/*
 * Todo: Hacky...
 */
static void tbgen_rex_rb_generate(FILE *stream, enum x86_rex w, enum x86_id r,
		enum x86_id b) {
	uint8_t rex = 0x40 | w;
	switch(r) {
		case X86_ID_XMM8:
		case X86_ID_XMM9:
		case X86_ID_XMM10:
		case X86_ID_XMM11:
		case X86_ID_XMM12:
		case X86_ID_XMM13:
		case X86_ID_XMM14:
		case X86_ID_XMM15:
		case X86_ID_R8:
		case X86_ID_R9:
		case X86_ID_R10:
		case X86_ID_R11:
		case X86_ID_R12:
		case X86_ID_R13:
		case X86_ID_R14:
		case X86_ID_R15: {
			rex |= X86_REX_R;
			break;
		}
		default:
			break;
	}
	switch(b) {
		case X86_ID_XMM8:
		case X86_ID_XMM9:
		case X86_ID_XMM10:
		case X86_ID_XMM11:
		case X86_ID_XMM12:
		case X86_ID_XMM13:
		case X86_ID_XMM14:
		case X86_ID_XMM15:
		case X86_ID_R8:
		case X86_ID_R9:
		case X86_ID_R10:
		case X86_ID_R11:
		case X86_ID_R12:
		case X86_ID_R13:
		case X86_ID_R14:
		case X86_ID_R15: {
			rex |= X86_REX_B;
			break;
		}
		default:
			break;
	}
	if(rex != 0x40)
		fwrite(&rex, 1, sizeof(rex), stream);
}

static void tbgen_modrm_ra_generate(FILE *stream, uint8_t reg, uint8_t addr) {
	uint8_t modrm = reg << 3 | addr;
	switch(addr) {
		case 0b100: {
			uint8_t sib = 0x24;
			fwrite(&modrm, 1, sizeof(modrm), stream);
			fwrite(&sib, 1, sizeof(sib), stream);
			break;
		}
		case 0b101: {
			modrm |= 0x40;
			uint8_t zero = 0;
			fwrite(&modrm, 1, sizeof(modrm), stream);
			fwrite(&zero, 1, sizeof(zero), stream);
			break;
		}
		default: {
			fwrite(&modrm, 1, sizeof(modrm), stream);
			break;
		}
	}
}

void tbgen_push_generate(FILE *stream, enum x86_id register_) {
	uint8_t reg_bin = tbgen_register_to_binary(register_);
	switch(x86_id_type_get(register_)) {
		case X86_ID_TYPE_STANDARD: {
			tbgen_rex_generic_generate(stream, X86_REX_B, register_);
			uint8_t push[] = { 0x50 + reg_bin };
			fwrite(push, 1, sizeof(push), stream);
			break;
		}
		case X86_ID_TYPE_MMX: {
			// sub rsp, 8
			uint8_t sub[] = { 0x48, 0x83, 0xec, 0x08 };
			fwrite(sub, 1, sizeof(sub), stream);

			// movq [rsp], register
			uint8_t movq[] = { 0x0f, 0x7f };
			fwrite(movq, 1, sizeof(movq), stream);
			tbgen_modrm_ra_generate(stream, reg_bin,
					tbgen_register_to_binary(X86_ID_SP));
			break;
		}
		case X86_ID_TYPE_SSE: {
			// sub rsp, 16
			uint8_t sub[] = { 0x48, 0x83, 0xec, 0x10 };
			fwrite(sub, 1, sizeof(sub), stream);

			// movupd [rsp], register
			uint8_t prefix = 0x66;
			fwrite(&prefix, 1, sizeof(prefix), stream);
			tbgen_rex_generic_generate(stream, X86_REX_R, register_);
			uint8_t movupd[] = { 0x0f, 0x11 };
			fwrite(movupd, 1, sizeof(movupd), stream);
			tbgen_modrm_ra_generate(stream, reg_bin,
					tbgen_register_to_binary(X86_ID_SP));
			break;
		}
	}
}

void tbgen_pop_generate(FILE *stream, enum x86_id register_) {
	uint8_t reg_bin = tbgen_register_to_binary(register_);
	switch(x86_id_type_get(register_)) {
		case X86_ID_TYPE_STANDARD: {
			tbgen_rex_generic_generate(stream, X86_REX_B, register_);
			uint8_t pop[] = { 0x58 + tbgen_register_to_binary(register_) };
			fwrite(pop, 1, sizeof(pop), stream);
			break;
		}
		case X86_ID_TYPE_MMX: {
			// movq register, [rsp]
			uint8_t movq[] = { 0x0f, 0x6f };
			fwrite(movq, 1, sizeof(movq), stream);
			tbgen_modrm_ra_generate(stream, reg_bin,
					tbgen_register_to_binary(X86_ID_SP));

			// add rsp, 8
			uint8_t add[] = { 0x48, 0x83, 0xc4, 0x08 };
			fwrite(add, 1, sizeof(add), stream);
			break;
		}
		case X86_ID_TYPE_SSE: {
			// movupd register, [rsp]
			uint8_t prefix = 0x66;
			fwrite(&prefix, 1, sizeof(prefix), stream);
			tbgen_rex_generic_generate(stream, X86_REX_R, register_);
			uint8_t movupd[] = { 0x0f, 0x10 };
			fwrite(movupd, 1, sizeof(movupd), stream);
			tbgen_modrm_ra_generate(stream, reg_bin,
					tbgen_register_to_binary(X86_ID_SP));

			// add rsp, 16
			uint8_t add[] = { 0x48, 0x83, 0xc4, 0x10 };
			fwrite(add, 1, sizeof(add), stream);
			break;
		}
	}
}

void tbgen_push_rflags_generate(FILE *stream) {
	uint8_t pushfq[] = { 0x9c };
	fwrite(pushfq, 1, sizeof(pushfq), stream);
}

void tbgen_pop_rflags_generate(FILE *stream) {
	uint8_t popfq[] = { 0x48, 0x9d };
	fwrite(popfq, 1, sizeof(popfq), stream);
}

void tbgen_mov_standard_old_register_generate(FILE *stream, enum x86_id from,
		enum x86_id to) {
	tbgen_rex_rb_generate(stream, X86_REX_W, from, to);
	uint8_t mov[] = { 0x89, 0xc0 | tbgen_register_to_binary(to)
			| (tbgen_register_to_binary(from) << 3) };
	fwrite(mov, 1, sizeof(mov), stream);
}

static void tbgen_mov_memory_to_register_generate(FILE *stream,
		enum x86_id register_, uint64_t *address, enum x86_id t0) {
	uint8_t t0_bin = tbgen_register_to_binary(t0);
	uint8_t register_bin = tbgen_register_to_binary(register_);

	// mov t0, address
	tbgen_rex_generic_generate(stream, X86_REX_W | X86_REX_B, t0);
	uint8_t mov_t0_address[] = { 0xb8 | t0_bin };
	fwrite(mov_t0_address, 1, sizeof(mov_t0_address), stream);
	fwrite(address, 8, 1, stream);

	switch(x86_id_type_get(register_)) {
		case X86_ID_TYPE_STANDARD: {
			// mov register, [t0]
			tbgen_rex_rb_generate(stream, X86_REX_W, register_, t0);
			uint8_t mov_reg_dt0[] = { 0x8b };
			fwrite(mov_reg_dt0, 1, sizeof(mov_reg_dt0), stream);
			tbgen_modrm_ra_generate(stream, register_bin, t0_bin);
			break;
		}
		case X86_ID_TYPE_MMX: {
			// movq register, [t0]
			tbgen_rex_generic_generate(stream, X86_REX_B, t0);
			uint8_t movq[] = { 0x0f, 0x6f };
			fwrite(movq, 1, sizeof(movq), stream);
			tbgen_modrm_ra_generate(stream, register_bin, t0_bin);
			break;
		}
		case X86_ID_TYPE_SSE: {
			// movupd register, [t0]
			uint8_t prefix = 0x66;
			fwrite(&prefix, 1, sizeof(prefix), stream);
			tbgen_rex_rb_generate(stream, X86_REX_NONE, register_, t0);
			uint8_t movupd[] = { 0x0f, 0x10 };
			fwrite(movupd, 1, sizeof(movupd), stream);
			tbgen_modrm_ra_generate(stream, register_bin, t0_bin);
			break;
		}
	}
}

static void tbgen_mov_memory_to_rflags_generate(FILE *stream, uint64_t *address,
		enum x86_id t0, struct tbgen_register_allocation *allocation) {
	uint8_t t0_bin = tbgen_register_to_binary(t0);

	// mov t0, address
	tbgen_rex_generic_generate(stream, X86_REX_W | X86_REX_B, t0);
	uint8_t mov_t0_address[] = { 0xb8 | t0_bin };
	fwrite(mov_t0_address, 1, sizeof(mov_t0_address), stream);
	fwrite(address, 8, 1, stream);

	// mov t0, [t0]
	tbgen_rex_generic_generate(stream, X86_REX_W | X86_REX_R | X86_REX_B, t0);
	uint8_t mov_t0_dt0[] = { 0x8b };
	fwrite(mov_t0_dt0, 1, sizeof(mov_t0_dt0), stream);
	tbgen_modrm_ra_generate(stream, t0_bin, t0_bin);

	// push t0
	tbgen_allocated_push_generate(stream, allocation, t0);

	// pop RFLAGS
	tbgen_allocated_pop_generate(stream, allocation, X86_ID_FLAGS);
}

static void tbgen_mov_register_to_memory_generate(FILE *stream,
		enum x86_id register_, uint64_t *address, enum x86_id t0) {
	uint8_t t0_bin = tbgen_register_to_binary(t0);
	uint8_t register_bin = tbgen_register_to_binary(register_);

	// mov t0, address
	tbgen_rex_generic_generate(stream, X86_REX_W | X86_REX_B, t0);
	uint8_t mov_t0_address[] = { 0xb8 | t0_bin };
	fwrite(mov_t0_address, 1, sizeof(mov_t0_address), stream);
	fwrite(address, 8, 1, stream);

	switch(x86_id_type_get(register_)) {
		case X86_ID_TYPE_STANDARD: {
			// mov [t0], register
			tbgen_rex_rb_generate(stream, X86_REX_W, register_, t0);
			uint8_t mov_dt0_reg[] = { 0x89 };
			fwrite(mov_dt0_reg, 1, sizeof(mov_dt0_reg), stream);
			tbgen_modrm_ra_generate(stream, register_bin, t0_bin);
			break;
		}
		case X86_ID_TYPE_MMX: {
			// movq [t0], register
			tbgen_rex_generic_generate(stream, X86_REX_B, t0);
			uint8_t movq[] = { 0x0f, 0x7f };
			fwrite(movq, 1, sizeof(movq), stream);
			tbgen_modrm_ra_generate(stream, register_bin, t0_bin);
			break;
		}
		case X86_ID_TYPE_SSE: {
			// movupd [t0], register
			uint8_t prefix = 0x66;
			fwrite(&prefix, 1, sizeof(prefix), stream);
			tbgen_rex_rb_generate(stream, X86_REX_NONE, register_, t0);
			uint8_t movupd[] = { 0x0f, 0x11 };
			fwrite(movupd, 1, sizeof(movupd), stream);
			tbgen_modrm_ra_generate(stream, register_bin, t0_bin);
			break;
		}
	}
}

static void tbgen_mov_rflags_to_memory_generate(FILE *stream, uint64_t *address,
		enum x86_id t0, enum x86_id t1,
		struct tbgen_register_allocation *allocation) {
	uint8_t t0_bin = tbgen_register_to_binary(t0);
	uint8_t t1_bin = tbgen_register_to_binary(t1);

	// push RFLAGS
	tbgen_allocated_push_generate(stream, allocation, X86_ID_FLAGS);

	// pop t1
	tbgen_allocated_pop_generate(stream, allocation, t1);

	// mov t0, address
	tbgen_rex_generic_generate(stream, X86_REX_W | X86_REX_B, t0);
	uint8_t mov_t0_address[] = { 0xb8 | t0_bin };
	fwrite(mov_t0_address, 1, sizeof(mov_t0_address), stream);
	fwrite(address, 8, 1, stream);

	// mov [t0], t1
	tbgen_rex_rb_generate(stream, X86_REX_W, t1, t0);
	uint8_t mov_dt0_t1[] = { 0x89 };
	fwrite(mov_dt0_t1, 1, sizeof(mov_dt0_t1), stream);
	tbgen_modrm_ra_generate(stream, t1_bin, t0_bin);
}

static struct tbgen_register_allocation *tbgen_registers_backup(FILE *stream,
		struct tracking_trace *trace) {
	struct tbgen_register_allocation *allocation = tbgen_allocation_init();

	void access_handle(struct register_access *access) {
		for(size_t i = 0; i < access->x86_indices_length; ++i) {
			enum x86_id reg = (enum x86_id)access->x86_indices[i];
//			if(reg == X86_ID_FLAGS)
//				continue;
//			tbgen_push_generate(stream, reg);
			tbgen_allocate_fixed(allocation, reg);
		}
	}

	access_handle(&trace->reg.read);
	access_handle(&trace->reg.written);
	access_handle(&trace->reg.dereferenced);

	tbgen_allocation_fixed_commit(allocation, stream);

	return allocation;
}

void tbgen_header_generate(FILE *stream) {
}

void tbgen_trailer_generate(FILE *stream) {
	uint8_t retq[] = { 0xc3 };

	fwrite(retq, 1, sizeof(retq), stream);
}

static void tbgen_jump_marker_generate(FILE *stream,
		struct tracking_trace *trace, struct context *context,
		struct tbgen_register_allocation *allocation, enum x86_id return_reg,
		enum x86_id t0, enum x86_id t1) {
	uint8_t t0_bin = tbgen_register_to_binary(t0);

	tbgen_rex_generic_generate(stream, X86_REX_W | X86_REX_R, t0);
	uint8_t lea[] = { 0x8d, 0x05 | (t0_bin << 3), 0xf9, 0xff, 0xff, 0xff };
	fwrite(&lea, 1, sizeof(lea), stream);

	tbgen_mov_register_to_memory_generate(stream, t0,
			(uint64_t*)&context->x86_registers[X86_ID_IP].data, t1);

	tbgen_rex_generic_generate(stream, X86_REX_B, return_reg);
	uint8_t jmp[] = { 0xff, 0xe0 | tbgen_register_to_binary(return_reg) };
	fwrite(&jmp, 1, sizeof(jmp), stream);
}

static void tbgen_registers_preparation_iterate(struct tracking_trace *trace,
		enum x86_id *addtional_regs, size_t addtional_regs_length,
		void (*prepare_reg)(enum x86_id)) {
	for(size_t i = 0; i < trace->reg.read.x86_indices_length; ++i) {
		size_t index = trace->reg.read.x86_indices[i];
		enum x86_id reg = (enum x86_id)index;
		prepare_reg(reg);
	}

	for(size_t i = 0; i < trace->reg.dereferenced.x86_indices_length; ++i) {
		size_t index = trace->reg.dereferenced.x86_indices[i];
		enum x86_id reg = (enum x86_id)index;
		prepare_reg(reg);
	}

	for(size_t i = 0; i < addtional_regs_length; ++i) {
		enum x86_id reg = (enum x86_id)addtional_regs[i];
		prepare_reg(reg);
	}
}

static void tbgen_registers_write_back_iterate(struct tracking_trace *trace,
		enum x86_id *addtional_regs, size_t addtional_regs_length,
		void (*write_back_reg)(enum x86_id)) {
	for(size_t i = 0; i < trace->reg.written.x86_indices_length; ++i) {
		size_t index = trace->reg.written.x86_indices[i];
		enum x86_id reg = (enum x86_id)index;
		write_back_reg(reg);
	}

	for(size_t i = 0; i < addtional_regs_length; ++i) {
		enum x86_id reg = (enum x86_id)addtional_regs[i];
		write_back_reg(reg);
	}
}

struct tbgen_result tbgen_code_generate(uint8_t *instruction,
		size_t instruction_length, struct tracking_trace *trace,
		struct context *context, char test_unused) {
	struct tbgen_result result;

	FILE *stream = open_memstream((char**)&result.buffer, &result.buffer_length);

	tbgen_header_generate(stream);

	struct tbgen_register_allocation *allocation = tbgen_registers_backup(stream,
			trace);

//	tbgen_allocated_push_generate(stream, allocation, X86_ID_FLAGS);

	enum x86_id t0;
	tbgen_allocate_dynamic(&t0, allocation, stream);
	enum x86_id t1;
	tbgen_allocate_dynamic(&t1, allocation, stream);
	enum x86_id return_reg;
	tbgen_allocate_dynamic(&return_reg, allocation, stream);

	void prepare_reg(enum x86_id reg) {
		switch(reg) {
			case X86_ID_FLAGS: {
				tbgen_mov_memory_to_rflags_generate(stream,
						(uint64_t*)&context->x86_registers[reg].data, t0, allocation);
				break;
			}
			case X86_ID_IP: {
				break;
			}
			default: {
				tbgen_mov_memory_to_register_generate(stream, reg,
						(uint64_t*)&context->x86_registers[reg].data, t0);
				break;
			}
		}
	}

	enum x86_id *addtional_regs = NULL;
	size_t addtional_regs_length = 0;
	if(test_unused) {
		addtional_regs = (enum x86_id*)malloc(X86_ID_COUNT * sizeof(enum x86_id));
		enum x86_id next;
		while(!tbgen_allocate_dynamic(&next, allocation, stream))
			addtional_regs[addtional_regs_length++] = next;
	}

	tbgen_registers_preparation_iterate(trace, addtional_regs,
			addtional_regs_length, &prepare_reg);

	/*
	 * Important: It might not be possible to allocate any more register from this point on
	 */

	tbgen_rex_generic_generate(stream, X86_REX_W | X86_REX_R, return_reg);
	uint8_t lea[] = { 0x8d, 0x05 | (tbgen_register_to_binary(return_reg) << 3) };
	fwrite(&lea, 1, sizeof(lea), stream);
	fwrite((uint32_t*)&instruction_length, 1, sizeof(uint32_t), stream);

	fflush(stream);
	result.instruction_offset = result.buffer_length;
	fwrite(instruction, 1, instruction_length, stream);

	//NOPs
	uint8_t nop[] = { 0x90 };
	for(size_t i = 0; i < 15; ++i)
		fwrite(nop, 1, sizeof(nop), stream);

//	result.jump_marker = NULL;
	FILE *marker_stream = open_memstream((char**)&result.jump_marker,
			&result.jump_marker_length);
	tbgen_jump_marker_generate(marker_stream, trace, context, allocation,
			return_reg, t0, t1);
	fclose(marker_stream);

	void write_back_reg(enum x86_id reg) {
		switch(reg) {
			case X86_ID_FLAGS: {
				tbgen_mov_rflags_to_memory_generate(stream,
						(uint64_t*)&context->x86_registers[reg].data, t0, t1, allocation);
				break;
			}
			case X86_ID_IP: {
				break;
			}
			default: {
				tbgen_mov_register_to_memory_generate(stream, reg,
						(uint64_t*)&context->x86_registers[reg].data, t0);
				break;
			}
		}
	}
	tbgen_registers_write_back_iterate(trace, addtional_regs,
			addtional_regs_length, &write_back_reg);

	free(addtional_regs);

//	tbgen_registers_restore(stream, trace);
	//	tbgen_allocated_pop_generate(stream, allocation, X86_ID_FLAGS);

	tbgen_allocation_registers_free(allocation, stream);
	tbgen_allocation_free(allocation);

	tbgen_trailer_generate(stream);

	fclose(stream);

	return result;
}
