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

struct frontend_desc {
	const char *name;
	const char *ext;
};

struct frontend {
	struct {
		state_t (*init)();
		void (*set_code)(state_t state, char *buffer, uint64_t size, uint64_t base);
		jmp_buf *(*err_tgt)(state_t s);
		string_t (*merge_rope)(state_t s, obj_t rope);
		char* (*get_error_message)(state_t s);
		uint64_t (*get_ip_offset)(state_t s);
		void (*reset_heap)(state_t state);
		void (*destroy)(state_t state);
	} generic;

	struct {
		int_t (*config_default)(state_t state);
		obj_t (*decode)(state_t state, int_t config);
		int_t (*operands)(state_t state, obj_t insn);
		obj_t *(*pretty)(state_t state, obj_t insn);
		obj_t *(*pretty_operand)(state_t state, obj_t insn, int_t i);
		obj_t *(*pretty_mnemonic)(state_t state, obj_t insn);
	} decoder;

	struct {
		obj_t (*translate)(state_t state, obj_t insn);
		obj_t *(*pretty)(state_t state, obj_t rreil);
		void (*rreil_cif_userdata_set)(state_t s, obj_t userdata);
		obj_t (*rreil_cif_userdata_get)(state_t s);
		obj_t (*rreil_convert_sem_stmts)(state_t s, callbacks_t cbs, obj_t stmts);
		obj_t (*decode_translate_block_optimized_int)(state_t state, int_t config, int_t limit, int_t pres);
	} translator;

	void *dl;
};

#define GDSL_MULTIPLEX_ERROR_NONE 0
#define GDSL_MULTIPLEX_ERROR_FRONTENDS_PATH_NOT_SET 1
#define GDSL_MULTIPLEX_ERROR_UNABLE_TO_OPEN 2
#define GDSL_MULTIPLEX_ERROR_SYMBOL_NOT_FOUND 3

extern size_t gdsl_multiplex_frontends_list(struct frontend_desc **descs);
extern size_t gdsl_multiplex_frontends_list_with_base(struct frontend_desc **descs, char const *base);
extern char gdsl_multiplex_frontend_get_by_desc(struct frontend *frontend, struct frontend_desc desc);
extern char gdsl_multiplex_frontend_get_by_lib_name(struct frontend *frontend, char *name);
extern void gdsl_multiplex_descs_free(struct frontend_desc *descs, size_t descs_length);
extern void gdsl_multiplex_frontend_close(struct frontend *frontend);

#endif /* GDSL_MULTIPLEX_H_ */
