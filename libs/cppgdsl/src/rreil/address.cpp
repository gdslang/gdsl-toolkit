/*
 * address.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/address.h>
#include <iostream>
#include <sstream>

gdsl::rreil::address::address(int_t size, linear *lin) {
  this->size = size;
  this->lin = lin;
}

gdsl::rreil::address::~address() {
  delete this->lin;
}

std::string gdsl::rreil::address::to_string() {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream& gdsl::rreil::operator <<(std::ostream &out, address &_this) {
  out << "(" << *_this.lin << "/" << _this.size << ")";
  return out;
}
