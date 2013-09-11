/*
 * gdrr.h
 *
 *  Created on: Feb 22, 2013
 *      Author: jucs
 */

#ifndef GDRR_CALLBACKS_H_
#define GDRR_CALLBACKS_H_

#include <gdrr_types.h>
#include <gdsl.h>

struct gdrr_sem_id_callbacks {
//	gdrr_sem_id_t *(*virt_na)(state_t state, int_t con);
//	gdrr_sem_id_t *(*virt_eq)(state_t state);
//	gdrr_sem_id_t *(*virt_neq)(state_t state);
//	gdrr_sem_id_t *(*virt_les)(state_t state);
//	gdrr_sem_id_t *(*virt_leu)(state_t state);
//	gdrr_sem_id_t *(*virt_lts)(state_t state);
//	gdrr_sem_id_t *(*virt_ltu)(state_t state);
	gdrr_sem_id_t *(*virt_t)(state_t state, int_t this);
};

struct gdrr_sem_address_callbacks {
	gdrr_sem_address_t *(*sem_address)(state_t state, int_t size,
			gdrr_sem_linear_t *address);
};

struct gdrr_sem_var_callbacks {
	gdrr_sem_var_t *(*sem_var)(state_t state, gdrr_sem_id_t *id, int_t offset);
};

struct gdrr_sem_linear_callbacks {
	gdrr_sem_linear_t *(*sem_lin_var)(state_t state, gdrr_sem_var_t *this);
	gdrr_sem_linear_t *(*sem_lin_imm)(state_t state, int_t imm);
	gdrr_sem_linear_t *(*sem_lin_add)(state_t state, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_linear_t *(*sem_lin_sub)(state_t state, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_linear_t *(*sem_lin_scale)(state_t state, int_t imm,
			gdrr_sem_linear_t *opnd);
};

struct gdrr_sem_sexpr_callbacks {
	gdrr_sem_sexpr_t *(*sem_sexpr_lin)(state_t state, gdrr_sem_linear_t *this);
	gdrr_sem_sexpr_t *(*sem_sexpr_cmp)(state_t state, gdrr_sem_op_cmp_t *this);
};

struct gdrr_sem_op_cmp_callbacks {
	gdrr_sem_op_t *(*sem_cmpeq)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_cmpneq)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_cmples)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_cmpleu)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_cmplts)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_cmpltu)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
};

struct gdrr_sem_op_callbacks {
	gdrr_sem_op_t *(*sem_lin)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1);
	gdrr_sem_op_t *(*sem_mul)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_div)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_divs)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_mod)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_shl)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_shr)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_shrs)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_and)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_or)(state_t state, int_t size, gdrr_sem_linear_t *opnd1,
			gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_xor)(state_t state, int_t size,
			gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2);
	gdrr_sem_op_t *(*sem_sx)(state_t state, int_t size, int_t fromsize,
			gdrr_sem_linear_t *opnd1);
	gdrr_sem_op_t *(*sem_zx)(state_t state, int_t size, int_t fromsize,
			gdrr_sem_linear_t *opnd1);
	gdrr_sem_op_t *(*sem_cmp)(state_t state, gdrr_sem_op_cmp_t *this);
	gdrr_sem_op_t *(*sem_arb)(state_t state, int_t size);
};

struct gdrr_sem_stmt_callbacks {
	gdrr_sem_stmt_t *(*sem_assign)(state_t state, gdrr_sem_var_t *lhs,
			gdrr_sem_op_t *rhs);
	gdrr_sem_stmt_t *(*sem_load)(state_t state, gdrr_sem_var_t *lhs, int_t size,
			gdrr_sem_address_t *address);
	gdrr_sem_stmt_t *(*sem_store)(state_t state, gdrr_sem_address_t *address,
			gdrr_sem_op_t *rhs);
	gdrr_sem_stmt_t *(*sem_ite)(state_t state, gdrr_sem_sexpr_t *cond,
			gdrr_sem_stmts_t *then_branch, gdrr_sem_stmts_t *else_branch);
	gdrr_sem_stmt_t *(*sem_while)(state_t state, gdrr_sem_sexpr_t *cond,
			gdrr_sem_stmts_t *body);
	gdrr_sem_stmt_t *(*sem_cbranch)(state_t state, gdrr_sem_sexpr_t *cond,
			gdrr_sem_address_t *target_true, gdrr_sem_address_t *target_false);
	gdrr_sem_stmt_t *(*sem_branch)(state_t state,
			gdrr_branch_hint_t *branch_hint, gdrr_sem_address_t *target);
};

struct gdrr_branch_hint_callbacks {
	gdrr_branch_hint_t *(*branch_hint)(state_t state, int_t con);
//	gdrr_sem_branch_hint_t *(*hint_jump)(state_t state);
//	gdrr_sem_branch_hint_t *(*hint_call)(state_t state);
//	gdrr_sem_branch_hint_t *(*hint_ret)(state_t state);
};

struct gdrr_sem_stmts_callbacks {
	gdrr_sem_stmts_t *(*sem_cons)(state_t state, gdrr_sem_stmt_t *hd,
			gdrr_sem_stmts_t *tl);
	gdrr_sem_stmts_t *(*sem_nil)(state_t state);
};

struct gdrr_sem_stmts_list_callbacks {
	gdrr_sem_stmts_t *(*list_next)(state_t state, gdrr_sem_stmt_t *next,
			gdrr_sem_stmts_t *list);
	gdrr_sem_stmts_t *(*list_init)(state_t state);
};

#endif /* GDRR_CALLBACKS_H_ */
