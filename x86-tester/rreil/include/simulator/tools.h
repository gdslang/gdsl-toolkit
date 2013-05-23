/*
 * simulator_tools.h
 *
 *  Created on: 08.05.2013
 *      Author: jucs
 */

#ifndef SIMULATOR_TOOLS_H_
#define SIMULATOR_TOOLS_H_

#include <stdint.h>

extern void membit_cpy(uint8_t *to, size_t to_offset, uint8_t *from,
		size_t from_offset, size_t bit_length);
extern void membit_zero_fill(uint8_t *to, size_t to_offset, size_t bit_length);
extern void membit_one_fill(uint8_t *to, size_t to_offset, size_t bit_length);

#endif /* SIMULATOR_TOOLS_H_ */
