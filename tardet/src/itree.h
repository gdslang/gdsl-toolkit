/*
 * itree.h
 *
 *  Created on: 22.07.2013
 *      Author: jucs
 */

#ifndef ITREE_H_
#define ITREE_H_

#include <stdlib.h>

enum itree_node_type {
	ITREE_NODE_TYPE_INNER, ITREE_NODE_TYPE_LEAF
};

struct itree_node {
	enum itree_node_type type;
	union {
		void *expresion;
		struct {
			struct itree_node *children;
			size_t children_count;
		};
	};
	struct {
		size_t start;
		size_t end;
	} interval;
};

extern struct itree_node *itree_root(void *expression, size_t start, size_t end);
extern void itree_split(struct itree_node *node, void **expressions,
		size_t *offsets, size_t children_count);
extern void itree_print(struct itree_node *node);

#endif /* ITREE_H_ */
