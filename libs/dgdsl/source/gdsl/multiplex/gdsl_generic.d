module gdsl.multiplex.gdsl_generic;

import core.stdc.config;

extern (C):

alias void* obj_t;
alias state* state_t;
alias long int_t;
alias char* string_t;
alias c_ulong vec_data_t;
alias vec vec_t;
alias long con_tag_t;
alias _Anonymous_0 unboxed_branch_hint_callbacks_t;
alias _Anonymous_0* branch_hint_callbacks_t;
alias _Anonymous_1 unboxed_sem_address_callbacks_t;
alias _Anonymous_1* sem_address_callbacks_t;
alias _Anonymous_2 unboxed_sem_exception_callbacks_t;
alias _Anonymous_2* sem_exception_callbacks_t;
alias _Anonymous_3 unboxed_sem_expr_callbacks_t;
alias _Anonymous_3* sem_expr_callbacks_t;
alias _Anonymous_4 unboxed_sem_expr_cmp_callbacks_t;
alias _Anonymous_4* sem_expr_cmp_callbacks_t;
alias _Anonymous_5 unboxed_sem_flop_callbacks_t;
alias _Anonymous_5* sem_flop_callbacks_t;
alias _Anonymous_6 unboxed_sem_id_callbacks_t;
alias _Anonymous_6* sem_id_callbacks_t;
alias _Anonymous_7 unboxed_sem_linear_callbacks_t;
alias _Anonymous_7* sem_linear_callbacks_t;
alias _Anonymous_8 unboxed_sem_sexpr_callbacks_t;
alias _Anonymous_8* sem_sexpr_callbacks_t;
alias _Anonymous_9 unboxed_sem_stmt_callbacks_t;
alias _Anonymous_9* sem_stmt_callbacks_t;
alias _Anonymous_10 unboxed_sem_stmt_list_callbacks_t;
alias _Anonymous_10* sem_stmt_list_callbacks_t;
alias _Anonymous_11 unboxed_sem_var_callbacks_t;
alias _Anonymous_11* sem_var_callbacks_t;
alias _Anonymous_12 unboxed_sem_varl_callbacks_t;
alias _Anonymous_12* sem_varl_callbacks_t;
alias _Anonymous_13 unboxed_sem_varl_list_callbacks_t;
alias _Anonymous_13* sem_varl_list_callbacks_t;
alias _Anonymous_14 unboxed_callbacks_t;
alias _Anonymous_14* callbacks_t;
alias _Anonymous_15 unboxed_translate_result_t;
alias _Anonymous_15* translate_result_t;
alias _Anonymous_16 unboxed_lv_super_result_t;
alias _Anonymous_16* lv_super_result_t;
alias _Anonymous_17 unboxed_insndata_t;
alias _Anonymous_17* insndata_t;
alias _Anonymous_18 unboxed_opt_result_t;
alias _Anonymous_18* opt_result_t;
alias _Anonymous_19 unboxed_asm_insn_t;
alias _Anonymous_19* asm_insn_t;
alias _Anonymous_20 unboxed_asm_annotation_callbacks_t;
alias _Anonymous_20* asm_annotation_callbacks_t;
alias _Anonymous_21 unboxed_asm_annotation_list_callbacks_t;
alias _Anonymous_21* asm_annotation_list_callbacks_t;
alias _Anonymous_22 unboxed_asm_boundary_callbacks_t;
alias _Anonymous_22* asm_boundary_callbacks_t;
alias _Anonymous_23 unboxed_asm_opnd_callbacks_t;
alias _Anonymous_23* asm_opnd_callbacks_t;
alias _Anonymous_24 unboxed_asm_opnd_list_callbacks_t;
alias _Anonymous_24* asm_opnd_list_callbacks_t;
alias _Anonymous_25 unboxed_asm_signedness_callbacks_t;
alias _Anonymous_25* asm_signedness_callbacks_t;
alias _Anonymous_26 unboxed_asm_callbacks_t;
alias _Anonymous_26* asm_callbacks_t;

enum id_shared
{
	ID_FLOATING_FLAGS = 0
}

