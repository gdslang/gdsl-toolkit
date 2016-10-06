/*
 * util.h
 *
 *  Created on: Apr 29, 2013
 *      Author: jucs
 */

#ifndef UTIL_H_
#define UTIL_H_

#include <stdint.h>
#include <stdlib.h>

extern void util_array_add(void*** array, void* object, size_t* length,
                           size_t* size);
extern void util_array_insert(void*** array, void* object, size_t index,
                              size_t* length, size_t* size);
extern void util_array_elements_insert(void** array, void** elements,
                                       size_t elements_length, size_t index,
                                       size_t* length, size_t* size);
extern void util_array_generic_add(void** array, void* object,
                                   size_t object_size, size_t* length,
                                   size_t* size);
extern void util_array_generic_remove_at(void** array, size_t index,
                                         size_t object_size, size_t* length,
                                         size_t* size);

size_t util_byte_append(uint8_t** buffer, size_t offset, size_t* size,
                        uint8_t byte);

extern void membit_cpy(uint8_t* to, size_t to_offset, uint8_t* from,
                       size_t from_offset, size_t bit_length);
extern void membit_zero_fill(uint8_t* to, size_t to_offset, size_t bit_length);
extern void membit_one_fill(uint8_t* to, size_t to_offset, size_t bit_length);

#endif /* UTIL_H_ */
