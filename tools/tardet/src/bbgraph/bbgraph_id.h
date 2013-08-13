/*
 * bbgraph_id.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef bbgraph_ID_H_
#define bbgraph_ID_H_

#include <stdlib.h>
#include <string>

using namespace std;


class bbgraph_id {
private:
	size_t address_machine;
	size_t inner;

public:
	bbgraph_id(size_t address_machine, size_t inner) {
		this->address_machine = address_machine;
		this->inner = inner;
	}
	size_t get_address_machine() {
		return address_machine;
	}
	size_t get_inner() {
		return inner;
	}

	string to_string();
};

#endif /* bbgraph_ID_H_ */
