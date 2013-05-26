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

char tester_test(struct rreil_statements *statements, uint8_t *instruction,
		size_t instruction_length);

#endif /* TESTER_H_ */
