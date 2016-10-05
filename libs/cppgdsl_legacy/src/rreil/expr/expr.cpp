/*
 * expr.cpp
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/expr/expr.h>
#include <sstream>

std::ostream &gdsl::rreil::operator <<(std::ostream &out, expr &_this) {
  _this.put(out);
  return out;
}

std::string gdsl::rreil::expr::to_string() {
  std::stringstream o;
  o << *this;
  return o.str();
}
