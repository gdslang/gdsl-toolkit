/*
 * x86.h
 *
 *  Created on: 15.05.2013
 *      Author: jucs
 */

#ifndef X86_H_
#define X86_H_

#include <stdlib.h>
#include <stdint.h>
#include <stdio.h>
#include <gdsl_generic.h>

enum x86_id {
	X86_ID_IP,
	X86_ID_FLAGS,
	X86_ID_MXCSR,
	X86_ID_A,
	X86_ID_B,
	X86_ID_C,
	X86_ID_D,
	X86_ID_SI,
	X86_ID_DI,
	X86_ID_SP,
	X86_ID_BP,
	X86_ID_R8,
	X86_ID_R9,
	X86_ID_R10,
	X86_ID_R11,
	X86_ID_R12,
	X86_ID_R13,
	X86_ID_R14,
	X86_ID_R15,
	X86_ID_CS,
	X86_ID_DS,
	X86_ID_SS,
	X86_ID_ES,
	X86_ID_FS,
	X86_ID_GS,
	X86_ID_CS_Base,
	X86_ID_DS_Base,
	X86_ID_SS_Base,
	X86_ID_ES_Base,
	X86_ID_FS_Base,
	X86_ID_GS_Base,
	X86_ID_ST0,
	X86_ID_ST1,
	X86_ID_ST2,
	X86_ID_ST3,
	X86_ID_ST4,
	X86_ID_ST5,
	X86_ID_ST6,
	X86_ID_ST7,
	X86_ID_MM0,
	X86_ID_MM1,
	X86_ID_MM2,
	X86_ID_MM3,
	X86_ID_MM4,
	X86_ID_MM5,
	X86_ID_MM6,
	X86_ID_MM7,
	X86_ID_XMM0,
	X86_ID_XMM1,
	X86_ID_XMM2,
	X86_ID_XMM3,
	X86_ID_XMM4,
	X86_ID_XMM5,
	X86_ID_XMM6,
	X86_ID_XMM7,
	X86_ID_XMM8,
	X86_ID_XMM9,
	X86_ID_XMM10,
	X86_ID_XMM11,
	X86_ID_XMM12,
	X86_ID_XMM13,
	X86_ID_XMM14,
	X86_ID_XMM15,
	X86_ID_VIRT_LES,
	X86_ID_VIRT_LEU,
	X86_ID_VIRT_LTS
};

#define X86_ID_COUNT (X86_ID_VIRT_LTS + 1)

enum x86_exception {
	X86_EXCEPTION_DIVISION_OVERFLOW
};

#define X86_EXCEPTION_COUNT (X86_EXCEPTION_DIVISION_OVERFLOW + 1)

#define X86_FLAGS_CARRY 0
#define X86_FLAGS_PARITY 2
#define X86_FLAGS_ADJUST 4
#define X86_FLAGS_ZERO 6
#define X86_FLAGS_SIGN 7
#define X86_FLAGS_TRAP 8
#define X86_FLAGS_INTERRUPT 9
#define X86_FLAGS_DIRECTION 10
#define X86_FLAGS_OVERFLOW 11
#define X86_FLAGS_IOP 12
#define X86_FLAGS_NT 14

enum x86_rex {
	X86_REX_W = 0x08,
	X86_REX_R = 0x04,
	X86_REX_X = 0x02,
	X86_REX_B = 0x01,
	X86_REX_NONE = 0x00
};

enum x86_vex_l {
	X86_VEX_128 = 0,
	X86_VEX_256 = 1
};

enum x86_vex_p {
	X86_VEX_P_NONE = 0,
	X86_VEX_66 = 1,
	X86_VEX_F3 = 2,
	X86_VEX_F2 = 3
};

enum x86_vex_m {
	X86_VEX_0F = 1,
	X86_VEX_0F_38 = 2,
	X86_VEX_0f_3A = 3
};

enum x86_id_type {
	X86_ID_TYPE_STANDARD,
	X86_ID_TYPE_MMX,
	X86_ID_TYPE_SSE
};

extern void x86_id_print(FILE *stream, enum x86_id id);
extern void x86_exception_print(FILE *stream, enum x86_exception exception);
extern size_t x86_amd64_sizeof(enum x86_id id);
extern enum x86_id_type x86_id_type_get(enum x86_id id);
extern enum x86_id x86_reg_from_name(char const *name);
extern enum x86_exception x86_exception_from_name(char const *name);

#endif /* X86_H_ */
