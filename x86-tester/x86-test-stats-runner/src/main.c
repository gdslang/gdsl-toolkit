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
#include <search.h>
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
#include "hash_array.h"

#include <sys/mman.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/wait.h>

struct insn_data {
	size_t errors[TESTER_RESULTS_LENGTH];
	size_t count;
};

static char test_instruction(struct hash_array *ha, __char *data,
		size_t data_size) {
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

	struct insn_data *insn_data;

	str = gdsl_x86_pretty(insn, GSDL_X86_PRINT_MODE_SIMPLE);
	if(str) {
		puts(str);

		ENTRY *e = hash_array_search_insert(ha, str);

		if(!e->data)
			e->data = (struct insn_data*)calloc(sizeof(struct insn_data), 1);
		insn_data = (struct insn_data*)e->data;

		insn_data->count++;
	} else {
		printf("NULL\n");

		return -3;
	}

	printf("---------------------------\n");

	__obj rreil;
	if(gdsl_translate(&rreil, insn, &state)) {
		printf("Translate failed\n");
		fflush(stderr);
		fflush(stdout);
		insn_data->errors[2]++;
		return -2;
	}

	struct gdrr_config *config = rreil_gdrr_builder_config_get();
	struct rreil_statements *statements = (struct rreil_statements*)gdrr_convert(
			rreil, config);
	free(config);

//	enum tester_result *test_result = (enum tester_result*)shmat(shmid, NULL, 0);
//	*test_result = TESTER_RESULT_CRASH;

	enum tester_result *test_result = mmap(NULL, sizeof(enum tester_result),
			PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANONYMOUS, 0, 0);
	*test_result = TESTER_RESULT_CRASH;

	pid_t pid = fork();
	if(!pid) {
//		enum tester_result *test_result = (enum tester_result*)shmat(shmid, NULL, 0);
		*test_result = tester_test_translated(statements, data, data_size);
//		shmdt(test_result);
//		tester_test_translated(statements, data, data_size);
		exit(0);
	} else
		waitpid(pid, NULL, 0);

	insn_data->errors[*test_result]++;

//	shmdt(test_result);
	munmap(test_result, sizeof(enum tester_result));

	rreil_statements_free(statements);

	gdsl_reset();

	return 0;
}

