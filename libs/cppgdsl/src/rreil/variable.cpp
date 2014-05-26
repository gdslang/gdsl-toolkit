/*
 * variable.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/variable.h>
#include <sstream>

using namespace gdsl::rreil;
using namespace std;

void gdsl::rreil::variable::put(std::ostream &out) {
  this->offset ? out << *_id << "." << offset : out << *_id;
}

gdsl::rreil::variable::variable(id *_id, int_t offset) {
  this->_id = _id;
  this->offset = offset;
}

gdsl::rreil::variable::~variable() {
  delete this->_id;
}

std::string gdsl::rreil::variable::to_string() {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream &gdsl::rreil::operator <<(std::ostream &out, variable &_this) {
  _this.put(out);
  return out;
}
