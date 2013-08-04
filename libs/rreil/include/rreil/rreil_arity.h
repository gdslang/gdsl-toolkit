/*
 * rreil_arity.h
 *
 *  Created on: 03.05.2013
 *      Author: jucs
 */

#ifndef RREIL_ARITY_H_
#define RREIL_ARITY_H_

#include <rreil/rreil_linear.h>

struct rreil_arity1 {
	uint64_t size;
	struct rreil_linear *opnd1;
};

struct rreil_arity2 {
	uint64_t size;
	struct rreil_linear *opnd1;
	struct rreil_linear *opnd2;
};


#endif /* RREIL_ARITY_H_ */
