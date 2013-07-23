/*
 * itree.h
 *
 *  Created on: 22.07.2013
 *      Author: jucs
 */

#ifndef ITREE_H_
#define ITREE_H_

#include <tr1/memory>
#include <stdlib.h>
#include "expression/expression.h"
extern "C" {
#include <rreil/rreil.h>
}

using namespace std::tr1;

enum itree_node_type {
	ITREE_NODE_TYPE_INNER, ITREE_NODE_TYPE_LEAF
};

class itree_node {
public:
	itree_node(size_t int_start, size_t int_end);
	virtual ~itree_node() {
	}
	struct {
		size_t start;
		size_t end;
	} interval;

	virtual enum itree_node_type type_get() = 0;
	virtual void print() = 0;
};

class itree_inner_node: public itree_node {
private:
	itree_node **children;
	size_t children_count;

public:
	itree_inner_node(itree_node **children, size_t children_count,
			size_t int_start, size_t int_end);
	~itree_inner_node();
	enum itree_node_type type_get();
	itree_node **children_get();
	size_t children_count_get();
	void print();
};

class itree_leaf_node: public itree_node {
private:
	shared_ptr<class expression> expression;

public:
	itree_leaf_node(shared_ptr<class expression> expression, size_t int_start,
			size_t int_end);
	~itree_leaf_node();
	enum itree_node_type type_get();
//	void *expression_get();
	itree_inner_node *split(shared_ptr<class expression> *expressions,
			size_t *offsets, size_t children_count);
	void print();
};

class itree {
private:
	itree_node *root;

public:
	itree(shared_ptr<class expression> expression, size_t int_start,
			size_t int_end);
	~itree() {
		delete root;
	}
	void print();
};

#endif /* ITREE_H_ */
