
/*
 * sexpr_lin.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/sexpr/sexpr_lin.h>

using namespace gdsl::rreil;

void gdsl::rreil::sexpr_lin::put(std::ostream &out) {
  out << *inner;
}

gdsl::rreil::sexpr_lin::sexpr_lin(linear *inner) {
  this->inner = inner;
}

gdsl::rreil::sexpr_lin::~sexpr_lin() {
  delete this->inner;
}

void gdsl::rreil::sexpr_lin::accept(sexpr_visitor &v) {
  v.visit(this);
}
