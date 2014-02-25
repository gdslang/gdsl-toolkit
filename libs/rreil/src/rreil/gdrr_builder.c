/*
 * rreil_builder.c
 *
 *  Created on: 03.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <gdsl.h>
#include <rreil/rreil.h>

#ifdef GDSL_X86
#include <x86.h>
#endif

// sem_id
//static obj_t virt_na(state_t state, int_t con) {
//	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
//	id->type = RREIL_ID_TYPE_VIRTUAL;
//	switch(con) {
//		case CON_VIRT_EQ: {
//			id->virtual_ = RREIL_ID_VIRTUAL_EQ;
//			break;
//		}
//		case CON_VIRT_NEQ: {
//			id->virtual_ = RREIL_ID_VIRTUAL_NEQ;
//			break;
//		}
//		case CON_VIRT_LES: {
//			id->virtual_ = RREIL_ID_VIRTUAL_LES;
//			break;
//		}
//		case CON_VIRT_LEU: {
//			id->virtual_ = RREIL_ID_VIRTUAL_LEU;
//			break;
//		}
//		case CON_VIRT_LTS: {
//			id->virtual_ = RREIL_ID_VIRTUAL_LTS;
//			break;
//		}
//		case CON_VIRT_LTU: {
//			id->virtual_ = RREIL_ID_VIRTUAL_LTU;
//			break;
//		}
//	}
//	return (obj_t)id;
//}
static obj_t shared(state_t state, int_t con) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_SHARED;
	switch (con) {
		case CON_FLOATING_FLAGS: {
			id->shared = RREIL_ID_SHARED_FLOATING_FLAGS;
			break;
		}
	}
	return (obj_t)id;
}
static obj_t virt_t(state_t state, int_t t) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_TEMPORARY;
	id->temporary = t;
	return (obj_t)id;
}

#ifdef GDSL_X86
obj_t sem_id_arch(state_t state, int_t con) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_X86;
	id->x86 = x86_reg_from_con(con);
	return id;
}
#else
obj_t sem_id_arch(state_t state, int_t con) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_ARCH;
	id->arch = (uint32_t)con;
	return id;
}
#endif

// sem_exception
static obj_t exception_shared(state_t state, int_t con) {
	struct rreil_id *id = (struct rreil_id*)malloc(sizeof(struct rreil_id));
	id->type = RREIL_ID_TYPE_SHARED;
	switch (con) {
		case CON_FLOATING_FLAGS: {
			id->shared = RREIL_ID_SHARED_FLOATING_FLAGS;
			break;
		}
	}
	return (obj_t)id;
}

#ifdef GDSL_X86
obj_t exception_arch(state_t state, int_t con) {
	struct rreil_exception *exception = (struct rreil_exception*)malloc(sizeof(struct rreil_exception));
	exception->type = RREIL_EXCEPTION_TYPE_X86;
	exception->x86 = x86_exception_from_con(con);
	return exception;
}
#else
obj_t exception_arch(state_t state, int_t con) {
	struct rreil_exception *exception = (struct rreil_exception*)malloc(sizeof(struct rreil_exception));
	exception->type = RREIL_EXCEPTION_TYPE_ARCH;
	exception->arch = (uint32_t)con;
	return exception;
}
#endif

// sem_address
static obj_t sem_address(state_t state, int_t size,
		obj_t address) {
	struct rreil_address *address_ = (struct rreil_address*)malloc(
			sizeof(struct rreil_address));
	address_->size = size;
	address_->address = (struct rreil_linear*)address;
	return (obj_t)address_;
}

// sem_var
static obj_t sem_var(state_t state, obj_t id, int_t offset) {
	struct rreil_variable *variable = (struct rreil_variable*)malloc(
			sizeof(struct rreil_variable));
	variable->id = (struct rreil_id*)id;
	variable->offset = offset;
	return (obj_t)variable;
}

// sem_linear
static obj_t sem_lin_var(state_t state, obj_t this) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_VARIABLE;
	linear->variable = (struct rreil_variable*)this;
	return (obj_t)linear;
}
static obj_t sem_lin_imm(state_t state, int_t imm) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_IMMEDIATE;
	linear->immediate = imm;
	return (obj_t)linear;
}
static obj_t sem_lin_add(state_t state, obj_t opnd1,
		obj_t opnd2) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_SUM;
	linear->sum.opnd1 = (struct rreil_linear*)opnd1;
	linear->sum.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)linear;
}
static obj_t sem_lin_sub(state_t state, obj_t opnd1,
		obj_t opnd2) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_DIFFERENCE;
	linear->difference.opnd1 = (struct rreil_linear*)opnd1;
	linear->difference.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)linear;
}
static obj_t sem_lin_scale(state_t state, int_t imm,
		obj_t opnd) {
	struct rreil_linear *linear = (struct rreil_linear*)malloc(
			sizeof(struct rreil_linear));
	linear->type = RREIL_LINEAR_TYPE_SCALE;
	linear->scale.imm = imm;
	linear->scale.opnd = (struct rreil_linear*)opnd;
	return (obj_t)linear;
}

// sem_sexpr
static obj_t sem_sexpr_lin(state_t state, obj_t this) {
	struct rreil_sexpr *sexpr = (struct rreil_sexpr*)malloc(
			sizeof(struct rreil_sexpr));
	sexpr->type = RREIL_SEXPR_TYPE_LIN;
	sexpr->lin = (struct rreil_linear*)this;
	return (obj_t)sexpr;
}
static obj_t sem_sexpr_cmp(state_t state, obj_t this) {
	struct rreil_sexpr *sexpr = (struct rreil_sexpr*)malloc(
			sizeof(struct rreil_sexpr));
	sexpr->type = RREIL_SEXPR_TYPE_CMP;
	sexpr->cmp = (struct rreil_comparator*)this;
	return (obj_t)sexpr;
}
static obj_t sem_sexpr_arb(state_t state, obj_t nothing) {
	struct rreil_sexpr *sexpr = (struct rreil_sexpr*)malloc(
			sizeof(struct rreil_sexpr));
	sexpr->type = RREIL_SEXPR_TYPE_ARB;
	return (obj_t)sexpr;
}

// sem_expr_cmp
static obj_t sem_cmpeq(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_EQ;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)comparator;
}
static obj_t sem_cmpneq(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_NEQ;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)comparator;
}
static obj_t sem_cmples(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LES;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)comparator;
}
static obj_t sem_cmpleu(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LEU;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)comparator;
}
static obj_t sem_cmplts(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LTS;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)comparator;
}
static obj_t sem_cmpltu(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_comparator *comparator = (struct rreil_comparator*)malloc(
			sizeof(struct rreil_comparator));
	comparator->type = RREIL_COMPARATOR_TYPE_LTU;
	comparator->arity2.opnd1 = (struct rreil_linear*)opnd1;
	comparator->arity2.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)comparator;
}

// sem_expr
static obj_t sem_sexpr(state_t state, obj_t opnd1) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_SEXPR;
	expr->sexpr = (struct rreil_sexpr*)opnd1;
	return (obj_t)expr;
}
static obj_t sem_mul(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_MUL;
	expr->mul.opnd1 = (struct rreil_linear*)opnd1;
	expr->mul.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_div(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_DIV;
	expr->div.opnd1 = (struct rreil_linear*)opnd1;
	expr->div.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_divs(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_DIVS;
	expr->divs.opnd1 = (struct rreil_linear*)opnd1;
	expr->divs.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_mod(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_MOD;
	expr->mod.opnd1 = (struct rreil_linear*)opnd1;
	expr->mod.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_mods(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_MODS;
	expr->mod.opnd1 = (struct rreil_linear*)opnd1;
	expr->mod.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_shl(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_SHL;
	expr->shl.opnd1 = (struct rreil_linear*)opnd1;
	expr->shl.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_shr(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_SHR;
	expr->shr.opnd1 = (struct rreil_linear*)opnd1;
	expr->shr.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_shrs(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_SHRS;
	expr->shrs.opnd1 = (struct rreil_linear*)opnd1;
	expr->shrs.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_and(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_AND;
	expr->and_.opnd1 = (struct rreil_linear*)opnd1;
	expr->and_.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_or(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_OR;
	expr->or_.opnd1 = (struct rreil_linear*)opnd1;
	expr->or_.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_xor(state_t state, obj_t opnd1, obj_t opnd2) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_XOR;
	expr->xor_.opnd1 = (struct rreil_linear*)opnd1;
	expr->xor_.opnd2 = (struct rreil_linear*)opnd2;
	return (obj_t)expr;
}
static obj_t sem_sx(state_t state, int_t fromsize, obj_t opnd1) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_SX;
	expr->sx.fromsize = fromsize;
	expr->sx.opnd = (struct rreil_linear*)opnd1;
	return (obj_t)expr;
}
static obj_t sem_zx(state_t state, int_t fromsize, obj_t opnd1) {
	struct rreil_expr *expr = (struct rreil_expr*)malloc(sizeof(struct rreil_expr));
	expr->type = RREIL_EXPR_TYPE_ZX;
	expr->zx.fromsize = fromsize;
	expr->zx.opnd = (struct rreil_linear*)opnd1;
	return (obj_t)expr;
}

// sem_varl
static obj_t sem_varl(state_t state, obj_t id, int_t offset, int_t size) {
	struct rreil_variable_limited *variable = (struct rreil_variable_limited*)malloc(sizeof(struct rreil_variable_limited));
	variable->id = (struct rreil_id*)id;
	variable->offset = (uint64_t)offset;
	variable->size = (uint64_t)size;
	return (obj_t)variable;
}

// sem_varls
static obj_t sem_varls_next(state_t state, obj_t next, obj_t list) {
	struct rreil_variable_limited_tuple *variable_tuple = (struct rreil_variable_limited_tuple*)list;
	if(variable_tuple->variables_length >= variable_tuple->variables_size) {
		variable_tuple->variables_size = variable_tuple->variables_size ? (variable_tuple->variables_size << 1) : 4;
		variable_tuple->variables = (struct rreil_variable_limited**)malloc(sizeof(struct rreil_variable_limited*)*variable_tuple->variables_size);
	}
	variable_tuple->variables[variable_tuple->variables_length++] = (struct rreil_variable_limited*)next;
	return (obj_t)variable_tuple;
}
static obj_t sem_varls_init(state_t state, obj_t nothing) {
	struct rreil_variable_limited_tuple *variable_tuple = (struct rreil_variable_limited_tuple*)malloc(sizeof(struct rreil_variable_limited_tuple));
	variable_tuple->variables = NULL;
	variable_tuple->variables_length = 0;
	variable_tuple->variables_size = 0;
	return variable_tuple;
}

// sem_flop
static obj_t sem_flop(state_t state, int_t con) {
	enum rreil_flop *rreil_flop = (enum rreil_flop*)malloc(sizeof(enum rreil_flop));
	switch (con) {
		case CON_SEM_FADD: {
			*rreil_flop = RREIL_FLOP_SEM_FADD;
			break;
		}
		case CON_SEM_FSUB: {
			*rreil_flop = RREIL_FLOP_SEM_FSUB;
			break;
		}
		case CON_SEM_FMUL: {
			*rreil_flop = RREIL_FLOP_SEM_FMUL;
			break;
		}
	}
	return (obj_t)rreil_flop;
}

// sem_stmt
static obj_t sem_assign(state_t state, int_t size, obj_t lhs,
		obj_t rhs) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_ASSIGN;
	statement->assign.size = size;
	statement->assign.lhs = (struct rreil_variable*)lhs;
	statement->assign.rhs = (struct rreil_expr*)rhs;
	return (obj_t)statement;
}
static obj_t sem_load(state_t state, int_t size, obj_t lhs,
		obj_t address) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_LOAD;
	statement->load.size = size;
	statement->load.lhs = (struct rreil_variable*)lhs;
	statement->load.address = (struct rreil_address*)address;
	return (obj_t)statement;
}
static obj_t sem_store(state_t state, int_t size, obj_t address,
		obj_t rhs) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_STORE;
	statement->store.size = size;
	statement->store.address = (struct rreil_address*)address;
	statement->store.rhs = (struct rreil_linear*)rhs;
	return (obj_t)statement;
}
static obj_t sem_ite(state_t state, obj_t cond,
		obj_t then_branch, obj_t else_branch) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_ITE;
	statement->ite.cond = (struct rreil_sexpr*)cond;
	statement->ite.then_branch = (struct rreil_statements*)then_branch;
	statement->ite.else_branch = (struct rreil_statements*)else_branch;
	return (obj_t)statement;
}
static obj_t sem_while(state_t state, obj_t cond,
		obj_t body) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_WHILE;
	statement->while_.cond = (struct rreil_sexpr*)cond;
	statement->while_.body = (struct rreil_statements*)body;
	return (obj_t)statement;
}
static obj_t sem_cbranch(state_t state, obj_t cond,
		obj_t target_true, obj_t target_false) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_CBRANCH;
	statement->cbranch.cond = (struct rreil_sexpr*)cond;
	statement->cbranch.target_true = (struct rreil_address*)target_true;
	statement->cbranch.target_false = (struct rreil_address*)target_false;
	return (obj_t)statement;
}
static obj_t sem_branch(state_t state,
		obj_t branch_hint, obj_t target) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_BRANCH;
	statement->branch.hint = (enum rreil_branch_hint*)branch_hint;
	statement->branch.target = (struct rreil_address*)target;
	return (obj_t)statement;
}
static obj_t sem_flop_stmt(state_t state, obj_t op, obj_t flags, obj_t lhs, obj_t rhs) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_FLOP;
	statement->flop.op = (enum rreil_flop*)op;
	statement->flop.flags = (struct rreil_variable*)flags;
	statement->flop.lhs = (struct rreil_variable_limited*)lhs;
	statement->flop.rhs = (struct rreil_variable_limited_tuple*)rhs;
	return (obj_t)statement;
}
static obj_t sem_prim(state_t state, obj_t op, obj_t lhs, obj_t rhs) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_PRIM;
	statement->prim.op = (char*)op;
	statement->prim.lhs = (struct rreil_variable_limited_tuple*)lhs;
	statement->prim.rhs = (struct rreil_variable_limited_tuple*)rhs;
	return (obj_t)statement;
}
static obj_t sem_throw(state_t state, obj_t exception) {
	struct rreil_statement *statement = (struct rreil_statement*)malloc(
			sizeof(struct rreil_statement));
	statement->type = RREIL_STATEMENT_TYPE_THROW;
	statement->throw_.exception = (struct rreil_exception*)exception;
	return (obj_t)statement;
}

// sem_branch_hint
static obj_t branch_hint(state_t state, int_t con) {
	enum rreil_branch_hint *hint = (enum rreil_branch_hint*)malloc(
			sizeof(enum rreil_branch_hint));
	switch(con) {
		case CON_HINT_JUMP: {
			*hint = RREIL_BRANCH_HINT_JUMP;
			break;
		}
		case CON_HINT_CALL: {
			*hint = RREIL_BRANCH_HINT_CALL;
			break;
		}
		case CON_HINT_RET: {
			*hint = RREIL_BRANCH_HINT_RET;
			break;
		}
	}
	return (obj_t)hint;
}

// sem_stmts
static obj_t sem_stmts_next(state_t state, obj_t next,
		obj_t list) {
	struct rreil_statements *statements = (struct rreil_statements*)list;
	if(statements->statements_length + 1 > statements->statements_size) {
		statements->statements_size =
				statements->statements_size ? statements->statements_size << 1 : 4;
		statements->statements = (struct rreil_statement**)realloc(
				statements->statements,
				statements->statements_size * sizeof(struct rreil_statement*));
	}
	statements->statements[statements->statements_length++] =
			(struct rreil_statement*)next;
	return (obj_t)statements;
}
static obj_t sem_stmts_init(state_t state, obj_t nothing) {
	struct rreil_statements *statements = (struct rreil_statements*)malloc(
			sizeof(struct rreil_statements));
	statements->statements = NULL;
	statements->statements_length = 0;
	statements->statements_size = 0;
	return (obj_t)statements;
}

callbacks_t rreil_gdrr_builder_callbacks_get(state_t state) {
	unboxed_sem_id_callbacks_t sem_id_callbacks = {
			.shared = &shared,
			.virt_t = &virt_t,
			.arch = &sem_id_arch
	};

	unboxed_sem_exception_callbacks_t sem_exception_callbacks = {
			.shared = &exception_shared,
			.arch = &exception_arch
	};

	unboxed_sem_address_callbacks_t sem_address_callbacks = {
			.sem_address_ = &sem_address
	};

	unboxed_sem_var_callbacks_t sem_var_callbacks = {
			.sem_var_ = &sem_var
	};

	unboxed_sem_linear_callbacks_t sem_linear_callbacks = {
			.sem_lin_var = &sem_lin_var,
			.sem_lin_imm = &sem_lin_imm,
			.sem_lin_add = &sem_lin_add,
			.sem_lin_sub = &sem_lin_sub,
			.sem_lin_scale = &sem_lin_scale
	};

	unboxed_sem_sexpr_callbacks_t sem_sexpr_callbacks = {
			.sem_sexpr_lin = &sem_sexpr_lin,
			.sem_sexpr_cmp = &sem_sexpr_cmp,
			.sem_sexpr_arb = &sem_sexpr_arb
	};

	unboxed_sem_expr_cmp_callbacks_t sem_expr_cmp_callbacks = {
			.sem_cmpeq = &sem_cmpeq,
			.sem_cmpneq = &sem_cmpneq,
			.sem_cmples = &sem_cmples,
			.sem_cmpleu = &sem_cmpleu,
			.sem_cmplts = &sem_cmplts,
			.sem_cmpltu = &sem_cmpltu
	};

	unboxed_sem_expr_callbacks_t sem_expr_callbacks = {
			.sem_sexpr = &sem_sexpr,
			.sem_mul = &sem_mul,
			.sem_div = &sem_div,
			.sem_divs = &sem_divs,
			.sem_mod = &sem_mod,
			.sem_mods = &sem_mods,
			.sem_shl = &sem_shl,
			.sem_shr = &sem_shr,
			.sem_shrs = &sem_shrs,
			.sem_and = &sem_and,
			.sem_or = &sem_or,
			.sem_xor = &sem_xor,
			.sem_sx = &sem_sx,
			.sem_zx = &sem_zx
	};

	unboxed_sem_varl_callbacks_t sem_varl_callbacks = {
			.sem_varl_ = &sem_varl
	};

	unboxed_sem_varls_callbacks_t sem_varls_callbacks = {
			.sem_varls_next = &sem_varls_next,
			.sem_varls_init = &sem_varls_init
	};

	unboxed_sem_flop_callbacks_t sem_flop_callbacks = {
			.sem_flop_ = &sem_flop
	};

	unboxed_sem_stmt_callbacks_t sem_stmt_callbacks = {
			.sem_assign = &sem_assign,
			.sem_load = &sem_load,
			.sem_store = &sem_store,
			.sem_ite = &sem_ite,
			.sem_while = &sem_while,
			.sem_cbranch = &sem_cbranch,
			.sem_branch = &sem_branch,
			.sem_flop = &sem_flop_stmt,
			.sem_prim = &sem_prim,
			.sem_throw = &sem_throw
	};

	unboxed_branch_hint_callbacks_t branch_hint_callbacks = {
			.branch_hint_ = &branch_hint
	};

//	unboxed_sem_stmts_list_callbacks_t sem_stmts_list_callbacks = {
//			.list_init = &list_init,
//			.list_next = &list_next
//	};

	unboxed_sem_stmts_callbacks_t sem_stmts_callbacks = {
			.sem_stmts_next = &sem_stmts_next,
			.sem_stmts_init = &sem_stmts_init
	};

	struct unboxed_callbacks {
		unboxed_callbacks_t callbacks;

		unboxed_sem_id_callbacks_t sem_id_callbacks;
		unboxed_sem_address_callbacks_t sem_address_callbacks;
		unboxed_sem_var_callbacks_t sem_var_callbacks;
		unboxed_sem_linear_callbacks_t sem_linear_callbacks;
		unboxed_sem_sexpr_callbacks_t sem_sexpr_callbacks;
		unboxed_sem_expr_cmp_callbacks_t sem_expr_cmp_callbacks;
		unboxed_sem_expr_callbacks_t sem_expr_callbacks;
		unboxed_sem_varl_callbacks_t sem_varl_callbacks;
		unboxed_sem_varls_callbacks_t sem_varls_callbacks;
		unboxed_sem_flop_callbacks_t sem_flop_callbacks;
		unboxed_sem_stmt_callbacks_t sem_stmt_callbacks;
		unboxed_branch_hint_callbacks_t branch_hint_callbacks;
		unboxed_sem_exception_callbacks_t sem_exception_callbacks;
		unboxed_sem_stmts_callbacks_t sem_stmts_callbacks;
	};

	struct unboxed_callbacks *callbacks_heap = (struct unboxed_callbacks*)malloc(sizeof(struct unboxed_callbacks));
	callbacks_heap->sem_id_callbacks = sem_id_callbacks;
	callbacks_heap->sem_address_callbacks = sem_address_callbacks;
	callbacks_heap->sem_var_callbacks = sem_var_callbacks;
	callbacks_heap->sem_linear_callbacks = sem_linear_callbacks;
	callbacks_heap->sem_sexpr_callbacks = sem_sexpr_callbacks;
	callbacks_heap->sem_expr_cmp_callbacks = sem_expr_cmp_callbacks;
	callbacks_heap->sem_expr_callbacks = sem_expr_callbacks;
	callbacks_heap->sem_varl_callbacks = sem_varl_callbacks;
	callbacks_heap->sem_varls_callbacks = sem_varls_callbacks;
	callbacks_heap->sem_flop_callbacks = sem_flop_callbacks;
	callbacks_heap->sem_stmt_callbacks = sem_stmt_callbacks;
	callbacks_heap->branch_hint_callbacks = branch_hint_callbacks;
	callbacks_heap->sem_exception_callbacks = sem_exception_callbacks;
	callbacks_heap->sem_stmts_callbacks = sem_stmts_callbacks;

	unboxed_callbacks_t callbacks = {
			.sem_id = &callbacks_heap->sem_id_callbacks,
			.sem_address = &callbacks_heap->sem_address_callbacks,
			.sem_var = &callbacks_heap->sem_var_callbacks,
			.sem_linear = &callbacks_heap->sem_linear_callbacks,
			.sem_sexpr = &callbacks_heap->sem_sexpr_callbacks,
			.sem_expr_cmp = &callbacks_heap->sem_expr_cmp_callbacks,
			.sem_expr = &callbacks_heap->sem_expr_callbacks,
			.sem_varl = &callbacks_heap->sem_varl_callbacks,
			.sem_varls = &callbacks_heap->sem_varls_callbacks,
			.sem_flop = &callbacks_heap->sem_flop_callbacks,
			.sem_stmt = &callbacks_heap->sem_stmt_callbacks,
			.branch_hint = &callbacks_heap->branch_hint_callbacks,
			.sem_exception = &callbacks_heap->sem_exception_callbacks,
			.sem_stmts = &callbacks_heap->sem_stmts_callbacks
	};

	callbacks_heap->callbacks = callbacks;

//		config.callbacks.sem_stmts.sem_cons = &sem_cons;
//		config.callbacks.sem_stmts.sem_nil = &sem_nil;
//		config.gdrr_config_stmts_handling = GDRR_CONFIG_STMTS_HANDLING_RECURSIVE;

	return &callbacks_heap->callbacks;
}
