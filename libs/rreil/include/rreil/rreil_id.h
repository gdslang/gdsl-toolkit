/*
 * rreil_id.h
 *
 *  Created on: 02.05.2013
 *      Author: jucs
 */

#ifndef RREIL_ID_H_
#define RREIL_ID_H_

#include <stdlib.h>
#include <stdint.h>

#ifdef GDSL_X86
#include <x86.h>
#endif

enum rreil_id_type {
	RREIL_ID_TYPE_VIRTUAL, RREIL_ID_TYPE_TEMPORARY,
#ifdef GDSL_X86
	RREIL_ID_TYPE_X86
#else
	RREIL_ID_TYPE_ARCH
#endif
};

enum rreil_id_virtual {
	RREIL_ID_VIRTUAL_EQ,
	RREIL_ID_VIRTUAL_NEQ,
	RREIL_ID_VIRTUAL_LES,
	RREIL_ID_VIRTUAL_LEU,
	RREIL_ID_VIRTUAL_LTS,
	RREIL_ID_VIRTUAL_LTU,
};

#define RREIL_ID_VIRTUAL_COUNT (RREIL_ID_VIRTUAL_LTU + 1)
#define RREIL_ID_TEMPORARY_COUNT 32

struct rreil_id {
	enum rreil_id_type type;
	union {
		enum rreil_id_virtual virtual_;
		union {
#ifdef GDSL_X86
			enum x86_id x86;
#else
			uint32_t arch;
#endif
		};
		uint64_t temporary;
	};
};

extern char rreil_id_equals(struct rreil_id *a, struct rreil_id *b);

#endif /* RREIL_ID_H_ */