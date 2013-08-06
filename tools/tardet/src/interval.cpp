/*
 * interval.cpp
 *
 *  Created on: Aug 6, 2013
 *      Author: jucs
 */

#include "interval.h"

bool interval::overlaps(interval *other) {
	if(start <= other->start)
		return other->start <= end;
	else
		return other->end >= start;
}

bool operator <=(size_t const &spot, interval &interval) {
	return (spot >= interval.get_start() && spot <= interval.get_end());
}
