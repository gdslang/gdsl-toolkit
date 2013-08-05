/*
 * gdsl.c
 *
 *  Created on: 21.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <gdsl-x86.h>
#include <gdsl.h>

char gdsl_decode(state_t state, obj_t *insn) {
	if(setjmp(*gdsl_err_tgt(state))) {
		return 1;
	} else {
		*insn = x86_decode(state);
		return 0;
	}
}

char *gdsl_x86_pretty(state_t state, obj_t insn, enum gdsl_x86_print_mode mode) {
	if(setjmp(*gdsl_err_tgt(state)))
		return NULL ;
	else
		switch(mode) {
			case GDSL_X86_PRINT_MODE_FULL:
				return x86_pretty(state, insn);
			case GDSL_X86_PRINT_MODE_SIMPLE:
				return x86_pretty_simple(state, insn);
		}

	return NULL ;
}

char gdsl_translate(obj_t state, obj_t *rreil, obj_t insn) {
	if(setjmp(*gdsl_err_tgt(state))) {
		return 1;
	} else {
		*rreil = x86_translate(state, insn);
		return 0;
	}
}

char gdsl_translate_block(obj_t state, obj_t *rreil) {
	if(setjmp(*gdsl_err_tgt(state))) {
		return 1;
	} else {
		*rreil = x86_translateBlock(state);
		return 0;
	}
}
