/*
 * linear.cpp
 *
 *  Created on: May 26, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/linear/linear.h>
#include <sstream>

std::string gdsl::rreil::linear::to_string() {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream &gdsl::rreil::operator <<(std::ostream &out, linear &_this) {
  _this.put(out);
  return out;
}
