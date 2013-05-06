/*
 * rreil_comperator.h
 *
 *  Created on: 02.05.2013
 *      Author: jucs
 */

#ifndef RREIL_COMPARATOR_H_
#define RREIL_COMPARATOR_H_

#include <stdint.h>
#include <rreil/rreil_linear.h>

enum rreil_comparator_type {
	RREIL_COMPARATOR_EQ,
	RREIL_COMPARATOR_NEQ,
	RREIL_COMPARATOR_LES,
	RREIL_COMPARATOR_LEU,
	RREIL_COMPARATOR_LTS,
	RREIL_COMPARATOR_LTU
};

struct rreil_comparator {
	enum rreil_comparator_type type;
	uint64_t size;
	struct rreil_linear *opnd1;
	struct rreil_linear *opnd2;
};

#endif /* RREIL_COMPARATOR_H_ */
