/*
 * x86_features.h
 *
 *  Created on: 29.05.2013
 *      Author: jucs
 */

#ifndef X86_FEATURES_H_
#define X86_FEATURES_H_

enum x86_feature {
	X86_FEATURE_NONE = 0,
	X86_FEATURE_AES = (1 << 0),
	X86_FEATURE_AVX = (1 << 1),
	X86_FEATURE_F16C = (1 << 2),
	X86_FEATURE_INVPCID = (1 << 3),
	X86_FEATURE_MMX = (1 << 4),
	X86_FEATURE_CLMUL = (1 << 5),
	X86_FEATURE_RDRAND = (1 << 6),
	X86_FEATURE_FSGSBASE = (1 << 7),
	X86_FEATURE_SSE = (1 << 8),
	X86_FEATURE_SSE2 = (1 << 9),
	X86_FEATURE_SSE3 = (1 << 10),
	X86_FEATURE_SSE4_1 = (1 << 11),
	X86_FEATURE_SSE4_2 = (1 << 12),
	X86_FEATURE_SSSE3 = (1 << 13),
	X86_FEATURE_XSAVEOPT = (1 << 14),
	X86_FEATURE_ILLEGAL_REP = (1 << 15),
	X86_FEATURE_ILLEGAL_REPNE = (1 << 16),
	X86_FEATURE_ILLEGAL_LOCK = (1 << 17),
	X86_FEATURE_ILLEGAL_LOCK_REGISTER = (1 << 18)
};

#define X86_FEATURES_COUNT 20

extern void x86_feature_print(enum x86_feature feature);

#endif /* X86_FEATURES_H_ */
