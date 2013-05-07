/*
 * rreil_print.h
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#ifndef RREIL_PRINT_H_
#define RREIL_PRINT_H_

extern void rreil_address_print(struct rreil_address *address);
extern void rreil_branch_hint_print(enum rreil_branch_hint *hint);
extern void rreil_comparator_print(struct rreil_comparator *comparator);
extern void rreil_id_print(struct rreil_id *id);
extern void rreil_linear_print(struct rreil_linear *linear);
extern void rreil_op_print(struct rreil_op *op);
extern void rreil_sexpr_print(struct rreil_sexpr *sexpr);
extern void rreil_variable_print(struct rreil_variable *variable);
extern void rreil_statement_print(struct rreil_statement *statement);
extern void rreil_statements_print(struct rreil_statements *statements);

#endif /* RREIL_PRINT_H_ */
