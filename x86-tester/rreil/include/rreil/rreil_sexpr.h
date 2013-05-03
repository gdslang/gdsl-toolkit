/*
 * rreil_sexpr.h
 *
 *  Created on: 03.05.2013
 *      Author: jucs
 */

#ifndef RREIL_SEXPR_H_
#define RREIL_SEXPR_H_

#include <rreil/rreil_linear.h>
#include <rreil/rreil_comparator.h>

enum rreil_sexpr_type {
	RREIL_SEXPR_TYPE_LIN,
	RREIL_SEXPR_TYPE_CMP
};

struct rreil_sexpr {
	enum rreil_sexpr_type type;
	union {
		struct rreil_linear *lin;
		struct rreil_comparator *cmp;
	};
};


#endif /* RREIL_SEXPR_H_ */
