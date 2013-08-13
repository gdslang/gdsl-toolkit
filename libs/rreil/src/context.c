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
#include <util.h>

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

//void context_data_init(struct data *data) {
//	data->data = (uint8_t*)malloc(bit_length / 8 + 1);
//	data->defined = (uint8_t*)malloc(bit_length / 8 + 1);
//}

void context_data_define(struct data *data) {
	data->defined = (uint8_t*)malloc(data->bit_length / 8 + 1);
	membit_one_fill(data->defined, 0, data->bit_length);
}

void context_data_undefine(struct data *data) {
	data->defined = (uint8_t*)malloc(data->bit_length / 8 + 1);
	membit_zero_fill(data->defined, 0, data->bit_length);
}

void context_data_clear(struct data *data) {
	if(data) {
		free(data->data);
		free(data->defined);
	}
}

struct context *context_copy(struct context *source) {
	struct context *context = (struct context*)malloc(sizeof(struct context));

	void copy_registers(size_t count, struct register_ *registers,
			struct register_ *registers_source) {
		for(size_t i = 0; i < count; ++i) {
			registers[i].bit_length = registers_source[i].bit_length;
//			registers[i].data_size = registers_source[i].data_size;
			void copy(uint8_t **field_to, uint8_t *field_from) {
				*field_to = (uint8_t*)malloc(registers[i].bit_length / 8 + 1);
				memcpy(*field_to, field_from,
						registers[i].bit_length / 8 + (registers[i].bit_length % 8 > 0));
			}
			copy(&registers[i].data, registers_source[i].data);
			copy(&registers[i].defined, registers_source[i].defined);
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
	if(register_) {
		free(register_->data);
		free(register_->defined);
	}
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

		if(!reg->bit_length)
			continue;

		/*
		 * Todo: Extra function for printing
		 */
		printf("Register ");
		x86_id_print(id_x86);
		printf(": ");

		size_t rest = 0;
		size_t reg_size = x86_amd64_sizeof(id_x86);
		if(reg_size > reg->bit_length)
			rest = reg_size - reg->bit_length;
		for(size_t i = 0; i < rest / 8; ++i)
			printf("00");
		if(reg->bit_length) {
			void print(uint8_t *ptr) {
				if(reg->bit_length % 8) {
					uint8_t top = ptr[reg->bit_length / 8]
							& reg->defined[reg->bit_length / 8];
					uint8_t mask = (1 << (reg->bit_length % 8)) - 1;
					printf("%02x", (top & mask));
				}
				for(size_t i = reg->bit_length / 8; i > 0; --i)
					printf("%02x", ptr[i - 1] & reg->defined[i - 1]);
			}
			print(reg->data);
			printf(" [defined:");
			print(reg->defined);
			printf("]");
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

static void context_compare_registers(struct register_ *reg_cpu,
		struct register_ *reg_rreil, void (*callback)(void)) {
	for(size_t j = 0; j < reg_cpu->bit_length / 8; ++j)
		if((reg_cpu->data[j] & reg_rreil->defined[j])
				!= (reg_rreil->data[j] & reg_rreil->defined[j])) {
			callback();
			break;
		}
}

static void context_compare_registers_using_trace(struct tracking_trace *trace,
		struct context *context_cpu, struct context *context_rreil,
		void (*callback)(enum x86_id reg)) {
	for(size_t i = 0; i < trace->reg.written.x86_indices_length; ++i) {
		size_t index = trace->reg.written.x86_indices[i];
		enum x86_id reg = (enum x86_id)index;
		struct register_ *reg_cpu = &context_cpu->x86_registers[index];
		struct register_ *reg_rreil = &context_rreil->x86_registers[index];
//		struct register_ *reg_trace = &trace->reg.written.x86_registers[index];
		void equal() {
			callback(reg);
		}
		context_compare_registers(reg_cpu, reg_rreil, &equal);
	}
}

static void context_compare_registers_all(struct context *context_cpu,
		struct context *context_rreil, void (*callback)(enum x86_id reg)) {
	for(size_t i = 0; i < X86_ID_COUNT; ++i) {
		enum x86_id reg = (enum x86_id)i;
		struct register_ *reg_cpu = &context_cpu->x86_registers[i];
		struct register_ *reg_rreil = &context_rreil->x86_registers[i];
//		struct register_ *reg_trace = &trace->reg.written.x86_registers[index];
		void equal() {
			callback(reg);
		}
		context_compare_registers(reg_cpu, reg_rreil, &equal);
	}
}

char context_compare_print(struct tracking_trace *trace,
		struct context *context_cpu, struct context *context_rreil,
		char test_unused) {
	char retval = 0;

	printf("Failing Registers:\n");
	char found = 0;
	void reg_found(enum x86_id reg) {
		if(found)
			printf(", ");

		x86_id_print(reg);
		found = 1;
	}

	if(test_unused)
		context_compare_registers_all(context_cpu, context_rreil, &reg_found);
	else
		context_compare_registers_using_trace(trace, context_cpu, context_rreil,
				&reg_found);

	if(!found)
		printf("None\n");
	else
		printf("\n");

	retval |= found;

	found = 0;
	printf("Failing memory addresses:\n");
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

	retval |= found;

	return retval;
}
