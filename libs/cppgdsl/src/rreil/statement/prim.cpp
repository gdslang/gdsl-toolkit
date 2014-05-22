/*
 * prim.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/prim.h>

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

std::string gdsl::rreil::prim::to_string() {
  string r = "(";
  for (size_t i = 0; i < lhs.size(); ++i) {
    if(i)
      r += ", ";
    r += lhs[i]->to_string();
  }
  r += ") = " + op + "(";
  for (size_t i = 0; i < rhs.size(); ++i) {
    if(i)
      r += ", ";
    r += rhs[i]->to_string();
  }
  r += ")";
  return r;
}
