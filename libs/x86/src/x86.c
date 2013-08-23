/*
 * x86.c
 *
 *  Created on: 15.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <x86.h>
#include <gdsl.h>

void x86_id_print(FILE *stream, enum x86_id id) {
	switch(id) {
		case X86_ID_IP: {
			fprintf(stream, "IP");
			break;
		}
		case X86_ID_FLAGS: {
			fprintf(stream, "FLAGS");
			break;
		}
		case X86_ID_MXCSR: {
			fprintf(stream, "MXCSR");
			break;
		}
		case X86_ID_AX: {
			fprintf(stream, "AX");
			break;
		}
		case X86_ID_BX: {
			fprintf(stream, "BX");
			break;
		}
		case X86_ID_CX: {
			fprintf(stream, "CX");
			break;
		}
		case X86_ID_DX: {
			fprintf(stream, "DX");
			break;
		}
		case X86_ID_SI: {
			fprintf(stream, "SI");
			break;
		}
		case X86_ID_DI: {
			fprintf(stream, "DI");
			break;
		}
		case X86_ID_SP: {
			fprintf(stream, "SP");
			break;
		}
		case X86_ID_BP: {
			fprintf(stream, "BP");
			break;
		}
		case X86_ID_R8: {
			fprintf(stream, "R8");
			break;
		}
		case X86_ID_R9: {
			fprintf(stream, "R9");
			break;
		}
		case X86_ID_R10: {
			fprintf(stream, "R10");
			break;
		}
		case X86_ID_R11: {
			fprintf(stream, "R11");
			break;
		}
		case X86_ID_R12: {
			fprintf(stream, "R12");
			break;
		}
		case X86_ID_R13: {
			fprintf(stream, "R13");
			break;
		}
		case X86_ID_R14: {
			fprintf(stream, "R14");
			break;
		}
		case X86_ID_R15: {
			fprintf(stream, "R15");
			break;
		}
		case X86_ID_CS: {
			fprintf(stream, "CS");
			break;
		}
		case X86_ID_DS: {
			fprintf(stream, "DS");
			break;
		}
		case X86_ID_SS: {
			fprintf(stream, "SS");
			break;
		}
		case X86_ID_ES: {
			fprintf(stream, "ES");
			break;
		}
		case X86_ID_FS: {
			fprintf(stream, "FS");
			break;
		}
		case X86_ID_GS: {
			fprintf(stream, "GS");
			break;
		}
		case X86_ID_ST0: {
			fprintf(stream, "ST0");
			break;
		}
		case X86_ID_ST1: {
			fprintf(stream, "ST1");
			break;
		}
		case X86_ID_ST2: {
			fprintf(stream, "ST2");
			break;
		}
		case X86_ID_ST3: {
			fprintf(stream, "ST3");
			break;
		}
		case X86_ID_ST4: {
			fprintf(stream, "ST4");
			break;
		}
		case X86_ID_ST5: {
			fprintf(stream, "ST5");
			break;
		}
		case X86_ID_ST6: {
			fprintf(stream, "ST6");
			break;
		}
		case X86_ID_ST7: {
			fprintf(stream, "ST7");
			break;
		}
		case X86_ID_MM0: {
			fprintf(stream, "MM0");
			break;
		}
		case X86_ID_MM1: {
			fprintf(stream, "MM1");
			break;
		}
		case X86_ID_MM2: {
			fprintf(stream, "MM2");
			break;
		}
		case X86_ID_MM3: {
			fprintf(stream, "MM3");
			break;
		}
		case X86_ID_MM4: {
			fprintf(stream, "MM4");
			break;
		}
		case X86_ID_MM5: {
			fprintf(stream, "MM5");
			break;
		}
		case X86_ID_MM6: {
			fprintf(stream, "MM6");
			break;
		}
		case X86_ID_MM7: {
			fprintf(stream, "MM7");
			break;
		}
		case X86_ID_XMM0: {
			fprintf(stream, "XMM0");
			break;
		}
		case X86_ID_XMM1: {
			fprintf(stream, "XMM1");
			break;
		}
		case X86_ID_XMM2: {
			fprintf(stream, "XMM2");
			break;
		}
		case X86_ID_XMM3: {
			fprintf(stream, "XMM3");
			break;
		}
		case X86_ID_XMM4: {
			fprintf(stream, "XMM4");
			break;
		}
		case X86_ID_XMM5: {
			fprintf(stream, "XMM5");
			break;
		}
		case X86_ID_XMM6: {
			fprintf(stream, "XMM6");
			break;
		}
		case X86_ID_XMM7: {
			fprintf(stream, "XMM7");
			break;
		}
		case X86_ID_XMM8: {
			fprintf(stream, "XMM8");
			break;
		}
		case X86_ID_XMM9: {
			fprintf(stream, "XMM9");
			break;
		}
		case X86_ID_XMM10: {
			fprintf(stream, "XMM10");
			break;
		}
		case X86_ID_XMM11: {
			fprintf(stream, "XMM11");
			break;
		}
		case X86_ID_XMM12: {
			fprintf(stream, "XMM12");
			break;
		}
		case X86_ID_XMM13: {
			fprintf(stream, "XMM13");
			break;
		}
		case X86_ID_XMM14: {
			fprintf(stream, "XMM14");
			break;
		}
		case X86_ID_XMM15: {
			fprintf(stream, "XMM15");
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

enum x86_id_type x86_id_type_get(enum x86_id id) {
	switch(id) {
		case X86_ID_MM0:
		case X86_ID_MM1:
		case X86_ID_MM2:
		case X86_ID_MM3:
		case X86_ID_MM4:
		case X86_ID_MM5:
		case X86_ID_MM6:
		case X86_ID_MM7:
			return X86_ID_TYPE_MMX;
		case X86_ID_XMM0:
		case X86_ID_XMM1:
		case X86_ID_XMM2:
		case X86_ID_XMM3:
		case X86_ID_XMM4:
		case X86_ID_XMM5:
		case X86_ID_XMM6:
		case X86_ID_XMM7:
		case X86_ID_XMM8:
		case X86_ID_XMM9:
		case X86_ID_XMM10:
		case X86_ID_XMM11:
		case X86_ID_XMM12:
		case X86_ID_XMM13:
		case X86_ID_XMM14:
		case X86_ID_XMM15:
			return X86_ID_TYPE_SSE;
		default:
			return X86_ID_TYPE_STANDARD;
	}
}

enum x86_id x86_reg_from_con(int_t con) {
	switch(con) {
		case CON_Sem_IP: {
			return X86_ID_IP;
			break;
		}
		case CON_Sem_FLAGS: {
			return X86_ID_FLAGS;
			break;
		}
		case CON_Sem_MXCSR: {
			return X86_ID_MXCSR;
			break;
		}
		case CON_Sem_AX: {
			return X86_ID_AX;
			break;
		}
		case CON_Sem_BX: {
			return X86_ID_BX;
			break;
		}
		case CON_Sem_CX: {
			return X86_ID_CX;
			break;
		}
		case CON_Sem_DX: {
			return X86_ID_DX;
			break;
		}
		case CON_Sem_SI: {
			return X86_ID_SI;
			break;
		}
		case CON_Sem_DI: {
			return X86_ID_DI;
			break;
		}
		case CON_Sem_SP: {
			return X86_ID_SP;
			break;
		}
		case CON_Sem_BP: {
			return X86_ID_BP;
			break;
		}
		case CON_Sem_R8: {
			return X86_ID_R8;
			break;
		}
		case CON_Sem_R9: {
			return X86_ID_R9;
			break;
		}
		case CON_Sem_R10: {
			return X86_ID_R10;
			break;
		}
		case CON_Sem_R11: {
			return X86_ID_R11;
			break;
		}
		case CON_Sem_R12: {
			return X86_ID_R12;
			break;
		}
		case CON_Sem_R13: {
			return X86_ID_R13;
			break;
		}
		case CON_Sem_R14: {
			return X86_ID_R14;
			break;
		}
		case CON_Sem_R15: {
			return X86_ID_R15;
			break;
		}
		case CON_Sem_CS: {
			return X86_ID_CS;
			break;
		}
		case CON_Sem_DS: {
			return X86_ID_DS;
			break;
		}
		case CON_Sem_SS: {
			return X86_ID_SS;
			break;
		}
		case CON_Sem_ES: {
			return X86_ID_ES;
			break;
		}
		case CON_Sem_FS: {
			return X86_ID_FS;
			break;
		}
		case CON_Sem_GS: {
			return X86_ID_GS;
			break;
		}
		case CON_Sem_ST0: {
			return X86_ID_ST0;
			break;
		}
		case CON_Sem_ST1: {
			return X86_ID_ST1;
			break;
		}
		case CON_Sem_ST2: {
			return X86_ID_ST2;
			break;
		}
		case CON_Sem_ST3: {
			return X86_ID_ST3;
			break;
		}
		case CON_Sem_ST4: {
			return X86_ID_ST4;
			break;
		}
		case CON_Sem_ST5: {
			return X86_ID_ST5;
			break;
		}
		case CON_Sem_ST6: {
			return X86_ID_ST6;
			break;
		}
		case CON_Sem_ST7: {
			return X86_ID_ST7;
			break;
		}
		case CON_Sem_MM0: {
			return X86_ID_MM0;
			break;
		}
		case CON_Sem_MM1: {
			return X86_ID_MM1;
			break;
		}
		case CON_Sem_MM2: {
			return X86_ID_MM2;
			break;
		}
		case CON_Sem_MM3: {
			return X86_ID_MM3;
			break;
		}
		case CON_Sem_MM4: {
			return X86_ID_MM4;
			break;
		}
		case CON_Sem_MM5: {
			return X86_ID_MM5;
			break;
		}
		case CON_Sem_MM6: {
			return X86_ID_MM6;
			break;
		}
		case CON_Sem_MM7: {
			return X86_ID_MM7;
			break;
		}
		case CON_Sem_XMM0: {
			return X86_ID_XMM0;
			break;
		}
		case CON_Sem_XMM1: {
			return X86_ID_XMM1;
			break;
		}
		case CON_Sem_XMM2: {
			return X86_ID_XMM2;
			break;
		}
		case CON_Sem_XMM3: {
			return X86_ID_XMM3;
			break;
		}
		case CON_Sem_XMM4: {
			return X86_ID_XMM4;
			break;
		}
		case CON_Sem_XMM5: {
			return X86_ID_XMM5;
			break;
		}
		case CON_Sem_XMM6: {
			return X86_ID_XMM6;
			break;
		}
		case CON_Sem_XMM7: {
			return X86_ID_XMM7;
			break;
		}
		case CON_Sem_XMM8: {
			return X86_ID_XMM8;
			break;
		}
		case CON_Sem_XMM9: {
			return X86_ID_XMM9;
			break;
		}
		case CON_Sem_XMM10: {
			return X86_ID_XMM10;
			break;
		}
		case CON_Sem_XMM11: {
			return X86_ID_XMM11;
			break;
		}
		case CON_Sem_XMM12: {
			return X86_ID_XMM12;
			break;
		}
		case CON_Sem_XMM13: {
			return X86_ID_XMM13;
			break;
		}
		case CON_Sem_XMM14: {
			return X86_ID_XMM14;
			break;
		}
		case CON_Sem_XMM15: {
			return X86_ID_XMM15;
			break;
		}
	}
}
