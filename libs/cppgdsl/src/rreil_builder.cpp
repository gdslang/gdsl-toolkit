/*
 * rreil_builder.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/exception/exception.h>
#include <cppgdsl/rreil_builder.h>

#include <cppgdsl/rreil/id/virtual.h>
#include <cppgdsl/rreil/id/arch_id.h>
#include <cppgdsl/rreil/exception/shared_exception.h>
#include <cppgdsl/rreil/exception/arch_exception.h>
#include <cppgdsl/rreil/address.h>
#include <cppgdsl/rreil/branch_hint.h>
#include <cppgdsl/rreil/expr/expr_binop.h>
#include <cppgdsl/rreil/expr/expr_ext.h>
#include <cppgdsl/rreil/expr/expr_sexpr.h>
#include <cppgdsl/rreil/expr_cmp/expr_cmp.h>
#include <cppgdsl/rreil/id/id.h>
#include <cppgdsl/rreil/linear/linear.h>
#include <cppgdsl/rreil/id/shared_id.h>
#include <cppgdsl/rreil/linear/lin_binop.h>
#include <cppgdsl/rreil/linear/lin_imm.h>
#include <cppgdsl/rreil/linear/lin_scale.h>
#include <cppgdsl/rreil/linear/lin_var.h>
#include <cppgdsl/rreil/sexpr/arbitrary.h>
#include <cppgdsl/rreil/sexpr/sexpr_cmp.h>
#include <cppgdsl/rreil/sexpr/sexpr_lin.h>
#include <cppgdsl/rreil/variable.h>
#include <cppgdsl/rreil/variable_limited.h>
#include <cppgdsl/rreil/flop.h>
#include <cppgdsl/rreil/statement/assign.h>
#include <cppgdsl/rreil/statement/branch.h>
#include <cppgdsl/rreil/statement/cbranch.h>
#include <cppgdsl/rreil/statement/floating.h>
#include <cppgdsl/rreil/statement/ite.h>
#include <cppgdsl/rreil/statement/load.h>
#include <cppgdsl/rreil/statement/prim.h>
#include <cppgdsl/rreil/statement/store.h>
#include <cppgdsl/rreil/statement/throw.h>
#include <cppgdsl/rreil/statement/while.h>

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string>
#include <vector>

extern "C" {
#include <gdsl_generic.h>
#include <gdsl_multiplex.h>
}

using namespace gdsl::rreil;
using namespace std;

struct frontend frontend;

// sem_id
static obj_t _shared(state_t state, int_t con) {
  switch(con) {
    case FLOATING_FLAGS: {
      return new shared_id(TYPE_FLOATING_FLAGS);
    }
    default: {
      throw "Invalid shared con";
    }
  }
}

static obj_t virt_t(state_t state, int_t t) {
  return new _virtual(t);
}

obj_t sem_id_arch(state_t state, obj_t gid) {
  char *arch_str = frontend.generic.merge_rope(state, frontend.translator.pretty_arch_id(state, gid));
  return new arch_id(string(arch_str));
}

// sem_exception
static obj_t exception_shared(state_t state, int_t con) {
  switch(con) {
    case DIVISION_BY_ZERO: {
      return new shared_exception(TYPE_DIVISION_BY_ZERO);
    }
    default: {
      throw "Invalid shared exception con";
    }
  }
}

static obj_t exception_arch(state_t state, obj_t ex) {
  char *ex_str = frontend.generic.merge_rope(state, frontend.translator.pretty_arch_exception(state, ex));
  return new arch_exception(string(ex_str));
}

// sem_address
static obj_t sem_address(state_t state, int_t size, obj_t _address) {
  return new address(size, (linear*)_address);
}

// sem_var
static obj_t sem_var(state_t state, obj_t _id, int_t offset) {
  return new variable((id*)_id, offset);
}

// sem_linear
static obj_t sem_lin_var(state_t state, obj_t inner) {
  return new lin_var((variable*)inner);
}

static obj_t sem_lin_imm(state_t state, int_t imm) {
  return new lin_imm(imm);
}

static obj_t sem_lin_add(state_t state, obj_t opnd1, obj_t opnd2) {
  return new lin_binop(BIN_LIN_ADD, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_lin_sub(state_t state, obj_t opnd1, obj_t opnd2) {
  return new lin_binop(BIN_LIN_SUB, (linear*)opnd1, (linear*)opnd2);
}
static obj_t sem_lin_scale(state_t state, int_t imm, obj_t opnd) {
  return new lin_scale(imm, (linear*)opnd);
}

// sem_sexpr
static obj_t sem_sexpr_lin(state_t state, obj_t inner) {
  return new sexpr_lin((linear*)inner);
}

static obj_t sem_sexpr_cmp(state_t state, obj_t inner) {
  return new sexpr_cmp((expr_cmp*)inner);
}

static obj_t sem_sexpr_arb(state_t state, obj_t nothing) {
  return new arbitrary();
}

// sem_expr_cmp
static obj_t sem_cmpeq(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_cmp(CMP_EQ, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_cmpneq(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_cmp(CMP_NEQ, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_cmples(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_cmp(CMP_LES, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_cmpleu(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_cmp(CMP_LEU, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_cmplts(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_cmp(CMP_LTS, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_cmpltu(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_cmp(CMP_LTU, (linear*)opnd1, (linear*)opnd2);
}

// sem_expr
static obj_t sem_sexpr(state_t state, obj_t opnd1) {
  return new expr_sexpr((sexpr*)opnd1);
}

static obj_t sem_mul(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_MUL, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_div(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_DIV, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_divs(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_DIVS, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_mod(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_MOD, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_mods(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_MODS, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_shl(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_SHL, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_shr(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_SHR, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_shrs(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_SHRS, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_and(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_AND, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_or(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_OR, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_xor(state_t state, obj_t opnd1, obj_t opnd2) {
  return new expr_binop(BIN_XOR, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_sx(state_t state, int_t fromsize, obj_t opnd1) {
  return new expr_ext(EXT_SX, fromsize, (linear*)opnd1);
}

static obj_t sem_zx(state_t state, int_t fromsize, obj_t opnd1) {
  return new expr_ext(EXT_ZX, fromsize, (linear*)opnd1);
}

// sem_varl
static obj_t sem_varl(state_t state, obj_t _id, int_t offset, int_t size) {
  return new variable_limited((id*)_id, offset, size);
}

// sem_varls
static obj_t sem_varls_next(state_t state, obj_t next, obj_t list) {
  vector<variable_limited*> *v = (vector<variable_limited*>*)list;
  v->push_back((variable_limited*)next);
  return list;
}

static obj_t sem_varls_init(state_t state, obj_t nothing) {
  return new vector<variable_limited*>();
}

// sem_flop
static obj_t sem_flop(state_t state, int_t con) {
  flop *f = (flop*)malloc(sizeof(flop));
  switch(con) {
    case FADD: {
      *f = FLOP_FADD;
      return f;
    }
    case FSUB: {
      *f = FLOP_FSUB;
      return f;
    }
    case FMUL: {
      *f = FLOP_FMUL;
      return f;
    }
    default: {
      free(f);
      throw "Invalid flop con";
    }
  }
}

// sem_stmt
static obj_t sem_assign(state_t state, int_t size, obj_t lhs, obj_t rhs) {
  return new assign(size, (variable*)lhs, (expr*)rhs);
}

static obj_t sem_load(state_t state, int_t size, obj_t lhs, obj_t _address) {
  return new load(size, (variable*)lhs, (address*)_address);
}

static obj_t sem_store(state_t state, int_t size, obj_t _address, obj_t rhs) {
  return new store(size, (address*)_address, (linear*)rhs);
}

static obj_t sem_ite(state_t state, obj_t cond, obj_t then_branch, obj_t else_branch) {
  return new ite((sexpr*)cond, (statement*)then_branch, (statement*)else_branch);
}

static obj_t sem_while(state_t state, obj_t cond, obj_t body) {
  return new _while((sexpr*)cond, (statement*)body);
}

static obj_t sem_cbranch(state_t state, obj_t cond, obj_t target_true, obj_t target_false) {
  return new cbranch((sexpr*)cond, (address*)target_true, (address*)target_false);
}

static obj_t sem_branch(state_t state, obj_t _branch_hint, obj_t target) {
  branch_hint *hint = (branch_hint*)_branch_hint;
  obj_t stmt = new branch((address*)target, *hint);
  free(hint);
  return stmt;
}

static obj_t sem_flop_stmt(state_t state, obj_t op, obj_t flags, obj_t lhs, obj_t rhs) {
  auto op_typed = (flop*)op;
  auto rhs_typed = (vector<variable_limited*>*)rhs;
  obj_t stmt = new floating(*op_typed, (variable*)flags, (variable_limited*)lhs, *rhs_typed);
  free(op_typed);
  delete rhs_typed;
  return stmt;
}

static obj_t sem_prim(state_t state, obj_t op, obj_t lhs, obj_t rhs) {
  auto op_typed = (char*)op;
  auto lhs_typed = (vector<variable_limited*>*)lhs;
  auto rhs_typed = (vector<variable_limited*>*)rhs;
  obj_t stmt = new prim(string(op_typed), *lhs_typed, *rhs_typed);
  delete lhs_typed;
  delete rhs_typed;
  return stmt;
}

static obj_t sem_throw(state_t state, obj_t _exception) {
  return new _throw((gdsl::rreil::exception*)_exception);
}

// sem_branch_hint
static obj_t _branch_hint(state_t state, int_t con) {
  branch_hint *hint = (branch_hint*)malloc(sizeof(branch_hint));
  switch(con) {
    case HINT_JUMP: {
      *hint = BRANCH_HINT_JUMP;
      break;
    }
    case HINT_CALL: {
      *hint = BRANCH_HINT_CALL;
      break;
    }
    case HINT_RET: {
      *hint = BRANCH_HINT_RET;
      break;
    }
    default: {
      free(hint);
      throw "Invalid flop con";
    }
  }
  return (obj_t)hint;
}

// sem_stmts
static obj_t sem_stmts_next(state_t state, obj_t next, obj_t list) {
  vector<statement*> *v = (vector<statement*>*)list;
  v->push_back((statement*)next);
  return list;
}

static obj_t sem_stmts_init(state_t state, obj_t nothing) {
  return new vector<statement*>();
}

callbacks_t rreil_gdrr_builder_callbacks_get(state_t state) {
  unboxed_sem_id_callbacks_t
  sem_id_callbacks = {.shared = &_shared, .virt_t = &virt_t, .arch = &sem_id_arch};

  unboxed_sem_exception_callbacks_t
  sem_exception_callbacks = {.shared = &exception_shared, .arch = &exception_arch};

  unboxed_sem_address_callbacks_t
  sem_address_callbacks = {.sem_address_ = &sem_address};

  unboxed_sem_var_callbacks_t
  sem_var_callbacks = {.sem_var_ = &sem_var};

  unboxed_sem_linear_callbacks_t
  sem_linear_callbacks = {.sem_lin_var = &sem_lin_var, .sem_lin_imm = &sem_lin_imm,
    .sem_lin_add = &sem_lin_add, .sem_lin_sub = &sem_lin_sub, .sem_lin_scale = &sem_lin_scale};

  unboxed_sem_sexpr_callbacks_t
  sem_sexpr_callbacks = {.sem_sexpr_lin = &sem_sexpr_lin,
    .sem_sexpr_cmp = &sem_sexpr_cmp, .sem_sexpr_arb = &sem_sexpr_arb};

  unboxed_sem_expr_cmp_callbacks_t
  sem_expr_cmp_callbacks = {.sem_cmpeq = &sem_cmpeq, .sem_cmpneq = &sem_cmpneq,
    .sem_cmples = &sem_cmples, .sem_cmpleu = &sem_cmpleu, .sem_cmplts = &sem_cmplts, .sem_cmpltu = &sem_cmpltu};

  unboxed_sem_expr_callbacks_t
  sem_expr_callbacks = {.sem_sexpr = &sem_sexpr, .sem_mul = &sem_mul, .sem_div = &sem_div,
    .sem_divs = &sem_divs, .sem_mod = &sem_mod, .sem_mods = &sem_mods, .sem_shl = &sem_shl, .sem_shr = &sem_shr,
    .sem_shrs = &sem_shrs, .sem_and = &sem_and, .sem_or = &sem_or, .sem_xor = &sem_xor, .sem_sx = &sem_sx, .sem_zx =
    &sem_zx};

  unboxed_sem_varl_callbacks_t
  sem_varl_callbacks = {.sem_varl_ = &sem_varl};

  unboxed_sem_varls_callbacks_t
  sem_varls_callbacks = {.sem_varls_next = &sem_varls_next, .sem_varls_init =
    &sem_varls_init};

  unboxed_sem_flop_callbacks_t
  sem_flop_callbacks = {.sem_flop_ = &sem_flop};

  unboxed_sem_stmt_callbacks_t
  sem_stmt_callbacks = {.sem_assign = &sem_assign, .sem_load = &sem_load, .sem_store =
    &sem_store, .sem_ite = &sem_ite, .sem_while = &sem_while, .sem_cbranch = &sem_cbranch, .sem_branch = &sem_branch,
    .sem_flop = &sem_flop_stmt, .sem_prim = &sem_prim, .sem_throw = &sem_throw};

  unboxed_branch_hint_callbacks_t
  branch_hint_callbacks = {.branch_hint_ = &_branch_hint};

  //  unboxed_sem_stmts_list_callbacks_t sem_stmts_list_callbacks = {
  //      .list_init = &list_init,
  //      .list_next = &list_next
  //  };

  unboxed_sem_stmts_callbacks_t
  sem_stmts_callbacks = {.sem_stmts_next = &sem_stmts_next, .sem_stmts_init =
    &sem_stmts_init};

  struct unboxed_callbacks {
    unboxed_callbacks_t callbacks;

    unboxed_sem_id_callbacks_t sem_id_callbacks;
    unboxed_sem_address_callbacks_t sem_address_callbacks;
    unboxed_sem_var_callbacks_t sem_var_callbacks;
    unboxed_sem_linear_callbacks_t sem_linear_callbacks;
    unboxed_sem_sexpr_callbacks_t sem_sexpr_callbacks;
    unboxed_sem_expr_cmp_callbacks_t sem_expr_cmp_callbacks;
    unboxed_sem_expr_callbacks_t sem_expr_callbacks;
    unboxed_sem_varl_callbacks_t sem_varl_callbacks;
    unboxed_sem_varls_callbacks_t sem_varls_callbacks;
    unboxed_sem_flop_callbacks_t sem_flop_callbacks;
    unboxed_sem_stmt_callbacks_t sem_stmt_callbacks;
    unboxed_branch_hint_callbacks_t branch_hint_callbacks;
    unboxed_sem_exception_callbacks_t sem_exception_callbacks;
    unboxed_sem_stmts_callbacks_t sem_stmts_callbacks;
  };

  struct unboxed_callbacks *callbacks_heap = (struct unboxed_callbacks*)malloc(sizeof(struct unboxed_callbacks));
  callbacks_heap->sem_id_callbacks = sem_id_callbacks;
  callbacks_heap->sem_address_callbacks = sem_address_callbacks;
  callbacks_heap->sem_var_callbacks = sem_var_callbacks;
  callbacks_heap->sem_linear_callbacks = sem_linear_callbacks;
  callbacks_heap->sem_sexpr_callbacks = sem_sexpr_callbacks;
  callbacks_heap->sem_expr_cmp_callbacks = sem_expr_cmp_callbacks;
  callbacks_heap->sem_expr_callbacks = sem_expr_callbacks;
  callbacks_heap->sem_varl_callbacks = sem_varl_callbacks;
  callbacks_heap->sem_varls_callbacks = sem_varls_callbacks;
  callbacks_heap->sem_flop_callbacks = sem_flop_callbacks;
  callbacks_heap->sem_stmt_callbacks = sem_stmt_callbacks;
  callbacks_heap->branch_hint_callbacks = branch_hint_callbacks;
  callbacks_heap->sem_exception_callbacks = sem_exception_callbacks;
  callbacks_heap->sem_stmts_callbacks = sem_stmts_callbacks;

  unboxed_callbacks_t
  callbacks = {.sem_id = &callbacks_heap->sem_id_callbacks, .sem_address =
    &callbacks_heap->sem_address_callbacks, .sem_var = &callbacks_heap->sem_var_callbacks, .sem_linear =
    &callbacks_heap->sem_linear_callbacks, .sem_sexpr = &callbacks_heap->sem_sexpr_callbacks, .sem_expr_cmp =
    &callbacks_heap->sem_expr_cmp_callbacks, .sem_expr = &callbacks_heap->sem_expr_callbacks, .sem_varl =
    &callbacks_heap->sem_varl_callbacks, .sem_varls = &callbacks_heap->sem_varls_callbacks, .sem_flop =
    &callbacks_heap->sem_flop_callbacks, .sem_stmt = &callbacks_heap->sem_stmt_callbacks, .branch_hint =
    &callbacks_heap->branch_hint_callbacks, .sem_exception = &callbacks_heap->sem_exception_callbacks, .sem_stmts =
    &callbacks_heap->sem_stmts_callbacks};

  callbacks_heap->callbacks = callbacks;

  //    config.callbacks.sem_stmts.sem_cons = &sem_cons;
  //    config.callbacks.sem_stmts.sem_nil = &sem_nil;
  //    config.gdrr_config_stmts_handling = GDRR_CONFIG_STMTS_HANDLING_RECURSIVE;

  return &callbacks_heap->callbacks;
}

std::vector<statement*> *gdsl::rreil_builder::translate() {
  char err = gdsl_multiplex_frontend_get_by_lib_name(&frontend, "x86");
  if(err != GDSL_MULTIPLEX_ERROR_NONE) throw "blah";

  uint16_t buffer = 0;
  state_t s = frontend.generic.init();
  frontend.generic.set_code(s, (char*)&buffer, 2, 0);

  obj_t insn = frontend.decoder.decode(s, frontend.decoder.config_default(s));
  obj_t rreil = frontend.translator.translate(s, insn);

  callbacks_t cbs = rreil_gdrr_builder_callbacks_get(s);

  auto v = (std::vector<statement*> *)frontend.translator.rreil_convert_sem_stmts(s, cbs, rreil);

  for (statement *stmt : *v) {
    printf("%s\n", stmt->to_string().c_str());
  }

  return NULL;
}
