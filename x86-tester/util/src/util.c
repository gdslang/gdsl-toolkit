/*
 * util.c
 *
 *  Created on: Apr 29, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <util.h>

void util_array_add(void ***array, void *object, size_t *length, size_t *size) {
	if(*length + 1 > *size) {
		*size = *size ? *size << 1 : 4;
		*array = realloc(*array, *size * sizeof(void*));
	}
	(*array)[(*length)++] = object;
}

void util_array_elements_insert(void **array, void **elements, size_t elements_length,
		size_t index, size_t *length, size_t *size) {
	while(*length + elements_length > *size) {
		*size = *size ? *size << 1 : 4;
		*array = realloc(*array, *size * sizeof(void*));
	}
	memmove(*array + (index + elements_length) * sizeof(void*), *array + index * sizeof(void*),
			(*length - index) * sizeof(void*));
	memcpy(*array + index * sizeof(void*), elements, elements_length * sizeof(void*));
	*length += elements_length;
}

void util_array_generic_add(void **array, void *object, size_t object_size, size_t *length,
		size_t *size) {
	while(*length + 1 > *size) {
		*size = *size ? *size << 1 : 4;
		*array = realloc(*array, *size * object_size);
	}
	memcpy(*array + (*length) * object_size, object, object_size);
	(*length)++;
}

void util_array_generic_remove_at(void **array, size_t index, size_t object_size,
		size_t *length, size_t *size) {
	if(*size > 8 && *length - 1 < *size / 4) {
		*size = *size >> 1;
		*array = realloc(*array, *size * object_size);
	}
	memmove(*array + index * object_size, *array + (index + 1) * object_size,
			(*size - (index + 1)) * object_size);
	(*length)--;
}

size_t util_byte_append(uint8_t **buffer, size_t offset, size_t *size, uint8_t byte) {
	if(offset + 1 > *size) {
		*size = *size ? *size << 1 : 4;
		*buffer = (uint8_t*)realloc(*buffer, *size);
	}
	(*buffer)[offset++] = byte;
	return offset;
}
