/*
 * simulator_ops.c
 *
 *  Created on: 08.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <stdint-gcc.h>
#include <string.h>
#include <simulator/ops.h>
#include <util.h>
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
//		if(mask != 0xff)
//			acc = 0;
		acc *= (mask == 0xff);
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

static uint8_t local_add(uint8_t *accumulator, uint8_t opnd1, uint8_t opnd2) {
	uint16_t result = (uint16_t)opnd1 + (uint16_t)opnd2 + (uint16_t)*accumulator;
	*accumulator = result >> 8;
	return (uint8_t)result;
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

	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result.data[i] = local_add(&accumulator, opnd1.data[i], opnd2.data[i]);

	simulator_op_definition_propagate(opnd1, opnd2, &result);

	return result;
}

static char more(size_t length, struct data opnd1, struct data opnd2, size_t i) {
	return i < length - 1 && opnd1.defined[i] == 0xff
			&& opnd2.defined[i] == 0xff;
}

struct data simulator_op_sub(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	if(!bit_length) {
		struct data result;
		result.data = NULL;
		result.defined = NULL;
		result.bit_length = 0;
		return result;
	}

	size_t length = bit_length / 8 + (bit_length % 8 > 0);

	uint8_t *complement = (uint8_t*)malloc(bit_length / 8 + 1);
	for(size_t i = 0; i < length; ++i)
		complement[i] = ~opnd2.data[i];
	for(size_t i = 0; 1; ++i)
		if(!more(length, opnd1, opnd2, i) || complement[i] != 0xff) {
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
	} else if(bit_length <= 128) {
		__uint128_t *result = (__uint128_t *)malloc(sizeof(__uint128_t ));
		*result = (*((__uint128_t *)opnd1.data)) * (*((__uint128_t *)opnd2.data));
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
	} else if(bit_length <= 128) {
		__uint128_t *result = (__uint128_t *)malloc(sizeof(__uint128_t ));
		*result = (*((__uint128_t *)opnd1.data)) / (*((__uint128_t *)opnd2.data));
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
	} else if(bit_length <= 128) {
		__int128_t *result = (__int128_t *)malloc(sizeof(__int128_t ));
		*result = (*((__int128_t *)opnd1.data)) / (*((__int128_t *)opnd2.data));
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
	} else if(bit_length <= 128) {
		__uint128_t *result = (__uint128_t *)malloc(sizeof(__uint128_t ));
		*result = (*((__uint128_t *)opnd1.data)) % (*((__uint128_t *)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else
		result_data.data = NULL; //error

	simulator_op_definition_simple(opnd1, opnd2, &result_data);

	return result_data;
}

struct data simulator_op_mods(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result_data;
	result_data.bit_length = bit_length;

	if(bit_length <= 8) {
		int8_t *result = (int8_t*)malloc(sizeof(int8_t));
		*result = (*((int8_t*)opnd1.data)) % (*((int8_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 16) {
		int16_t *result = (int16_t*)malloc(sizeof(int16_t));
		*result = (*((int16_t*)opnd1.data)) % (*((int16_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 32) {
		int32_t *result = (int32_t*)malloc(sizeof(int32_t));
		*result = (*((int32_t*)opnd1.data)) % (*((int32_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 64) {
		int64_t *result = (int64_t*)malloc(sizeof(int64_t));
		*result = (*((int64_t*)opnd1.data)) % (*((int64_t*)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else if(bit_length <= 128) {
		__int128_t *result = (__int128_t *)malloc(sizeof(__int128_t ));
		*result = (*((__int128_t *)opnd1.data)) % (*((__int128_t *)opnd2.data));
		result_data.data = (uint8_t*)result;
	} else
		result_data.data = NULL; //error

	simulator_op_definition_simple(opnd1, opnd2, &result_data);

	return result_data;
}

char inside(size_t bit_length, size_t i) {
	return i < bit_length / 8 + (bit_length % 8 > 0);
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
		amount_ptr[i] = opnd2.data[i];
		if(i == bit_length / 8) {
			uint8_t mask = (1 << (bit_length % 8)) - 1;
			amount_ptr[i] &= mask;
			break;
		}
	}

	uint16_t inter = amount / 8;
	uint16_t inner = amount % 8;

	for(size_t i = 0; i < inter; ++i) {
		if(!inside(bit_length, i))
			goto end;
		result.data[i] = 0;
	}

	uint32_t acc = 0;
	uint8_t *acc_ptr = (uint8_t*)&acc;
	for(size_t i = 0; inside(bit_length, inter + i); ++i) {
		acc >>= inner + 8;
		acc_ptr[1] = opnd1.data[i];
		acc <<= inner;
		result.data[inter + i] = acc_ptr[1];
	}

	end:

	/*
	 * Todo: This is wrong.
	 */
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
		amount_ptr[i] = opnd2.data[i];
		if(i == bit_length / 8) {
			uint8_t mask = (1 << (bit_length % 8)) - 1;
			amount_ptr[i] &= mask;
			break;
		}
	}

	uint16_t inter = amount / 8;
	uint16_t inner = amount % 8;

	size_t bytes = bit_length / 8 + (bit_length % 8 > 0);

	for(size_t i = bytes, j = 0; j < inter && i > 0; --i, ++j) {
		result.data[i - 1] = 0xff * sign;
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
		result.data[bytes - inter - 1] = acc_ptr[1];
		for(size_t i = 1; inter + i < bytes; ++i) {
			acc <<= inner + 8;
			acc_ptr[1] = opnd1.data[bytes - i - 1];
			acc >>= inner;
			result.data[bytes - inter - i - 1] = acc_ptr[1];
		}
	}

	end:

	simulator_op_definition_simple(opnd1, opnd2, &result);

	return result;
}

