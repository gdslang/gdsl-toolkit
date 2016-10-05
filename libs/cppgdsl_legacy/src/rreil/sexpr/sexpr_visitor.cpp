/*
 * sexpr_visitor.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/sexpr/sexpr_visitor.h>
#include <cppgdsl/rreil/sexpr/sexpr.h>
#include <cppgdsl/rreil/sexpr/arbitrary.h>
#include <cppgdsl/rreil/sexpr/sexpr_cmp.h>
#include <cppgdsl/rreil/sexpr/sexpr_lin.h>

using namespace gdsl::rreil;

void sexpr_visitor::visit(arbitrary *a) {
    if(arbitrary_callback != NULL)
      arbitrary_callback(a);
    else
      _default(a);
  }
void sexpr_visitor::visit(sexpr_cmp *a) {
    if(sexpr_cmp_callback != NULL)
      sexpr_cmp_callback(a);
    else
      _default(a);
  }
void sexpr_visitor::visit(sexpr_lin *a) {
    if(sexpr_lin_callback != NULL)
      sexpr_lin_callback(a);
    else
      _default(a);
}

void gdsl::rreil::sexpr_visitor::_default(sexpr *s) {
  if(default_callback != NULL)
    default_callback(s);
}
