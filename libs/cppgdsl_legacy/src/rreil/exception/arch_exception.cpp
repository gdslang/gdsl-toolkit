/*
 * arch_exception.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/exception/arch_exception.h>
#include <iostream>

gdsl::rreil::arch_exception::arch_exception(std::string name) {
  this->name = name;
}

void gdsl::rreil::arch_exception::accept(exception_visitor &v) {
  return v.visit(this);
}

void gdsl::rreil::arch_exception::put(std::ostream &out) {
  out << "[architecture specific exception:";
  out << name;
  out << "]";
}
