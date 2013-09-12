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
		void (*rreil_cif_userdata_set)(state_t s, obj_t userdata);
		obj_t (*rreil_convert_sem_stmts_list)(state_t s, callbacks_t cbs, obj_t stmts);
	} translator;

	void *dl;
};

#define GDSL_MULTIPLEX_ERROR_NONE 0
#define GDSL_MULTIPLEX_ERROR_BACKENDS_PATH_NOT_SET 1
#define GDSL_MULTIPLEX_ERROR_UNABLE_TO_OPEN 2
#define GDSL_MULTIPLEX_ERROR_SYMBOL_NOT_FOUND 3

size_t gdsl_multiplex_backends_list(char ***backends);
char gdsl_multiplex_backend_get(struct backend *backend, const char *name);
void gdsl_multiplex_backend_close(struct backend *backend);

#endif /* GDSL_MULTIPLEX_H_ */
