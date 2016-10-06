#include "cppgdsl/rreil/statement/branch.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void branch::put(std::ostream& out) const {
  out << branch_hint_to_string(hint) << " => " << *target;
}

branch::branch(std::unique_ptr<address> target, branch_hint hint)
    : target(move(target)), hint(hint) {}

void branch::accept(statement_visitor& v) const { v.visit(this); }

std::unique_ptr<statement> branch::copy() const {
  return std::unique_ptr<statement>(new branch(*this));
}

bool branch::operator==(statement const& o) const {
  bool is_equal = false;
  statement_visitor v;
  v._([&](branch const* o) {
    is_equal = this->hint == o->hint && *this->target == *o->target;
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
