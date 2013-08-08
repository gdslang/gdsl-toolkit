/*
 * bbtree_node.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef BBTREE_NODE_H_
#define BBTREE_NODE_H_

#include <stdlib.h>
#include <stdint.h>
#include <memory>
#include <vector>
#include "bbtree_id.h"

using namespace std;

class bbtree_node {
private:
	bbtree_id id;
	vector<shared_ptr<bbtree_node>> children;
	vector<shared_ptr<bbtree_node>> parents;

public:
	bbtree_node(bbtree_id id) {
		this->id = id;
		children = vector<shared_ptr<bbtree_node>>();
		parents = vector<shared_ptr<bbtree_node>>();
	}
};


#endif /* BBTREE_NODE_H_ */
