/*
 * sexpr_cmp.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/sexpr/sexpr_cmp.h>

void gdsl::rreil::sexpr_cmp::put(std::ostream &out) {
  out << *inner;
}

gdsl::rreil::sexpr_cmp::sexpr_cmp(expr_cmp *inner) {
  this->inner = inner;
}

gdsl::rreil::sexpr_cmp::~sexpr_cmp() {
  delete this->inner;
}

void gdsl::rreil::sexpr_cmp::accept(sexpr_visitor &v) {
  v.visit(this);
}
