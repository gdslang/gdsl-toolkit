/*
 * lin_var.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/linear/lin_var.h>

gdsl::rreil::lin_var::lin_var(variable *var) {
  this->var = var;
}

gdsl::rreil::lin_var::~lin_var() {
  delete this->var;
}
