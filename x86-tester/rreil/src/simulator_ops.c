/*
 * simulator_ops.c
 *
 *  Created on: 08.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <simulator_ops.h>

uint8_t *simulator_op_add(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	uint8_t *result = (uint8_t*)malloc(bit_length / 8 + 1);

	uint8_t accumulator = 0;
	uint8_t local_add(uint8_t opnd1, uint8_t opnd2) {
		uint16_t result = (uint16_t)opnd1 + (uint16_t)opnd2 + (uint16_t)accumulator;
		accumulator = result >> 8;
		return (uint8_t)result;
	}

	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result[i] = local_add(opnd1[i], opnd2[i]);

	return result;
}

uint8_t *simulator_op_sub(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	uint8_t *complement = (uint8_t*)malloc(bit_length / 8 + 1);
	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		complement[i] = ~opnd2[i];
	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		if(complement[i] != 0xff) {
			complement[i]++;
			break;
		} else
			complement[i] = 0;
	uint8_t *result = simulator_op_add(opnd1, complement, bit_length);
	free(complement);
	return result;
}

uint8_t *simulator_op_mul(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	if(bit_length <= 8) {
		uint8_t *result = (uint8_t*)malloc(sizeof(uint8_t));
		*result = (*opnd1) * (*opnd2);
		return result;
	} else if(bit_length <= 16) {
		uint16_t *result = (uint16_t*)malloc(sizeof(uint16_t));
		*result = (*((uint16_t*)opnd1)) * (*((uint16_t*)opnd2));
		return (uint8_t*)result;
	} else if(bit_length <= 32) {
		uint32_t *result = (uint32_t*)malloc(sizeof(uint32_t));
		*result = (*((uint32_t*)opnd1)) * (*((uint32_t*)opnd2));
		return (uint8_t*)result;
	} else if(bit_length <= 64) {
		uint64_t *result = (uint64_t*)malloc(sizeof(uint64_t));
		*result = (*((uint64_t*)opnd1)) * (*((uint64_t*)opnd2));
		return (uint8_t*)result;
	} else
		return NULL; //error
}

uint8_t *simulator_op_div(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	if(bit_length <= 8) {
		uint8_t *result = (uint8_t*)malloc(sizeof(uint8_t));
		*result = (*opnd1) / (*opnd2);
		return result;
	} else if(bit_length <= 16) {
		uint16_t *result = (uint16_t*)malloc(sizeof(uint16_t));
		*result = (*((uint16_t*)opnd1)) / (*((uint16_t*)opnd2));
		return (uint8_t*)result;
	} else if(bit_length <= 32) {
		uint32_t *result = (uint32_t*)malloc(sizeof(uint32_t));
		*result = (*((uint32_t*)opnd1)) / (*((uint32_t*)opnd2));
		return (uint8_t*)result;
	} else if(bit_length <= 64) {
		uint64_t *result = (uint64_t*)malloc(sizeof(uint64_t));
		*result = (*((uint64_t*)opnd1)) / (*((uint64_t*)opnd2));
		return (uint8_t*)result;
	} else
		return NULL; //error
}

uint8_t *simulator_op_divs(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	if(bit_length <= 8) {
		int8_t *result = (int8_t*)malloc(sizeof(int8_t));
		*result = (*((int8_t*)opnd1)) / (*((int8_t*)opnd2));
		return (uint8_t*)result;
	} else if(bit_length <= 16) {
		int16_t *result = (int16_t*)malloc(sizeof(int16_t));
		*result = (*((int16_t*)opnd1)) / (*((int16_t*)opnd2));
		return (uint8_t*)result;
	} else if(bit_length <= 32) {
		int32_t *result = (int32_t*)malloc(sizeof(int32_t));
		*result = (*((int32_t*)opnd1)) / (*((int32_t*)opnd2));
		return (uint8_t*)result;
	} else if(bit_length <= 64) {
		int64_t *result = (int64_t*)malloc(sizeof(int64_t));
		*result = (*((int64_t*)opnd1)) / (*((int64_t*)opnd2));
		return (uint8_t*)result;
	} else
		return NULL; //error
}

uint8_t *simulator_op_mod(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	if(bit_length <= 8) {
		uint8_t *result = (uint8_t*)malloc(sizeof(uint8_t));
		*result = (*opnd1) % (*opnd2);
		return result;
	} else if(bit_length <= 16) {
		uint16_t *result = (uint16_t*)malloc(sizeof(uint16_t));
		*result = (*((uint16_t*)opnd1)) % (*((uint16_t*)opnd2));
		return (uint8_t*)result;
	} else if(bit_length <= 32) {
		uint32_t *result = (uint32_t*)malloc(sizeof(uint32_t));
		*result = (*((uint32_t*)opnd1)) % (*((uint32_t*)opnd2));
		return (uint8_t*)result;
	} else if(bit_length <= 64) {
		uint64_t *result = (uint64_t*)malloc(sizeof(uint64_t));
		*result = (*((uint64_t*)opnd1)) % (*((uint64_t*)opnd2));
		return (uint8_t*)result;
	} else
		return NULL; //error
}

/*
 * Todo: bit_length == 0
 */

