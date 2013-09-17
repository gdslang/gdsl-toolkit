/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <unistd.h>
#include <readhex.h>
#include <gdsl.h>

#ifdef GDSL_X86
struct options {
	char mode64;
	char default_opnd_sz_32;
};

static char args_parse(int argc, char **argv, struct options *options) {
	options->mode64 = 1;
	options->default_opnd_sz_32 = 1;

	while(1) {
		char c = getopt(argc, argv, "md");
		switch(c) {
			case 'm': {
				options->mode64 = 0;
				break;
			}
			case 'd': {
				options->default_opnd_sz_32 = 0;
				break;
			}
			default: {
				goto end;
			}
		}
	}
	end: ;

	return 0;
}
#endif

int main(int argc, char** argv) {
	char retval = 0;

#ifdef GDSL_X86
	struct options options;
	args_parse(argc, argv, &options);

	printf("Configuration:\n");
	printf("\tmode64: %s\n", options.mode64 ? "true" : "false");
	printf("\tdefault_opnd_sz = 32: %s\n", options.default_opnd_sz_32 ? "true" : "false");
#endif

	uint8_t *buffer;
	size_t size = readhex_hex_read(stdin, &buffer);

	state_t state = gdsl_init();
	gdsl_set_code(state, (char*)buffer, size, 0);

	if(setjmp(*gdsl_err_tgt(state))) {
		fprintf(stderr, "decode failed: %s\n", gdsl_get_error_message(state));
		retval = 1;
		goto cleanup;
	}

#ifdef GDSL_X86
	int_t config = 0;
	config |= gdsl_config_mode64(state)*options.mode64;
	config |= gdsl_config_default_opnd_sz_32(state)*options.default_opnd_sz_32;

	obj_t insn = gdsl_decode(state, config);
#else
	obj_t insn = gdsl_decode(state, gdsl_config_default(state));
#endif

	printf("[");
	size_t decoded = gdsl_get_ip_offset(state);
	for(size_t i = 0; i < decoded; ++i) {
		if(i)
			printf(" ");
		printf("%02x", buffer[i]);
	}
	printf("] ");

	string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn));
	puts(fmt);

	cleanup:

	gdsl_destroy(state);
	free(buffer);

	return retval;
}

