/*
 * itree.cpp
 *
 *  Created on: 22.07.2013
 *      Author: jucs
 */

#include <functional>
#include <memory>
#include <stdlib.h>
#include <stdio.h>
#include "interval.h"
#include "itree.h"

#include "expression/expression.h"

using namespace std;

itree::itree(shared_ptr<expression> expression, size_t int_start,
		size_t int_end) {
	this->root = new itree_leaf_node(expression, int_start, int_end);
}

void itree::print() {
	root->print();
}

char itree::contains(struct rreil_variable* variable) {
	return root->contains(variable);
}

void itree::substitute(struct rreil_variable *old, shared_ptr<expression> new_,
		uint64_t from, uint64_t to) {
	root = root->substitute(old, new_, from, to);
}

itree_node::itree_node(size_t int_start, size_t int_end) {
	this->intv.start = int_start;
	this->intv.end = int_end;
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

itree_inner_node::~itree_inner_node() {
	for(size_t i = 0; i < children_count; ++i) {
		delete children[i];
	}
	free(children);
}

void itree_inner_node::print() {
	for(size_t i = 0; i < children_count; ++i)
		children[i]->print();
}

char itree_inner_node::contains(struct rreil_variable *variable) {
	for(size_t i = 0; i < children_count; ++i)
		if(children[i]->contains(variable))
			return 1;
	return 0;
}

itree_node *itree_inner_node::substitute(struct rreil_variable *old,
		shared_ptr<expression> new_, uint64_t from, uint64_t to) {
	for(size_t i = 0; i < children_count; ++i)
		children[i] = children[i]->substitute(old, new_, from, to);
	return this;
}

char itree_inner_node::evaluate(uint64_t *result) {
	return children[0]->evaluate(result);
}

itree_leaf_node::itree_leaf_node(shared_ptr<expression> expression,
		size_t int_start, size_t int_end) :
		itree_node(int_start, int_end) {
	this->exp = expression;
}

enum itree_node_type itree_leaf_node::type_get() {
	return ITREE_NODE_TYPE_LEAF;
}

//void *itree_leaf_node::expression_get() {
//	return expression;
//}

itree_inner_node *itree_leaf_node::split(shared_ptr<expression> *expressions,
		size_t *offsets, size_t children_count) {
	struct {
		size_t start;
		size_t end;
	} intv;
	auto intv_calc = [&](size_t index) {
		if(!index) {
			intv.start = this->intv.start;
			intv.end = this->intv.start + offsets[index] - 1;
		} else if(index == children_count - 1) {
			intv.start = this->intv.start + offsets[index - 1];
			intv.end = this->intv.end;
		} else {
			intv.start = this->intv.start + offsets[index - 1];
			intv.end = this->intv.start + offsets[index] - 1;
		}
	};

	itree_node **children = (itree_node**)malloc(
			sizeof(itree_node*) * children_count);
	for(size_t i = 0; i < children_count; ++i) {
		intv_calc(i);
		children[i] = new itree_leaf_node(expressions[i], intv.start, intv.end);
	}

	return new itree_inner_node(children, children_count, this->intv.start,
			this->intv.end);
}

itree_leaf_node::~itree_leaf_node() {
	exp.reset();
}

void itree_leaf_node::print() {
	printf("[%zu..%zu]: ", intv.start, intv.end);
	exp->print();
	printf("\n");
}

char itree_leaf_node::contains(struct rreil_variable *variable) {
	return exp->contains(variable);
}

itree_node *itree_leaf_node::substitute(struct rreil_variable *old,
		shared_ptr<expression> new_, uint64_t from, uint64_t to) {

//	if(from < this->intv.start && to < this->intv.start)
//		return this;
//	if(from > this->intv.end && to > this->intv.end)
//		return this;

	shared_ptr<expression> new_subst = new_;
	bool substitute_toplevel = exp->substitute(old, new_subst);
	if(!substitute_toplevel)
		return this;

//	if(from <= this->intv.start && to >= this->intv.end) {
	exp = new_subst;
	return this;
//	}
//
//	interval me = interval(this->intv.start, this->intv.end);
//
//	if(from <= this->intv.start && to <= me) {
//		shared_ptr<expression> children[] = { new_subst, exp };
//		size_t offsets[] = { this->intv.start, to + 1 };
//		itree_inner_node *inner = split(children, offsets, 2);
//		delete this;
//		return inner;
//	}
//
//	if(from <= me && to >= this->intv.start) {
//		shared_ptr<expression> children[] = { exp, new_subst };
//		size_t offsets[] = { this->intv.start, from };
//		itree_inner_node *inner = split(children, offsets, 2);
//		delete this;
//		return inner;
//	}
//
//	shared_ptr<expression> children[] = { exp, new_subst, exp };
//	size_t offsets[] = { this->intv.start, to, from + 1 };
//	itree_inner_node *inner = split(children, offsets, 3);
//	delete this;
//	return inner;
}

char itree_leaf_node::evaluate(uint64_t *result) {
	return exp->evaluate(result);
}

