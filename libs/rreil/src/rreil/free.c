/*
 * rreil.c
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <rreil/rreil.h>

void rreil_address_free(struct rreil_address *address) {
	rreil_linear_free(address->address);
	free(address);
}

void rreil_arity1_clear(struct rreil_arity1 *arity1) {
	rreil_linear_free(arity1->opnd1);
}

void rreil_arity2_clear(struct rreil_arity2 *arity2) {
	rreil_linear_free(arity2->opnd1);
	rreil_linear_free(arity2->opnd2);
}

void rreil_branch_hint_free(enum rreil_branch_hint *hint) {
	free(hint);
}

void rreil_comparator_free(struct rreil_comparator *comparator) {
	rreil_arity2_clear(&comparator->arity2);
	free(comparator);
}

void rreil_id_free(struct rreil_id *id) {
#ifndef GDSL_X86
  if(id->type == RREIL_ID_TYPE_ARCH) {
    free(id->arch);
  }
#endif
	free(id);
}

void rreil_exception_free(struct rreil_exception *exception) {
#ifndef GDSL_X86
  if(exception->type == RREIL_EXCEPTION_TYPE_ARCH) {
    free(exception->arch);
  }
#endif
	free(exception);
}

void rreil_linear_free(struct rreil_linear *linear) {
	switch(linear->type) {
		case RREIL_LINEAR_TYPE_VARIABLE: {
			rreil_variable_free(linear->variable);
			break;
		}
		case RREIL_LINEAR_TYPE_IMMEDIATE: {
			break;
		}
		case RREIL_LINEAR_TYPE_SUM: {
			rreil_linear_free(linear->sum.opnd1);
			rreil_linear_free(linear->sum.opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_DIFFERENCE: {
			rreil_linear_free(linear->difference.opnd1);
			rreil_linear_free(linear->difference.opnd2);
			break;
		}
		case RREIL_LINEAR_TYPE_SCALE: {
			rreil_linear_free(linear->scale.opnd);
			break;
		}
	}
	free(linear);
}

void rreil_size_change_clear(struct rreil_size_change *size_change) {
	rreil_linear_free(size_change->opnd);
}

void rreil_expr_free(struct rreil_expr *expr) {
	switch (expr->type) {
		case RREIL_EXPR_TYPE_SEXPR: {
			rreil_sexpr_free(expr->sexpr);
			break;
		}
		case RREIL_EXPR_TYPE_MUL: {
			rreil_arity2_clear(&expr->mul);
			break;
		}
		case RREIL_EXPR_TYPE_DIV: {
			rreil_arity2_clear(&expr->div);
			break;
		}
		case RREIL_EXPR_TYPE_DIVS: {
			rreil_arity2_clear(&expr->divs);
			break;
		}
		case RREIL_EXPR_TYPE_MOD: {
			rreil_arity2_clear(&expr->mod);
			break;
		}
		case RREIL_EXPR_TYPE_MODS: {
			rreil_arity2_clear(&expr->mods);
			break;
		}
		case RREIL_EXPR_TYPE_SHL: {
			rreil_arity2_clear(&expr->shl);
			break;
		}
		case RREIL_EXPR_TYPE_SHR: {
			rreil_arity2_clear(&expr->shr);
			break;
		}
		case RREIL_EXPR_TYPE_SHRS: {
			rreil_arity2_clear(&expr->shrs);
			break;
		}
		case RREIL_EXPR_TYPE_AND: {
			rreil_arity2_clear(&expr->and_);
			break;
		}
		case RREIL_EXPR_TYPE_OR: {
			rreil_arity2_clear(&expr->or_);
			break;
		}
		case RREIL_EXPR_TYPE_XOR: {
			rreil_arity2_clear(&expr->xor_);
			break;
		}
		case RREIL_EXPR_TYPE_SX: {
			rreil_size_change_clear(&expr->sx);
			break;
		}
		case RREIL_EXPR_TYPE_ZX: {
			rreil_size_change_clear(&expr->zx);
			break;
		}
	}
	free(expr);
}

void rreil_sexpr_free(struct rreil_sexpr *sexpr) {
	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_LIN: {
			rreil_linear_free(sexpr->lin);
			break;
		}
		case RREIL_SEXPR_TYPE_CMP: {
			rreil_comparator_free(sexpr->cmp);
			break;
		}
		case RREIL_SEXPR_TYPE_ARB: {
			break;
		}
	}
	free(sexpr);
}

void rreil_variable_free(struct rreil_variable *variable) {
	rreil_id_free(variable->id);
	free(variable);
}

void rreil_variable_limited_free(struct rreil_variable_limited *varl) {
	rreil_id_free(varl->id);
	free(varl);
}

void rreil_variable_limited_tuple_free(struct rreil_variable_limited_tuple *varls) {
	for (size_t i = 0; i < varls->variables_length; ++i)
		rreil_variable_limited_free(varls->variables[i]);
	free(varls->variables);
	free(varls);
}

void rreil_flop_free(enum rreil_flop *flop) {
	free(flop);
}

void rreil_statement_free(struct rreil_statement *statement) {
	switch (statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			rreil_variable_free(statement->assign.lhs);
			rreil_expr_free(statement->assign.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			rreil_variable_free(statement->load.lhs);
			rreil_address_free(statement->load.address);
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			rreil_address_free(statement->store.address);
			rreil_linear_free(statement->store.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {
			rreil_sexpr_free(statement->ite.cond);
			rreil_statements_free(statement->ite.then_branch);
			rreil_statements_free(statement->ite.else_branch);
			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {
			rreil_sexpr_free(statement->while_.cond);
			rreil_statements_free(statement->while_.body);
			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {
			rreil_sexpr_free(statement->cbranch.cond);
			rreil_address_free(statement->cbranch.target_true);
			rreil_address_free(statement->cbranch.target_false);
			break;
		}
		case RREIL_STATEMENT_TYPE_BRANCH: {
			rreil_branch_hint_free(statement->branch.hint);
			rreil_address_free(statement->branch.target);
			break;
		}
		case RREIL_STATEMENT_TYPE_FLOP: {
			rreil_flop_free(statement->flop.op);
			rreil_variable_free(statement->flop.flags);
			rreil_variable_limited_free(statement->flop.lhs);
			rreil_variable_limited_tuple_free(statement->flop.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_PRIM: {
			//prim->generic.op: allocated on GDSL heap
			rreil_variable_limited_tuple_free(statement->prim.lhs);
			rreil_variable_limited_tuple_free(statement->prim.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_THROW: {
			rreil_exception_free(statement->throw_.exception);
			break;
		}
	}
	free(statement);
}

void rreil_statements_free(struct rreil_statements *statements) {
	for (size_t i = 0; i < statements->statements_length; ++i)
		rreil_statement_free(statements->statements[i]);
	free(statements->statements);
	free(statements);
}
