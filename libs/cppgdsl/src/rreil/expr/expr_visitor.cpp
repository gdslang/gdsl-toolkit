/*
 * expr_visitor.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/expr/expr_visitor.h>
#include <cppgdsl/rreil/expr/expr.h>
#include <cppgdsl/rreil/expr/expr_binop.h>
#include <cppgdsl/rreil/expr/expr_ext.h>
#include <cppgdsl/rreil/expr/expr_sexpr.h>

using namespace gdsl::rreil;

void expr_visitor::visit(expr_binop *a) {
  if(expr_binop_callback != NULL)
    expr_binop_callback(a);
  else
    _default(a);
}

void expr_visitor::visit(expr_ext *a) {
  if(expr_ext_callback != NULL)
    expr_ext_callback(a);
  else
    _default(a);
}

void expr_visitor::visit(expr_sexpr *a) {
  if(expr_sexpr_callback != NULL)
    expr_sexpr_callback(a);
  else
    _default(a);
}

void gdsl::rreil::expr_visitor::_default(expr *e) {
  if(default_callback != NULL)
    default_callback(e);
}
