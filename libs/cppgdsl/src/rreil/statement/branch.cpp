/*
 * branch.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/branch.h>

gdsl::rreil::branch::branch(address *target, branch_hint hint) {
  this->target = target;
  this->hint = hint;
}

gdsl::rreil::branch::~branch() {
  delete target;
}

std::string gdsl::rreil::branch::to_string() {
  return branch_hint_to_string(hint) + " => " + target->to_string();
}
