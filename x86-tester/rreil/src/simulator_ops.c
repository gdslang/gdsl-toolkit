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
