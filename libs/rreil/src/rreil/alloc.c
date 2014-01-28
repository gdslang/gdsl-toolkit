/*
 * alloc.c
 *
 *  Created on: Jan 28, 2014
 *      Author: jucs
 */
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

struct rreil_id *rreil_temporary_alloc(long long unsigned temporary) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_TEMPORARY;
	id->temporary = temporary;
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
