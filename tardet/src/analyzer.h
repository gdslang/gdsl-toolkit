/*
 * analyzer.h
 *
 *  Created on: 23.07.2013
 *      Author: jucs
 */

#ifndef ANALYZER_H_
#define ANALYZER_H_

#include "itree.h"
extern "C" {
#include <rreil/rreil.h>
}

itree *analyze(struct rreil_statements *statements);

#endif /* ANALYZER_H_ */
