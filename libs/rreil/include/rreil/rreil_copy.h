/*
 * rreil_free.h
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#include <rreil/rreil.h>

#ifndef RREIL_COPY_H_
#define RREIL_COPY_H_

extern struct rreil_address *rreil_address_copy(struct rreil_address *address);
extern struct rreil_arity1 rreil_arity1_copy(struct rreil_arity1 arity1);
extern struct rreil_arity2 rreil_arity2_copy(struct rreil_arity2 arity2);
extern enum rreil_branch_hint *rreil_branch_hint_copy(enum rreil_branch_hint *hint);
extern struct rreil_comparator *rreil_comparator_copy(struct rreil_comparator *comparator);
extern struct rreil_id *rreil_id_copy(struct rreil_id *id);
extern struct rreil_linear *rreil_linear_copy(struct rreil_linear *linear);
extern struct rreil_size_change rreil_size_change_copy(struct rreil_size_change size_change);
extern struct rreil_expr *rreil_op_copy(struct rreil_expr *op);
extern struct rreil_sexpr *rreil_sexpr_copy(struct rreil_sexpr *sexpr);
extern struct rreil_variable *rreil_variable_copy(struct rreil_variable *variable);
extern struct rreil_statement *rreil_statement_copy(struct rreil_statement *statement);
extern struct rreil_statements *rreil_statements_copy(struct rreil_statements *statements);

#endif /* RREIL_COPY_H_ */
