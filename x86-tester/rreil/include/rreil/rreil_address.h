/*
 * rreil_address.h
 *
 *  Created on: 03.05.2013
 *      Author: jucs
 */

#ifndef RREIL_ADDRESS_H_
#define RREIL_ADDRESS_H_

#include <stdint.h>
#include <rreil/rreil_linear.h>

struct rreil_address {
	uint64_t size;
	struct rreil_linear *address;
};


#endif /* RREIL_ADDRESS_H_ */
