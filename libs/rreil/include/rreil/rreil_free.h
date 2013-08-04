/*
 * rreil_free.h
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#ifndef RREIL_FREE_H_
#define RREIL_FREE_H_

extern void rreil_address_free(struct rreil_address *address);
extern void rreil_arity1_clear(struct rreil_arity1 *arity1);
extern void rreil_arity2_clear(struct rreil_arity2 *arity2);
extern void rreil_branch_hint_free(enum rreil_branch_hint *hint);
extern void rreil_comparator_free(struct rreil_comparator *comparator);
extern void rreil_id_free(struct rreil_id *id);
extern void rreil_linear_free(struct rreil_linear *linear);
extern void rreil_size_change_clear(struct rreil_size_change *size_change);
extern void rreil_op_free(struct rreil_op *op);
extern void rreil_sexpr_free(struct rreil_sexpr *sexpr);
extern void rreil_variable_free(struct rreil_variable *variable);
extern void rreil_statement_free(struct rreil_statement *statement);
extern void rreil_statements_free(struct rreil_statements *statements);

#endif /* RREIL_FREE_H_ */
