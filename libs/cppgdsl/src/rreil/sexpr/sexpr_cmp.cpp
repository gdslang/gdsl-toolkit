/*
 * sexpr_cmp.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/sexpr/sexpr_cmp.h>

gdsl::rreil::sexpr_cmp::sexpr_cmp(expr_cmp *cmp) {
  this->cmp = cmp;
}

gdsl::rreil::sexpr_cmp::~sexpr_cmp() {
  delete this->cmp;
}
