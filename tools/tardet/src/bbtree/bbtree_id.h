/*
 * bbtree_id.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef BBTREE_ID_H_
#define BBTREE_ID_H_

#include <stdlib.h>

class bbtree_id {
private:
	size_t address_machine;
	size_t inner;

public:
	bbtree_id(size_t address_machine, size_t inner) {
		this->address_machine = address_machine;
		this->inner = inner;
	}
	size_t get_address_machine() {
		return address_machine;
	}
	size_t get_inner() {
		return inner;
	}
};


#endif /* BBTREE_ID_H_ */
