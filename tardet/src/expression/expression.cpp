/*
 * expression.cpp
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <tr1/functional>
#include <tr1/memory>
#include "expression.h"
extern "C" {
#include <rreil/rreil.h>
}

#include "binary_expression.h"
#include "operand.h"

using namespace std::tr1;

expression *expression::from_rreil_linear(struct rreil_linear* linear) {
	function<expression*(struct rreil_linear*)> handle_linear =
			[&](struct rreil_linear *linear) {
				expression *exp;
				switch(linear->type) {
					case RREIL_LINEAR_TYPE_VARIABLE: {
						exp = new variable(linear->variable);
						break;
					}
					case RREIL_LINEAR_TYPE_IMMEDIATE: {
						exp = new immediate(linear->immediate);
						break;
					}
					case RREIL_LINEAR_TYPE_SUM: {
						exp = new addition(handle_linear(linear->sum.opnd1), handle_linear(linear->sum.opnd1));
						break;
					}
					case RREIL_LINEAR_TYPE_DIFFERENCE: {
						exp = new subtraction(handle_linear(linear->sum.opnd1), handle_linear(linear->sum.opnd1));
					}
					case RREIL_LINEAR_TYPE_SCALE: {
						printf("Scale :-(...\n");
						break;
					}
				}
				return exp;
			};
	return handle_linear(linear);
}
