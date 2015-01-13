/*
 * sexpr_cmp.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/sexpr/sexpr_cmp.h>
#include <iostream>

void gdsl::rreil::sexpr_cmp::put(std::ostream &out) {
  out << "[" << *inner << "]:" << size;
}

gdsl::rreil::sexpr_cmp::sexpr_cmp(int_t size, expr_cmp *inner) {
  this->size = size;
  this->inner = inner;
}

gdsl::rreil::sexpr_cmp::~sexpr_cmp() {
  delete this->inner;
}

void gdsl::rreil::sexpr_cmp::accept(sexpr_visitor &v) {
  v.visit(this);
}
