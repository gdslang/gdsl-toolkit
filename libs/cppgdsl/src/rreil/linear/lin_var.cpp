#include "cppgdsl/rreil/linear/lin_var.h"

namespace gdsl {
namespace rreil {

void lin_var::put(std::ostream& out) const { out << *var; }

lin_var::lin_var(std::unique_ptr<variable> var) : var(move(var)) {}

std::unique_ptr<linear> lin_var::copy() const {
  return std::unique_ptr<linear>(new lin_var(*this));
}

void lin_var::accept(linear_visitor& v) const { v.visit(this); }

bool gdsl::rreil::lin_var::operator==(linear const& o) const {
  bool is_equal = false;
  linear_visitor v;
  v._([&](lin_var const* o) { is_equal = *this->var == *o->var; });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
