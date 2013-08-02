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

char gdsl_decode(obj_t *insn, state_t state) {
	jmp_buf exp_vec;
//	__exp_vec_set(&exp_vec);
//	if(setjmp(exp_vec)) {
//		return 1;
//	} else {
		*insn = x86_decode(state);
		return 0;
//	}
}

size_t gdsl_decoded(state_t state) {
	return gdsl_get_ip_offset(state);
}

int_t gdsl_features_get(obj_t insn) {
//	obj_t payload = __DECON(insn);
//	switch(__CASETAGCON(payload)) {
//		case __VA0:
//		case __VA1:
//		case __VA2:
//		case __VA3:
//		case __VA4: {
//			payload = __DECON(payload);
//			break;
//		}
//	}
//	obj_t features = __RECORD_SELECT(payload, ___features);
//	return __CASETAGINT(__zx(features));
	return 0;
}

char *gdsl_x86_pretty(state_t state, obj_t insn, enum gdsl_x86_print_mode mode) {
//	jmp_buf exp_vec;
//	__exp_vec_set(&exp_vec);
//
//	size_t str_size = 128;
//	char *str = (char*)malloc(str_size);
//
//	do {
//		if(setjmp(exp_vec)) {
//			str_size <<= 1;
//			if(str_size > 64 * 1024 * 1024) {
//				free(str);
//				str = NULL;
//				break;
//			}
//			str = (char*)realloc(str, str_size);
//		} else {
//			switch(mode) {
//				case GDSL_X86_PRINT_MODE_FULL: {
//					__pretty(__pretty__, insn, str, str_size);
//					break;
//				}
//				case GDSL_X86_PRINT_MODE_SIMPLE: {
//					__pretty(__pretty_simple__, insn, str, str_size);
//					break;
//				}
//			}
//
//			break;
//		}
//	} while(1);

	switch(mode) {
		case GDSL_X86_PRINT_MODE_FULL:
			return x86_pretty(state, insn);
		case GDSL_X86_PRINT_MODE_SIMPLE:
			return x86_pretty_simple(state, insn);
	}

	return NULL ;
}

char gdsl_translate(obj_t *rreil, obj_t insn, obj_t state) {
	jmp_buf exp_vec;
//	__exp_vec_set(&exp_vec);
//	if(setjmp(exp_vec)) {
//		return 1;
//	} else {
		*rreil = x86_translate(state, insn);
		return 0;
//	}
}

char gdsl_translate_block(obj_t *rreil, obj_t state) {
	jmp_buf exp_vec;
//	__exp_vec_set(&exp_vec);
//	if(setjmp(exp_vec)) {
//		return 1;
//	} else {
		*rreil = x86_translateBlock(state);
		return 0;
//	}
}

void gdsl_reset(state_t state) {
	gdsl_reset_heap(state);
}