struct data simulator_op_shr(struct data opnd1, struct data opnd2) {
	return simulator_op_shr_sign(opnd1, opnd2, 0);
}

struct data simulator_op_shrs(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	size_t bytes = bit_length / 8 + (bit_length % 8 > 0);
	uint8_t top = opnd1.data[bytes - 1];
	if(bit_length % 8)
		top >>= (bit_length % 8) - 1;
	else
		top >>= 7;
	return simulator_op_shr_sign(opnd1, opnd2, top & 0x01);
}

struct data simulator_op_and(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result;
	result.data = (uint8_t*)malloc(bit_length / 8 + 1);
	result.bit_length = bit_length;

	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result.data[i] = opnd1.data[i] & opnd2.data[i];

	simulator_op_definition_bitwise(opnd1, opnd2, &result);

	return result;
}

struct data simulator_op_or(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result;
	result.data = (uint8_t*)malloc(bit_length / 8 + 1);
	result.bit_length = bit_length;

	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result.data[i] = opnd1.data[i] | opnd2.data[i];

	simulator_op_definition_bitwise(opnd1, opnd2, &result);

	return result;
}

struct data simulator_op_xor(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result;
	result.data = (uint8_t*)malloc(bit_length / 8 + 1);
	result.bit_length = bit_length;

	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i)
		result.data[i] = opnd1.data[i] ^ opnd2.data[i];

	simulator_op_definition_bitwise(opnd1, opnd2, &result);

	return result;
}

struct data simulator_op_not(struct data opnd) {
	size_t bit_length = opnd.bit_length;

	struct data result;
	result.data = (uint8_t*)malloc(bit_length / 8 + 1);
	result.defined = (uint8_t*)malloc(bit_length / 8 + 1);
	result.bit_length = bit_length;

	for(size_t i = 0; i < bit_length / 8 + (bit_length % 8 > 0); ++i) {
		result.data[i] = ~opnd.data[i];
		result.defined[i] = opnd.defined[i];
	}

	return result;
}

struct data simulator_op_zx(size_t to, struct data opnd1) {
	size_t from = opnd1.bit_length;

	if(to < from)
		from = to;

	/*
	 * Todo: Use membit_cpy()
	 */
	struct data result;
	result.data = (uint8_t*)calloc(to / 8 + 1, 1);
	result.defined = (uint8_t*)malloc(to / 8 + 1);
	result.bit_length = to;

	memcpy(result.data, opnd1.data, from / 8);

	if(from % 8) {
		uint8_t top = opnd1.data[from / 8];
		uint8_t mask = (1 << from % 8) - 1;
		result.data[from / 8] = top & mask;
	}

	membit_cpy(result.defined, 0, opnd1.defined, 0, from);
	membit_one_fill(result.defined, from, to - from);

	return result;
}

static uint8_t *sx_buffer(size_t to, size_t from, uint8_t *opnd) {
	uint8_t *result = (uint8_t*)calloc(to / 8 + 1, 1);
	memcpy(result, opnd, from / 8);

	uint8_t sign;
	if(from / 8)
		sign = opnd[from / 8 - 1] >> 7;
	size_t next = from / 8;

//		if(opnd[1] >> 7)
//			printf("%lu\n", from/8 - 1);
//		if(opnd[from / 8 - 1] >> 7)
//			printf("%lu\n", from/8 - 1);

	if(from % 8) {
		uint8_t top = opnd[from / 8];
		sign = top >> ((from % 8) - 1);
		uint8_t mask = (1 << from % 8) - 1;
		result[from / 8] = top & mask;
		if(sign & 0x01) {
			result[from / 8] |= ~mask;
			next++;
		}
	}

	if(sign & 0x01)
		for(size_t i = next; i <= to / 8; ++i)
			result[i] = 0xff;

	return result;
}

struct data simulator_op_sx(size_t to, struct data opnd) {
	size_t from = opnd.bit_length;

	if(!from || !to) {
		struct data result;
		result.data = (uint8_t*)malloc(to);
		result.bit_length = to;
		context_data_undefine(&result);
		return result;
	}

	if(to < from)
		from = to;

	/*
	 * Todo: Use membit_cpy()
	 */


