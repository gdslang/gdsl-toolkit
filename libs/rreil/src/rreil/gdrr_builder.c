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
#include <gdsl.h>
#include <rreil/rreil.h>
#include <x86.h>

// sem_id
//static gdrr_sem_id_t *virt_na(state_t state, int_t con) {
//	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
//	id->type = RREIL_ID_TYPE_VIRTUAL;
//	switch(con) {
//		case CON_VIRT_EQ: {
//			id->virtual_ = RREIL_ID_VIRTUAL_EQ;
//			break;
//		}
//		case CON_VIRT_NEQ: {
//			id->virtual_ = RREIL_ID_VIRTUAL_NEQ;
//			break;
//		}
//		case CON_VIRT_LES: {
//			id->virtual_ = RREIL_ID_VIRTUAL_LES;
//			break;
//		}
//		case CON_VIRT_LEU: {
//			id->virtual_ = RREIL_ID_VIRTUAL_LEU;
//			break;
//		}
//		case CON_VIRT_LTS: {
//			id->virtual_ = RREIL_ID_VIRTUAL_LTS;
//			break;
//		}
//		case CON_VIRT_LTU: {
//			id->virtual_ = RREIL_ID_VIRTUAL_LTU;
//			break;
//		}
//	}
//	return (gdrr_sem_id_t*)id;
//}

static gdrr_sem_id_t *virt_t(state_t state, int_t t) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_TEMPORARY;
	id->temporary = t;
	return (gdrr_sem_id_t*)id;
}

#ifdef GDSL_X86
gdrr_sem_id_t *sem_id_arch(state_t state, int_t con) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->x86 = (uint32_t)x86_reg_from_con(con);
	return id;
}
#else
gdrr_sem_id_t *sem_id_arch(state_t state, int_t con) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_ARCH;
	id->arch = (uint32_t)con;
	return id;
}
#endif

// sem_address
static gdrr_sem_address_t *sem_address(state_t state, int_t size,
		gdrr_sem_linear_t *address) {
	struct rreil_address *address_ = (struct rreil_address*)malloc(
			sizeof(struct rreil_address));
	address_->size = size;
	address_->address = (struct rreil_linear*)address;
	return (gdrr_sem_address_t*)address_;
}

// sem_var
static gdrr_sem_var_t *sem_var(state_t state, gdrr_sem_id_t *id, int_t offset) {
	struct rreil_variable *variable = (struct rreil_variable*)malloc(
			sizeof(struct rreil_variable));
	variable->id = (struct rreil_id*)id;
	variable->offset = offset;
	return (gdrr_sem_var_t*)variable;
}

// sem_linear
static gdrr_sem_linear_t *sem_lin_var(state_t state, gdrr_sem_var_t *this) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_VARIABLE;
	linear->variable = (struct rreil_variable*)this;
	return (gdrr_sem_linear_t*)linear;
}
static gdrr_sem_linear_t *sem_lin_imm(state_t state, int_t imm) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_IMMEDIATE;
	linear->immediate = imm;
	return (gdrr_sem_linear_t*)linear;
}
static gdrr_sem_linear_t *sem_lin_add(state_t state, gdrr_sem_linear_t *opnd1,
		gdrr_sem_linear_t *opnd2) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_SUM;
	linear->sum.opnd1 = (struct rreil_linear*)opnd1;
	linear->sum.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_linear_t*)linear;
}
static gdrr_sem_linear_t *sem_lin_sub(state_t state, gdrr_sem_linear_t *opnd1,
		gdrr_sem_linear_t *opnd2) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_DIFFERENCE;
	linear->difference.opnd1 = (struct rreil_linear*)opnd1;
	linear->difference.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_linear_t*)linear;
}
static gdrr_sem_linear_t *sem_lin_scale(state_t state, int_t imm,
		gdrr_sem_linear_t *opnd) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_SCALE;
	linear->scale.imm = imm;
	linear->scale.opnd = (struct rreil_linear*)opnd;
	return (gdrr_sem_linear_t*)linear;
}

// sem_sexpr
static gdrr_sem_sexpr_t *sem_sexpr_lin(state_t state, gdrr_sem_linear_t *this) {
	struct rreil_sexpr *sexpr = (struct rreil_sexpr*)malloc(
			sizeof(struct rreil_sexpr));
	sexpr->type = RREIL_SEXPR_TYPE_LIN;
	sexpr->lin = (struct rreil_linear*)this;
	return (gdrr_sem_sexpr_t*)sexpr;
}
static gdrr_sem_sexpr_t *sem_sexpr_cmp(state_t state, gdrr_sem_op_cmp_t *this) {
	struct rreil_sexpr *sexpr = (struct rreil_sexpr*)malloc(
			sizeof(struct rreil_sexpr));
	sexpr->type = RREIL_SEXPR_TYPE_CMP;
	sexpr->cmp = (struct rreil_comparator*)this;
	return (gdrr_sem_sexpr_t*)sexpr;
}

