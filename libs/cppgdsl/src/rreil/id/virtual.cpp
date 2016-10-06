#include "cppgdsl/rreil/id/virtual.h"

#include <iostream>

namespace gdsl {
namespace rreil {

void _virtual::put(std::ostream& out) const { out << (opt ? "o" : "t") << t; }

size_t _virtual::subclass_counter = id::subclass_counter++;

_virtual::_virtual(int_t t, bool opt) {
  this->t = t;
  this->opt = opt;
}

size_t _virtual::get_subclass_counter() const { return subclass_counter; }

int_t _virtual::get_t() const { return this->t; }

bool _virtual::get_opt() const { return this->opt; }

bool _virtual::operator==(id const& other) const {
  bool equals = false;
  id_visitor iv;
  iv._((std::function<void(_virtual const*)>)([&](_virtual const* aid) {
    equals = this->t == aid->t;
  }));
  other.accept(iv);
  return equals;
}

bool _virtual::operator<(const id& other) const {
  size_t scc_me = subclass_counter;
  size_t scc_other = other.get_subclass_counter();
  if (scc_me == scc_other) {
    _virtual const& other_casted = dynamic_cast<_virtual const&>(other);
    if (opt && !other_casted.opt)
      return true;
    else if (!opt && other_casted.opt)
      return false;
    else
      return t < other_casted.t;
  } else
    return scc_me < scc_other;
}

std::unique_ptr<id> _virtual::copy() const {
  return std::unique_ptr<id>(new _virtual(*this));
}

void _virtual::accept(id_visitor& v) const { v.visit(this); }

}  // namespace rreil
}  // namespace gdsl
