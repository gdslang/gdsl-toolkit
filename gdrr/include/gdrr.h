/*
 * gdrr.h
 *
 *  Created on: Feb 22, 2013
 *      Author: jucs
 */

#ifndef GDRR_H_
#define GDRR_H_

#include <dis.h>

typedef void gdrr_sem_id_t;
typedef void gdrr_sem_address_t;
typedef void gdrr_sem_var_t;
typedef void gdrr_sem_linear_t;
typedef void gdrr_sem_op_t;
typedef void gdrr_sem_stmt_t;
typedef void gdrr_branch_hint;
typedef void gdrr_sem_stmts_t;

struct gdrr_sem_id_callbacks {
	gdrr_sem_id_t *(*virt_eq)(void);
	gdrr_sem_id_t *(*virt_neq)(void);
	gdrr_sem_id_t *(*virt_les)(void);
	gdrr_sem_id_t *(*virt_leu)(void);
	gdrr_sem_id_t *(*virt_lts)(void);
	gdrr_sem_id_t *(*virt_ltu)(void);
	gdrr_sem_id_t *(*virt_t)(__word this);
};

struct gdrr_sem_var_callbacks {
	gdrr_sem_var_t *(*sem_var)(gdrr_sem_id_t *id, __word offset);
};

struct gdrr_sem_linear_callbacks {
	gdrr_sem_linear_t *(*sem_lin_var)(gdrr_sem_var_t *this);
	gdrr_sem_linear_t *(*sem_lin_imm)(__word imm);
	gdrr_sem_linear_t *(*sem_lin_add)(gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_linear_t *(*sem_lin_sub)(gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_linear_t *(*sem_lin_scale)(__word imm, gdrr_sem_linear_t *opnd);
};

struct gdrr_sem_op_callbacks {
	gdrr_sem_op_t *(*sem_lin)(__word size, gdrr_sem_linear_t *opnd1);
	gdrr_sem_op_t *(*sem_mul)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_div)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_divs)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_mod)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_shl)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_shr)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_shrs)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_and)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_or)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_xor)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_sx)(__word size, __word fromsize,
			gdrr_sem_linear_t *opnd1);
	gdrr_sem_op_t *(*sem_zx)(__word size, __word fromsize,
			gdrr_sem_linear_t *opnd1);
	gdrr_sem_op_t *(*sem_cmpeq)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_cmpneq)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_cmples)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_cmpleu)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_cmplts)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_cmpltu)(__word size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_arb)(__word size);
};

struct gdrr_sem_stmt_callbacks {
	gdrr_sem_stmt_t *(*sem_assign)(gdrr_sem_var_t *lhs, gdrr_sem_op_t *rhs);
	gdrr_sem_stmt_t *(*sem_load)(gdrr_sem_var_t *lhs, __word size,
			gdrr_sem_address_t *address);
	gdrr_sem_stmt_t *(*sem_store)(gdrr_sem_var_t *lhs, gdrr_sem_op_t *rhs);
	gdrr_sem_stmt_t *(*sem_ite)(gdrr_sem_linear_t *cond,
			gdrr_sem_stmts_t *then_branch, gdrr_sem_stmts_t *else_branch);
	gdrr_sem_stmt_t *(*sem_while)(gdrr_sem_linear_t *cond, gdrr_sem_stmts_t *body);
	gdrr_sem_stmt_t *(*sem_cbranch)(gdrr_sem_linear_t *cond,
			gdrr_sem_address_t *target_true, gdrr_sem_address_t *target_false);
	gdrr_sem_stmt_t *(*sem_branch)(gdrr_branch_hint *branch_hint,
			gdrr_sem_address_t *target);
};

struct gdrr_sem_stmts_callbacks {
	gdrr_sem_stmts_t *(*sem_cons)(gdrr_sem_stmt_t *hd, gdrr_sem_stmts_t *tl);
	gdrr_sem_stmts_t *(*sem_nil)(void);
};

struct gdrr_sem_stmts_list_callbacks {
	gdrr_sem_stmts_t *(*list_next)(gdrr_sem_stmt_t *next, gdrr_sem_stmts_t *list);
	gdrr_sem_stmts_t *(*list_init)(void);
};

struct gdrr_callbacks {
	struct gdrr_sem_id_callbacks sem_id;
	struct gdrr_sem_var_callbacks sem_var;
	struct gdrr_sem_linear_callbacks sem_linear;
	struct gdrr_sem_op_callbacks sem_op;
	struct gdrr_sem_stmt_callbacks sem_stmt;
	union {
		struct gdrr_sem_stmts_callbacks sem_stmts;
		struct gdrr_sem_stmts_list_callbacks sem_stmts_list;
	};
};

gdrr_sem_stmt_t *gdrr_convert(__obj semantics, struct gdrr_callbacks *callbacks);
gdrr_sem_stmt_t *gdrr_convert_list(__obj semantics,
		struct gdrr_callbacks *callbacks);

#endif /* GDRR_H_ */
