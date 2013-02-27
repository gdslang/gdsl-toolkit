/*
 * gdrr.c
 *
 *  Created on: Feb 22, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <dis.h>
#include "gdrr.h"

static gdrr_sem_id_t *gdrr_convert_sem_id(__obj sem_id_obj,
		struct gdrr_config *config);
static gdrr_sem_var_t *gdrr_convert_sem_address(__obj sem_address_obj,
		struct gdrr_config *config);
static gdrr_sem_var_t *gdrr_convert_sem_var(__obj sem_var_obj,
		struct gdrr_config *config);
static gdrr_sem_id_t *gdrr_convert_sem_linear(__obj sem_linear_obj,
		struct gdrr_config *config);
static gdrr_sem_op_t *gdrr_convert_sem_op(__obj sem_op_obj,
		struct gdrr_config *config);
static gdrr_sem_stmt_t *gdrr_convert_sem_branch_hint(__obj sem_branch_hint_obj,
		struct gdrr_config *config);
static gdrr_sem_stmt_t *gdrr_convert_sem_stmt(__obj sem_stmt_obj,
		struct gdrr_config *config);
static gdrr_sem_stmts_t *gdrr_convert_sem_stmts(__obj sem_stmts_obj,
		struct gdrr_config *config);
static gdrr_sem_stmts_t *gdrr_convert_sem_stmts_list(__obj sem_stmts_obj,
		struct gdrr_config *config);
static gdrr_sem_stmts_t *gdrr_convert_sem_stmts_with_config(__obj sem_stmts_obj,
		struct gdrr_config *config);

static gdrr_sem_id_t *gdrr_convert_sem_id(__obj sem_id_obj,
		struct gdrr_config *config) {
	gdrr_sem_id_t *sem_id = NULL;

	switch(__CASETAGCON(sem_id_obj)) {
		case __VIRT_EQ: {
			sem_id = config->callbacks.sem_id.virt_eq();
			break;
		}
		case __VIRT_NEQ: {
			sem_id = config->callbacks.sem_id.virt_neq();
			break;
		}
		case __VIRT_LES: {
			sem_id = config->callbacks.sem_id.virt_les();
			break;
		}
		case __VIRT_LEU: {
			sem_id = config->callbacks.sem_id.virt_leu();
			break;
		}
		case __VIRT_LTS: {
			sem_id = config->callbacks.sem_id.virt_lts();
			break;
		}
		case __VIRT_LTU: {
			sem_id = config->callbacks.sem_id.virt_ltu();
			break;
		}
		case __VIRT_T: {
			__obj this = __DECON(sem_id_obj);
			sem_id = config->callbacks.sem_id.virt_t(__CASETAGINT(this));
			break;
		}
	}

	return sem_id;
}

static gdrr_sem_var_t *gdrr_convert_sem_address(__obj sem_address_obj,
		struct gdrr_config *config) {
	__obj rec = __DECON(sem_address_obj);

	__obj size = __RECORD_SELECT(rec, ___id);
	__obj address = __RECORD_SELECT(rec, ___offset);

	return config->callbacks.sem_address.sem_address(__CASETAGINT(size),
			gdrr_convert_sem_linear(address, config));
}

static gdrr_sem_var_t *gdrr_convert_sem_var(__obj sem_var_obj,
		struct gdrr_config *config) {
	__obj rec = __DECON(sem_var_obj);

	__obj id = __RECORD_SELECT(rec, ___id);
	__obj offset = __RECORD_SELECT(rec, ___offset);

	return config->callbacks.sem_var.sem_var(gdrr_convert_sem_id(id, config),
			__CASETAGINT(offset));
}

static gdrr_sem_id_t *gdrr_convert_sem_linear(__obj sem_linear_obj,
		struct gdrr_config *config) {
	gdrr_sem_linear_t *sem_linear = NULL;

	__obj payload = __DECON(sem_linear_obj);

	switch(__CASETAGCON(sem_linear_obj)) {
		case __SEM_LIN_VAR: {

			sem_linear = config->callbacks.sem_linear.sem_lin_var(
					gdrr_convert_sem_var(payload, config));
			break;
		}
		case __SEM_LIN_IMM: {
			__obj imm = __RECORD_SELECT(payload, ___imm);
			sem_linear = config->callbacks.sem_linear.sem_lin_imm(__CASETAGINT(imm));
			break;
		}
		case __SEM_LIN_ADD: {
			__obj opnd1 = __RECORD_SELECT(payload, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(payload, ___opnd2);
			sem_linear = config->callbacks.sem_linear.sem_lin_add(
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_LIN_SUB: {
			__obj opnd1 = __RECORD_SELECT(payload, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(payload, ___opnd2);
			sem_linear = config->callbacks.sem_linear.sem_lin_sub(
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_LIN_SCALE: {
			__obj imm = __RECORD_SELECT(payload, ___imm);
			__obj opnd = __RECORD_SELECT(payload, ___opnd);
			sem_linear = config->callbacks.sem_linear.sem_lin_scale(__CASETAGINT(imm),
					gdrr_convert_sem_linear(opnd, config));
			break;
		}
	}

	return sem_linear;
}

static gdrr_sem_op_t *gdrr_convert_sem_op(__obj sem_op_obj,
		struct gdrr_config *config) {
	gdrr_sem_op_t *sem_op = NULL;

	__obj rec = __DECON(sem_op_obj);

	__obj size = __RECORD_SELECT(rec, ___size);
	__word size_word = __CASETAGINT(size);

	switch(__CASETAGCON(sem_op_obj)) {
		case __SEM_LIN: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			sem_op = config->callbacks.sem_op.sem_lin(size_word,
					gdrr_convert_sem_linear(opnd1, config));
			break;
		}
		case __SEM_MUL: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_mul(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_DIV: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_div(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_DIVS: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_divs(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_MOD: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_mod(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_SHL: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_shl(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_SHR: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_shr(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_SHRS: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_shrs(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_AND: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_and(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_OR: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_or(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_XOR: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_xor(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_SX: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj fromsize = __RECORD_SELECT(rec, ___fromsize);
			sem_op = config->callbacks.sem_op.sem_sx(size_word,
					__CASETAGINT(fromsize), gdrr_convert_sem_linear(opnd1, config));
			break;
		}
		case __SEM_ZX: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj fromsize = __RECORD_SELECT(rec, ___fromsize);
			sem_op = config->callbacks.sem_op.sem_zx(size_word,
					__CASETAGINT(fromsize), gdrr_convert_sem_linear(opnd1, config));
			break;
		}
		case __SEM_CMPEQ: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_cmpeq(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_CMPNEQ: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_cmpneq(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_CMPLES: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_cmples(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_CMPLEU: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_cmpleu(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_CMPLTS: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_cmplts(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_CMPLTU: {
			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
			sem_op = config->callbacks.sem_op.sem_cmpltu(size_word,
					gdrr_convert_sem_linear(opnd1, config),
					gdrr_convert_sem_linear(opnd2, config));
			break;
		}
		case __SEM_ARB: {
			sem_op = config->callbacks.sem_op.sem_arb(size_word);
			break;
		}
	}

	return sem_op;
}

static gdrr_sem_stmt_t *gdrr_convert_sem_branch_hint(__obj sem_branch_hint_obj,
		struct gdrr_config *config) {
	gdrr_sem_stmt_t *sem_branch_hint = NULL;

	switch(__CASETAGCON(sem_branch_hint_obj)) {
		case __HINT_JUMP: {
			sem_branch_hint = config->callbacks.sem_branch_hint.hint_jump();
			break;
		}
		case __HINT_CALL: {
			sem_branch_hint = config->callbacks.sem_branch_hint.hint_call();
			break;
		}
		case __HINT_RET: {
			sem_branch_hint = config->callbacks.sem_branch_hint.hint_ret();
			break;
		}
	}

	return sem_branch_hint;
}

static gdrr_sem_stmt_t *gdrr_convert_sem_stmt(__obj sem_stmt_obj,
		struct gdrr_config *config) {
	gdrr_sem_stmt_t *sem_stmt = NULL;

	__obj rec = __DECON(sem_stmt_obj);
	switch(__CASETAGCON(sem_stmt_obj)) {
		case __SEM_ASSIGN: {
			__obj lhs = __RECORD_SELECT(rec, ___lhs);
			__obj rhs = __RECORD_SELECT(rec, ___rhs);
			sem_stmt = config->callbacks.sem_stmt.sem_assign(
					gdrr_convert_sem_var(lhs, config), gdrr_convert_sem_op(rhs, config));
			break;
		}
		case __SEM_LOAD: {
			__obj lhs = __RECORD_SELECT(rec, ___lhs);
			__obj size = __RECORD_SELECT(rec, ___size);
			__obj address = __RECORD_SELECT(rec, ___address);
			sem_stmt = config->callbacks.sem_stmt.sem_load(
					gdrr_convert_sem_var(lhs, config), __CASETAGINT(size),
					gdrr_convert_sem_address(address, config));
			break;
		}
		case __SEM_STORE: {
			__obj address = __RECORD_SELECT(rec, ___address);
			__obj rhs = __RECORD_SELECT(rec, ___rhs);
			sem_stmt = config->callbacks.sem_stmt.sem_store(
					gdrr_convert_sem_address(address, config),
					gdrr_convert_sem_op(rhs, config));
			break;
		}
		case __SEM_ITE: {
			__obj cond = __RECORD_SELECT(rec, ___cond);
			__obj then_branch = __RECORD_SELECT(rec, ___then_branch);
			__obj else_branch = __RECORD_SELECT(rec, ___else_branch);
			sem_stmt = config->callbacks.sem_stmt.sem_ite(
					gdrr_convert_sem_linear(cond, config),
					gdrr_convert_sem_stmts_with_config(then_branch, config),
					gdrr_convert_sem_stmts_with_config(else_branch, config));
			break;
		}
		case __SEM_WHILE: {
			__obj cond = __RECORD_SELECT(rec, ___cond);
			__obj body = __RECORD_SELECT(rec, ___body);
			sem_stmt = config->callbacks.sem_stmt.sem_while(
					gdrr_convert_sem_linear(cond, config),
					gdrr_convert_sem_stmts_with_config(body, config));
			break;
		}
		case __SEM_CBRANCH: {
			__obj cond = __RECORD_SELECT(rec, ___cond);
			__obj target_true = __RECORD_SELECT(rec, ___target_true);
			__obj target_false = __RECORD_SELECT(rec, ___target_false);
			sem_stmt = config->callbacks.sem_stmt.sem_cbranch(
					gdrr_convert_sem_linear(cond, config),
					gdrr_convert_sem_address(target_true, config),
					gdrr_convert_sem_address(target_false, config));
			break;
		}
		case __SEM_BRANCH: {
			__obj hint = __RECORD_SELECT(rec, ___hint);
			__obj target = __RECORD_SELECT(rec, ___target);
			sem_stmt = config->callbacks.sem_stmt.sem_branch(
					gdrr_convert_sem_branch_hint(hint, config),
					gdrr_convert_sem_address(target, config));
			break;
		}
	}

	return sem_stmt;
}

static gdrr_sem_stmts_t *gdrr_convert_sem_stmts(__obj sem_stmts_obj,
		struct gdrr_config *config) {
	gdrr_sem_stmts_t *sem_stmts = NULL;

	if(__CASETAGCON(sem_stmts_obj) == __SEM_CONS) {
		__obj rec = __DECON(sem_stmts_obj);
		__obj instr = __RECORD_SELECT(rec, ___hd);
		__obj tl_obj = __RECORD_SELECT(rec, ___tl);

		gdrr_sem_stmts_t *tl = gdrr_convert_sem_stmts(tl_obj, config);
		gdrr_sem_stmt_t *hd = gdrr_convert_sem_stmt(instr, config);

		sem_stmts = config->callbacks.sem_stmts.sem_cons(hd, tl);
	} else
		sem_stmts = config->callbacks.sem_stmts.sem_nil();

	return sem_stmts;
}

static gdrr_sem_stmts_t *gdrr_convert_sem_stmts_list(__obj sem_stmts_obj,
		struct gdrr_config *config) {
	gdrr_sem_stmts_t *list = config->callbacks.sem_stmts_list.list_init();

	while(__CASETAGCON(sem_stmts_obj) == __SEM_CONS) {
		__obj rec = __DECON(sem_stmts_obj);
		__obj instr = __RECORD_SELECT(rec, ___hd);
		__obj tl_obj = __RECORD_SELECT(rec, ___tl);

		gdrr_sem_stmt_t *next = gdrr_convert_sem_stmt(instr, config);
		list = config->callbacks.sem_stmts_list.list_next(next, list);

		sem_stmts_obj = tl_obj;
	}

	return list;
}

static gdrr_sem_stmts_t *gdrr_convert_sem_stmts_with_config(__obj sem_stmts_obj,
		struct gdrr_config *config) {
	if(config->gdrr_config_stmts_handling == GDRR_CONFIG_STMTS_HANDLING_LIST)
		return gdrr_convert_sem_stmts_list(sem_stmts_obj, config);
	else
		return gdrr_convert_sem_stmts(sem_stmts_obj, config);
}

gdrr_sem_stmts_t *gdrr_convert(__obj semantics, struct gdrr_config *config) {
	return gdrr_convert_sem_stmts_with_config(semantics, config);
}
