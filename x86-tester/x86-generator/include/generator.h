/*
 * generator.h
 *
 *  Created on: Apr 29, 2013
 *      Author: jucs
 */

#ifndef GENERATOR_H_
#define GENERATOR_H_

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <x86_opcodes.h>
#include <generator_tree.h>

typedef size_t (generator_function_t)(FILE *stream);

enum generator_type {
	GENERATOR_TYPE_PREFIXES,
	GENERATOR_TYPE_OPCODE,
	GENERATOR_TYPE_MODRM,
	GENERATOR_TYPE_IMMEDIATE,
	GENERATOR_TYPE_REX,
	GENERATOR_TYPE_VEX
};

struct generator {
	enum generator_type type;
	void *data;
};

struct generator_opcodes_data {
	struct opcode_table *table;
};

extern struct generator *generator_init(enum generator_type type);
extern void generator_free(struct generator *generator);
extern void generator_print(struct generator *generator);
extern void generator_execute(struct generator *generator, FILE *stream);
extern struct generator_tree_node *generator_x86_tree_get();

#endif /* GENERATOR_H_ */
