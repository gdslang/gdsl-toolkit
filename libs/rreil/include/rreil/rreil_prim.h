/*
 * rreil_prim.h
 *
 *  Created on: Sep 13, 2013
 *      Author: jucs
 */

#ifndef RREIL_PRIM_H_
#define RREIL_PRIM_H_

#include "rreil_variable_limited.h"
#include "rreil_prim.h"
#include "rreil_variable.h"

enum rreil_prim_type {
	RREIL_PRIM_TYPE_GENERIC, RREIL_PRIM_TYPE_FLOP
};

struct rreil_prim {
	enum rreil_prim_type type;
	union {
		struct {
			char *op;
			struct rreil_variable_limited_tuple *res;
			struct rreil_variable_limited_tuple *args;
		} generic;
		struct {
			enum rreil_flop *op;
			struct rreil_variable *flags;
			struct rreil_variable_limited *res;
			struct rreil_variable_limited_tuple *args;
		} flop;
	};
};

#endif /* RREIL_PRIM_H_ */
