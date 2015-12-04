/*
 * while.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/while.h>
#include <string>
#include <iostream>

gdsl::rreil::_while::_while(sexpr *cond, std::vector<statement*> *body) {
  this->cond = cond;
  this->body = body;
}

gdsl::rreil::_while::~_while() {
  delete this->cond;
  for(auto stmt : *body)
    delete stmt;
  delete this->body;
}

void gdsl::rreil::_while::accept(statement_visitor &v) {
  v.visit(this);
}

void gdsl::rreil::_while::put(std::ostream &out) const {
  out << "while(" << *cond << ") {\n";
  for(auto stmt: *body)
    out << *stmt << std::endl;
  out << "\n}";
}
