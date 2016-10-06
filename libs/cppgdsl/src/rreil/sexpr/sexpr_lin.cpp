#include "cppgdsl/rreil/sexpr/sexpr_lin.h"

namespace gdsl {
namespace rreil {

void sexpr_lin::put(std::ostream& out) const { out << *inner; }

sexpr_lin::sexpr_lin(std::unique_ptr<linear> inner) : inner(move(inner)) {}

std::unique_ptr<sexpr> sexpr_lin::copy() const {
  return std::unique_ptr<sexpr>(new sexpr_lin(*this));
}

void sexpr_lin::accept(sexpr_visitor& v) const { v.visit(this); }

bool sexpr_lin::operator==(sexpr const& o) const {
  bool is_equal = false;
  sexpr_visitor v;
  v._([&](sexpr_lin const* o) { is_equal = *this->inner == *o->inner; });
  o.accept(v);
  return is_equal;
}

std::unique_ptr<sexpr> make_sexpr(int_t const_arg) {
  return make_sexpr(make_linear(const_arg));
}

std::unique_ptr<sexpr> make_sexpr(std::unique_ptr<id> id_arg, int_t offset) {
  return make_sexpr(make_linear(make_variable(std::move(id_arg), offset)));
}

}  // namespace rreil
}  // namespace gdsl
