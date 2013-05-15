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

void membitcpy(uint8_t *to, uint8_t *from, size_t bits) {
	memcpy(to, from, bits/8);
	if(bits % 8) {
		uint8_t from_high = from[bits/8];
		uint8_t to_high = to[bits/8];

		uint8_t mask = (1 << (bits % 8)) - 1;

		to[bits/8] = (to_high & ~mask) | (from_high & mask);
	}
}
