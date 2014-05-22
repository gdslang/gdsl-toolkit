/*
 * shared_exception.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/exception/shared_exception.h>

std::string gdsl::rreil::shared_exception_type_to_string(shared_exception_type t) {
  switch(t) {
    case TYPE_DIVISION_BY_ZERO:
      return "Division By Zero";
  }
}

gdsl::rreil::shared_exception::shared_exception(shared_exception_type type) {
  this->type = type;
}

std::string gdsl::rreil::shared_exception::to_string() {
  return "[architecture specific exception: " + shared_exception_type_to_string(type) + "]";

}

