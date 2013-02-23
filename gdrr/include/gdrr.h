/*
 * gdrr.h
 *
 *  Created on: Feb 22, 2013
 *      Author: jucs
 */

#ifndef GDRR_H_
#define GDRR_H_

#include <dis.h>

typedef void gdrr_sem_stmt_t;
typedef void gdrr_sem_stmts_t;

typedef void gdrr_sem_linear_t;
typedef void gdrr_sem_var_t;
typedef void gdrr_sem_op_t;
typedef void gdrr_sem_address_t;

struct gddr_sem_stmts_callbacks {
	gdrr_sem_stmts_t *(*sem_cons)(gdrr_sem_stmt_t *hd, gdrr_sem_stmts_t *tl);
	gdrr_sem_stmts_t *(*sem_nil)(void);
};

struct gddr_sem_stmts_list_callbacks {
	gdrr_sem_stmts_t *(*list_init)(void);
	gdrr_sem_stmts_t *(*list_next)(gdrr_sem_stmt_t *next, gdrr_sem_stmts_t *list);
};

struct gddr_sem_stmt_callbacks {
	gdrr_sem_stmt_t *(*sem_assign)(gdrr_sem_var_t *lhs, gdrr_sem_op_t *rhs);
	gdrr_sem_stmt_t *(*sem_load)(gdrr_sem_var_t *lhs, __word size,
			gdrr_sem_address_t *address);
	gdrr_sem_stmt_t *(*sem_store)(gdrr_sem_var_t *lhs, gdrr_sem_op_t *rhs);
	gdrr_sem_stmt_t *(*sem_ite)(gdrr_sem_linear_t *cond,
			gdrr_sem_stmts_t *then_branch, gdrr_sem_stmts_t *else_branch);
};

struct gddr_callbacks {
	union {
		struct gddr_sem_stmts_callbacks sem_stmts;
		struct gddr_sem_stmts_list_callbacks sem_stmts_list;
	};
	struct gddr_sem_stmt_callbacks sem_stmt;
};

gdrr_sem_stmt_t *gdrr_convert(__obj semantics, struct gddr_callbacks *callbacks);
gdrr_sem_stmt_t *gdrr_convert_list(__obj semantics,
		struct gddr_callbacks *callbacks);

#endif /* GDRR_H_ */
