/*
 * bbgraph_id.cpp
 *
 *  Created on: Aug 9, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <string>
#include "bbgraph_id.h"

using namespace std;

string bbgraph_id::to_string() {
	char *str;
	size_t str_length;
	FILE *stream = open_memstream(&str, &str_length);
	fprintf(stream, "%lx:%zu", address_machine, inner);
	fclose(stream);
	string result = string(str);
	free(str);
	return result;
}
