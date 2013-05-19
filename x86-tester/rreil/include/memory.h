/*
 * memory.h
 *
 *  Created on: 18.05.2013
 *      Author: jucs
 */

#ifndef MEMORY_H_
#define MEMORY_H_

#include <stdlib.h>
#include <stdint.h>
#include <context.h>

extern void *memory_ptr_get(uint8_t *address, uint64_t address_size);
extern void memory_load(struct context *context, uint8_t **buffer,
		uint8_t *address, uint64_t address_size, uint64_t access_size, uint8_t *source);
extern void memory_store(struct context *context, uint8_t *buffer,
		uint8_t *address, uint64_t address_size, uint64_t access_size);

#endif /* MEMORY_H_ */
