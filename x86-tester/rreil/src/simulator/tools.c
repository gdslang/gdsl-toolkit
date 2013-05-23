/*
 * simulator_tools.c
 *
 *  Created on: 08.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <simulator/tools.h>

void membit_cpy(uint8_t *to, size_t to_offset, uint8_t *from, size_t from_offset,
		size_t bit_length) {
	void byte_write(uint8_t data, uint8_t length, size_t offset) {
		if(offset % 8 || length < 8) {
			uint8_t local = offset % 8;
			uint8_t low = to[offset / 8];
			uint8_t high;
			if(offset + length > 8)
				high = to[offset / 8 + 1];
			else
				high = 0;

			uint8_t length_mask = (1 << length) - 1;
			data &= length_mask;

//			uint8_t mask = (1 << local) - 1; => mask / ~mask
			low &= ~(length_mask << local);
			high &= ~(length_mask >> (8 - local));

			low |= data << local;
			high |= data >> (8 - local);

			to[offset / 8] = low;
			if(offset + length > 8)
				to[offset / 8 + 1] = high;
		} else
			to[offset / 8] = data;
	}

	uint8_t byte_read(uint8_t length, size_t offset) {
		if(length == 8 && !(offset % 8))
			return from[offset / 8];

		uint8_t local = offset % 8;
		uint8_t low = from[offset / 8];
		uint8_t high;
		if(offset + length > 8)
			high = from[offset / 8 + 1];
		else
			high = 0;

		uint16_t word = (high << 8) | low;

		word >>= local;

		uint16_t mask = (1 << length) - 1;

		return (uint8_t)(word & mask);
	}

	while(bit_length) {
		size_t next_size = bit_length > 8 ? 8 : bit_length;

		uint8_t next = byte_read(next_size, from_offset);
		byte_write(next, next_size, to_offset);

		from_offset += next_size;
		to_offset += next_size;
		bit_length -= next_size;
	}
}

void membit_zero_fill(uint8_t *to, size_t to_offset, size_t bit_length) {
	uint8_t *zeros = (uint8_t*)calloc(bit_length / 8 + 1, 1);
	membit_cpy(to, to_offset, zeros, 0, bit_length);
}

void membit_one_fill(uint8_t *to, size_t to_offset, size_t bit_length) {
	uint8_t *ones = (uint8_t*)malloc(bit_length / 8 + 1);
	for (size_t i = 0; i < bit_length/8 + 1; ++i)
		ones[i] = 0xff;
	membit_cpy(to, to_offset, ones, 0, bit_length);
}
