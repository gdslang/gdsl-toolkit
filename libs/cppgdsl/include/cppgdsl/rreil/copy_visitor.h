/*
 * copy_visitor.h
 *
 *  Created on: Sep 19, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <vector>

#include <cppgdsl/rreil/visitor.h>

#include <cppgdsl/rreil/id/shared_id.h>
#include <cppgdsl/rreil/expr/binop_op.h>
#include <cppgdsl/rreil/expr/expr_ext.h>
#include <cppgdsl/rreil/expr_cmp/cmp_op.h>
#include <cppgdsl/rreil/linear/binop_lin_op.h>
#include <cppgdsl/rreil/branch_hint.h>
#include <cppgdsl/rreil/flop.h>
#include <cppgdsl/rreil/exception/shared_exception.h>

extern "C" {
#include <gdsl_generic.h>
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

class copy_visitor: public visitor {
private:
  std::function<variable*(id*, int_t)> variable_ctor = NULL;
  std::function<variable_limited*(id*, int_t, int_t)> variable_limited_ctor = NULL;
  std::function<address*(int_t, linear*)> address_ctor = NULL;
  std::function<expr_cmp*(cmp_op, linear*, linear*)> expr_cmp_ctor = NULL;

  std::function<expr*(binop_op, linear*, linear*)> expr_binop_ctor = NULL;
  std::function<expr*(ext_op, int_t, linear*)> expr_ext_ctor = NULL;
  std::function<expr*(sexpr*)> expr_sexpr_ctor = NULL;

  std::function<id*(std::string)> arch_id_ctor = NULL;
  std::function<id*(shared_id_type)> shared_id_ctor = NULL;
  std::function<id*(int_t)> _virtual_ctor = NULL;

  std::function<linear*(binop_lin_op, linear*, linear*)> lin_binop_ctor = NULL;
  std::function<linear*(int_t)> lin_imm_ctor = NULL;
  std::function<linear*(int_t, linear*)> lin_scale_ctor = NULL;
  std::function<linear*(variable*)> lin_var_ctor = NULL;

  std::function<sexpr*()> arbitrary_ctor = NULL;
  std::function<sexpr*(expr_cmp*)> sexpr_cmp_ctor = NULL;
  std::function<sexpr*(linear*)> sexpr_lin_ctor = NULL;

  std::function<statement*(int_t, variable*, expr*)> assign_ctor = NULL;
  std::function<statement*(int_t, variable*, address*)> load_ctor = NULL;
  std::function<statement*(int_t, address*, linear*)> store_ctor = NULL;
  std::function<statement*(sexpr*, std::vector<statement*>*, std::vector<statement*>*)> ite_ctor = NULL;
  std::function<statement*(sexpr*, std::vector<statement*>*)> _while_ctor = NULL;
  std::function<statement*(sexpr*, address*, address*)> cbranch_ctor = NULL;
  std::function<statement*(address*, ::gdsl::rreil::branch_hint)> branch_ctor = NULL;
  std::function<statement*(::gdsl::rreil::flop, variable*, variable_limited*, std::vector<variable_limited*>)> floating_ctor =
  NULL;
  std::function<statement*(std::string, std::vector<variable_limited*>, std::vector<variable_limited*>)> prim_ctor =
  NULL;
  std::function<statement*(::gdsl::rreil::exception*)> _throw_ctor = NULL;

  std::function<::gdsl::rreil::exception*(std::string)> arch_exception_ctor = NULL;
  std::function<::gdsl::rreil::exception*(shared_exception_type)> shared_exception_ctor = NULL;

  union {
    variable *_variable;
    variable_limited *_variable_limited;
    address *_address;
    expr_cmp *_expr_cmp;

    statement *_statement;
    sexpr *_sexpr;
    linear *_linear;
    id *_id;
    expr *_expr;
    ::gdsl::rreil::exception *_exception;
  };

public:
  variable *get_variable() {
    return _variable;
  }

  variable_limited *get_variable_limited() {
    return _variable_limited;
  }

  address *get_address() {
    return _address;
  }

  expr_cmp *get_expr_cmp() {
    return _expr_cmp;
  }

  statement *get_statement() {
    return _statement;
  }

  sexpr *get_sexpr() {
    return _sexpr;
  }

  linear *get_linear() {
    return _linear;
  }

  id *get_id() {
    return _id;
  }

  expr *get_expr() {
    return _expr;
  }

  ::gdsl::rreil::exception *get_exception() {
    return _exception;
  }

  void visit(std::vector<statement*> *statements);

  virtual void visit(variable *v);
  virtual void visit(variable_limited *v);
  virtual void visit(address *v);
  virtual void visit(expr_cmp *v);

  virtual void visit(assign *a);
  virtual void visit(load *a);
  virtual void visit(store *a);
  virtual void visit(ite *a);
  virtual void visit(_while *a);
  virtual void visit(cbranch *a);
  virtual void visit(branch *a);
  virtual void visit(floating *a);
  virtual void visit(prim *a);
  virtual void visit(_throw *a);

  virtual void visit(arbitrary *a);
  virtual void visit(sexpr_cmp *a);
  virtual void visit(sexpr_lin *a);

  virtual void visit(lin_binop *a);
  virtual void visit(lin_imm *a);
  virtual void visit(lin_scale *a);
  virtual void visit(lin_var *a);

  virtual void visit(arch_id *a);
  virtual void visit(shared_id *a);
  virtual void visit(_virtual *a);

  virtual void visit(expr_binop *a);
  virtual void visit(expr_ext *a);
  virtual void visit(expr_sexpr *a);

  virtual void visit(arch_exception *a);
  virtual void visit(shared_exception *a);

  void _(std::function<variable*(id*, int_t)> c) {
    this->variable_ctor = c;
  }
  void _(std::function<variable_limited*(id*, int_t, int_t)> c) {
    this->variable_limited_ctor = c;
  }
  void _(std::function<address*(int_t, linear*)> c) {
    this->address_ctor = c;
  }
  void _(std::function<expr_cmp*(cmp_op, linear*, linear*)> c) {
    this->expr_cmp_ctor = c;
  }

  void _(std::function<expr*(binop_op, linear*, linear*)> c) {
    this->expr_binop_ctor = c;
  }
  void _(std::function<expr*(ext_op, int_t, linear*)> c) {
    this->expr_ext_ctor = c;
  }
  void _(std::function<expr*(sexpr*)> c) {
    this->expr_sexpr_ctor = c;
  }

  void _(std::function<id*(std::string)> c) {
    this->arch_id_ctor = c;
  }
  void _(std::function<id*(shared_id_type)> c) {
    this->shared_id_ctor = c;
  }
  void _(std::function<id*(int_t)> c) {
    this->_virtual_ctor = c;
  }

  void _(std::function<linear*(binop_lin_op, linear*, linear*)> c) {
    this->lin_binop_ctor = c;
  }
  void _(std::function<linear*(int_t)> c) {
    this->lin_imm_ctor = c;
  }
  void _(std::function<linear*(int_t, linear*)> c) {
    this->lin_scale_ctor = c;
  }
  void _(std::function<linear*(variable*)> c) {
    this->lin_var_ctor = c;
  }

  void _(std::function<sexpr*()> c) {
    this->arbitrary_ctor = c;
  }
  void _(std::function<sexpr*(expr_cmp*)> c) {
    this->sexpr_cmp_ctor = c;
  }
  void _(std::function<sexpr*(linear*)> c) {
    this->sexpr_lin_ctor = c;
  }

  void _(std::function<statement*(int_t, variable*, expr*)> c) {
    this->assign_ctor = c;
  }
  void _(std::function<statement*(int_t, variable*, address*)> c) {
    this->load_ctor = c;
  }
  void _(std::function<statement*(int_t, address*, linear*)> c) {
    this->store_ctor = c;
  }
  void _(std::function<statement*(sexpr*, std::vector<statement*>*, std::vector<statement*>*)> c) {
    this->ite_ctor = c;
  }
  void _(std::function<statement*(sexpr*, std::vector<statement*>*)> c) {
    this->_while_ctor = c;
  }
  void _(std::function<statement*(sexpr*, address*, address*)> c) {
    this->cbranch_ctor = c;
  }
  void _(std::function<statement*(address*, ::gdsl::rreil::branch_hint)> c) {
    this->branch_ctor = c;
  }
  void _(std::function<statement*(::gdsl::rreil::flop, variable*, variable_limited*, std::vector<variable_limited*>)> c) {
    this->floating_ctor = c;
  }
  void _(std::function<statement*(std::string, std::vector<variable_limited*>, std::vector<variable_limited*>)> c) {
    this->prim_ctor = c;
  }
  void _(std::function<statement*(exception*)> c) {
    this->_throw_ctor = c;
  }
  void _(std::function<::gdsl::rreil::exception*(std::string)> c) {
    this->arch_exception_ctor = c;
  }
  void _(std::function<::gdsl::rreil::exception*(shared_exception_type)> c) {
    this->shared_exception_ctor = c;
  }
};

}
}
