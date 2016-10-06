#include "cppgdsl/rreil/linear/lin_scale.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void lin_scale::put(std::ostream& out) const {
  out << const_ << "*" << *operand_;
}

lin_scale::lin_scale(int_t const_arg, std::unique_ptr<linear> operand_arg)
    : const_(const_arg), operand_(move(operand_arg)) {}

std::unique_ptr<linear> lin_scale::copy() const {
  return std::unique_ptr<linear>(new lin_scale(*this));
}

void lin_scale::accept(linear_visitor& v) const { v.visit(this); }

bool lin_scale::operator==(linear const& o) const {
  bool is_equal = false;
  linear_visitor v;
  v._([&](lin_scale const* o) {
    is_equal = this->const_ == o->const_ && *this->operand_ == *o->operand_;
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
