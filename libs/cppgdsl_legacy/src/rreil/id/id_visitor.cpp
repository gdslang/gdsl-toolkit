/*
 * id_visitor.cpp
 *
 *  Created on: Oct 28, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/id/id_visitor.h>
#include <cppgdsl/rreil/id/arch_id.h>
#include <cppgdsl/rreil/id/shared_id.h>
#include <cppgdsl/rreil/id/virtual.h>

using namespace gdsl::rreil;

void id_visitor::visit(arch_id *a) {
  if(arch_id_callback != NULL) arch_id_callback(a);
  else _default(a);
}
void id_visitor::visit(shared_id *a) {
  if(shared_id_callback != NULL) shared_id_callback(a);
  else _default(a);
}
void id_visitor::visit(_virtual *a) {
  if(_virtual_callback != NULL) _virtual_callback(a);
  else _default(a);
}

void gdsl::rreil::id_visitor::_default(id *i) {
  if(default_callback != NULL) default_callback(i);
}
