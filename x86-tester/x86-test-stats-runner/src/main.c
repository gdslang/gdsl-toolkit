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
	size_t errors[TESTER_RESULT_TYPES_LENGTH];
	/*
	 * SIMULATOR_ERROR_UNALIGNED_STORE => 0
	 * SIMULATOR_ERROR_UNDEFINED_ADDRESS => 1
	 * SIMULATOR_ERROR_UNDEFINED_BRANCH => 2
	 */
	size_t simulation_errors[SIMULATOR_ERRORS_COUNT - 1];
	size_t execution_errors[EXECUTOR_RESULTS_COUNT];
	size_t sigsegv_count;
	size_t sigill_count;
	size_t sigalrm_count;
	size_t sigbus_count;
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

	struct tester_result result = tester_test_binary(&for_name, 1, data,
			data_size);

	if(insn_data) {
		insn_data->count++;
		insn_data->errors[result.type]++;

		switch(result.type) {
			case TESTER_RTYPE_SIMULATION_ERROR: {
				if(result.simulator_error & SIMULATOR_ERROR_UNALIGNED_STORE)
					insn_data->simulation_errors[0]++;
				if(result.simulator_error & SIMULATOR_ERROR_UNDEFINED_ADDRESS)
					insn_data->simulation_errors[1]++;
				if(result.simulator_error & SIMULATOR_ERROR_UNDEFINED_BRANCH)
					insn_data->simulation_errors[2]++;
				break;
			}
			case TESTER_RTYPE_EXECUTION_ERROR: {
				insn_data->execution_errors[result.execution_result.type]++;
				if(result.execution_result.type == EXECUTION_RTYPE_SIGNAL)
					switch(result.execution_result.signum) {
						case SIGSEGV: {
							insn_data->sigsegv_count++;
							break;
						}
						case SIGILL: {
							insn_data->sigill_count++;
							break;
						}
						case SIGALRM: {
							insn_data->sigalrm_count++;
							break;
						}
						case SIGBUS: {
							insn_data->sigbus_count++;
							break;
						}
					}
				break;
			}
			default:
				break;
		}
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
	struct insn_data accumulator;
	memset(&accumulator, 0, sizeof(accumulator));
	for(size_t i = 0; i < entries_length; ++i) {
		struct insn_data *data = (struct insn_data*)entries[i].data;
		printf(
				"%s: %lu, successful tests: %lu, translation errors: %lu, simulation errors: %lu, execution errors: %lu, comparison errors: %lu, crashes: %lu\n",
				entries[i].key, data->count, data->errors[TESTER_RTYPE_SUCCESS],
				data->errors[TESTER_RTYPE_TRANSLATION_ERROR],
				data->errors[TESTER_RTYPE_SIMULATION_ERROR],
				data->errors[TESTER_RTYPE_EXECUTION_ERROR],
				data->errors[TESTER_RTYPE_COMPARISON_ERROR],
				data->errors[TESTER_RTYPE_CRASH]);

		for(size_t i = 0; i < TESTER_RESULT_TYPES_LENGTH; ++i)
			accumulator.errors[i] += data->errors[i];
		for(size_t i = 0; i < SIMULATOR_ERRORS_COUNT; ++i)
			accumulator.simulation_errors[i] += data->simulation_errors[i];
		for(size_t i = 0; i < EXECUTOR_RESULTS_COUNT; ++i)
			accumulator.execution_errors[i] += data->execution_errors[i];
		accumulator.sigsegv_count += data->sigsegv_count;
		accumulator.sigill_count += data->sigill_count;
		accumulator.sigalrm_count += data->sigalrm_count;
		accumulator.sigbus_count += data->sigbus_count;
		accumulator.count += data->count;
	}
	printf("Summary:\n");
	printf("%lu instructions generated (%lu decodable ones, %f%%)\n", options.n,
			options.n - decode_errors,
			100 * (options.n - decode_errors) / (double)options.n);
	printf("%lu instruction tests (%lu different instruction types)\n",
			accumulator.count, entries_length);
	printf("%lu successful tests (%f%%)\n",
			accumulator.errors[TESTER_RTYPE_SUCCESS],
			100 * accumulator.errors[TESTER_RTYPE_SUCCESS]
					/ (double)accumulator.count);
	printf("%lu translation errors (%f%%)\n",
			accumulator.errors[TESTER_RTYPE_TRANSLATION_ERROR],
			100 * accumulator.errors[TESTER_RTYPE_TRANSLATION_ERROR]
					/ (double)accumulator.count);
	printf("%lu simulation errors (%f%%)\n",
			accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR],
			100 * accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]
					/ (double)accumulator.count);
	printf("%lu execution errors (%f%%)\n",
			accumulator.errors[TESTER_RTYPE_EXECUTION_ERROR],
			100 * accumulator.errors[TESTER_RTYPE_EXECUTION_ERROR]
					/ (double)accumulator.count);
	printf("%lu comparison errors (%f%%)\n",
			accumulator.errors[TESTER_RTYPE_COMPARISON_ERROR],
			100 * accumulator.errors[TESTER_RTYPE_COMPARISON_ERROR]
					/ (double)accumulator.count);
	printf("%lu crashes (%f%%)\n", accumulator.errors[TESTER_RTYPE_CRASH],
			100 * accumulator.errors[TESTER_RTYPE_CRASH] / (double)accumulator.count);

	printf("Simulation errors:\n");
	printf("%lu unaligned (bit level) store errors (%f%%)\n",
			accumulator.simulation_errors[0],
			100 * accumulator.simulation_errors[0]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);
	printf("%lu undefined address errors (%f%%)\n",
			accumulator.simulation_errors[1],
			100 * accumulator.simulation_errors[1]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);
	printf("%lu undefined branch errors (%f%%)\n",
			accumulator.simulation_errors[2],
			100 * accumulator.simulation_errors[2]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);

	printf("Execution errors:\n");
	printf("%lu mapping errors (%f%%)\n",
			accumulator.execution_errors[EXECUTION_RTYPE_MAPPING_ERROR],
			100 * accumulator.execution_errors[EXECUTION_RTYPE_MAPPING_ERROR]
					/ (double)accumulator.errors[TESTER_RTYPE_EXECUTION_ERROR]);
	printf("%lu signals (%f%%)\n",
			accumulator.execution_errors[EXECUTION_RTYPE_SIGNAL],
			100 * accumulator.execution_errors[EXECUTION_RTYPE_SIGNAL]
					/ (double)accumulator.errors[TESTER_RTYPE_EXECUTION_ERROR]);

	printf("Signals:\n");
	printf("%lu SIGSEGV (%f%%)\n", accumulator.sigsegv_count,
			100 * accumulator.sigsegv_count
					/ (double)accumulator.execution_errors[EXECUTION_RTYPE_SIGNAL]);
	printf("%lu SIGILL (%f%%)\n", accumulator.sigill_count,
			100 * accumulator.sigill_count
					/ (double)accumulator.execution_errors[EXECUTION_RTYPE_SIGNAL]);
	printf("%lu SIGALRM (%f%%)\n", accumulator.sigalrm_count,
			100 * accumulator.sigalrm_count
					/ (double)accumulator.execution_errors[EXECUTION_RTYPE_SIGNAL]);
	printf("%lu SIGBUS (%f%%)\n", accumulator.sigbus_count,
			100 * accumulator.sigbus_count
					/ (double)accumulator.execution_errors[EXECUTION_RTYPE_SIGNAL]);

	for(size_t i = 0; i < entries_length; ++i) {
		free(entries[i].data);
		free(entries[i].key);
	}
	hash_array_free(ha);

	return 0;
}

//reset; /usr/bin/valgrind --vgdb=yes --vgdb-error=0  --leak-check=full ./x86-tester
