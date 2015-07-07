/*
 * statement.cpp
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */
#include <cppgdsl/rreil/statement/statement.h>
#include <sstream>

std::string gdsl::rreil::statement::to_string() const {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream &gdsl::rreil::operator<<(std::ostream &out,
                                      const statement &_this) {
  _this.put(out);
  return out;
}
