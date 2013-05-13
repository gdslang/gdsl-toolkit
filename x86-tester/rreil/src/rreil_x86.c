/*
 * rreil_x86.c
 *
 *  Created on: 13.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <rreil/rreil_x86.h>

size_t rreil_x86_amd64_sizeof(enum rreil_id_x86 x86) {
	switch(x86) {
		case RREIL_ID_X86_IP: {
			return 64;
		}
		case RREIL_ID_X86_FLAGS: {
			return 64;
		}
		case RREIL_ID_X86_MXCSR: {
			return 64;
		}
		case RREIL_ID_X86_AX: {
			return 64;
		}
		case RREIL_ID_X86_BX: {
			return 64;
		}
		case RREIL_ID_X86_CX: {
			return 64;
		}
		case RREIL_ID_X86_DX: {
			return 64;
		}
		case RREIL_ID_X86_SI: {
			return 64;
		}
		case RREIL_ID_X86_DI: {
			return 64;
		}
		case RREIL_ID_X86_SP: {
			return 64;
		}
		case RREIL_ID_X86_BP: {
			return 64;
		}
		case RREIL_ID_X86_R8: {
			return 64;
		}
		case RREIL_ID_X86_R9: {
			return 64;
		}
		case RREIL_ID_X86_R10: {
			return 64;
		}
		case RREIL_ID_X86_R11: {
			return 64;
		}
		case RREIL_ID_X86_R12: {
			return 64;
		}
		case RREIL_ID_X86_R13: {
			return 64;
		}
		case RREIL_ID_X86_R14: {
			return 64;
		}
		case RREIL_ID_X86_R15: {
			return 64;
		}
		case RREIL_ID_X86_CS: {
			return 64;
		}
		case RREIL_ID_X86_DS: {
			return 64;
		}
		case RREIL_ID_X86_SS: {
			return 64;
		}
		case RREIL_ID_X86_ES: {
			return 64;
		}
		case RREIL_ID_X86_FS: {
			return 64;
		}
		case RREIL_ID_X86_GS: {
			return 64;
		}
		case RREIL_ID_X86_ST0: {
			return 64;
		}
		case RREIL_ID_X86_ST1: {
			return 64;
		}
		case RREIL_ID_X86_ST2: {
			return 64;
		}
		case RREIL_ID_X86_ST3: {
			return 64;
		}
		case RREIL_ID_X86_ST4: {
			return 64;
		}
		case RREIL_ID_X86_ST5: {
			return 64;
		}
		case RREIL_ID_X86_ST6: {
			return 64;
		}
		case RREIL_ID_X86_ST7: {
			return 64;
		}
		case RREIL_ID_X86_MM0: {
			return 64;
		}
		case RREIL_ID_X86_MM1: {
			return 64;
		}
		case RREIL_ID_X86_MM2: {
			return 64;
		}
		case RREIL_ID_X86_MM3: {
			return 64;
		}
		case RREIL_ID_X86_MM4: {
			return 64;
		}
		case RREIL_ID_X86_MM5: {
			return 64;
		}
		case RREIL_ID_X86_MM6: {
			return 64;
		}
		case RREIL_ID_X86_MM7: {
			return 64;
		}
		case RREIL_ID_X86_XMM0: {
			return 128;
		}
		case RREIL_ID_X86_XMM1: {
			return 128;
		}
		case RREIL_ID_X86_XMM2: {
			return 128;
		}
		case RREIL_ID_X86_XMM3: {
			return 128;
		}
		case RREIL_ID_X86_XMM4: {
			return 128;
		}
		case RREIL_ID_X86_XMM5: {
			return 128;
		}
		case RREIL_ID_X86_XMM6: {
			return 128;
		}
		case RREIL_ID_X86_XMM7: {
			return 128;
		}
		case RREIL_ID_X86_XMM8: {
			return 128;
		}
		case RREIL_ID_X86_XMM9: {
			return 128;
		}
		case RREIL_ID_X86_XMM10: {
			return 128;
		}
		case RREIL_ID_X86_XMM11: {
			return 128;
		}
		case RREIL_ID_X86_XMM12: {
			return 128;
		}
		case RREIL_ID_X86_XMM13: {
			return 128;
		}
		case RREIL_ID_X86_XMM14: {
			return 128;
		}
		case RREIL_ID_X86_XMM15: {
			return 128;
		}
		default:
			return 0;
	}
}
