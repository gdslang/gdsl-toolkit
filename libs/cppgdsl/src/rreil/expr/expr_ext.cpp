/*
 * expr_ext.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/expr/expr_ext.h>
#include <iostream>

std::string gdsl::rreil::ext_op_to_string(ext_op op) {
  switch(op) {
    case EXT_ZX: {
      return "z";
    }
    case EXT_SX: {
      return "s";
    }
  }
}

void gdsl::rreil::expr_ext::put(std::ostream &out) {
  out << "[" << ext_op_to_string(op) << "->" << fromsize << "]" << opnd;
}

gdsl::rreil::expr_ext::expr_ext(ext_op op, int_t fromsize, linear *opnd) {
  this->op = op;
  this->fromsize = fromsize;
  this->opnd = opnd;
}

gdsl::rreil::expr_ext::~expr_ext() {
  delete this->opnd;
}

void gdsl::rreil::expr_ext::accept(expr_visitor &v) {
  v.visit(this);
}


