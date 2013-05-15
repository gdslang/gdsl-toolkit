/*
 * tester.h
 *
 *  Created on: 14.05.2013
 *      Author: jucs
 */

#ifndef TESTER_H_
#define TESTER_H_

size_t tbgen_code_generate(uint8_t **buffer, uint8_t *instruction,
		size_t instruction_length, struct simulator_trace *trace,
		struct simulator_context *context);

#endif /* TESTER_H_ */
