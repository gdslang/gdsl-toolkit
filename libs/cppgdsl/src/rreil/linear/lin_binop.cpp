/*
 * lin_add.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/linear/lin_binop.h>
#include <iostream>

void gdsl::rreil::lin_binop::put(std::ostream &out) {
  out << "(" << *opnd1 << " " << bin_lin_op_to_string(op) << " " << *opnd2 << ")";
}

gdsl::rreil::lin_binop::lin_binop(binop_lin_op op, linear *opnd1, linear *opnd2) {
  this->op = op;
  this->opnd1 = opnd1;
  this->opnd2 = opnd2;
}

gdsl::rreil::lin_binop::~lin_binop() {
  delete this->opnd1;
  delete this->opnd2;
}

void gdsl::rreil::lin_binop::accept(linear_visitor& v) {
  v.visit(this);
}
