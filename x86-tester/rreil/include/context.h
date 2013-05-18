/*
 * context.h
 *
 *  Created on: 15.05.2013
 *      Author: jucs
 */

#ifndef CONTEXT_H_
#define CONTEXT_H_

struct register_ {
	uint8_t *data;
	size_t data_bit_length;
	size_t data_size;
};

struct memory_allocation {
	uint8_t *data;
	size_t data_size;
	void *address;
};

struct context {
	struct register_ *virtual_registers;
	struct register_ *x86_registers;
	struct register_ *temporary_registers;
	struct {
		struct memory_allocation *allocations;
		size_t allocations_length;
		size_t allocations_size;
		uint8_t (*byte_read)(void *address);
	} memory;

};

extern struct memory_allocation *memory_allocation_init(void *address);
extern struct context *context_init(uint8_t (*byte_read)(void *address));
extern struct context *context_copy(
		struct context *source);
extern void context_free(struct context *context);
extern void context_x86_print(struct context *context);

#endif /* CONTEXT_H_ */
