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
#include <gdsl-x86.h>
#include <rreil/rreil.h>
#include <x86.h>

// sem_id
static gdrr_sem_id_t *virt_na(void *closure, int_t con) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_VIRTUAL;
	switch(con) {
		case CON_VIRT_EQ: {
			id->virtual_ = RREIL_ID_VIRTUAL_EQ;
			break;
		}
		case CON_VIRT_NEQ: {
			id->virtual_ = RREIL_ID_VIRTUAL_NEQ;
			break;
		}
		case CON_VIRT_LES: {
			id->virtual_ = RREIL_ID_VIRTUAL_LES;
			break;
		}
		case CON_VIRT_LEU: {
			id->virtual_ = RREIL_ID_VIRTUAL_LEU;
			break;
		}
		case CON_VIRT_LTS: {
			id->virtual_ = RREIL_ID_VIRTUAL_LTS;
			break;
		}
		case CON_VIRT_LTU: {
			id->virtual_ = RREIL_ID_VIRTUAL_LTU;
			break;
		}
	}
	return (gdrr_sem_id_t*)id;
}

static gdrr_sem_id_t *virt_t(void *closure, int_t t) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_TEMPORARY;
	id->temporary = t;
	return (gdrr_sem_id_t*)id;
}

static gdrr_sem_id_t *x86(void *closure, int_t con) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	switch(con) {
		case CON_Sem_IP: {
			id->x86 = X86_ID_IP;
			break;
		}
		case CON_Sem_FLAGS: {
			id->x86 = X86_ID_FLAGS;
			break;
		}
		case CON_Sem_MXCSR: {
			id->x86 = X86_ID_MXCSR;
			break;
		}
		case CON_Sem_AX: {
			id->x86 = X86_ID_AX;
			break;
		}
		case CON_Sem_BX: {
			id->x86 = X86_ID_BX;
			break;
		}
		case CON_Sem_CX: {
			id->x86 = X86_ID_CX;
			break;
		}
		case CON_Sem_DX: {
			id->x86 = X86_ID_DX;
			break;
		}
		case CON_Sem_SI: {
			id->x86 = X86_ID_SI;
			break;
		}
		case CON_Sem_DI: {
			id->x86 = X86_ID_DI;
			break;
		}
		case CON_Sem_SP: {
			id->x86 = X86_ID_SP;
			break;
		}
		case CON_Sem_BP: {
			id->x86 = X86_ID_BP;
			break;
		}
		case CON_Sem_R8: {
			id->x86 = X86_ID_R8;
			break;
		}
		case CON_Sem_R9: {
			id->x86 = X86_ID_R9;
			break;
		}
		case CON_Sem_R10: {
			id->x86 = X86_ID_R10;
			break;
		}
		case CON_Sem_R11: {
			id->x86 = X86_ID_R11;
			break;
		}
		case CON_Sem_R12: {
			id->x86 = X86_ID_R12;
			break;
		}
		case CON_Sem_R13: {
			id->x86 = X86_ID_R13;
			break;
		}
		case CON_Sem_R14: {
			id->x86 = X86_ID_R14;
			break;
		}
		case CON_Sem_R15: {
			id->x86 = X86_ID_R15;
			break;
		}
		case CON_Sem_CS: {
			id->x86 = X86_ID_CS;
			break;
		}
		case CON_Sem_DS: {
			id->x86 = X86_ID_DS;
			break;
		}
		case CON_Sem_SS: {
			id->x86 = X86_ID_SS;
			break;
		}
		case CON_Sem_ES: {
			id->x86 = X86_ID_ES;
			break;
		}
		case CON_Sem_FS: {
			id->x86 = X86_ID_FS;
			break;
		}
		case CON_Sem_GS: {
			id->x86 = X86_ID_GS;
			break;
		}
		case CON_Sem_ST0: {
			id->x86 = X86_ID_ST0;
			break;
		}
		case CON_Sem_ST1: {
			id->x86 = X86_ID_ST1;
			break;
		}
		case CON_Sem_ST2: {
			id->x86 = X86_ID_ST2;
			break;
		}
		case CON_Sem_ST3: {
			id->x86 = X86_ID_ST3;
			break;
		}
		case CON_Sem_ST4: {
			id->x86 = X86_ID_ST4;
			break;
		}
		case CON_Sem_ST5: {
			id->x86 = X86_ID_ST5;
			break;
		}
		case CON_Sem_ST6: {
			id->x86 = X86_ID_ST6;
			break;
		}
		case CON_Sem_ST7: {
			id->x86 = X86_ID_ST7;
			break;
		}
		case CON_Sem_MM0: {
			id->x86 = X86_ID_MM0;
			break;
		}
		case CON_Sem_MM1: {
			id->x86 = X86_ID_MM1;
			break;
		}
		case CON_Sem_MM2: {
			id->x86 = X86_ID_MM2;
			break;
		}
		case CON_Sem_MM3: {
			id->x86 = X86_ID_MM3;
			break;
		}
		case CON_Sem_MM4: {
			id->x86 = X86_ID_MM4;
			break;
		}
		case CON_Sem_MM5: {
			id->x86 = X86_ID_MM5;
			break;
		}
		case CON_Sem_MM6: {
			id->x86 = X86_ID_MM6;
			break;
		}
		case CON_Sem_MM7: {
			id->x86 = X86_ID_MM7;
			break;
		}
		case CON_Sem_XMM0: {
			id->x86 = X86_ID_XMM0;
			break;
		}
		case CON_Sem_XMM1: {
			id->x86 = X86_ID_XMM1;
			break;
		}
		case CON_Sem_XMM2: {
			id->x86 = X86_ID_XMM2;
			break;
		}
		case CON_Sem_XMM3: {
			id->x86 = X86_ID_XMM3;
			break;
		}
		case CON_Sem_XMM4: {
			id->x86 = X86_ID_XMM4;
			break;
		}
		case CON_Sem_XMM5: {
			id->x86 = X86_ID_XMM5;
			break;
		}
		case CON_Sem_XMM6: {
			id->x86 = X86_ID_XMM6;
			break;
		}
		case CON_Sem_XMM7: {
			id->x86 = X86_ID_XMM7;
			break;
		}
		case CON_Sem_XMM8: {
			id->x86 = X86_ID_XMM8;
			break;
		}
		case CON_Sem_XMM9: {
			id->x86 = X86_ID_XMM9;
			break;
		}
		case CON_Sem_XMM10: {
			id->x86 = X86_ID_XMM10;
			break;
		}
		case CON_Sem_XMM11: {
			id->x86 = X86_ID_XMM11;
			break;
		}
		case CON_Sem_XMM12: {
			id->x86 = X86_ID_XMM12;
			break;
		}
		case CON_Sem_XMM13: {
			id->x86 = X86_ID_XMM13;
			break;
		}
		case CON_Sem_XMM14: {
			id->x86 = X86_ID_XMM14;
			break;
		}
		case CON_Sem_XMM15: {
			id->x86 = X86_ID_XMM15;
			break;
		}
	}

	return (gdrr_sem_id_t*)id;
}

