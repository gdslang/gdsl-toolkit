/*
 * expr_sexpr.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/expr/expr_sexpr.h>

void gdsl::rreil::expr_sexpr::put(std::ostream &out) {
  out << inner;
}

gdsl::rreil::expr_sexpr::expr_sexpr(sexpr *inner) {
  this->inner = inner;
}

gdsl::rreil::expr_sexpr::~expr_sexpr() {
  delete this->inner;
}

void gdsl::rreil::expr_sexpr::accept(expr_visitor &v) {
  v.visit(this);
}
