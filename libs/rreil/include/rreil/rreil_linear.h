/*
 * rreil_linear.h
 *
 *  Created on: 02.05.2013
 *      Author: jucs
 */

#ifndef RREIL_LINEAR_H_
#define RREIL_LINEAR_H_

#include <stdint.h>
#include <rreil/rreil_variable.h>

enum rreil_linear_type {
	RREIL_LINEAR_TYPE_VARIABLE,
	RREIL_LINEAR_TYPE_IMMEDIATE,
	RREIL_LINEAR_TYPE_SUM,
	RREIL_LINEAR_TYPE_DIFFERENCE,
	RREIL_LINEAR_TYPE_SCALE
};

struct rreil_linear {
	enum rreil_linear_type type;
	union {
		struct rreil_variable *variable;
		long long unsigned int immediate;
		struct {
			struct rreil_linear *opnd1;
			struct rreil_linear *opnd2;
		} sum;
		struct {
			struct rreil_linear *opnd1;
			struct rreil_linear *opnd2;
		} difference;
		struct {
			long long unsigned int imm;
			struct rreil_linear *opnd;
		} scale;
	};
};

extern struct rreil_linear *rreil_linear_variable_alloc(struct rreil_variable *variable);

#endif /* RREIL_LINEAR_H_ */
