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
#include <stdio.h>
extern "C" {
#include <rreil/rreil_print.h>
}
#include "operand.h"
#include "../interval.h"
#include "concat_expression.h"

using namespace std;

variable::variable(struct rreil_id *id, uint64_t offset, uint64_t size) :
		expression(size) {
	this->id = id;
	this->offset = offset;
}

void variable::print_inner() {
	rreil_id_print(id);
	if(offset)
		printf("/%lu", offset);
}

char variable::contains(struct rreil_variable *variable) {
	if(!rreil_id_equals(this->id, variable->id))
		return 0;

	interval me = interval(offset, size_get());

	return variable->offset <= me;

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
	if(!rreil_id_equals(id, old->id))
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

	if(other >= me) {
		vector<struct concat_element> elements = vector<struct concat_element>();

		struct concat_element element;
		element.expression = new_;
		element.size = get_size();

		elements.push_back(element);

		new_ = shared_ptr < expression
				> (new concat_expression(elements, get_size()));
		return true;
	}

	if(other <= me) {
		vector<struct concat_element> elements = vector<struct concat_element>();

		struct concat_element element;

		size_t size_acc = 0;

		size_t size = other.get_start() - me.get_start();
		if(size) {
			element.expression = shared_ptr < expression
					> (new variable(id, offset, size));
			element.size = size;
			size_acc += size;
			elements.push_back(element);
		}

		size = other.get_end() - other.get_start() + 1;
		element.expression = new_;
		element.size = size;
		size_acc += size;
		elements.push_back(element);

		size = me.get_end() - other.get_end();
		if(size) {
			element.expression = shared_ptr < expression
					> (new variable(id, size_acc + offset, size));
			element.size = size;
			elements.push_back(element);
		}

		new_ = shared_ptr < expression
				> (new concat_expression(elements, get_size()));
		return true;
	}

	/*
	 * Todo: Overlapping
	 */
	throw new string("Not yet implemented...");
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
