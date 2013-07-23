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

variable::variable(struct rreil_variable *variable) {
	this->variable_ = variable;
}

void variable::print() {
	rreil_variable_print(this->variable_);
}

char variable::contains(rreil_variable *variable, size_t size) {
	if(!rreil_id_equals(this->variable_, variable))
		return 0;
	uint64_t diff;
	if(this->variable_->offset < variable->offset)
		diff = variable->offset - this->variable_->offset;
	else
		diff = this->variable_->offset - variable->offset;
	if(diff < size)
		return 1;
	else
		return 0;
}

//variable::~variable() {
//
//}

immediate::immediate(uint64_t immediate) {
	this->immediate_ = immediate;
}

void immediate::print() {
	printf("%lu", this->immediate_);
}

//immediate::~immediate() {
//
//}
