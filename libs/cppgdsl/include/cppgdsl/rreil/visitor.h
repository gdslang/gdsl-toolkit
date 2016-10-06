/*
 * The file contains an implementation of the Visitor Pattern for
 * the whole RReil AST. Here, the AST is traversed from left to right;
 * whenever a node is discovered, the respective visit() function
 * is called.
 */

#pragma once
#include "cppgdsl/rreil/exception/exception_visitor.h"
#include "cppgdsl/rreil/expr/expr_visitor.h"
#include "cppgdsl/rreil/id/id_visitor.h"
#include "cppgdsl/rreil/linear/linear_visitor.h"
#include "cppgdsl/rreil/sexpr/sexpr_visitor.h"
#include "cppgdsl/rreil/statement/statement_visitor.h"

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
  std::function<void(variable const*)> variable_callback = nullptr;
  std::function<void(variable_limited const*)> variable_limited_callback =
      nullptr;
  std::function<void(address const*)> address_callback = nullptr;
  std::function<void(expr_cmp const*)> expr_cmp_callback = nullptr;

 public:
  virtual ~visitor() = default;

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

  virtual void _default() {}

  void _(std::function<void(variable const*)> c) {
    variable_callback = std::move(c);
  }
  void _(std::function<void(variable_limited const*)> c) {
    variable_limited_callback = std::move(c);
  }
  void _(std::function<void(address const*)> c) {
    address_callback = std::move(c);
  }
  void _(std::function<void(expr_cmp const*)> c) {
    expr_cmp_callback = std::move(c);
  }

  using statement_visitor::_;
  using sexpr_visitor::_;
  using linear_visitor::_;
  using id_visitor::_;
  using expr_visitor::_;
  using exception_visitor::_;
};

}  // namespace rreil
}  // namespace gdsl
