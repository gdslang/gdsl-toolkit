/*
 * id.cpp
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/id/id.h>
#include <sstream>

size_t gdsl::rreil::id::subclass_counter = 0;

std::ostream &gdsl::rreil::operator <<(std::ostream &out, id &_this) {
  _this.put(out);
  return out;
}

std::string gdsl::rreil::id::to_string() {
  std::stringstream o;
  o << *this;
  return o.str();
}
