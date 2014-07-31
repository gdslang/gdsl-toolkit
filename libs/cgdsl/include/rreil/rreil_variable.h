/*
 * rreil_variable.h
 *
 *  Created on: 02.05.2013
 *      Author: jucs
 */

#ifndef RREIL_VARIABLE_H_
#define RREIL_VARIABLE_H_

#include <stdint.h>
#include <rreil/rreil_id.h>

struct rreil_variable {
	struct rreil_id *id;
	long long unsigned offset;
};

extern struct rreil_variable *rreil_variable_alloc(struct rreil_id *id, long long unsigned offset);

#endif /* RREIL_VARIABLE_H_ */
