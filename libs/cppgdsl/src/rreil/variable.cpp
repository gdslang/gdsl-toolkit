/*
 * variable.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/variable.h>

using namespace gdsl::rreil;

gdsl::rreil::variable::variable(id *_id, int_t offset) {
  this->_id = _id;
  this->offset = offset;
}

gdsl::rreil::variable::~variable() {
  delete this->_id;
}
