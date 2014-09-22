/*
 * copy_visitor.cpp
 *
 *  Created on: Sep 19, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/copy_visitor.h>
#include <cppgdsl/rreil/rreil.h>
#include <cppgdsl/rreil/statement/floating.h>
#include <vector>

using namespace std;

void gdsl::rreil::copy_visitor::visit(std::vector<statement*> *statements) {
  std::vector<statement*> *_statements = new vector<statement*>();
  for(auto stmt : *statements) {
    stmt->accept(*this);
    _statements->push_back(this->_statement);
  }
  this->_statements = _statements;
}

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

void gdsl::rreil::copy_visitor::visit(store *a) {
  a->get_address()->accept(*this);
  address *_address = this->_address;
  a->get_rhs()->accept(*this);
  linear *rhs = _linear;
  if(store_ctor != NULL) _statement = store_ctor(a->get_size(), _address, rhs);
  else _statement = new store(a->get_size(), _address, rhs);
}

void gdsl::rreil::copy_visitor::visit(ite *a) {
  a->get_cond()->accept(*this);
  sexpr *cond = this->_sexpr;
  auto then_branch = new vector<statement*>();
  for(auto stmt : *a->get_then_branch()) {
    stmt->accept(*this);
    then_branch->push_back(_statement);
  }
  auto else_branch = new vector<statement*>();
  for(auto stmt : *a->get_else_branch()) {
    stmt->accept(*this);
    else_branch->push_back(_statement);
  }
  if(ite_ctor != NULL) _statement = ite_ctor(cond, then_branch, else_branch);
  else _statement = new ite(cond, then_branch, else_branch);
}

void gdsl::rreil::copy_visitor::visit(_while *a) {
  a->get_cond()->accept(*this);
  sexpr *cond = _sexpr;
  auto body = new vector<statement*>();
  for(auto stmt : *a->get_body()) {
    stmt->accept(*this);
    body->push_back(_statement);
  }
  if(_while_ctor != NULL) _statement = _while_ctor(cond, body);
  else _statement = new _while(cond, body);
}

void gdsl::rreil::copy_visitor::visit(cbranch *a) {
  a->get_cond()->accept(*this);
  sexpr *cond = _sexpr;
  a->get_target_true()->accept(*this);
  address *target_true = _address;
  a->get_target_false()->accept(*this);
  address *target_false = _address;
  if(cbranch_ctor != NULL) _statement = cbranch_ctor(cond, target_true, target_false);
  else _statement = new cbranch(cond, target_true, target_false);
}

void gdsl::rreil::copy_visitor::visit(branch *a) {
  a->get_target()->accept(*this);
  address *target = _address;
  if(branch_ctor != NULL) _statement = branch_ctor(target, a->get_hint());
  else _statement = new branch(target, a->get_hint());
}

void gdsl::rreil::copy_visitor::visit(floating *a) {
  a->get_flags()->accept(*this);
  variable *flags = _variable;
  a->get_lhs()->accept(*this);
  variable_limited *lhs = _variable_limited;
  vector<variable_limited*> rhs;
  for(auto var : a->get_rhs()) {
    var->accept(*this);
    rhs.push_back(_variable_limited);
  }
  if(floating_ctor != NULL) _statement = floating_ctor(a->get_op(), flags, lhs, rhs);
  else _statement = new floating(a->get_op(), flags, lhs, rhs);
}

void gdsl::rreil::copy_visitor::visit(prim *a) {
  vector<variable_limited*> lhs;
  for(auto var : a->get_lhs()) {
    var->accept(*this);
    lhs.push_back(_variable_limited);
  }
  vector<variable_limited*> rhs;
  for(auto var : a->get_rhs()) {
    var->accept(*this);
    rhs.push_back(_variable_limited);
  }
  if(prim_ctor != NULL) _statement = prim_ctor(a->get_op(), a->get_lhs(), a->get_rhs());
  else _statement = new prim(a->get_op(), a->get_lhs(), a->get_rhs());
}

void gdsl::rreil::copy_visitor::visit(arbitrary *a) {
  if(arbitrary_ctor != NULL) _sexpr = arbitrary_ctor();
  else _sexpr = new arbitrary();
}

void gdsl::rreil::copy_visitor::visit(sexpr_cmp *a) {
  a->get_inner()->accept(*this);
  expr_cmp *inner = _expr_cmp;
  if(sexpr_cmp_ctor != NULL) _sexpr = sexpr_cmp_ctor(inner);
  else _sexpr = new sexpr_cmp(inner);
}

void gdsl::rreil::copy_visitor::visit(sexpr_lin *a) {
  a->get_lin()->accept(*this);
  linear *lin = _linear;
  if(sexpr_lin_ctor != NULL) _sexpr = sexpr_lin_ctor(lin);
  else _sexpr = new sexpr_lin(lin);
}

void gdsl::rreil::copy_visitor::visit(lin_binop *a) {
  a->get_opnd1()->accept(*this);
  linear *opnd1 = _linear;
  a->get_opnd2()->accept(*this);
  linear *opnd2 = _linear;
  if(lin_binop_ctor != NULL) _linear = lin_binop_ctor(a->get_op(), opnd1, opnd2);
  else _linear = new lin_binop(a->get_op(), opnd1, opnd2);
}

void gdsl::rreil::copy_visitor::visit(lin_imm *a) {
  if(lin_imm_ctor != NULL) _linear = lin_imm_ctor(a->get_imm());
  else _linear = new lin_imm(a->get_imm());
  ;
}

void gdsl::rreil::copy_visitor::visit(lin_scale *a) {
  a->get_opnd()->accept(*this);
  linear *opnd = _linear;
  if(lin_scale_ctor != NULL) _linear = lin_scale_ctor(a->get_const(), opnd);
  else _linear = new lin_scale(a->get_const(), opnd);
}

void gdsl::rreil::copy_visitor::visit(lin_var *a) {
  a->get_var()->accept(*this);
  variable *var = _variable;
  if(lin_var_ctor != NULL) _linear = lin_var_ctor(var);
  else _linear = new lin_var(var);
}

void gdsl::rreil::copy_visitor::visit(arch_id *a) {
  if(arch_id_ctor != NULL) _id = arch_id_ctor(a->get_name());
  else _id = new arch_id(a->get_name());
}

void gdsl::rreil::copy_visitor::visit(shared_id *a) {
  if(shared_id_ctor != NULL) _id = shared_id_ctor(a->get_inner());
  else _id = new shared_id(a->get_inner());
}

void gdsl::rreil::copy_visitor::visit(_virtual *a) {
  if(_virtual_ctor != NULL) _id = _virtual_ctor(a->get_t());
  else _id = new _virtual(a->get_t());
}

void gdsl::rreil::copy_visitor::visit(expr_binop *a) {
  a->get_opnd1()->accept(*this);
  linear *opnd1 = _linear;
  a->get_opnd2()->accept(*this);
  linear *opnd2 = _linear;
  if(expr_binop_ctor != NULL) _expr = expr_binop_ctor(a->get_op(), a->get_opnd1(), a->get_opnd2());
  else _expr = new expr_binop(a->get_op(), opnd1, opnd2);
  ;
}

void gdsl::rreil::copy_visitor::visit(expr_ext *a) {
  a->get_opnd()->accept(*this);
  linear *opnd = _linear;
  if(expr_ext_ctor != NULL) _expr = expr_ext_ctor(a->get_op(), a->get_fromsize(), opnd);
  else _expr = new expr_ext(a->get_op(), a->get_fromsize(), opnd);
}

void gdsl::rreil::copy_visitor::visit(expr_sexpr *a) {
  a->get_inner()->accept(*this);
  sexpr *inner = _sexpr;
  if(expr_sexpr_ctor != NULL) _expr = expr_sexpr_ctor(inner);
  else _expr = new expr_sexpr(inner);
}

void gdsl::rreil::copy_visitor::visit(arch_exception *a) {
  if(arch_exception_ctor != NULL) _exception = arch_exception_ctor(a->get_name());
  else _exception = new arch_exception(a->get_name());
}

void gdsl::rreil::copy_visitor::visit(shared_exception *a) {
  if(shared_exception_ctor != NULL) _exception = shared_exception_ctor(a->get_type());
  else _exception = new shared_exception(a->get_type());
}
