#pragma once

#include <memory>
#include <vector>

#include "cppgdsl/rreil/branch_hint.h"
#include "cppgdsl/rreil/exception/shared_exception.h"
#include "cppgdsl/rreil/expr_cmp/cmp_op.h"
#include "cppgdsl/rreil/expr/binop_op.h"
#include "cppgdsl/rreil/expr/expr_ext.h"
#include "cppgdsl/rreil/flop.h"
#include "cppgdsl/rreil/id/shared_id.h"
#include "cppgdsl/rreil/visitor.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class linear;
class expr;
class sexpr;
class statement;
class id;
class exception;

class variable;
class variable_limited;
class address;
class expr_cmp;

class copy_visitor : public visitor {
 public:
  using variable_ctor_t =
      std::function<std::unique_ptr<variable>(std::unique_ptr<id>, int_t)>;
  using variable_limited_ctor_t =
      std::function<std::unique_ptr<variable_limited>(std::unique_ptr<id>,
                                                      int_t, int_t)>;
  using address_ctor_t =
      std::function<std::unique_ptr<address>(int_t, std::unique_ptr<linear>)>;
  using expr_cmp_ctor_t = std::function<std::unique_ptr<expr_cmp>(
      cmp_op, std::unique_ptr<linear>, std::unique_ptr<linear>)>;
  using expr_binop_ctor_t = std::function<std::unique_ptr<expr>(
      binop_op, std::unique_ptr<linear>, std::unique_ptr<linear>)>;
  using expr_ext_ctor_t = std::function<std::unique_ptr<expr>(
      ext_op, int_t, std::unique_ptr<linear>)>;
  using expr_sexpr_ctor_t =
      std::function<std::unique_ptr<expr>(std::unique_ptr<sexpr>)>;
  using arch_id_ctor_t = std::function<std::unique_ptr<id>(std::string)>;
  using shared_id_ctor_t = std::function<std::unique_ptr<id>(shared_id_type)>;
  using _virtual_ctor_t = std::function<std::unique_ptr<id>(int_t, bool)>;
  using lin_binop_ctor_t = std::function<std::unique_ptr<linear>(
      binop_lin_op, std::unique_ptr<linear>, std::unique_ptr<linear>)>;
  using lin_imm_ctor_t = std::function<std::unique_ptr<linear>(int_t)>;
  using lin_scale_ctor_t =
      std::function<std::unique_ptr<linear>(int_t, std::unique_ptr<linear>)>;
  using lin_var_ctor_t =
      std::function<std::unique_ptr<linear>(std::unique_ptr<variable>)>;
  using arbitrary_ctor_t = std::function<std::unique_ptr<sexpr>()>;
  using sexpr_cmp_ctor_t =
      std::function<std::unique_ptr<sexpr>(int_t, std::unique_ptr<expr_cmp>)>;
  using sexpr_lin_ctor_t =
      std::function<std::unique_ptr<sexpr>(std::unique_ptr<linear>)>;
  using assign_ctor_t = std::function<std::unique_ptr<statement>(
      int_t, std::unique_ptr<variable>, std::unique_ptr<expr>)>;
  using load_ctor_t = std::function<std::unique_ptr<statement>(
      int_t, std::unique_ptr<variable>, std::unique_ptr<address>)>;
  using store_ctor_t = std::function<std::unique_ptr<statement>(
      int_t, std::unique_ptr<address>, std::unique_ptr<linear>)>;
  using ite_ctor_t = std::function<std::unique_ptr<statement>(
      std::unique_ptr<sexpr>, std::vector<std::unique_ptr<statement>>,
      std::vector<std::unique_ptr<statement>>)>;
  using _while_ctor_t = std::function<std::unique_ptr<statement>(
      std::unique_ptr<sexpr>, std::vector<std::unique_ptr<statement>>)>;
  using cbranch_ctor_t = std::function<std::unique_ptr<statement>(
      std::unique_ptr<sexpr>, std::unique_ptr<address>,
      std::unique_ptr<address>)>;
  using branch_ctor_t = std::function<std::unique_ptr<statement>(
      std::unique_ptr<address>, ::gdsl::rreil::branch_hint)>;
  using floating_ctor_t = std::function<std::unique_ptr<statement>(
      ::gdsl::rreil::flop, std::unique_ptr<variable>,
      std::unique_ptr<variable_limited>,
      std::vector<std::unique_ptr<variable_limited>>)>;
  using prim_ctor_t = std::function<std::unique_ptr<statement>(
      std::string, std::vector<std::unique_ptr<variable_limited>>,
      std::vector<std::unique_ptr<variable_limited>>)>;
  using _throw_ctor_t = std::function<std::unique_ptr<statement>(
      std::unique_ptr<::gdsl::rreil::exception>)>;
  using arch_exception_ctor_t =
      std::function<std::unique_ptr<::gdsl::rreil::exception>(std::string)>;
  using shared_exception_ctor_t =
      std::function<std::unique_ptr<::gdsl::rreil::exception>(
          shared_exception_type)>;

