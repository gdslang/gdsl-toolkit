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
#include "../expression/expression.h"

using namespace std;

class bbgraph_node;

struct bbgraph_branch {
	weak_ptr<bbgraph_node> dst;
	shared_ptr<expression> condition;
};

struct bbgraph_pref {
	weak_ptr<bbgraph_node> dst;
	shared_ptr<expression> condition;
};

class bbgraph_node {
private:
	bbgraph_id *id;
	vector<struct bbgraph_branch> children;
	vector<struct bbgraph_pref> parents;
	struct rreil_statements stmts;
	bool marked = 0;

	bool has_subgraph();
//	void print_dot_label();
	void print_dot_subgraph();
public:
	bbgraph_node(bbgraph_id *id, struct rreil_statements stmts) {
		this->id = id;
		children = vector<struct bbgraph_branch>();
		parents = vector<struct bbgraph_pref>();
		this->stmts = stmts;
		marked = false;
	}
	~bbgraph_node() {
//		printf("Destructing: %s\n", this->id->to_string().c_str());
		delete id;
		free(stmts.statements);
	}
	bbgraph_id *get_id() {
		return this->id;
	}
	bool is_marked() {
		return marked;
	}
	void mark() {
		marked = true;
	}

	void add_child(shared_ptr<bbgraph_node> child, shared_ptr<expression> condition);
	void add_parent(shared_ptr<bbgraph_node> parent, shared_ptr<expression> condition);

	struct rreil_statements get_stmts() {
		return this->stmts;
	}

	void print_dot();
};


#endif /* bbgraph_NODE_H_ */
