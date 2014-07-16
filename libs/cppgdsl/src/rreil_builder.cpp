/*
 * rreil_builder.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/gdsl_exception.h>
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
#include <setjmp.h>
}

using namespace std;

struct frontend frontend_glob;

// sem_id
static obj_t _shared(state_t state, int_t con) {
  using namespace gdsl::rreil;
  switch(con) {
    case ID_FLOATING_FLAGS: {
      return new shared_id(TYPE_FLOATING_FLAGS);
    }
    default: {
      throw string("Invalid shared con");
    }
  }
}

static obj_t virt_t(state_t state, int_t t) {
  using namespace gdsl::rreil;
  return new _virtual(t);
}

obj_t sem_id_arch(state_t state, string_t id_str) {
  using namespace gdsl::rreil;
  return new arch_id(string(id_str));
}

// sem_exception
static obj_t exception_shared(state_t state, int_t con) {
  using namespace gdsl::rreil;
  switch(con) {
    case EXCEPTION_DIVISION_BY_ZERO: {
      return new shared_exception(TYPE_DIVISION_BY_ZERO);
    }
    default: {
      throw string("Invalid shared exception con");
    }
  }
}

static obj_t exception_arch(state_t state, string_t ex_str) {
  using namespace gdsl::rreil;
  return new arch_exception(string(ex_str));
}

// sem_address
static obj_t sem_address(state_t state, int_t size, obj_t _address) {
  using namespace gdsl::rreil;
  return new address(size, (linear*)_address);
}

// sem_var
static obj_t sem_var(state_t state, obj_t _id, int_t offset) {
  using namespace gdsl::rreil;
  return new variable((id*)_id, offset);
}

// sem_linear
static obj_t sem_lin_var(state_t state, obj_t inner) {
  using namespace gdsl::rreil;
  return new lin_var((variable*)inner);
}

static obj_t sem_lin_imm(state_t state, int_t imm) {
  using namespace gdsl::rreil;
  return new lin_imm(imm);
}

static obj_t sem_lin_add(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new lin_binop(BIN_LIN_ADD, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_lin_sub(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new lin_binop(BIN_LIN_SUB, (linear*)opnd1, (linear*)opnd2);
}
static obj_t sem_lin_scale(state_t state, int_t imm, obj_t opnd) {
  using namespace gdsl::rreil;
  return new lin_scale(imm, (linear*)opnd);
}

// sem_sexpr
static obj_t sem_sexpr_lin(state_t state, obj_t inner) {
  using namespace gdsl::rreil;
  return new sexpr_lin((linear*)inner);
}

static obj_t sem_sexpr_cmp(state_t state, obj_t inner) {
  using namespace gdsl::rreil;
  return new sexpr_cmp((expr_cmp*)inner);
}

static obj_t sem_sexpr_arb(state_t state) {
  using namespace gdsl::rreil;
  return new arbitrary();
}

// sem_expr_cmp
static obj_t sem_cmpeq(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_cmp(CMP_EQ, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_cmpneq(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_cmp(CMP_NEQ, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_cmples(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_cmp(CMP_LES, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_cmpleu(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_cmp(CMP_LEU, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_cmplts(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_cmp(CMP_LTS, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_cmpltu(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_cmp(CMP_LTU, (linear*)opnd1, (linear*)opnd2);
}

// sem_expr
static obj_t sem_sexpr(state_t state, obj_t opnd1) {
  using namespace gdsl::rreil;
  return new expr_sexpr((sexpr*)opnd1);
}

static obj_t sem_mul(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_MUL, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_div(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_DIV, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_divs(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_DIVS, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_mod(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_MOD, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_mods(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_MODS, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_shl(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_SHL, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_shr(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_SHR, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_shrs(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_SHRS, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_and(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_AND, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_or(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_OR, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_xor(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace gdsl::rreil;
  return new expr_binop(BIN_XOR, (linear*)opnd1, (linear*)opnd2);
}

static obj_t sem_sx(state_t state, int_t fromsize, obj_t opnd1) {
  using namespace gdsl::rreil;
  return new expr_ext(EXT_SX, fromsize, (linear*)opnd1);
}

static obj_t sem_zx(state_t state, int_t fromsize, obj_t opnd1) {
  using namespace gdsl::rreil;
  return new expr_ext(EXT_ZX, fromsize, (linear*)opnd1);
}

// sem_varl
static obj_t sem_varl(state_t state, obj_t _id, int_t offset, int_t size) {
  using namespace gdsl::rreil;
  return new variable_limited((id*)_id, offset, size);
}

// sem_varls
static obj_t sem_varls_next(state_t state, obj_t next, obj_t list) {
  using namespace gdsl::rreil;
  vector<variable_limited*> *v = (vector<variable_limited*>*)list;
  v->push_back((variable_limited*)next);
  return list;
}

static obj_t sem_varls_init(state_t state) {
  using namespace gdsl::rreil;
  return new vector<variable_limited*>();
}

// sem_flop
static obj_t sem_flop(state_t state, int_t con) {
  gdsl::rreil::flop *f = (gdsl::rreil::flop*)malloc(sizeof(gdsl::rreil::flop));
  switch(con) {
    case FLOP_FADD: {
      *f = gdsl::rreil::FLOP_FADD;
      return f;
    }
    case FLOP_FSUB: {
      *f = gdsl::rreil::FLOP_FADD;
      return f;
    }
    case FLOP_FMUL: {
      *f = gdsl::rreil::FLOP_FADD;
      return f;
    }
    default: {
      free(f);
      throw string("Invalid flop con");
    }
  }
}

// sem_stmt
static obj_t sem_assign(state_t state, int_t size, obj_t lhs, obj_t rhs) {
  using namespace gdsl::rreil;
  return new assign(size, (variable*)lhs, (expr*)rhs);
}

static obj_t sem_load(state_t state, int_t size, obj_t lhs, obj_t _address) {
  using namespace gdsl::rreil;
  return new load(size, (variable*)lhs, (address*)_address);
}

static obj_t sem_store(state_t state, int_t size, obj_t _address, obj_t rhs) {
  using namespace gdsl::rreil;
  return new store(size, (address*)_address, (linear*)rhs);
}

static obj_t sem_ite(state_t state, obj_t cond, obj_t then_branch, obj_t else_branch) {
  using namespace gdsl::rreil;
  return new ite((sexpr*)cond, (statement*)then_branch, (statement*)else_branch);
}

static obj_t sem_while(state_t state, obj_t cond, obj_t body) {
  using namespace gdsl::rreil;
  return new _while((sexpr*)cond, (statement*)body);
}

static obj_t sem_cbranch(state_t state, obj_t cond, obj_t target_true, obj_t target_false) {
  using namespace gdsl::rreil;
  return new cbranch((sexpr*)cond, (address*)target_true, (address*)target_false);
}

static obj_t sem_branch(state_t state, obj_t _branch_hint, obj_t target) {
  gdsl::rreil::branch_hint *hint = (gdsl::rreil::branch_hint*)_branch_hint;
  obj_t stmt = new gdsl::rreil::branch((gdsl::rreil::address*)target, *hint);
  free(hint);
  return stmt;
}

static obj_t sem_flop_stmt(state_t state, obj_t op, obj_t flags, obj_t lhs, obj_t rhs) {
  auto op_typed = (gdsl::rreil::flop*)op;
  auto rhs_typed = (vector<gdsl::rreil::variable_limited*>*)rhs;
  obj_t stmt = new gdsl::rreil::floating(*op_typed, (gdsl::rreil::variable*)flags, (gdsl::rreil::variable_limited*)lhs, *rhs_typed);
  free(op_typed);
  delete rhs_typed;
  return stmt;
}

static obj_t sem_prim(state_t state, string_t op, obj_t lhs, obj_t rhs) {
  using namespace gdsl::rreil;
  auto lhs_typed = (vector<variable_limited*>*)lhs;
  auto rhs_typed = (vector<variable_limited*>*)rhs;
  obj_t stmt = new prim(string(op), *lhs_typed, *rhs_typed);
  delete lhs_typed;
  delete rhs_typed;
  return stmt;
}

static obj_t sem_throw(state_t state, obj_t _exception) {
  using namespace gdsl::rreil;
  return new _throw((gdsl::rreil::exception*)_exception);
}

// sem_branch_hint
static obj_t _branch_hint(state_t state, int_t con) {
  gdsl::rreil::branch_hint *hint = (gdsl::rreil::branch_hint*)malloc(sizeof(gdsl::rreil::branch_hint));
  switch(con) {
    case BRANCH_HINT_JUMP: {
      *hint = gdsl::rreil::BRANCH_HINT_JUMP;
      break;
    }
    case BRANCH_HINT_CALL: {
      *hint = gdsl::rreil::BRANCH_HINT_CALL;
      break;
    }
    case BRANCH_HINT_RET: {
      *hint = gdsl::rreil::BRANCH_HINT_RET;
      break;
    }
    default: {
      free(hint);
      throw string("Invalid flop con");
    }
  }
  return (obj_t)hint;
}

// sem_stmts
static obj_t sem_stmts_next(state_t state, obj_t next, obj_t list) {
  using namespace gdsl::rreil;
  vector<statement*> *v = (vector<statement*>*)list;
  v->push_back((statement*)next);
  return list;
}

static obj_t sem_stmts_init(state_t state) {
  using namespace gdsl::rreil;
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

  unboxed_sem_varl_list_callbacks_t
  sem_varl_list_callbacks = {.sem_varl_list_next = &sem_varls_next, .sem_varl_list_init =
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

  unboxed_sem_stmt_list_callbacks_t
  sem_stmt_list_callbacks = {.sem_stmt_list_next = &sem_stmts_next, .sem_stmt_list_init =
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
    unboxed_sem_varl_list_callbacks_t sem_varl_list_callbacks;
    unboxed_sem_flop_callbacks_t sem_flop_callbacks;
    unboxed_sem_stmt_callbacks_t sem_stmt_callbacks;
    unboxed_branch_hint_callbacks_t branch_hint_callbacks;
    unboxed_sem_exception_callbacks_t sem_exception_callbacks;
    unboxed_sem_stmt_list_callbacks_t sem_stmt_list_callbacks;
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
  callbacks_heap->sem_varl_list_callbacks = sem_varl_list_callbacks;
  callbacks_heap->sem_flop_callbacks = sem_flop_callbacks;
  callbacks_heap->sem_stmt_callbacks = sem_stmt_callbacks;
  callbacks_heap->branch_hint_callbacks = branch_hint_callbacks;
  callbacks_heap->sem_exception_callbacks = sem_exception_callbacks;
  callbacks_heap->sem_stmt_list_callbacks = sem_stmt_list_callbacks;

  unboxed_callbacks_t
  callbacks = {.sem_id = &callbacks_heap->sem_id_callbacks, .sem_address =
    &callbacks_heap->sem_address_callbacks, .sem_var = &callbacks_heap->sem_var_callbacks, .sem_linear =
    &callbacks_heap->sem_linear_callbacks, .sem_sexpr = &callbacks_heap->sem_sexpr_callbacks, .sem_expr_cmp =
    &callbacks_heap->sem_expr_cmp_callbacks, .sem_expr = &callbacks_heap->sem_expr_callbacks, .sem_varl =
    &callbacks_heap->sem_varl_callbacks, .sem_varl_list = &callbacks_heap->sem_varl_list_callbacks, .sem_flop =
    &callbacks_heap->sem_flop_callbacks, .sem_stmt = &callbacks_heap->sem_stmt_callbacks, .branch_hint =
    &callbacks_heap->branch_hint_callbacks, .sem_exception = &callbacks_heap->sem_exception_callbacks, .sem_stmt_list =
    &callbacks_heap->sem_stmt_list_callbacks};

  callbacks_heap->callbacks = callbacks;

  //    config.callbacks.sem_stmts.sem_cons = &sem_cons;
  //    config.callbacks.sem_stmts.sem_nil = &sem_nil;
  //    config.gdrr_config_stmts_handling = GDRR_CONFIG_STMTS_HANDLING_RECURSIVE;

  return &callbacks_heap->callbacks;
}

gdsl::rreil_builder::rreil_builder(gdsl::gdsl *g) {
  this->g = g;
}

std::vector<gdsl::rreil::statement*>* gdsl::rreil_builder::convert(obj_t rreil) {
  using namespace rreil;
  frontend_glob = g->get_frontend()->native();

  if(setjmp(*frontend_glob.generic.err_tgt(g->get_state())))
    throw gdsl_exception("convert() failed", string(frontend_glob.generic.get_error_message(g->get_state())));

  callbacks_t cbs = rreil_gdrr_builder_callbacks_get(g->get_state());
  auto v = (std::vector<statement*> *)frontend_glob.translator.rreil_convert_sem_stmts(g->get_state(), cbs, rreil);

  free(cbs);

  return v;
}
//std::vector<statement*> *gdsl::rreil_builder::translate() {
//  char err = gdsl_multiplex_frontend_get_by_lib_name(&frontend, "x86");
//  if(err != GDSL_MULTIPLEX_ERROR_NONE) throw "blah";
//
//  uint16_t buffer = 0;
//  state_t s = frontend.generic.init();
//  frontend.generic.set_code(s, (char*)&buffer, 2, 0);
//
//  obj_t insn = frontend.decoder.decode(s, frontend.decoder.config_default(s));
//  obj_t rreil = frontend.translator.translate(s, insn);
//
//  callbacks_t cbs = rreil_gdrr_builder_callbacks_get(s);
//
//  auto v = (std::vector<statement*> *)frontend.translator.rreil_convert_sem_stmts(s, cbs, rreil);
//
//  for (statement *stmt : *v) {
//    printf("%s\n", stmt->to_string().c_str());
//  }
//
//  return NULL;
//}
