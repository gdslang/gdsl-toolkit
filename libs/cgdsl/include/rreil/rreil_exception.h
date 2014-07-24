/*
 * rreil_exception.h
 *
 *  Created on: Oct 4, 2013
 *      Author: jucs
 */

#ifndef RREIL_EXCEPTION_H_
#define RREIL_EXCEPTION_H_

#include <stdlib.h>
#include <stdint.h>

#ifdef GDSL_X86
#include <x86.h>
#endif

enum rreil_exception_type {
	RREIL_EXCEPTION_TYPE_SHARED,
#ifdef GDSL_X86
	RREIL_EXCEPTION_TYPE_X86
#else
	RREIL_EXCEPTION_TYPE_ARCH
#endif
};

enum rreil_exception_shared {
	RREIL_EXCEPTION_SHARED_DIVISION_BY_ZERO
};

#define RREIL_EXCEPTION_SHARED_COUNT (RREIL_EXCEPTION_SHARED_DIVISION_BY_ZERO + 1)

struct rreil_exception {
	enum rreil_exception_type type;
	union {
		enum rreil_exception_shared shared;
		union {
#ifdef GDSL_X86
			enum x86_exception x86;
#else
			char *arch;
#endif
		};
	};
};

#endif /* RREIL_EXCEPTION_H_ */
