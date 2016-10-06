#include "cppgdsl/rreil/statement/throw.h"

#include <iostream>

#include "cppgdsl/compare.h"

namespace gdsl {
namespace rreil {

void _throw::put(std::ostream& out) const { out << "throw " << *inner; }

_throw::_throw(std::unique_ptr<rreil::exception> inner) : inner(move(inner)) {}

std::unique_ptr<statement> _throw::copy() const {
  return std::unique_ptr<statement>(new _throw(*this));
}

void _throw::accept(statement_visitor& v) const { v.visit(this); }

bool _throw::operator==(statement const& o) const {
  bool is_equal = false;
  statement_visitor v;
  v._([&](_throw const* o) { is_equal = *this->inner == *o->inner; });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
