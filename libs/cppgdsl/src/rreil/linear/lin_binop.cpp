#include "cppgdsl/rreil/linear/lin_binop.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void lin_binop::put(std::ostream& out) const {
  out << "(" << *lhs << " " << bin_lin_op_to_string(op) << " " << *rhs << ")";
}

lin_binop::lin_binop(binop_lin_op op, std::unique_ptr<linear> lhs,
                     std::unique_ptr<linear> rhs)
    : op(op), lhs(move(lhs)), rhs(move(rhs)) {}

lin_binop::~lin_binop() {}

std::unique_ptr<linear> lin_binop::copy() const {
  return std::unique_ptr<linear>(new lin_binop(*this));
}

void lin_binop::accept(linear_visitor& v) const { v.visit(this); }

bool lin_binop::operator==(linear const& o) const {
  bool is_equal = false;
  linear_visitor v;
  v._([&](lin_binop const* o) {
    is_equal = *this->lhs == *o->lhs && *this->rhs == *o->rhs;
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
