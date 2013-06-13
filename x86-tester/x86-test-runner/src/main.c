/*
 * main.c
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#define _GNU_SOURCE
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdint-gcc.h>
#include <time.h>
#include <unistd.h>
#include <rreil/rreil.h>
#include <generator.h>
#include <generator_tree.h>
#include <setjmp.h>
#include <tester.h>
#include <gdsl.h>

enum mode {
	MODE_NONE, MODE_GENERATOR, MODE_CLI, MODE_CODE, MODE_CMDLINE
};

struct options {
	enum mode mode;
	char const *parameter;
	unsigned long n;
	char fork;
	char test_unused;
};

static size_t stream_to_insn_buffer(FILE *stream, uint8_t *buffer,
		size_t size_max) {
	char char_to_hex(char x) {
		if(x >= '0' && x <= '9')
			return x - '0';
		if(x >= 'a' && x <= 'z')
			return x - 'a' + 10;
		else if(x >= 'A' && x <= 'Z')
			return x - 'A' + 10;
		else
			return -1;
	}

	size_t size_actual = 0;
	for(size_t i = 0; i < size_max; i++) {
		uint8_t c = 0;
		for(int i = 0; i < 2;) {
			int x = getc(stream);
			switch(x) {
				case EOF:
					goto done;
				case '\n':
					goto done;
				default: {
					char r = char_to_hex(x);
					if(r >= 0)
						c |= r << (4 * (1 - i++));
					break;
				}
			}
		}
		buffer[size_actual++] = c;
	}
	done: ;
	return size_actual;
}

//static char test(__char *data, size_t data_size) {
//	__obj state = gdsl_create_state(data, data_size);
//
//	__obj insn;
//	if(gdsl_decode(&insn, &state)) {
//		printf("Decode failed\n");
//		fflush(stderr);
//		fflush(stdout);
//		return -1;
//	}
//
//	data_size = gdsl_decoded(&state);
//
//	printf("Instruction bytes:");
//	for(size_t i = 0; i < data_size; ++i)
//		printf(" %02x", (int)(data[i]) & 0xff);
//	printf("\n");
//
//	char *str = gdsl_x86_pretty(insn, GSDL_X86_PRINT_MODE_FULL);
//	if(str)
//		puts(str);
//	else
//		printf("NULL\n");
//	free(str);
//
//	str = gdsl_x86_pretty(insn, GSDL_X86_PRINT_MODE_SIMPLE);
//	if(str)
//		puts(str);
//	else
//		printf("NULL\n");
//	free(str);
//
//	printf("---------------------------\n");
//
//	__obj rreil;
//	if(gdsl_translate(&rreil, insn, &state)) {
//		printf("Translate failed\n");
//		fflush(stderr);
//		fflush(stdout);
//		return -2;
//	}
//
//	struct gdrr_config *config = rreil_gdrr_builder_config_get();
//	struct rreil_statements *statements = (struct rreil_statements*)gdrr_convert(
//			rreil, config);
//	free(config);
//
//	char retval = tester_test_translated(statements, data, data_size);
//
//	rreil_statements_free(statements);
//
//	gdsl_reset();
//
//	return retval;enum mode {
//}

static void result_print(struct tester_result result) {
	printf("Result: ");
	tester_result_type_print(result.type);
	printf("\n");
}

static void test_stream(FILE *stream, struct options *options) {
	__char data[15];
	stream_to_insn_buffer(stream, (uint8_t*)data, sizeof(data));
	struct tester_result result = tester_test_binary(NULL, options->fork, data,
			sizeof(data), options->test_unused);
	result_print(result);
}

static void generator(struct options *options) {
	struct generator_tree_node *root = generator_x86_tree_get();
	printf("Generator:\n");
	generator_tree_print(root);
	printf("\n");

	for(size_t i = 0; i < options->n; ++i) {
		printf("\nTest #%lu +++++++++++++++++++++\n", i);

		char *buffer;
		size_t length;
		FILE *stream = open_memstream(&buffer, &length);
		generator_tree_execute(root, stream);
		fclose(stream);

		struct tester_result result = tester_test_binary(NULL, options->fork,
				(__char *)buffer, length, options->test_unused);

		free(buffer);

		result_print(result);
		if(result.type == TESTER_RTYPE_COMPARISON_ERROR)
			break;
//		if(result.type == TESTER_RTYPE_CRASH)
//			break;
	}

	generator_tree_free(root);
}

static void cli(struct options *options) {
	test_stream(stdin, options);
}

static void code(struct options *options) {

	//	__char data[] = { 0x66, 0x42, 0x0f, 0x38, 0x07, 0x61, 0x55 };
	// 66 66 66 66 41 63 4a 47 78 50 69 22

	/*
	 * SIGILL
	 */
	//	__char data[] = { 0x66, 0x66, 0x66, 0x66, 0x45, 0x0f, 0xc3, 0x57, 0x10 };
	/*
	 * 4d d3 df!!!
	 * 40 18 a9 10 b9 90 e7
	 */

	//	__char data[] = { 0x4c, 0x01, 0xc4 };
	//	__char data[] = { 0x66, 0x0f, 0x5e, 0xff };
	//	__char data[] = { 0x49, 0x0f, 0x42, 0x3b };
	//	__char data[] = { 0x40, 0xd3, 0xa4, 0xae, 0xe6, 0x47, 0xd0, 0x45, 0x21, 0xe9, 0x35, 0x0a };
	//	__char data[] = { 0x66, 0x48, 0xff, 0x28 };
	/*
	 * Todo: semantics
	 */
	//	__char data[] = { 0x66, 0x4b, 0xd0, 0x13 };
	//	__char data[] = { 0x66, 0x41, 0xe0, 0xbd, 0x51, 0x24, 0xb0, 0x23 };
	//
	/*
	 * Todo: Wrong decoding
	 */
