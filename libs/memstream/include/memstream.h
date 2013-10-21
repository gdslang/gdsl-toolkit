#ifndef MEMSTREAM_H_
#define MEMSTREAM_H_

#include <stdio.h>

extern FILE *open_memstream(char **cp, size_t *lenp);

#endif /* MEMSTREAM_H_ */
