/*
 * cbranch.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/cbranch.h>
#include <iostream>

gdsl::rreil::cbranch::cbranch(sexpr *cond, address *target_true, address *target_false) {
  this->cond = cond;
  this->target_true = target_true;
  this->target_false = target_false;
}

gdsl::rreil::cbranch::~cbranch() {
  delete this->cond;
  delete this->target_true;
  delete this->target_false;
}

void gdsl::rreil::cbranch::accept(statement_visitor &v) {
  v.visit(this);
}

void gdsl::rreil::cbranch::put(std::ostream &out) {
  out << *cond << " ? goto " << *target_true << " : goto " << *target_false;
}
