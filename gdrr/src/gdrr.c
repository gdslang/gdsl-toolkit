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

static gdrr_sem_op_t *gdrr_convert_sem_op(__obj sem_op_obj,
		struct gddr_callbacks *callbacks) {
	gdrr_sem_op_t *sem_op = NULL;

	switch(__CASETAGCON(sem_op_obj)) {
		case __SEM_LIN: {
			sem_op = callbacks->sem_op.sem_lin(0, NULL);
			break;
		}
		case __SEM_MUL: {
			sem_op = callbacks->sem_op.sem_mul(0, NULL, NULL);
			break;
		}
		case __SEM_DIV: {
			sem_op = callbacks->sem_op.sem_div(0, NULL, NULL);
			break;
		}
		case __SEM_DIVS: {
			sem_op = callbacks->sem_op.sem_divs(0, NULL, NULL);
			break;
		}
		case __SEM_MOD: {
			sem_op = callbacks->sem_op.sem_mod(0, NULL, NULL);
			break;
		}
		case __SEM_SHL: {
			sem_op = callbacks->sem_op.sem_shl(0, NULL, NULL);
			break;
		}
		case __SEM_SHR: {
			sem_op = callbacks->sem_op.sem_shr(0, NULL, NULL);
			break;
		}
		case __SEM_SHRS: {
			sem_op = callbacks->sem_op.sem_shrs(0, NULL, NULL);
			break;
		}
		case __SEM_AND: {
			sem_op = callbacks->sem_op.sem_and(0, NULL, NULL);
			break;
		}
		case __SEM_OR: {
			sem_op = callbacks->sem_op.sem_or(0, NULL, NULL);
			break;
		}
		case __SEM_XOR: {
			sem_op = callbacks->sem_op.sem_xor(0, NULL, NULL);
			break;
		}
		case __SEM_SX: {
			sem_op = callbacks->sem_op.sem_sx(0, 0, NULL);
			break;
		}
		case __SEM_ZX: {
			sem_op = callbacks->sem_op.sem_zx(0, 0, NULL);
			break;
		}
		case __SEM_CMPEQ: {
			sem_op = callbacks->sem_op.sem_cmpeq(0, NULL, NULL);
			break;
		}
		case __SEM_CMPNEQ: {
			sem_op = callbacks->sem_op.sem_cmpneq(0, NULL, NULL);
			break;
		}
		case __SEM_CMPLES: {
			sem_op = callbacks->sem_op.sem_cmples(0, NULL, NULL);
			break;
		}
		case __SEM_CMPLEU: {
			sem_op = callbacks->sem_op.sem_cmpleu(0, NULL, NULL);
			break;
		}
		case __SEM_CMPLTS: {
			sem_op = callbacks->sem_op.sem_cmplts(0, NULL, NULL);
			break;
		}
		case __SEM_CMPLTU: {
			sem_op = callbacks->sem_op.sem_cmpltu(0, NULL, NULL);
			break;
		}
		case __SEM_ARB: {
			sem_op = callbacks->sem_op.sem_arb(0);
			break;
		}
	}

	return sem_op;
}

