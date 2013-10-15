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
#include <x86_features.h>
#include "hash_array.h"

struct options {
	unsigned long n;
	char test_unused;
};

#define LOG_SIMULATOR_ERROR_UNALIGNED_STORE 0
#define LOG_SIMULATOR_ERROR_UNDEFINED_ADDRESS 1
#define LOG_SIMULATOR_ERROR_UNDEFINED_STORE 2
#define LOG_SIMULATOR_ERROR_UNDEFINED_BRANCH 3
#define LOG_SIMULATOR_ERROR_FLOP_UNIMPLEMENTED 4
#define LOG_SIMULATOR_ERROR_PRIMITIVE_UNKNOWN 5
#define LOG_SIMULATOR_ERROR_PRIMITIVE_SIGNATURE_INVALID 6
#define LOG_SIMULATOR_ERROR_MAX_LOOP_ITERATIONS_COUNT_EXCEEDED 7
#define LOG_SIMULATOR_ERROR_EXCEPTION 8

struct insn_data {
	size_t errors[TESTER_RESULT_TYPES_LENGTH];
	size_t simulation_errors[SIMULATOR_ERRORS_COUNT - 1];
	size_t execution_errors[EXECUTOR_RESULTS_COUNT];
	size_t sigsegv_count;
	size_t sigill_count;
	size_t sigalrm_count;
	size_t sigbus_count;
	size_t sigfpe_count;
	size_t sigsys_count;
	size_t sigtrap_count;
	size_t count;
};

struct feature_data {
	size_t success;
	size_t failed;
};

static struct hash_array *insn_types;
static struct insn_data *insn_data = NULL;

static void for_name(char *name) {
	size_t name_length = strlen(name);
	char *copy = (char*)malloc(name_length + 1);
	memcpy(copy, name, name_length + 1);

	ENTRY *e = hash_array_search_insert(insn_types, copy);

	if(!e->data)
		e->data = (struct insn_data*)calloc(sizeof(struct insn_data), 1);
	else
		free(copy);
	insn_data = (struct insn_data*)e->data;
}

static void incf(struct tester_result *result, struct feature_data *features, size_t i) {
	if(result->type == TESTER_RTYPE_SUCCESS)
		features[i].success++;
	else
		features[i].failed++;
}

static char test_instruction(struct feature_data *features,
		struct hash_array *insn_types_, uint8_t *data, size_t data_size,
		char test_unused) {
	insn_types = insn_types_;

	struct tester_result result = tester_test_binary(&for_name, 1, data,
			data_size, test_unused);

	if(insn_data) {
		insn_data->count++;
		insn_data->errors[result.type]++;

		switch(result.type) {
			case TESTER_RTYPE_SIMULATION_ERROR: {
				if(result.simulator_error & SIMULATOR_ERROR_UNALIGNED_STORE)
					insn_data->simulation_errors[LOG_SIMULATOR_ERROR_UNALIGNED_STORE]++;
				if(result.simulator_error & SIMULATOR_ERROR_UNDEFINED_ADDRESS)
					insn_data->simulation_errors[LOG_SIMULATOR_ERROR_UNDEFINED_ADDRESS]++;
				if(result.simulator_error & SIMULATOR_ERROR_UNDEFINED_STORE)
					insn_data->simulation_errors[LOG_SIMULATOR_ERROR_UNDEFINED_STORE]++;
				if(result.simulator_error & SIMULATOR_ERROR_UNDEFINED_BRANCH)
					insn_data->simulation_errors[LOG_SIMULATOR_ERROR_UNDEFINED_BRANCH]++;
				if(result.simulator_error & SIMULATOR_ERROR_FLOP_UNIMPLEMENTED)
					insn_data->simulation_errors[LOG_SIMULATOR_ERROR_FLOP_UNIMPLEMENTED]++;
				if(result.simulator_error & SIMULATOR_ERROR_PRIMITIVE_UNKNOWN)
					insn_data->simulation_errors[LOG_SIMULATOR_ERROR_PRIMITIVE_UNKNOWN]++;
				if(result.simulator_error & SIMULATOR_ERROR_PRIMITIVE_SIGNATURE_INVALID)
					insn_data->simulation_errors[LOG_SIMULATOR_ERROR_PRIMITIVE_SIGNATURE_INVALID]++;
				if(result.simulator_error & SIMULATOR_ERROR_MAX_LOOP_ITERATIONS_COUNT_EXCEEDED)
					insn_data->simulation_errors[LOG_SIMULATOR_ERROR_MAX_LOOP_ITERATIONS_COUNT_EXCEEDED]++;
				if(result.simulator_error & SIMULATOR_ERROR_EXCEPTION)
					insn_data->simulation_errors[LOG_SIMULATOR_ERROR_EXCEPTION]++;
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
						case SIGFPE: {
							insn_data->sigfpe_count++;
							break;
						}
						case SIGSYS: {
							insn_data->sigsys_count++;
							break;
						}
						case SIGTRAP: {
							insn_data->sigtrap_count++;
							break;
						}
					}
				break;
			}
			default:
				break;
		}

		if(result.type != TESTER_RTYPE_DECODING_ERROR) { //Always true ;-)

			for(size_t i = 1; i < X86_FEATURES_COUNT; ++i)
				if(result.features & (1 << (i - 1)))
					incf(&result, features, i);
			if(!result.features)
				incf(&result, features, 0);
		}
		return 0;
	} else
		return 1;
}

