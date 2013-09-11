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
		state_t (*init)();
		void (*set_code)(state_t state, char *buffer, uint64_t size, uint64_t base);
		jmp_buf *(*err_tgt)(state_t s);
		string_t (*merge_rope)(state_t s, obj_t rope);
		char* (*get_error_message)(state_t s);
		uint64_t (*get_ip_offset)(state_t s);
		void (*destroy)(state_t state);
	} generic;

	struct {
		obj_t (*decode)(state_t state);
		obj_t *(*pretty)(state_t state, obj_t insn);
	} decoder;

	struct {
		obj_t (*translate)(state_t state, obj_t insn);
		obj_t *(*pretty)(state_t state, obj_t rreil);
	} translator;

	void *dl;
};

size_t gdsl_multiplex_backends_list(char ***backends);
char gdsl_multiplex_backend_get(struct backend *backend, char *name);
void gdsl_multiplex_backend_close(struct backend *backend);

#endif /* GDSL_MULTIPLEX_H_ */
