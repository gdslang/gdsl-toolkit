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
#include <rreil/rreil_x86.h>

enum rreil_id_type {
	RREIL_ID_TYPE_VIRTUAL,
	RREIL_ID_TYPE_TEMPORARY,
	RREIL_ID_TYPE_X86
};

enum rreil_id_virtual {
	RREIL_ID_VIRTUAL_EQ,
	RREIL_ID_VIRTUAL_NEQ,
	RREIL_ID_VIRTUAL_LES,
	RREIL_ID_VIRTUAL_LEU,
	RREIL_ID_VIRTUAL_LTS,
	RREIL_ID_VIRTUAL_LTU,
};

struct rreil_id {
	enum rreil_id_type type;
	union {
		enum rreil_id_virtual virtual;
		enum rreil_id_x86 x86;
		uint64_t temporary;
	};
};

#endif /* RREIL_ID_H_ */
