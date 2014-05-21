
/*
 * store.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/store.h>

gdsl::rreil::store::store(int_t size, address *_address, linear *rhs) {
  this->size = size;
  this->_address = _address;
  this->rhs = rhs;
}

gdsl::rreil::store::~store() {
  delete this->_address;
  delete this->rhs;
}
