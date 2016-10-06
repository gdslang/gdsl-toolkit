#include "cppgdsl/rreil/sexpr/arbitrary.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void arbitrary::put(std::ostream& out) const { out << "arbitrary"; }

std::unique_ptr<sexpr> arbitrary::copy() const {
  return std::unique_ptr<sexpr>(new arbitrary(*this));
}

void arbitrary::accept(sexpr_visitor& v) const { v.visit(this); }

bool arbitrary::operator==(sexpr const& o) const {
  bool is_equal = false;
  sexpr_visitor v;
  v._([&](arbitrary const* o) { is_equal = true; });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
