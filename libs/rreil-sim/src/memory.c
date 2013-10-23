/*
 * memory.c
 *
 *  Created on: 18.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <context.h>
#include <memory.h>

static struct memory_allocation *memory_allocation_add(struct context *context,
		void *ptr) {
	if(context->memory.allocations_length + 1
			> context->memory.allocations_size) {
		context->memory.allocations_size =
				context->memory.allocations_size ? context->memory.allocations_size
						<< 1 :
						8;
		context->memory.allocations = (struct memory_allocation*)realloc(
				context->memory.allocations,
				context->memory.allocations_size * sizeof(struct memory_allocation));
	}
	struct memory_allocation *allocation =
			&context->memory.allocations[context->memory.allocations_length++];
	allocation->address = ptr;
	allocation->data = NULL;
	allocation->data_size = 0;

	return allocation;
}

static struct memory_allocation *memory_allocation_get(struct context *context,
		void *ptr) {
	struct memory_allocation *allocation = NULL;
	for(size_t i = 0; i < context->memory.allocations_length; ++i)
		if(ptr >= context->memory.allocations[i].address
				&& (size_t)ptr
						< (size_t)context->memory.allocations[i].address
								+ context->memory.allocations[i].data_size) {
			allocation = &context->memory.allocations[i];
			break;
		}
	if(!allocation)
		allocation = memory_allocation_add(context, ptr);
	return allocation;
}

void *memory_ptr_get(uint8_t *address, uint64_t address_size) {
	void *ptr = NULL;
	for(size_t i = 0; i < sizeof(ptr) && i < address_size / 8; ++i) {
		uint8_t *ptr_u8 = (uint8_t*)&ptr;
		ptr_u8[i] = address[i];
	}
	return ptr;
}

static void memory_allocation_resize(struct memory_allocation *allocation,
		uint64_t access_size, void *ptr) {
	size_t diff = (size_t)ptr - (size_t)allocation->address;
	if(diff + access_size / 8 > allocation->data_size) {
		allocation->data_size = diff + access_size / 8;
		allocation->data = (uint8_t*)realloc(allocation->data,
				allocation->data_size);
	}
}

void memory_load(struct context *context, uint8_t **buffer, uint8_t *address,
		uint64_t address_size, uint64_t access_size, uint8_t *source) {
	void *ptr = memory_ptr_get(address, address_size);
	struct memory_allocation *allocation = memory_allocation_get(context, ptr);
	allocation->type = MEMORY_ALLOCATION_TYPE_ACCESS;

	size_t old_size = allocation->data_size;
	memory_allocation_resize(allocation, access_size, ptr);

	size_t diff = (size_t)ptr - (size_t)allocation->address;
	*buffer = &allocation->data[diff];

	for(size_t i = 0; i < allocation->data_size - old_size; ++i)
		allocation->data[old_size + i] = source[i];
}

void memory_store(struct context *context, uint8_t *buffer, uint8_t *address,
		uint64_t address_size, uint64_t access_size) {
	void *ptr = memory_ptr_get(address, address_size);
	struct memory_allocation *allocation = memory_allocation_get(context, ptr);
	allocation->type = MEMORY_ALLOCATION_TYPE_ACCESS;

	memory_allocation_resize(allocation, access_size, ptr);

	size_t diff = (size_t)ptr - (size_t)allocation->address;
	uint8_t *to = &allocation->data[diff];

	memcpy(to, buffer, access_size / 8);
}

void memory_jump(struct context *context, uint8_t *address,
		uint64_t address_size) {
	void *ptr = memory_ptr_get(address, address_size);
	struct memory_allocation *allocation = memory_allocation_add(context, ptr);
	allocation->type = MEMORY_ALLOCATION_TYPE_JUMP;
}
