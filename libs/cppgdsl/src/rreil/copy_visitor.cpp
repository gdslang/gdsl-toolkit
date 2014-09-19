/*
 * copy_visitor.cpp
 *
 *  Created on: Sep 19, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/copy_visitor.h>
#include <cppgdsl/rreil/rreil.h>

void gdsl::rreil::copy_visitor::visit(variable *a) {
  a->get_id()->accept(*this);
  id *id = _id;
  if(variable_ctor != NULL) _variable = variable_ctor(id, a->get_offset());
  else _variable = new variable(id, a->get_offset());
}

void gdsl::rreil::copy_visitor::visit(variable_limited *a) {
  a->get_id()->accept(*this);
  id *id = _id;
  if(variable_limited_ctor != NULL) _variable_limited = variable_limited_ctor(id, a->get_offset(), a->get_size());
  else _variable_limited = new variable_limited(id, a->get_offset(), a->get_size());
}

void gdsl::rreil::copy_visitor::visit(address *a) {
  a->get_lin()->accept(*this);
  linear *lin = _linear;
  if(address_ctor != NULL) _address = address_ctor(a->get_size(), lin);
  else _address = new address(a->get_size(), lin);
}

void gdsl::rreil::copy_visitor::visit(expr_cmp *a) {
  a->get_opnd1()->accept(*this);
  linear *opnd1 = _linear;
  a->get_opnd2()->accept(*this);
  linear *opnd2 = _linear;
  if(expr_cmp_ctor != NULL) _expr_cmp = expr_cmp_ctor(a->get_op(), opnd1, opnd2);
  else _expr_cmp = new expr_cmp(a->get_op(), opnd1, opnd2);
}

void gdsl::rreil::copy_visitor::visit(_throw *a) {
  a->get_inner()->accept(*this);
  gdsl::rreil::exception *e = _exception;
  if(_throw_ctor != NULL) _statement = _throw_ctor(e);
  else _statement = new _throw(e);
}

void gdsl::rreil::copy_visitor::visit(assign *a) {
  a->get_lhs()->accept(*this);
  variable *lhs = _variable;
  a->get_rhs()->accept(*this);
  expr *rhs = _expr;
  if(assign_ctor != NULL) _statement = assign_ctor(a->get_size(), lhs, rhs);
  else _statement = new assign(a->get_size(), lhs, rhs);
}

void gdsl::rreil::copy_visitor::visit(load *a) {
  a->get_lhs()->accept(*this);
  variable *lhs = _variable;
  a->get_address()->accept(*this);
  address *address = _address;
  if(load_ctor != NULL) _statement = load_ctor(a->get_size(), lhs, address);
  else _statement = new load(a->get_size(), lhs, address);
}

//void gdsl::rreil::copy_visitor::visit(store *a) {
//  statement_copy_visitor::visit(a);
//  a->get_address()->accept(*this);
//  a->get_rhs()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(ite *a) {
//  statement_copy_visitor::visit(a);
//  a->get_cond()->accept(*this);
//  for(auto stmt : *a->get_then_branch())
//    stmt->accept(*this);
//  for(auto stmt : *a->get_else_branch())
//    stmt->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(_while *a) {
//  statement_copy_visitor::visit(a);
//  a->get_cond()->accept(*this);
//  for(auto stmt : *a->get_body())
//    stmt->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(cbranch *a) {
//  statement_copy_visitor::visit(a);
//  a->get_cond()->accept(*this);
//  a->get_target_true()->accept(*this);
//  a->get_target_false()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(branch *a) {
//  statement_copy_visitor::visit(a);
//  a->get_target()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(floating *a) {
//  statement_copy_visitor::visit(a);
//  a->get_flags()->accept(*this);
//  a->get_lhs()->accept(*this);
//  for(auto v : a->get_rhs())
//    v->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(prim *a) {
//  statement_copy_visitor::visit(a);
//  for(auto v : a->get_lhs())
//    v->accept(*this);
//  for(auto v : a->get_rhs())
//    v->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(arbitrary *a) {
//  sexpr_copy_visitor::visit(a);
//}
//
//void gdsl::rreil::copy_visitor::visit(sexpr_cmp *a) {
//  sexpr_copy_visitor::visit(a);
//  a->get_inner()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(sexpr_lin *a) {
//  sexpr_copy_visitor::visit(a);
//  a->get_lin()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(lin_binop *a) {
//  linear_copy_visitor::visit(a);
//  a->get_opnd1()->accept(*this);
//  a->get_opnd2()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(lin_imm *a) {
//  linear_copy_visitor::visit(a);
//}
//
//void gdsl::rreil::copy_visitor::visit(lin_scale *a) {
//  linear_copy_visitor::visit(a);
//  a->get_opnd()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(lin_var *a) {
//  linear_copy_visitor::visit(a);
//  a->get_var()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(arch_id *a) {
//  id_copy_visitor::visit(a);
//}
//
//void gdsl::rreil::copy_visitor::visit(shared_id *a) {
//  id_copy_visitor::visit(a);
//}
//
//void gdsl::rreil::copy_visitor::visit(_virtual *a) {
//  id_copy_visitor::visit(a);
//}
//
//void gdsl::rreil::copy_visitor::visit(expr_binop *a) {
//  expr_copy_visitor::visit(a);
//  a->get_opnd1()->accept(*this);
//  a->get_opnd2()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(expr_ext *a) {
//  expr_copy_visitor::visit(a);
//  a->get_opnd()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(expr_sexpr *a) {
//  expr_copy_visitor::visit(a);
//  a->get_inner()->accept(*this);
//}
//
//void gdsl::rreil::copy_visitor::visit(arch_exception *a) {
//  exception_copy_visitor::visit(a);
//}
//
//void gdsl::rreil::copy_visitor::visit(shared_exception *a) {
//  exception_copy_visitor::visit(a);
//}
