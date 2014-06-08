/*
 * sexpr.cpp
 *
 *  Created on: May 26, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/sexpr/sexpr.h>
#include <sstream>

std::string gdsl::rreil::sexpr::to_string() {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream& gdsl::rreil::operator <<(std::ostream &out, sexpr &_this) {
  _this.put(out);
  return out;
}
