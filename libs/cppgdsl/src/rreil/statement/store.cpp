#include "cppgdsl/rreil/statement/store.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void store::put(std::ostream& out) const {
  out << "*" << *address_ << " =:" << size << " " << *rhs;
}

store::store(int_t size, std::unique_ptr<address> address_arg,
             std::unique_ptr<linear> rhs)
    : size(size), address_(move(address_arg)), rhs(move(rhs)) {}

std::unique_ptr<statement> store::copy() const {
  return std::unique_ptr<statement>(new store(*this));
}

void store::accept(statement_visitor& v) const { v.visit(this); }

bool store::operator==(statement const& o) const {
  bool is_equal = false;
  statement_visitor v;
  v._([&](store const* o) {
    is_equal = this->size == o->size && *this->address_ == *o->address_ &&
               *this->rhs == *o->rhs;
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
