/*
 * floating.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/floating.h>

using namespace std;

gdsl::rreil::floating::floating(flop op, variable *flags, variable_limited *lhs, std::vector<variable_limited*> rhs) {
  this->op = op;
  this->flags = flags;
  this->lhs = lhs;
  this->rhs = rhs;
}

gdsl::rreil::floating::~floating() {
  delete this->flags;
  delete this->lhs;
  for(variable_limited *v : this->rhs)
    delete v;
}

std::string gdsl::rreil::floating::to_string() {
  string r = lhs->to_string() + " = (" + flop_to_string(op) + ")(";
  for (size_t i = 0; i < rhs.size(); ++i) {
    if(i)
      r += ", ";
    r += rhs[i]->to_string();
  }
  return r + ")";
}

void gdsl::rreil::floating::accept(statement_visitor &v) {
  v.visit(this);
}
