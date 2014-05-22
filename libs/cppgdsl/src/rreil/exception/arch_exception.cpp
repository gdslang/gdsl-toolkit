/*
 * arch_exception.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/exception/arch_exception.h>

gdsl::rreil::arch_exception::arch_exception(std::string name) {
  this->name = name;
}

std::string gdsl::rreil::arch_exception::to_string() {
  return "[architecture specific exception:" + name + "]";
}
