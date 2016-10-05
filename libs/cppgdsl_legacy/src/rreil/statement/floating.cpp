/*
 * floating.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/floating.h>
#include <iostream>

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

void gdsl::rreil::floating::accept(statement_visitor &v) {
  v.visit(this);
}

void gdsl::rreil::floating::put(std::ostream &out) const {
  out << *lhs << " = (" << flop_to_string(op) << ")(";
  for (size_t i = 0; i < rhs.size(); ++i) {
    if(i)
      out << ", ";
    out << *rhs[i];
  }
  out << ")";
}