 private:
  variable_ctor_t variable_ctor = NULL;
  variable_limited_ctor_t variable_limited_ctor = NULL;
  address_ctor_t address_ctor = NULL;
  expr_cmp_ctor_t expr_cmp_ctor = NULL;
  expr_binop_ctor_t expr_binop_ctor = NULL;
  expr_ext_ctor_t expr_ext_ctor = NULL;
  expr_sexpr_ctor_t expr_sexpr_ctor = NULL;
  arch_id_ctor_t arch_id_ctor = NULL;
  shared_id_ctor_t shared_id_ctor = NULL;
  _virtual_ctor_t _virtual_ctor = NULL;
  lin_binop_ctor_t lin_binop_ctor = NULL;
  lin_imm_ctor_t lin_imm_ctor = NULL;
  lin_scale_ctor_t lin_scale_ctor = NULL;
  lin_var_ctor_t lin_var_ctor = NULL;
  arbitrary_ctor_t arbitrary_ctor = NULL;
  sexpr_cmp_ctor_t sexpr_cmp_ctor = NULL;
  sexpr_lin_ctor_t sexpr_lin_ctor = NULL;
  assign_ctor_t assign_ctor = NULL;
  load_ctor_t load_ctor = NULL;
  store_ctor_t store_ctor = NULL;
  ite_ctor_t ite_ctor = NULL;
  _while_ctor_t _while_ctor = NULL;
  cbranch_ctor_t cbranch_ctor = NULL;
  branch_ctor_t branch_ctor = NULL;
  floating_ctor_t floating_ctor = NULL;
  prim_ctor_t prim_ctor = NULL;
  _throw_ctor_t _throw_ctor = NULL;
  arch_exception_ctor_t arch_exception_ctor = NULL;
  shared_exception_ctor_t shared_exception_ctor = NULL;

 protected:
  std::vector<std::unique_ptr<statement>> _statements;

  std::unique_ptr<variable> _variable;
  std::unique_ptr<variable_limited> _variable_limited;
  std::unique_ptr<address> _address;
  std::unique_ptr<expr_cmp> _expr_cmp;

  std::unique_ptr<statement> _statement;
  std::unique_ptr<sexpr> _sexpr;
  std::unique_ptr<linear> _linear;
  std::unique_ptr<id> _id;
  std::unique_ptr<expr> _expr;
  std::unique_ptr<gdsl::rreil::exception> _exception;

 public:
  ~copy_visitor();
  copy_visitor();

  std::unique_ptr<variable> retrieve_variable() { return std::move(_variable); }

  std::unique_ptr<variable_limited> retrieve_variable_limited() {
    return std::move(_variable_limited);
  }

  std::unique_ptr<address> retrieve_address() { return std::move(_address); }

  std::unique_ptr<expr_cmp> retrieve_expr_cmp() { return std::move(_expr_cmp); }

  std::unique_ptr<statement> retrieve_statement() {
    return std::move(_statement);
  }

  std::vector<std::unique_ptr<statement>> retrieve_statements() {
    return std::move(_statements);
  }

