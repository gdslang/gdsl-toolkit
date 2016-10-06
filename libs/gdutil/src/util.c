/*
 * util.c
 *
 *  Created on: Apr 29, 2013
 *      Author: jucs
 */

#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <util.h>

void util_array_add(void*** array, void* object, size_t* length, size_t* size) {
  if (*length + 1 > *size) {
    *size = *size ? *size << 1 : 4;
    *array = realloc(*array, *size * sizeof(void*));
  }
  (*array)[(*length)++] = object;
}

void util_array_elements_insert(void** array, void** elements,
                                size_t elements_length, size_t index,
                                size_t* length, size_t* size) {
  while (*length + elements_length > *size) {
    *size = *size ? *size << 1 : 4;
    *array = realloc(*array, *size * sizeof(void*));
  }
  memmove(*array + (index + elements_length) * sizeof(void*),
          *array + index * sizeof(void*), (*length - index) * sizeof(void*));
  memcpy(*array + index * sizeof(void*), elements,
         elements_length * sizeof(void*));
  *length += elements_length;
}

void util_array_generic_add(void** array, void* object, size_t object_size,
                            size_t* length, size_t* size) {
  while (*length + 1 > *size) {
    *size = *size ? *size << 1 : 4;
    *array = realloc(*array, *size * object_size);
  }
  memcpy(*array + (*length) * object_size, object, object_size);
  (*length)++;
}

void util_array_generic_remove_at(void** array, size_t index,
                                  size_t object_size, size_t* length,
                                  size_t* size) {
  if (*size > 8 && *length - 1 < *size / 4) {
    *size = *size >> 1;
    *array = realloc(*array, *size * object_size);
  }
  memmove(*array + index * object_size, *array + (index + 1) * object_size,
          (*size - (index + 1)) * object_size);
  (*length)--;
}

size_t util_byte_append(uint8_t** buffer, size_t offset, size_t* size,
                        uint8_t byte) {
  if (offset + 1 > *size) {
    *size = *size ? *size << 1 : 4;
    *buffer = (uint8_t*)realloc(*buffer, *size);
  }
  (*buffer)[offset++] = byte;
  return offset;
}

static void byte_write(uint8_t* to, uint8_t data, uint8_t length,
                       size_t offset) {
  if (offset % 8 || length < 8) {
    uint8_t local = offset % 8;
    uint8_t low = to[offset / 8];
    uint8_t high;
    if (offset % 8 + length > 8)
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
    if (offset % 8 + length > 8) to[offset / 8 + 1] = high;
  } else
    to[offset / 8] = data;
}

static uint8_t byte_read(uint8_t* from, uint8_t length, size_t offset) {
  if (length == 8 && !(offset % 8)) return from[offset / 8];

  uint8_t local = offset % 8;
  uint8_t low = from[offset / 8];
  uint8_t high;
  if (offset % 8 + length > 8)
    high = from[offset / 8 + 1];
  else
    high = 0;

  uint16_t word = (high << 8) | low;

  word >>= local;

  uint16_t mask = (1 << length) - 1;

  return (uint8_t)(word & mask);
}

void membit_cpy(uint8_t* to, size_t to_offset, uint8_t* from,
                size_t from_offset, size_t bit_length) {
  while (bit_length) {
    size_t next_size = bit_length > 8 ? 8 : bit_length;

    uint8_t next = byte_read(from, next_size, from_offset);
    byte_write(to, next, next_size, to_offset);

    from_offset += next_size;
    to_offset += next_size;
    bit_length -= next_size;
  }
}

void membit_zero_fill(uint8_t* to, size_t to_offset, size_t bit_length) {
  uint8_t* zeros = (uint8_t*)calloc(bit_length / 8 + 1, 1);
  membit_cpy(to, to_offset, zeros, 0, bit_length);
  free(zeros);
}

void membit_one_fill(uint8_t* to, size_t to_offset, size_t bit_length) {
  uint8_t* ones = (uint8_t*)malloc(bit_length / 8 + 1);
  for (size_t i = 0; i < bit_length / 8 + 1; ++i) ones[i] = 0xff;
  membit_cpy(to, to_offset, ones, 0, bit_length);
  free(ones);
}
