/*
 * statement.cpp
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */
#include <cppgdsl/rreil/statement/statement.h>
#include <sstream>

std::ostream &gdsl::rreil::operator<<(std::ostream &out,
                                      const statement &statement) {
  statement.put(out);
  return out;
}

std::string gdsl::rreil::statement::to_string() const {
  std::stringstream o;
  o << *this;
  return o.str();
}
