/*
 * tbgen_alloc.h
 *
 *  Created on: 17.05.2013
 *      Author: jucs
 */

#ifndef TBGEN_ALLOC_H_
#define TBGEN_ALLOC_H_

#include <stdlib.h>
#include <x86.h>

struct tbgen_register_allocation {
	enum x86_id *registers;
	size_t registers_length;
	size_t registers_size;

	char sp_allocated;
	enum x86_id sp_backup;
//	enum x86_id sp_mirror;
};

extern void tbgen_allocated_push_generate(FILE *stream,
		struct tbgen_register_allocation *allocation, enum x86_id register_);
extern void tbgen_allocated_pop_generate(FILE *stream,
		struct tbgen_register_allocation *allocation, enum x86_id register_);
extern struct tbgen_register_allocation *tbgen_allocation_init();
extern void tbgen_allocate_fixed(struct tbgen_register_allocation *allocation,
		enum x86_id reg);
extern char tbgen_allocate_dynamic(enum x86_id *result,
		struct tbgen_register_allocation *allocation, FILE *stream);
extern void tbgen_allocation_fixed_commit(
		struct tbgen_register_allocation *allocation, FILE *stream);
extern void tbgen_allocation_registers_free(
		struct tbgen_register_allocation *allocation, FILE *stream);
extern void tbgen_allocation_free(struct tbgen_register_allocation *allocation);

#endif /* TBGEN_ALLOC_H_ */
