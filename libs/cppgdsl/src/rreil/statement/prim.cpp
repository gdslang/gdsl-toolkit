#include "cppgdsl/rreil/statement/prim.h"

#include <iostream>

#include "cppgdsl/compare.h"

namespace gdsl {
namespace rreil {

prim::prim(std::string op, variables_limited_t lhs, variables_limited_t rhs)
    : op(op), lhs(move(lhs)), rhs(move(rhs)) {}

prim::prim(const prim& p)
    : statement(p),
      op(p.op),
      lhs(rreil::copy(p.lhs)),
      rhs(rreil::copy(p.rhs)) {}

void prim::put(std::ostream& out) const {
  out << "(";
  for (size_t i = 0; i < lhs.size(); ++i) {
    if (i) out << ", ";
    out << *lhs[i];
  }
  out << ") = " << op << "(";
  for (size_t i = 0; i < rhs.size(); ++i) {
    if (i) out << ", ";
    out << *rhs[i];
  }
  out << ")";
}

std::unique_ptr<statement> prim::copy() const {
  return std::unique_ptr<statement>(new prim(*this));
}

void prim::accept(statement_visitor& v) const { v.visit(this); }

bool prim::operator==(statement const& o) const {
  bool is_equal = false;
  statement_visitor v;
  v._([&](prim const* o) {
    is_equal = this->op == o->op && equals(this->lhs, o->lhs) &&
               equals(this->rhs, o->rhs);
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
