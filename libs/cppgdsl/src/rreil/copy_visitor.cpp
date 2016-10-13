#include <cppgdsl/rreil/copy_visitor.h>
#include <cppgdsl/rreil/rreil.h>
#include <cppgdsl/rreil/statement/floating.h>
#include <vector>

using namespace std;

void gdsl::rreil::copy_visitor::visit(variable const *a) {
  a->get_id().accept(*this);
  auto id = std::move(_id);
  if (variable_ctor != NULL)
    _variable = variable_ctor(std::move(id), a->get_offset());
  else
    _variable = make_variable(std::move(id), a->get_offset());
}

void gdsl::rreil::copy_visitor::visit(variable_limited const *a) {
  a->get_id().accept(*this);
  auto id = std::move(_id);
  if (variable_limited_ctor != NULL)
    _variable_limited =
        variable_limited_ctor(std::move(id), a->get_offset(), a->get_size());
  else
    _variable_limited =
        make_variable(std::move(id), a->get_offset(), a->get_size());
}

void gdsl::rreil::copy_visitor::visit(address const *a) {
  a->get_lin().accept(*this);
  std::unique_ptr<linear> lin = std::move(_linear);
  if (address_ctor != NULL)
    _address = address_ctor(a->get_size(), std::move(lin));
  else
    _address = make_address(a->get_size(), lin);
}

void gdsl::rreil::copy_visitor::visit(expr_cmp const *a) {
  a->get_lhs().accept(*this);
  std::unique_ptr<linear> lhs = std::move(_linear);
  a->get_rhs().accept(*this);
  std::unique_ptr<linear> rhs = std::move(_linear);
  if (expr_cmp_ctor != NULL)
    _expr_cmp = expr_cmp_ctor(a->get_op(), std::move(lhs), std::move(rhs));
  else
    _expr_cmp = make_expr_cmp(a->get_op(), std::move(lhs), std::move(rhs));
}

void gdsl::rreil::copy_visitor::visit(_throw const *a) {
  a->get_inner().accept(*this);
  std::unique_ptr<gdsl::rreil::exception> e = std::move(_exception);
  if (_throw_ctor != NULL)
    _statement = _throw_ctor(std::move(e));
  else
    _statement = make_throw(std::move(e));
}

void gdsl::rreil::copy_visitor::visit(assign const *a) {
  a->get_lhs().accept(*this);
  std::unique_ptr<variable> lhs = std::move(_variable);
  a->get_rhs().accept(*this);
  std::unique_ptr<expr> rhs = std::move(_expr);
  if (assign_ctor != NULL)
    _statement = assign_ctor(a->get_size(), std::move(lhs), std::move(rhs));
  else
    _statement = make_assign(a->get_size(), std::move(lhs), std::move(rhs));
}

void gdsl::rreil::copy_visitor::visit(load const *a) {
  a->get_lhs().accept(*this);
  std::unique_ptr<variable> lhs = std::move(_variable);
  a->get_address().accept(*this);
  std::unique_ptr<address> address = std::move(_address);
  if (load_ctor != NULL)
    _statement = load_ctor(a->get_size(), std::move(lhs), std::move(address));
  else
    _statement = make_load(a->get_size(), std::move(lhs), std::move(address));
}

void gdsl::rreil::copy_visitor::visit(store const *a) {
  a->get_address().accept(*this);
  std::unique_ptr<address> address = std::move(this->_address);
  a->get_rhs().accept(*this);
  std::unique_ptr<linear> rhs = std::move(_linear);
  if (store_ctor != NULL)
    _statement = store_ctor(a->get_size(), std::move(address), std::move(rhs));
  else
    _statement = make_store(a->get_size(), std::move(address), std::move(rhs));
}

void gdsl::rreil::copy_visitor::visit(ite const *a) {
  a->get_cond().accept(*this);
  std::unique_ptr<sexpr> cond = std::move(this->_sexpr);
  vector<std::unique_ptr<statement>> then_branch;
  for (auto const &stmt : a->get_then_branch()) {
    stmt.accept(*this);
    then_branch.push_back(std::move(_statement));
  }
  vector<std::unique_ptr<statement>> else_branch;
  for (auto const &stmt : a->get_else_branch()) {
    stmt.accept(*this);
    else_branch.push_back(std::move(_statement));
  }
  if (ite_ctor != NULL)
    _statement = ite_ctor(std::move(cond), std::move(then_branch),
                          std::move(else_branch));
  else
    _statement = make_ite(std::move(cond), std::move(then_branch),
                          std::move(else_branch));
}

