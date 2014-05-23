/*
 * exception.cpp
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/exception/exception.h>
#include <sstream>

std::ostream &gdsl::rreil::operator <<(std::ostream &out, exception &_this) {
  _this.put(out);
  return out;
}

std::string gdsl::rreil::exception::to_string() {
  std::stringstream o;
  o << *this;
  return o.str();
}
