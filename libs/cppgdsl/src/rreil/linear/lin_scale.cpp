/*
 * lin_scale.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/linear/lin_scale.h>

gdsl::rreil::lin_scale::lin_scale(int_t _const, linear *opnd) {
  this->_const = _const;
  this->opnd = opnd;
}

gdsl::rreil::lin_scale::~lin_scale() {
  delete this->opnd;
}
