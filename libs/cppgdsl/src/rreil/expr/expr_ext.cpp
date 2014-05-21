/*
 * expr_ext.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/expr/expr_ext.h>

gdsl::rreil::expr_ext::expr_ext(ext_op op, int_t fromsize, linear *opnd) {
  this->op = op;
  this->fromsize = fromsize;
  this->opnd = opnd;
}

gdsl::rreil::expr_ext::~expr_ext() {
  delete this->opnd;
}
