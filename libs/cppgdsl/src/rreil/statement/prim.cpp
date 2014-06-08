/*
 * prim.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/prim.h>
#include <iostream>

using namespace std;

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

void gdsl::rreil::prim::accept(statement_visitor &v) {
  v.visit(this);
}

void gdsl::rreil::prim::put(std::ostream &out) {
  out << "(";
  for (size_t i = 0; i < lhs.size(); ++i) {
    if(i)
      out << ", ";
    out << *lhs[i];
  }
  out << ") = " << op << "(";
  for (size_t i = 0; i < rhs.size(); ++i) {
    if(i)
      out << ", ";
    out << *rhs[i];
  }
  out << ")";
}
