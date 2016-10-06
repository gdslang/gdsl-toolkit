#include "cppgdsl/rreil/linear/lin_imm.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void lin_imm::put(std::ostream& out) const { out << const_; }

lin_imm::lin_imm(int_t const_arg) { this->const_ = const_arg; }

std::unique_ptr<linear> lin_imm::copy() const {
  return std::unique_ptr<linear>(new lin_imm(*this));
}

void lin_imm::accept(linear_visitor& v) const { v.visit(this); }

bool lin_imm::operator==(linear const& o) const {
  bool is_equal = false;
  linear_visitor v;
  v._([&](lin_imm const* o) { is_equal = this->const_ == o->const_; });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
