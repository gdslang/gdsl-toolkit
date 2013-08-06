/*
 * interval.h
 *
 *  Created on: Aug 6, 2013
 *      Author: jucs
 */

#ifndef INTERVAL_H_
#define INTERVAL_H_

#include <stdlib.h>
#include <stdio.h>

class interval {
private:
	size_t start;
	size_t end;

public:
	interval(size_t start, size_t end) {
		this->start = start;
		this->end = end;
	}

	size_t get_start() {
		return start;
	}
	size_t get_end() {
		return end;
	}

	bool overlaps(interval *other);

	friend bool operator <=(size_t const &spot, interval &interval);
	friend bool operator <=(interval &a, interval &b);
	friend bool operator >=(interval &a, interval &b);
	friend bool operator ==(interval &a, interval &b);
};

#endif /* INTERVAL_H_ */
