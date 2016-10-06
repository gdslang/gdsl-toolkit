#include "cppgdsl/rreil/statement/load.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void load::put(std::ostream& out) const {
  out << *lhs << " =:" << size << " *" << *address_;
}

load::load(int_t size, std::unique_ptr<variable> lhs,
           std::unique_ptr<address> address_arg)
    : size(size), lhs(std::move(lhs)), address_(std::move(address_arg)) {}

void load::accept(statement_visitor& v) const { v.visit(this); }

std::unique_ptr<statement> load::copy() const {
  return std::unique_ptr<load>(new load(*this));
}

bool load::operator==(statement const& o) const {
  bool is_equal = false;
  statement_visitor v;
  v._([&](load const* o) {
    is_equal = this->size == o->size && *this->lhs == *o->lhs &&
               *this->address_ == *o->address_;
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
