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

extern size_t generator_x86_prefixes_generate(FILE *stream);
extern size_t generator_x86_opcode_generate(FILE *stream);
extern size_t generator_x86_modrm_generate(FILE *stream);
extern size_t generator_x86_immediate_generate(FILE *stream);
extern size_t generator_x86_rex_generate(FILE *stream);
extern size_t generator_x86_vex_generate(FILE *stream);

size_t generator_x86_prefixes_generate(FILE *stream) {
	size_t size = 0;
	while(rand() > RAND_MAX / 2) {
		int discr = rand() % 4;
		switch(discr) {
			case 0: {
				fputc(0x66, stream);
				size++;
				break;
			}
			case 1: {
				fputc(0x66, stream);
				size++;
				break;
			}
			case 2: {
				fputc(0x66, stream);
				size++;
				break;
			}
			case 3: {
				fputc(0x66, stream);
				size++;
				break;
			}
		}
	}
	return size;
}

struct generator *generator_init(enum generator_type type) {
	struct generator *generator = (struct generator*)malloc(
			sizeof(struct generator));

	generator->type = type;
	switch(type) {
		case GENERATOR_TYPE_PREFIXES: {
			generator->data = NULL;
			break;
		}
		case GENERATOR_TYPE_OPCODE: {
			generator->data = NULL;
			break;
		}
		case GENERATOR_TYPE_MODRM: {
			generator->data = NULL;
			break;
		}
		case GENERATOR_TYPE_IMMEDIATE: {
			generator->data = NULL;
			break;
		}
		case GENERATOR_TYPE_REX: {
			generator->data = NULL;
			break;
		}
		case GENERATOR_TYPE_VEX: {
			generator->data = NULL;
			break;
		}
	}

	return generator;
}

void generator_print(struct generator *generator) {
	switch(generator->type) {
		case GENERATOR_TYPE_PREFIXES: {
			printf("GENERATOR_TYPE_PREFIXES");
			break;
		}
		case GENERATOR_TYPE_OPCODE: {
			printf("GENERATOR_TYPE_OPCODE");
			break;
		}
		case GENERATOR_TYPE_MODRM: {
			printf("GENERATOR_TYPE_MODRM");
			break;
		}
		case GENERATOR_TYPE_IMMEDIATE: {
			printf("GENERATOR_TYPE_IMMEDIATE");
			break;
		}
		case GENERATOR_TYPE_REX: {
			printf("GENERATOR_TYPE_REX");
			break;
		}
		case GENERATOR_TYPE_VEX: {
			printf("GENERATOR_TYPE_VEX");
			break;
		}
	}
}

void generator_free(struct generator *generator) {

}
