/*
 * assign.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/assign.h>
#include <iostream>

gdsl::rreil::assign::assign(int_t size, variable *lhs, expr *rhs) {
  this->size = size;
  this->lhs = lhs;
  this->rhs = rhs;
}

gdsl::rreil::assign::~assign() {
  delete this->lhs;
  delete this->rhs;
}

void gdsl::rreil::assign::accept(statement_visitor &v) {
  v.visit(this);
}

void gdsl::rreil::assign::put(std::ostream &out) const {
  out << *lhs << " =:" << size << " " << *rhs;
}
