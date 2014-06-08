/*
 * branch.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/branch.h>
#include <iostream>

gdsl::rreil::branch::branch(address *target, branch_hint hint) {
  this->target = target;
  this->hint = hint;
}

gdsl::rreil::branch::~branch() {
  delete target;
}

void gdsl::rreil::branch::accept(statement_visitor &v) {
  v.visit(this);
}

void gdsl::rreil::branch::put(std::ostream &out) {
  out << branch_hint_to_string(hint) << " => " << *target;
}
