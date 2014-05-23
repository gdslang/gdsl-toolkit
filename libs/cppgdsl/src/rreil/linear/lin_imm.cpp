/*
 * lin_imm.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/linear/lin_imm.h>

gdsl::rreil::lin_imm::lin_imm(int_t _const) {
  this->_const = _const;
}

std::string gdsl::rreil::lin_imm::to_string() {
  return std::to_string(_const);
}

void gdsl::rreil::lin_imm::accept(linear_visitor &v) {
  v.visit(this);
}
