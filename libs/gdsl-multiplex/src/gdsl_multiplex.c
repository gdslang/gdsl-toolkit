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
#include <dirent.h>
#include <dlfcn.h>

#include <gdsl_multiplex.h>

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
	char *base = getenv("GDSL_BACKENDS");
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

#define ADD_FUNCTION_GENERIC(CAT,FUNC,NAME)\
		backend->CAT.FUNC = (__typeof__(backend->CAT.FUNC))dlsym(dl, NAME);\
		if(!backend->CAT.FUNC)\
			error = 1;
#define ADD_FUNCTION(CAT,FUNC) ADD_FUNCTION_GENERIC(CAT,FUNC,"gdsl_" #FUNC)

char gdsl_multiplex_backend_get(struct backend *backend, const char *name) {
	char *base = getenv("GDSL_BACKENDS");
	if(!base)
		return GDSL_MULTIPLEX_ERROR_BACKENDS_PATH_NOT_SET;

	char *lib;
	size_t lib_length;
	FILE *libf = open_memstream(&lib, &lib_length);
	fprintf(libf, "%s/libgdsl-%s.so", base, name);
	fputc(0, libf);
	fclose(libf);

	void *dl = dlopen(lib, RTLD_LAZY);
	free(lib);
	if(!dl)
		return GDSL_MULTIPLEX_ERROR_UNABLE_TO_OPEN;

	char error = 0;

	ADD_FUNCTION(generic, init)
	ADD_FUNCTION(generic, set_code)
	ADD_FUNCTION(generic, err_tgt)
	ADD_FUNCTION(generic, get_error_message)
	ADD_FUNCTION(generic, destroy)
	ADD_FUNCTION(generic, get_ip_offset)
	ADD_FUNCTION(generic, merge_rope)
	ADD_FUNCTION(decoder, config_default)
	ADD_FUNCTION(decoder, decode)
	ADD_FUNCTION(decoder, pretty)
	ADD_FUNCTION(translator, translate)
	ADD_FUNCTION_GENERIC(translator, pretty, "gdsl_rreil_pretty")
	ADD_FUNCTION(translator, rreil_cif_userdata_set)
	ADD_FUNCTION(translator, rreil_convert_sem_stmts)

	if(error)
		return GDSL_MULTIPLEX_ERROR_SYMBOL_NOT_FOUND;

	backend->dl = dl;

	return GDSL_MULTIPLEX_ERROR_NONE;
}

void gdsl_multiplex_backend_close(struct backend *backend) {
	dlclose(backend->dl);
}
