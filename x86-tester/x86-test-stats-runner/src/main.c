/*
 * main.c
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdint-gcc.h>
#include <time.h>
#include <unistd.h>
#include <dis.h>
#include <gdrr.h>
#include <rreil/rreil.h>
#include <rreil/gdrr_builder.h>
#include <generator.h>
#include <generator_tree.h>
#include <setjmp.h>
#include <tester.h>
#include <gdsl.h>

static char test(__char *data, size_t data_size) {
	__obj state = gdsl_create_state(data, data_size);

	__obj insn;
	if(gdsl_decode(&insn, &state)) {
		printf("Decode failed\n");
		fflush(stderr);
		fflush(stdout);
		return -1;
	}

	data_size = gdsl_decoded(&state);

	printf("Instruction bytes:");
	for(size_t i = 0; i < data_size; ++i)
		printf(" %02x", (int)(data[i]) & 0xff);
	printf("\n");

	char *str = gdsl_x86_pretty(insn, GSDL_X86_PRINT_MODE_FULL);
	if(str)
		puts(str);
	else
		printf("NULL\n");
	free(str);

	str = gdsl_x86_pretty(insn, GSDL_X86_PRINT_MODE_SIMPLE);
	if(str)
		puts(str);
	else
		printf("NULL\n");
	free(str);

	printf("---------------------------\n");

	__obj rreil;
	if(gdsl_translate(&rreil, insn, &state)) {
		printf("Translate failed\n");
		fflush(stderr);
		fflush(stdout);
		return -2;
	}

	struct gdrr_config *config = rreil_gdrr_builder_config_get();
	struct rreil_statements *statements = (struct rreil_statements*)gdrr_convert(
			rreil, config);
	free(config);

	char retval = tester_test(statements, data, data_size);

	rreil_statements_free(statements);

	gdsl_reset();

	return retval;
}

static void generator() {
	for(size_t i = 0; i < 1000; ++i) {
		printf("%lu +++++++++++++++++++++\n", i);

		struct generator_tree_node *root = generator_x86_tree_get();

//		generator_tree_print(root);
//		printf("\n");

		char *buffer;
		size_t length;
		FILE *stream = open_memstream(&buffer, &length);
		generator_tree_execute(root, stream);
		fclose(stream);
		generator_tree_free(root);

		char result = test((__char *)buffer, length);

		free(buffer);

		if(result > 0) {
			printf("FAILURE.\n");
			break;
		}
	}
}

enum mode {
	MODE_GENERATOR, MODE_CLI, MODE_CODE, MODE_CMDLINE
};

struct options {
	enum mode mode;
	char const *parameter;
};

static char args_parse(int argc, char **argv, struct options *options) {
	while(1) {
		char c = getopt(argc, argv, "gcpm:");
		if(c == -1)
			return -1;
		switch(c) {
			case 'g': {
				options->mode = MODE_GENERATOR;
				goto end;
			}
			case 'c': {
				options->mode = MODE_CLI;
				goto end;
			}
			case 'p': {
				options->mode = MODE_CODE;
				goto end;
			}
			case 'm': {
				options->mode = MODE_CMDLINE;
				options->parameter = optarg;
				goto end;
			}
		}
	}
	end:;

	return 0;
}

int main(int argc, char **argv) {
//	struct register_ reg;
//	reg.data = NULL;
//	reg.data_length = 0;
//	reg.data_size = 0;
//
//	uint8_t x = 0x42;
//	simulator_register_generic_write(&reg, &x, 8, 0);
//	x = 0x99;
//	simulator_register_generic_write(&reg, &x, 8, 8);
//
//	x = 0b10110;
//	simulator_register_generic_write(&reg, &x, 5, 5);

	stderr = stdout;

	srand(time(NULL));

	struct options options;
	char retval = args_parse(argc, argv, &options);
	if(retval)
		return 1;

	switch(options.mode) {
		case MODE_CLI: {
			break;
		}
		case MODE_GENERATOR: {
			generator();
			break;
		}
		case MODE_CODE: {
			break;
		}
		case MODE_CMDLINE: {
			break;
		}
	}

	return 0;
}

//reset; /usr/bin/valgrind --vgdb=yes --vgdb-error=0  --leak-check=full ./x86-tester