enum branch_hint
{
	BRANCH_HINT_JUMP = 0,
	BRANCH_HINT_CALL = 1,
	BRANCH_HINT_RET = 2
}

enum exception
{
	EXCEPTION_DIVISION_BY_ZERO = 0
}

enum flop
{
	FLOP_FADD = 0,
	FLOP_FSUB = 1,
	FLOP_FMUL = 2
}

enum preservation
{
	PRESERVATION_EVERYWHERE = 0,
	PRESERVATION_BLOCK = 1,
	PRESERVATION_CONTEXT = 2
}

struct state
{
	void* userdata;
}

struct vec
{
	uint size;
	vec_data_t data;
}

struct _Anonymous_0
{
	obj_t function (state_t, int_t) branch_hint_;
}

struct _Anonymous_1
{
	obj_t function (state_t, int_t, obj_t) sem_address_;
}

struct _Anonymous_2
{
	obj_t function (state_t, string_t) arch;
	obj_t function (state_t, int_t) shared_;
}

struct _Anonymous_3
{
	obj_t function (state_t, obj_t, obj_t) sem_and;
	obj_t function (state_t, obj_t, obj_t) sem_div;
	obj_t function (state_t, obj_t, obj_t) sem_divs;
	obj_t function (state_t, obj_t, obj_t) sem_mod;
	obj_t function (state_t, obj_t, obj_t) sem_mods;
	obj_t function (state_t, obj_t, obj_t) sem_mul;
	obj_t function (state_t, obj_t, obj_t) sem_or;
	obj_t function (state_t, obj_t) sem_sexpr;
	obj_t function (state_t, obj_t, obj_t) sem_shl;
	obj_t function (state_t, obj_t, obj_t) sem_shr;
	obj_t function (state_t, obj_t, obj_t) sem_shrs;
	obj_t function (state_t, int_t, obj_t) sem_sx;
	obj_t function (state_t, obj_t, obj_t) sem_xor;
	obj_t function (state_t, int_t, obj_t) sem_zx;
}

struct _Anonymous_4
{
	obj_t function (state_t, obj_t, obj_t) sem_cmpeq;
	obj_t function (state_t, obj_t, obj_t) sem_cmples;
	obj_t function (state_t, obj_t, obj_t) sem_cmpleu;
	obj_t function (state_t, obj_t, obj_t) sem_cmplts;
	obj_t function (state_t, obj_t, obj_t) sem_cmpltu;
	obj_t function (state_t, obj_t, obj_t) sem_cmpneq;
}

struct _Anonymous_5
{
	obj_t function (state_t, int_t) sem_flop_;
}

struct _Anonymous_6
{
	obj_t function (state_t, string_t) arch;
	obj_t function (state_t, int_t) shared_;
	obj_t function (state_t, int_t) virt_t;
}

struct _Anonymous_7
{
	obj_t function (state_t, obj_t, obj_t) sem_lin_add;
	obj_t function (state_t, int_t) sem_lin_imm;
	obj_t function (state_t, int_t, obj_t) sem_lin_scale;
	obj_t function (state_t, obj_t, obj_t) sem_lin_sub;
	obj_t function (state_t, obj_t) sem_lin_var;
}

struct _Anonymous_8
{
	obj_t function (state_t) sem_sexpr_arb;
	obj_t function (state_t, obj_t) sem_sexpr_cmp;
	obj_t function (state_t, obj_t) sem_sexpr_lin;
}

struct _Anonymous_9
{
	obj_t function (state_t, int_t, obj_t, obj_t) sem_assign;
	obj_t function (state_t, obj_t, obj_t) sem_branch;
	obj_t function (state_t, obj_t, obj_t, obj_t) sem_cbranch;
	obj_t function (state_t, obj_t, obj_t, obj_t, obj_t) sem_flop;
	obj_t function (state_t, obj_t, obj_t, obj_t) sem_ite;
	obj_t function (state_t, int_t, obj_t, obj_t) sem_load;
	obj_t function (state_t, string_t, obj_t, obj_t) sem_prim;
	obj_t function (state_t, int_t, obj_t, obj_t) sem_store;
	obj_t function (state_t, obj_t) sem_throw;
	obj_t function (state_t, obj_t, obj_t) sem_while;
}

