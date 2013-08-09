/*
 * bbgraph.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef bbgraph_H_
#define bbgraph_H_

#include <memory>
#include "bbgraph_node.h"
extern "C" {
#include <rreil/rreil.h>
}

using namespace std;

class bbgraph {
private:
	shared_ptr<bbgraph_node> root;

public:
	bbgraph(shared_ptr<bbgraph_node> root) {
		this->root = root;
	}

	void print_dot();

	static bbgraph *from_rreil_statements(struct rreil_statements *stmts, size_t address);
};

#endif /* bbgraph_H_ */
