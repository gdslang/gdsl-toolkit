/*
 * copy.c
 *
 *  Created on: Aug 15, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <rreil/rreil.h>

struct rreil_address *rreil_address_copy(struct rreil_address *address) {
	struct rreil_address *address_copy = (struct rreil_address*)malloc(sizeof(struct rreil_address));

	address_copy->address = rreil_linear_copy(address->address);
	address_copy->size = address->size;

	return address_copy;
}

struct rreil_arity1_sexpr rreil_arity1_sexpr_copy(struct rreil_arity1_sexpr arity1_sexpr) {
	struct rreil_arity1_sexpr arity1_sexpr_copy;

	arity1_sexpr_copy.opnd1 = rreil_sexpr_copy(arity1_sexpr.opnd1);
	arity1_sexpr_copy.size = arity1_sexpr.size;

	return arity1_sexpr_copy;
}

struct rreil_arity1 rreil_arity1_copy(struct rreil_arity1 arity1) {
	struct rreil_arity1 arity1_copy;

	arity1_copy.opnd1 = rreil_linear_copy(arity1.opnd1);
	arity1_copy.size = arity1.size;

	return arity1_copy;
}

struct rreil_arity2 rreil_arity2_copy(struct rreil_arity2 arity2) {
	struct rreil_arity2 arity2_copy;

	arity2_copy.opnd1 = rreil_linear_copy(arity2.opnd1);
	arity2_copy.opnd2 = rreil_linear_copy(arity2.opnd2);
	arity2_copy.size = arity2.size;

	return arity2_copy;
}

enum rreil_branch_hint *rreil_branch_hint_copy(enum rreil_branch_hint *hint) {
	enum rreil_branch_hint *hint_copy = (enum rreil_branch_hint*)malloc(sizeof(enum rreil_branch_hint));

	*hint_copy = *hint;

	return hint_copy;
}

struct rreil_comparator *rreil_comparator_copy(struct rreil_comparator *comparator) {
	struct rreil_comparator *comparator_copy = (struct rreil_comparator*)malloc(sizeof(struct rreil_comparator));

	comparator_copy->arity2 = rreil_arity2_copy(comparator->arity2);
	comparator_copy->type = comparator->type;

	return comparator_copy;
}

struct rreil_id *rreil_id_copy(struct rreil_id *id) {
	struct rreil_id *id_copy = (struct rreil_id*)malloc(sizeof(struct rreil_id));

	*id_copy = *id;

	return id_copy;
}

struct rreil_linear *rreil_linear_copy(struct rreil_linear *linear) {
	struct rreil_linear *linear_copy = (struct rreil_linear*)malloc(sizeof(struct rreil_linear));

	linear_copy->type = linear->type;

	switch(linear->type) {
		case RREIL_LINEAR_TYPE_VARIABLE: {
			linear_copy->variable = rreil_variable_copy(linear->variable);
			break;
		}
		case RREIL_LINEAR_TYPE_IMMEDIATE: {
			linear_copy->immediate = linear->immediate;
			break;
		}
		case RREIL_LINEAR_TYPE_SUM: {
			linear_copy->sum.opnd1 = rreil_linear_copy(linear->sum.opnd1);
			linear_copy->sum.opnd2 = rreil_linear_copy(linear->sum.opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_DIFFERENCE: {
			linear_copy->difference.opnd1 = rreil_linear_copy(linear->difference.opnd1);
			linear_copy->difference.opnd2 = rreil_linear_copy(linear->difference.opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_SCALE: {
			linear_copy->scale.imm = linear->scale.imm;
			linear_copy->scale.opnd = rreil_linear_copy(linear->scale.opnd);
			break;
		}
	}

	return linear_copy;
}

struct rreil_size_change rreil_size_change_copy(struct rreil_size_change size_change) {
	struct rreil_size_change size_change_copy;

	size_change_copy.fromsize = size_change.fromsize;
	size_change_copy.size = size_change.size;
	size_change_copy.opnd = rreil_linear_copy(size_change.opnd);

	return size_change_copy;
}

struct rreil_expr *rreil_op_copy(struct rreil_expr *op) {
	struct rreil_expr *op_copy = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));

	op_copy->type = op->type;

	switch (op->type) {
		case RREIL_EXPR_TYPE_SEXPR: {
			op_copy->sexpr = rreil_arity1_sexpr_copy(op->sexpr);
			break;
		}
		case RREIL_EXPR_TYPE_MUL: {
			op_copy->mul = rreil_arity2_copy(op->mul);
			break;
		}
		case RREIL_EXPR_TYPE_DIV: {
			op_copy->div = rreil_arity2_copy(op->div);
			break;
		}
		case RREIL_EXPR_TYPE_DIVS: {
			op_copy->divs = rreil_arity2_copy(op->divs);
			break;
		}
		case RREIL_EXPR_TYPE_MOD: {
			op_copy->mod = rreil_arity2_copy(op->mod);
			break;
		}
		case RREIL_EXPR_TYPE_SHL: {
			op_copy->shl = rreil_arity2_copy(op->shl);
			break;
		}
		case RREIL_EXPR_TYPE_SHR: {
			op_copy->shr = rreil_arity2_copy(op->shr);
			break;
		}
		case RREIL_EXPR_TYPE_SHRS: {
			op_copy->shrs = rreil_arity2_copy(op->shrs);
			break;
		}
		case RREIL_EXPR_TYPE_AND: {
			op_copy->and_ = rreil_arity2_copy(op->and_);
			break;
		}
		case RREIL_EXPR_TYPE_OR: {
			op_copy->or_ = rreil_arity2_copy(op->or_);
			break;
		}
		case RREIL_EXPR_TYPE_XOR: {
			op_copy->xor_ = rreil_arity2_copy(op->xor_);
			break;
		}
		case RREIL_EXPR_TYPE_SX: {
			op_copy->sx = rreil_size_change_copy(op->sx);
			break;
		}
		case RREIL_EXPR_TYPE_ZX: {
			op_copy->zx = rreil_size_change_copy(op->zx);
			break;
		}
		case RREIL_EXPR_TYPE_ARB: {
			op_copy->arb.size = op->arb.size;
			break;
		}
	}

	return op_copy;
}

struct rreil_sexpr *rreil_sexpr_copy(struct rreil_sexpr *sexpr) {
	struct rreil_sexpr *sexpr_copy = (struct rreil_sexpr*)malloc(sizeof(struct rreil_sexpr));

	sexpr_copy->type = sexpr->type;

	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_LIN: {
			sexpr_copy->lin = rreil_linear_copy(sexpr->lin);
			break;
		}
		case RREIL_SEXPR_TYPE_CMP: {
			sexpr_copy->cmp = rreil_comparator_copy(sexpr->cmp);
			break;
		}
	}

	return sexpr_copy;
}

struct rreil_variable *rreil_variable_copy(struct rreil_variable *variable) {
	struct rreil_variable *variable_copy = (struct rreil_variable*)malloc(sizeof(struct rreil_variable));

	variable_copy->id = rreil_id_copy(variable->id);
	variable_copy->offset = variable->offset;

	return variable_copy;
}

struct rreil_variable_limited *rreil_variable_limited_copy(struct rreil_variable_limited *varl) {
	struct rreil_variable_limited *varl_copy = (struct rreil_variable_limited*)malloc(sizeof(struct rreil_variable_limited));

	varl_copy->id = rreil_id_copy(varl->id);
	varl_copy->offset = varl->offset;
	varl_copy->size = varl->size;

	return varl_copy;
}

struct rreil_variable_limited_tuple *rreil_variable_limited_tuple_copy(struct rreil_variable_limited_tuple *varls) {
	struct rreil_variable_limited_tuple *varls_copy = (struct rreil_variable_limited_tuple*)malloc(sizeof(struct rreil_variable_limited_tuple));

	varls_copy->variables_length = varls->variables_length;
	varls_copy->variables_size = varls->variables_size;
	varls_copy->variables = (struct rreil_variable_limited**)malloc(sizeof(struct rreil_variable_limited*)*varls_copy->variables_size);
	for (size_t i = 0; i < varls->variables_length; ++i)
		varls_copy->variables[i] = rreil_variable_limited_copy(varls->variables[i]);

	return varls_copy;
}

enum rreil_flop *rreil_flop_copy(enum rreil_flop *flop) {
	enum rreil_flop *flop_copy = (enum rreil_flop*)malloc(sizeof(enum rreil_flop));

	*flop_copy = *flop;

	return flop_copy;
}

struct rreil_statement *rreil_statement_copy(struct rreil_statement *statement) {
	struct rreil_statement *statement_copy = (struct rreil_statement*)malloc(sizeof(struct rreil_statement));

	statement_copy->type = statement->type;

	switch (statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			statement_copy->assign.lhs = rreil_variable_copy(statement->assign.lhs);
			statement_copy->assign.rhs = rreil_op_copy(statement->assign.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			statement_copy->load.lhs = rreil_variable_copy(statement->load.lhs);
			statement_copy->load.address = rreil_address_copy(statement->load.address);
			statement_copy->load.size = statement->load.size;
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			statement_copy->store.address = rreil_address_copy(statement->store.address);
			statement_copy->store.rhs = rreil_op_copy(statement->store.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {
			statement_copy->ite.cond = rreil_sexpr_copy(statement->ite.cond);
			statement_copy->ite.then_branch = rreil_statements_copy(statement->ite.then_branch);
			statement_copy->ite.else_branch = rreil_statements_copy(statement->ite.else_branch);
			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {
			statement_copy->while_.cond = rreil_sexpr_copy(statement->while_.cond);
			statement_copy->while_.body = rreil_statements_copy(statement->while_.body);
			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {
			statement_copy->cbranch.cond = rreil_sexpr_copy(statement->cbranch.cond);
			statement_copy->cbranch.target_true = rreil_address_copy(statement->cbranch.target_true);
			statement_copy->cbranch.target_false = rreil_address_copy(statement->cbranch.target_false);
			break;
		}
		case RREIL_STATEMENT_TYPE_BRANCH: {
			statement_copy->branch.hint = rreil_branch_hint_copy(statement->branch.hint);
			statement_copy->branch.target = rreil_address_copy(statement->branch.target);
			break;
		}
		case RREIL_STATEMENT_TYPE_FLOP: {
			statement_copy->flop.op = rreil_flop_copy(statement->flop.op);
			statement_copy->flop.lhs = rreil_variable_limited_copy(statement->flop.lhs);
			statement_copy->flop.rhs = rreil_variable_limited_tuple_copy(statement->flop.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_PRIM: {
			statement_copy->prim.op = statement->prim.op; //String allocated on GDSL heap
			statement_copy->prim.lhs = rreil_variable_limited_tuple_copy(statement->prim.lhs);
			statement_copy->prim.rhs = rreil_variable_limited_tuple_copy(statement->prim.rhs);
			break;
		}
	}

	return statement_copy;
}

struct rreil_statements *rreil_statements_copy(struct rreil_statements *statements) {
	struct rreil_statements *statements_copy = (struct rreil_statements*)malloc(sizeof(struct rreil_statements));

	statements_copy->statements_length = statements->statements_length;
	statements_copy->statements_size = statements->statements_size;
	statements_copy->statements = (struct rreil_statement**)malloc(sizeof(struct rreil_statement*)*statements_copy->statements_size);

	for (size_t i = 0; i < statements->statements_length; ++i)
		statements_copy->statements[i] = rreil_statement_copy(statements->statements[i]);

	return statements_copy;
}
