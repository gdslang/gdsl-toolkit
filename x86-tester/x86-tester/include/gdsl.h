/*
 * gdsl.h
 *
 *  Created on: 21.05.2013
 *      Author: jucs
 */

#ifndef GDSL_H_
#define GDSL_H_

#include <dis.h>

enum gdsl_x86_print_mode {
	GSDL_X86_PRINT_MODE_FULL,
	GSDL_X86_PRINT_MODE_SIMPLE
};

extern __obj gdsl_create_state(__char *buffer, __word size);
extern char gdsl_decode(__obj *insn, __obj *state);
extern size_t gdsl_decoded(__obj *state);
extern __word gdsl_features_get(__obj insn);
extern char *gdsl_x86_pretty(__obj insn, enum gdsl_x86_print_mode mode);
extern char gdsl_translate(__obj *rreil, __obj insn, __obj *state);
extern void gdsl_reset();

#endif /* GDSL_H_ */
