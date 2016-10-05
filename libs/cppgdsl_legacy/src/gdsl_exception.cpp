/*
 * gdsl_exception.cpp
 *
 *  Created on: May 27, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/gdsl_exception.h>
#include <iostream>

gdsl::gdsl_exception::gdsl_exception(std::string cppgdsl_message, std::string gdsl_message) {
  this->cppgdsl_message = cppgdsl_message;
  this->gdsl_message = gdsl_message;
}

std::ostream &gdsl::operator <<(std::ostream &out, gdsl_exception &_this) {
  out << "gdsl exception, original gdsl message: " << _this.gdsl_message << ", cppgdsl message: "
      << _this.cppgdsl_message;
  return out;
}
