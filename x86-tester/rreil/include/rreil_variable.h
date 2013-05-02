/*
 * rreil_variable.h
 *
 *  Created on: 02.05.2013
 *      Author: jucs
 */

#ifndef RREIL_VARIABLE_H_
#define RREIL_VARIABLE_H_

#include <stdint.h>
#include <rreil_id.h>

struct rreil_variable {
	struct rreil_id id;
	uint64_t offset;
};


#endif /* RREIL_VARIABLE_H_ */
