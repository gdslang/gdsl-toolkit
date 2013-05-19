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
#include <memory.h>
#include <util.h>
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

static size_t tester_instruction_mapped_generate(uint8_t *instruction,
		size_t instruction_length, struct simulator_trace *trace,
		struct context *context, void **memory, void **next_instruction_address) {
	uint8_t* buffer;
	size_t instruction_offset;
	size_t buffer_size = tbgen_code_generate(&buffer, instruction,
			instruction_length, trace, context, &instruction_offset);
	*memory = mmap(NULL, buffer_size, PROT_READ | PROT_WRITE | PROT_EXEC,
			MAP_PRIVATE | MAP_ANONYMOUS, 0, 0);
	memcpy(*memory, buffer, buffer_size);
	*next_instruction_address = *memory + instruction_offset + instruction_length;
	free(buffer);
	return buffer_size;
}

static void tester_instruction_execute(uint8_t *instruction,
		size_t instruction_length, struct simulator_trace *trace,
		struct context *context, void *code) {

	void for_page(void **address, size_t *size) {
		*size = *size + ((size_t)address & 0x0fff);
		*address = (void*)((size_t)*address & 0xfffffffffffff000);
	}

	void unmap(void *address, size_t size) {
		for_page(&address, &size);

		munmap(address, size);
	}

	void map(void *address, size_t size) {
		for_page(&address, &size);

		uint64_t *mem_real = mmap(address, size, PROT_READ | PROT_WRITE,
				MAP_PRIVATE | MAP_ANONYMOUS | MAP_FIXED, 0, 0);

		/*
		 * Todo: Handle error
		 */
	}

	for(size_t i = 0; i < trace->mem.written.accesses_length; ++i) {
		struct memory_access *access = &trace->mem.written.accesses[i];
		map(access->address, access->data_size);
	}

	for(size_t i = 0; i < context->memory.allocations_length; ++i) {
		struct memory_allocation *allocation = &context->memory.allocations[i];

		map(allocation->address, allocation->data_size);
		memcpy(allocation->address, allocation->data, allocation->data_size);
	}

	((void (*)(void))code)();

	for(size_t i = 0; i < context->memory.allocations_length; ++i) {
		struct memory_allocation *allocation = &context->memory.allocations[i];
		memcpy(allocation->data, allocation->address, allocation->data_size);
		unmap(allocation->address, allocation->data_size);
	}

	for(size_t i = 0; i < trace->mem.written.accesses_length; ++i) {
		struct memory_access *access = &trace->mem.written.accesses[i];

		struct memory_allocation allocation;
		allocation.address = access->address;
		allocation.data_size = access->data_size;
		allocation.data = (uint8_t*)malloc(access->data_size);
		memcpy(allocation.data, access->address, access->data_size);

		unmap(access->address, access->data_size);

		util_array_generic_add((void**)&context->memory.allocations, &allocation,
				sizeof(allocation), &context->memory.allocations_length,
				&context->memory.allocations_size);
	}
}

