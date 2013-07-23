/*
 * expression.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef EXPRESSION_H_
#define EXPRESSION_H_

class expression {
public:
	virtual void print() = 0;
	virtual ~expression() {
	}
};

#endif /* EXPRESSION_H_ */
