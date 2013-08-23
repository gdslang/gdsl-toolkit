/*
 * rreil_id.c
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <rreil/rreil_id.h>

char rreil_id_equals(struct rreil_id *a, struct rreil_id *b) {
	if(a->type != b->type)
		return 0;
	switch(a->type) {
		case RREIL_ID_TYPE_VIRTUAL: {
			return a->virtual_ == b->virtual_;
		}
		case RREIL_ID_TYPE_TEMPORARY: {
			return a->temporary == b->temporary;
		}
#ifdef GDSL_X86
		case RREIL_ID_TYPE_X86: {
			return a->x86 == b->x86;
		}
#else
		case RREIL_ID_TYPE_ARCH: {
			return a->arch == b->arch;
		}
#endif
	}
	return 0;
}
