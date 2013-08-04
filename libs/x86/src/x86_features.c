/*
 * x86_features.c
 *
 *  Created on: 29.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <x86_features.h>

extern void x86_feature_print(enum x86_feature feature) {
	switch(feature) {
		case X86_FEATURE_NONE: {
			printf("NONE");
			break;
		}
		case X86_FEATURE_AES: {
			printf("AES");
			break;
		}
		case X86_FEATURE_AVX: {
			printf("AVX");
			break;
		}
		case X86_FEATURE_F16C: {
			printf("F16C");
			break;
		}
		case X86_FEATURE_INVPCID: {
			printf("INVPCID");
			break;
		}
		case X86_FEATURE_MMX: {
			printf("MMX");
			break;
		}
		case X86_FEATURE_CLMUL: {
			printf("CLMUL");
			break;
		}
		case X86_FEATURE_RDRAND: {
			printf("RDRAND");
			break;
		}
		case X86_FEATURE_FSGSBASE: {
			printf("FSGSBASE");
			break;
		}
		case X86_FEATURE_SSE: {
			printf("SSE");
			break;
		}
		case X86_FEATURE_SSE2: {
			printf("SSE2");
			break;
		}
		case X86_FEATURE_SSE3: {
			printf("SSE3");
			break;
		}
		case X86_FEATURE_SSE4_1: {
			printf("SSE4_1");
			break;
		}
		case X86_FEATURE_SSE4_2: {
			printf("SSE4_2");
			break;
		}
		case X86_FEATURE_SSSE3: {
			printf("SSSE3");
			break;
		}
		case X86_FEATURE_XSAVEOPT: {
			printf("XSAVEOPT");
			break;
		}
		case X86_FEATURE_ILLEGAL_REP: {
			printf("ILLEGAL_REP");
			break;
		}
		case X86_FEATURE_ILLEGAL_REPNE: {
			printf("ILLEGAL_REPNE");
			break;
		}
		case X86_FEATURE_ILLEGAL_LOCK: {
			printf("ILLEGAL_LOCK");
			break;
		}
		case X86_FEATURE_ILLEGAL_LOCK_REGISTER: {
			printf("ILLEGAL_LOCK_REGISTER");
			break;
		}
	}
}
