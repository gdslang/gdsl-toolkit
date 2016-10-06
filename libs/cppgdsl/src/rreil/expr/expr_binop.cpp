#include "cppgdsl/rreil/expr/expr_binop.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void gdsl::rreil::expr_binop::put(std::ostream& out) const {
  out << *lhs << " " << binop_op_to_string(op) << " " << *rhs;
}

expr_binop::expr_binop(binop_op op, std::unique_ptr<linear> lhs,
                       std::unique_ptr<linear> rhs)
    : op(op), lhs(std::move(lhs)), rhs(std::move(rhs)) {}

void gdsl::rreil::expr_binop::accept(expr_visitor& v) const { v.visit(this); }

std::unique_ptr<expr> expr_binop::copy() const {
  return std::unique_ptr<expr>(new expr_binop(*this));
}

bool expr_binop::operator==(expr const& o) const {
  bool is_equal = false;
  expr_visitor v;
  v._([&](expr_binop const* o) {
    is_equal =
        this->op == o->op && *this->lhs == *o->lhs && *this->rhs == *o->rhs;
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
