/*
 * analyzer.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef ANALYZER_H_
#define ANALYZER_H_

#include <memory>
#include <vector>
#include "bbgraph/bbgraph.h"
#include "bbgraph/bbgraph_id.h"
#include "bbgraph/bbgraph_node.h"
extern "C" {
#include <rreil/rreil.h>
}

using namespace std;

struct analysis_result {
	shared_ptr<expression> condition;
	shared_ptr<expression> exp;
};

//vector<struct analysis_result> analyze(struct rreil_statements statements, shared_ptr<expression> exp);
vector<struct analysis_result> analyze(bbgraph *graph, shared_ptr<bbgraph_rrnode> sp);

#endif /* ANALYZER_H_ */
