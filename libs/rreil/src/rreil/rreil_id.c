/*
 * rreil_id.c
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <rreil/rreil_id.h>

char rreil_id_equals(struct rreil_id *a, struct rreil_id *b) {
	if(a->type != b->type)
		return 0;
	switch(a->type) {
		case RREIL_ID_TYPE_SHARED: {
			return a->shared == b->shared;
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
			return !strcmp(a->arch, b->arch);
		}
#endif
	}
	return 0;
}

static char compare_long_unsinged(long unsigned int a, long unsigned int b) {
	if(a == b)
		return 0;
	else if(a < b)
		return -1;
	return 1;
}

char rreil_id_compare(struct rreil_id *a, struct rreil_id *b) {
	if(a->type != b->type)
		return compare_long_unsinged(a->type, b->type);
	switch(a->type) {
		case RREIL_ID_TYPE_SHARED: {
			return compare_long_unsinged(a->shared, b->shared);
		}
		case RREIL_ID_TYPE_TEMPORARY: {
			return compare_long_unsinged(a->temporary, b->temporary);
		}
#ifdef GDSL_X86
		case RREIL_ID_TYPE_X86: {
			return compare_long_unsinged(a->x86, b->x86);
		}
#else
		case RREIL_ID_TYPE_ARCH: {
			return strcmp(a->arch, b->arch);
		}
#endif
	}
	return 0;
}
