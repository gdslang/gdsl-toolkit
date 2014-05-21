/*
 * while.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/while.h>

gdsl::rreil::_while::_while(sexpr *cond, statement *body) {
  this->cond = cond;
  this->body = body;
}

gdsl::rreil::_while::~_while() {
  delete this->cond;
  delete this->body;
}