//	__char data[] = { 0x41, 0x8a, 0xe5 };
//	__char data[] = { 0x66, 0x66, 0x66, 0x66, 0x66, 0x66, 0x47, 0x74, 0xf0 };
//	__char data[] = { 0x48, 0x83, 0xc4, 0x08 };
//	__char data[] = { 0x48, 0x01, 0xd0 };

//	__char data[] = { 0x48, 0x83, 0xc0, 0x2a };

	__char data[] = { 0x48, 0x01, 0xe3 };


	struct tester_result result = tester_test_binary(NULL, options->fork, data,
			sizeof(data), options->test_unused);
	result_print(result);
}

static void cmdline(struct options *options) {
	FILE *stream = fmemopen((void*)options->parameter,
			strlen(options->parameter) + 1, "r");
	test_stream(stream, options);
}

static char args_parse(int argc, char **argv, struct options *options) {
	options->mode = MODE_NONE;
	options->n = 100;
	options->fork = 0;
	options->test_unused = 0;

	while(1) {
		char c = getopt(argc, argv, "gcpm:n:fu");
		switch(c) {
			case 'g': {
				options->mode = MODE_GENERATOR;
				break;
			}
			case 'c': {
				options->mode = MODE_CLI;
				break;
			}
			case 'p': {
				options->mode = MODE_CODE;
				break;
			}
			case 'm': {
				options->mode = MODE_CMDLINE;
				options->parameter = optarg;
				break;
			}
			case 'n': {
				sscanf(optarg, "%lu", &options->n);
				break;
			}
			case 'f': {
				options->fork = 1;
				break;
			}
			case 'u': {
				options->test_unused = 1;
				break;
			}
			default: {
				goto end;
			}
		}
	}
	end: ;

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

	struct timespec timespec;
#ifndef CLOCK_MONOTONIC_RAW
#define CLOCK_MONOTONIC_RAW 0
#endif
	clock_gettime(CLOCK_MONOTONIC_RAW, &timespec);
	srand(timespec.tv_nsec);

	struct options options;
	char retval = args_parse(argc, argv, &options);
	if(retval)
		return 1;

	switch(options.mode) {
		case MODE_CLI: {
			cli(&options);
			break;
		}
		case MODE_GENERATOR: {
			generator(&options);
			break;
		}
		case MODE_CODE: {
			code(&options);
			break;
		}
		case MODE_CMDLINE: {
			cmdline(&options);
			break;
		}
		default: {
			printf("*** No operation specified. Exiting...\n");
			break;
		}
	}

//	char fmt[1024];
//	__word sz = 15;

//	int i = 5;
//	blob[0] = 0x48;
//	blob[1] = 0x8b;
//	blob[2] = 0x03;

//add    $0x8,%rsp
//		blob[0] = 0x48;
//		blob[1] = 0x83;
//		blob[2] = 0xc4;
//		blob[3] = 0x42;

//add    $0x42,%ecx
//	blob[0] = 0x83;
//	blob[1] = 0xc1;
//	blob[2] = 0x42;

//	add    %r8, %rsp
//		blob[0] = 0x4c;
//		blob[1] = 0x01;
//		blob[2] = 0xc4;

//	blob[0] = 0x41;
//	blob[1] = 0xff;
//	blob[2] = 0xd0;

//	blob[0] = 0x0f;
//	blob[1] = 0x84;
//	blob[2] = 0xff;
//	blob[3] = 0xcd;
//	blob[4] = 0xef;
//	blob[5] = 0x80;

//	blob[0] = 0x66;
//	blob[1] = 0x01;
//	blob[2] = 0xfc;

// pand mm0, mm1
//		blob[0] = 0x0f;
//		blob[1] = 0xdb;
//		blob[2] = 0xc1;

//			blob[0] = 0x66;
//			blob[1] = 0x0f;
//			blob[2] = 0x38;
//			blob[3] = 0x10;
//			blob[4] = 0xd3;

//			blob[0] = 0x66;
//			blob[1] = 0x0f;
//			blob[2] = 0x3a;
//			blob[3] = 0x44;
//			blob[4] = 0xd3;
//			blob[5] = 0x31;

//			blob[0] = 0x00;
//			blob[1] = 0x01;

//	blob[0] = 0x4c;
//	blob[1] = 0x8d;
//	blob[2] = 0x25;
//	blob[3] = 0x84;
//	blob[4] = 0x22;
//	blob[5] = 0x20;
//	blob[6] = 0x00;

//				blob[5] = 0x20;
//				blob[6] = 0x00;
//		blob[0] = 0x04;
//		blob[1] = 0x42;

//shl
//	blob[0] = 0x48;
//	blob[1] = 0xc1;
//	blob[2] = 0xe0;
//	blob[3] = 0x2a;

//	typedef uint8_t xmm_t __attribute__ ((vector_size (16)));
//
//	register xmm_t hugo asm ("xmm0");
//
//	hugo[0] = 0x1122334455667788;
//	hugo[1] = 0xaabbccddeeff1122;
//
//	hugo = {3, 4} ;

//	hugo = {0x1122334455667788, 0x1122334455667788} ;

//shr
//	blob[0] = 0x48;
//	blob[1] = 0xc1;
//	blob[2] = 0xe8;
//	blob[3] = 0x2c;

//shrs
//	blob[0] = 0x48;
//	blob[1] = 0xc1;
//	blob[2] = 0xf8;
//	blob[3] = 0x2c;

//movzx
//	blob[0] = 0x48;
//	blob[1] = 0x0f;
//	blob[2] = 0xb7;
//	blob[3] = 0xd8;

//movsx
//	blob[0] = 0x48;
//	blob[1] = 0x0f;
//	blob[2] = 0xbf;
//	blob[3] = 0xd8;

//add %rax, %rbx
//	blob[0] = 0x48;
//	blob[1] = 0x01;
//	blob[2] = 0xc3;

//	jmp_buf exp_vec;
//	__exp_vec_set(&exp_vec);
//
//	__obj state = __createState(blob, i, 0, 0);
//
//	if(setjmp(exp_vec)) {
//		printf("Decode failed\n");
//		exit(1);
//	}
//	__obj insn = __runMonadicNoArg(__decode__, &state);
//
//	if(___isNil(insn))
//		__fatal("decode failed");
//	else {
//		__pretty(__pretty__, insn, fmt, 1024);
//		puts(fmt);
//
//		printf("---------------------------\n");
//
//		if(setjmp(exp_vec)) {
//			printf("Translate failed\n");
//			exit(1);
//		}
//		__obj r = __runMonadicOneArg(__translate__, &state, insn);
//		if(___isNil(r))
//			__fatal("translate failed");
//		else {
////			__pretty(__rreil_pretty__, r, fmt, 1024);
////			puts(fmt);
//
//			struct gdrr_config *config = rreil_gdrr_builder_config_get();
//			struct rreil_statements *statements =
//					(struct rreil_statements*)gdrr_convert(r, config);
//			free(config);
//
//			tester_test(statements, blob, i);
//
//			rreil_statements_free(statements);
//		}
//	}
	return 0;
}

//reset; /usr/bin/valgrind --vgdb=yes --vgdb-error=0  --leak-check=full ./x86-tester