void gdsl::rreil::copy_visitor::visit(_while const *a) {
  a->get_cond().accept(*this);
  std::unique_ptr<sexpr> cond = std::move(_sexpr);
  vector<std::unique_ptr<statement>> body;
  for (auto const &stmt : a->get_body()) {
    stmt.accept(*this);
    body.push_back(std::move(_statement));
  }
  if (_while_ctor != NULL)
    _statement = _while_ctor(std::move(cond), std::move(body));
  else
    _statement = make_while(std::move(cond), std::move(body));
}

void gdsl::rreil::copy_visitor::visit(cbranch const* a) {
  a->get_cond().accept(*this);
  std::unique_ptr<sexpr> cond = std::move(_sexpr);
  a->get_target_true().accept(*this);
  std::unique_ptr<address> target_true = std::move(_address);
  a->get_target_false().accept(*this);
  std::unique_ptr<address> target_false = std::move(_address);
  if (cbranch_ctor != NULL)
    _statement = cbranch_ctor(std::move(cond), std::move(target_true),
                              std::move(target_false));
  else
    _statement = make_cbranch(std::move(cond), std::move(target_true),
                              std::move(target_false));
  ;
}

void gdsl::rreil::copy_visitor::visit(branch const *a) {
  a->get_target().accept(*this);
  std::unique_ptr<address> target = std::move(_address);
  if (branch_ctor != NULL)
    _statement = branch_ctor(std::move(target), a->get_hint());
  else
    _statement = make_branch(std::move(target), a->get_hint());
}

void gdsl::rreil::copy_visitor::visit(floating const *a) {
  a->get_flags().accept(*this);
  std::unique_ptr<variable> flags = std::move(_variable);
  a->get_lhs().accept(*this);
  std::unique_ptr<variable_limited> lhs = std::move(_variable_limited);
  vector<std::unique_ptr<variable_limited>> rhs;
  for (auto const &var : a->get_rhs()) {
    var.accept(*this);
    rhs.push_back(std::move(_variable_limited));
  }
  if (floating_ctor != NULL)
    _statement = floating_ctor(a->get_op(), std::move(flags), std::move(lhs),
                               std::move(rhs));
  else
    _statement = make_floating(a->get_op(), std::move(flags), std::move(lhs),
                               std::move(rhs));
}

void gdsl::rreil::copy_visitor::visit(prim const *a) {
  vector<std::unique_ptr<variable_limited>> lhs;
  for (auto const &var : a->get_lhs()) {
    var.accept(*this);
    lhs.push_back(std::move(_variable_limited));
  }
  vector<std::unique_ptr<variable_limited>> rhs;
  for (auto const &var : a->get_rhs()) {
    var.accept(*this);
    rhs.push_back(std::move(_variable_limited));
  }
  if (prim_ctor != NULL)
    _statement = prim_ctor(a->get_op(), std::move(lhs), std::move(rhs));
  else
    _statement = make_prim(a->get_op(), std::move(lhs), std::move(rhs));
}

void gdsl::rreil::copy_visitor::visit(arbitrary const *a) {
  if (arbitrary_ctor != NULL)
    _sexpr = arbitrary_ctor();
  else
    _sexpr = make_arbitrary();
}

void gdsl::rreil::copy_visitor::visit(sexpr_cmp const *a) {
  a->get_inner().accept(*this);
  std::unique_ptr<expr_cmp> inner = std::move(_expr_cmp);
  if (sexpr_cmp_ctor != NULL)
    _sexpr = sexpr_cmp_ctor(a->get_size(), std::move(inner));
  else
    _sexpr = make_sexpr(a->get_size(), std::move(inner));
}

void gdsl::rreil::copy_visitor::visit(sexpr_lin const* a) {
  a->get_lin().accept(*this);
  std::unique_ptr<linear> lin = std::move(_linear);
  if (sexpr_lin_ctor != NULL)
    _sexpr = sexpr_lin_ctor(std::move(lin));
  else
    _sexpr = make_sexpr(std::move(lin));
}

