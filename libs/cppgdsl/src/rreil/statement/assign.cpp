#include "cppgdsl/rreil/statement/assign.h"
#include "cppgdsl/rreil/expr/expr_sexpr.h"
#include "cppgdsl/rreil/variable.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void assign::put(std::ostream& out) const {
  out << *lhs << " =:" << size << " " << *rhs;
}

assign::assign(int_t size, std::unique_ptr<variable> lhs,
               std::unique_ptr<expr> rhs)
    : size(size), lhs(move(lhs)), rhs(move(rhs)) {}

std::unique_ptr<statement> assign::copy() const {
  return std::unique_ptr<statement>(new assign(*this));
}

void assign::accept(statement_visitor& v) const { v.visit(this); }

bool assign::operator==(statement const& o) const {
  bool is_equal = false;
  statement_visitor v;
  v._([&](assign const* o) {
    is_equal =
        this->size == o->size && *this->lhs == *o->lhs && *this->rhs == *o->rhs;
  });
  o.accept(v);
  return is_equal;
}

std::unique_ptr<statement> make_assign(int_t size, std::unique_ptr<id> lhs,
                                       std::unique_ptr<expr> rhs) {
  return make_assign(size, make_variable(std::move(lhs)), std::move(rhs));
}

std::unique_ptr<statement> make_assign(int_t size, std::unique_ptr<id> lhs,
                                       std::unique_ptr<id> id_arg) {
  return make_assign(size, make_variable(std::move(lhs)),
                     make_expr(std::move(id_arg)));
}

std::unique_ptr<statement> make_assign(int_t size, std::unique_ptr<id> lhs,
                                       int_t const_arg) {
  return make_assign(size, make_variable(std::move(lhs)), make_expr(const_arg));
}

}  // namespace rreil
}  // namespace gdsl
