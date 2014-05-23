/*
 * shared_exception.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/exception/shared_exception.h>
#include <iostream>

std::string gdsl::rreil::shared_exception_type_to_string(shared_exception_type t) {
  switch(t) {
    case TYPE_DIVISION_BY_ZERO:
      return "Division By Zero";
  }
}

gdsl::rreil::shared_exception::shared_exception(shared_exception_type type) {
  this->type = type;
}

void gdsl::rreil::shared_exception::accept(exception_visitor &v) {
  v.visit(this);
}

void gdsl::rreil::shared_exception::put(std::ostream &out) {
  out << "[architecture specific exception: ";
  out << shared_exception_type_to_string(type);
  out << "]";
}
