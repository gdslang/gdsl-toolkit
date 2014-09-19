/*
 * copy_visitor.h
 *
 *  Created on: Sep 19, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <vector>

#include <cppgdsl/rreil/visitor.h>
//#include <cppgdsl/rreil/exception/exception_visitor.h>
//#include <cppgdsl/rreil/expr/expr_visitor.h>
//#include <cppgdsl/rreil/id/id_visitor.h>
//#include <cppgdsl/rreil/linear/linear_visitor.h>
//#include <cppgdsl/rreil/sexpr/sexpr_visitor.h>
//#include <cppgdsl/rreil/statement/statement_visitor.h>

#include <cppgdsl/rreil/id/shared_id.h>
#include <cppgdsl/rreil/expr/binop_op.h>
#include <cppgdsl/rreil/expr/expr_ext.h>
#include <cppgdsl/rreil/expr_cmp/cmp_op.h>
#include <cppgdsl/rreil/linear/binop_lin_op.h>

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
  std::function<statement*(address*, branch_hint)> branch_ctor = NULL;
  std::function<statement*(flop, variable, variable_limited, std::vector<variable_limited*>*)> floating_ctor = NULL;
  std::function<statement*(std::string, std::vector<variable_limited*>*, std::vector<variable_limited*>*)> prim_ctor =
      NULL;
  std::function<statement*(gdsl::rreil::exception*)> _throw_ctor = NULL;

  union {
    variable *_variable;
    variable_limited *_variable_limited;
    address *_address;
    expr_cmp *_expr_cmp;

    statement *_statement;
//    assign *_assign;
//    load *_load;
//    store *_store;
//    ite *_ite;
//    _while *__while;
//    cbranch *_cbranch;
//    branch *_branch;
//    floating *_floating;
//    prim *_prim;
//    _throw *__throw;

    arbitrary *_arbitrary;
    sexpr_cmp *_sexpr_cmp;
    sexpr_lin *_sexpr_lin;

    linear *_linear;
//    lin_binop *_lin_binop;
//    lin_imm *_lin_imm;
//    lin_scale *_lin_scale;
//    lin_var *_lin_var;

//    arch_id *_arch_id;
//    shared_id *_shared_id;
//    _virtual *__virtual;
    id *_id;

    expr *_expr;
//    expr_binop *_expr_binop;
//    expr_ext *_expr_ext;
//    expr_sexpr *_expr_sexpr;

    gdsl::rreil::exception *_exception;
//    arch_exception *_arch_exception;
//    shared_exception *_shared_exception;
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

//  assign *get_assign() {
//    return _assign;
//  }
//
//  load *get_load() {
//    return _load;
//  }
//
//  store *get_store() {
//    return _store;
//  }
//
//  ite *get_ite() {
//    return _ite;
//  }
//
//  _while *get_while() {
//    return __while;
//  }
//
//  cbranch *get_cbranch() {
//    return _cbranch;
//  }
//
//  branch *get_branch() {
//    return _branch;
//  }
//
//  floating *get_floating() {
//    return _floating;
//  }
//
//  prim *get_prim() {
//    return _prim;
//  }
//
//  _throw *get_throw() {
//    return __throw;
//  }

  arbitrary *get_arbitrary() {
    return _arbitrary;
  }

  sexpr_cmp *get_sexpr_cmp() {
    return _sexpr_cmp;
  }

  sexpr_lin *get_sexpr_lin() {
    return _sexpr_lin;
  }

  linear *get_linear() {
    return _linear;
  }

//  lin_binop *get_lin_binop() {
//    return _lin_binop;
//  }
//
//  lin_imm *get_lin_imm() {
//    return _lin_imm;
//  }
//
//  lin_scale *get_lin_scale() {
//    return _lin_scale;
//  }
//
//  lin_var *get_lin_var() {
//    return _lin_var;
//  }

//  arch_id *get_arch_id() {
//    return _arch_id;
//  }
//
//  shared_id *get_shared_id() {
//    return _shared_id;
//  }
//
//  _virtual *get_virtual() {
//    return __virtual;
//  }

  id *get_id() {
    return _id;
  }

  expr *get_expr() {
    return _expr;
  }

//  expr_binop *get_expr_binop() {
//    return _expr_binop;
//  }
//
//  expr_ext *get_expr_ext() {
//    return _expr_ext;
//  }
//
//  expr_sexpr *get_expr_sexpr() {
//    return _expr_sexpr;
//  }

  gdsl::rreil::exception *get_exception() {
    return _exception;
  }
//  arch_exception *get_arch_exception() {
//    return _arch_exception;
//  }
//
//  shared_exception *get_shared_exception() {
//    return _shared_exception;
//  }

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
  void _(std::function<statement*(address*, branch_hint)> c) {
    this->branch_ctor = c;
  }
  void _(std::function<statement*(flop, variable, variable_limited, std::vector<variable_limited*>*)> c) {
    this->floating_ctor = c;
  }
  void _(std::function<statement*(std::string, std::vector<variable_limited*>*, std::vector<variable_limited*>*)> c) {
    this->prim_ctor = c;
  }
  void _(std::function<statement*(exception*)> c) {
    this->_throw_ctor = c;
  }
};

}
}
