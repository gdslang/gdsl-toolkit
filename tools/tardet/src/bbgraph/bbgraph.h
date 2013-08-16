/*
 * bbgraph.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef bbgraph_H_
#define bbgraph_H_

#include <stdint.h>
#include <memory>
#include <functional>
#include <vector>
#include <map>
#include "bbgraph_node.h"
extern "C" {
#include <rreil/rreil.h>
}

using namespace std;

class bbgraph {
private:
	shared_ptr<bbgraph_node> root;
	map<int64_t, vector<shared_ptr<bbgraph_node>>> addr_map;

public:
	bbgraph(/*shared_ptr<bbgraph_node> root*/) {
//		this->root = root;
		this->root = NULL;
		addr_map = map<int64_t, vector<shared_ptr<bbgraph_node>>>();
	}
	void unmark_all() {
		auto seen = set<size_t>();
		get_root()->unmark_all(seen);
//		get_root()->unmark_all();
	}
	void reset_all();
	void invert_marking();

	shared_ptr<bbgraph_node> get_root();

	void print_dot();

	shared_ptr<bbgraph_rrnode> rreil_add(struct rreil_statements *statements, int64_t offset);

	static vector<shared_ptr<bbgraph_rrnode>> from_rreil_statements(
			struct rreil_statements *stmts, size_t address);
	void connect(shared_ptr<bbgraph_rrnode> node, int64_t offset, shared_ptr<expression> condition);

	bool analyzed(int64_t offset);
};

#endif /* bbgraph_H_ */
