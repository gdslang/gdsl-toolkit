/*
 * _virtual.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/id/virtual.h>
#include <iostream>

using namespace gdsl::rreil;

void gdsl::rreil::_virtual::put(std::ostream &out) {
  out << (opt ? "o" : "t") << t;
}

size_t gdsl::rreil::_virtual::subclass_counter = id::subclass_counter++;

_virtual::_virtual(int_t t, bool opt) {
  this->t = t;
  this->opt = opt;
}

size_t gdsl::rreil::_virtual::get_subclass_counter() const {
  return subclass_counter;
}

int_t _virtual::get_t() {
  return this->t;
}

bool _virtual::get_opt() {
  return this->opt;
}

bool gdsl::rreil::_virtual::operator==(id &other) const {
  bool equals = false;
  id_visitor iv;
  iv._((std::function<void(_virtual *)>)[&](_virtual * aid) { equals = this->t == aid->t; });
  other.accept(iv);
  return equals;
}

bool gdsl::rreil::_virtual::operator<(const id &other) const {
  size_t scc_me = subclass_counter;
  size_t scc_other = other.get_subclass_counter();
  if(scc_me == scc_other) {
    _virtual const &other_casted = dynamic_cast<_virtual const &>(other);
    if(opt && !other_casted.opt)
      return true;
    else if(!opt && other_casted.opt)
      return false;
    else return t < other_casted.t;
  } else
    return scc_me < scc_other;
}

void gdsl::rreil::_virtual::accept(id_visitor &v) {
  v.visit(this);
}
