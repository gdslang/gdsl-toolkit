/*
 * x86.c
 *
 *  Created on: 15.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <x86.h>

void x86_id_print(enum x86_id id) {
	switch(id) {
		case X86_ID_IP: {
			printf("IP");
			break;
		}
		case X86_ID_FLAGS: {
			printf("FLAGS");
			break;
		}
		case X86_ID_MXCSR: {
			printf("MXCSR");
			break;
		}
		case X86_ID_AX: {
			printf("AX");
			break;
		}
		case X86_ID_BX: {
			printf("BX");
			break;
		}
		case X86_ID_CX: {
			printf("CX");
			break;
		}
		case X86_ID_DX: {
			printf("DX");
			break;
		}
		case X86_ID_SI: {
			printf("SI");
			break;
		}
		case X86_ID_DI: {
			printf("DI");
			break;
		}
		case X86_ID_SP: {
			printf("SP");
			break;
		}
		case X86_ID_BP: {
			printf("BP");
			break;
		}
		case X86_ID_R8: {
			printf("R8");
			break;
		}
		case X86_ID_R9: {
			printf("R9");
			break;
		}
		case X86_ID_R10: {
			printf("R10");
			break;
		}
		case X86_ID_R11: {
			printf("R11");
			break;
		}
		case X86_ID_R12: {
			printf("R12");
			break;
		}
		case X86_ID_R13: {
			printf("R13");
			break;
		}
		case X86_ID_R14: {
			printf("R14");
			break;
		}
		case X86_ID_R15: {
			printf("R15");
			break;
		}
		case X86_ID_CS: {
			printf("CS");
			break;
		}
		case X86_ID_DS: {
			printf("DS");
			break;
		}
		case X86_ID_SS: {
			printf("SS");
			break;
		}
		case X86_ID_ES: {
			printf("ES");
			break;
		}
		case X86_ID_FS: {
			printf("FS");
			break;
		}
		case X86_ID_GS: {
			printf("GS");
			break;
		}
		case X86_ID_ST0: {
			printf("ST0");
			break;
		}
		case X86_ID_ST1: {
			printf("ST1");
			break;
		}
		case X86_ID_ST2: {
			printf("ST2");
			break;
		}
		case X86_ID_ST3: {
			printf("ST3");
			break;
		}
		case X86_ID_ST4: {
			printf("ST4");
			break;
		}
		case X86_ID_ST5: {
			printf("ST5");
			break;
		}
		case X86_ID_ST6: {
			printf("ST6");
			break;
		}
		case X86_ID_ST7: {
			printf("ST7");
			break;
		}
		case X86_ID_MM0: {
			printf("MM0");
			break;
		}
		case X86_ID_MM1: {
			printf("MM1");
			break;
		}
		case X86_ID_MM2: {
			printf("MM2");
			break;
		}
		case X86_ID_MM3: {
			printf("MM3");
			break;
		}
		case X86_ID_MM4: {
			printf("MM4");
			break;
		}
		case X86_ID_MM5: {
			printf("MM5");
			break;
		}
		case X86_ID_MM6: {
			printf("MM6");
			break;
		}
		case X86_ID_MM7: {
			printf("MM7");
			break;
		}
		case X86_ID_XMM0: {
			printf("XMM0");
			break;
		}
		case X86_ID_XMM1: {
			printf("XMM1");
			break;
		}
		case X86_ID_XMM2: {
			printf("XMM2");
			break;
		}
		case X86_ID_XMM3: {
			printf("XMM3");
			break;
		}
		case X86_ID_XMM4: {
			printf("XMM4");
			break;
		}
		case X86_ID_XMM5: {
			printf("XMM5");
			break;
		}
		case X86_ID_XMM6: {
			printf("XMM6");
			break;
		}
		case X86_ID_XMM7: {
			printf("XMM7");
			break;
		}
		case X86_ID_XMM8: {
			printf("XMM8");
			break;
		}
		case X86_ID_XMM9: {
			printf("XMM9");
			break;
		}
		case X86_ID_XMM10: {
			printf("XMM10");
			break;
		}
		case X86_ID_XMM11: {
			printf("XMM11");
			break;
		}
		case X86_ID_XMM12: {
			printf("XMM12");
			break;
		}
		case X86_ID_XMM13: {
			printf("XMM13");
			break;
		}
		case X86_ID_XMM14: {
			printf("XMM14");
			break;
		}
		case X86_ID_XMM15: {
			printf("XMM15");
			break;
		}
	}
}

size_t x86_amd64_sizeof(enum x86_id id) {
	switch(id) {
		case X86_ID_IP: {
			return 64;
		}
		case X86_ID_FLAGS: {
			return 64;
		}
		case X86_ID_MXCSR: {
			return 64;
		}
		case X86_ID_AX: {
			return 64;
		}
		case X86_ID_BX: {
			return 64;
		}
		case X86_ID_CX: {
			return 64;
		}
		case X86_ID_DX: {
			return 64;
		}
		case X86_ID_SI: {
			return 64;
		}
		case X86_ID_DI: {
			return 64;
		}
		case X86_ID_SP: {
			return 64;
		}
		case X86_ID_BP: {
			return 64;
		}
		case X86_ID_R8: {
			return 64;
		}
		case X86_ID_R9: {
			return 64;
		}
		case X86_ID_R10: {
			return 64;
		}
		case X86_ID_R11: {
			return 64;
		}
		case X86_ID_R12: {
			return 64;
		}
		case X86_ID_R13: {
			return 64;
		}
		case X86_ID_R14: {
			return 64;
		}
		case X86_ID_R15: {
			return 64;
		}
		case X86_ID_CS: {
			return 64;
		}
		case X86_ID_DS: {
			return 64;
		}
		case X86_ID_SS: {
			return 64;
		}
		case X86_ID_ES: {
			return 64;
		}
		case X86_ID_FS: {
			return 64;
		}
		case X86_ID_GS: {
			return 64;
		}
		case X86_ID_ST0: {
			return 64;
		}
		case X86_ID_ST1: {
			return 64;
		}
		case X86_ID_ST2: {
			return 64;
		}
		case X86_ID_ST3: {
			return 64;
		}
		case X86_ID_ST4: {
			return 64;
		}
		case X86_ID_ST5: {
			return 64;
		}
		case X86_ID_ST6: {
			return 64;
		}
		case X86_ID_ST7: {
			return 64;
		}
		case X86_ID_MM0: {
			return 64;
		}
		case X86_ID_MM1: {
			return 64;
		}
		case X86_ID_MM2: {
			return 64;
		}
		case X86_ID_MM3: {
			return 64;
		}
		case X86_ID_MM4: {
			return 64;
		}
		case X86_ID_MM5: {
			return 64;
		}
		case X86_ID_MM6: {
			return 64;
		}
		case X86_ID_MM7: {
			return 64;
		}
		case X86_ID_XMM0: {
			return 128;
		}
		case X86_ID_XMM1: {
			return 128;
		}
		case X86_ID_XMM2: {
			return 128;
		}
		case X86_ID_XMM3: {
			return 128;
		}
		case X86_ID_XMM4: {
			return 128;
		}
		case X86_ID_XMM5: {
			return 128;
		}
		case X86_ID_XMM6: {
			return 128;
		}
		case X86_ID_XMM7: {
			return 128;
		}
		case X86_ID_XMM8: {
			return 128;
		}
		case X86_ID_XMM9: {
			return 128;
		}
		case X86_ID_XMM10: {
			return 128;
		}
		case X86_ID_XMM11: {
			return 128;
		}
		case X86_ID_XMM12: {
			return 128;
		}
		case X86_ID_XMM13: {
			return 128;
		}
		case X86_ID_XMM14: {
			return 128;
		}
		case X86_ID_XMM15: {
			return 128;
		}
		default:
			return 0;
	}
}
