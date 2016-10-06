#include "cppgdsl/rreil/exception/arch_exception.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void gdsl::rreil::arch_exception::put(std::ostream& out) const {
  out << "[architecture specific exception:";
  out << name;
  out << "]";
}

arch_exception::arch_exception(std::string name) : name(std::move(name)) {}

void arch_exception::accept(exception_visitor& v) const {
  return v.visit(this);
}

std::unique_ptr<exception> arch_exception::copy() const {
  return std::unique_ptr<exception>(new arch_exception(*this));
}

bool arch_exception::operator==(exception const& o) const {
  bool is_equal = false;
  exception_visitor v;
  v._([&](arch_exception const* e) { is_equal = this->name == e->name; });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
