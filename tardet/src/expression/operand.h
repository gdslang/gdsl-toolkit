/*
 * operand.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef OPERAND_H_
#define OPERAND_H_

#include <stdint.h>
extern "C" {
#include <rreil/rreil.h>
}

class operand {
public:
	virtual void print() = 0;
	virtual ~operand() {};
};

class variable : public operand {
private:
	struct rreil_variable *variable_;

public:
	variable(struct rreil_variable *variable);
	~variable() {};
	void print();
};

class immediate : public operand {
private:
	uint64_t immediate_;

public:
	immediate(uint64_t immediate);
	~immediate() {};
	void print();
};

#endif /* OPERAND_H_ */