struct _Anonymous_10
{
	obj_t function (state_t) sem_stmt_list_init;
	obj_t function (state_t, obj_t, obj_t) sem_stmt_list_next;
}

struct _Anonymous_11
{
	obj_t function (state_t, obj_t, int_t) sem_var_;
}

struct _Anonymous_12
{
	obj_t function (state_t, obj_t, int_t, int_t) sem_varl_;
}

struct _Anonymous_13
{
	obj_t function (state_t) sem_varl_list_init;
	obj_t function (state_t, obj_t, obj_t) sem_varl_list_next;
}

struct _Anonymous_14
{
	branch_hint_callbacks_t branch_hint;
	sem_address_callbacks_t sem_address;
	sem_exception_callbacks_t sem_exception;
	sem_expr_callbacks_t sem_expr;
	sem_expr_cmp_callbacks_t sem_expr_cmp;
	sem_flop_callbacks_t sem_flop;
	sem_id_callbacks_t sem_id;
	sem_linear_callbacks_t sem_linear;
	sem_sexpr_callbacks_t sem_sexpr;
	sem_stmt_callbacks_t sem_stmt;
	sem_stmt_list_callbacks_t sem_stmt_list;
	sem_var_callbacks_t sem_var;
	sem_varl_callbacks_t sem_varl;
	sem_varl_list_callbacks_t sem_varl_list;
}

struct _Anonymous_15
{
	obj_t insns;
	obj_t succ_a;
	obj_t succ_b;
}

struct _Anonymous_16
{
	obj_t after;
	obj_t initial;
}

struct _Anonymous_17
{
	int_t addr_sz;
	int_t config;
	int_t features;
	obj_t insn;
	int_t length;
	int_t lock;
	int_t opnd_sz;
	int_t rep;
	int_t repne;
}

struct _Anonymous_18
{
	obj_t insns;
	obj_t rreil;
}

struct _Anonymous_19
{
	obj_t annotations;
	int_t length;
	string_t mnemonic;
	obj_t opnds;
}

struct _Anonymous_20
{
	obj_t function (state_t, string_t) ann_string;
	obj_t function (state_t, string_t, obj_t) function_;
	obj_t function (state_t, string_t, obj_t) opnd;
}

struct _Anonymous_21
{
	obj_t function (state_t, obj_t, obj_t) annotation_list_next;
	obj_t function (state_t) init;
}

struct _Anonymous_22
{
	obj_t function (state_t, int_t) sz;
	obj_t function (state_t, int_t, int_t) sz_o;
}

struct _Anonymous_23
{
	obj_t function (state_t, obj_t, obj_t) annotated;
	obj_t function (state_t, obj_t, obj_t) bounded;
	obj_t function (state_t, obj_t) composite;
	obj_t function (state_t, int_t) imm;
	obj_t function (state_t, obj_t) memory;
	obj_t function (state_t, string_t) opnd_register;
	obj_t function (state_t, obj_t, obj_t) post_op;
	obj_t function (state_t, obj_t, obj_t) pre_op;
	obj_t function (state_t, obj_t) rel;
	obj_t function (state_t, int_t, obj_t) scale;
	obj_t function (state_t, obj_t, obj_t) sign;
	obj_t function (state_t, obj_t, obj_t) sum;
}

struct _Anonymous_24
{
	obj_t function (state_t) init;
	obj_t function (state_t, obj_t, obj_t) opnd_list_next;
}

struct _Anonymous_25
{
	obj_t function (state_t) asm_signed;
	obj_t function (state_t) asm_unsigned;
}

struct _Anonymous_26
{
	asm_annotation_callbacks_t annotation;
	asm_annotation_list_callbacks_t annotation_list;
	asm_boundary_callbacks_t boundary;
	obj_t function (state_t, int_t, string_t, obj_t, obj_t) insn;
	asm_opnd_callbacks_t opnd;
	asm_opnd_list_callbacks_t opnd_list;
	asm_signedness_callbacks_t signedness;
}