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
#include <simulator/ops.h>
#include <context.h>

static void simulator_op_definition_propagate(struct data opnd1,
		struct data opnd2, struct data *result) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = result->bit_length;

	result->defined = (uint8_t*)malloc(bit_length / 8 + 1);

	uint8_t acc = 0xff;
	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i) {
		uint8_t x = opnd1.defined[i] & opnd2.defined[i];
		uint8_t mask = x & (~x - 1);
		result->defined[i] = x & mask & acc;
		if(mask != 0xff)
			acc = 0;
	}
}

static void simulator_op_definition_bitwise(struct data opnd1,
		struct data opnd2, struct data *result) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = result->bit_length;

	result->defined = (uint8_t*)malloc(bit_length / 8 + 1);

	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result->defined[i] = opnd1.defined[i] & opnd2.defined[i];
}

static void simulator_op_definition_simple(struct data opnd1, struct data opnd2,
		struct data *result) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = result->bit_length;

	void (*f)(struct data*) = &context_data_define;
	for(size_t i = 0; i < bit_length / 8; ++i) {
		uint8_t x = opnd1.defined[i] & opnd2.defined[i];
		if(x != 0xff) {
			f = &context_data_undefine;
			break;
		}
	}
	if(bit_length % 8 > 0) {
		uint8_t local = bit_length % 8;
		uint8_t last = opnd1.defined[bit_length / 8]
				& opnd2.defined[bit_length / 8];
		uint8_t mask = (1 << local) - 1;
		if((last & mask) != mask)
			f = &context_data_undefine;
	}
	f(result);
}

struct data simulator_op_add(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result;
	result.bit_length = bit_length;
	result.data = (uint8_t*)malloc(bit_length / 8 + 1);

	uint8_t accumulator = 0;
	uint8_t local_add(uint8_t opnd1, uint8_t opnd2) {
		uint16_t result = (uint16_t)opnd1 + (uint16_t)opnd2 + (uint16_t)accumulator;
		accumulator = result >> 8;
		return (uint8_t)result;
	}

	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result.data[i] = local_add(opnd1.data[i], opnd2.data[i]);

	simulator_op_definition_propagate(opnd1, opnd2, &result);

	return result;
}

struct data simulator_op_sub(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	uint8_t *complement = (uint8_t*)malloc(bit_length / 8 + 1);
	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		complement[i] = ~opnd2.data[i];
	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		if(complement[i] != 0xff) {
			complement[i]++;
			break;
		} else
			complement[i] = 0;
	opnd2.data = complement;
	struct data result = simulator_op_add(opnd1, opnd2);
	free(complement);
	return result;
}