	struct data result;
	result.data = sx_buffer(to, from, opnd.data);
	result.defined = sx_buffer(to, from, opnd.defined);
	result.bit_length = to;

	return result;
}

struct data simulator_op_cmp_eq(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data result;
	result.data = (uint8_t*)malloc(1);
	result.data[0] = 1;
	/*
	 * Todo: Use only one bit
	 */
	result.bit_length = 1;

	for(size_t i = 0; i < bit_length / 8; ++i)
		if((opnd1.data[i] & opnd1.defined[i])
				!= (opnd2.data[i] & opnd2.defined[i])) {
			result.data[0] = 0;
			goto end;
		}

	if(bit_length % 8) {
		uint8_t top1 = opnd1.data[bit_length / 8];
		uint8_t top2 = opnd2.data[bit_length / 8];

		uint8_t mask = (1 << bit_length % 8) - 1;

		result.data[0] = (top1 & mask) == (top2 & mask);
	}

	end: simulator_op_definition_simple(opnd1, opnd2, &result);

	return result;
}

struct data simulator_op_cmp_neq(struct data opnd1, struct data opnd2) {
	struct data result = simulator_op_cmp_eq(opnd1, opnd2);
	result.data[0] ^= 1;
	return result;
}

static void top_bit_set(size_t bit_length, uint8_t *dst, uint8_t *src) {
	uint8_t top = src[bit_length / 8 - (bit_length % 8 == 0)];
	uint8_t local = bit_length % 8;
	if(!local)
		*dst = top >> 7;
	else
		*dst = top >> (local - 1);
}

struct data simulator_op_cmp_les(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data a = simulator_op_sub(opnd2, opnd1);
	struct data b = simulator_op_not(a);
	struct data c = simulator_op_xor(opnd1, opnd2);
	struct data d = simulator_op_or(b, c);

	struct data e = simulator_op_not(opnd2);
	struct data f = simulator_op_or(opnd1, e);

	struct data r = simulator_op_and(d, f);

	struct data result;
	result.data = (uint8_t*)malloc(1);
	result.defined = (uint8_t*)malloc(1);
	result.bit_length = 1;

	top_bit_set(bit_length, result.data, r.data);
	top_bit_set(bit_length, result.defined, r.defined);

	context_data_clear(&a);
	context_data_clear(&b);
	context_data_clear(&c);
	context_data_clear(&d);
	context_data_clear(&e);
	context_data_clear(&f);
	context_data_clear(&r);

	return result;
}

struct data simulator_op_cmp_leu(struct data opnd1, struct data opnd2) {
	/*
	 * Todo: Handle different sizes
	 */
	size_t bit_length = opnd1.bit_length;

	struct data a = simulator_op_sub(opnd2, opnd1);
	struct data b = simulator_op_not(a);
	struct data c = simulator_op_xor(opnd1, opnd2);
	struct data d = simulator_op_or(b, c);

	struct data e = simulator_op_not(opnd1);
	struct data f = simulator_op_or(opnd2, e);

	struct data r = simulator_op_and(d, f);

//	void top_bit_set(uint8_t *dst, uint8_t *src) {
//		uint8_t top = src[bit_length / 8 - (bit_length % 8 == 0)];
//		uint8_t local = bit_length % 8;
//		if(!local)
//			*dst = top >> 7;
//		else
//			*dst = top >> (local - 1);
//	}

	struct data result;
	result.data = (uint8_t*)malloc(1);
	result.defined = (uint8_t*)malloc(1);
	result.bit_length = 1;

	top_bit_set(bit_length, result.data, r.data);
	top_bit_set(bit_length, result.defined, r.defined);

	context_data_clear(&a);
	context_data_clear(&b);
	context_data_clear(&c);
	context_data_clear(&d);
	context_data_clear(&e);
	context_data_clear(&f);
	context_data_clear(&r);

	return result;
}

struct data simulator_op_cmp_lts(struct data opnd1, struct data opnd2) {
	struct data a = simulator_op_cmp_les(opnd1, opnd2);
	struct data b = simulator_op_cmp_neq(opnd1, opnd2);

	struct data result;
	result.data = (uint8_t*)malloc(1);
	result.defined = (uint8_t*)malloc(1);
	result.bit_length = 1;

	result.data[0] = a.data[0] & b.data[0];
	result.defined[0] = a.defined[0] & b.defined[0];

	context_data_clear(&a);
	context_data_clear(&b);

	return result;
}

struct data simulator_op_cmp_ltu(struct data opnd1, struct data opnd2) {
	struct data a = simulator_op_cmp_leu(opnd1, opnd2);
	struct data b = simulator_op_cmp_neq(opnd1, opnd2);

	struct data result;
	result.data = (uint8_t*)malloc(1);
	result.defined = (uint8_t*)malloc(1);
	result.bit_length = 1;

	result.data[0] = a.data[0] & b.data[0];
	result.defined[0] = a.defined[0] & b.defined[0];

	context_data_clear(&a);
	context_data_clear(&b);

	return result;
}
