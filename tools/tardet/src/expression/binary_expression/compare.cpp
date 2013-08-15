/*
 * compare.cpp
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <string>
#include <memory>
#include "compare.h"

using namespace std;

compare::compare(shared_ptr<expression> left, shared_ptr<expression> right, shared_ptr<compare_op> op) :
binary_expression(left, right, 1) {
	this->op = op;
}

compare::~compare() {
}

uint64_t compare_eq::compare(uint64_t a, uint64_t b) {
	return a == b;
}

string compare_eq::print() {
	return "==";
}

uint64_t compare_neq::compare(uint64_t a, uint64_t b) {
	return a != b;
}

string compare_neq::print() {
	return "!=";
}

uint64_t compare_les::compare(uint64_t a, uint64_t b) {
	return ((int64_t)a) <= ((int64_t)b);
}

string compare_les::print() {
	return "<=s";
}

uint64_t compare_leu::compare(uint64_t a, uint64_t b) {
	return a <= b;
}

string compare_leu::print() {
	return "<=u";
}

uint64_t compare_lts::compare(uint64_t a, uint64_t b) {
	return ((int64_t)a) < ((int64_t)b);
}

string compare_lts::print() {
	return "<s";
}

uint64_t compare_ltu::compare(uint64_t a, uint64_t b) {
	return a < b;
}

string compare_ltu::print() {
	return "<";
}

uint64_t compare::evaluate(uint64_t a, uint64_t b) {
	return op->compare(a, b);
}

expression *compare::construct(shared_ptr<expression> left, shared_ptr<expression> right) {
	return new compare(left, right, op);
}

void compare::print_inner() {
	binary_expression::print_inner(op->print());
}
