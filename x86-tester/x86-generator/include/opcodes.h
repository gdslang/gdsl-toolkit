/*
 * opcodes.h
 *
 *  Created on: Apr 29, 2013
 *      Author: jucs
 */

#ifndef OPCODES_H_
#define OPCODES_H_

#include <stdint.h>

struct opcode_table {
	size_t *offsets;
	size_t offsets_length;

	uint8_t *opcodes;
};

extern struct opcode_table *opcodes_opcode_table_build();
extern void opcodes_opcode_table_free(struct opcode_table *table);

#endif /* OPCODES_H_ */
