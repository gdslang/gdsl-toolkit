/*
 * bbgraph_rrnode.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef bbgraph_rrnode_H_
#define bbgraph_rrnode_H_

#include <stdlib.h>
#include <stdint.h>
#include <memory>
#include <vector>
#include <queue>
#include "bbgraph_id.h"
extern "C" {
#include <rreil/rreil.h>
}
#include "../expression/expression.h"
#include "../expression/expressions.h"

using namespace std;

class bbgraph_rrnode;

struct bbgraph_pref {
	weak_ptr<bbgraph_rrnode> dst;
	shared_ptr<expression> condition;
};

class bbgraph_node : public enable_shared_from_this<bbgraph_node> {
protected:
	vector<struct bbgraph_pref> parents;
	bool marked = 0;
	bbgraph_id *id;
public:
	bbgraph_node(bbgraph_id *id) {
		this->id = id;
		marked = false;
		parents = vector<struct bbgraph_pref>();
	}
	vector<struct bbgraph_pref> get_parents() {
		return parents;
	}

	virtual ~bbgraph_node() {
		delete id;
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

	void add_parent(shared_ptr<bbgraph_rrnode> parent, shared_ptr<expression> condition);

	virtual void unmark_all() = 0;

	virtual void print_dot() = 0;
	virtual bool has_subgraph() = 0;
//	void print_dot_label();
	virtual void print_dot_subgraph(queue<shared_ptr<bbgraph_node>> &outsiders) = 0;

	virtual bool replace_with(shared_ptr<bbgraph_node> other) = 0;
};

struct bbgraph_branch {
	weak_ptr<bbgraph_node> dst;
	shared_ptr<expression> condition;
};

class bbgraph_rrnode : public bbgraph_node {
private:
	vector<struct bbgraph_branch> children;
	struct rreil_statements stmts;
	shared_ptr<union_expression> uexp;

public:
	bbgraph_rrnode(bbgraph_id *id, struct rreil_statements stmts) : bbgraph_node(id) {
		this->stmts = stmts;
		children = vector<struct bbgraph_branch>();
		uexp = NULL;
	}
	~bbgraph_rrnode() {
//		printf("Destructing: %s\n", this->id->to_string().c_str());
		free(stmts.statements);
	}
	vector<struct bbgraph_branch> get_children() {
		return children;
	}
	struct rreil_statements *get_stmts() {
		return &stmts;
	}
	shared_ptr<union_expression> get_uexp() {
		return uexp;
	}

	void add_child(shared_ptr<bbgraph_node> child, shared_ptr<expression> condition);

	void add_expression(shared_ptr<expression> expression);

	void unmark_all();

	bool has_subgraph();
//	void print_dot_label();
	void print_dot_subgraph(queue<shared_ptr<bbgraph_node>> &outsiders);
	void print_dot();

	bool replace_with(shared_ptr<bbgraph_node> other);
};

class bbgraph_stubnode : public bbgraph_node {
public:
	bbgraph_stubnode(bbgraph_id *id) : bbgraph_node(id) {
	}

	void unmark_all();

	bool has_subgraph();
//	void print_dot_label();
	void print_dot_subgraph(queue<shared_ptr<bbgraph_node>> &outsiders);
	void print_dot();

	bool replace_with(shared_ptr<bbgraph_node> other);
};


#endif /* bbgraph_rrnode_H_ */