uint8_t *simulator_op_shl(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	uint8_t *result = (uint8_t*)malloc(bit_length / 8 + 1);
	uint8_t amount = *opnd2;
	if(bit_length < 8) {
		uint8_t mask = (1 << bit_length) - 1;
		amount &= mask;
	}

	uint8_t inter = amount / 8;
	uint8_t inner = amount % 8;

	char inside(size_t i) {
		return i < bit_length / 8 + (bit_length % 8 > 0);
	}

	for(size_t i = 0; i < inter; ++i) {
		if(!inside(i))
			return result;
		result[i] = 0;
	}

	uint32_t acc = 0;
	uint8_t *acc_ptr = (uint8_t*)&acc;
	for (size_t i = 0; inside(inter + i); ++i) {
		acc >>= inner + 8;
		acc_ptr[1] = opnd1[i];
		acc <<= inner;
		result[inter + i] = acc_ptr[1];
	}

	return result;
}

uint8_t *simulator_op_and(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	uint8_t *result = (uint8_t*)malloc(bit_length / 8 + 1);
	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result[i] = opnd1[i] & opnd2[i];
	return result;
}

uint8_t *simulator_op_or(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	uint8_t *result = (uint8_t*)malloc(bit_length / 8 + 1);
	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result[i] = opnd1[i] | opnd2[i];
	return result;
}

uint8_t *simulator_op_xor(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	uint8_t *result = (uint8_t*)malloc(bit_length / 8 + 1);
	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result[i] = opnd1[i] ^ opnd2[i];
	return result;
}

uint8_t *simulator_op_not(uint8_t *opnd, size_t bit_length) {
	uint8_t *result = (uint8_t*)malloc(bit_length / 8 + 1);
	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result[i] = ~opnd[i];
	return result;
}

uint8_t *simulator_op_zx(size_t from, size_t to, uint8_t *opnd1) {
	if(to < from)
		from = to;

	uint8_t *result = (uint8_t*)calloc(to / 8 + 1, 1);
	memcpy(result, opnd1, from / 8);

	if(from % 8) {
		uint8_t top = opnd1[from / 8];
		uint8_t mask = (1 << from % 8) - 1;
		result[from / 8] = top & mask;
	}

	return result;
}

