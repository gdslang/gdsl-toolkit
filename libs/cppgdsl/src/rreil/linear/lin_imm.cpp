/*
 * lin_imm.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/linear/lin_imm.h>
#include <iostream>

void gdsl::rreil::lin_imm::put(std::ostream &out) {
  out << _const;
}

gdsl::rreil::lin_imm::lin_imm(int_t _const) {
  this->_const = _const;
}

void gdsl::rreil::lin_imm::accept(linear_visitor &v) {
  v.visit(this);
}
