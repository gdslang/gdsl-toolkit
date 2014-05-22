/*
 * variable.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/variable.h>

using namespace gdsl::rreil;
using namespace std;

gdsl::rreil::variable::variable(id *_id, int_t offset) {
  this->_id = _id;
  this->offset = offset;
}

gdsl::rreil::variable::~variable() {
  delete this->_id;
}

std::string gdsl::rreil::variable::to_string() {
  string r = _id->to_string();
  return this->offset ? r + "." + std::to_string(offset) : r;
}
