/*
 * variable_limited.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/variable_limited.h>
#include <cppgdsl/rreil/visitor.h>
#include <iostream>

void gdsl::rreil::variable_limited::put(std::ostream &out) {
  variable::put(out);
  out << "/" << size;
}

gdsl::rreil::variable_limited::variable_limited(id *_id, int_t offset, int_t size) :
    variable(_id, offset) {
  this->size = size;
}

void gdsl::rreil::variable_limited::accept(visitor &v) {
  v.visit(this);
}
