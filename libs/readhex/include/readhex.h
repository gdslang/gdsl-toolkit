/*
 * readhex.h
 *
 *  Created on: May 28, 2012
 *      Author: jucs
 */

#ifndef READHEX_H_
#define READHEX_H_

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>

size_t readhex_hex_read(FILE *f, uint8_t **buffer);

#endif /* READHEX_H_ */
