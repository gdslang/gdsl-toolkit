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
		struct generator_tree_node *next =
				va_arg(a_list, struct generator_tree_node *);
		uint8_t weight = (uint8_t)va_arg(a_list, int);
		node->branches[i].node = next;
		node->branches[i].weight = weight;
	}
	va_end(a_list);

	return node;
}

void generator_tree_print(struct generator_tree_node *root) {
	if(!root)
		return;
	switch(root->type) {
		case GENERATOR_TREE_NODE_TYPE_BRANCH: {
			printf("BRANCH (");
			for(int i = 0; i < root->branches_length; ++i) {
				if(i)
					printf(", ");
				printf("[");
				generator_tree_print(root->branches[i].node);
				printf("]::%u", root->branches[i].weight);
			}
			printf(")");
			break;
		}
		case GENERATOR_TREE_NODE_TYPE_GENERATOR: {
			printf("GENERATOR {");
			generator_print(root->generator);
			printf("}");
			if(root->next) {
				printf(" => ");
				generator_tree_print(root->next);
			}
			break;
		}
	}
}

void generator_tree_execute(struct generator_tree_node *root) {
	if(!root)
		return;
	switch(root->type) {
		case GENERATOR_TREE_NODE_TYPE_BRANCH: {
			int random = rand();
			int weights = 0;
			for(size_t i = 0; i < root->branches_length; ++i)
				weights += root->branches[i].weight;
			int interval = RAND_MAX / weights;
			int current = 0;
			for(size_t i = 0; i < root->branches_length; ++i)
				if(random >= interval * current
						&& random < interval * (current + root->branches[i].weight)) {
					generator_tree_execute(root->branches[i].node);
					break;
				}
			break;

		}
	}
}
