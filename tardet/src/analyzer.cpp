/*
 * analyzer.cpp
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#include <tr1/memory>
#include <stdlib.h>
#include <stdio.h>
extern "C" {
#include <rreil/rreil.h>
}
#include "itree.h"
#include "expression/expression.h"

using namespace std::tr1;

static itree *initial(rreil_statement *last) {
	itree *root = NULL;

	switch(last->type) {
		case RREIL_STATEMENT_TYPE_BRANCH: {
			shared_ptr<class expression> exp = shared_ptr<class expression>(
					expression::from_rreil_linear(last->branch.target->address));
			root = new itree(exp, 0, last->branch.target->size - 1);
			break;
		}
//		case RREIL_STATEMENT_TYPE_CBRANCH: {
//			shared_ptr<class expression> exp = expression::from_rreil_linear(last->cbranch.target->address);
//			root = new itree(exp, 0, last->cbranch.target->size - 1);
//			break;
//		}
		default: {
			break; //handle error
		}
	}

	return root;
}

itree *analyze(struct rreil_statements *statements) {
	rreil_statement *last = statements->statements[statements->statements_length
			- 1];

	itree *root = initial(last);
	if(!root)
		return NULL;

	for(size_t i = statements->statements_length - 1; i > 0; --i) {
		rreil_statement *current = statements->statements[i - 1];

	}

	return root;
}
