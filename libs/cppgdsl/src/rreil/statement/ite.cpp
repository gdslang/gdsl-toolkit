#include "cppgdsl/rreil/statement/ite.h"
#include "cppgdsl/compare.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void ite::put(std::ostream& out) const {
  out << "if(" << *cond << ") {\n";
  for (auto const& stmt : then_branch) {
    out << *stmt << "\n";
  }
  out << "}{\n";
  for (auto const& stmt : else_branch) {
    out << *stmt << "\n";
  }
  out << "}";
}

ite::ite(std::unique_ptr<sexpr> cond, statements_t then_branch,
         statements_t else_branch)
    : cond(move(cond)),
      then_branch(std::move(then_branch)),
      else_branch(std::move(else_branch)) {}

ite::ite(const ite& i)
    : statement(i),
      cond(i.cond->copy()),
      then_branch(gdsl::rreil::copy(i.then_branch)),
      else_branch(gdsl::rreil::copy(i.else_branch)) {}

std::unique_ptr<statement> ite::copy() const {
  return std::unique_ptr<statement>(new ite(*this));
}

void ite::accept(statement_visitor& v) const { v.visit(this); }

bool ite::operator==(statement const& o) const {
  bool is_equal = false;
  statement_visitor v;
  v._([&](ite const* o) {
    is_equal = *this->cond == *o->cond &&
               equals(this->then_branch, o->then_branch) &&
               equals(this->else_branch, o->else_branch);
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
