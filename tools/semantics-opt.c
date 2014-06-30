/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdlib.h>
#include <stdint.h>
#include <stdio.h>
#include <gdsl.h>
#include <sys/resource.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <time.h>
#include <getopt.h>

#include <err.h>
#include <fcntl.h>
#include <gelf.h>
#include <string.h>
#include <sysexits.h>

#define NANOS 1000000000LL

char elf_section_boundary_get(char *path, size_t *offset, size_t *size) {
	char retval = 0;

	int fd = open(path, O_RDONLY);
	if(!fd) {
		retval = 8;
		goto end_0;
	}

	if(elf_version(EV_CURRENT) == EV_NONE) {
		retval = 2;
		goto end_0;
	}

	Elf *e = elf_begin(fd, ELF_C_READ, NULL);
	if(!e) {
		retval = 3;
		goto end_0;
	}

	if(elf_kind(e) != ELF_K_ELF) {
		retval = 4;
		goto end_1;
	}

	size_t shstrndx;
	elf_getshstrndx(e, &shstrndx); 
//	if(elf_getshstrndx(e, &shstrndx) != 0) { // return value is negative on MacOS although result seems ok: we ignore it for now
//		retval = 5;
//		goto end_1;
//	}

	Elf_Scn *scn = NULL;

	char found = 0;
	while((scn = elf_nextscn(e, scn)) != NULL) {
		GElf_Shdr shdr;
		if(gelf_getshdr(scn, &shdr) != &shdr) {
			retval = 6;
			goto end_1;
		}

		char *name = elf_strptr(e, shstrndx, shdr.sh_name);
		if(!name) {
			retval = 7;
			goto end_1;
		}
		if(!strcmp(name, ".text")) {
			*offset = shdr.sh_offset;
			*size = shdr.sh_size;
			found = 1;
			break;
		}
//		printf("%s - %zu:%zu\n", name, shdr.sh_offset, shdr.sh_size);
	}

	if(!found)
		retval = 1;

	end_1: elf_end(e);

	end_0: close(fd);

	return retval;
}

struct options {
	long preservation;
	char elf;
	char *file;
	size_t offset;
	size_t length;
};

enum p_option {
	OPTION_ELF, OPTION_FILE, OPTION_OFFSET, OPTION_LENGTH, OPTION_PRESERVATION
};

static char args_parse(int argc, char **argv, struct options *options) {
	options->elf = 0;
	options->file = NULL;
	options->preservation = CON_SEM_PRESERVATION_EVERYWHERE;
	options->offset = 0;
	options->length = 0;

	struct option long_options[] = { { "elf", no_argument, NULL, OPTION_ELF }, { "file", required_argument, NULL,
			OPTION_FILE }, { "offset", required_argument, NULL, OPTION_FILE }, { "length", required_argument, NULL,
			OPTION_LENGTH }, { "preserve", required_argument, NULL, OPTION_PRESERVATION } };

	while(1) {
		int result = getopt_long(argc, argv, "", long_options, NULL);
		if(result < 0)
			break;
		switch(result) {
			case OPTION_ELF: {
				options->elf = 1;
				break;
			}
			case OPTION_FILE: {
				options->file = optarg;
				break;
			}
			case OPTION_OFFSET: {
				sscanf(optarg, "%lu", &options->offset);
				break;
			}
			case OPTION_LENGTH: {
				sscanf(optarg, "%lu", &options->length);
				break;
			}
			case OPTION_PRESERVATION: {
				if(!strcmp("everywhere", optarg)) {
					options->preservation = CON_SEM_PRESERVATION_EVERYWHERE;
					break;
				}
				if(!strcmp("block", optarg)) {
					options->preservation = CON_SEM_PRESERVATION_BLOCK;
					break;
				}
				if(!strcmp("context", optarg)) {
					options->preservation = CON_SEM_PRESERVATION_CONTEXT;
					break;
				}
				return 2;
			}
			case '?':
				return 1;
		}
	}

	return 0;
}

int main(int argc, char** argv) {
	const rlim_t kStackSize = 64L * 1024L * 1024L; // min stack size = 64 Mb
	int result;

	struct options options;
	if(args_parse(argc, argv, &options)) {
		printf(
				"Usage: semantics-opt [--elf] [--offset offset] [--length length] --file file [--preserve everywhere|block|context]\n");
		return 1;
	}

	if(options.elf) {
		if(elf_section_boundary_get(options.file, &options.offset, &options.length)) {
      printf("cannot read section boundary\n");
			exit(1);
		}
	} else if(!options.length) {
		struct stat buf;
		stat(options.file, &buf);
		options.length = buf.st_size;
	}

	FILE *f = fopen(options.file, "r");
	if(!f) {
		printf("Unable to open file.\n");
		return 1;
	}
	fseek(f, options.offset, SEEK_SET);

	size_t buffer_size = options.length + 15;
	char *buffer = (char*)malloc(buffer_size);
	size_t buffer_length = fread(buffer, 1, buffer_size, f);

	state_t state = gdsl_init();
	gdsl_set_code(state, buffer, buffer_length, 0);

	if(setjmp(*gdsl_err_tgt(state))) {
		fprintf(stderr, "failure: %s\n", gdsl_get_error_message(state));
		exit(1);
	}

	//uint64_t consumed = 0;
	size_t last_offset = 0;
	while(last_offset < options.length) {
		obj_t rreil = gdsl_decode_translate_block_optimized(state, gdsl_config_default(state), gdsl_int_max(state),
				options.preservation);

		string_t fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil));
		puts(fmt);

		gdsl_reset_heap(state);

		last_offset = gdsl_get_ip_offset(state);
	}

	gdsl_destroy(state);

	return 0;
}

