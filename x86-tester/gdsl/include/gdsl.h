/*
 * gdsl.h
 *
 *  Created on: 21.05.2013
 *      Author: jucs
 */

#ifndef GDSL_H_
#define GDSL_H_

#include <gdsl.h>

enum gdsl_x86_print_mode {
	GDSL_X86_PRINT_MODE_FULL, GDSL_X86_PRINT_MODE_SIMPLE
};

extern state_t gdsl_create_state(char *buffer, int_t size);
extern char gdsl_decode(obj_t *insn, state_t state);
extern size_t gdsl_decoded(state_t state);
extern int_t gdsl_features_get(obj_t insn);
extern char *gdsl_x86_pretty(state_t state, obj_t insn,
		enum gdsl_x86_print_mode mode);
extern char gdsl_translate(obj_t *rreil, obj_t insn, obj_t state);
extern char gdsl_translate_block(obj_t *rreil, obj_t state);
extern void gdsl_reset(state_t state);

#endif /* GDSL_H_ */