void gdsl::rreil::copy_visitor::visit(lin_binop const* a) {
  a->get_lhs().accept(*this);
  std::unique_ptr<linear> lhs = std::move(_linear);
  a->get_rhs().accept(*this);
  std::unique_ptr<linear> rhs = std::move(_linear);
  if (lin_binop_ctor != NULL)
    _linear = lin_binop_ctor(a->get_op(), std::move(lhs), std::move(rhs));
  else
    _linear = make_linear(a->get_op(), std::move(lhs), std::move(rhs));
}

void gdsl::rreil::copy_visitor::visit(lin_imm const* a) {
  if (lin_imm_ctor != NULL)
    _linear = lin_imm_ctor(a->get_imm());
  else
    _linear = make_linear(a->get_imm());
  ;
}

void gdsl::rreil::copy_visitor::visit(lin_scale const* a) {
  a->get_operand().accept(*this);
  std::unique_ptr<linear> opnd = std::move(_linear);
  if (lin_scale_ctor != NULL)
    _linear = lin_scale_ctor(a->get_const(), std::move(opnd));
  else
    _linear = make_linear(a->get_const(), std::move(opnd));
}

void gdsl::rreil::copy_visitor::visit(lin_var const* a) {
  a->get_var().accept(*this);
  std::unique_ptr<variable> var = std::move(_variable);
  if (lin_var_ctor != NULL)
    _linear = lin_var_ctor(std::move(var));
  else
    _linear = make_linear(std::move(var));
}

void gdsl::rreil::copy_visitor::visit(arch_id const* a) {
  if (arch_id_ctor != NULL)
    _id = arch_id_ctor(a->get_name());
  else
    _id = make_id(a->get_name());
}

void gdsl::rreil::copy_visitor::visit(shared_id const* a) {
  if (shared_id_ctor != NULL)
    _id = shared_id_ctor(a->get_inner());
  else
    _id = make_id(a->get_inner());
}

void gdsl::rreil::copy_visitor::visit(_virtual const* a) {
  if (_virtual_ctor != NULL)
    _id = _virtual_ctor(a->get_t(), a->get_opt());
  else
    _id = make_id(a->get_t(), a->get_opt());
}

void gdsl::rreil::copy_visitor::visit(expr_binop const* a) {
  a->get_lhs().accept(*this);
  std::unique_ptr<linear> lhs = std::move(_linear);
  a->get_rhs().accept(*this);
  std::unique_ptr<linear> rhs = std::move(_linear);
  if (expr_binop_ctor != NULL)
    _expr = expr_binop_ctor(a->get_op(), std::move(lhs), std::move(rhs));
  else
    _expr = make_expr(a->get_op(), std::move(lhs), std::move(rhs));
}

void gdsl::rreil::copy_visitor::visit(expr_ext const* a) {
  a->get_operand().accept(*this);
  std::unique_ptr<linear> opnd = std::move(_linear);
  if (expr_ext_ctor != NULL)
    _expr = expr_ext_ctor(a->get_op(), a->get_fromsize(), std::move(opnd));
  else
    _expr = make_expr(a->get_op(), a->get_fromsize(), std::move(opnd));
}

void gdsl::rreil::copy_visitor::visit(expr_sexpr const* a) {
  a->get_inner().accept(*this);
  std::unique_ptr<sexpr> inner = std::move(_sexpr);
  if (expr_sexpr_ctor != NULL)
    _expr = expr_sexpr_ctor(std::move(inner));
  else
    _expr = make_expr(std::move(inner));
}

void gdsl::rreil::copy_visitor::visit(arch_exception const* a) {
  if (arch_exception_ctor != NULL)
    _exception = arch_exception_ctor(a->get_name());
  else
    _exception = make_exception(a->get_name());
}

void gdsl::rreil::copy_visitor::visit(shared_exception const* a) {
  if (shared_exception_ctor != NULL)
    _exception = shared_exception_ctor(a->get_type());
  else
    _exception = make_exception(a->get_type());
}

gdsl::rreil::copy_visitor::~copy_visitor() {}

gdsl::rreil::copy_visitor::copy_visitor() {}
