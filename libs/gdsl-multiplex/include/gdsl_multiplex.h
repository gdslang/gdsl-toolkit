/*
 * gdsl_multiplex.h
 *
 *  Created on: Sep 11, 2013
 *      Author: jucs
 */

#ifndef GDSL_MULTIPLEX_H_
#define GDSL_MULTIPLEX_H_

#include <gdsl.h>
#include <stdint.h>

struct backend {
	struct {
		state_t (*gdsl_init)();
		void (*gdsl_set_code)(state_t state, char *buffer, uint64_t size, uint64_t base);
	} generic;

	struct {
		obj_t (*decode)(state_t state);
		char *(*pretty)(state_t state, obj_t insn);
	} decoder;

	struct {
		obj_t (*translate)(state_t state, obj_t insn);
		char *(*pretty)(state_t state, obj_t rreil);
	} translator;
};

size_t gdsl_multiplex_backends_list(char ***backends);

#endif /* GDSL_MULTIPLEX_H_ */
