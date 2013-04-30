/*
 * generator.h
 *
 *  Created on: Apr 29, 2013
 *      Author: jucs
 */

#ifndef GENERATOR_H_
#define GENERATOR_H_

#include <stdlib.h>
#include <stdint.h>
#include <opcodes.h>

typedef size_t (generator_function_t)(uint8_t **buffer, size_t offset,
		size_t size);

enum generator_type {
	GENERATOR_TYPE_PREFIXES,
	GENERATOR_TYPE_OPCODE,
	GENERATOR_TYPE_MODRM,
	GENERATOR_TYPE_IMMEDIATE,
	GENERATOR_TYPE_REX,
	GENERATOR_TYPE_VEX
};

struct generator {
	void *data;
	generator_function_t *generate;
};

struct generator_opcodes_data {
	struct opcode_table *table;
};

extern struct generator *generator_init(generator_function_t *generate);
extern void generator_free(struct generator *generator);

extern size_t generator_x86_prefixes_generate(uint8_t **buffer, size_t offset,
		size_t *size);
extern size_t generator_x86_opcode_generate(uint8_t **buffer, size_t offset,
		size_t *size);
extern size_t generator_x86_modrm_generate(uint8_t **buffer, size_t offset,
		size_t *size);
extern size_t generator_x86_immediate_generate(uint8_t **buffer, size_t offset,
		size_t *size);
extern size_t generator_x86_rex_generate(uint8_t **buffer, size_t offset,
		size_t *size);
extern size_t generator_x86_vex_generate(uint8_t **buffer, size_t offset,
		size_t *size);

#endif /* GENERATOR_H_ */
