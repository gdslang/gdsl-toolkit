module gdsl.multiplex.gdsl_generic;

import core.stdc.config;

extern (C):

alias void* obj_t;
alias state* state_t;
alias long int_t;
alias char* string_t;
alias c_ulong vec_data_t;
alias _Anonymous_0 unboxed_struct1_t;
alias _Anonymous_0* struct1_t;
alias _Anonymous_1 unboxed_lv_super_result_t;
alias _Anonymous_1* lv_super_result_t;
alias _Anonymous_2 unboxed_translate_result_t;
alias _Anonymous_2* translate_result_t;
alias _Anonymous_3 unboxed_struct7_t;
alias _Anonymous_3* struct7_t;
alias _Anonymous_4 unboxed_opt_result_t;
alias _Anonymous_4* opt_result_t;
alias _Anonymous_5 unboxed_sem_varl_callbacks_t;
alias _Anonymous_5* sem_varl_callbacks_t;
alias _Anonymous_6 unboxed_sem_id_callbacks_t;
alias _Anonymous_6* sem_id_callbacks_t;
alias _Anonymous_7 unboxed_sem_exception_callbacks_t;
alias _Anonymous_7* sem_exception_callbacks_t;
alias _Anonymous_8 unboxed_branch_hint_callbacks_t;
alias _Anonymous_8* branch_hint_callbacks_t;
alias _Anonymous_9 unboxed_sem_stmt_callbacks_t;
alias _Anonymous_9* sem_stmt_callbacks_t;
alias _Anonymous_10 unboxed_sem_flop_callbacks_t;
alias _Anonymous_10* sem_flop_callbacks_t;
alias _Anonymous_11 unboxed_sem_expr_callbacks_t;
alias _Anonymous_11* sem_expr_callbacks_t;
alias _Anonymous_12 unboxed_sem_expr_cmp_callbacks_t;
alias _Anonymous_12* sem_expr_cmp_callbacks_t;
alias _Anonymous_13 unboxed_sem_sexpr_callbacks_t;
alias _Anonymous_13* sem_sexpr_callbacks_t;
alias _Anonymous_14 unboxed_sem_linear_callbacks_t;
alias _Anonymous_14* sem_linear_callbacks_t;
alias _Anonymous_15 unboxed_sem_var_callbacks_t;
alias _Anonymous_15* sem_var_callbacks_t;
alias _Anonymous_16 unboxed_sem_address_callbacks_t;
alias _Anonymous_16* sem_address_callbacks_t;
alias _Anonymous_17 unboxed_sem_stmts_callbacks_t;
alias _Anonymous_17* sem_stmts_callbacks_t;
alias _Anonymous_18 unboxed_sem_varls_callbacks_t;
alias _Anonymous_18* sem_varls_callbacks_t;
alias _Anonymous_19 unboxed_callbacks_t;
alias _Anonymous_19* callbacks_t;

struct _Anonymous_0
{
}

struct _Anonymous_1
{
	obj_t initial;
	obj_t after;
}

struct _Anonymous_2
{
	obj_t insns;
	obj_t succ_a;
	obj_t succ_b;
}

struct _Anonymous_3
{
	obj_t greedy;
	obj_t conservative;
}

struct _Anonymous_4
{
	struct1_t insns;
	obj_t rreil;
}

struct _Anonymous_5
{
	obj_t function (state_t, obj_t, int_t, int_t) sem_varl_;
}

struct _Anonymous_6
{
	obj_t function (state_t, int_t) shared_;
	obj_t function (state_t, int_t) virt_t;
	obj_t function (state_t, obj_t) arch;
}

struct _Anonymous_7
{
	obj_t function (state_t, int_t) shared_;
	obj_t function (state_t, obj_t) arch;
}

struct _Anonymous_8
{
	obj_t function (state_t, int_t) branch_hint_;
}

