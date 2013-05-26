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

enum tester_result {
	TESTER_RESULT_SUCCESS,
	TESTER_RESULT_DECODING_ERROR,
	TESTER_RESULT_TRANSLATION_ERROR,
	TESTER_RESULT_SIMULATION_ERROR,
	TESTER_RESULT_EXECUTION_ERROR,
	TESTER_RESULT_COMPARISON_ERROR
};

char tester_test(struct rreil_statements *statements, uint8_t *instruction,
		size_t instruction_length);

#endif /* TESTER_H_ */
