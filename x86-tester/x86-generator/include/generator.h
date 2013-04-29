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

typedef size_t (generator_function_t)(uint8_t **buffer, size_t offset, size_t size);

struct generator {

	generator_function_t *generate;
};

extern struct generator *generator_init(generator_function_t *generate);
extern size_t generator_x86_prefixes_generate(uint8_t **buffer, size_t offset, size_t *size);
extern void generator_free(struct generator *generator);

#endif /* GENERATOR_H_ */
