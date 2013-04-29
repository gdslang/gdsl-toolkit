/*
 * generator.c
 *
 *  Created on: Apr 29, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <generator.h>
#include <util.h>

struct generator *generator_init(generator_function_t *generate) {
	struct generator *generator = (struct generator*)malloc(sizeof(struct generator));

	generator->generate = generate;

	return generator;
}

size_t generator_x86_prefixes_generate(uint8_t **buffer, size_t offset, size_t *size) {
	while(rand() > RAND_MAX/2) {
		int discr = rand()%4;
		switch(discr) {
			case 0: {
				offset = util_byte_append(buffer, offset, size, 0x66);
				break;
			}
			case 1: {
				offset = util_byte_append(buffer, offset, size, 0x67);
				break;
			}
			case 2: {
				offset = util_byte_append(buffer, offset, size, 0xf2);
				break;
			}
			case 3: {
				offset = util_byte_append(buffer, offset, size, 0xf3);
				break;
			}
		}
	}
	return offset;
}

void generator_free(struct generator *generator) {

}
