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
	long long unsigned int size;
	struct rreil_linear *address;
};

extern struct rreil_address *rreil_address_alloc(long long unsigned int size, struct rreil_linear *addr_lin);

#endif /* RREIL_ADDRESS_H_ */
