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

class visitor : public virtual statement_visitor,
    public virtual sexpr_visitor,
    public virtual linear_visitor,
    public virtual id_visitor,
    public virtual expr_visitor,
    public virtual exception_visitor {
private:
  std::function<void(variable*)> variable_callback = nullptr;
  std::function<void(variable_limited*)> variable_limited_callback = nullptr;
  std::function<void(address*)> address_callback = nullptr;
  std::function<void(expr_cmp*)> expr_cmp_callback = nullptr;
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

  using statement_visitor::_;
  using sexpr_visitor::_;
  using linear_visitor::_;
  using id_visitor::_;
  using expr_visitor::_;
  using exception_visitor::_;
};

}
}
