#include "cppgdsl/rreil_builder.h"

#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <memory>
#include <string>
#include <vector>

#include "cppgdsl/gdsl_exception.h"
#include "cppgdsl/rreil/rreil.h"

extern "C" {
#include "gdsl_generic.h"
#include "gdsl_multiplex.h"
#include "setjmp.h"
}

using namespace std;

namespace gdsl {

// sem_id
static obj_t _shared(state_t state, int_t con) {
  using namespace rreil;
  switch (con) {
    case ID_FLOATING_FLAGS: {
      return new shared_id(TYPE_FLOATING_FLAGS);
    }
    default: { throw std::runtime_error("Invalid shared ID constructor"); }
  }
}

static obj_t virt_t(state_t state, int_t t) {
  using namespace rreil;
  return new _virtual(t, false);
}

static obj_t virt_o(state_t state, int_t t) {
  using namespace rreil;
  return new _virtual(t, true);
}

obj_t sem_id_arch(state_t state, string_t id_str) {
  using namespace rreil;
  return new arch_id(std::string(id_str));
}

// sem_exception
static obj_t exception_shared(state_t state, int_t con) {
  using namespace rreil;
  switch (con) {
    case EXCEPTION_DIVISION_BY_ZERO: {
      return new shared_exception(TYPE_DIVISION_BY_ZERO);
    }
    default: {
      throw std::runtime_error("Invalid shared exception constructor");
    }
  }
}

static obj_t exception_arch(state_t state, string_t ex_str) {
  using namespace rreil;
  return new arch_exception(std::string(ex_str));
}

// sem_address
static obj_t sem_address(state_t state, int_t size, obj_t _address) {
  using namespace rreil;
  return new address(size, std::unique_ptr<linear>((linear*)_address));
}

// sem_var
static obj_t sem_var(state_t state, obj_t _id, int_t offset) {
  using namespace rreil;
  return new variable(std::unique_ptr<id>((id*)_id), offset);
}

// sem_linear
static obj_t sem_lin_var(state_t state, obj_t inner) {
  using namespace rreil;
  return new lin_var(std::unique_ptr<variable>((variable*)inner));
}

static obj_t sem_lin_imm(state_t state, int_t imm) {
  using namespace rreil;
  return new lin_imm(imm);
}

static obj_t sem_lin_add(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new lin_binop(BIN_LIN_ADD, std::unique_ptr<linear>((linear*)opnd1),
                       std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_lin_sub(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new lin_binop(BIN_LIN_SUB, std::unique_ptr<linear>((linear*)opnd1),
                       std::unique_ptr<linear>((linear*)opnd2));
}
static obj_t sem_lin_scale(state_t state, int_t imm, obj_t opnd) {
  using namespace rreil;
  return new lin_scale(imm, std::unique_ptr<linear>((linear*)opnd));
}

// sem_sexpr
static obj_t sem_sexpr_lin(state_t state, obj_t inner) {
  using namespace rreil;
  return new sexpr_lin(std::unique_ptr<linear>((linear*)inner));
}

static obj_t sem_sexpr_cmp(state_t state, int_t size, obj_t inner) {
  using namespace rreil;
  return new sexpr_cmp(size, std::unique_ptr<expr_cmp>((expr_cmp*)inner));
}

static obj_t sem_sexpr_arb(state_t state) {
  using namespace rreil;
  return new arbitrary();
}

// sem_expr_cmp
static obj_t sem_cmpeq(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_cmp(CMP_EQ, std::unique_ptr<linear>((linear*)opnd1),
                      std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_cmpneq(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_cmp(CMP_NEQ, std::unique_ptr<linear>((linear*)opnd1),
                      std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_cmples(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_cmp(CMP_LES, std::unique_ptr<linear>((linear*)opnd1),
                      std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_cmpleu(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_cmp(CMP_LEU, std::unique_ptr<linear>((linear*)opnd1),
                      std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_cmplts(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_cmp(CMP_LTS, std::unique_ptr<linear>((linear*)opnd1),
                      std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_cmpltu(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_cmp(CMP_LTU, std::unique_ptr<linear>((linear*)opnd1),
                      std::unique_ptr<linear>((linear*)opnd2));
}

// sem_expr
static obj_t sem_sexpr(state_t state, obj_t opnd1) {
  using namespace rreil;
  return new expr_sexpr(std::unique_ptr<sexpr>((sexpr*)opnd1));
}

static obj_t sem_mul(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_MUL, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_div(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_DIV, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_divs(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_DIVS, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_mod(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_MOD, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_mods(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_MODS, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_shl(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_SHL, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_shr(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_SHR, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_shrs(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_SHRS, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_and(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_AND, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_or(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_OR, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_xor(state_t state, obj_t opnd1, obj_t opnd2) {
  using namespace rreil;
  return new expr_binop(BIN_XOR, std::unique_ptr<linear>((linear*)opnd1),
                        std::unique_ptr<linear>((linear*)opnd2));
}

static obj_t sem_sx(state_t state, int_t fromsize, obj_t opnd1) {
  using namespace rreil;
  return new expr_ext(EXT_SX, fromsize,
                      std::unique_ptr<linear>((linear*)opnd1));
}

static obj_t sem_zx(state_t state, int_t fromsize, obj_t opnd1) {
  using namespace rreil;
  return new expr_ext(EXT_ZX, fromsize,
                      std::unique_ptr<linear>((linear*)opnd1));
}

// sem_varl
static obj_t sem_varl(state_t state, obj_t _id, int_t offset, int_t size) {
  using namespace rreil;
  return new variable_limited(std::unique_ptr<id>((id*)_id), offset, size);
}

// sem_varls
static obj_t sem_varls_next(state_t state, obj_t next, obj_t list) {
  using namespace rreil;
  auto* v = (variables_limited_t*)list;
  v->push_back(std::unique_ptr<variable_limited>((variable_limited*)next));
  return list;
}

static obj_t sem_varls_init(state_t state) {
  using namespace rreil;
  return new variables_limited_t();
}

// sem_flop
static obj_t sem_flop(state_t state, int_t con) {
  rreil::flop* f = (rreil::flop*)malloc(sizeof(rreil::flop));
  switch (con) {
    case FLOP_FADD: {
      *f = rreil::FLOP_FADD;
      return f;
    }
    case FLOP_FSUB: {
      *f = rreil::FLOP_FADD;
      return f;
    }
    case FLOP_FMUL: {
      *f = rreil::FLOP_FADD;
      return f;
    }
    default: {
      free(f);
      throw std::runtime_error("Invalid floating point operation constructor");
    }
  }
}

// sem_stmt
static obj_t sem_assign(state_t state, int_t size, obj_t lhs, obj_t rhs) {
  using namespace rreil;
  return new assign(size, std::unique_ptr<variable>((variable*)lhs),
                    std::unique_ptr<expr>((expr*)rhs));
}

static obj_t sem_load(state_t state, int_t size, obj_t lhs, obj_t _address) {
  using namespace rreil;
  return new load(size, std::unique_ptr<variable>((variable*)lhs),
                  std::unique_ptr<address>((address*)_address));
}

static obj_t sem_store(state_t state, int_t size, obj_t _address, obj_t rhs) {
  using namespace rreil;
  return new store(size, std::unique_ptr<address>((address*)_address),
                   std::unique_ptr<linear>((linear*)rhs));
}

static obj_t sem_ite(state_t state, obj_t cond, obj_t then_branch,
                     obj_t else_branch) {
  using namespace rreil;
  auto then_branch_casted = std::unique_ptr<statements_t>(
      (vector<std::unique_ptr<statement>>*)then_branch);
  auto else_branch_casted = std::unique_ptr<statements_t>(
      (vector<std::unique_ptr<statement>>*)else_branch);
  return new ite(std::unique_ptr<sexpr>((sexpr*)cond),
                 std::move(*then_branch_casted),
                 std::move(*else_branch_casted));
}

static obj_t sem_while(state_t state, obj_t cond, obj_t body) {
  using namespace rreil;
  auto body_casted =
      std::unique_ptr<statements_t>((vector<std::unique_ptr<statement>>*)body);
  return new _while(std::unique_ptr<sexpr>((sexpr*)cond),
                    std::move(*body_casted));
}

static obj_t sem_cbranch(state_t state, obj_t cond, obj_t target_true,
                         obj_t target_false) {
  using namespace rreil;
  return new cbranch(std::unique_ptr<sexpr>((sexpr*)cond),
                     std::unique_ptr<address>((address*)target_true),
                     std::unique_ptr<address>((address*)target_false));
}

static obj_t sem_branch(state_t state, obj_t _branch_hint, obj_t target) {
  rreil::branch_hint* hint = (rreil::branch_hint*)_branch_hint;
  obj_t stmt = new rreil::branch(
      std::unique_ptr<rreil::address>((rreil::address*)target), *hint);
  free(hint);
  return stmt;
}

static obj_t sem_flop_stmt(state_t state, obj_t op, obj_t flags, obj_t lhs,
                           obj_t rhs) {
  auto op_typed = (rreil::flop*)op;
  auto rhs_typed = (rreil::variables_limited_t*)rhs;
  obj_t stmt = new rreil::floating(
      *op_typed, std::unique_ptr<rreil::variable>((rreil::variable*)flags),
      std::unique_ptr<rreil::variable_limited>((rreil::variable_limited*)lhs),
      move(*rhs_typed));
  free(op_typed);
  delete rhs_typed;
  return stmt;
}

static obj_t sem_prim(state_t state, string_t op, obj_t lhs, obj_t rhs) {
  using namespace rreil;
  auto lhs_typed = (variables_limited_t*)lhs;
  auto rhs_typed = (variables_limited_t*)rhs;
  obj_t stmt = new prim(std::string(op), move(*lhs_typed), move(*rhs_typed));
  delete lhs_typed;
  delete rhs_typed;
  return stmt;
}

static obj_t sem_throw(state_t state, obj_t _exception) {
  using namespace rreil;
  return new _throw(
      unique_ptr<rreil::exception>((rreil::exception*)_exception));
}

// sem_branch_hint
static obj_t _branch_hint(state_t state, int_t con) {
  rreil::branch_hint* hint =
      (rreil::branch_hint*)malloc(sizeof(rreil::branch_hint));
  switch (con) {
    case BRANCH_HINT_JUMP: {
      *hint = rreil::BRANCH_HINT_JUMP;
      break;
    }
    case BRANCH_HINT_CALL: {
      *hint = rreil::BRANCH_HINT_CALL;
      break;
    }
    case BRANCH_HINT_RET: {
      *hint = rreil::BRANCH_HINT_RET;
      break;
    }
    default: {
      free(hint);
      throw std::runtime_error("Invalid branch hint constructor");
    }
  }
  return (obj_t)hint;
}

// sem_stmts
static obj_t sem_stmts_next(state_t state, obj_t next, obj_t list) {
  using namespace rreil;
  auto v = (statements_t*)list;
  v->push_back(unique_ptr<statement>((statement*)next));
  return list;
}

static obj_t sem_stmts_init(state_t state) {
  using namespace rreil;
  return new statements_t();
}

using cb_up_t = std::unique_ptr<unboxed_callbacks_t, void (*)(callbacks_t)>;

cb_up_t rreil_gdrr_builder_callbacks_get(state_t state) {
  unboxed_sem_id_callbacks_t sem_id_callbacks;
  sem_id_callbacks.arch = &sem_id_arch;
  sem_id_callbacks.shared = &_shared;
  sem_id_callbacks.virt_o = &virt_o;
  sem_id_callbacks.virt_t = &virt_t;

  unboxed_sem_exception_callbacks_t sem_exception_callbacks;
  sem_exception_callbacks.arch = exception_arch;
  sem_exception_callbacks.shared = exception_shared;

  unboxed_sem_address_callbacks_t sem_address_callbacks;
  sem_address_callbacks.sem_address_ = &sem_address;

  unboxed_sem_var_callbacks_t sem_var_callbacks;
  sem_var_callbacks.sem_var_ = &sem_var;

  unboxed_sem_linear_callbacks_t sem_linear_callbacks;
  sem_linear_callbacks.sem_lin_add = &sem_lin_add;
  sem_linear_callbacks.sem_lin_imm = &sem_lin_imm;
  sem_linear_callbacks.sem_lin_scale = &sem_lin_scale;
  sem_linear_callbacks.sem_lin_sub = &sem_lin_sub;
  sem_linear_callbacks.sem_lin_var = &sem_lin_var;

  unboxed_sem_sexpr_callbacks_t sem_sexpr_callbacks;
  sem_sexpr_callbacks.sem_sexpr_arb = &sem_sexpr_arb;
  sem_sexpr_callbacks.sem_sexpr_cmp = &sem_sexpr_cmp;
  sem_sexpr_callbacks.sem_sexpr_lin = &sem_sexpr_lin;

  unboxed_sem_expr_cmp_callbacks_t sem_expr_cmp_callbacks;
  sem_expr_cmp_callbacks.sem_cmpeq = &sem_cmpeq;
  sem_expr_cmp_callbacks.sem_cmples = &sem_cmples;
  sem_expr_cmp_callbacks.sem_cmpleu = &sem_cmpleu;
  sem_expr_cmp_callbacks.sem_cmplts = &sem_cmplts;
  sem_expr_cmp_callbacks.sem_cmpltu = &sem_cmpltu;
  sem_expr_cmp_callbacks.sem_cmpneq = &sem_cmpneq;

  unboxed_sem_expr_callbacks_t sem_expr_callbacks;
  sem_expr_callbacks.sem_and = &sem_and;
  sem_expr_callbacks.sem_div = &sem_div;
  sem_expr_callbacks.sem_divs = &sem_divs;
  sem_expr_callbacks.sem_mod = &sem_mod;
  sem_expr_callbacks.sem_mods = &sem_mods;
  sem_expr_callbacks.sem_mul = &sem_mul;
  sem_expr_callbacks.sem_or = &sem_or;
  sem_expr_callbacks.sem_sexpr = &sem_sexpr;
  sem_expr_callbacks.sem_shl = &sem_shl;
  sem_expr_callbacks.sem_shr = &sem_shr;
  sem_expr_callbacks.sem_shrs = &sem_shrs;
  sem_expr_callbacks.sem_sx = &sem_sx;
  sem_expr_callbacks.sem_zx = &sem_zx;
  sem_expr_callbacks.sem_xor = &sem_xor;

  unboxed_sem_varl_callbacks_t sem_varl_callbacks;
  sem_varl_callbacks.sem_varl_ = &sem_varl;

  unboxed_sem_varl_list_callbacks_t sem_varl_list_callbacks;
  sem_varl_list_callbacks.sem_varl_list_init = &sem_varls_init;
  sem_varl_list_callbacks.sem_varl_list_next = &sem_varls_next;

  unboxed_sem_flop_callbacks_t sem_flop_callbacks;
  sem_flop_callbacks.sem_flop_ = &sem_flop;

  unboxed_sem_stmt_callbacks_t sem_stmt_callbacks;
  sem_stmt_callbacks.sem_assign = &sem_assign;
  sem_stmt_callbacks.sem_branch = &sem_branch;
  sem_stmt_callbacks.sem_cbranch = &sem_cbranch;
  sem_stmt_callbacks.sem_flop = sem_flop_stmt;
  sem_stmt_callbacks.sem_ite = &sem_ite;
  sem_stmt_callbacks.sem_load = &sem_load;
  sem_stmt_callbacks.sem_prim = &sem_prim;
  sem_stmt_callbacks.sem_store = &sem_store;
  sem_stmt_callbacks.sem_throw = &sem_throw;
  sem_stmt_callbacks.sem_while = &sem_while;

  unboxed_branch_hint_callbacks_t branch_hint_callbacks;
  branch_hint_callbacks.branch_hint_ = &_branch_hint;

  unboxed_sem_stmt_list_callbacks_t sem_stmt_list_callbacks;
  sem_stmt_list_callbacks.sem_stmt_list_init = &sem_stmts_init;
  sem_stmt_list_callbacks.sem_stmt_list_next = &sem_stmts_next;

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

  struct unboxed_callbacks* callbacks_heap =
      (struct unboxed_callbacks*)malloc(sizeof(struct unboxed_callbacks));
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

  unboxed_callbacks_t callbacks;
  callbacks.branch_hint = &callbacks_heap->branch_hint_callbacks;
  callbacks.sem_address = &callbacks_heap->sem_address_callbacks;
  callbacks.sem_exception = &callbacks_heap->sem_exception_callbacks;
  callbacks.sem_expr = &callbacks_heap->sem_expr_callbacks;
  callbacks.sem_expr_cmp = &callbacks_heap->sem_expr_cmp_callbacks;
  callbacks.sem_flop = &callbacks_heap->sem_flop_callbacks;
  callbacks.sem_id = &callbacks_heap->sem_id_callbacks;
  callbacks.sem_linear = &callbacks_heap->sem_linear_callbacks;
  callbacks.sem_sexpr = &callbacks_heap->sem_sexpr_callbacks;
  callbacks.sem_stmt = &callbacks_heap->sem_stmt_callbacks;
  callbacks.sem_stmt_list = &callbacks_heap->sem_stmt_list_callbacks;
  callbacks.sem_var = &callbacks_heap->sem_var_callbacks;
  callbacks.sem_varl = &callbacks_heap->sem_varl_callbacks;
  callbacks.sem_varl_list = &callbacks_heap->sem_varl_list_callbacks;

  callbacks_heap->callbacks = callbacks;

  return cb_up_t((callbacks_t)&callbacks_heap->callbacks,
                 [](callbacks_t c) { free(c); });
}

rreil_builder::rreil_builder(gdsl* g) { this->g = g; }

rreil::statements_t rreil_builder::convert(obj_t rreil) {
  using namespace rreil;
  struct frontend frontend_glob = g->get_frontend()->native();

  if (setjmp(*frontend_glob.generic.err_tgt(g->get_state())))
    throw gdsl_exception(
        "convert() failed",
        std::string(frontend_glob.generic.get_error_message(g->get_state())));

  auto cbs = rreil_gdrr_builder_callbacks_get(g->get_state());
  auto v = unique_ptr<rreil::statements_t>(
      (rreil::statements_t*)(frontend_glob.translator
                                 .rreil_convert_sem_stmt_list(
                                     g->get_state(), cbs.get(), rreil)));
  return std::move(*v);
}

}  // namespace gdsl
