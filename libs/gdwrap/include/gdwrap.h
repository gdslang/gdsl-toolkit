/*
 * gdsl.h
 *
 *  Created on: 21.05.2013
 *      Author: jucs
 */

#ifndef GDSL_H_
#define GDSL_H_

#include <gdsl_generic.h>

enum gdwrap_x86_print_mode {
	GDSL_X86_PRINT_MODE_FULL, GDSL_X86_PRINT_MODE_SIMPLE
};

extern char gdwrap_decode(state_t state, obj_t *insn);
extern char *gdwrap_x86_pretty(state_t state, obj_t insn,
		enum gdwrap_x86_print_mode mode);
extern char gdwrap_translate(obj_t state, obj_t *rreil, obj_t insn);
extern char gdwrap_translate_block(obj_t state, obj_t *rreil);

#endif /* GDSL_H_ */
