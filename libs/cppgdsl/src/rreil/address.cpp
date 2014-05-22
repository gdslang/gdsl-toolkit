/*
 * address.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/address.h>

gdsl::rreil::address::address(int_t size, linear *lin) {
  this->size = size;
  this->lin = lin;
}

gdsl::rreil::address::~address() {
  delete this->lin;
}

std::string gdsl::rreil::address::to_string() {
  return lin->to_string() + "/" + std::to_string(size);
}
