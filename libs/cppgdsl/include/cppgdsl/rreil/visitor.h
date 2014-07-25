/*
 * visitor.h
 *
 *  Created on: Jun 2, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/exception/exception_visitor.h>
#include <cppgdsl/rreil/expr/expr_visitor.h>
#include <cppgdsl/rreil/id/id_visitor.h>
#include <cppgdsl/rreil/linear/linear_visitor.h>
#include <cppgdsl/rreil/sexpr/sexpr_visitor.h>
#include <cppgdsl/rreil/statement/statement_visitor.h>

namespace gdsl {
namespace rreil {

class variable;
class variable_limited;
class address;
class expr_cmp;

class visitor : public statement_visitor,
    public sexpr_visitor,
    public linear_visitor,
    public id_visitor,
    public expr_visitor,
    public exception_visitor {
private:
  std::function<void(variable*)> variable_callback = NULL;
  std::function<void(variable_limited*)> variable_limited_callback = NULL;
  std::function<void(address*)> address_callback = NULL;
  std::function<void(expr_cmp*)> expr_cmp_callback = NULL;
public:
  ~visitor() {
  }

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

  virtual void _default() {
  }

  void _(std::function<void(variable*)> c) {
    this->variable_callback = c;
  }
  void _(std::function<void(variable_limited*)> c) {
    this->variable_limited_callback = c;
  }
  void _(std::function<void(address*)> c) {
    this->address_callback = c;
  }
  void _(std::function<void(expr_cmp*)> c) {
    this->expr_cmp_callback = c;
  }
};

}
}
