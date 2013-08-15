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
	comparator_copy->type = rreil_arity2_copy(comparator->arity2);

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

void rreil_size_change_clear(struct rreil_size_change *size_change) {
	rreil_linear_free(size_change->opnd);
}

void rreil_op_free(struct rreil_op *op) {
	switch (op->type) {
		case RREIL_OP_TYPE_LIN: {
			rreil_arity1_clear(&op->lin);
			break;
		}
		case RREIL_OP_TYPE_MUL: {
			rreil_arity2_clear(&op->mul);
			break;
		}
		case RREIL_OP_TYPE_DIV: {
			rreil_arity2_clear(&op->div);
			break;
		}
		case RREIL_OP_TYPE_DIVS: {
			rreil_arity2_clear(&op->divs);
			break;
		}
		case RREIL_OP_TYPE_MOD: {
			rreil_arity2_clear(&op->mod);
			break;
		}
		case RREIL_OP_TYPE_SHL: {
			rreil_arity2_clear(&op->shl);
			break;
		}
		case RREIL_OP_TYPE_SHR: {
			rreil_arity2_clear(&op->shr);
			break;
		}
		case RREIL_OP_TYPE_SHRS: {
			rreil_arity2_clear(&op->shrs);
			break;
		}
		case RREIL_OP_TYPE_AND: {
			rreil_arity2_clear(&op->and_);
			break;
		}
		case RREIL_OP_TYPE_OR: {
			rreil_arity2_clear(&op->or_);
			break;
		}
		case RREIL_OP_TYPE_XOR: {
			rreil_arity2_clear(&op->xor_);
			break;
		}
		case RREIL_OP_TYPE_SX: {
			rreil_size_change_clear(&op->sx);
			break;
		}
		case RREIL_OP_TYPE_ZX: {
			rreil_size_change_clear(&op->zx);
			break;
		}
		case RREIL_OP_TYPE_CMP: {
			rreil_comparator_free(op->cmp);
			break;
		}
		case RREIL_OP_TYPE_ARB: {
			break;
		}
	}
	free(op);
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
	}
	free(sexpr);
}

void rreil_variable_free(struct rreil_variable *variable) {
	rreil_id_free(variable->id);
	free(variable);
}

void rreil_statement_free(struct rreil_statement *statement) {
	switch (statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			rreil_variable_free(statement->assign.lhs);
			rreil_op_free(statement->assign.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			rreil_variable_free(statement->load.lhs);
			rreil_address_free(statement->load.address);
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			rreil_address_free(statement->store.address);
			rreil_op_free(statement->store.rhs);
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
	}
	free(statement);
}

void rreil_statements_free(struct rreil_statements *statements) {
	for (size_t i = 0; i < statements->statements_length; ++i)
		rreil_statement_free(statements->statements[i]);
	free(statements->statements);
	free(statements);
}
