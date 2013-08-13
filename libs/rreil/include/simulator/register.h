/*
 * register.h
 *
 *  Created on: 27.05.2013
 *      Author: jucs
 */

#ifndef REGISTER_H_
#define REGISTER_H_

#include <stdlib.h>
#include <stdint.h>

struct register_ {
	uint8_t *data;
	uint8_t *defined;
	size_t bit_length;
};

#endif /* REGISTER_H_ */
