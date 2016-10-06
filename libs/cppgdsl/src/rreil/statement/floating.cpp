/*
 * floating.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include "cppgdsl/rreil/statement/floating.h"
#include "cppgdsl/compare.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void floating::put(std::ostream& out) const {
  out << *lhs << " = (" << flop_to_string(op) << ")(";
  for (size_t i = 0; i < rhs.size(); ++i) {
    if (i) out << ", ";
    out << *rhs[i];
  }
  out << ")";
}

floating::floating(flop op, std::unique_ptr<variable> flags,
                   std::unique_ptr<variable_limited> lhs,
                   variables_limited_t rhs)
    : op(op), flags(move(flags)), lhs(move(lhs)), rhs(move(rhs)) {}

floating::floating(const floating& f)
    : statement(f),
      op(f.op),
      flags(f.flags->copy()),
      lhs(std::unique_ptr<variable_limited>(new variable_limited(*f.lhs))),
      rhs(gdsl::rreil::copy(f.rhs)) {}

void floating::accept(statement_visitor& v) const { v.visit(this); }

std::unique_ptr<statement> gdsl::rreil::floating::copy() const {
  return std::unique_ptr<statement>(new floating(*this));
}

bool floating::operator==(statement const& o) const {
  bool is_equal = false;
  statement_visitor v;
  v._([&](floating const* o) {
    is_equal = this->op == o->op && *this->flags == *o->flags &&
               *this->lhs == *o->lhs && equals(this->rhs, o->rhs);
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
