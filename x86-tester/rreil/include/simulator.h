/*
 * simulator.h
 *
 *  Created on: 07.05.2013
 *      Author: jucs
 */

#ifndef SIMULATOR_H_
#define SIMULATOR_H_

#include <stdint.h>
#include <rreil/rreil.h>

struct register_ {
	uint8_t *data;
	size_t data_bit_length;
	size_t data_size;
};

struct simulator_context {
	struct register_ *virtual_registers;
	struct register_ *x86_registers;
	struct register_ *temporary_registers;
};

extern void rreil_statements_simulate(struct simulator_context *context,
		struct rreil_statements *statements);
extern struct simulator_context *simulator_context_init();
extern void simulator_context_free(struct simulator_context *context);
extern void simulator_context_x86_print(struct simulator_context *context);

#endif /* SIMULATOR_H_ */
