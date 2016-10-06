#include "cppgdsl/rreil/address.h"

#include <iostream>
#include <sstream>

namespace gdsl {
namespace rreil {

address::address(int_t size, std::unique_ptr<linear> lin)
    : size(size), lin(move(lin)) {}

std::string address::to_string() const {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream& operator<<(std::ostream& out, address const& _this) {
  out << "(" << *_this.lin << "/" << _this.size << ")";
  return out;
}

std::unique_ptr<address> address::copy() const {
  return std::unique_ptr<address>(new address(*this));
}

void address::accept(visitor& v) const { v.visit(this); }

}  // namespace rreil
}  // namespace gdsl
