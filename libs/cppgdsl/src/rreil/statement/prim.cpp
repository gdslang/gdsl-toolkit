/*
 * prim.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/prim.h>

gdsl::rreil::prim::prim(std::string op, std::vector<variable_limited*> lhs, std::vector<variable_limited*> rhs) {
  this->op = op;
  this->lhs = lhs;
  this->rhs = rhs;
}

gdsl::rreil::prim::~prim() {
  for(variable_limited *v : this->lhs)
    delete v;
  for(variable_limited *v : this->rhs)
    delete v;
}

std::string gdsl::rreil::prim::to_string() {
  return "prim";
}
