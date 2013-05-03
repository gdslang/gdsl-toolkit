/*
 * rreil_statement.h
 *
 *  Created on: 03.05.2013
 *      Author: jucs
 */

#ifndef RREIL_STATEMENT_H_
#define RREIL_STATEMENT_H_

#include <stdint.h>
#include <rreil/rreil_variable.h>
#include <rreil/rreil_op.h>
#include <rreil/rreil_address.h>
#include <rreil/rreil_sexpr.h>
#include <rreil/rreil_branch_hint.h>

enum rreil_statement_type {
	RREIL_STATEMENT_TYPE_ASSIGN,
	RREIL_STATEMENT_TYPE_LOAD,
	RREIL_STATEMENT_TYPE_STORE,
	RREIL_STATEMENT_TYPE_ITE,
	RREIL_STATEMENT_TYPE_WHILE,
	RREIL_STATEMENT_TYPE_CBRANCH,
	RREIL_STATEMENT_TYPE_BRANCH
};

struct rreil_statement {
	enum rreil_statement_type type;
	union {
		struct {
			struct rreil_variable *lhs;
			struct rreil_op *rhs;
		} assign;
		struct {
			struct rreil_variable *lhs;
			uint64_t size;
			struct rreil_address *address;
		} load;
		struct {
			struct rreil_address *address;
			struct rreil_op *rhs;
		} store;
		struct {
			struct rreil_sexpr *cond;
			struct rreil_statement *then_branch;
			size_t then_branch_length;
			struct rreil_statement *else_branch;
			size_t else_branch_length;
		} ite;
		struct {
			struct rreil_sexpr *cond;
			struct rreil_statement *body;
			size_t body_length;
		} while_;
		struct {
			struct rreil_sexpr cond;
			struct rreil_address *target_true;
			struct rreil_address *target_false;
		} cbranch;
		struct {
			enum rreil_branch_hint hint;
			struct rreil_address *target_false;
		} branch;
	};
};

#endif /* RREIL_STATEMENT_H_ */
