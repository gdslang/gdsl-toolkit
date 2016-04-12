/*
 * alloc.c
 *
 *  Created on: Jan 28, 2014
 *      Author: jucs
 */
#include <rreil/rreil_address.h>
#include <rreil/rreil_branch_hint.h>
#include <rreil/rreil_expr.h>
#include <rreil/rreil_id.h>
#include <rreil/rreil_linear.h>
#include <rreil/rreil_sexpr.h>
#include <rreil/rreil_statement.h>
#include <rreil/rreil_variable.h>

struct rreil_statement *rreil_assignment_alloc(long long unsigned int size, struct rreil_variable *lhs,
    struct rreil_expr *rhs) {
  struct rreil_statement *stmt = (struct rreil_statement*)malloc(sizeof(struct rreil_statement));
  stmt->type = RREIL_STATEMENT_TYPE_ASSIGN;
  stmt->assign.size = size;
  stmt->assign.lhs = lhs;
  stmt->assign.rhs = rhs;
  return stmt;
}

struct rreil_statement *rreil_store_alloc(long long unsigned int size, struct rreil_address *address,
    struct rreil_linear *rhs) {
  struct rreil_statement *stmt = (struct rreil_statement*)malloc(sizeof(struct rreil_statement));
  stmt->type = RREIL_STATEMENT_TYPE_STORE;
  stmt->store.size = size;
  stmt->store.address = address;
  stmt->store.rhs = rhs;
  return stmt;
}

struct rreil_statement *rreil_load_alloc(long long unsigned int size, struct rreil_variable *lhs,
    struct rreil_address *address) {
  struct rreil_statement *stmt = (struct rreil_statement*)malloc(sizeof(struct rreil_statement));
  stmt->type = RREIL_STATEMENT_TYPE_LOAD;
  stmt->load.size = size;
  stmt->load.lhs = lhs;
  stmt->load.address = address;
  return stmt;
}

struct rreil_statement *rreil_branch_alloc(enum rreil_branch_hint hint, struct rreil_address *target) {
  enum rreil_branch_hint *hint_heap = (enum rreil_branch_hint *)malloc(sizeof(enum rreil_branch_hint));
  *hint_heap = hint;
  struct rreil_statement *stmt = (struct rreil_statement*)malloc(sizeof(struct rreil_statement));
  stmt->type = RREIL_STATEMENT_TYPE_BRANCH;
  stmt->branch.hint = hint_heap;
  stmt->branch.target = target;
  return stmt;
}

struct rreil_statement *rreil_cbranch_alloc(struct rreil_sexpr *cond, struct rreil_address *target_true,
    struct rreil_address *target_false) {
  struct rreil_statement *stmt = (struct rreil_statement*)malloc(sizeof(struct rreil_statement));
  stmt->type = RREIL_STATEMENT_TYPE_CBRANCH;
  stmt->cbranch.cond = cond;
  stmt->cbranch.target_true = target_true;
  stmt->cbranch.target_false = target_false;
  return stmt;
}

struct rreil_id *rreil_temporary_alloc(long long unsigned temporary, char opt) {
  struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
  id->type = RREIL_ID_TYPE_TEMPORARY;
  id->temporary = temporary;
  id->opt = opt;
  return id;
}

struct rreil_variable *rreil_variable_alloc(struct rreil_id *id, long long unsigned offset) {
  struct rreil_variable *variable = (struct rreil_variable*)malloc(sizeof(struct rreil_variable));
  variable->id = id;
  variable->offset = offset;
  return variable;
}

struct rreil_linear *rreil_linear_variable_alloc(struct rreil_variable *variable) {
  struct rreil_linear *linear = (struct rreil_linear*)malloc(sizeof(struct rreil_linear));
  linear->type = RREIL_LINEAR_TYPE_VARIABLE;
  linear->variable = variable;
  return linear;
}

struct rreil_linear *rreil_linear_immediate_alloc(long long unsigned int immediate) {
  struct rreil_linear *linear = (struct rreil_linear*)malloc(sizeof(struct rreil_linear));
  linear->type = RREIL_LINEAR_TYPE_IMMEDIATE;
  linear->immediate = immediate;
  return linear;
}

struct rreil_linear *rreil_linear_sum_alloc(struct rreil_linear *l1, struct rreil_linear *l2) {
  struct rreil_linear *linear = (struct rreil_linear*)malloc(sizeof(struct rreil_linear));
  linear->type = RREIL_LINEAR_TYPE_SUM;
  linear->sum.opnd1 = l1;
  linear->sum.opnd2 = l2;
  return linear;
}

struct rreil_linear *rreil_linear_difference_alloc(struct rreil_linear *l1, struct rreil_linear *l2) {
  struct rreil_linear *linear = (struct rreil_linear*)malloc(sizeof(struct rreil_linear));
  linear->type = RREIL_LINEAR_TYPE_DIFFERENCE;
  linear->difference.opnd1 = l1;
  linear->difference.opnd2 = l2;
  return linear;
}

struct rreil_linear *rreil_linear_scale_alloc(long long unsigned int scale, struct rreil_linear *l2) {
  struct rreil_linear *linear = (struct rreil_linear*)malloc(sizeof(struct rreil_linear));
  linear->type = RREIL_LINEAR_TYPE_SCALE;
  linear->scale.imm = scale;
  linear->scale.opnd = l2;
  return linear;
}

struct rreil_sexpr *rreil_sexpr_linear_alloc(struct rreil_linear *linear) {
  struct rreil_sexpr *sexpr = (struct rreil_sexpr*)malloc(sizeof(struct rreil_sexpr));
  sexpr->type = RREIL_SEXPR_TYPE_LIN;
  sexpr->lin = linear;
  return sexpr;
}

struct rreil_expr *rreil_expr_sexpr_alloc(struct rreil_sexpr *sexpr) {
  struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
  expr->type = RREIL_EXPR_TYPE_SEXPR;
  expr->sexpr = sexpr;
  return expr;
}

struct rreil_address *rreil_address_alloc(long long unsigned int size, struct rreil_linear *addr_lin) {
  struct rreil_address *address = (struct rreil_address*)malloc(sizeof(struct rreil_address));
  address->size = size;
  address->address = addr_lin;
  return address;
}
