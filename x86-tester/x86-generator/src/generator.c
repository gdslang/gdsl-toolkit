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
#include <x86_opcodes.h>

size_t generator_x86_prefixes_generate(struct generator *this, FILE *stream) {
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

static size_t generator_x86_opcode_generate(struct generator *this,
		FILE *stream) {
	if(!this->data)
		this->data = x86_opcodes_opcode_table_build();
	struct opcode_table *table = (struct opcode_table*)this->data;

	int random = rand() % table->offsets_length;

	size_t start = random ? table->offsets[random - 1] : 0;
	size_t next = table->offsets[random];

//	if(table->offsets[start] == 0)
//		printf("%zu\n", start);

	return fwrite(&table->opcodes[start], 1, next - start, stream);
}

static size_t generator_x86_modrm_generate(struct generator *this, FILE *stream) {
	uint8_t modrm = rand() & 0xff;
	size_t written = fwrite(&modrm, 1, 1, stream);

	uint8_t mod = modrm >> 6;
//	uint8_t reg = (modrm >> 3) & 0b111;
	uint8_t rm = modrm & 0b111;

	void add_disp8() {
		int random = rand();
		written += fwrite(&random, 1, 1, stream);
	}

	void add_disp16() {
		add_disp8();
		add_disp8();
	}

	void add_disp32() {
		add_disp16();
		add_disp16();
	}

	void add_sib() {
		add_disp8();
	}

	switch(mod) {
		case 0b00: {
			switch(rm) {
				case 0b100: {
					add_sib();
					add_disp32();
					break;
				}
				case 0b101: {
					add_disp32();
					break;
				}
			}
			break;
		}
		case 0b01: {
			switch(rm) {
				case 0b100: {
					add_sib();
					break;
				}
			}
			add_disp8();
			break;
		}
		case 0b10: {
			switch(rm) {
				case 0b100: {
					add_sib();
					break;
				}
			}
			add_disp32();
			break;
		}
	}

	return written;
}

static size_t generator_x86_immediate_generate(struct generator *this,
		FILE *stream) {
	if(rand() > 2 * (RAND_MAX / 3)) {
		int random = rand();
		return fwrite(&random, 4, 1, stream);
	} else
		return 0;
}

static size_t generator_x86_rex_generate(struct generator *this, FILE *stream) {
	uint8_t rex = 0x40;
	rex |= rand() & 0x0f;
	return fwrite(&rex, 1, 1, stream);
}

static size_t generator_x86_vex_generate(struct generator *this, FILE *stream) {
	size_t written = 0;
	if(rand() > RAND_MAX / 2) {
		// 3 byte
		uint8_t vex0 = 0xc4;
		written += fwrite(&vex0, 1, 1, stream);
		uint8_t vex1 = (rand() & 0xe0) + (rand() % 3) + 1;
		written += fwrite(&vex1, 1, 1, stream);
		uint8_t vex2 = rand() & 0xff;
		if(rand() > RAND_MAX / 2)
			vex2 |= 0x78;
		written += fwrite(&vex2, 1, 1, stream);
	} else {
		uint8_t vex0 = 0xc5;
		written += fwrite(&vex0, 1, 1, stream);
		uint8_t vex1 = rand() & 0xff;
		if(rand() > RAND_MAX / 2)
			vex1 |= 0x78;
		written += fwrite(&vex1, 1, 1, stream);
	}
	return written;
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

void generator_execute(struct generator *generator, FILE *stream) {
	switch(generator->type) {
		case GENERATOR_TYPE_PREFIXES: {
			generator_x86_prefixes_generate(generator, stream);
			break;
		}
		case GENERATOR_TYPE_OPCODE: {
			generator_x86_opcode_generate(generator, stream);
			break;
		}
		case GENERATOR_TYPE_MODRM: {
			generator_x86_modrm_generate(generator, stream);
			break;
		}
		case GENERATOR_TYPE_IMMEDIATE: {
			generator_x86_immediate_generate(generator, stream);
			break;
		}
		case GENERATOR_TYPE_REX: {
			generator_x86_rex_generate(generator, stream);
			break;
		}
		case GENERATOR_TYPE_VEX: {
			generator_x86_vex_generate(generator, stream);
			break;
		}
	}
}

struct generator_tree_node *generator_x86_tree_get() {
	struct generator_tree_node *imm = generator_tree_generator_build(
			generator_init(GENERATOR_TYPE_IMMEDIATE), NULL);
	struct generator_tree_node *rm_imm = generator_tree_generator_build(
			generator_init(GENERATOR_TYPE_MODRM), imm);
	struct generator_tree_node *op_rm_imm = generator_tree_generator_build(
			generator_init(GENERATOR_TYPE_OPCODE), rm_imm);
	struct generator_tree_node *rex_op_rm_imm = generator_tree_generator_build(
			generator_init(GENERATOR_TYPE_REX), op_rm_imm);
	struct generator_tree_node *pref_rex_op_rm_imm =
			generator_tree_generator_build(generator_init(GENERATOR_TYPE_PREFIXES),
					rex_op_rm_imm);

	struct generator_tree_node *vex_op_rm_imm = generator_tree_generator_build(
			generator_init(GENERATOR_TYPE_VEX), op_rm_imm);

	struct generator_tree_node *root = generator_tree_branch(2,
			pref_rex_op_rm_imm, 3, vex_op_rm_imm, 2);

	return root;
}

void generator_free(struct generator *generator) {
	if(generator) {
		switch(generator->type) {
			case GENERATOR_TYPE_PREFIXES: {
				break;
			}
			case GENERATOR_TYPE_OPCODE: {
				x86_opcodes_opcode_table_free((struct opcode_table*)generator->data);
				break;
			}
			case GENERATOR_TYPE_MODRM: {
				break;
			}
			case GENERATOR_TYPE_IMMEDIATE: {
				break;
			}
			case GENERATOR_TYPE_REX: {
				break;
			}
			case GENERATOR_TYPE_VEX: {
				break;
			}
		}
		free(generator);
	}
}
