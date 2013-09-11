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

char gdsl_multiplex_backend_get(struct backend *backend, char *name) {
	char *base = getenv("GDSL_DECODERS");
	if(!base)
		return 1;

	char *lib;
	size_t lib_length;
	FILE *libf = open_memstream(&lib, &lib_length);
	fprintf(libf, "%s/libgdsl-%s.so", base, name);
	fputc(0, libf);
	fclose(libf);

	void *dl = dlopen(lib, RTLD_LAZY);
	free(lib);
	if(!dl)
		return 2;

	backend->generic.init = (void(*)(void))dlsym(dl, "gdsl_init");
	backend->generic.set_code = (void(*)(void))dlsym(dl, "gdsl_set_code");
	backend->generic.err_tgt = (void(*)(void))dlsym(dl, "gdsl_err_tgt");
	backend->generic.get_error_message = (void(*)(void))dlsym(dl, "gdsl_get_error_message");
	backend->generic.destroy = (void(*)(void))dlsym(dl, "gdsl_destroy");
	backend->generic.get_ip_offset = (void(*)(void))dlsym(dl, "gdsl_get_ip_offset");
	backend->generic.merge_rope = (void(*)(void))dlsym(dl, "gdsl_merge_rope");
	backend->decoder.decode = (void(*)(void))dlsym(dl, "gdsl_decode");
	backend->decoder.pretty = (void(*)(void))dlsym(dl, "gdsl_pretty");
	backend->translator.translate = (void(*)(void))dlsym(dl, "gdsl_translate");
	backend->translator.pretty = (void(*)(void))dlsym(dl, "gdsl_rreil_pretty");

	backend->dl = dl;

	return 0;
}

void gdsl_multiplex_backend_close(struct backend *backend) {
	dlclose(backend->dl);
}