struct _Anonymous_9
{
	obj_t function (state_t, obj_t, obj_t, obj_t, obj_t) sem_flop;
	obj_t function (state_t, obj_t, obj_t, obj_t) sem_prim;
	obj_t function (state_t, int_t, obj_t, obj_t) sem_assign;
	obj_t function (state_t, int_t, obj_t, obj_t) sem_load;
	obj_t function (state_t, int_t, obj_t, obj_t) sem_store;
	obj_t function (state_t, obj_t, obj_t, obj_t) sem_ite;
	obj_t function (state_t, obj_t, obj_t) sem_while;
	obj_t function (state_t, obj_t, obj_t, obj_t) sem_cbranch;
	obj_t function (state_t, obj_t, obj_t) sem_branch;
	obj_t function (state_t, obj_t) sem_throw;
}

struct _Anonymous_10
{
	obj_t function (state_t, int_t) sem_flop_;
}

struct _Anonymous_11
{
	obj_t function (state_t, obj_t) sem_sexpr;
	obj_t function (state_t, obj_t, obj_t) sem_mul;
	obj_t function (state_t, obj_t, obj_t) sem_div;
	obj_t function (state_t, obj_t, obj_t) sem_divs;
	obj_t function (state_t, obj_t, obj_t) sem_mod;
	obj_t function (state_t, obj_t, obj_t) sem_mods;
	obj_t function (state_t, obj_t, obj_t) sem_shl;
	obj_t function (state_t, obj_t, obj_t) sem_shr;
	obj_t function (state_t, obj_t, obj_t) sem_shrs;
	obj_t function (state_t, obj_t, obj_t) sem_and;
	obj_t function (state_t, obj_t, obj_t) sem_or;
	obj_t function (state_t, obj_t, obj_t) sem_xor;
	obj_t function (state_t, int_t, obj_t) sem_sx;
	obj_t function (state_t, int_t, obj_t) sem_zx;
}

struct _Anonymous_12
{
	obj_t function (state_t, obj_t, obj_t) sem_cmpeq;
	obj_t function (state_t, obj_t, obj_t) sem_cmpneq;
	obj_t function (state_t, obj_t, obj_t) sem_cmples;
	obj_t function (state_t, obj_t, obj_t) sem_cmpleu;
	obj_t function (state_t, obj_t, obj_t) sem_cmplts;
	obj_t function (state_t, obj_t, obj_t) sem_cmpltu;
}

struct _Anonymous_13
{
	obj_t function (state_t, obj_t) sem_sexpr_lin;
	obj_t function (state_t, obj_t) sem_sexpr_cmp;
	obj_t function (state_t, obj_t) sem_sexpr_arb;
}

struct _Anonymous_14
{
	obj_t function (state_t, obj_t) sem_lin_var;
	obj_t function (state_t, int_t) sem_lin_imm;
	obj_t function (state_t, obj_t, obj_t) sem_lin_add;
	obj_t function (state_t, obj_t, obj_t) sem_lin_sub;
	obj_t function (state_t, int_t, obj_t) sem_lin_scale;
}

struct _Anonymous_15
{
	obj_t function (state_t, obj_t, int_t) sem_var_;
}

struct _Anonymous_16
{
	obj_t function (state_t, int_t, obj_t) sem_address_;
}

struct _Anonymous_17
{
	obj_t function (state_t, obj_t, obj_t) sem_stmts_next;
	obj_t function (state_t, obj_t) sem_stmts_init;
}

struct _Anonymous_18
{
	obj_t function (state_t, obj_t, obj_t) sem_varls_next;
	obj_t function (state_t, obj_t) sem_varls_init;
}

struct _Anonymous_19
{
	sem_varl_callbacks_t sem_varl;
	sem_id_callbacks_t sem_id;
	sem_exception_callbacks_t sem_exception;
	branch_hint_callbacks_t branch_hint;
	sem_stmt_callbacks_t sem_stmt;
	sem_flop_callbacks_t sem_flop;
	sem_expr_callbacks_t sem_expr;
	sem_expr_cmp_callbacks_t sem_expr_cmp;
	sem_sexpr_callbacks_t sem_sexpr;
	sem_linear_callbacks_t sem_linear;
	sem_var_callbacks_t sem_var;
	sem_address_callbacks_t sem_address;
	sem_stmts_callbacks_t sem_stmts;
	sem_varls_callbacks_t sem_varls;
}

struct state;