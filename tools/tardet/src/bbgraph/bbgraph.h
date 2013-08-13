/*
 * bbgraph.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef bbgraph_H_
#define bbgraph_H_

#include <memory>
#include <functional>
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
	void unmark_all() {
		root->unmark_all();
	}

	void print_dot();

	static tuple<vector<shared_ptr<bbgraph_node>>, shared_ptr<bbgraph_node>, shared_ptr<bbgraph_node>> from_rreil_statements(
			struct rreil_statements *stmts, size_t address);
};

#endif /* bbgraph_H_ */
