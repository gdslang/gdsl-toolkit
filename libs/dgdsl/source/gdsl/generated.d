module gdsl.generated;

import core.sys.posix.setjmp;
import core.stdc.config;

extern (C):

alias void* obj_t;
alias state* state_t;
alias long int_t;
alias char* string_t;
alias c_ulong vec_data_t;
alias vec vec_t;
alias long con_tag_t;
alias _Anonymous_0 unboxed_lv_super_result_t;
alias _Anonymous_0* lv_super_result_t;
alias _Anonymous_1 unboxed_translate_result_t;
alias _Anonymous_1* translate_result_t;
alias _Anonymous_2 unboxed_struct7_t;
alias _Anonymous_2* struct7_t;
alias _Anonymous_3 unboxed_opt_result_t;
alias _Anonymous_3* opt_result_t;
alias _Anonymous_4 unboxed_sem_varl_callbacks_t;
alias _Anonymous_4* sem_varl_callbacks_t;
alias _Anonymous_5 unboxed_sem_id_callbacks_t;
alias _Anonymous_5* sem_id_callbacks_t;
alias _Anonymous_6 unboxed_sem_exception_callbacks_t;
alias _Anonymous_6* sem_exception_callbacks_t;
alias _Anonymous_7 unboxed_branch_hint_callbacks_t;
alias _Anonymous_7* branch_hint_callbacks_t;
alias _Anonymous_8 unboxed_sem_stmt_callbacks_t;
alias _Anonymous_8* sem_stmt_callbacks_t;
alias _Anonymous_9 unboxed_sem_flop_callbacks_t;
alias _Anonymous_9* sem_flop_callbacks_t;
alias _Anonymous_10 unboxed_sem_expr_callbacks_t;
alias _Anonymous_10* sem_expr_callbacks_t;
alias _Anonymous_11 unboxed_sem_expr_cmp_callbacks_t;
alias _Anonymous_11* sem_expr_cmp_callbacks_t;
alias _Anonymous_12 unboxed_sem_sexpr_callbacks_t;
alias _Anonymous_12* sem_sexpr_callbacks_t;
alias _Anonymous_13 unboxed_sem_linear_callbacks_t;
alias _Anonymous_13* sem_linear_callbacks_t;
alias _Anonymous_14 unboxed_sem_var_callbacks_t;
alias _Anonymous_14* sem_var_callbacks_t;
alias _Anonymous_15 unboxed_sem_address_callbacks_t;
alias _Anonymous_15* sem_address_callbacks_t;
alias _Anonymous_16 unboxed_sem_stmts_callbacks_t;
alias _Anonymous_16* sem_stmts_callbacks_t;
alias _Anonymous_17 unboxed_sem_varls_callbacks_t;
alias _Anonymous_17* sem_varls_callbacks_t;
alias _Anonymous_18 unboxed_callbacks_t;
alias _Anonymous_18* callbacks_t;

struct vec
{
	uint size;
	vec_data_t data;
}

struct _Anonymous_0
{
	obj_t initial;
	obj_t after;
}

struct _Anonymous_1
{
	obj_t insns;
	obj_t succ_a;
	obj_t succ_b;
}

struct _Anonymous_2
{
	obj_t greedy;
	obj_t conservative;
}

struct _Anonymous_3
{
	obj_t insns;
	obj_t rreil;
}

struct _Anonymous_4
{
	obj_t function (state_t, obj_t, int_t, int_t) sem_varl_;
}

struct _Anonymous_5
{
	obj_t function (state_t, int_t) shared_;
	obj_t function (state_t, int_t) virt_t;
	obj_t function (state_t, int_t) arch;
}

struct _Anonymous_6
{
	obj_t function (state_t, int_t) shared_;
	obj_t function (state_t, int_t) arch;
}

struct _Anonymous_7
{
	obj_t function (state_t, int_t) branch_hint_;
}

struct _Anonymous_8
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

struct _Anonymous_9
{
	obj_t function (state_t, int_t) sem_flop_;
}

struct _Anonymous_10
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

struct _Anonymous_11
{
	obj_t function (state_t, obj_t, obj_t) sem_cmpeq;
	obj_t function (state_t, obj_t, obj_t) sem_cmpneq;
	obj_t function (state_t, obj_t, obj_t) sem_cmples;
	obj_t function (state_t, obj_t, obj_t) sem_cmpleu;
	obj_t function (state_t, obj_t, obj_t) sem_cmplts;
	obj_t function (state_t, obj_t, obj_t) sem_cmpltu;
}

struct _Anonymous_12
{
	obj_t function (state_t, obj_t) sem_sexpr_lin;
	obj_t function (state_t, obj_t) sem_sexpr_cmp;
	obj_t function (state_t, obj_t) sem_sexpr_arb;
}

struct _Anonymous_13
{
	obj_t function (state_t, obj_t) sem_lin_var;
	obj_t function (state_t, int_t) sem_lin_imm;
	obj_t function (state_t, obj_t, obj_t) sem_lin_add;
	obj_t function (state_t, obj_t, obj_t) sem_lin_sub;
	obj_t function (state_t, int_t, obj_t) sem_lin_scale;
}

struct _Anonymous_14
{
	obj_t function (state_t, obj_t, int_t) sem_var_;
}

