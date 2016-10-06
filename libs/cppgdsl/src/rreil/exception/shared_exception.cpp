#include "cppgdsl/rreil/exception/shared_exception.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void shared_exception::put(std::ostream& out) const {
  out << "[architecture specific exception: ";
  out << shared_exception_type_to_string(type);
  out << "]";
}

std::string shared_exception_type_to_string(shared_exception_type t) {
  switch (t) {
    case TYPE_DIVISION_BY_ZERO:
      return "Division By Zero";
  }
}

shared_exception::shared_exception(shared_exception_type type) : type(type) {}

void shared_exception::accept(exception_visitor& v) const { v.visit(this); }

std::unique_ptr<exception> shared_exception::copy() const {
  return std::unique_ptr<exception>(new shared_exception(*this));
}

bool shared_exception::operator==(exception const& o) const {
  bool is_equal = false;
  exception_visitor v;
  v._([&](shared_exception const* e) { is_equal = this->type == e->type; });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
