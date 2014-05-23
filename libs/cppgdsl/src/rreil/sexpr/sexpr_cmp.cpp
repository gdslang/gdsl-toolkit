/*
 * sexpr_cmp.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/sexpr/sexpr_cmp.h>

gdsl::rreil::sexpr_cmp::sexpr_cmp(expr_cmp *inner) {
  this->inner = inner;
}

gdsl::rreil::sexpr_cmp::~sexpr_cmp() {
  delete this->inner;
}

std::string gdsl::rreil::sexpr_cmp::to_string() {
  return inner->to_string();
}

void gdsl::rreil::sexpr_cmp::accept(sexpr_visitor &v) {
  v.visit(this);
}
