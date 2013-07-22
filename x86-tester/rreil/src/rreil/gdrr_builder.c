/*
 * rreil_builder.c
 *
 *  Created on: 03.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <gdrr.h>
#include <dis.h>
#include <rreil/rreil.h>
#include <x86.h>

// sem_id
static gdrr_sem_id_t *virt_eq(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_VIRTUAL;
	id->virtual_ = RREIL_ID_VIRTUAL_EQ;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *virt_neq(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_VIRTUAL;
	id->virtual_ = RREIL_ID_VIRTUAL_NEQ;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *virt_les(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_VIRTUAL;
	id->virtual_ = RREIL_ID_VIRTUAL_LES;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *virt_leu(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_VIRTUAL;
	id->virtual_ = RREIL_ID_VIRTUAL_LEU;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *virt_lts(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_VIRTUAL;
	id->virtual_ = RREIL_ID_VIRTUAL_LTS;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *virt_ltu(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_VIRTUAL;
	id->virtual_ = RREIL_ID_VIRTUAL_LTU;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *virt_t(void *closure, __word t) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_TEMPORARY;
	id->temporary = t;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_ip(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_IP;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_flags(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_FLAGS;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_mxcsr(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_MXCSR;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_ax(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_AX;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_bx(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_BX;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_cx(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_CX;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_dx(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_DX;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_si(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_SI;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_di(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_DI;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_sp(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_SP;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_bp(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_BP;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_r8(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_R8;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_r9(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_R9;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_r10(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_R10;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_r11(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_R11;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_r12(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_R12;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_r13(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_R13;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_r14(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_R14;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_r15(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_R15;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_cs(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_CS;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_ds(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_DS;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_ss(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_SS;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_es(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_ES;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_fs(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_FS;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_gs(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_GS;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_st0(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_ST0;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_st1(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_ST1;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_st2(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_ST2;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_st3(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_ST3;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_st4(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_ST4;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_st5(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_ST5;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_st6(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_ST6;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_st7(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_ST7;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_mm0(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_MM0;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_mm1(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_MM1;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_mm2(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_MM2;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_mm3(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_MM3;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_mm4(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_MM4;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_mm5(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_MM5;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_mm6(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_MM6;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_mm7(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_MM7;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm0(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM0;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm1(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM1;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm2(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM2;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm3(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM3;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm4(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM4;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm5(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM5;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm6(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM6;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm7(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM7;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm8(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM8;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm9(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM9;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm10(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM10;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm11(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM11;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm12(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM12;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm13(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM13;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm14(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM14;
	return (gdrr_sem_id_t*)id;
}
static gdrr_sem_id_t *sem_xmm15(void *closure) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->virtual_ = X86_ID_XMM15;
	return (gdrr_sem_id_t*)id;
}

// sem_address
static gdrr_sem_address_t *sem_address(void *closure, __word size,
		gdrr_sem_linear_t *address) {
	struct rreil_address *address_ = (struct rreil_address*)malloc(
			sizeof(struct rreil_address));
	address_->size = size;
	address_->address = (struct rreil_linear*)address;
	return (gdrr_sem_address_t*)address_;
}

// sem_var
static gdrr_sem_var_t *sem_var(void *closure, gdrr_sem_id_t *id, __word offset) {
	struct rreil_variable *variable = (struct rreil_variable*)malloc(
			sizeof(struct rreil_variable));
	variable->id = (struct rreil_id*)id;
	variable->offset = offset;
	return (gdrr_sem_var_t*)variable;
}

// sem_linear
static gdrr_sem_linear_t *sem_lin_var(void *closure, gdrr_sem_var_t *this) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_VARIABLE;
	linear->variable = (struct rreil_variable*)this;
	return (gdrr_sem_linear_t*)linear;
}
static gdrr_sem_linear_t *sem_lin_imm(void *closure, __word imm) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_IMMEDIATE;
	linear->immediate = imm;
	return (gdrr_sem_linear_t*)linear;
}
static gdrr_sem_linear_t *sem_lin_add(void *closure, gdrr_sem_linear_t *opnd1,
		gdrr_sem_linear_t *opnd2) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_SUM;
	linear->sum.opnd1 = (struct rreil_linear*)opnd1;
	linear->sum.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_linear_t*)linear;
}
static gdrr_sem_linear_t *sem_lin_sub(void *closure, gdrr_sem_linear_t *opnd1,
		gdrr_sem_linear_t *opnd2) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_DIFFERENCE;
	linear->difference.opnd1 = (struct rreil_linear*)opnd1;
	linear->difference.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_linear_t*)linear;
}
static gdrr_sem_linear_t *sem_lin_scale(void *closure, __word imm,
		gdrr_sem_linear_t *opnd) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_SCALE;
	linear->scale.imm = imm;
	linear->scale.opnd = (struct rreil_linear*)opnd;
	return (gdrr_sem_linear_t*)linear;
}

// sem_sexpr
static gdrr_sem_sexpr_t *sem_sexpr_lin(void *closure, gdrr_sem_linear_t *this) {
	struct rreil_sexpr *sexpr = (struct rreil_sexpr*)malloc(
			sizeof(struct rreil_sexpr));
	sexpr->type = RREIL_SEXPR_TYPE_LIN;
	sexpr->lin = (struct rreil_linear*)this;
	return (gdrr_sem_sexpr_t*)sexpr;
}
static gdrr_sem_sexpr_t *sem_sexpr_cmp(void *closure, gdrr_sem_op_cmp_t *this) {
	struct rreil_sexpr *sexpr = (struct rreil_sexpr*)malloc(
			sizeof(struct rreil_sexpr));
	sexpr->type = RREIL_SEXPR_TYPE_CMP;
	sexpr->cmp = (struct rreil_comparator*)this;
	return (gdrr_sem_sexpr_t*)sexpr;
}

// sem_op_cmp
static gdrr_sem_op_cmp_t *sem_cmpeq(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_EQ;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmpneq(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_NEQ;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmples(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LES;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmpleu(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LEU;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmplts(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LTS;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmpltu(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LTU;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}

// sem_op
static gdrr_sem_op_t *sem_lin(void *closure, __word size,
		gdrr_sem_linear_t *opnd1) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_LIN;
	op->lin.size = size;
	op->lin.opnd1 = (struct rreil_linear*)opnd1;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_mul(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_MUL;
	op->mul.size = size;
	op->mul.opnd1 = (struct rreil_linear*)opnd1;
	op->mul.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_div(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_DIV;
	op->div.size = size;
	op->div.opnd1 = (struct rreil_linear*)opnd1;
	op->div.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_divs(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_DIVS;
	op->divs.size = size;
	op->divs.opnd1 = (struct rreil_linear*)opnd1;
	op->divs.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_mod(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_MOD;
	op->mod.size = size;
	op->mod.opnd1 = (struct rreil_linear*)opnd1;
	op->mod.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_shl(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SHL;
	op->shl.size = size;
	op->shl.opnd1 = (struct rreil_linear*)opnd1;
	op->shl.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_shr(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SHR;
	op->shr.size = size;
	op->shr.opnd1 = (struct rreil_linear*)opnd1;
	op->shr.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_shrs(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SHRS;
	op->shrs.size = size;
	op->shrs.opnd1 = (struct rreil_linear*)opnd1;
	op->shrs.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_and(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_AND;
	op->and_.size = size;
	op->and_.opnd1 = (struct rreil_linear*)opnd1;
	op->and_.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_or(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_OR;
	op->or_.size = size;
	op->or_.opnd1 = (struct rreil_linear*)opnd1;
	op->or_.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_xor(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_XOR;
	op->xor_.size = size;
	op->xor_.opnd1 = (struct rreil_linear*)opnd1;
	op->xor_.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_sx(void *closure, __word size, __word fromsize,
		gdrr_sem_linear_t *opnd1) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SX;
	op->sx.size = size;
	op->sx.fromsize = fromsize;
	op->sx.opnd = (struct rreil_linear*)opnd1;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_zx(void *closure, __word size, __word fromsize,
		gdrr_sem_linear_t *opnd1) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_ZX;
	op->zx.size = size;
	op->zx.fromsize = fromsize;
	op->zx.opnd = (struct rreil_linear*)opnd1;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_cmp(void *closure, gdrr_sem_op_cmp_t *this) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_CMP;
	op->cmp = (struct rreil_comparator*)this;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_arb(void *closure, __word size) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_ARB;
	op->arb.size = size;
	return (gdrr_sem_op_t*)op;
}

// sem_branch_hint
static gdrr_sem_branch_hint_t *hint_jump(void *closure) {
	enum rreil_branch_hint *hint = (enum rreil_branch_hint*)malloc(
			sizeof(enum rreil_branch_hint));
	*hint = RREIL_BRANCH_HINT_JUMP;
	return (gdrr_sem_branch_hint_t*)hint;
}
static gdrr_sem_branch_hint_t *hint_call(void *closure) {
	enum rreil_branch_hint *hint = (enum rreil_branch_hint*)malloc(
			sizeof(enum rreil_branch_hint));
	*hint = RREIL_BRANCH_HINT_CALL;
	return (gdrr_sem_branch_hint_t*)hint;
}
static gdrr_sem_branch_hint_t *hint_ret(void *closure) {
	enum rreil_branch_hint *hint = (enum rreil_branch_hint*)malloc(
			sizeof(enum rreil_branch_hint));
	*hint = RREIL_BRANCH_HINT_RET;
	return (gdrr_sem_branch_hint_t*)hint;
}

// sem_stmt
static gdrr_sem_stmt_t *sem_assign(void *closure, gdrr_sem_var_t *lhs,
		gdrr_sem_op_t *rhs) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_ASSIGN;
	statement->assign.lhs = (struct rreil_variable*)lhs;
	statement->assign.rhs = (struct rreil_op*)rhs;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_load(void *closure, gdrr_sem_var_t *lhs,
		__word size, gdrr_sem_address_t *address) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_LOAD;
	statement->load.lhs = (struct rreil_variable*)lhs;
	statement->load.size = size;
	statement->load.address = (struct rreil_address*)address;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_store(void *closure, gdrr_sem_address_t *address,
		gdrr_sem_op_t *rhs) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_STORE;
	statement->store.address = (struct rreil_address*)address;
	statement->store.rhs = (struct rreil_op*)rhs;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_ite(void *closure, gdrr_sem_sexpr_t *cond,
		gdrr_sem_stmts_t *then_branch, gdrr_sem_stmts_t *else_branch) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_ITE;
	statement->ite.cond = (struct rreil_sexpr*)cond;
	statement->ite.then_branch = (struct rreil_statements*)then_branch;
	statement->ite.else_branch = (struct rreil_statements*)else_branch;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_while(void *closure, gdrr_sem_linear_t *cond,
		gdrr_sem_stmts_t *body) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_WHILE;
	statement->while_.cond = (struct rreil_sexpr*)cond;
	statement->while_.body = (struct rreil_statements*)body;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_cbranch(void *closure, gdrr_sem_linear_t *cond,
		gdrr_sem_address_t *target_true, gdrr_sem_address_t *target_false) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_CBRANCH;
	statement->cbranch.cond = (struct rreil_sexpr*)cond;
	statement->cbranch.target_true = (struct rreil_address*)target_true;
	statement->cbranch.target_false = (struct rreil_address*)target_false;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_branch(void *closure,
		gdrr_sem_branch_hint_t *branch_hint, gdrr_sem_address_t *target) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_BRANCH;
	statement->branch.hint = (enum rreil_branch_hint*)branch_hint;
	statement->branch.target = (struct rreil_address*)target;
	return (gdrr_sem_stmt_t*)statement;
}

// sem_stmts
static gdrr_sem_stmts_t *list_next(void *closure, gdrr_sem_stmt_t *next,
		gdrr_sem_stmts_t *list) {
	struct rreil_statements *statements = (struct rreil_statements*)list;
	if(statements->statements_length + 1 > statements->statements_size) {
		statements->statements_size =
				statements->statements_size ? statements->statements_size << 1 : 4;
		statements->statements = (struct rreil_statement**)realloc(
				statements->statements,
				statements->statements_size * sizeof(struct rreil_statement*));
	}
	statements->statements[statements->statements_length++] =
			(struct rreil_statement*)next;
	return (gdrr_sem_stmts_t*)statements;
}
static gdrr_sem_stmts_t *list_init(void *closure) {
	struct rreil_statements *statements = (struct rreil_statements*)malloc(
			sizeof(struct rreil_statements));
	statements->statements = NULL;
	statements->statements_length = 0;
	statements->statements_size = 0;
	return (gdrr_sem_stmts_t*)statements;
}

struct gdrr_config *rreil_gdrr_builder_config_get() {
	struct gdrr_config *config = (struct gdrr_config*)malloc(
			sizeof(struct gdrr_config));

	config->callbacks.sem_id.virt_eq = &virt_eq;
	config->callbacks.sem_id.virt_neq = &virt_neq;
	config->callbacks.sem_id.virt_les = &virt_les;
	config->callbacks.sem_id.virt_leu = &virt_leu;
	config->callbacks.sem_id.virt_lts = &virt_lts;
	config->callbacks.sem_id.virt_ltu = &virt_ltu;
	config->callbacks.sem_id.virt_t = &virt_t;
	config->callbacks.arch.x86.sem_id.sem_ip = &sem_ip;
	config->callbacks.arch.x86.sem_id.sem_flags = &sem_flags;
	config->callbacks.arch.x86.sem_id.sem_mxcsr = &sem_mxcsr;
	config->callbacks.arch.x86.sem_id.sem_ax = &sem_ax;
	config->callbacks.arch.x86.sem_id.sem_bx = &sem_bx;
	config->callbacks.arch.x86.sem_id.sem_cx = &sem_cx;
	config->callbacks.arch.x86.sem_id.sem_dx = &sem_dx;
	config->callbacks.arch.x86.sem_id.sem_si = &sem_si;
	config->callbacks.arch.x86.sem_id.sem_di = &sem_di;
	config->callbacks.arch.x86.sem_id.sem_sp = &sem_sp;
	config->callbacks.arch.x86.sem_id.sem_bp = &sem_bp;
	config->callbacks.arch.x86.sem_id.sem_r8 = &sem_r8;
	config->callbacks.arch.x86.sem_id.sem_r9 = &sem_r9;
	config->callbacks.arch.x86.sem_id.sem_r10 = &sem_r10;
	config->callbacks.arch.x86.sem_id.sem_r11 = &sem_r11;
	config->callbacks.arch.x86.sem_id.sem_r12 = &sem_r12;
	config->callbacks.arch.x86.sem_id.sem_r13 = &sem_r13;
	config->callbacks.arch.x86.sem_id.sem_r14 = &sem_r14;
	config->callbacks.arch.x86.sem_id.sem_r15 = &sem_r15;
	config->callbacks.arch.x86.sem_id.sem_cs = &sem_cs;
	config->callbacks.arch.x86.sem_id.sem_ds = &sem_ds;
	config->callbacks.arch.x86.sem_id.sem_ss = &sem_ss;
	config->callbacks.arch.x86.sem_id.sem_es = &sem_es;
	config->callbacks.arch.x86.sem_id.sem_fs = &sem_fs;
	config->callbacks.arch.x86.sem_id.sem_gs = &sem_gs;
	config->callbacks.arch.x86.sem_id.sem_st0 = &sem_st0;
	config->callbacks.arch.x86.sem_id.sem_st1 = &sem_st1;
	config->callbacks.arch.x86.sem_id.sem_st2 = &sem_st2;
	config->callbacks.arch.x86.sem_id.sem_st3 = &sem_st3;
	config->callbacks.arch.x86.sem_id.sem_st4 = &sem_st4;
	config->callbacks.arch.x86.sem_id.sem_st5 = &sem_st5;
	config->callbacks.arch.x86.sem_id.sem_st6 = &sem_st6;
	config->callbacks.arch.x86.sem_id.sem_st7 = &sem_st7;
	config->callbacks.arch.x86.sem_id.sem_mm0 = &sem_mm0;
	config->callbacks.arch.x86.sem_id.sem_mm1 = &sem_mm1;
	config->callbacks.arch.x86.sem_id.sem_mm2 = &sem_mm2;
	config->callbacks.arch.x86.sem_id.sem_mm3 = &sem_mm3;
	config->callbacks.arch.x86.sem_id.sem_mm4 = &sem_mm4;
	config->callbacks.arch.x86.sem_id.sem_mm5 = &sem_mm5;
	config->callbacks.arch.x86.sem_id.sem_mm6 = &sem_mm6;
	config->callbacks.arch.x86.sem_id.sem_mm7 = &sem_mm7;
	config->callbacks.arch.x86.sem_id.sem_xmm0 = &sem_xmm0;
	config->callbacks.arch.x86.sem_id.sem_xmm1 = &sem_xmm1;
	config->callbacks.arch.x86.sem_id.sem_xmm2 = &sem_xmm2;
	config->callbacks.arch.x86.sem_id.sem_xmm3 = &sem_xmm3;
	config->callbacks.arch.x86.sem_id.sem_xmm4 = &sem_xmm4;
	config->callbacks.arch.x86.sem_id.sem_xmm5 = &sem_xmm5;
	config->callbacks.arch.x86.sem_id.sem_xmm6 = &sem_xmm6;
	config->callbacks.arch.x86.sem_id.sem_xmm7 = &sem_xmm7;
	config->callbacks.arch.x86.sem_id.sem_xmm8 = &sem_xmm8;
	config->callbacks.arch.x86.sem_id.sem_xmm9 = &sem_xmm9;
	config->callbacks.arch.x86.sem_id.sem_xmm10 = &sem_xmm10;
	config->callbacks.arch.x86.sem_id.sem_xmm11 = &sem_xmm11;
	config->callbacks.arch.x86.sem_id.sem_xmm12 = &sem_xmm12;
	config->callbacks.arch.x86.sem_id.sem_xmm13 = &sem_xmm13;
	config->callbacks.arch.x86.sem_id.sem_xmm14 = &sem_xmm14;
	config->callbacks.arch.x86.sem_id.sem_xmm15 = &sem_xmm15;

	config->callbacks.sem_address.sem_address = &sem_address;

	config->callbacks.sem_var.sem_var = &sem_var;

	config->callbacks.sem_linear.sem_lin_var = &sem_lin_var;
	config->callbacks.sem_linear.sem_lin_imm = &sem_lin_imm;
	config->callbacks.sem_linear.sem_lin_add = &sem_lin_add;
	config->callbacks.sem_linear.sem_lin_sub = &sem_lin_sub;
	config->callbacks.sem_linear.sem_lin_scale = &sem_lin_scale;

	config->callbacks.sem_op_cmp.sem_cmpeq = &sem_cmpeq;
	config->callbacks.sem_op_cmp.sem_cmpneq = &sem_cmpneq;
	config->callbacks.sem_op_cmp.sem_cmples = &sem_cmples;
	config->callbacks.sem_op_cmp.sem_cmpleu = &sem_cmpleu;
	config->callbacks.sem_op_cmp.sem_cmplts = &sem_cmplts;
	config->callbacks.sem_op_cmp.sem_cmpltu = &sem_cmpltu;

	config->callbacks.sem_sexpr.sem_sexpr_lin = &sem_sexpr_lin;
	config->callbacks.sem_sexpr.sem_sexpr_cmp = &sem_sexpr_cmp;

	config->callbacks.sem_op.sem_lin = &sem_lin;
	config->callbacks.sem_op.sem_mul = &sem_mul;
	config->callbacks.sem_op.sem_div = &sem_div;
	config->callbacks.sem_op.sem_divs = &sem_divs;
	config->callbacks.sem_op.sem_mod = &sem_mod;
	config->callbacks.sem_op.sem_shl = &sem_shl;
	config->callbacks.sem_op.sem_shr = &sem_shr;
	config->callbacks.sem_op.sem_shrs = &sem_shrs;
	config->callbacks.sem_op.sem_and = &sem_and;
	config->callbacks.sem_op.sem_or = &sem_or;
	config->callbacks.sem_op.sem_xor = &sem_xor;
	config->callbacks.sem_op.sem_sx = &sem_sx;
	config->callbacks.sem_op.sem_zx = &sem_zx;
	config->callbacks.sem_op.sem_cmp = &sem_cmp;
	config->callbacks.sem_op.sem_arb = &sem_arb;

	config->callbacks.sem_branch_hint.hint_jump = &hint_jump;
	config->callbacks.sem_branch_hint.hint_call = &hint_call;
	config->callbacks.sem_branch_hint.hint_ret = &hint_ret;

	config->callbacks.sem_stmt.sem_assign = &sem_assign;
	config->callbacks.sem_stmt.sem_load = &sem_load;
	config->callbacks.sem_stmt.sem_store = &sem_store;
	config->callbacks.sem_stmt.sem_ite = &sem_ite;
	config->callbacks.sem_stmt.sem_while = &sem_while;
	config->callbacks.sem_stmt.sem_cbranch = &sem_cbranch;
	config->callbacks.sem_stmt.sem_branch = &sem_branch;

	config->callbacks.sem_stmts_list.list_init = &list_init;
	config->callbacks.sem_stmts_list.list_next = &list_next;
	config->gdrr_config_stmts_handling = GDRR_CONFIG_STMTS_HANDLING_LIST;

	return config;
}
