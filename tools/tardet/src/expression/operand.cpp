/*
 * operand.cpp
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <memory>
#include <string>
#include <vector>
#include <functional>
#include <stdio.h>
extern "C" {
#include <rreil/rreil_print.h>
}
#include "operand.h"
#include "../interval.h"
#include "slice_expression.h"

using namespace std;

variable::variable(struct rreil_id id, uint64_t size, uint64_t offset) :
		expression(size) {
	this->id = id;
	this->offset = offset;
}

void variable::print_inner() {
	rreil_id_print(&id);
	if(offset)
		printf("/%lu", offset);
}

char variable::contains(struct rreil_variable *variable) {
	if(!rreil_id_equals(&this->id, variable->id))
		return 0;

//	interval me = interval(offset, offset + size_get());
//	interval other = interval(variable->offset, variable->offset + variable->)

	/*
	 * Todo: Be more precise
	 */

	return variable->offset <= offset + size_get();

//	uint64_t diff;
//	if(this->variable_->offset < variable->offset)
//		diff = variable->offset - this->variable_->offset;
//	else
//		diff = this->variable_->offset - variable->offset;
//	if(diff < size_get())
//		return 1;
//	else
//		return 0;
}

bool variable::substitute(struct rreil_variable *old,
		shared_ptr<expression> &new_) {
	if(!rreil_id_equals(&id, old->id))
		return false;

	/*
	 * Todo: size = 0?
	 */
	interval me = interval(offset, offset + get_size() - 1);
	interval other = interval(old->offset, old->offset + new_->get_size() - 1);

	if(!other.overlaps(&me))
		return false;

	if(me == other)
		return true;

	vector<struct slice_element> elements = vector<struct slice_element>();
	auto element = [&](shared_ptr<expression> exp, size_t size, size_t offset) {
		struct slice_element element;
		element.expression = exp;
		element.size = size;
		element.offset = offset;
//		element.expression->require_size(size + offset);
		elements.push_back(element);
	};
	auto element_ne = [&](expression *exp, size_t size, size_t offset) {
		return element(shared_ptr<expression>(exp), size, offset);
	};

	if(other >= me)
		element(new_, get_size(), me.get_start() - other.get_start());
	else if(other <= me) {
		size_t size_acc = 0;

		size_t size = other.get_start() - me.get_start();
		if(size) {
			element_ne(new variable(id, size, offset), size, 0);
			size_acc += size;
		}

		element(new_, other.get_size(), 0);
		size_acc += other.get_size();

		size = me.get_end() - other.get_end();
		if(size)
			element_ne(new variable(id, size, offset + size_acc), size, 0);

	} else {
		auto two =
				[&](function<void(size_t,size_t)> construct_a, function<void(size_t,size_t)> construct_b) {
					size_t offset_a = me.get_start() - other.get_start();
					size_t size_a = other.get_size() - offset_a;
//			element(new_, size_a, offset_a);
					construct_a(size_a, offset_a);

					size_t offset_b = offset_a + size_a;
					size_t size_b = me.get_size() - size_a;
//			element_ne(new variable(id, offset_b, size_b), size_b, offset_b);
					construct_b(size_b, offset_b);
				};
		auto construct_other = [&](size_t size, size_t offset) {
			element(new_, size, offset);
		};
		auto construct_me = [&](size_t size, size_t offset) {
			element_ne(new variable(id, size, offset + this->offset), size, 0);
		};

		if(me.starts_with(&other))
			two(construct_other, construct_me);
		else
			two(construct_me, construct_other);
	}

	new_ = shared_ptr<expression>(new slice_expression(elements, get_size()));
	return true;

//	/*
//	 * Todo: Overlapping
//	 */
//	throw new string(
//			"Handling of partially overlapping expressions not yet implemented :-(...");
}

//variable::~variable() {
//
//}

immediate::immediate(uint64_t immediate, uint64_t size) :
		expression(size) {
	this->immediate_ = immediate;
}

void immediate::print_inner() {
	printf("%lu", this->immediate_);
}

//immediate::~immediate() {
//
//}
