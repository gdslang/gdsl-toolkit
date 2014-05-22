/*
 * expr_cmp.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/expr_cmp/cmp_op.h>
#include <cppgdsl/rreil/expr_cmp/expr_cmp.h>
#include <cppgdsl/rreil/linear/linear.h>

gdsl::rreil::expr_cmp::expr_cmp(cmp_op op, linear *opnd1, linear *opnd2) {
  this->opnd1 = opnd1;
  this->opnd2 = opnd2;
}

gdsl::rreil::expr_cmp::~expr_cmp() {
  delete this->opnd1;
  delete this->opnd2;
}

std::string gdsl::rreil::expr_cmp::to_string() {
  return opnd1->to_string() + " " + cmp_op_to_string(op) + " " + opnd2->to_string();
}
