/*
 * rreil_variable_limited.h
 *
 *  Created on: Sep 13, 2013
 *      Author: jucs
 */

#ifndef RREIL_VARIABLE_LIMITED_H_
#define RREIL_VARIABLE_LIMITED_H_

#include <stdlib.h>
#include <stdint.h>

struct rreil_variable_limited {
	struct rreil_id *id;
	uint64_t offset;
	uint64_t size;
};

struct rreil_variable_limited_tuple {
	struct rreil_variable_limited **variables;
	size_t variables_length;
	size_t variables_size;
};

#endif /* RREIL_VARIABLE_LIMITED_H_ */