// sem_op_cmp
static gdrr_sem_op_cmp_t *sem_cmpeq(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_EQ;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmpneq(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_NEQ;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmples(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LES;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmpleu(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LEU;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmplts(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LTS;
	comparator->arity2.size = size;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_cmp_t*)comparator;
}
static gdrr_sem_op_cmp_t *sem_cmpltu(state_t state, int_t size,
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
static gdrr_sem_op_t *sem_lin(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_LIN;
	op->lin.size = size;
	op->lin.opnd1 = (struct rreil_linear*)opnd1;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_mul(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_MUL;
	op->mul.size = size;
	op->mul.opnd1 = (struct rreil_linear*)opnd1;
	op->mul.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_div(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_DIV;
	op->div.size = size;
	op->div.opnd1 = (struct rreil_linear*)opnd1;
	op->div.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_divs(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_DIVS;
	op->divs.size = size;
	op->divs.opnd1 = (struct rreil_linear*)opnd1;
	op->divs.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_mod(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_MOD;
	op->mod.size = size;
	op->mod.opnd1 = (struct rreil_linear*)opnd1;
	op->mod.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_shl(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SHL;
	op->shl.size = size;
	op->shl.opnd1 = (struct rreil_linear*)opnd1;
	op->shl.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_shr(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SHR;
	op->shr.size = size;
	op->shr.opnd1 = (struct rreil_linear*)opnd1;
	op->shr.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_shrs(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SHRS;
	op->shrs.size = size;
	op->shrs.opnd1 = (struct rreil_linear*)opnd1;
	op->shrs.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_and(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_AND;
	op->and_.size = size;
	op->and_.opnd1 = (struct rreil_linear*)opnd1;
	op->and_.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_or(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_OR;
	op->or_.size = size;
	op->or_.opnd1 = (struct rreil_linear*)opnd1;
	op->or_.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_xor(state_t state, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_XOR;
	op->xor_.size = size;
	op->xor_.opnd1 = (struct rreil_linear*)opnd1;
	op->xor_.opnd2 = (struct rreil_linear*)opnd2;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_sx(state_t state, int_t size, int_t fromsize,
		gdrr_sem_linear_t *opnd1) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_SX;
	op->sx.size = size;
	op->sx.fromsize = fromsize;
	op->sx.opnd = (struct rreil_linear*)opnd1;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_zx(state_t state, int_t size, int_t fromsize,
		gdrr_sem_linear_t *opnd1) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_ZX;
	op->zx.size = size;
	op->zx.fromsize = fromsize;
	op->zx.opnd = (struct rreil_linear*)opnd1;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_cmp(state_t state, gdrr_sem_op_cmp_t *this) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_CMP;
	op->cmp = (struct rreil_comparator*)this;
	return (gdrr_sem_op_t*)op;
}
static gdrr_sem_op_t *sem_arb(state_t state, int_t size) {
	struct rreil_op *op = (struct rreil_op*)malloc(sizeof(struct rreil_op));
	op->type = RREIL_OP_TYPE_ARB;
	op->arb.size = size;
	return (gdrr_sem_op_t*)op;
}

// sem_branch_hint
static gdrr_branch_hint_t *branch_hint(state_t state, int_t con) {
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
static gdrr_sem_stmt_t *sem_assign(state_t state, gdrr_sem_var_t *lhs,
		gdrr_sem_op_t *rhs) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_ASSIGN;
	statement->assign.lhs = (struct rreil_variable*)lhs;
	statement->assign.rhs = (struct rreil_op*)rhs;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_load(state_t state, gdrr_sem_var_t *lhs, int_t size,
		gdrr_sem_address_t *address) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_LOAD;
	statement->load.lhs = (struct rreil_variable*)lhs;
	statement->load.size = size;
	statement->load.address = (struct rreil_address*)address;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_store(state_t state, gdrr_sem_address_t *address,
		gdrr_sem_op_t *rhs) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_STORE;
	statement->store.address = (struct rreil_address*)address;
	statement->store.rhs = (struct rreil_op*)rhs;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_ite(state_t state, gdrr_sem_sexpr_t *cond,
		gdrr_sem_stmts_t *then_branch, gdrr_sem_stmts_t *else_branch) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_ITE;
	statement->ite.cond = (struct rreil_sexpr*)cond;
	statement->ite.then_branch = (struct rreil_statements*)then_branch;
	statement->ite.else_branch = (struct rreil_statements*)else_branch;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_while(state_t state, gdrr_sem_linear_t *cond,
		gdrr_sem_stmts_t *body) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_WHILE;
	statement->while_.cond = (struct rreil_sexpr*)cond;
	statement->while_.body = (struct rreil_statements*)body;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_cbranch(state_t state, gdrr_sem_linear_t *cond,
		gdrr_sem_address_t *target_true, gdrr_sem_address_t *target_false) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_CBRANCH;
	statement->cbranch.cond = (struct rreil_sexpr*)cond;
	statement->cbranch.target_true = (struct rreil_address*)target_true;
	statement->cbranch.target_false = (struct rreil_address*)target_false;
	return (gdrr_sem_stmt_t*)statement;
}
static gdrr_sem_stmt_t *sem_branch(state_t state,
		gdrr_branch_hint_t *branch_hint, gdrr_sem_address_t *target) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_BRANCH;
	statement->branch.hint = (enum rreil_branch_hint*)branch_hint;
	statement->branch.target = (struct rreil_address*)target;
	return (gdrr_sem_stmt_t*)statement;
}

// sem_stmts
static gdrr_sem_stmts_t *list_next(state_t state, gdrr_sem_stmt_t *next,
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
static gdrr_sem_stmts_t *list_init(state_t state) {
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

//	config->callbacks.sem_id.virt_na = &virt_na;
	config->callbacks.sem_id.virt_t = &virt_t;
	config->callbacks.arch.sem_id.arch = &sem_id_arch;
	config->callbacks.arch.sem_id.arch = &sem_id_arch;

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
