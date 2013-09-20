/*
 * rreil_print.c
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <rreil/rreil.h>

#ifdef GDSL_X86
#include <x86.h>
#endif

void rreil_address_print(struct rreil_address *address) {
	printf("{%lu} ", address->size);
	rreil_linear_print(address->address);
}

void rreil_branch_hint_print(enum rreil_branch_hint *hint) {
	switch(*hint) {
		case RREIL_BRANCH_HINT_JUMP: {
			printf("JUMP");
			break;
		}
		case RREIL_BRANCH_HINT_CALL: {
			printf("CALL");
			break;
		}
		case RREIL_BRANCH_HINT_RET: {
			printf("RET");
			break;
		}
	}
}

void rreil_comparator_print(struct rreil_comparator *comparator) {
	printf("{%lu->1} ", comparator->arity2.size);
	rreil_linear_print(comparator->arity2.opnd1);
	switch(comparator->type) {
		case RREIL_COMPARATOR_TYPE_EQ: {
			printf(" == ");
			break;
		}
		case RREIL_COMPARATOR_TYPE_NEQ: {
			printf(" != ");
			break;
		}
		case RREIL_COMPARATOR_TYPE_LES: {
			printf(" <=s ");
			break;
		}
		case RREIL_COMPARATOR_TYPE_LEU: {
			printf(" <=u ");
			break;
		}
		case RREIL_COMPARATOR_TYPE_LTS: {
			printf(" <s ");
			break;
		}
		case RREIL_COMPARATOR_TYPE_LTU: {
			printf(" <u ");
			break;
		}
	}
	rreil_linear_print(comparator->arity2.opnd2);
}

void rreil_id_print(FILE *stream, struct rreil_id *id) {
	switch(id->type) {
		case RREIL_ID_TYPE_SHARED: {
			switch(id->shared) {
				case RREIL_ID_SHARED_FLOATING_FLAGS: {
					fprintf(stream, "FLOATING_FLAGS");
					break;
				}
			}
			break;
		}
		case RREIL_ID_TYPE_TEMPORARY: {
			fprintf(stream, "T%lu", id->temporary);
			break;
		}
#ifdef GDSL_X86
		case RREIL_ID_TYPE_X86: {
			x86_id_print(stream, id->x86);
			break;
		}
#else
			case RREIL_ID_TYPE_ARCH: {
				fprintf(stream, "arch#%u", id->arch);
			}
#endif
	}
}

void rreil_linear_print(struct rreil_linear *linear) {
	switch(linear->type) {
		case RREIL_LINEAR_TYPE_VARIABLE: {
			rreil_variable_print(stdout, linear->variable);
			break;
		}
		case RREIL_LINEAR_TYPE_IMMEDIATE: {
			printf("%lu", linear->immediate);
			break;
		}
		case RREIL_LINEAR_TYPE_SUM: {
			printf("(");
			rreil_linear_print(linear->sum.opnd1);
			printf(" + ");
			rreil_linear_print(linear->sum.opnd2);
			printf(")");
			break;
		}
		case RREIL_LINEAR_TYPE_DIFFERENCE: {
			printf("(");
			rreil_linear_print(linear->difference.opnd1);
			printf(" - ");
			rreil_linear_print(linear->difference.opnd2);
			printf(")");
			break;
		}
		case RREIL_LINEAR_TYPE_SCALE: {
			printf("%lu*", linear->scale.imm);
			rreil_linear_print(linear->scale.opnd);
			break;
		}
	}
}

void rreil_op_print(struct rreil_expr *op) {
	switch(op->type) {
		case RREIL_EXPR_TYPE_SEXPR: {
			printf("{%lu} ", op->sexpr.size);
			rreil_sexpr_print(op->sexpr.opnd1);
			break;
		}
		case RREIL_EXPR_TYPE_MUL: {
			printf("{%lu} ", op->mul.size);
			rreil_linear_print(op->mul.opnd1);
			printf(" * ");
			rreil_linear_print(op->mul.opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_DIV: {
			printf("{%lu} ", op->div.size);
			rreil_linear_print(op->div.opnd1);
			printf(" /u ");
			rreil_linear_print(op->div.opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_DIVS: {
			printf("{%lu} ", op->divs.size);
			rreil_linear_print(op->divs.opnd1);
			printf(" /s ");
			rreil_linear_print(op->divs.opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_MOD: {
			printf("{%lu} ", op->mod.size);
			rreil_linear_print(op->mod.opnd1);
			printf(" %% ");
			rreil_linear_print(op->mod.opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_SHL: {
			printf("{%lu} ", op->shl.size);
			rreil_linear_print(op->shl.opnd1);
			printf(" << ");
			rreil_linear_print(op->shl.opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_SHR: {
			printf("{%lu} ", op->shr.size);
			rreil_linear_print(op->shr.opnd1);
			printf(" >>u ");
			rreil_linear_print(op->shr.opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_SHRS: {
			printf("{%lu} ", op->shrs.size);
			rreil_linear_print(op->shrs.opnd1);
			printf(" >>s ");
			rreil_linear_print(op->shrs.opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_AND: {
			printf("{%lu} ", op->and_.size);
			rreil_linear_print(op->and_.opnd1);
			printf(" & ");
			rreil_linear_print(op->and_.opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_OR: {
			printf("{%lu} ", op->or_.size);
			rreil_linear_print(op->or_.opnd1);
			printf(" | ");
			rreil_linear_print(op->or_.opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_XOR: {
			printf("{%lu} ", op->xor_.size);
			rreil_linear_print(op->xor_.opnd1);
			printf(" ^ ");
			rreil_linear_print(op->xor_.opnd2);
			break;
		}
		case RREIL_EXPR_TYPE_SX: {
			printf("{%lu->s%lu} ", op->sx.fromsize, op->sx.size);
			rreil_linear_print(op->sx.opnd);
			break;
		}
		case RREIL_EXPR_TYPE_ZX: {
			printf("{%lu->u%lu} ", op->zx.fromsize, op->zx.size);
			rreil_linear_print(op->zx.opnd);
			break;
		}
	}
}

void rreil_sexpr_print(struct rreil_sexpr *sexpr) {
	switch(sexpr->type) {
		case RREIL_SEXPR_TYPE_LIN: {
			rreil_linear_print(sexpr->lin);
			break;
		}
		case RREIL_SEXPR_TYPE_CMP: {
			rreil_comparator_print(sexpr->cmp);
			break;
		}
		case RREIL_SEXPR_TYPE_ARB: {
			printf("arbitrary");
			break;
		}
	}
}

void rreil_variable_print(FILE *stream, struct rreil_variable *variable) {
	rreil_id_print(stream, variable->id);
	if(variable->offset)
		fprintf(stream, "/%lu", variable->offset);
}

void rreil_varl_print(FILE *stream, struct rreil_variable_limited *varl) {
	rreil_id_print(stream, varl->id);
	if(varl->offset)
		fprintf(stream, "/%lu", varl->offset);
	fprintf(stream, ":%lu", varl->size);
}

void rreil_varls_print(FILE *stream, struct rreil_variable_limited_tuple *varls) {
	if(varls->variables_length > 1)
		fprintf(stream, "(");
	for(size_t i = 0; i < varls->variables_length; ++i) {
		if(i)
			fprintf(stream, ", ");
		rreil_varl_print(stream, varls->variables[i]);
	}
	if(varls->variables_length > 1)
		fprintf(stream, ")");
}

void rreil_flop_print(FILE *stream, enum rreil_flop *flop) {
	switch(*flop) {
		case RREIL_FLOP_SEM_FADD: {
			fprintf(stream, "FADD");
			break;
		}
		case RREIL_FLOP_SEM_FSUB: {
			fprintf(stream, "FSUB");
			break;
		}
		case RREIL_FLOP_SEM_FMUL: {
			fprintf(stream, "FMUL");
			break;
		}
	}
}

void rreil_statement_print(struct rreil_statement *statement) {
	switch(statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			rreil_variable_print(stdout, statement->assign.lhs);
			printf(" = ");
			rreil_op_print(statement->assign.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_LOAD: {
			rreil_variable_print(stdout, statement->load.lhs);
			printf(" = {%lu} *(", statement->load.size);
			rreil_address_print(statement->load.address);
			printf(")");
			break;
		}
		case RREIL_STATEMENT_TYPE_STORE: {
			printf("*(");
			rreil_address_print(statement->store.address);
			printf(") = ");
			rreil_op_print(statement->store.rhs);
			break;
		}
		case RREIL_STATEMENT_TYPE_ITE: {
			printf("if(");
			rreil_sexpr_print(statement->ite.cond);
			printf(") {\n");
			rreil_statements_print(statement->ite.then_branch);
			printf("} else {\n");
			rreil_statements_print(statement->ite.else_branch);
			printf("}");
			break;
		}
		case RREIL_STATEMENT_TYPE_WHILE: {
			printf("while(");
			rreil_sexpr_print(statement->while_.cond);
			printf(") {\n");
			rreil_statements_print(statement->while_.body);
			printf("}");
			break;
		}
		case RREIL_STATEMENT_TYPE_CBRANCH: {
			printf("if(");
			rreil_sexpr_print(statement->cbranch.cond);
			printf(") { goto");
			rreil_address_print(statement->cbranch.target_true);
			printf(" } else { goto");
			rreil_address_print(statement->cbranch.target_false);
			printf(" }");
			break;
		}
		case RREIL_STATEMENT_TYPE_BRANCH: {
			printf("goto [");
			rreil_branch_hint_print(statement->branch.hint);
			printf("] ");
			rreil_address_print(statement->branch.target);
			break;
		}
		case RREIL_STATEMENT_TYPE_FLOP: {
			rreil_varl_print(stdout, statement->flop.lhs);
			fprintf(stdout, " = $");
			rreil_flop_print(stdout, statement->flop.op);
			fprintf(stdout, " ");
			rreil_varls_print(stdout, statement->flop.rhs);
			fprintf(stdout, " [flags:");
			rreil_variable_print(stdout, statement->flop.flags);
			fprintf(stdout, "]");
			break;
		}
		case RREIL_STATEMENT_TYPE_PRIM: {
			rreil_varls_print(stdout, statement->prim.lhs);
			fprintf(stdout, " = $%s ", statement->prim.op);
			rreil_varls_print(stdout, statement->prim.rhs);
			break;
		}
	}
}

void rreil_statements_print(struct rreil_statements *statements) {
	for(size_t i = 0; i < statements->statements_length; ++i) {
		rreil_statement_print(statements->statements[i]);
		printf("\n");
	}
}
