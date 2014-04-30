/*
 * gdsl_generic.h
 *
 *  Created on: Apr 29, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <stdint.h>

/* data types used in decoder programs */
typedef void* obj_t;
typedef struct state* state_t;
typedef long long int int_t;
typedef char* string_t;
typedef uint64_t vec_data_t;

/**
 * RReil defintions
 */

#define FLOATING_FLAGS 0

#define HINT_JUMP 0
#define HINT_CALL 1
#define HINT_RET 2

#define DIVISION_BY_ZERO 0

#define FADD 0
#define FSUB 1
#define FMUL 2

/**
 * Interface data structures
 */

#ifndef GDSL_SPECIFIC
typedef struct {
} unboxed_struct1_t;
typedef unboxed_struct1_t* struct1_t;
typedef struct {
  obj_t initial;
  obj_t after;
} unboxed_lv_super_result_t;
typedef unboxed_lv_super_result_t* lv_super_result_t;
typedef struct {
  obj_t insns;
  obj_t succ_a;
  obj_t succ_b;
} unboxed_translate_result_t;
typedef unboxed_translate_result_t* translate_result_t;
typedef struct {
  obj_t greedy;
  obj_t conservative;
} unboxed_struct7_t;
typedef unboxed_struct7_t* struct7_t;
typedef struct {
  struct1_t insns;
  obj_t rreil;
} unboxed_opt_result_t;
typedef unboxed_opt_result_t* opt_result_t;
typedef struct {
  obj_t (*sem_varl_)(state_t,obj_t,int_t,int_t);
} unboxed_sem_varl_callbacks_t;
typedef unboxed_sem_varl_callbacks_t* sem_varl_callbacks_t;
typedef struct {
  obj_t (*shared)(state_t,int_t);
  obj_t (*virt_t)(state_t,int_t);
  obj_t (*arch)(state_t,obj_t);
} unboxed_sem_id_callbacks_t;
typedef unboxed_sem_id_callbacks_t* sem_id_callbacks_t;
typedef struct {
  obj_t (*shared)(state_t,int_t);
  obj_t (*arch)(state_t,obj_t);
} unboxed_sem_exception_callbacks_t;
typedef unboxed_sem_exception_callbacks_t* sem_exception_callbacks_t;
typedef struct {
  obj_t (*branch_hint_)(state_t,int_t);
} unboxed_branch_hint_callbacks_t;
typedef unboxed_branch_hint_callbacks_t* branch_hint_callbacks_t;
typedef struct {
  obj_t (*sem_flop)(state_t,obj_t,obj_t,obj_t,obj_t);
  obj_t (*sem_prim)(state_t,obj_t,obj_t,obj_t);
  obj_t (*sem_assign)(state_t,int_t,obj_t,obj_t);
  obj_t (*sem_load)(state_t,int_t,obj_t,obj_t);
  obj_t (*sem_store)(state_t,int_t,obj_t,obj_t);
  obj_t (*sem_ite)(state_t,obj_t,obj_t,obj_t);
  obj_t (*sem_while)(state_t,obj_t,obj_t);
  obj_t (*sem_cbranch)(state_t,obj_t,obj_t,obj_t);
  obj_t (*sem_branch)(state_t,obj_t,obj_t);
  obj_t (*sem_throw)(state_t,obj_t);
} unboxed_sem_stmt_callbacks_t;
typedef unboxed_sem_stmt_callbacks_t* sem_stmt_callbacks_t;
typedef struct {
  obj_t (*sem_flop_)(state_t,int_t);
} unboxed_sem_flop_callbacks_t;
typedef unboxed_sem_flop_callbacks_t* sem_flop_callbacks_t;
typedef struct {
  obj_t (*sem_sexpr)(state_t,obj_t);
  obj_t (*sem_mul)(state_t,obj_t,obj_t);
  obj_t (*sem_div)(state_t,obj_t,obj_t);
  obj_t (*sem_divs)(state_t,obj_t,obj_t);
  obj_t (*sem_mod)(state_t,obj_t,obj_t);
  obj_t (*sem_mods)(state_t,obj_t,obj_t);
  obj_t (*sem_shl)(state_t,obj_t,obj_t);
  obj_t (*sem_shr)(state_t,obj_t,obj_t);
  obj_t (*sem_shrs)(state_t,obj_t,obj_t);
  obj_t (*sem_and)(state_t,obj_t,obj_t);
  obj_t (*sem_or)(state_t,obj_t,obj_t);
  obj_t (*sem_xor)(state_t,obj_t,obj_t);
  obj_t (*sem_sx)(state_t,int_t,obj_t);
  obj_t (*sem_zx)(state_t,int_t,obj_t);
} unboxed_sem_expr_callbacks_t;
typedef unboxed_sem_expr_callbacks_t* sem_expr_callbacks_t;
typedef struct {
  obj_t (*sem_cmpeq)(state_t,obj_t,obj_t);
  obj_t (*sem_cmpneq)(state_t,obj_t,obj_t);
  obj_t (*sem_cmples)(state_t,obj_t,obj_t);
  obj_t (*sem_cmpleu)(state_t,obj_t,obj_t);
  obj_t (*sem_cmplts)(state_t,obj_t,obj_t);
  obj_t (*sem_cmpltu)(state_t,obj_t,obj_t);
} unboxed_sem_expr_cmp_callbacks_t;
typedef unboxed_sem_expr_cmp_callbacks_t* sem_expr_cmp_callbacks_t;
typedef struct {
  obj_t (*sem_sexpr_lin)(state_t,obj_t);
  obj_t (*sem_sexpr_cmp)(state_t,obj_t);
  obj_t (*sem_sexpr_arb)(state_t,obj_t);
} unboxed_sem_sexpr_callbacks_t;
typedef unboxed_sem_sexpr_callbacks_t* sem_sexpr_callbacks_t;
typedef struct {
  obj_t (*sem_lin_var)(state_t,obj_t);
  obj_t (*sem_lin_imm)(state_t,int_t);
  obj_t (*sem_lin_add)(state_t,obj_t,obj_t);
  obj_t (*sem_lin_sub)(state_t,obj_t,obj_t);
  obj_t (*sem_lin_scale)(state_t,int_t,obj_t);
} unboxed_sem_linear_callbacks_t;
typedef unboxed_sem_linear_callbacks_t* sem_linear_callbacks_t;
typedef struct {
  obj_t (*sem_var_)(state_t,obj_t,int_t);
} unboxed_sem_var_callbacks_t;
typedef unboxed_sem_var_callbacks_t* sem_var_callbacks_t;
typedef struct {
  obj_t (*sem_address_)(state_t,int_t,obj_t);
} unboxed_sem_address_callbacks_t;
typedef unboxed_sem_address_callbacks_t* sem_address_callbacks_t;
typedef struct {
  obj_t (*sem_stmts_next)(state_t,obj_t,obj_t);
  obj_t (*sem_stmts_init)(state_t,obj_t);
} unboxed_sem_stmts_callbacks_t;
typedef unboxed_sem_stmts_callbacks_t* sem_stmts_callbacks_t;
typedef struct {
  obj_t (*sem_varls_next)(state_t,obj_t,obj_t);
  obj_t (*sem_varls_init)(state_t,obj_t);
} unboxed_sem_varls_callbacks_t;
typedef unboxed_sem_varls_callbacks_t* sem_varls_callbacks_t;
typedef struct {
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
} unboxed_callbacks_t;
typedef unboxed_callbacks_t* callbacks_t;
#endif
