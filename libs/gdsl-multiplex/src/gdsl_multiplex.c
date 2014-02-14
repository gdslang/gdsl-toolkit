/*
 * gdsl_multiplex.c
 *
 *  Created on: Sep 11, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#define __USE_XOPEN2K8
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <dirent.h>
#include <dlfcn.h>

#include <gdsl_multiplex.h>

static char frontend_get(struct frontend_desc *desc, char *file) {
	size_t length = strlen(file);

	char *prefix = "libgdsl-";
	size_t prefix_length = strlen(prefix);

	size_t suffixes_length = 2;
	char *suffix[] = { ".so", ".dylib" };

	size_t suffix_length[suffixes_length];
	for (size_t i = 0; i < suffixes_length; ++i)
		suffix_length[i] = strlen(suffix[i]);

	for (size_t i = 0; i < suffixes_length; ++i) {
		char *suffix_next = suffix[i];
		size_t suffix_length_next = suffix_length[i];

		if(!strncmp(file, prefix, prefix_length) && length > suffix_length_next
				&& !strcmp(file + length - suffix_length_next, suffix_next)) {
			size_t decoder_length = length - prefix_length - suffix_length_next;

			char *decoder = (char*)malloc(decoder_length + 1);
			memcpy(decoder, file + prefix_length, decoder_length);
			decoder[decoder_length] = 0;

//			char *suffix_ = (char*)malloc(suffix_length + 1);
//			memcpy(suffix_, suffix, suffix_length + 1);

			desc->name = decoder;
			desc->ext = suffix_next;

			return 1;
		}
	}

	return 0;
}

size_t gdsl_multiplex_frontends_list(struct frontend_desc **descs) {
	char *base = getenv("GDSL_FRONTENDS");
	if(!base)
		return 0;

	size_t frontends_length = 0;
	size_t frontends_size = 8;
	*descs = (struct frontend_desc*)malloc(sizeof(struct frontend_desc) * frontends_size);

	DIR *dir;
	struct dirent *ent;
	dir = opendir(base);
	if(dir) {
		while((ent = readdir(dir)) != NULL) {
			struct frontend_desc desc;
			char frontend = frontend_get(&desc, ent->d_name);
			if(frontend) {
				if(frontends_length == frontends_size) {
					frontends_size <<= 1;
					*descs = (struct frontend_desc*)realloc(descs, sizeof(struct frontend_desc) * frontends_size);
				}
				(*descs)[frontends_length++] = desc;
			}
		}

		closedir(dir);
	}

	return frontends_length;
}

#define ADD_FUNCTION_GENERIC(CAT,FUNC,NAME)\
		frontend->CAT.FUNC = (__typeof__(frontend->CAT.FUNC))dlsym(dl, NAME);\
		if(!frontend->CAT.FUNC)\
			error = 1;
#define ADD_FUNCTION(CAT,FUNC) ADD_FUNCTION_GENERIC(CAT,FUNC,"gdsl_" #FUNC)

char gdsl_multiplex_frontend_get(struct frontend *frontend, struct frontend_desc desc) {
	char *base = getenv("GDSL_FRONTENDS");
	if(!base)
		return GDSL_MULTIPLEX_ERROR_FRONTENDS_PATH_NOT_SET;

	char *lib;
	size_t lib_length;
	FILE *libf = open_memstream(&lib, &lib_length);
	fprintf(libf, "%s/libgdsl-%s%s", base, desc.name, desc.ext);
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
	ADD_FUNCTION(decoder, operands)
	ADD_FUNCTION(decoder, pretty)
	ADD_FUNCTION(decoder, pretty_operand)
	ADD_FUNCTION(translator, translate)
	ADD_FUNCTION_GENERIC(translator, pretty, "gdsl_rreil_pretty")
	ADD_FUNCTION(translator, rreil_cif_userdata_set)
	ADD_FUNCTION(translator, rreil_cif_userdata_get)
	ADD_FUNCTION(translator, rreil_convert_sem_stmts)

	if(error)
		return GDSL_MULTIPLEX_ERROR_SYMBOL_NOT_FOUND;

	frontend->dl = dl;

	return GDSL_MULTIPLEX_ERROR_NONE;
}

/*
 * Todo: Fix? What about .ext?
 */
void gdsl_multiplex_descs_free(struct frontend_desc *descs, size_t descs_length) {
	for (size_t i = 0; i < descs_length; ++i)
		free((char*)descs[i].name);
	free(descs);
}

void gdsl_multiplex_frontend_close(struct frontend *backend) {
	dlclose(backend->dl);
}
