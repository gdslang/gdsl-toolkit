/*
 * itree.cpp
 *
 *  Created on: 22.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include "itree.h"

itree_node::itree_node(size_t int_start, size_t int_end) {
	this->interval.start = int_start;
	this->interval.end = int_end;
}

itree_inner_node::itree_inner_node(itree_node **children, size_t children_count,
		size_t int_start, size_t int_end) :
		itree_node(int_start, int_end) {
	this->children = children;
	this->children_count = children_count;
}

enum itree_node_type itree_inner_node::type_get() {
	return ITREE_NODE_TYPE_INNER;
}

itree_node **itree_inner_node::children_get() {
	return children;
}

size_t itree_inner_node::children_count_get() {
	return children_count;
}

void itree_inner_node::print() {
	for(size_t i = 0; i < children_count; ++i)
		children[i]->print();
}

itree_leaf_node::itree_leaf_node(void *expression, size_t int_start,
		size_t int_end) :
		itree_node(int_start, int_end) {
	this->expression = expression;
}

enum itree_node_type itree_leaf_node::type_get() {
	return ITREE_NODE_TYPE_LEAF;
}

void *itree_leaf_node::expression_get() {
	return expression;
}

itree_inner_node *itree_leaf_node::split(void **expressions, size_t *offsets,
		size_t children_count) {
	struct {
		size_t start;
		size_t end;
	} interval;
	auto interval_calc = [&](size_t index) {
		if(!index) {
			interval.start = this->interval.start;
			interval.end = this->interval.start + offsets[index] - 1;
		} else if(index == children_count - 1) {
			interval.start = this->interval.start + offsets[index - 1];
			interval.end = this->interval.end;
		} else {
			interval.start = this->interval.start + offsets[index - 1];
			interval.end = this->interval.start + offsets[index] - 1;
		}
	};

	itree_node **children = (itree_node**)malloc(
			sizeof(itree_node*) * children_count);
	for(size_t i = 0; i < children_count; ++i) {
		interval_calc(i);
		children[i] = new itree_leaf_node(expressions[i], interval.start,
				interval.end);
	}

	return new itree_inner_node(children, children_count, this->interval.start,
			this->interval.end);
}

void itree_leaf_node::print() {
	printf("[%zu..%zu]: %s\n", interval.start, interval.end, expression);
}
