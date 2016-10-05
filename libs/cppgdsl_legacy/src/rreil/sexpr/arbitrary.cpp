/*
 * arbitrary.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/sexpr/arbitrary.h>
#include <iostream>

void gdsl::rreil::arbitrary::put(std::ostream &out) {
  out << "arbitrary";
}

void gdsl::rreil::arbitrary::accept(sexpr_visitor &v) {
  v.visit(this);
}
