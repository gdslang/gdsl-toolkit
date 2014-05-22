/*
 * ite.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/ite.h>

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

std::string gdsl::rreil::ite::to_string() {
  return "ite";
}
