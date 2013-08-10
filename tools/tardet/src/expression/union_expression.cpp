/*
 * union_expression.cpp
 *
 *  Created on: Aug 10, 2013
 *      Author: jucs
 */

#include <memory>
#include <vector>
#include "expression.h"
#include "union_expression.h"

union_expression::union_expression(vector<shared_ptr<expression>> children, uint64_t size) :
		expression(size) {
	this->children = children;
}

union_expression::union_expression(uint64_t size) :
		expression(size) {
	this->children = vector<shared_ptr<expression>>();
}

union_expression::~union_expression() {
	// TODO Auto-generated destructor stub
}

void union_expression::print_inner() {
	if(children.size() == 1) {
		children[0]->print_inner();
		return;
	}
	printf("[");
	for(size_t i = 0; i < children.size(); ++i) {
		if(i)
			printf(", ");
		children[i]->print();
	}
	printf("]");
}

char union_expression::contains(struct rreil_variable *variable) {
	for(size_t i = 0; i < children.size(); ++i)
		if(children[i]->contains(variable))
			return true;
	return false;
}

bool union_expression::substitute(struct rreil_variable *old, shared_ptr<expression> &new_) {
	vector<shared_ptr<expression>> children_new = vector<shared_ptr<expression>>();
	bool update = false;
	for(size_t i = 0; i < children.size(); ++i) {
		shared_ptr<expression> new_next = new_;
		bool substituted = children[i]->substitute(old, new_next);
		if(substituted)
			children_new.push_back(new_next);
		else
			children_new.push_back(children[i]);
		update |= substituted;
	}
	if(update) {
		union_expression *replacement = new union_expression(children_new, get_size());
		new_ = shared_ptr<expression>(replacement);
		return true;
	} else
		return false;
}

char union_expression::evaluate(uint64_t *result) {
	for(size_t i = 0; i < children.size(); ++i)
		if(children[i]->evaluate(result))
			return true;
	return false;
}

void union_expression::add(shared_ptr<expression> exp) {
	if(get_size() != exp->get_size())
		throw new string("Cannot union expressions of different sizes :-(.");
	children.push_back(exp);
}
