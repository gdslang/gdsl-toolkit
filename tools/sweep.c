/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdlib.h>
#include <stdint.h>
#include <stdio.h>
#include <gdsl.h>
#include <sys/resource.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>

#include <err.h>
#include <fcntl.h>
#include <gelf.h>
#include <string.h>
#include <sysexits.h>

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
	if(elf_getshdrstrndx(e, &shstrndx) != 0) {
		retval = 5;
		goto end_1;
	}

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

int main(int argc, char** argv) {
	const rlim_t kStackSize = 64L * 1024L * 1024L; // min stack size = 64 Mb
	struct rlimit rl;
	int result;

	result = getrlimit(RLIMIT_STACK, &rl);
	if(result == 0) {
		if(rl.rlim_cur < kStackSize) {
			rl.rlim_cur = kStackSize;
			result = setrlimit(RLIMIT_STACK, &rl);
			if(result != 0) {
				fprintf(stderr, "setrlimit returned result = %d\n", result);
			}
		}
	}

	size_t offset;
	size_t length;
	char *file;

	switch(argc) {
		case 2: {
			file = argv[1];

			char e = elf_section_boundary_get(file, &offset, &length);
			if(e)
				exit(2);
//			offset = 0;
//
//			struct stat buf;
//			stat(file, &buf);
//			length = buf.st_size;
			break;
		}
		case 3: {
			file = argv[1];
			sscanf(argv[2], "%zu", &offset);

			struct stat buf;
			stat(file, &buf);
			length = buf.st_size;
			break;
		}
		case 4: {
			file = argv[1];
			sscanf(argv[2], "%zu", &offset);
			sscanf(argv[3], "%zu", &length);
			break;
		}
		default: {
			printf("Usage: sweep file offset length\n");
			return 1;
		}
	}

	FILE *f = fopen(file, "r");
	if(!f) {
		printf("Unable to open file.\n");
		return 1;
	}
	fseek(f, offset, SEEK_SET);

	size_t buffer_size = length + 15;
	char *buffer = (char*)malloc(buffer_size);
	size_t buffer_length = fread(buffer, 1, buffer_size, f);

	state_t state = gdsl_init();
	gdsl_set_code(state, buffer, buffer_length, 0);

	//uint64_t consumed = 0;
	while(gdsl_get_ip_offset(state) < length) {
		printf("++++++++++++ DECODING NEXT INSTRUCTION ++++++++++++\n");

		if(setjmp(*gdsl_err_tgt(state))) {
			fprintf(stderr, "decode failed: %s\n", gdsl_get_error_message(state));
			break;
		}
		obj_t insn = gdsl_decode(state, gdsl_config_default(state));

		string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn));
		puts(fmt);

		printf("---------------------------\n");

		if(setjmp(*gdsl_err_tgt(state))) {
			fprintf(stderr, "translate failed: %s\n", gdsl_get_error_message(state));
			break;
		}
		obj_t rreil = gdsl_translate(state, insn);
//		__obj r = __runMonadicOneArg(__translate__, &state, insn);
		//__obj r = __translate(__translate__,insn);

		fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil));
		puts(fmt);

		gdsl_reset_heap(state);
	}

	gdsl_destroy(state);

	return 1;
}

