/*
 * rreil_print.c
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#include <rreil/rreil.h>

void rreil_address_print(struct rreil_address *address) {
}

void rreil_arity1_clear(struct rreil_arity1 *arity1) {
}

void rreil_arity2_clear(struct rreil_arity2 *arity2) {
}

void rreil_branch_hint_print(enum rreil_branch_hint *hint) {
}

void rreil_comparator_print(struct rreil_comparator *comparator) {
}

void rreil_id_print(struct rreil_id *id) {

}

void rreil_linear_print(struct rreil_linear *linear) {
	switch(linear->type) {
		case RREIL_LINEAR_TYPE_VARIABLE: {
			break;
		}
		case RREIL_LINEAR_TYPE_IMMEDIATE: {
			break;
		}
		case RREIL_LINEAR_TYPE_SUM: {
			break;
		}
		case RREIL_LINEAR_TYPE_DIFFERENCE: {
			break;
		}
		case RREIL_LINEAR_TYPE_SCALE: {
			break;
		}
	}
}

void rreil_size_change_clear(struct rreil_size_change *size_change) {
}

void rreil_op_print(struct rreil_op *op) {
	switch(op->type) {
		case RREIL_OP_TYPE_LIN: {
			break;
		}
		case RREIL_OP_TYPE_MUL: {
			break;
		}
		case RREIL_OP_TYPE_DIV: {
			break;
		}
		case RREIL_OP_TYPE_DIVS: {
			break;
		}
		case RREIL_OP_TYPE_MOD: {
			break;
		}
		case RREIL_OP_TYPE_SHL: {
			break;
		}
		case RREIL_OP_TYPE_SHR: {
			break;
		}
		case RREIL_OP_TYPE_SHRS: {
			break;
		}
		case RREIL_OP_TYPE_AND: {
			break;
		}
		case RREIL_OP_TYPE_OR: {
			break;
		}
		case RREIL_OP_TYPE_XOR: {
			break;
		}
		case RREIL_OP_TYPE_SX: {
			break;
		}
		case RREIL_OP_TYPE_ZX: {
			break;
		}
		case RREIL_OP_TYPE_CMP: {
			break;
		}
		case RREIL_OP_TYPE_ARB: {
			break;
		}
	}
}

void rreil_sexpr_print(struct rreil_sexpr *sexpr) {
	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_LIN: {
			break;
		}
		case RREIL_SEXPR_TYPE_CMP: {
			break;
		}
	}
}

void rreil_variable_print(struct rreil_variable *variable) {
}

void rreil_statement_print(struct rreil_statement *statement) {
	switch(statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {
			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {
			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {
			break;
		}
		case RREIL_STATEMENT_TYPE_BRANCH: {
			break;
		}
	}
}

void rreil_statements_print(struct rreil_statements *statements) {
	for(size_t i = 0; i < statements->statements_length; ++i)
		;
}
