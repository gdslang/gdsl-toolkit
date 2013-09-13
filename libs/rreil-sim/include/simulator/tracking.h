/*
 * simulator_tracking.h
 *
 *  Created on: 11.05.2013
 *      Author: jucs
 */

#ifndef SIMULATOR_TRACKING_H_
#define SIMULATOR_TRACKING_H_

#include <stdlib.h>
#include <simulator/register.h>
#include <rreil/rreil.h>

struct register_access {
	struct register_ *x86_registers;
	size_t *x86_indices;
	size_t x86_indices_length;
	size_t x86_indices_size;
};

struct memory_access {
	size_t data_size;
	void *address;
};

struct tracking_trace {
//	struct {
//		struct register_ *virtual_registers;
//		struct register_ *x86_registers;
//		struct register_ *temporary_registers;
//	} defined;
	struct {
		struct register_access read;
		struct register_access written;
		struct register_access dereferenced;
	} reg;
	struct {
		struct {
			struct memory_access *accesses;
			size_t accesses_length;
			size_t accesses_size;
		} written;
		char used;
	} mem;
};

extern void tracking_statements_trace(struct tracking_trace *trace,
		struct rreil_statements *statements);
extern struct tracking_trace *tracking_trace_init();
extern void tracking_trace_free(struct tracking_trace *trace);
extern void tracking_trace_memory_write_add(struct tracking_trace *trace,
		struct memory_access access);
extern void tracking_trace_print(struct tracking_trace *trace);

#endif /* SIMULATOR_TRACKING_H_ */
