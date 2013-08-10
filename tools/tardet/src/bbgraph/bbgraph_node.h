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
#include "../expression/expressions.h"

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
	shared_ptr<union_expression> uexp;

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
		uexp = NULL;
	}
	~bbgraph_node() {
//		printf("Destructing: %s\n", this->id->to_string().c_str());
		delete id;
		free(stmts.statements);
	}
	bbgraph_id *get_id() {
		return this->id;
	}
	vector<struct bbgraph_pref> get_parents() {
		return parents;
	}
	struct rreil_statements get_stmts() {
		return stmts;
	}
	shared_ptr<union_expression> get_uexp() {
		return uexp;
	}
	bool is_marked() {
		return marked;
	}
	void mark() {
		marked = true;
	}

	void add_expression(shared_ptr<expression> expression);

	void add_child(shared_ptr<bbgraph_node> child, shared_ptr<expression> condition);
	void add_parent(shared_ptr<bbgraph_node> parent, shared_ptr<expression> condition);

	void print_dot();
};


#endif /* bbgraph_NODE_H_ */