static char args_parse(int argc, char **argv, struct options *options) {
	options->n = 100;
	options->test_unused = 0;

	while(1) {
		char c = getopt(argc, argv, "n:u");
		switch(c) {
			case 'n': {
				sscanf(optarg, "%lu", &options->n);
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

	struct hash_array *insn_types = hash_array_init(32768);
	struct feature_data *features = (struct feature_data *)calloc(
			X86_FEATURES_COUNT, sizeof(struct feature_data));

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

		decode_errors += test_instruction(features, insn_types, (uint8_t *)buffer,
				length, options.test_unused);

		free(buffer);
	}

	generator_tree_free(root);

	ENTRY *entries;
	size_t entries_length = hash_array_entries_get(insn_types, &entries);
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
		accumulator.sigfpe_count += data->sigfpe_count;
		accumulator.sigsys_count += data->sigsys_count;
		accumulator.sigtrap_count += data->sigtrap_count;
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
			accumulator.simulation_errors[LOG_SIMULATOR_ERROR_UNALIGNED_STORE],
			100 * accumulator.simulation_errors[LOG_SIMULATOR_ERROR_UNALIGNED_STORE]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);
	printf("%lu undefined address errors (%f%%)\n",
			accumulator.simulation_errors[LOG_SIMULATOR_ERROR_UNDEFINED_ADDRESS],
			100 * accumulator.simulation_errors[LOG_SIMULATOR_ERROR_UNDEFINED_ADDRESS]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);
	printf("%lu undefined data (to be stored) errors (%f%%)\n",
			accumulator.simulation_errors[LOG_SIMULATOR_ERROR_UNDEFINED_STORE],
			100 * accumulator.simulation_errors[LOG_SIMULATOR_ERROR_UNDEFINED_STORE]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);
	printf("%lu undefined branch errors (%f%%)\n",
			accumulator.simulation_errors[LOG_SIMULATOR_ERROR_UNDEFINED_BRANCH],
			100 * accumulator.simulation_errors[LOG_SIMULATOR_ERROR_UNDEFINED_BRANCH]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);
	printf("%lu unimplemented flop errors (%f%%)\n",
			accumulator.simulation_errors[LOG_SIMULATOR_ERROR_FLOP_UNIMPLEMENTED],
			100 * accumulator.simulation_errors[LOG_SIMULATOR_ERROR_FLOP_UNIMPLEMENTED]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);
	printf("%lu unknown primitive errors (%f%%)\n",
			accumulator.simulation_errors[LOG_SIMULATOR_ERROR_PRIMITIVE_UNKNOWN],
			100 * accumulator.simulation_errors[LOG_SIMULATOR_ERROR_PRIMITIVE_UNKNOWN]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);
	printf("%lu invalid primitive signature errors (%f%%)\n",
			accumulator.simulation_errors[LOG_SIMULATOR_ERROR_PRIMITIVE_SIGNATURE_INVALID],
			100 * accumulator.simulation_errors[LOG_SIMULATOR_ERROR_PRIMITIVE_SIGNATURE_INVALID]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);
	printf("%lu loop iteration count limit exceedance errors (%f%%)\n",
			accumulator.simulation_errors[LOG_SIMULATOR_ERROR_MAX_LOOP_ITERATIONS_COUNT_EXCEEDED],
			100 * accumulator.simulation_errors[LOG_SIMULATOR_ERROR_MAX_LOOP_ITERATIONS_COUNT_EXCEEDED]
					/ (double)accumulator.errors[TESTER_RTYPE_SIMULATION_ERROR]);
	printf("%lu unexpected exception errors (%f%%)\n",
			accumulator.simulation_errors[LOG_SIMULATOR_ERROR_EXCEPTION],
			100 * accumulator.simulation_errors[LOG_SIMULATOR_ERROR_EXCEPTION]
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
	printf("%lu SIGFPE (%f%%)\n", accumulator.sigfpe_count,
			100 * accumulator.sigfpe_count
					/ (double)accumulator.execution_errors[EXECUTION_RTYPE_SIGNAL]);
	printf("%lu SIGSYS (%f%%)\n", accumulator.sigsys_count,
			100 * accumulator.sigsys_count
					/ (double)accumulator.execution_errors[EXECUTION_RTYPE_SIGNAL]);
	printf("%lu SIGTRAP (%f%%)\n", accumulator.sigtrap_count,
			100 * accumulator.sigtrap_count
					/ (double)accumulator.execution_errors[EXECUTION_RTYPE_SIGNAL]);

	printf("Instruction tests by feature:\n");
	for(size_t i = 0; i < X86_FEATURES_COUNT; ++i) {
		size_t total = features[i].success + features[i].failed;
		x86_feature_print(i ? (1 << (i - 1)) : 0);
		printf(": %lu total, %lu failed", total, features[i].failed);
		if(total)
			printf(" (%f%% success)\n", 100 * features[i].success / (double)total);
		else
			printf("\n");
	}

	for(size_t i = 0; i < entries_length; ++i) {
		free(entries[i].data);
		free(entries[i].key);
	}
	hash_array_free(insn_types);
	free(features);

	return 0;
}

//reset; /usr/bin/valgrind --vgdb=yes --vgdb-error=0  --leak-check=full ./x86-tester
