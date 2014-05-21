
/*
 * sexpr_lin.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/sexpr/sexpr_lin.h>

using namespace gdsl::rreil;

gdsl::rreil::sexpr_lin::sexpr_lin(linear *lin) {
  this->lin = lin;
}

gdsl::rreil::sexpr_lin::~sexpr_lin() {
  delete this->lin;
}