struct _Anonymous_15
{
	obj_t function (state_t, int_t, obj_t) sem_address_;
}

struct _Anonymous_16
{
	obj_t function (state_t, obj_t, obj_t) sem_stmts_next;
	obj_t function (state_t, obj_t) sem_stmts_init;
}

struct _Anonymous_17
{
	obj_t function (state_t, obj_t, obj_t) sem_varls_next;
	obj_t function (state_t, obj_t) sem_varls_init;
}

struct _Anonymous_18
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


state_t gdsl_init ();
void gdsl_set_code (state_t s, char* buf, size_t buf_len, size_t base);
size_t gdsl_get_ip_offset (state_t s);
int_t gdsl_seek (state_t s, size_t i);
jmp_buf* gdsl_err_tgt (state_t s);
char* gdsl_get_error_message (state_t s);
void gdsl_reset_heap (state_t s);
size_t gdsl_heap_residency (state_t s);
string_t gdsl_merge_rope (state_t s, obj_t rope);
void gdsl_destroy (state_t s);
obj_t gdsl_cleanup (state_t s, obj_t stmts);
lv_super_result_t gdsl_liveness_super (state_t s, translate_result_t data);
obj_t gdsl_liveness (state_t s, obj_t instructions);
struct7_t gdsl_lv_analyze (state_t s, obj_t initial_live, obj_t stack);
obj_t gdsl_lv_pretty (state_t s, obj_t t);
obj_t gdsl_lv_union (state_t s, obj_t a, obj_t b);
obj_t gdsl_lv_kills (state_t s, obj_t stmts);
obj_t gdsl_lv_gens (state_t s, obj_t stmts);
obj_t gdsl_lv_gen (state_t s, obj_t gens, obj_t stmt);
obj_t gdsl_lv_kill (state_t s, obj_t kills, obj_t stmt);
obj_t gdsl_translate (state_t s, obj_t insn);
obj_t gdsl_pretty_simple (state_t s, obj_t i);
obj_t gdsl_pretty_mnemonic (state_t s, obj_t x);
obj_t gdsl_pretty_operand (state_t s, obj_t x, int_t i);
obj_t gdsl_pretty (state_t s, obj_t i);
int_t gdsl_operands (state_t s, obj_t x);
int_t gdsl_features_get (state_t s, obj_t insndata);
int_t gdsl_typeof_opnd (state_t s, obj_t x, int_t i);
obj_t gdsl_decode (state_t s, int_t config);
int_t gdsl_config_default_opnd_sz_32 (state_t s);
int_t gdsl_config_mode64 (state_t s);
int_t gdsl_config_default (state_t s);
obj_t gdsl_succ_pretty (state_t s, obj_t succ, obj_t name);
translate_result_t gdsl_decode_translate_super_block (state_t s, int_t config, int_t limit, obj_t function (state_t, obj_t, obj_t) insn_append);
obj_t gdsl_decode_translate_single (state_t s, int_t config);
obj_t gdsl_decode_translate_block_insns (state_t s, int_t config, int_t limit, obj_t function (state_t, obj_t, obj_t) insn_append);
obj_t gdsl_decode_translate_block (state_t s, int_t config, int_t limit);
opt_result_t gdsl_decode_translate_block_optimized_int (state_t s, int_t config, int_t limit, int_t pres, obj_t insns_initv, obj_t function (state_t, obj_t, obj_t) insn_append);
obj_t gdsl_decode_translate_block_optimized (state_t s, int_t config, int_t limit, int_t pres, obj_t function (state_t, obj_t, obj_t) insn_append);
obj_t gdsl_rreil_pretty (state_t s, obj_t ss_);
obj_t gdsl_rreil_sem_stmts_tail (state_t s, obj_t stmts);
obj_t gdsl_rreil_sem_stmts_head (state_t s, obj_t stmts);
int_t gdsl_rreil_sem_stmts_has_more (state_t s, obj_t stmts);
obj_t gdsl_rreil_convert_sem_stmts (state_t s, callbacks_t cbs, obj_t stmts);
obj_t gdsl_rreil_convert_sem_stmt_manual (state_t s, callbacks_t cbs, obj_t stmt);
int_t gdsl_rreil_sem_varls_has_more (state_t s, obj_t varls);
obj_t gdsl_rreil_sem_varls_tail (state_t s, obj_t stmts);
obj_t gdsl_rreil_sem_varls_head (state_t s, obj_t stmts);
obj_t gdsl_rreil_convert_sem_varl (state_t s, callbacks_t cbs, obj_t varl);
obj_t gdsl_rreil_cif_userdata_get (state_t s);
void gdsl_rreil_cif_userdata_set (state_t s, obj_t userdata);
obj_t gdsl_example_b (state_t s);
obj_t gdsl_example_a (state_t s);
int_t gdsl_rreil_stmts_count (state_t s, obj_t stmts);
obj_t gdsl_select_live (state_t s);
int_t gdsl_select_ins_count (state_t s);
int_t gdsl_int_max (state_t s);
string_t gdsl_rope_to_string (state_t s, obj_t r, string_t buf);
void gdsl_rope_print (state_t s, obj_t r);
int_t gdsl_rope_length (state_t s, obj_t r);