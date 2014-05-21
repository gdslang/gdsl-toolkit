/*
 * expr_binop.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/expr/expr_binop.h>

gdsl::rreil::expr_binop::expr_binop(binop_op op, linear *opnd1, linear *opnd2) {
  this->op = op;
  this->opnd1 = opnd1;
  this->opnd2 = opnd2;
}

gdsl::rreil::expr_binop::~expr_binop() {
  delete this->opnd1;
  delete this->opnd2;
}
