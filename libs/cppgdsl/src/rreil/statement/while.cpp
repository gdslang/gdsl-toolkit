/*
 * while.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/while.h>
#include <string>

using namespace std;

gdsl::rreil::_while::_while(sexpr *cond, statement *body) {
  this->cond = cond;
  this->body = body;
}

gdsl::rreil::_while::~_while() {
  delete this->cond;
  delete this->body;
}

std::string gdsl::rreil::_while::to_string() {
  string r = "while(" + cond->to_string() + ") {\n";
  r += body->to_string();
  r += "\n}";
  return r;
}

void gdsl::rreil::_while::accept(statement_visitor &v) {
  v.visit(this);
}

void gdsl::rreil::_while::put(ostream &out) {
  out << to_string();
}
