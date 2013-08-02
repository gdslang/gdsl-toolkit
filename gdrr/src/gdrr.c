/*
 * gdrr.c
 *
 *  Created on: Feb 22, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <gdsl-x86.h>
#include <gdrr.h>
#include <gdrr_x86.h>

//static gdrr_sem_id_t *gdrr_convert_sem_id(__obj sem_id_obj,
//		struct gdrr_config *config);
//static gdrr_sem_var_t *gdrr_convert_sem_address(__obj sem_address_obj,
//		struct gdrr_config *config);
//static gdrr_sem_var_t *gdrr_convert_sem_var(__obj sem_var_obj,
//		struct gdrr_config *config);
//static gdrr_sem_id_t *gdrr_convert_sem_linear(__obj sem_linear_obj,
//		struct gdrr_config *config);
//static gdrr_sem_sexpr_t *gdrr_convert_sem_sexpr(__obj sem_sexpr_obj,
//		struct gdrr_config *config);
//static gdrr_sem_op_cmp_t *gdrr_convert_sem_op_cmp(__obj sem_op_obj,
//		struct gdrr_config *config);
//static gdrr_sem_op_t *gdrr_convert_sem_op(__obj sem_op_obj,
//		struct gdrr_config *config);
//static gdrr_sem_stmt_t *gdrr_convert_sem_branch_hint(__obj sem_branch_hint_obj,
//		struct gdrr_config *config);
//static gdrr_sem_stmt_t *gdrr_convert_sem_stmt(__obj sem_stmt_obj,
//		struct gdrr_config *config);
//static gdrr_sem_stmts_t *gdrr_convert_sem_stmts(__obj sem_stmts_obj,
//		struct gdrr_config *config);
//static gdrr_sem_stmts_t *gdrr_convert_sem_stmts_list(__obj sem_stmts_obj,
//		struct gdrr_config *config);
//static gdrr_sem_stmts_t *gdrr_convert_sem_stmts_with_config(__obj sem_stmts_obj,
//		struct gdrr_config *config);
//
//static gdrr_sem_id_t *gdrr_convert_sem_id(__obj sem_id_obj,
//		struct gdrr_config *config) {
//	gdrr_sem_id_t *sem_id = NULL;
//
//	switch(__CASETAGCON(sem_id_obj)) {
//		case __VIRT_EQ: {
//			sem_id = config->callbacks.sem_id.virt_eq(config->closure);
//			break;
//		}
//		case __VIRT_NEQ: {
//			sem_id = config->callbacks.sem_id.virt_neq(config->closure);
//			break;
//		}
//		case __VIRT_LES: {
//			sem_id = config->callbacks.sem_id.virt_les(config->closure);
//			break;
//		}
//		case __VIRT_LEU: {
//			sem_id = config->callbacks.sem_id.virt_leu(config->closure);
//			break;
//		}
//		case __VIRT_LTS: {
//			sem_id = config->callbacks.sem_id.virt_lts(config->closure);
//			break;
//		}
//		case __VIRT_LTU: {
//			sem_id = config->callbacks.sem_id.virt_ltu(config->closure);
//			break;
//		}
//		case __VIRT_T: {
//			__obj this = __DECON(sem_id_obj);
//			sem_id = config->callbacks.sem_id.virt_t(config->closure,
//					__CASETAGINT(this));
//			break;
//		}
//		default: {
//			sem_id = gdrr_convert_sem_id_x86(sem_id_obj, config);
//			break;
//		}
//	}
//
//	return sem_id;
//}
//
//static gdrr_sem_var_t *gdrr_convert_sem_address(__obj sem_address_obj,
//		struct gdrr_config *config) {
//	__obj rec = __DECON(sem_address_obj);
//
//	__obj size = __RECORD_SELECT(rec, ___size);
//	__obj address = __RECORD_SELECT(rec, ___address);
//
//	return config->callbacks.sem_address.sem_address(config->closure,
//			__CASETAGINT(size), gdrr_convert_sem_linear(address, config));
//}
//
//static gdrr_sem_var_t *gdrr_convert_sem_var(__obj sem_var_obj,
//		struct gdrr_config *config) {
//	__obj rec = __DECON(sem_var_obj);
//
//	__obj id = __RECORD_SELECT(rec, ___id);
//	__obj offset = __RECORD_SELECT(rec, ___offset);
//
//	return config->callbacks.sem_var.sem_var(config->closure,
//			gdrr_convert_sem_id(id, config), __CASETAGINT(offset));
//}
//
//static gdrr_sem_id_t *gdrr_convert_sem_linear(__obj sem_linear_obj,
//		struct gdrr_config *config) {
//	gdrr_sem_linear_t *sem_linear = NULL;
//
//	__obj payload = __DECON(sem_linear_obj);
//
//	switch(__CASETAGCON(sem_linear_obj)) {
//		case __SEM_LIN_VAR: {
//
//			sem_linear = config->callbacks.sem_linear.sem_lin_var(config->closure,
//					gdrr_convert_sem_var(payload, config));
//			break;
//		}
//		case __SEM_LIN_IMM: {
//			__obj imm = __RECORD_SELECT(payload, ___imm);
//			sem_linear = config->callbacks.sem_linear.sem_lin_imm(config->closure,
//					__CASETAGINT(imm));
//			break;
//		}
//		case __SEM_LIN_ADD: {
//			__obj opnd1 = __RECORD_SELECT(payload, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(payload, ___opnd2);
//			sem_linear = config->callbacks.sem_linear.sem_lin_add(config->closure,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_LIN_SUB: {
//			__obj opnd1 = __RECORD_SELECT(payload, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(payload, ___opnd2);
//			sem_linear = config->callbacks.sem_linear.sem_lin_sub(config->closure,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_LIN_SCALE: {
//			__obj imm = __RECORD_SELECT(payload, ___imm);
//			__obj opnd = __RECORD_SELECT(payload, ___opnd);
//			sem_linear = config->callbacks.sem_linear.sem_lin_scale(config->closure,
//					__CASETAGINT(imm), gdrr_convert_sem_linear(opnd, config));
//			break;
//		}
//	}
//
//	return sem_linear;
//}
//
//static gdrr_sem_sexpr_t *gdrr_convert_sem_sexpr(__obj sem_sexpr_obj,
//		struct gdrr_config *config) {
//	gdrr_sem_sexpr_t *sem_sexpr = NULL;
//
//	__obj this = __DECON(sem_sexpr_obj);
//
//	switch(__CASETAGCON(sem_sexpr_obj)) {
//		case __SEM_SEXPR_LIN: {
//			sem_sexpr = config->callbacks.sem_sexpr.sem_sexpr_lin(config->closure,
//					gdrr_convert_sem_linear(this, config));
//			break;
//		}
//		case __SEM_SEXPR_CMP: {
//			sem_sexpr = config->callbacks.sem_sexpr.sem_sexpr_cmp(config->closure,
//					gdrr_convert_sem_op_cmp(this, config));
//			break;
//		}
//	}
//
//	return sem_sexpr;
//}
//
//static gdrr_sem_op_t *gdrr_convert_sem_op_cmp(__obj sem_op_cmp_obj,
//		struct gdrr_config *config) {
//	gdrr_sem_op_cmp_t *sem_op_cmp = NULL;
//
//	__obj rec = __DECON(sem_op_cmp_obj);
//
//	__obj size = __RECORD_SELECT(rec, ___size);
//	__word size_word = __CASETAGINT(size);
//
//	switch(__CASETAGCON(sem_op_cmp_obj)) {
//		case __SEM_CMPEQ: {
//			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
//			sem_op_cmp = config->callbacks.sem_op_cmp.sem_cmpeq(config->closure,
//					size_word, gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_CMPNEQ: {
//			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
//			sem_op_cmp = config->callbacks.sem_op_cmp.sem_cmpneq(config->closure,
//					size_word, gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_CMPLES: {
//			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
//			sem_op_cmp = config->callbacks.sem_op_cmp.sem_cmples(config->closure,
//					size_word, gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_CMPLEU: {
//			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
//			sem_op_cmp = config->callbacks.sem_op_cmp.sem_cmpleu(config->closure,
//					size_word, gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_CMPLTS: {
//			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
//			sem_op_cmp = config->callbacks.sem_op_cmp.sem_cmplts(config->closure,
//					size_word, gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_CMPLTU: {
//			__obj opnd1 = __RECORD_SELECT(rec, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(rec, ___opnd2);
//			sem_op_cmp = config->callbacks.sem_op_cmp.sem_cmpltu(config->closure,
//					size_word, gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//	}
//
//	return sem_op_cmp;
//}
//
//static gdrr_sem_op_t *gdrr_convert_sem_op(__obj sem_op_obj,
//		struct gdrr_config *config) {
//	gdrr_sem_op_t *sem_op = NULL;
//
//	__obj this = __DECON(sem_op_obj);
//
//	switch(__CASETAGCON(sem_op_obj)) {
//		case __SEM_LIN: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			sem_op = config->callbacks.sem_op.sem_lin(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config));
//			break;
//		}
//		case __SEM_MUL: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(this, ___opnd2);
//			sem_op = config->callbacks.sem_op.sem_mul(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_DIV: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(this, ___opnd2);
//			sem_op = config->callbacks.sem_op.sem_div(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_DIVS: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(this, ___opnd2);
//			sem_op = config->callbacks.sem_op.sem_divs(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_MOD: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(this, ___opnd2);
//			sem_op = config->callbacks.sem_op.sem_mod(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_SHL: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(this, ___opnd2);
//			sem_op = config->callbacks.sem_op.sem_shl(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_SHR: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(this, ___opnd2);
//			sem_op = config->callbacks.sem_op.sem_shr(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_SHRS: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(this, ___opnd2);
//			sem_op = config->callbacks.sem_op.sem_shrs(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_AND: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(this, ___opnd2);
//			sem_op = config->callbacks.sem_op.sem_and(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_OR: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(this, ___opnd2);
//			sem_op = config->callbacks.sem_op.sem_or(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_XOR: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj opnd2 = __RECORD_SELECT(this, ___opnd2);
//			sem_op = config->callbacks.sem_op.sem_xor(config->closure, size_word,
//					gdrr_convert_sem_linear(opnd1, config),
//					gdrr_convert_sem_linear(opnd2, config));
//			break;
//		}
//		case __SEM_SX: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj fromsize = __RECORD_SELECT(this, ___fromsize);
//			sem_op = config->callbacks.sem_op.sem_sx(config->closure, size_word,
//					__CASETAGINT(fromsize), gdrr_convert_sem_linear(opnd1, config));
//			break;
//		}
//		case __SEM_ZX: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			__obj opnd1 = __RECORD_SELECT(this, ___opnd1);
//			__obj fromsize = __RECORD_SELECT(this, ___fromsize);
//			sem_op = config->callbacks.sem_op.sem_zx(config->closure, size_word,
//					__CASETAGINT(fromsize), gdrr_convert_sem_linear(opnd1, config));
//			break;
//		}
//		case __SEM_CMP: {
//			sem_op = config->callbacks.sem_op.sem_cmp(config->closure,
//					gdrr_convert_sem_op_cmp(this, config));
//			break;
//		}
//		case __SEM_ARB: {
//			__obj size = __RECORD_SELECT(this, ___size);
//			__word size_word = __CASETAGINT(size);
//			sem_op = config->callbacks.sem_op.sem_arb(config->closure, size_word);
//			break;
//		}
//	}
//
//	return sem_op;
//}
//
//static gdrr_sem_stmt_t *gdrr_convert_sem_branch_hint(__obj sem_branch_hint_obj,
//		struct gdrr_config *config) {
//	gdrr_sem_stmt_t *sem_branch_hint = NULL;
//
//	switch(__CASETAGCON(sem_branch_hint_obj)) {
//		case __HINT_JUMP: {
//			sem_branch_hint = config->callbacks.sem_branch_hint.hint_jump(
//					config->closure);
//			break;
//		}
//		case __HINT_CALL: {
//			sem_branch_hint = config->callbacks.sem_branch_hint.hint_call(
//					config->closure);
//			break;
//		}
//		case __HINT_RET: {
//			sem_branch_hint = config->callbacks.sem_branch_hint.hint_ret(
//					config->closure);
//			break;
//		}
//	}
//
//	return sem_branch_hint;
//}
//
//static gdrr_sem_stmt_t *gdrr_convert_sem_stmt(__obj sem_stmt_obj,
//		struct gdrr_config *config) {
//	gdrr_sem_stmt_t *sem_stmt = NULL;
//
//	__obj rec = __DECON(sem_stmt_obj);
//	switch(__CASETAGCON(sem_stmt_obj)) {
//		case __SEM_ASSIGN: {
//			__obj lhs = __RECORD_SELECT(rec, ___lhs);
//			__obj rhs = __RECORD_SELECT(rec, ___rhs);
//			sem_stmt = config->callbacks.sem_stmt.sem_assign(config->closure,
//					gdrr_convert_sem_var(lhs, config), gdrr_convert_sem_op(rhs, config));
//			break;
//		}
//		case __SEM_LOAD: {
//			__obj lhs = __RECORD_SELECT(rec, ___lhs);
//			__obj size = __RECORD_SELECT(rec, ___size);
//			__obj address = __RECORD_SELECT(rec, ___address);
//			sem_stmt = config->callbacks.sem_stmt.sem_load(config->closure,
//					gdrr_convert_sem_var(lhs, config), __CASETAGINT(size),
//					gdrr_convert_sem_address(address, config));
//			break;
//		}
//		case __SEM_STORE: {
//			__obj address = __RECORD_SELECT(rec, ___address);
//			__obj rhs = __RECORD_SELECT(rec, ___rhs);
//			sem_stmt = config->callbacks.sem_stmt.sem_store(config->closure,
//					gdrr_convert_sem_address(address, config),
//					gdrr_convert_sem_op(rhs, config));
//			break;
//		}
//		case __SEM_ITE: {
//			__obj cond = __RECORD_SELECT(rec, ___cond);
//			__obj then_branch = __RECORD_SELECT(rec, ___then_branch);
//			__obj else_branch = __RECORD_SELECT(rec, ___else_branch);
//			sem_stmt = config->callbacks.sem_stmt.sem_ite(config->closure,
//					gdrr_convert_sem_sexpr(cond, config),
//					gdrr_convert_sem_stmts_with_config(then_branch, config),
//					gdrr_convert_sem_stmts_with_config(else_branch, config));
//			break;
//		}
//		case __SEM_WHILE: {
//			__obj cond = __RECORD_SELECT(rec, ___cond);
//			__obj body = __RECORD_SELECT(rec, ___body);
//			sem_stmt = config->callbacks.sem_stmt.sem_while(config->closure,
//					gdrr_convert_sem_sexpr(cond, config),
//					gdrr_convert_sem_stmts_with_config(body, config));
//			break;
//		}
//		case __SEM_CBRANCH: {
//			__obj cond = __RECORD_SELECT(rec, ___cond);
//			__obj target_true = __RECORD_SELECT(rec, ___target_true);
//			__obj target_false = __RECORD_SELECT(rec, ___target_false);
//			sem_stmt = config->callbacks.sem_stmt.sem_cbranch(config->closure,
//					gdrr_convert_sem_sexpr(cond, config),
//					gdrr_convert_sem_address(target_true, config),
//					gdrr_convert_sem_address(target_false, config));
//			break;
//		}
//		case __SEM_BRANCH: {
//			__obj hint = __RECORD_SELECT(rec, ___hint);
//			__obj target = __RECORD_SELECT(rec, ___target);
//			sem_stmt = config->callbacks.sem_stmt.sem_branch(config->closure,
//					gdrr_convert_sem_branch_hint(hint, config),
//					gdrr_convert_sem_address(target, config));
//			break;
//		}
//	}
//
//	return sem_stmt;
//}
//
//static gdrr_sem_stmts_t *gdrr_convert_sem_stmts(__obj sem_stmts_obj,
//		struct gdrr_config *config) {
//	gdrr_sem_stmts_t *sem_stmts = NULL;
//
//	if(__CASETAGCON(sem_stmts_obj) == __SEM_CONS) {
//		__obj rec = __DECON(sem_stmts_obj);
//		__obj instr = __RECORD_SELECT(rec, ___hd);
//		__obj tl_obj = __RECORD_SELECT(rec, ___tl);
//
//		gdrr_sem_stmts_t *tl = gdrr_convert_sem_stmts(tl_obj, config);
//		gdrr_sem_stmt_t *hd = gdrr_convert_sem_stmt(instr, config);
//
//		sem_stmts = config->callbacks.sem_stmts.sem_cons(config->closure, hd, tl);
//	} else
//		sem_stmts = config->callbacks.sem_stmts.sem_nil(config->closure);
//
//	return sem_stmts;
//}
//
//static gdrr_sem_stmts_t *gdrr_convert_sem_stmts_list(__obj sem_stmts_obj,
//		struct gdrr_config *config) {
//	gdrr_sem_stmts_t *list = config->callbacks.sem_stmts_list.list_init(
//			config->closure);
//
//	while(__CASETAGCON(sem_stmts_obj) == __SEM_CONS) {
//		__obj rec = __DECON(sem_stmts_obj);
//		__obj instr = __RECORD_SELECT(rec, ___hd);
//		__obj tl_obj = __RECORD_SELECT(rec, ___tl);
//
//		gdrr_sem_stmt_t *next = gdrr_convert_sem_stmt(instr, config);
//		list = config->callbacks.sem_stmts_list.list_next(config->closure, next,
//				list);
//
//		sem_stmts_obj = tl_obj;
//	}
//
//	return list;
//}

static gdrr_sem_stmts_t *gdrr_convert_sem_stmts_with_config(obj_t sem_stmts_obj,
		struct gdrr_config *config) {

//	if(config->gdrr_config_stmts_handling == GDRR_CONFIG_STMTS_HANDLING_LIST)
//		return gdrr_convert_sem_stmts_list(sem_stmts_obj, config);
//	else
//		return gdrr_convert_sem_stmts(sem_stmts_obj, config);
	obj_t sem_id_callbacks = x86_rreil_callbacks_sem_id(config->state,
			config->callbacks.sem_id.virt_na, config->callbacks.sem_id.virt_t,
			config->callbacks.arch.x86.sem_id.x86);
	obj_t sem_address_callbacks = x86_rreil_callbacks_sem_address(config->state,
			config->callbacks.sem_address.sem_address);
	obj_t sem_var_callbacks = x86_rreil_callbacks_sem_var(config->state,
			config->callbacks.sem_var.sem_var);
	obj_t sem_linear_callbacks = x86_rreil_callbacks_sem_linear(config->state,
			config->callbacks.sem_linear.sem_lin_var,
			config->callbacks.sem_linear.sem_lin_imm,
			config->callbacks.sem_linear.sem_lin_add,
			config->callbacks.sem_linear.sem_lin_sub,
			config->callbacks.sem_linear.sem_lin_scale);
	obj_t sem_sexpr_callbacks = x86_rreil_callbacks_sem_sexpr(config->state,
			config->callbacks.sem_sexpr.sem_sexpr_lin,
			config->callbacks.sem_sexpr.sem_sexpr_cmp);
	obj_t sem_op_cmp_callbacks = x86_rreil_callbacks_sem_op_cmp(config->state,
			config->callbacks.sem_op_cmp.sem_cmpeq,
			config->callbacks.sem_op_cmp.sem_cmpneq,
			config->callbacks.sem_op_cmp.sem_cmples,
			config->callbacks.sem_op_cmp.sem_cmpleu,
			config->callbacks.sem_op_cmp.sem_cmplts,
			config->callbacks.sem_op_cmp.sem_cmpltu);
	obj_t sem_op_callbacks = x86_rreil_callbacks_sem_op(config->state,
			config->callbacks.sem_op.sem_lin, config->callbacks.sem_op.sem_mul,
			config->callbacks.sem_op.sem_div, config->callbacks.sem_op.sem_divs,
			config->callbacks.sem_op.sem_mod, config->callbacks.sem_op.sem_shl,
			config->callbacks.sem_op.sem_shr, config->callbacks.sem_op.sem_shrs,
			config->callbacks.sem_op.sem_and, config->callbacks.sem_op.sem_or,
			config->callbacks.sem_op.sem_xor, config->callbacks.sem_op.sem_sx,
			config->callbacks.sem_op.sem_zx, config->callbacks.sem_op.sem_cmp,
			config->callbacks.sem_op.sem_arb);
	obj_t sem_stmt_callbacks = x86_rreil_callbacks_sem_stmt(config->state,
			config->callbacks.sem_stmt.sem_assign,
			config->callbacks.sem_stmt.sem_load, config->callbacks.sem_stmt.sem_store,
			config->callbacks.sem_stmt.sem_ite, config->callbacks.sem_stmt.sem_while,
			config->callbacks.sem_stmt.sem_cbranch,
			config->callbacks.sem_stmt.sem_branch);
	obj_t branch_hint_callbacks = x86_rreil_callbacks_branch_hint(config->state,
			config->callbacks.branch_hint.branch_hint);
	obj_t sem_stmts_callbacks = x86_rreil_callbacks_sem_stmts(config->state,
			config->callbacks.sem_stmts.sem_cons,
			config->callbacks.sem_stmts.sem_nil);
	obj_t sem_stmts_list_callbacks = x86_rreil_callbacks_sem_stmts(config->state,
			config->callbacks.sem_stmts_list.list_next,
			config->callbacks.sem_stmts_list.list_init);

	obj_t callbacks = x86_rreil_callbacks(config->state, sem_id_callbacks,
			sem_address_callbacks, sem_var_callbacks, sem_linear_callbacks,
			sem_sexpr_callbacks, sem_op_cmp_callbacks, sem_op_callbacks,
			sem_stmt_callbacks, branch_hint_callbacks, sem_stmts_callbacks,
			sem_stmts_list_callbacks);

	return x86_rreil_convert_sem_stmts(config->state, callbacks, config->closure,
			sem_stmts_obj);
}

gdrr_sem_stmts_t *gdrr_convert(obj_t semantics, struct gdrr_config *config) {
	return gdrr_convert_sem_stmts_with_config(semantics, config);
}
