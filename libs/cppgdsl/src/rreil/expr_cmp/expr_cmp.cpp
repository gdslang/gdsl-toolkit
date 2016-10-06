#include "cppgdsl/rreil/expr_cmp/expr_cmp.h"

#include <iosfwd>
#include <iostream>
#include <sstream>

#include "cppgdsl/rreil/expr_cmp/cmp_op.h"
#include "cppgdsl/rreil/linear/linear.h"

namespace gdsl {
namespace rreil {

void expr_cmp::put(std::ostream& out) const {
  out << *lhs << " " << cmp_op_to_string(op) << " " << *rhs;
}

expr_cmp::expr_cmp(cmp_op op, std::unique_ptr<linear> lhs,
                   std::unique_ptr<linear> rhs)
    : op(op), lhs(move(lhs)), rhs(move(rhs)) {}

std::string expr_cmp::to_string() const {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream& operator<<(std::ostream& out, expr_cmp const& _this) {
  _this.put(out);
  return out;
}

std::unique_ptr<expr_cmp> expr_cmp::copy() const {
  return std::unique_ptr<expr_cmp>(new expr_cmp(*this));
}

void expr_cmp::accept(visitor& v) const { v.visit(this); }

bool expr_cmp::operator==(const expr_cmp& o) const {
  return this->op == o.op && *this->lhs == *o.lhs && *this->rhs == *o.rhs;
}

}  // namespace rreil
}  // namespace gdsl
