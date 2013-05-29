/*
 * gdsl.c
 *
 *  Created on: 21.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <dis.h>
#include <gdsl.h>

__obj gdsl_create_state(__char *buffer, __word size) {
	return __createState(buffer, size, 0, 0);
}

char gdsl_decode(__obj *insn, __obj *state) {
	jmp_buf exp_vec;
	__exp_vec_set(&exp_vec);
	if(setjmp(exp_vec)) {
		return 1;
	} else {
		*insn = __runMonadicNoArg(__decode__, state);
		return 0;
	}
}

size_t gdsl_decoded(__obj *state) {
	return __getBlobIndex(*state);
}

__word gdsl_features_get(__obj insn) {
	__obj payload = __DECON(insn);
	switch(__CASETAGCON(payload)) {
		case __VA0:
		case __VA1:
		case __VA2:
		case __VA3:
		case __VA4: {
			payload = __DECON(payload);
			break;
		}
	}
	__obj features = __RECORD_SELECT(payload, ___features);
	return __CASETAGINT(__zx(features));
}

char *gdsl_x86_pretty(__obj insn, enum gdsl_x86_print_mode mode) {
	jmp_buf exp_vec;
	__exp_vec_set(&exp_vec);

	size_t str_size = 128;
	char *str = (char*)malloc(str_size);

	do {
		if(setjmp(exp_vec)) {
			str_size <<= 1;
			if(str_size > 64 * 1024 * 1024) {
				free(str);
				str = NULL;
				break;
			}
			str = (char*)realloc(str, str_size);
		} else {
			switch(mode) {
				case GSDL_X86_PRINT_MODE_FULL: {
					__pretty(__pretty__, insn, str, str_size);
					break;
				}
				case GSDL_X86_PRINT_MODE_SIMPLE: {
					__pretty(__pretty_simple__, insn, str, str_size);
					break;
				}
			}

			break;
		}
	} while(1);

	return str;
}

char gdsl_translate(__obj *rreil, __obj insn, __obj *state) {
	jmp_buf exp_vec;
	__exp_vec_set(&exp_vec);
	if(setjmp(exp_vec)) {
		return 1;
	} else {
		*rreil = __runMonadicOneArg(__translate__, state, insn);
		return 0;
	}
}

void gdsl_reset() {
	__resetHeap();
}
