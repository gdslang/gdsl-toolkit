/*
 * concatexpression.cpp
 *
 *  Created on: Aug 6, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <vector>
#include <memory>
#include "concat_expression.h"

using namespace std;

concat_expression::concat_expression(vector<struct concat_element> elements,
		size_t size) :
		expression(size) {
	this->elements = elements;
}

concat_expression::~concat_expression() {
}

void concat_expression::print_inner() {
	printf("[");
	for(size_t i = 0; i < elements.size(); ++i) {
		if(i)
			printf(", ");
		printf("{");
		elements[i].expression->print_inner();
		printf("}:%lu", elements[i].size);
	}
	printf("]");
}

char concat_expression::contains(struct rreil_variable *variable) {
	for(size_t i = 0; i < elements.size(); ++i)
		if(elements[i].expression->contains(variable))
			return true;
	return false;
}

bool concat_expression::substitute(struct rreil_variable *old,
		shared_ptr<expression> &new_) {
	vector<struct concat_element> elements_new = vector<struct concat_element>();
	bool update = false;
	for(size_t i = 0; i < elements.size(); ++i) {
		struct concat_element element;
		element.expression = new_;
		element.size = elements[i].size;
		bool substituted = elements[i].expression->substitute(old,
				element.expression);
		elements_new.push_back(element);
		update |= substituted;
	}
	if(update) {
		concat_expression *replacement = new concat_expression(elements_new,
				get_size());
		return replacement;
	} else
		return this;
}

char concat_expression::evaluate(uint64_t *result) {
	return 0;
}
