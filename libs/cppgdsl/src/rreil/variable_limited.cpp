/*
 * variable_limited.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/variable_limited.h>

gdsl::rreil::variable_limited::variable_limited(id *_id, int_t offset, int_t size) :
    variable(_id, offset) {
  this->size = size;
}

std::string gdsl::rreil::variable_limited::to_string() {
  return variable::to_string() + "/" + std::to_string(size);
}
