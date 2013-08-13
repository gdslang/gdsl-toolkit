/*
 * analyzer.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef ANALYZER_H_
#define ANALYZER_H_

#include <memory>
#include "bbgraph/bbgraph.h"
#include "bbgraph/bbgraph_id.h"
#include "bbgraph/bbgraph_node.h"
extern "C" {
#include <rreil/rreil.h>
}

using namespace std;

shared_ptr<expression> analyze(struct rreil_statements statements, shared_ptr<expression> exp);
shared_ptr<expression> analyze(bbgraph *graph, shared_ptr<bbgraph_rrnode> sp);

#endif /* ANALYZER_H_ */
