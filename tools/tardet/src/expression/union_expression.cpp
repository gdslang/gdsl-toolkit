/*
 * union_expression.cpp
 *
 *  Created on: Aug 10, 2013
 *      Author: jucs
 */

#include <stdint.h>
#include <memory>
#include <vector>
#include "expression.h"
#include "expressions.h"
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

string union_expression::print_inner() {
	if(children.size() == 1)
		return children[0]->print_inner();
	string r = "[";
	for(size_t i = 0; i < children.size(); ++i) {
		if(i)
			r.append(", ");
		r.append(children[i]->print());
	}
	r.append("]");
	return r;
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

shared_ptr<expression> union_expression::simplify() {
	for (size_t i = 0; i < this->children.size(); ++i)
		children[i] = children[i]->simplify();

	vector<size_t> alive = vector<size_t>();
	for (size_t i = 0; i < this->children.size(); ++i)
		if(!children[i]->is_dead())
			alive.push_back(i);

	if(alive.size() == children.size())
		return shared_from_this();

	vector<shared_ptr<expression>> children_new;
	for (size_t i = 0; i < alive.size(); ++i)
		children_new.push_back(children[alive[i]]);

	switch(children_new.size()) {
		case 0: {
			return make_shared<unevalable>();
		}
		case 1: {
			return children_new[0];
		}
		default: {
			children = children_new;
			return shared_from_this();
		}
	}
}
