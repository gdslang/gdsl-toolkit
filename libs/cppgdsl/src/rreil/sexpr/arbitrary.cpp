/*
 * arbitrary.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/sexpr/arbitrary.h>

std::string gdsl::rreil::arbitrary::to_string() {
  return "arbitrary";
}

void gdsl::rreil::arbitrary::accept(sexpr_visitor &v) {
  v.visit(this);
}
