/*
 * load.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/load.h>

gdsl::rreil::load::load(int_t size, variable *lhs, address *_address) {
  this->size = size;
  this->lhs = lhs;
  this->_address = _address;
}

gdsl::rreil::load::~load() {
  delete this->lhs;
  delete this->_address;
}
