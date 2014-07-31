
/*
 * visitor.cpp
 *
 *  Created on: Jun 2, 2014
 *      Author: Julian Kranz
 */
#include <cppgdsl/rreil/expr/expr_binop.h>
#include <cppgdsl/rreil/expr/expr_ext.h>
#include <cppgdsl/rreil/expr/expr_sexpr.h>
#include <cppgdsl/rreil/linear/lin_binop.h>
#include <cppgdsl/rreil/linear/lin_scale.h>
#include <cppgdsl/rreil/linear/lin_var.h>
#include <cppgdsl/rreil/sexpr/sexpr_cmp.h>
#include <cppgdsl/rreil/sexpr/sexpr_lin.h>
#include <cppgdsl/rreil/visitor.h>
#include <cppgdsl/rreil/statement/assign.h>
#include <cppgdsl/rreil/statement/branch.h>
#include <cppgdsl/rreil/statement/cbranch.h>
#include <cppgdsl/rreil/statement/prim.h>
#include <cppgdsl/rreil/statement/floating.h>
#include <cppgdsl/rreil/statement/ite.h>
#include <cppgdsl/rreil/statement/load.h>
#include <cppgdsl/rreil/statement/store.h>
#include <cppgdsl/rreil/statement/throw.h>
#include <cppgdsl/rreil/statement/while.h>

using gdsl::rreil::assign;

void gdsl::rreil::visitor::visit(variable *a) {
  if(variable_callback != NULL)
    variable_callback(a);
  _default();
  a->get_id()->accept(*this);
}

void gdsl::rreil::visitor::visit(variable_limited *a) {
  if(variable_limited_callback != NULL)
    variable_limited_callback(a);
  _default();
  a->get_id()->accept(*this);
}

void gdsl::rreil::visitor::visit(address *a) {
  if(address_callback != NULL)
    address_callback(a);
  _default();
  a->get_lin()->accept(*this);
}

void gdsl::rreil::visitor::visit(expr_cmp *a) {
  if(expr_cmp_callback != NULL)
    expr_cmp_callback(a);
  _default();
  a->get_opnd1()->accept(*this);
  a->get_opnd2()->accept(*this);
}

void gdsl::rreil::visitor::visit(_throw* a) {
  statement_visitor::visit(a);
  a->get_inner()->accept(*this);
}

void gdsl::rreil::visitor::visit(assign *a) {
  statement_visitor::visit(a);
  a->get_lhs()->accept(*this);
  a->get_rhs()->accept(*this);
}

void gdsl::rreil::visitor::visit(load *a) {
  statement_visitor::visit(a);
  a->get_lhs()->accept(*this);
  a->get_address()->accept(*this);
}

void gdsl::rreil::visitor::visit(store *a) {
  statement_visitor::visit(a);
  a->get_address()->accept(*this);
  a->get_rhs()->accept(*this);
}

void gdsl::rreil::visitor::visit(ite *a) {
  statement_visitor::visit(a);
  a->get_cond()->accept(*this);
  a->get_then_branch()->accept(*this);
  a->get_else_branch()->accept(*this);
}

void gdsl::rreil::visitor::visit(_while *a) {
  statement_visitor::visit(a);
  a->get_cond()->accept(*this);
  a->get_body()->accept(*this);
}

void gdsl::rreil::visitor::visit(cbranch *a) {
  statement_visitor::visit(a);
  a->get_cond()->accept(*this);
  a->get_target_true()->accept(*this);
  a->get_target_false()->accept(*this);
}

void gdsl::rreil::visitor::visit(branch *a) {
  statement_visitor::visit(a);
  a->get_target()->accept(*this);
}

void gdsl::rreil::visitor::visit(floating *a) {
  statement_visitor::visit(a);
  a->get_flags()->accept(*this);
  a->get_lhs()->accept(*this);
  for(auto v : a->get_rhs())
    v->accept(*this);
}

void gdsl::rreil::visitor::visit(prim *a) {
  statement_visitor::visit(a);
  for(auto v : a->get_lhs())
    v->accept(*this);
  for(auto v : a->get_rhs())
    v->accept(*this);
}

void gdsl::rreil::visitor::visit(arbitrary *a) {
  sexpr_visitor::visit(a);
}

void gdsl::rreil::visitor::visit(sexpr_cmp *a) {
  sexpr_visitor::visit(a);
  a->get_inner()->accept(*this);
}

void gdsl::rreil::visitor::visit(sexpr_lin *a) {
  sexpr_visitor::visit(a);
  a->get_lin()->accept(*this);
}

void gdsl::rreil::visitor::visit(lin_binop *a) {
  linear_visitor::visit(a);
  a->get_opnd1()->accept(*this);
  a->get_opnd2()->accept(*this);
}

void gdsl::rreil::visitor::visit(lin_imm *a) {
  linear_visitor::visit(a);
}

void gdsl::rreil::visitor::visit(lin_scale *a) {
  linear_visitor::visit(a);
  a->get_opnd()->accept(*this);
}

void gdsl::rreil::visitor::visit(lin_var *a) {
  linear_visitor::visit(a);
  a->get_var()->accept(*this);
}

void gdsl::rreil::visitor::visit(arch_id *a) {
  id_visitor::visit(a);
}

void gdsl::rreil::visitor::visit(shared_id *a) {
  id_visitor::visit(a);
}

void gdsl::rreil::visitor::visit(_virtual *a) {
  id_visitor::visit(a);
}

void gdsl::rreil::visitor::visit(expr_binop *a) {
  expr_visitor::visit(a);
  a->get_opnd1()->accept(*this);
  a->get_opnd2()->accept(*this);
}

void gdsl::rreil::visitor::visit(expr_ext *a) {
  expr_visitor::visit(a);
  a->get_opnd()->accept(*this);
}

void gdsl::rreil::visitor::visit(expr_sexpr *a) {
  expr_visitor::visit(a);
  a->get_inner()->accept(*this);
}

void gdsl::rreil::visitor::visit(arch_exception *a) {
  exception_visitor::visit(a);
}

void gdsl::rreil::visitor::visit(shared_exception *a) {
  exception_visitor::visit(a);
}
