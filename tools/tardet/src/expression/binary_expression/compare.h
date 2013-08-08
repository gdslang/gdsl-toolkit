/*
 * compare.h
 *
 *  Created on: Aug 8, 2013
 *      Author: jucs
 */

#ifndef COMPARE_H_
#define COMPARE_H_

#include <stdint.h>
#include <string>
#include <memory>
#include "binary_expression.h"

using namespace std;

class compare_op {
public:
	virtual uint64_t compare(uint64_t a, uint64_t b) = 0;
	virtual string print() = 0;
};

class compare_eq: public compare_op {
public:
	uint64_t compare(uint64_t a, uint64_t b);
	string print();
};

class compare_neq: public compare_op {
public:
	uint64_t compare(uint64_t a, uint64_t b);
	string print();
};

class compare_les: public compare_op {
public:
	uint64_t compare(uint64_t a, uint64_t b);
	string print();
};

class compare_leu: public compare_op {
public:
	uint64_t compare(uint64_t a, uint64_t b);
	string print();
};

class compare_lts: public compare_op {
public:
	uint64_t compare(uint64_t a, uint64_t b);
	string print();
};

class compare_ltu: public compare_op {
public:
	uint64_t compare(uint64_t a, uint64_t b);
	string print();
};

class compare: public binary_expression {
private:
	shared_ptr<compare_op> op;
public:
	compare(shared_ptr<expression> left, shared_ptr<expression> right, uint64_t size, shared_ptr<compare_op> op);
	virtual ~compare();

	uint64_t evaluate(uint64_t a, uint64_t b);
	expression *construct(shared_ptr<expression> left, shared_ptr<expression> right);
	void print_inner();
};
#endif /* COMPARE_H_ */