static void tester_contexts_compare(struct simulator_trace *trace,
		struct context *context_cpu, struct context *context_rreil) {
	char found = 0;
	for(size_t i = 0; i < trace->reg.written.indices_length; ++i) {
		size_t index = trace->reg.written.indices[i];
		enum x86_id reg = (enum x86_id)index;
		struct register_ *reg_cpu = &context_cpu->x86_registers[index];
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

	found = 0;
	printf("Memory addresses:\n");
//	void compare_memory(struct context *from, struct context *to) {
//		for(size_t i = 0; i < from->memory.allocations_length; ++i) {
//			struct memory_allocation *allocation = &from->memory.allocations[i];
//
//			for(size_t j = 0; j < to->memory.allocations_length; ++j)
//				if(allocation->address == to->memory.allocations[j].address)
//					goto next;
//
//			printf("Memory address: 0x");
//			for(size_t i = sizeof(allocation->address); i > 0; --i) {
//				uint8_t *addr_ptr = (uint8_t*)&allocation->address;
//				printf("%02x", addr_ptr[i - 1]);
//			}
//
//			printf("\n");
//
//			found = 1;
//
//			next:;
//		}
//	}

//	for(size_t i = 0; i < context_rreil->memory.allocations_length; ++i) {
//		struct memory_allocation *allocation = &context_rreil->memory.allocations[i];
//
//		uint8_t *ptr = (uint8_t*)allocation->address;
//		for(size_t i = 0; i < allocation->data_size; ++i) {
//			if(ptr[i] != allocation->data[i]) {
//				printf("Memory address: 0x");
//				for(size_t j = sizeof(ptr); j > 0; --j) {
//					uint8_t *current = &ptr[i];
//					uint8_t *addr_ptr = (uint8_t*)&current;
//					printf("%02x", addr_ptr[j - 1]);
//				}
//				printf("\n");
//				found = 1;
//			}
//		}
//	}

	int allocation_compare(__const void *a, __const void *b) {
		struct memory_allocation *a_ = (struct memory_allocation*)a;
		struct memory_allocation *b_ = (struct memory_allocation*)b;

		if(a_->address < b_->address)
			return -1;
		else if(a_->address > b_->address)
			return 1;
		else
			return 0;
	}

	qsort(context_cpu->memory.allocations, context_cpu->memory.allocations_length,
			sizeof(struct memory_allocation), &allocation_compare);
	qsort(context_rreil->memory.allocations,
			context_rreil->memory.allocations_length,
			sizeof(struct memory_allocation), &allocation_compare);

	size_t j = 0;
	for(size_t i = 0; i < context_rreil->memory.allocations_length; ++i) {
		struct memory_allocation *alloc_rreil =
				&context_rreil->memory.allocations[i];

		void print_addr(void *addr) {
			printf("Memory address: 0x");
			for(size_t i = sizeof(addr); i > 0; --i) {
				uint8_t *addr_ptr = (uint8_t*)&addr;
				printf("%02x", addr_ptr[i - 1]);
			}

			found = 1;
		}

		void handle_find() {
			print_addr(alloc_rreil->address);

			if(alloc_rreil->data_size > 1)
				printf(" (+ the %zu follwing)", alloc_rreil->data_size - 1);

			printf("\n");
		}

		struct memory_allocation *alloc_cpu = NULL;
		for(; j < context_cpu->memory.allocations_length; ++j) {
			alloc_cpu = &context_cpu->memory.allocations[j];
			if(alloc_cpu->address >= alloc_rreil->address)
				break;
		}

		if(!alloc_cpu || alloc_cpu->address != alloc_rreil->address)
			handle_find();
		else {
			if(alloc_cpu->data_size != alloc_rreil->data_size)
				handle_find();
			else {
				for(size_t k = 0; k < alloc_rreil->data_size; ++k)
					if(alloc_rreil->data[k] != alloc_cpu->data[k]) {
						print_addr(alloc_rreil->address + k);
						printf("\n");
					}
			}
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

	struct context *context_cpu;
	struct context *context_rreil;
	struct simulator_trace *trace = tracking_trace_init();

	void load(uint8_t **buffer, uint8_t *address, uint64_t address_size,
			uint64_t access_size) {
		uint8_t *source = (uint8_t*)malloc(access_size / 8);
		for(size_t i = 0; i < access_size / 8; ++i)
			source[i] = rand();
		memory_load(context_rreil, buffer, address, address_size, access_size,
				source);
		memory_load(context_cpu, buffer, address, address_size, access_size,
				source);
	}
	void store(uint8_t *buffer, uint8_t *address, uint64_t address_size,
			uint64_t access_size) {
		memory_store(context_rreil, buffer, address, address_size, access_size);
		struct memory_access access;
		access.address = memory_ptr_get(address, address_size);
		access.data_size = access_size / 8;
		tracking_trace_memory_write_add(trace, access);
	}

	context_rreil = context_init(&load, &store);

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

	tester_access_init(context_rreil, &trace->reg.written, &zero_buffer);
	tester_access_init(context_rreil, &trace->reg.read, &rand_buffer);
	tester_access_init(context_rreil, &trace->reg.dereferenced,
			&rand_address_buffer);

	tester_rflags_clean(context_rreil);
	context_cpu = context_copy(context_rreil);

	void *code;
	void *next_instruction_address;
	size_t code_size = tester_instruction_mapped_generate(instruction,
			instruction_length, trace, context_cpu, &code, &next_instruction_address);

	simulator_register_generic_write(&context_cpu->x86_registers[X86_ID_IP],
			(uint8_t*)&next_instruction_address, sizeof(next_instruction_address) * 8, 0);
	simulator_register_generic_write(&context_rreil->x86_registers[X86_ID_IP],
			(uint8_t*)&next_instruction_address, sizeof(next_instruction_address) * 8, 0);

	simulator_statements_simulate(context_rreil, statements);

	tester_rflags_clean(context_rreil);

	printf("------------------\n");
	context_x86_print(context_rreil);

	tester_rflags_clean(context_cpu);

	tester_instruction_execute(instruction, instruction_length, trace,
			context_cpu, code);

	munmap(code, code_size);

	printf("------------------\n");
	printf("CPU:\n");
	context_x86_print(context_cpu);
	printf("Rreil simulator:\n");
	context_x86_print(context_rreil);

	printf("------------------\n");
	printf("Failing Registers / Memory locations:\n");
	tester_contexts_compare(trace, context_cpu, context_rreil);

	tracking_trace_free(trace);

	context_free(context_cpu);
	context_free(context_rreil);
}
