/*
 * util.h
 *
 *  Created on: Apr 29, 2013
 *      Author: jucs
 */

#ifndef UTIL_H_
#define UTIL_H_

#include <stdlib.h>
#include <stdint.h>

size_t util_append_byte(uint8_t **buffer, size_t offset, size_t *size, uint8_t byte);

#endif /* UTIL_H_ */