struct data simulator_op_mul(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result_data;
	result_data.bit_length = bit_length;

	if(bit_length <= 8) {
		uint8_t *result = (uint8_t*)malloc(sizeof(uint8_t));
		*result = (*opnd1.data) * (*opnd2.data);
		result_data.data = result;
	} else if(bit_length <= 16) {
		uint16_t *result = (uint16_t*)malloc(sizeof(uint16_t));
		*result = (*((uint16_t*)opnd1.data)) * (*((uint16_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 32) {
		uint32_t *result = (uint32_t*)malloc(sizeof(uint32_t));
		*result = (*((uint32_t*)opnd1.data)) * (*((uint32_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 64) {
		uint64_t *result = (uint64_t*)malloc(sizeof(uint64_t));
		*result = (*((uint64_t*)opnd1.data)) * (*((uint64_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else
		result_data.data = NULL; //error

	simulator_op_definition_simple(opnd1, opnd2, &result_data);

	return result_data;
}

struct data simulator_op_div(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result_data;
	result_data.bit_length = bit_length;

	if(bit_length <= 8) {
		uint8_t *result = (uint8_t*)malloc(sizeof(uint8_t));
		*result = (*opnd1.data) / (*opnd2.data);
		result_data.data = result;
	} else if(bit_length <= 16) {
		uint16_t *result = (uint16_t*)malloc(sizeof(uint16_t));
		*result = (*((uint16_t*)opnd1.data)) / (*((uint16_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 32) {
		uint32_t *result = (uint32_t*)malloc(sizeof(uint32_t));
		*result = (*((uint32_t*)opnd1.data)) / (*((uint32_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 64) {
		uint64_t *result = (uint64_t*)malloc(sizeof(uint64_t));
		*result = (*((uint64_t*)opnd1.data)) / (*((uint64_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else
		result_data.data = NULL; //error

	simulator_op_definition_simple(opnd1, opnd2, &result_data);

	return result_data;
}

struct data simulator_op_divs(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result_data;
	result_data.bit_length = bit_length;

	if(bit_length <= 8) {
		int8_t *result = (int8_t*)malloc(sizeof(int8_t));
		*result = (*((int8_t*)opnd1.data)) / (*((int8_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 16) {
		int16_t *result = (int16_t*)malloc(sizeof(int16_t));
		*result = (*((int16_t*)opnd1.data)) / (*((int16_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 32) {
		int32_t *result = (int32_t*)malloc(sizeof(int32_t));
		*result = (*((int32_t*)opnd1.data)) / (*((int32_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 64) {
		int64_t *result = (int64_t*)malloc(sizeof(int64_t));
		*result = (*((int64_t*)opnd1.data)) / (*((int64_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else
		result_data.data = NULL; //error

	simulator_op_definition_simple(opnd1, opnd2, &result_data);

	return result_data;
}

struct data simulator_op_mod(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result_data;
	result_data.bit_length = bit_length;

	if(bit_length <= 8) {
		uint8_t *result = (uint8_t*)malloc(sizeof(uint8_t));
		*result = (*opnd1.data) % (*opnd2.data);
		result_data.data = result;
	} else if(bit_length <= 16) {
		uint16_t *result = (uint16_t*)malloc(sizeof(uint16_t));
		*result = (*((uint16_t*)opnd1.data)) % (*((uint16_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 32) {
		uint32_t *result = (uint32_t*)malloc(sizeof(uint32_t));
		*result = (*((uint32_t*)opnd1.data)) % (*((uint32_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 64) {
		uint64_t *result = (uint64_t*)malloc(sizeof(uint64_t));
		*result = (*((uint64_t*)opnd1.data)) % (*((uint64_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else
		result_data.data = NULL; //error
}

/*
 * Todo: bit_length == 0
 */

struct data simulator_op_shl(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result;
	result.data = (uint8_t*)malloc(bit_length / 8 + 1);
	result.bit_length = bit_length;
//	uint8_t amount = *opnd2;
//	if(bit_length < 8) {
//		uint8_t mask = (1 << bit_length) - 1;
//		amount &= mask;
//	}

	uint16_t amount = 0;
	uint8_t *amount_ptr = (uint8_t*)&amount;
	for(size_t i = 0; i < 2; ++i) {
		amount_ptr[i] = opnd2.data[i] << (i * 8);
		if(i == bit_length / 8) {
			uint8_t mask = (1 << (bit_length % 8)) - 1;
			amount_ptr[i] &= mask;
			break;
		}
	}

	uint16_t inter = amount / 8;
	uint16_t inner = amount % 8;

	char inside(size_t i) {
		return i < bit_length / 8 + (bit_length % 8 > 0);
	}

	for(size_t i = 0; i < inter; ++i) {
		if(!inside(i))
			goto end;
		result[i] = 0;
	}

	uint32_t acc = 0;
	uint8_t *acc_ptr = (uint8_t*)&acc;
	for(size_t i = 0; inside(inter + i); ++i) {
		acc >>= inner + 8;
		acc_ptr[1] = opnd1.data[i];
		acc <<= inner;
		result[inter + i] = acc_ptr[1];
	}

	end:

	simulator_op_definition_bitwise(opnd1, opnd2, &result);

	return result;
}

static struct data simulator_op_shr_sign(struct data opnd1, struct data opnd2,
		uint8_t sign) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result;
	result.data = (uint8_t*)malloc(bit_length / 8 + 1);
	result.bit_length = bit_length;

	uint16_t amount = 0;
	uint8_t *amount_ptr = (uint8_t*)&amount;
	for(size_t i = 0; i < 2; ++i) {
		amount_ptr[i] = opnd2.data[i] << (i * 8);
		if(i == bit_length / 8) {
			uint8_t mask = (1 << (bit_length % 8)) - 1;
			amount_ptr[i] &= mask;
			break;
		}
	}

	uint16_t inter = amount / 8;
	uint16_t inner = amount % 8;

	size_t bytes = bit_length / 8 + (bit_length % 8 > 0);

	for(size_t i = bytes - 1, j = 0; j < inter; --i, ++j) {
		result.data[i] = 0xff * sign;
		if(!i)
			goto end;
	}

	uint32_t acc = 0xffffffff * sign;
	uint8_t *acc_ptr = (uint8_t*)&acc;

	uint8_t top = opnd1.data[bytes - 1];

	if(inter < bytes) {
		uint8_t mask = (1 << (bit_length % 8)) - 1;
		if(bit_length % 8) {
			if(sign)
				top |= ~mask;
			else
				top &= mask;
		}
		acc_ptr[1] = top;
		acc >>= inner;
		result[bytes - inter - 1] = acc_ptr[1];
		for(size_t i = 1; inter + i < bytes; ++i) {
			acc <<= inner + 8;
			acc_ptr[1] = opnd1.data[bytes - i - 1];
			acc >>= inner;
			result[bytes - inter - i - 1] = acc_ptr[1];
		}
	}

	end:

	return result;
}

uint8_t *simulator_op_shr(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	return simulator_op_shr_sign(opnd1, opnd2, bit_length, 0);
}

uint8_t *simulator_op_shrs(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length) {
	size_t bytes = bit_length / 8 + (bit_length % 8 > 0);
	uint8_t top = opnd1[bytes - 1];
	if(bit_length % 8)
		top >>= (bit_length % 8) - 1;
	else
		top >>= 7;
	return simulator_op_shr_sign(opnd1, opnd2, bit_length, top & 0x01);
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
