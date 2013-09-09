/*
 * gdsl.c
 *
 *  Created on: 21.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <gdsl.h>
#include <gdwrap.h>

char gdwrap_decode(state_t state, obj_t *insn) {
	if(setjmp(*gdsl_err_tgt(state))) {
		return 1;
	} else {
		*insn = gdsl_decode(state);
		return 0;
	}
}

char *gdwrap_x86_pretty(state_t state, obj_t insn, enum gdwrap_x86_print_mode mode) {
	if(setjmp(*gdsl_err_tgt(state)))
		return NULL ;
	else
		switch(mode) {
			case GDSL_X86_PRINT_MODE_FULL:
				return gdsl_merge_rope(state, gdsl_pretty(state, insn));
			case GDSL_X86_PRINT_MODE_SIMPLE:
				return gdsl_merge_rope(state, gdsl_pretty_simple(state, insn));
		}

	return NULL ;
}

char gdwrap_translate(obj_t state, obj_t *rreil, obj_t insn) {
	if(setjmp(*gdsl_err_tgt(state))) {
		return 1;
	} else {
		*rreil = gdsl_translate(state, insn);
		return 0;
	}
}

char gdwrap_translate_block(obj_t state, obj_t *rreil) {
	if(setjmp(*gdsl_err_tgt(state))) {
		return 1;
	} else {
		*rreil = gdsl_translateBlock(state);
		return 0;
	}
}
