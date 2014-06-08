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

_virtual::_virtual(int_t t) {
  this->t = t;
}

int_t _virtual::get_t() {
  return this->t;
}

void gdsl::rreil::_virtual::accept(id_visitor &v) {
  v.visit(this);
}