  std::unique_ptr<sexpr> retrieve_sexpr() { return std::move(_sexpr); }

  std::unique_ptr<linear> retrieve_linear() { return std::move(_linear); }

  std::unique_ptr<id> retrieve_id() { return std::move(_id); }

  std::unique_ptr<expr> retrieve_expr() { return std::move(_expr); }

  std::unique_ptr<::gdsl::rreil::exception> retrieve_exception() {
    return std::move(_exception);
  }

  virtual void visit(variable const* v);
  virtual void visit(variable_limited const* v);
  virtual void visit(address const* v);
  virtual void visit(expr_cmp const* v);

  virtual void visit(assign const* a);
  virtual void visit(load const* a);
  virtual void visit(store const* a);
  virtual void visit(ite const* a);
  virtual void visit(_while const* a);
  virtual void visit(cbranch const* a);
  virtual void visit(branch const* a);
  virtual void visit(floating const* a);
  virtual void visit(prim const* a);
  virtual void visit(_throw const* a);

  virtual void visit(arbitrary const* a);
  virtual void visit(sexpr_cmp const* a);
  virtual void visit(sexpr_lin const* a);

  virtual void visit(lin_binop const* a);
  virtual void visit(lin_imm const* a);
  virtual void visit(lin_scale const* a);
  virtual void visit(lin_var const* a);

  virtual void visit(arch_id const* a);
  virtual void visit(shared_id const* a);
  virtual void visit(_virtual const* a);

  virtual void visit(expr_binop const* a);
  virtual void visit(expr_ext const* a);
  virtual void visit(expr_sexpr const* a);

  virtual void visit(arch_exception const* a);
  virtual void visit(shared_exception const* a);

  void _(variable_ctor_t c) { this->variable_ctor = c; }
  void _(variable_limited_ctor_t c) { this->variable_limited_ctor = c; }
  void _(address_ctor_t c) { this->address_ctor = c; }
  void _(expr_cmp_ctor_t c) { this->expr_cmp_ctor = c; }

  void _(expr_binop_ctor_t c) { this->expr_binop_ctor = c; }
  void _(expr_ext_ctor_t c) { this->expr_ext_ctor = c; }
  void _(expr_sexpr_ctor_t c) { this->expr_sexpr_ctor = c; }

  void _(arch_id_ctor_t c) { this->arch_id_ctor = c; }
  void _(shared_id_ctor_t c) { this->shared_id_ctor = c; }
  void _(_virtual_ctor_t c) { this->_virtual_ctor = c; }

  void _(lin_binop_ctor_t c) { this->lin_binop_ctor = c; }
  void _(lin_imm_ctor_t c) { this->lin_imm_ctor = c; }
  void _(lin_scale_ctor_t c) { this->lin_scale_ctor = c; }
  void _(lin_var_ctor_t c) { this->lin_var_ctor = c; }

  void _(arbitrary_ctor_t c) { this->arbitrary_ctor = c; }
  void _(sexpr_cmp_ctor_t c) { this->sexpr_cmp_ctor = c; }
  void _(sexpr_lin_ctor_t c) { this->sexpr_lin_ctor = c; }

  void _(assign_ctor_t c) { this->assign_ctor = c; }
  void _(load_ctor_t c) { this->load_ctor = c; }
  void _(store_ctor_t c) { this->store_ctor = c; }
  void _(ite_ctor_t c) { this->ite_ctor = c; }
  void _(_while_ctor_t c) { this->_while_ctor = c; }
  void _(cbranch_ctor_t c) { this->cbranch_ctor = c; }
  void _(branch_ctor_t c) { this->branch_ctor = c; }
  void _(floating_ctor_t c) { this->floating_ctor = c; }
  void _(prim_ctor_t c) { this->prim_ctor = c; }
  void _(_throw_ctor_t c) { this->_throw_ctor = c; }
  void _(arch_exception_ctor_t c) { this->arch_exception_ctor = c; }
  void _(shared_exception_ctor_t c) { this->shared_exception_ctor = c; }
};

}  // namespace rreil
}  // namespace gdsl
