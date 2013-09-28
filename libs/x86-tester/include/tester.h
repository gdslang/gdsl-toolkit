/*
 * tester.h
 *
 *  Created on: 15.05.2013
 *      Author: jucs
 */

#ifndef TESTER_H_
#define TESTER_H_

#include <stdlib.h>
#include <stdint.h>
#include <rreil/rreil.h>
#include <simulator/simulator.h>
#include <gdsl.h>
#include <executor.h>

enum tester_result_type {
	TESTER_RTYPE_SUCCESS = 0,
	TESTER_RTYPE_DECODING_ERROR = 1,
	TESTER_RTYPE_TRANSLATION_ERROR = 2,
	TESTER_RTYPE_SIMULATION_ERROR = 3,
	TESTER_RTYPE_TBGEN_ERROR = 4,
	TESTER_RTYPE_EXECUTION_ERROR = 5,
	TESTER_RTYPE_COMPARISON_ERROR = 6,
	TESTER_RTYPE_CRASH = 7
};

#define TESTER_RESULT_TYPES_LENGTH (TESTER_RTYPE_CRASH + 1)

struct tester_result {
	enum tester_result_type type;
	union {
		enum simulator_error simulator_error;
		struct execution_result execution_result;
	};
	uint64_t features;
};

extern struct tester_result tester_test_translated(
		struct rreil_statements *statements, uint8_t *instruction,
		size_t instruction_length, char test_unused);
extern struct tester_result tester_test_binary(void (*name)(char *), char fork_,
		uint8_t *data, size_t data_size, char test_unused);
extern void tester_result_type_print(enum tester_result_type result);

#endif /* TESTER_H_ */
