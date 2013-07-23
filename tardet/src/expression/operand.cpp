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
