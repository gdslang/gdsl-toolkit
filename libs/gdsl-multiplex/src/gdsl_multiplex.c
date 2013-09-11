/*
 * gdsl_multiplex.c
 *
 *  Created on: Sep 11, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <gdsl_multiplex.h>

#include <dirent.h>

static char *backend_get(char *file) {
	size_t length = strlen(file);

	char *prefix = "libgdsl-";
	size_t prefix_length = strlen(prefix);
	char *suffix = ".so";
	size_t suffix_length = strlen(suffix);

	if(!strncmp(file, prefix, prefix_length) && length > suffix_length
			&& !strcmp(file + length - suffix_length, suffix)) {
		size_t decoder_length = length - prefix_length - suffix_length;
		char *decoder = (char*)malloc(decoder_length + 1);
		memcpy(decoder, file + prefix_length, decoder_length);
		decoder[decoder_length] = 0;
		return decoder;
	}
	return NULL;
}

size_t gdsl_multiplex_backends_list(char ***backends) {
	char *base = getenv("GDSL_DECODERS");
	if(!base)
		return 0;

	size_t backends_length = 0;
	size_t backends_size = 8;
	*backends = (char**)malloc(sizeof(char*) * backends_size);

	DIR *dir;
	struct dirent *ent;
	dir = opendir(base);
	if(dir) {
		while((ent = readdir(dir)) != NULL) {
			char *backend = backend_get(ent->d_name);
			if(backend) {
				if(backends_length == backends_size) {
					backends_size <<= 1;
					*backends = (char**)realloc(*backends, sizeof(char*)*backends_size);
				}
				(*backends)[backends_length++] = backend;
			}
		}

		closedir(dir);
	}

	return backends_length;
}
