/*
 * bbgraph_node.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef bbgraph_NODE_H_
#define bbgraph_NODE_H_

#include <stdlib.h>
#include <stdint.h>
#include <memory>
#include <vector>
#include "bbgraph_id.h"
extern "C" {
#include <rreil/rreil.h>
}

using namespace std;

class bbgraph_node;

struct bbgraph_branch {
	shared_ptr<bbgraph_node> dst;
	void *condition;
};

class bbgraph_node {
private:
	bbgraph_id *id;
	vector<struct bbgraph_branch> children;
	vector<shared_ptr<bbgraph_node>> parents;
	struct rreil_statements stmts;
	bool marked = 0;

	bool has_subgraph();
	void print_dot_subgraph();
public:
	bbgraph_node(bbgraph_id *id, struct rreil_statements stmts) {
		this->id = id;
		children = vector<struct bbgraph_branch>();
		parents = vector<shared_ptr<bbgraph_node>>();
		this->stmts = stmts;
		marked = false;
	}
	~bbgraph_node() {
		printf(":(\n");
		delete id;
		free(stmts.statements);
	}
	bool is_marked() {
		return marked;
	}
	void mark() {
		marked = true;
	}

	void add_child(shared_ptr<bbgraph_node> child);

	struct rreil_statements get_stmts() {
		return this->stmts;
	}

	void print_dot();
};


#endif /* bbgraph_NODE_H_ */
