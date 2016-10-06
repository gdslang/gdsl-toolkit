#include "cppgdsl/rreil/statement/cbranch.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void cbranch::put(std::ostream& out) const {
  out << *cond << " ? goto " << *target_true << " : goto " << *target_false;
}

cbranch::cbranch(std::unique_ptr<sexpr> cond,
                 std::unique_ptr<address> target_true,
                 std::unique_ptr<address> target_false)
    : cond(move(cond)),
      target_true(move(target_true)),
      target_false(move(target_false)) {}

void cbranch::accept(statement_visitor& v) const { v.visit(this); }

std::unique_ptr<statement> cbranch::copy() const {
  return std::unique_ptr<statement>(new cbranch(*this));
}

bool cbranch::operator==(statement const& o) const {
  bool is_equal = false;
  statement_visitor v;
  v._([&](cbranch const* o) {
    is_equal = *this->cond == *o->cond &&
               *this->target_true == *o->target_true &&
               *this->target_false == *o->target_false;
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
