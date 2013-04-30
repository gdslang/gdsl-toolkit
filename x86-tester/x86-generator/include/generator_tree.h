/*
 * generator_tree.h
 *
 *  Created on: 30.04.2013
 *      Author: jucs
 */

#ifndef GENERATOR_TREE_H_
#define GENERATOR_TREE_H_

#include <stdlib.h>
#include <generator.h>

enum generator_tree_node_type {
	GENERATOR_TREE_NODE_TYPE_BRANCH, GENERATOR_TREE_NODE_TYPE_GENERATOR
};

struct generator_tree_node;

struct generator_tree_wbranch {
	struct generator_tree_node *node;
	uint8_t weight;
};

struct generator_tree_node {
	enum generator_tree_node_type type;
	union {
		struct {
			struct generator_tree_wbranch *branches;
			size_t branches_length;
		};
		struct {
			struct generator *generator;
			struct generator_tree_node *next;
		};
	};
};

extern struct generator_tree_node *generator_tree_generator_build(
		struct generator *generator, struct generator_tree_node *child);
extern struct generator_tree_node *generator_tree_branch(size_t branches_length,
		...);
extern void generator_tree_print(struct generator_tree_node *root);

#endif /* GENERATOR_TREE_H_ */
