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
#include <stdint.h>
#include <search.h>
#include <time.h>
#include <unistd.h>
#include <generator.h>
#include <generator_tree.h>
#include <tester.h>
#include "hash_array.h"

struct insn_data {
	size_t errors[TESTER_RESULTS_LENGTH];
	size_t count;
};

static char test_instruction(struct hash_array *ha, __char *data,
		size_t data_size) {
	struct insn_data *insn_data = NULL;

	void for_name(char *name) {
		size_t name_length = strlen(name);
		char *copy = (char*)malloc(name_length + 1);
		memcpy(copy, name, name_length + 1);

		ENTRY *e = hash_array_search_insert(ha, copy);

		if(!e->data)
			e->data = (struct insn_data*)calloc(sizeof(struct insn_data), 1);
		else
			free(copy);
		insn_data = (struct insn_data*)e->data;
	}

	enum tester_result result = tester_test_binary(&for_name, 1, data, data_size);

	if(insn_data) {
		insn_data->count++;
		insn_data->errors[result]++;
		return 0;
	} else
		return 1;
}

struct options {
	unsigned long n;
};

static char args_parse(int argc, char **argv, struct options *options) {
	options->n = 100;

	while(1) {
		char c = getopt(argc, argv, "n:");
		switch(c) {
			case 'n': {
				sscanf(optarg, "%lu", &options->n);
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

	struct hash_array *ha = hash_array_init(32768);

	size_t decode_errors = 0;

	struct generator_tree_node *root = generator_x86_tree_get();
	printf("Generator:\n");
	generator_tree_print(root);
	printf("\n");

	for(size_t i = 0; i < options.n; ++i) {
		printf("\nTest #%lu +++++++++++++++++++++\n", i);

		char *buffer;
		size_t length;
		FILE *stream = open_memstream(&buffer, &length);
		generator_tree_execute(root, stream);
		fclose(stream);

		decode_errors += test_instruction(ha, (__char *)buffer, length);

		free(buffer);
	}

	generator_tree_free(root);

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
				entries[i].key, data->count, data->errors[TESTER_RESULT_SUCCESS],
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
	printf("Summary:\n");
	printf("%lu instructions generated (%lu decodable ones, %f%%)\n", options.n,
			options.n - decode_errors,
			100 * (options.n - decode_errors) / (double)options.n);
	printf("%lu instruction tests (%lu different instruction types)\n", executed,
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

	return 0;
}

//reset; /usr/bin/valgrind --vgdb=yes --vgdb-error=0  --leak-check=full ./x86-tester
