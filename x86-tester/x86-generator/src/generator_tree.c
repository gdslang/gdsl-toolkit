/*
 * generator_tree.c
 *
 *  Created on: 30.04.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdarg.h>
#include <stdio.h>
#include <generator_tree.h>

struct generator_tree_node *generator_tree_generator_build(
		struct generator *generator, struct generator_tree_node *child) {
	struct generator_tree_node *node = (struct generator_tree_node *)malloc(
			sizeof(struct generator_tree_node));
	node->type = GENERATOR_TREE_NODE_TYPE_GENERATOR;
	node->generator = generator;
	node->next = child;
	return node;
}

struct generator_tree_node *generator_tree_branch(size_t branches_length, ...) {
	struct generator_tree_node *node = (struct generator_tree_node *)malloc(
			sizeof(struct generator_tree_node));
	node->type = GENERATOR_TREE_NODE_TYPE_BRANCH;
	node->branches_length = branches_length;
	node->branches = (struct generator_tree_wbranch*)malloc(
			branches_length * sizeof(struct generator_tree_wbranch));

	va_list a_list;
	va_start(a_list, branches_length);
	for(int i = 0; i < branches_length; ++i) {
		struct generator_tree_node *node =
				va_arg(a_list, struct generator_tree_node *);
		uint8_t weight = va_arg(a_list, uint8_t);
		node->branches[i].node = node;
		node->branches[i].weight = weight;
	}
	va_end(a_list);

	return node;
}
