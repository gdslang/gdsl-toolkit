/*
 * ite.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/ite.h>
#include <iostream>

using namespace std;

gdsl::rreil::ite::ite(sexpr *cond, statement *then_branch, statement *else_branch) {
  this->cond = cond;
  this->then_branch = then_branch;
  this->else_branch = else_branch;
}

gdsl::rreil::ite::~ite() {
  delete this->cond;
  delete this->then_branch;
  delete this->else_branch;
}

void gdsl::rreil::ite::accept(statement_visitor &v) {
  v.visit(this);
}

void gdsl::rreil::ite::put(std::ostream &out) {
  out << "if(" << *cond << ") {\n";
  out << *then_branch << "\n}{\n";
  out << *else_branch;
  out << "\n}";
}
