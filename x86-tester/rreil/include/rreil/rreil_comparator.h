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
#include <rreil/rreil_arity.h>

enum rreil_comparator_type {
	RREIL_COMPARATOR_TYPE_EQ,
	RREIL_COMPARATOR_TYPE_NEQ,
	RREIL_COMPARATOR_TYPE_LES,
	RREIL_COMPARATOR_TYPE_LEU,
	RREIL_COMPARATOR_TYPE_LTS,
	RREIL_COMPARATOR_TYPE_LTU
};

struct rreil_comparator {
	enum rreil_comparator_type type;
	struct rreil_arity2 arity2;
};

#endif /* RREIL_COMPARATOR_H_ */
