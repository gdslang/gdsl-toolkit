/*
 * gdsl.h
 *
 *  Created on: 21.05.2013
 *      Author: jucs
 */

#ifndef GDSL_H_
#define GDSL_H_

#include <gdsl-x86.h>

enum gdsl_x86_print_mode {
	GDSL_X86_PRINT_MODE_FULL, GDSL_X86_PRINT_MODE_SIMPLE
};

extern char gdsl_decode(state_t state, obj_t *insn);
extern char *gdsl_x86_pretty(state_t state, obj_t insn,
		enum gdsl_x86_print_mode mode);
extern char gdsl_translate(obj_t state, obj_t *rreil, obj_t insn);
extern char gdsl_translate_block(obj_t state, obj_t *rreil);

#endif /* GDSL_H_ */
