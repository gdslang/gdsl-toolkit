/*
 * ite.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/ite.h>
#include <iostream>

gdsl::rreil::ite::ite(sexpr *cond, std::vector<statement*> *then_branch, std::vector<statement*> *else_branch) {
  this->cond = cond;
  this->then_branch = then_branch;
  this->else_branch = else_branch;
}

gdsl::rreil::ite::~ite() {
  delete this->cond;
  for(auto stmt : *then_branch)
    delete stmt;
  delete then_branch;
  for(auto stmt : *else_branch)
    delete stmt;
  delete else_branch;
}

void gdsl::rreil::ite::accept(statement_visitor &v) {
  v.visit(this);
}

void gdsl::rreil::ite::put(std::ostream &out) const {
  out << "if(" << *cond << ") {\n";
  for(auto stmt : *then_branch)
    out << *stmt << "\n";
  out << "}{\n";
  for(auto stmt : *else_branch)
    out << *stmt << "\n";
  out << "}";
}
