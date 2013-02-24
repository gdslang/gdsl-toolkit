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

static gdrr_sem_stmt_t *gdrr_convert_sem_stmt(__obj sem_stmt_obj,
		struct gddr_callbacks *callbacks) {
	gdrr_sem_stmt_t *sem_stmt = NULL;

	switch(__CASETAGCON(sem_stmt_obj)) {
		case __SEM_ASSIGN: {
			sem_stmt = callbacks->sem_stmt.sem_assign(NULL, NULL);
			break;
		}
		case __SEM_LOAD: {
			sem_stmt = callbacks->sem_stmt.sem_load(NULL, 0, NULL);
			break;
		}
		case __SEM_STORE: {
			sem_stmt = callbacks->sem_stmt.sem_store(NULL, NULL);
			break;
		}
		case __SEM_ITE: {
			sem_stmt = callbacks->sem_stmt.sem_ite(NULL, NULL, NULL);
			break;
		}
		case __SEM_WHILE: {
			sem_stmt = callbacks->sem_stmt.sem_while(NULL, NULL);
			break;
		}
		case __SEM_CBRANCH: {
			sem_stmt = callbacks->sem_stmt.sem_cbranch(NULL, NULL, NULL);
			break;
		}
		case __SEM_BRANCH: {
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
