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
	uint8_t *defined;
	size_t bit_length;
};

struct data {
	uint8_t *data;
	uint8_t *defined;
	size_t bit_length;
};

enum memory_allocation_type {
	MEMORY_ALLOCATION_TYPE_ACCESS, MEMORY_ALLOCATION_TYPE_JUMP
};

struct memory_allocation {
	enum memory_allocation_type type;
	uint8_t *data;
	size_t data_size;
	void *address;
};

typedef void (context_load_t)(uint8_t **, uint8_t *, uint64_t, uint64_t);
typedef void (context_store_t)(uint8_t *, uint8_t *, uint64_t, uint64_t);
typedef void (context_jump_t)(uint8_t *, uint64_t);

struct context {
	struct register_ *virtual_registers;
	struct register_ *x86_registers;
	struct register_ *temporary_registers;
	struct {
		struct memory_allocation *allocations;
		size_t allocations_length;
		size_t allocations_size;
		context_load_t *load;
		context_store_t *store;
		context_jump_t *jump;
	} memory;

};

extern struct memory_allocation *memory_allocation_init(void *address);
extern struct context *context_init(context_load_t *load,
		context_store_t *store, context_jump_t *jump);
extern struct context *context_copy(struct context *source);
extern void context_free(struct context *context);
extern void context_x86_print(struct context *context);

#endif /* CONTEXT_H_ */
