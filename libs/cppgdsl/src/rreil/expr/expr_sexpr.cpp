#include "cppgdsl/rreil/expr/expr_sexpr.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void expr_sexpr::put(std::ostream& out) const { out << *inner; }

expr_sexpr::expr_sexpr(std::unique_ptr<sexpr> inner) : inner(move(inner)) {}

void expr_sexpr::accept(expr_visitor& v) const { v.visit(this); }

std::unique_ptr<expr> expr_sexpr::copy() const {
  return std::unique_ptr<expr>(new expr_sexpr(*this));
}

bool expr_sexpr::operator==(expr const& o) const {
  bool is_equal = false;
  expr_visitor v;
  v._([&](expr_sexpr const* o) { is_equal = *this->inner == *o->inner; });
  o.accept(v);
  return is_equal;
}

std::unique_ptr<expr> make_expr(std::unique_ptr<linear> inner) {
  return make_expr(make_sexpr(std::move(inner)));
}

std::unique_ptr<expr> make_expr(int_t const_arg) {
  return make_expr(make_linear(const_arg));
}

std::unique_ptr<expr> make_expr(std::unique_ptr<id> id_arg, int_t offset) {
  return make_expr(make_sexpr(std::move(id_arg), offset));
}

}  // namespace rreil
}  // namespace gdsl
