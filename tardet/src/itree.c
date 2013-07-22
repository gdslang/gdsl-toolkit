/*
 * itree.c
 *
 *  Created on: 22.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include "itree.h"

struct itree_node *itree_root(void *expression, size_t start, size_t end) {
	struct itree_node *node = (struct itree_node*)malloc(
			sizeof(struct itree_node));
	node->type = ITREE_NODE_TYPE_LEAF;
	node->expresion = expression;
	node->interval.start = start;
	node->interval.end = end;

	return node;
}

void itree_split(struct itree_node *node, void **expressions, size_t *offsets,
		size_t children_count) {
	node->type = ITREE_NODE_TYPE_INNER;

	struct {
		size_t start;
		size_t end;
	} interval;
	void interval_calc(size_t index) {
		if(!index) {
			interval.start = node->interval.start;
			interval.end = node->interval.start + offsets[index] - 1;
		} else if(index == children_count - 1) {
			interval.start = node->interval.start + offsets[index - 1];
			interval.end = node->interval.end;
		} else {
			interval.start = node->interval.start + offsets[index - 1];
			interval.end = node->interval.start + offsets[index] - 1;
		}
	}

	node->children = (struct itree_node*)malloc(
			sizeof(struct itree_node) * children_count);
	node->children_count = children_count;
	for(size_t i = 0; i < children_count; ++i) {
		node->children[i].type = ITREE_NODE_TYPE_LEAF;
		node->children[i].expresion = expressions[i];
		interval_calc(i);
		node->children[i].interval.start = interval.start;
		node->children[i].interval.end = interval.end;
	}
}

void itree_print(struct itree_node *node) {
	if(node->type == ITREE_NODE_TYPE_INNER)
		for(size_t i = 0; i < node->children_count; ++i)
			itree_print(&node->children[i]);
	else
		printf("[%zu..%zu]: %s\n", node->interval.start, node->interval.end,
				node->expresion);
}