static gdrr_sem_stmt_t *gdrr_convert_sem_stmt(__obj sem_stmt_obj,
		struct gddr_callbacks *callbacks) {
	gdrr_sem_stmt_t *sem_stmt = NULL;

	__obj rec = __DECON(sem_stmt_obj);
	switch(__CASETAGCON(sem_stmt_obj)) {
		case __SEM_ASSIGN: {
			__obj lhs = __RECORD_SELECT(rec, ___lhs);
			__obj rhs = __RECORD_SELECT(rec, ___rhs);
			sem_stmt = callbacks->sem_stmt.sem_assign(NULL,
					gdrr_convert_sem_op(rhs, callbacks));
			break;
		}
		case __SEM_LOAD: {
			__obj lhs = __RECORD_SELECT(rec, ___lhs);
			__obj size = __RECORD_SELECT(rec, ___size);
			__obj address = __RECORD_SELECT(rec, ___address);
			sem_stmt = callbacks->sem_stmt.sem_load(NULL, 0, NULL);
			break;
		}
		case __SEM_STORE: {
			__obj address = __RECORD_SELECT(rec, ___address);
			__obj rhs = __RECORD_SELECT(rec, ___rhs);
			sem_stmt = callbacks->sem_stmt.sem_store(NULL,
					gdrr_convert_sem_op(rhs, callbacks));
			break;
		}
		case __SEM_ITE: {
      __obj cond = __RECORD_SELECT(rec, ___cond);
      __obj then_branch = __RECORD_SELECT(rec, ___then_branch);
      __obj else_branch = __RECORD_SELECT(rec, ___else_branch);
			sem_stmt = callbacks->sem_stmt.sem_ite(NULL, NULL, NULL);
			break;
		}
		case __SEM_WHILE: {
      __obj cond = __RECORD_SELECT(rec, ___cond);
      __obj body = __RECORD_SELECT(rec, ___body);
			sem_stmt = callbacks->sem_stmt.sem_while(NULL, NULL);
			break;
		}
		case __SEM_CBRANCH: {
      __obj cond = __RECORD_SELECT(rec, ___cond);
      __obj target_true = __RECORD_SELECT(rec, ___target_true);
      __obj target_false = __RECORD_SELECT(rec, ___target_false);
			sem_stmt = callbacks->sem_stmt.sem_cbranch(NULL, NULL, NULL);
			break;
		}
		case __SEM_BRANCH: {
      __obj hint = __RECORD_SELECT(rec, ___hint);
      __obj target = __RECORD_SELECT(rec, ___target);
			sem_stmt = callbacks->sem_stmt.sem_branch(NULL, NULL);
			break;
		}
	}

	return sem_stmt;
}

static gdrr_sem_stmts_t *gdrr_convert_sem_stmts(__obj sem_stmts_obj,
		struct gddr_callbacks *callbacks) {
	gdrr_sem_stmts_t *sem_stmts = NULL;

	if(__CASETAGCON(sem_stmts_obj) == __SEM_CONS) {
		__obj rec = __DECON(sem_stmts_obj);
		__obj instr = __RECORD_SELECT(rec, ___hd);
		__obj tl_obj = __RECORD_SELECT(rec, ___tl);

		gdrr_sem_stmts_t *tl = gdrr_convert_sem_stmts(tl_obj, callbacks);
		gdrr_sem_stmt_t *hd = gdrr_convert_sem_stmt(instr, callbacks);

		sem_stmts = callbacks->sem_stmts.sem_cons(hd, tl);
	} else
		sem_stmts = callbacks->sem_stmts.sem_nil();

	return sem_stmts;
}

static gdrr_sem_stmts_t *gdrr_convert_sem_stmts_list(__obj sem_stmts_obj,
		struct gddr_callbacks *callbacks) {
	gdrr_sem_stmts_t *list = callbacks->sem_stmts_list.list_init();

	while(__CASETAGCON(sem_stmts_obj) == __SEM_CONS) {
		__obj rec = __DECON(sem_stmts_obj);
		__obj instr = __RECORD_SELECT(rec, ___hd);
		__obj tl_obj = __RECORD_SELECT(rec, ___tl);

		gdrr_sem_stmt_t *next = gdrr_convert_sem_stmt(instr, callbacks);
		list = callbacks->sem_stmts_list.list_next(next, list);

		sem_stmts_obj = tl_obj;
	}

	return list;
}

gdrr_sem_stmt_t *gdrr_convert(__obj semantics, struct gddr_callbacks *callbacks) {
	return gdrr_convert_sem_stmts(semantics, callbacks);
}

gdrr_sem_stmt_t *gdrr_convert_list(__obj semantics,
		struct gddr_callbacks *callbacks) {
	return gdrr_convert_sem_stmts_list(semantics, callbacks);
}
