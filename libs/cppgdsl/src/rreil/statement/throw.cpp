/*
 * throw.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/throw.h>
#include <iostream>

using namespace std;

gdsl::rreil::_throw::_throw(exception *inner) {
  this->inner = inner;
}

gdsl::rreil::_throw::~_throw() {
  delete this->inner;
}

void gdsl::rreil::_throw::accept(statement_visitor& v) {
  v.visit(this);
}

void gdsl::rreil::_throw::put(std::ostream &out) {
  out << "throw " << *inner;
}
