/*
 * analyzer.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef ANALYZER_H_
#define ANALYZER_H_

#include <memory>
#include "itree.h"
extern "C" {
#include <rreil/rreil.h>
}

using namespace std;


shared_ptr<expression> analyze(struct rreil_statements *statements);

#endif /* ANALYZER_H_ */
