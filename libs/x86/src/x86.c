/*
 * x86.c
 *
 *  Created on: 15.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
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
		case X86_ID_A: {
			fprintf(stream, "A");
			break;
		}
		case X86_ID_B: {
			fprintf(stream, "B");
			break;
		}
		case X86_ID_C: {
			fprintf(stream, "C");
			break;
		}
		case X86_ID_D: {
			fprintf(stream, "D");
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
		case X86_ID_CS_Base: {
			fprintf(stream, "CS_Base");
			break;
		}
		case X86_ID_DS_Base: {
			fprintf(stream, "DS_Base");
			break;
		}
		case X86_ID_SS_Base: {
			fprintf(stream, "SS_Base");
			break;
		}
		case X86_ID_ES_Base: {
			fprintf(stream, "ES_Base");
			break;
		}
		case X86_ID_FS_Base: {
			fprintf(stream, "FS_Base");
			break;
		}
		case X86_ID_GS_Base: {
			fprintf(stream, "GS_Base");
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
		case X86_ID_VIRT_LES: {
			fprintf(stream, "VIRT_LES");
			break;
		}
		case X86_ID_VIRT_LEU: {
			fprintf(stream, "VIRT_LEU");
			break;
		}
		case X86_ID_VIRT_LTS: {
			fprintf(stream, "VIRT_LTS");
			break;
		}
	}
}

void x86_exception_print(FILE *stream, enum x86_exception exception) {
	switch(exception) {
		case X86_EXCEPTION_DIVISION_OVERFLOW: {
			fprintf(stream, "{Exception: Division overflow}");
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
		case X86_ID_A: {
			return 64;
		}
		case X86_ID_B: {
			return 64;
		}
		case X86_ID_C: {
			return 64;
		}
		case X86_ID_D: {
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
		case X86_ID_CS_Base: {
			return 64;
		}
		case X86_ID_DS_Base: {
			return 64;
		}
		case X86_ID_SS_Base: {
			return 64;
		}
		case X86_ID_ES_Base: {
			return 64;
		}
		case X86_ID_FS_Base: {
			return 64;
		}
		case X86_ID_GS_Base: {
			return 64;
		}
		case X86_ID_CS: {
			return 16;
		}
		case X86_ID_DS: {
			return 16;
		}
		case X86_ID_SS: {
			return 16;
		}
		case X86_ID_ES: {
			return 16;
		}
		case X86_ID_FS: {
			return 16;
		}
		case X86_ID_GS: {
			return 16;
		}
		case X86_ID_ST0: {
			return 80;
		}
		case X86_ID_ST1: {
			return 80;
		}
		case X86_ID_ST2: {
			return 80;
		}
		case X86_ID_ST3: {
			return 80;
		}
		case X86_ID_ST4: {
			return 80;
		}
		case X86_ID_ST5: {
			return 80;
		}
		case X86_ID_ST6: {
			return 80;
		}
		case X86_ID_ST7: {
			return 80;
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
			return 256;
		}
		case X86_ID_XMM1: {
			return 256;
		}
		case X86_ID_XMM2: {
			return 256;
		}
		case X86_ID_XMM3: {
			return 256;
		}
		case X86_ID_XMM4: {
			return 256;
		}
		case X86_ID_XMM5: {
			return 256;
		}
		case X86_ID_XMM6: {
			return 256;
		}
		case X86_ID_XMM7: {
			return 256;
		}
		case X86_ID_XMM8: {
			return 256;
		}
		case X86_ID_XMM9: {
			return 256;
		}
		case X86_ID_XMM10: {
			return 256;
		}
		case X86_ID_XMM11: {
			return 256;
		}
		case X86_ID_XMM12: {
			return 256;
		}
		case X86_ID_XMM13: {
			return 256;
		}
		case X86_ID_XMM14: {
			return 256;
		}
		case X86_ID_XMM15: {
			return 256;
		}
		case X86_ID_VIRT_LES: {
			return 1;
		}
		case X86_ID_VIRT_LEU: {
			return 1;
		}
		case X86_ID_VIRT_LTS: {
			return 1;
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

enum x86_id x86_reg_from_name(char const *name) {
	if(!strcmp(name, "IP")) {
		return X86_ID_IP;
	} else if(!strcmp(name, "FLAGS")) {
		return X86_ID_FLAGS;
	} else if(!strcmp(name, "MXCSR")) {
		return X86_ID_MXCSR;
	} else if(!strcmp(name, "A")) {
		return X86_ID_A;
	} else if(!strcmp(name, "B")) {
		return X86_ID_B;
	} else if(!strcmp(name, "C")) {
		return X86_ID_C;
	} else if(!strcmp(name, "D")) {
		return X86_ID_D;
	} else if(!strcmp(name, "SI")) {
		return X86_ID_SI;
	} else if(!strcmp(name, "DI")) {
		return X86_ID_DI;
	} else if(!strcmp(name, "SP")) {
		return X86_ID_SP;
	} else if(!strcmp(name, "BP")) {
		return X86_ID_BP;
	} else if(!strcmp(name, "R8")) {
		return X86_ID_R8;
	} else if(!strcmp(name, "R9")) {
		return X86_ID_R9;
	} else if(!strcmp(name, "R10")) {
		return X86_ID_R10;
	} else if(!strcmp(name, "R11")) {
		return X86_ID_R11;
	} else if(!strcmp(name, "R12")) {
		return X86_ID_R12;
	} else if(!strcmp(name, "R13")) {
		return X86_ID_R13;
	} else if(!strcmp(name, "R14")) {
		return X86_ID_R14;
	} else if(!strcmp(name, "R15")) {
		return X86_ID_R15;
	} else if(!strcmp(name, "CS")) {
		return X86_ID_CS;
	} else if(!strcmp(name, "DS")) {
		return X86_ID_DS;
	} else if(!strcmp(name, "SS")) {
		return X86_ID_SS;
	} else if(!strcmp(name, "ES")) {
		return X86_ID_ES;
	} else if(!strcmp(name, "FS")) {
		return X86_ID_FS;
	} else if(!strcmp(name, "GS")) {
		return X86_ID_GS;
	} else if(!strcmp(name, "CS_Base")) {
		return X86_ID_CS_Base;
	} else if(!strcmp(name, "DS_Base")) {
		return X86_ID_DS_Base;
	} else if(!strcmp(name, "SS_Base")) {
		return X86_ID_SS_Base;
	} else if(!strcmp(name, "ES_Base")) {
		return X86_ID_ES_Base;
	} else if(!strcmp(name, "FS_Base")) {
		return X86_ID_FS_Base;
	} else if(!strcmp(name, "GS_Base")) {
		return X86_ID_GS_Base;
	} else if(!strcmp(name, "ST0")) {
		return X86_ID_ST0;
	} else if(!strcmp(name, "ST1")) {
		return X86_ID_ST1;
	} else if(!strcmp(name, "ST2")) {
		return X86_ID_ST2;
	} else if(!strcmp(name, "ST3")) {
		return X86_ID_ST3;
	} else if(!strcmp(name, "ST4")) {
		return X86_ID_ST4;
	} else if(!strcmp(name, "ST5")) {
		return X86_ID_ST5;
	} else if(!strcmp(name, "ST6")) {
		return X86_ID_ST6;
	} else if(!strcmp(name, "ST7")) {
		return X86_ID_ST7;
	} else if(!strcmp(name, "MM0")) {
		return X86_ID_MM0;
	} else if(!strcmp(name, "MM1")) {
		return X86_ID_MM1;
	} else if(!strcmp(name, "MM2")) {
		return X86_ID_MM2;
	} else if(!strcmp(name, "MM3")) {
		return X86_ID_MM3;
	} else if(!strcmp(name, "MM4")) {
		return X86_ID_MM4;
	} else if(!strcmp(name, "MM5")) {
		return X86_ID_MM5;
	} else if(!strcmp(name, "MM6")) {
		return X86_ID_MM6;
	} else if(!strcmp(name, "MM7")) {
		return X86_ID_MM7;
	} else if(!strcmp(name, "XMM0")) {
		return X86_ID_XMM0;
	} else if(!strcmp(name, "XMM1")) {
		return X86_ID_XMM1;
	} else if(!strcmp(name, "XMM2")) {
		return X86_ID_XMM2;
	} else if(!strcmp(name, "XMM3")) {
		return X86_ID_XMM3;
	} else if(!strcmp(name, "XMM4")) {
		return X86_ID_XMM4;
	} else if(!strcmp(name, "XMM5")) {
		return X86_ID_XMM5;
	} else if(!strcmp(name, "XMM6")) {
		return X86_ID_XMM6;
	} else if(!strcmp(name, "XMM7")) {
		return X86_ID_XMM7;
	} else if(!strcmp(name, "XMM8")) {
		return X86_ID_XMM8;
	} else if(!strcmp(name, "XMM9")) {
		return X86_ID_XMM9;
	} else if(!strcmp(name, "XMM10")) {
		return X86_ID_XMM10;
	} else if(!strcmp(name, "XMM11")) {
		return X86_ID_XMM11;
	} else if(!strcmp(name, "XMM12")) {
		return X86_ID_XMM12;
	} else if(!strcmp(name, "XMM13")) {
		return X86_ID_XMM13;
	} else if(!strcmp(name, "XMM14")) {
		return X86_ID_XMM14;
	} else if(!strcmp(name, "XMM15")) {
		return X86_ID_XMM15;
	} else if(!strcmp(name, "LES")) {
		return X86_ID_VIRT_LES;
	} else if(!strcmp(name, "LEU")) {
		return X86_ID_VIRT_LEU;
	} else if(!strcmp(name, "LTS")) {
		return X86_ID_VIRT_LTS;
	}
	return 0;
}

enum x86_exception x86_exception_from_name(char const *name) {
	if(!strcmp(name, "{Exception: Division overflow}")) {
		return X86_EXCEPTION_DIVISION_OVERFLOW;
	}
	return 0;
}