static void generator() {
	struct hash_array *ha = hash_array_init(32768);

	size_t n = 1000000;
	for(size_t i = 0; i < n; ++i) {
		printf("%lu +++++++++++++++++++++\n", i);

//		generator_tree_print(root);
//		printf("\n");

		struct generator_tree_node *root = generator_x86_tree_get();
		char *buffer;
		size_t length;
		FILE *stream = open_memstream(&buffer, &length);
		generator_tree_execute(root, stream);
		fclose(stream);
		generator_tree_free(root);

		char result = test_instruction(ha, (__char *)buffer, length);

		free(buffer);
	}

	ENTRY *entries;
	size_t entries_length = hash_array_entries_get(ha, &entries);
	size_t errors[TESTER_RESULTS_LENGTH];
	size_t executed = 0;
	for(size_t i = 0; i < TESTER_RESULTS_LENGTH; ++i)
		errors[i] = 0;
	for(size_t i = 0; i < entries_length; ++i) {
		struct insn_data *data = (struct insn_data*)entries[i].data;
		printf(
				"%s: %lu, successful tests: %lu, translation errors: %lu, simulation errors: %lu, execution errors: %lu, comparison errors: %lu, crashes: %lu\n",
				entries[i].key, data->count,
				data->errors[TESTER_RESULT_SUCCESS],
				data->errors[TESTER_RESULT_TRANSLATION_ERROR],
				data->errors[TESTER_RESULT_SIMULATION_ERROR],
				data->errors[TESTER_RESULT_EXECUTION_ERROR],
				data->errors[TESTER_RESULT_COMPARISON_ERROR],
				data->errors[TESTER_RESULT_CRASH]);

		errors[TESTER_RESULT_SUCCESS] += data->errors[TESTER_RESULT_SUCCESS];
		errors[TESTER_RESULT_TRANSLATION_ERROR] +=
				data->errors[TESTER_RESULT_TRANSLATION_ERROR];
		errors[TESTER_RESULT_SIMULATION_ERROR] +=
				data->errors[TESTER_RESULT_SIMULATION_ERROR];
		errors[TESTER_RESULT_EXECUTION_ERROR] +=
				data->errors[TESTER_RESULT_EXECUTION_ERROR];
		errors[TESTER_RESULT_COMPARISON_ERROR] +=
				data->errors[TESTER_RESULT_COMPARISON_ERROR];
		errors[TESTER_RESULT_CRASH] += data->errors[TESTER_RESULT_CRASH];
		executed += data->count;
	}
	printf("Error summary:\n");
	printf("%lu instructions executed (%lu different ones)\n", executed,
			entries_length);
	printf("%lu successful tests (%f%%)\n", errors[TESTER_RESULT_SUCCESS],
			100 * errors[TESTER_RESULT_SUCCESS] / (double)executed);
	printf("%lu translation errors (%f%%)\n",
			errors[TESTER_RESULT_TRANSLATION_ERROR],
			100 * errors[TESTER_RESULT_TRANSLATION_ERROR] / (double)executed);
	printf("%lu simulation errors (%f%%)\n",
			errors[TESTER_RESULT_SIMULATION_ERROR],
			100 * errors[TESTER_RESULT_SIMULATION_ERROR] / (double)executed);
	printf("%lu execution errors (%f%%)\n", errors[TESTER_RESULT_EXECUTION_ERROR],
			100 * errors[TESTER_RESULT_EXECUTION_ERROR] / (double)executed);
	printf("%lu comparison errors (%f%%)\n",
			errors[TESTER_RESULT_COMPARISON_ERROR],
			100 * errors[TESTER_RESULT_COMPARISON_ERROR] / (double)executed);
	printf("%lu crashes (%f%%)\n", errors[TESTER_RESULT_CRASH],
			100 * errors[TESTER_RESULT_CRASH] / (double)executed);

	for(size_t i = 0; i < entries_length; ++i) {
		free(entries[i].data);
		free(entries[i].key);
	}
	hash_array_free(ha);
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
	end: ;

	return 0;
}

char *data[] = { "alpha", "bravo", "charlie", "delta", "echo", "foxtrot",
		"golf", "hotel", "india", "juliet", "kilo", "lima", "mike", "november",
		"oscar", "papa", "quebec", "romeo", "sierra", "tango", "uniform", "victor",
		"whisky", "x-ray", "yankee", "zulu" };

int main(int argc, char **argv) {
//	while(1) {
//		int n = 1000000;
//		int *k = mmap(NULL, n*sizeof(int),
//				PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANONYMOUS, 0, 0);
//		for (int i = 0; i < n; ++i) {
//			k[i] = 2*i;
//		}
//		usleep(10);
//	}
//	int shmid = shmget(IPC_PRIVATE, 1024, 0644 | IPC_CREAT);
//
//	pid_t p = fork();
//	if(!p) {
//		//child
//		uint8_t *data = shmat(shmid, NULL, 0);
//		data[0] = 99;
//		int *k = 0;
//		printf("Hallo...\n");
//		k[0] = 77;
//		printf("... Hugo!\n");
//	} else
//		waitpid(p, NULL, 0);
//
//	uint8_t *data = shmat(shmid, NULL, 0);
//
//	printf("%d", data[0]);

//	ENTRY e, *ep;
//	int i;
//
//	struct hsearch_data htab;
//	memset(&htab, 0, sizeof(htab));
//	int x = hcreate_r(30, &htab);
//
//	for(i = 0; i < 24; i++) {
//		e.key = data[i];
//		/* data is just an integer, instead of a
//		 pointer to something */
//		e.data = (void *)i;
//		hsearch_r(e, ENTER, &ep, &htab);
//		/* there should be no failures */
//		if(ep == NULL) {
//			fprintf(stderr, "entry failed\n");
//			exit(EXIT_FAILURE);
//		}
//	}
//
//	for(i = 22; i < 26; i++) {
//		/* print two entries from the table, and
//		 show that two are not in the table */
//		e.key = data[i];
//		hsearch_r(e, FIND, &ep, &htab);
//		printf("%9.9s -> %9.9s:%d\n", e.key, ep ? ep->key : "NULL",
//				ep ? (int)(ep->data) : 0);
//	}
//	hdestroy_r(&htab);

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
