#include "cppgdsl/rreil/sexpr/sexpr_cmp.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void sexpr_cmp::put(std::ostream& out) const {
  out << "[" << *inner << "]:" << size;
}

sexpr_cmp::sexpr_cmp(int_t size, std::unique_ptr<expr_cmp> inner)
    : size(size), inner(move(inner)) {}

std::unique_ptr<sexpr> sexpr_cmp::copy() const {
  return std::unique_ptr<sexpr>(new sexpr_cmp(*this));
}

void sexpr_cmp::accept(sexpr_visitor& v) const { v.visit(this); }

bool sexpr_cmp::operator==(sexpr const& o) const {
  bool is_equal = false;
  sexpr_visitor v;
  v._([&](sexpr_cmp const* o) {
    is_equal = this->size == o->size && *this->inner == *o->inner;
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
