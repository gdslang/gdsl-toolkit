/*
 * util.c
 *
 *  Created on: Apr 29, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>

size_t util_append_byte(uint8_t **buffer, size_t offset, size_t *size, uint8_t byte) {
	if(offset + 1 > *size) {
		*size *= 2;
		*buffer = (uint8_t*)realloc(*buffer, *size);
	}
	(*buffer)[offset++] = byte;
	return offset;
}
