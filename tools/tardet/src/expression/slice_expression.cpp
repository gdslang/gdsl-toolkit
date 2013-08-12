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
#include "slice_expression.h"
extern "C" {
#include <util.h>
}
using namespace std;

slice_expression::slice_expression(vector<struct slice_element> elements,
		size_t size) :
		expression(size) {
	this->elements = elements;
}

slice_expression::~slice_expression() {
}

void slice_expression::print_inner() {
	auto print_element = [&](struct slice_element *element) {
		element->expression->print_inner();
		if(element->size != get_size())
		printf(":%lu", element->size);
		if(element->offset)
		printf("/%lu", element->offset);
	};

	if(elements.size() > 1) {
		printf("[");
		for(size_t i = 0; i < elements.size(); ++i) {
			if(i)
				printf(", ");
			printf("{");
			print_element(&elements[i]);
			printf("}");
		}
		printf("]");
	} else if(elements.size())
		print_element(&elements[0]);
}

char slice_expression::contains(struct rreil_variable *variable) {
	for(size_t i = 0; i < elements.size(); ++i)
		if(elements[i].expression->contains(variable))
			return true;
	return false;
}

bool slice_expression::substitute(struct rreil_variable *old,
		shared_ptr<expression> &new_) {
	vector<struct slice_element> elements_new = vector<struct slice_element>();
	bool update = false;
	for(size_t i = 0; i < elements.size(); ++i) {
		struct slice_element element;
		element.expression = new_;
		element.size = elements[i].size;
		element.offset = elements[i].offset;

		bool substituted = elements[i].expression->substitute(old,
				element.expression);
		if(substituted) {
//			element.expression->require_size(element.size + element.offset);
			elements_new.push_back(element);
		} else
			elements_new.push_back(elements[i]);
		update |= substituted;
	}
	if(update) {
		slice_expression *replacement = new slice_expression(elements_new,
				get_size());
		new_ = shared_ptr<expression>(replacement);
		return true;
	} else
		return false;
}

char slice_expression::evaluate(uint64_t *result) {
	size_t bit_offset = 0;
	uint64_t dest = 0;

	for(size_t i = 0; i < elements.size(); ++i) {
		uint64_t element;
		if(!elements[i].expression->evaluate(&element))
			return 0;
		membit_cpy((uint8_t*)result, bit_offset, (uint8_t*)&element,
				elements[i].offset, elements[i].size);
		bit_offset += elements[i].size;
	}

	return 1;
}
