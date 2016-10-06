#include "cppgdsl/rreil/visitor.h"
#include "cppgdsl/rreil/expr/expr_binop.h"
#include "cppgdsl/rreil/expr/expr_ext.h"
#include "cppgdsl/rreil/expr/expr_sexpr.h"
#include "cppgdsl/rreil/linear/lin_binop.h"
#include "cppgdsl/rreil/linear/lin_scale.h"
#include "cppgdsl/rreil/linear/lin_var.h"
#include "cppgdsl/rreil/sexpr/sexpr_cmp.h"
#include "cppgdsl/rreil/sexpr/sexpr_lin.h"
#include "cppgdsl/rreil/statement/assign.h"
#include "cppgdsl/rreil/statement/branch.h"
#include "cppgdsl/rreil/statement/cbranch.h"
#include "cppgdsl/rreil/statement/floating.h"
#include "cppgdsl/rreil/statement/ite.h"
#include "cppgdsl/rreil/statement/load.h"
#include "cppgdsl/rreil/statement/prim.h"
#include "cppgdsl/rreil/statement/store.h"
#include "cppgdsl/rreil/statement/throw.h"
#include "cppgdsl/rreil/statement/while.h"

using gdsl::rreil::assign;

void gdsl::rreil::visitor::visit(variable const* a) {
  if (variable_callback != nullptr) variable_callback(a);
  _default();
  a->get_id().accept(*this);
}

void gdsl::rreil::visitor::visit(variable_limited const* a) {
  if (variable_limited_callback != nullptr) variable_limited_callback(a);
  _default();
  a->get_id().accept(*this);
}

void gdsl::rreil::visitor::visit(address const* a) {
  if (address_callback != nullptr) address_callback(a);
  _default();
  a->get_lin().accept(*this);
}

void gdsl::rreil::visitor::visit(expr_cmp const* a) {
  if (expr_cmp_callback != nullptr) expr_cmp_callback(a);
  _default();
  a->get_lhs().accept(*this);
  a->get_rhs().accept(*this);
}

void gdsl::rreil::visitor::visit(_throw const* a) {
  statement_visitor::visit(a);
  a->get_inner().accept(*this);
}

void gdsl::rreil::visitor::visit(assign const* a) {
  statement_visitor::visit(a);
  a->get_lhs().accept(*this);
  a->get_rhs().accept(*this);
}

void gdsl::rreil::visitor::visit(load const* a) {
  statement_visitor::visit(a);
  a->get_lhs().accept(*this);
  a->get_address().accept(*this);
}

void gdsl::rreil::visitor::visit(store const* a) {
  statement_visitor::visit(a);
  a->get_address().accept(*this);
  a->get_rhs().accept(*this);
}

void gdsl::rreil::visitor::visit(ite const* a) {
  statement_visitor::visit(a);
  a->get_cond().accept(*this);
  for (auto const& stmt : a->get_then_branch()) stmt.accept(*this);
  for (auto const& stmt : a->get_else_branch()) stmt.accept(*this);
}

void gdsl::rreil::visitor::visit(_while const* a) {
  statement_visitor::visit(a);
  a->get_cond().accept(*this);
  for (auto const& stmt : a->get_body()) stmt.accept(*this);
}

void gdsl::rreil::visitor::visit(cbranch const* a) {
  statement_visitor::visit(a);
  a->get_cond().accept(*this);
  a->get_target_true().accept(*this);
  a->get_target_false().accept(*this);
}

void gdsl::rreil::visitor::visit(branch const* a) {
  statement_visitor::visit(a);
  a->get_target().accept(*this);
}

void gdsl::rreil::visitor::visit(floating const* a) {
  statement_visitor::visit(a);
  a->get_flags().accept(*this);
  a->get_lhs().accept(*this);
  for (auto const& v : a->get_rhs()) v.accept(*this);
}

void gdsl::rreil::visitor::visit(prim const* a) {
  statement_visitor::visit(a);
  for (auto const& v : a->get_lhs()) v.accept(*this);
  for (auto const& v : a->get_rhs()) v.accept(*this);
}

void gdsl::rreil::visitor::visit(arbitrary const* a) {
  sexpr_visitor::visit(a);
}

void gdsl::rreil::visitor::visit(sexpr_cmp const* a) {
  sexpr_visitor::visit(a);
  a->get_inner().accept(*this);
}

void gdsl::rreil::visitor::visit(sexpr_lin const* a) {
  sexpr_visitor::visit(a);
  a->get_lin().accept(*this);
}

void gdsl::rreil::visitor::visit(lin_binop const* a) {
  linear_visitor::visit(a);
  a->get_lhs().accept(*this);
  a->get_rhs().accept(*this);
}

void gdsl::rreil::visitor::visit(lin_imm const* a) { linear_visitor::visit(a); }

void gdsl::rreil::visitor::visit(lin_scale const* a) {
  linear_visitor::visit(a);
  a->get_operand().accept(*this);
}

void gdsl::rreil::visitor::visit(lin_var const* a) {
  linear_visitor::visit(a);
  a->get_var().accept(*this);
}

void gdsl::rreil::visitor::visit(arch_id const* a) { id_visitor::visit(a); }

void gdsl::rreil::visitor::visit(shared_id const* a) { id_visitor::visit(a); }

void gdsl::rreil::visitor::visit(_virtual const* a) { id_visitor::visit(a); }

void gdsl::rreil::visitor::visit(expr_binop const* a) {
  expr_visitor::visit(a);
  a->get_lhs().accept(*this);
  a->get_rhs().accept(*this);
}

void gdsl::rreil::visitor::visit(expr_ext const* a) {
  expr_visitor::visit(a);
  a->get_operand().accept(*this);
}

void gdsl::rreil::visitor::visit(expr_sexpr const* a) {
  expr_visitor::visit(a);
  a->get_inner().accept(*this);
}

void gdsl::rreil::visitor::visit(arch_exception const* a) {
  exception_visitor::visit(a);
}

void gdsl::rreil::visitor::visit(shared_exception const* a) {
  exception_visitor::visit(a);
}
