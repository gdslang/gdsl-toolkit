/*
 * simulator.h
 *
 *  Created on: 07.05.2013
 *      Author: jucs
 */

#ifndef SIMULATOR_H_
#define SIMULATOR_H_

#include <stdint.h>
#include <rreil/rreil.h>
#include <context.h>

extern void simulator_statements_simulate(struct context *context,
		struct rreil_statements *statements);

#endif /* SIMULATOR_H_ */
