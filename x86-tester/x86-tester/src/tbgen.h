/*
 * tester.h
 *
 *  Created on: 14.05.2013
 *      Author: jucs
 */

#ifndef TBGEN_H_
#define TBGEN_H_

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <context.h>
#include <simulator/tracking.h>
#include <x86.h>

size_t tbgen_code_generate(uint8_t **buffer, uint8_t *instruction,
		size_t instruction_length, struct simulator_trace *trace,
		struct context *context);

#endif /* TBGEN_H_ */
