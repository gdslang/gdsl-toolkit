/*
 * statement.cpp
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */
#include <cppgdsl/rreil/statement/statement.h>

std::ostream& gdsl::rreil::operator <<(std::ostream &out, statement &_this) {
  _this.put(out);
  return out;
}