// sem_address
static gdrr_sem_address_t *sem_address(void *closure, int_t size,
		gdrr_sem_linear_t *address) {
	struct rreil_address *address_ = (struct rreil_address*)malloc(
			sizeof(struct rreil_address));
	address_->size = size;
	address_->address = (struct rreil_linear*)address;
	return (gdrr_sem_address_t*)address_;
}

// sem_var
static gdrr_sem_var_t *sem_var(void *closure, gdrr_sem_id_t *id, int_t offset) {
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
static gdrr_sem_linear_t *sem_lin_imm(void *closure, int_t imm) {
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
static gdrr_sem_linear_t *sem_lin_scale(void *closure, int_t imm,
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
static gdrr_sem_op_cmp_t *sem_cmpeq(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_EQ;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmpneq(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_NEQ;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmples(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LES;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmpleu(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LEU;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmplts(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LTS;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmpltu(void *closure, int_t size,
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
static gdrr_sem_op_t *sem_lin(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_LIN;
	op->lin.size = size;
	op->lin.opnd1 = (struct rreil_linear*)opnd1;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_mul(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_MUL;
	op->mul.size = size;
	op->mul.opnd1 = (struct rreil_linear*)opnd1;
	op->mul.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_div(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_DIV;
	op->div.size = size;
	op->div.opnd1 = (struct rreil_linear*)opnd1;
	op->div.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_divs(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_DIVS;
	op->divs.size = size;
	op->divs.opnd1 = (struct rreil_linear*)opnd1;
	op->divs.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_mod(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_MOD;
	op->mod.size = size;
	op->mod.opnd1 = (struct rreil_linear*)opnd1;
	op->mod.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_shl(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SHL;
	op->shl.size = size;
	op->shl.opnd1 = (struct rreil_linear*)opnd1;
	op->shl.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_shr(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SHR;
	op->shr.size = size;
	op->shr.opnd1 = (struct rreil_linear*)opnd1;
	op->shr.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_shrs(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SHRS;
	op->shrs.size = size;
	op->shrs.opnd1 = (struct rreil_linear*)opnd1;
	op->shrs.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_and(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_AND;
	op->and_.size = size;
	op->and_.opnd1 = (struct rreil_linear*)opnd1;
	op->and_.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_or(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_OR;
	op->or_.size = size;
	op->or_.opnd1 = (struct rreil_linear*)opnd1;
	op->or_.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_xor(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_XOR;
	op->xor_.size = size;
	op->xor_.opnd1 = (struct rreil_linear*)opnd1;
	op->xor_.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_sx(void *closure, int_t size, int_t fromsize,
		gdrr_sem_linear_t *opnd1) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SX;
	op->sx.size = size;
	op->sx.fromsize = fromsize;
	op->sx.opnd = (struct rreil_linear*)opnd1;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_zx(void *closure, int_t size, int_t fromsize,
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
static gdrr_sem_op_t *sem_arb(void *closure, int_t size) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_ARB;
	op->arb.size = size;
	return (gdrr_sem_op_t*)op;
}

// sem_branch_hint
static gdrr_branch_hint_t *branch_hint(void *closure, int_t con) {
	enum rreil_branch_hint *hint = (enum rreil_branch_hint*)malloc(
			sizeof(enum rreil_branch_hint));
	switch(con) {
		case CON_HINT_JUMP: {
			*hint = RREIL_BRANCH_HINT_JUMP;
			break;
		}
		case CON_HINT_CALL: {
			*hint = RREIL_BRANCH_HINT_CALL;
			break;
		}
		case CON_HINT_RET: {
			*hint = RREIL_BRANCH_HINT_RET;
			break;
		}
	}
	return (gdrr_branch_hint_t*)hint;
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
static gdrr_sem_stmt_t *sem_load(void *closure, gdrr_sem_var_t *lhs, int_t size,
		gdrr_sem_address_t *address) {
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
		gdrr_branch_hint_t *branch_hint, gdrr_sem_address_t *target) {
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

struct gdrr_config *rreil_gdrr_builder_config_get(state_t state) {
	struct gdrr_config *config = (struct gdrr_config*)malloc(
			sizeof(struct gdrr_config));

	config->callbacks.sem_id.virt_na = &virt_na;
	config->callbacks.sem_id.virt_t = &virt_t;
	config->callbacks.arch.x86.sem_id.x86 = &x86;

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

	config->callbacks.branch_hint.branch_hint = &branch_hint;

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

	config->state = state;

	return config;
}
