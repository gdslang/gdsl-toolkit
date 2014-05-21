/*
 * throw.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/throw.h>

gdsl::rreil::_throw::_throw(exception *inner) {
  this->inner = inner;
}

gdsl::rreil::_throw::~_throw() {
  delete this->inner;
}
