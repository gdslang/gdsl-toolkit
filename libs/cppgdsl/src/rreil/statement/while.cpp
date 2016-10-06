#include "cppgdsl/rreil/statement/while.h"

#include <iostream>
#include <string>

#include "cppgdsl/compare.h"

namespace gdsl {
namespace rreil {

void _while::put(std::ostream& out) const {
  out << "while(" << *cond << ") {\n";
  for (auto const& stmt : body) out << *stmt << std::endl;
  out << "\n}";
}

gdsl::rreil::_while::_while(std::unique_ptr<sexpr> cond, statements_t body)
    : cond(std::move(cond)), body(std::move(body)) {}

_while::_while(const _while& w)
    : statement(w), cond(w.cond->copy()), body(rreil::copy(w.body)) {}

std::unique_ptr<statement> _while::copy() const {
  return std::unique_ptr<statement>(new _while(*this));
}

void _while::accept(statement_visitor& v) const { v.visit(this); }

bool _while::operator==(statement const& o) const {
  bool is_equal = false;
  statement_visitor v;
  v._([&](_while const* o) {
    is_equal = *this->cond == *o->cond && equals(this->body, o->body);
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