uint8_t *simulator_op_sx(size_t from, size_t to, uint8_t *opnd1) {
	if(to < from)
		from = to;
	uint8_t *result = (uint8_t*)calloc(to / 8 + 1, 1);
	memcpy(result, opnd1, from / 8);

	uint8_t sign;
	if(from / 8)
		sign = opnd1[from / 8 - 1] >> 7;
	size_t next = from / 8;

	if(from % 8) {
		uint8_t top = opnd1[from / 8];
		sign = top >> ((from % 8) - 1);
		uint8_t mask = (1 << from % 8) - 1;
		result[from / 8] = top & mask;
		if(sign) {
			result[from / 8] |= ~mask;
			next++;
		}
	}

	if(sign)
		for(size_t i = next; i <= to / 8; ++i)
			result[i] = 0xff;

	return result;
}

uint8_t simulator_op_cmp_eq(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	for(size_t i = 0; i < bit_length / 8; ++i)
		if(opnd1[i] != opnd2[i])
			return 0;

	if(bit_length % 8) {
		uint8_t top1 = opnd1[bit_length / 8];
		uint8_t top2 = opnd2[bit_length / 8];

		uint8_t mask = (1 << bit_length % 8) - 1;

		return (top1 & mask) == (top2 & mask);
	}

	return 1;
}

uint8_t simulator_op_cmp_neq(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	return !simulator_op_cmp_eq(opnd1, opnd2, bit_length);
}

uint8_t simulator_op_cmp_les(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	uint8_t *a = simulator_op_sub(opnd2, opnd1, bit_length);
	uint8_t *b = simulator_op_not(a, bit_length);
	uint8_t *c = simulator_op_xor(opnd1, opnd2, bit_length);
	uint8_t *d = simulator_op_or(b, c, bit_length);

	uint8_t *e = simulator_op_not(opnd2, bit_length);
	uint8_t *f = simulator_op_or(opnd1, e, bit_length);

	uint8_t *result = simulator_op_and(d, f, bit_length);

	uint8_t top = result[bit_length / 8 - (bit_length % 8 == 0)];

	free(a);
	free(b);
	free(c);
	free(d);
	free(e);
	free(f);
	free(result);

	uint8_t local = bit_length % 8;
	if(!local)
		return top >> 7;
	else
		return top >> (local - 1);

//	if(bit_length % 8) {
//		uint8_t local = bit_length % 8;
//		int8_t top1 = (int8_t)opnd1[bit_length / 8] << (8 - local);
//		int8_t top2 = (int8_t)opnd2[bit_length / 8] << (8 - local);
//
//		if(top1 <= top2)
//			return 1;
//		else if(top1 > top2)
//			return 0;
//	}
//
//	for(size_t i = bit_length / 8 - 1; i >= 0 ; --i)
//		if(opnd1[i] <= top2)
//			return 1;
//		else if(opnd1[i] > top2)
//			return 0;
}

uint8_t simulator_op_cmp_leu(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	uint8_t *a = simulator_op_sub(opnd2, opnd1, bit_length);
	uint8_t *b = simulator_op_not(a, bit_length);
	uint8_t *c = simulator_op_xor(opnd1, opnd2, bit_length);
	uint8_t *d = simulator_op_or(b, c, bit_length);

	uint8_t *e = simulator_op_not(opnd1, bit_length);
	uint8_t *f = simulator_op_or(opnd2, e, bit_length);

	uint8_t *result = simulator_op_and(d, f, bit_length);

	uint8_t top = result[bit_length / 8 - (bit_length % 8 == 0)];

	free(a);
	free(b);
	free(c);
	free(d);
	free(e);
	free(f);
	free(result);

	uint8_t local = bit_length % 8;
	if(!local)
		return top >> 7;
	else
		return top >> (local - 1);
}

uint8_t simulator_op_cmp_lts(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	return simulator_op_cmp_les(opnd1, opnd2, bit_length)
			&& simulator_op_cmp_neq(opnd1, opnd2, bit_length);
}

uint8_t simulator_op_cmp_ltu(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	return simulator_op_cmp_leu(opnd1, opnd2, bit_length)
			&& simulator_op_cmp_neq(opnd1, opnd2, bit_length);
}
