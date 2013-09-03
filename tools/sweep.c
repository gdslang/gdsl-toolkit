/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdlib.h>
#include <stdint.h>
#include <stdio.h>
#include <gdsl.h>
#include <sys/resource.h>

static void fatal(char *msg) {
	fprintf(stderr, "%s", msg);
	exit(1);
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

	if(argc != 4) {
		printf("Usage: sweep file offset length\n");
		return 1;
	}

	size_t offset;
	sscanf(argv[2], "%zu", &offset);
	size_t length;
	sscanf(argv[3], "%zu", &length);

	FILE *f = fopen(argv[1], "r");
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
	while(gdsl_get_ip_offset(state) + 15 < buffer_length) {
		printf("++++++++++++ DECODING NEXT INSTRUCTION ++++++++++++\n");

		if(setjmp(*gdsl_err_tgt(state)))
			fatal("Decode failed");
		obj_t insn = gdsl_decode(state);

		string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn));
		puts(fmt);

		printf("---------------------------\n");

		if(setjmp(*gdsl_err_tgt(state)))
			fatal("Translate failed");
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

