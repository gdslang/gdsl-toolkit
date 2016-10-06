#include "cppgdsl/rreil/variable_limited.h"

#include <iostream>

#include "cppgdsl/rreil/visitor.h"

namespace gdsl {
namespace rreil {

void variable_limited::put(std::ostream& out) const {
  variable::put(out);
  out << "/" << size;
}

variable_limited::variable_limited(std::unique_ptr<id> _id, int_t offset,
                                   int_t size)
    : variable(move(_id), offset), size(size) {}

std::unique_ptr<variable> variable_limited::copy() const {
  return std::unique_ptr<variable_limited>(new variable_limited(*this));
}

void variable_limited::accept(visitor& v) const { v.visit(this); }

variables_limited_t copy(variables_limited_t const& vars_limited) {
  variables_limited_t copied;
  copied.reserve(vars_limited.size());
  for (auto const& v : vars_limited)
    copied.emplace_back(
        std::unique_ptr<variable_limited>(new variable_limited(*v)));
  return copied;
}

bool variable_limited::operator==(const variable& o) const {
  bool equals = false;
  visitor v;
  v._([&](variable_limited const* b) { equals = this->size == b->size; });
  o.accept(v);
  // We're using implementation inheritance here, thus we need to call
  // the base class equality operator.
  return equals && variable::operator==(o);
}

}  // namespace rreil
}  // namespace gdsl
