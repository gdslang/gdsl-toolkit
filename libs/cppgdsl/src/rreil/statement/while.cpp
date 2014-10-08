/*
 * while.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/while.h>
#include <string>
#include <iostream>

using namespace std;

gdsl::rreil::_while::_while(sexpr *cond, vector<statement*> *body) {
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

void gdsl::rreil::_while::put(ostream &out) {
  out << "while(" << *cond << ") {\n";
  for(auto stmt: *body)
    out << *stmt << endl;
  out << "\n}";
}
