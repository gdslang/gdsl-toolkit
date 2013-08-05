/*
 * operand.cpp
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
extern "C" {
#include <rreil/rreil_print.h>
}
#include "operand.h"

variable::variable(struct rreil_variable *variable, uint64_t size) :
		expression(size) {
	this->variable_ = variable;
}

void variable::print_inner() {
	rreil_variable_print(this->variable_);
}

char variable::contains(struct rreil_variable *variable) {
	if(!rreil_id_equals(this->variable_->id, variable->id))
		return 0;
	uint64_t diff;
	if(this->variable_->offset < variable->offset)
		diff = variable->offset - this->variable_->offset;
	else
		diff = this->variable_->offset - variable->offset;
	if(diff < size_get())
		return 1;
	else
		return 0;
}

bool variable::substitute(struct rreil_id *old, shared_ptr<expression> new_) {
	return rreil_id_equals(this->variable_->id, old);
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
