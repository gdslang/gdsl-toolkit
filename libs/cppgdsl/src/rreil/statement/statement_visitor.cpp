/*
 * statement_visitor.cpp
 *
 *  Created on: Oct 13, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/statement/statement_visitor.h>
#include <cppgdsl/rreil/rreil.h>

using namespace gdsl::rreil;

void statement_visitor::visit(assign *a) {
  if(assign_callback != NULL)
    assign_callback(a);
  _default(a);
}
void statement_visitor::visit(load *a) {
  if(load_callback != NULL)
    load_callback(a);
  _default(a);
}
void statement_visitor::visit(store *a) {
  if(store_callback != NULL)
    store_callback(a);
  _default(a);
}
void statement_visitor::visit(ite *a) {
  if(ite_callback != NULL)
    ite_callback(a);
  _default(a);
}
void statement_visitor::visit(_while *a) {
  if(_while_callback != NULL)
    _while_callback(a);
  _default(a);
}
void statement_visitor::visit(cbranch *a) {
  if(cbranch_callback != NULL)
    cbranch_callback(a);
  _default(a);
}
void statement_visitor::visit(branch *a) {
  if(branch_callback != NULL)
    branch_callback(a);
  _default(a);
}
void statement_visitor::visit(floating *a) {
  if(floating_callback != NULL)
    floating_callback(a);
  _default(a);
}
void statement_visitor::visit(prim *a) {
  if(prim_callback != NULL)
    prim_callback(a);
  _default(a);
}
void statement_visitor::visit(_throw *a) {
  if(_throw_callback != NULL)
    _throw_callback(a);
  _default(a);
}
void statement_visitor::_default(statement *s) {
  if(default_callback != NULL)
    default_callback(s);
}
