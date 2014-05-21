/*
 * lin_add.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/linear/lin_add.h>

gdsl::rreil::lin_add::lin_add(linear *opnd1, linear *opnd2) {
  this->opnd1 = opnd1;
  this->opnd2 = opnd2;
}

gdsl::rreil::lin_add::~lin_add() {
  delete this->opnd1;
  delete this->opnd2;
}
