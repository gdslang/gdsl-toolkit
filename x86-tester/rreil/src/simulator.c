/*
 * simulator.c
 *
 *  Created on: 07.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <rreil/rreil.h>
#include <simulator.h>
#include <simulator_regacc.h>

void rreil_variable_write(struct simulator_context *context,
		struct rreil_variable *variable, size_t bit_length, uint8_t *buffer) {
	simulator_register_write(context, variable->id, buffer, bit_length,
			variable->offset);
}

size_t rreil_op_simulate(struct simulator_context *context, uint8_t **buffer,
		struct rreil_op *op) {

}

void rreil_statement_simulate(struct simulator_context *context,
		struct rreil_statement *statement) {
	switch(statement->type) {
		case RREIL_STATEMENT_TYPE_ASSIGN: {
			uint8_t *buffer;
			size_t bit_length = rreil_op_simulate(context, &buffer,
					statement->assign.rhs);
			rreil_variable_write(context, statement->assign.lhs, bit_length, buffer);
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

void rreil_statements_simulate(struct simulator_context *context,
		struct rreil_statements *statements) {
	for(size_t i = 0; i < statements->statements_length; ++i)
		rreil_statement_simulate(context, statements->statements[i]);
}
