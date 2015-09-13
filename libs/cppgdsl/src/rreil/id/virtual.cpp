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
  out << "t" << t;
}

size_t gdsl::rreil::_virtual::subclass_counter = id::subclass_counter++;

_virtual::_virtual(int_t t) {
  this->t = t;
}

size_t gdsl::rreil::_virtual::get_subclass_counter() {
  return subclass_counter;
}

int_t _virtual::get_t() {
  return this->t;
}

bool gdsl::rreil::_virtual::operator ==(id &other) const {
  bool equals = false;
  id_visitor iv;
  iv._((std::function<void(_virtual*)>)[&](_virtual *aid) {
    equals = this->t == aid->t;
  });
  other.accept(iv);
  return equals;
}

void gdsl::rreil::_virtual::accept(id_visitor &v) {
  v.visit(this);
}
