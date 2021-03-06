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
	node->ref_count = 0;
	node->type = GENERATOR_TREE_NODE_TYPE_GENERATOR;
	node->generator = generator;
	node->next = child;
	if(child)
		child->ref_count++;
	return node;
}

struct generator_tree_node *generator_tree_branch(size_t branches_length, ...) {
	struct generator_tree_node *node = (struct generator_tree_node *)malloc(
			sizeof(struct generator_tree_node));
	node->ref_count = 0;
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
		if(next)
			next->ref_count++;
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

void generator_tree_execute(struct generator_tree_node *root, FILE *stream) {
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
			for(size_t i = 0; i < root->branches_length; ++i) {
				if((random >= interval * current
						&& random < interval * (current + root->branches[i].weight))
						|| i == root->branches_length) {
					generator_tree_execute(root->branches[i].node, stream);
					break;
				}
				current += root->branches[i].weight;
			}
			break;
		}
		case GENERATOR_TREE_NODE_TYPE_GENERATOR: {
			generator_execute(root->generator, stream);
			generator_tree_execute(root->next, stream);
			break;
		}
	}
}

void generator_tree_free(struct generator_tree_node *root) {
	if(!root)
		return;
	switch(root->type) {
		case GENERATOR_TREE_NODE_TYPE_BRANCH: {
			for(size_t i = 0; i < root->branches_length; ++i) {
				struct generator_tree_node *next = root->branches[i].node;
				if(next && next->ref_count > 1) {
					next->ref_count--;
				} else
					generator_tree_free(next);
			}
			free(root->branches);
			break;
		}
		case GENERATOR_TREE_NODE_TYPE_GENERATOR: {
			generator_free(root->generator);
			if(root->next && root->next->ref_count > 1)
				root->next->ref_count--;
			else
				generator_tree_free(root->next);
			break;
		}
	}
	free(root);
}
