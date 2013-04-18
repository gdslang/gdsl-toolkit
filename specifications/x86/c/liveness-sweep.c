/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <dis.h>
#include <sys/resource.h>

#include <err.h>
#include <fcntl.h>
#include <gelf.h>
#include <string.h>
#include <sysexits.h>
#include <unistd.h>

#include <time.h>

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
	const rlim_t kStackSize = 4096L * 1024L * 1024L;
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

	size_t size = 16 * 1024 * 1024;
	char *fmt = (char*)malloc(size);

	size_t offset;
	size_t size_max;

	if(argc == 3) {
		if(strcmp(argv[1], "--elf"))
			return 1;
		char e = elf_section_boundary_get(argv[2], &offset, &size_max);
		if(e)
			return 2;
	} else if(argc != 2) {
		printf("Usage: liveness-sweep [--elf] file\n");
		return 1;
	} else {
		offset = 0;
		size_max = 0;
	}

	FILE *f = fopen(argv[1 + (argc == 3)], "r");
	if(!f) {
		printf("Unable to open file.\n");
		return 1;
	}

	fseek(f, offset, SEEK_SET);

	size_t buffer_size = 128;
	unsigned char *buffer = NULL;
	size_t buffer_length = 0;
	do {
		buffer_size *= 2;
		buffer = (unsigned char*)realloc(buffer, buffer_size);
		buffer_length += fread(buffer + buffer_length, 1,
				buffer_size - buffer_length, f);
	} while(!feof(f) && (!size_max || buffer_length < size_max));

	fclose(f);

	//printf("size_max: %lu, buffer_length: %lu\n", size_max, buffer_length);

	if(size_max && buffer_length > size_max)
		buffer_length = size_max;

	if(buffer_length == buffer_size) {
		buffer_size++;
		buffer = (unsigned char*)realloc(buffer, buffer_size);
	}
	buffer[buffer_length++] = 0xc3; //Last instruction should be a jump (ret) ;-).

	size_t lines = 0;
	size_t lines_greedy = 0;

	long time_non_opt = 0;
	long time_opt = 0;

	struct timespec start;
	struct timespec end;

	uint64_t consumed = 0;
	while(consumed < buffer_length) {
		__obj state = __createState(buffer + consumed, buffer_length - consumed, 0, 0);

		clock_gettime(CLOCK_MONOTONIC_RAW, &start);
		__obj rreil_instructions = __runMonadicNoArg(__translateBlock__, &state);
		clock_gettime(CLOCK_MONOTONIC_RAW, &end);
		long diff = end.tv_nsec - start.tv_nsec;
		time_non_opt += diff > 0 ? diff : 0;
	
		if(!__isNil(rreil_instructions)) {
			__fatal("TranslateBlock failed");
			goto end;
		}

		//printf("%x\n", buffer[consumed]);
	
		printf("Initial RREIL instructions:\n");
		__pretty(__rreil_pretty__, rreil_instructions, fmt, size);
		puts(fmt);
		printf("\n");
	
		for(size_t i = 0; fmt[i]; i++)
			if(fmt[i] == '\n')
				lines++;
	
		clock_gettime(CLOCK_MONOTONIC_RAW, &start);
		__obj greedy_state = __runMonadicOneArg(__liveness__, &state,
				rreil_instructions);
		clock_gettime(CLOCK_MONOTONIC_RAW, &end);
		diff = end.tv_nsec - start.tv_nsec;
		time_opt += diff > 0 ? diff : 0;
		if(!__isNil(greedy_state)) {
			__fatal("Liveness failed");
			goto end;
		}

		__obj rreil_instructions_greedy = __RECORD_SELECT(state, ___live);
		if(!__isNil(rreil_instructions_greedy)) {
			__fatal("Liveness failed (no greedy instructions)");
			goto end;
		}
	
		printf("Liveness greedy state:\n");
		__pretty(__lv_pretty__, greedy_state, fmt, size);
		puts(fmt);
		printf("\n");
	
		printf("RREIL instructions after LV (greedy):\n");
		__pretty(__rreil_pretty__, rreil_instructions_greedy, fmt, size);
		puts(fmt);
		printf("\n");
	
		for(size_t i = 0; fmt[i]; i++)
			if(fmt[i] == '\n')
				lines_greedy++;
	
		__resetHeap();
		consumed += __getBlobIndex(state);

		printf("consumed: %lu, buffer_length: %lu\n", consumed, buffer_length);
	}

	printf("Statistics:\n");
	printf("Number of lines without LV analysis: %zu\n", lines);
	printf("Number of lines with LV analysis: %zu\n", lines_greedy);

	double reduction = 1 - (lines_greedy / (double)lines);

	printf("Reduction: %lf%%\n", 100 * reduction);

	printf("Time needed for the decoding and the translation to RREIL: %lf seconds\n", time_non_opt/(double)(1000000000));
	printf("Time needed for the lv analysis: %lf\n seconds", time_opt/(double)(1000000000));

	end:
	free(buffer);
	free(fmt);

	return (1);
}

