/*
 * dectran-cli-generic.c
 *
 *  Created on: Sep 11, 2013
 *      Author: jucs
 */

#include <stdio.h>
#include <stdio_ext.h>
#include <stdlib.h>
#include <stdint.h>
#include <readhex.h>
#include <gdsl_multiplex.h>
#include <gdsl.h>

int main(int argc, char** argv) {
	char retval = 0;

	char **backends;
	size_t backends_count = gdsl_multiplex_backends_list(&backends);

	size_t backend_ind = 0;
	if(!backends_count) {
		fprintf(stderr, "No backends available.\n");
		return 1;
	}
	if(backends_count > 1) {
		printf("Available backends:\n");
		for(size_t i = 0; i < backends_count; ++i)
			printf("\t[%zu] %s\n", i, backends[i]);
		printf("Your choice? ");
		scanf("%zu", &backend_ind);
	}

	if(backend_ind >= backends_count) {
		fprintf(stderr, "Backend %zu is invalid.\n", backend_ind);
		return 1;
	}

	printf("Using backend %s...\n", backends[backend_ind]);

	__fpurge(stdin);

	uint8_t *buffer;
	size_t size = readhex_hex_read(stdin, &buffer);

	struct backend backend;
	if(gdsl_multiplex_backend_get(&backend, backends[backend_ind])) {
		fprintf(stderr, "Unable to open backend.\n");
		return 1;
	}

	state_t state = backend.generic.init();
	backend.generic.set_code(state, (char*)buffer, size, 0);

	if(setjmp(*backend.generic.err_tgt(state))) {
		fprintf(stderr, "decode failed: %s\n", backend.generic.get_error_message(state));
		retval = 1;
		goto cleanup;
	}
	obj_t insn = backend.decoder.decode(state);

	printf("[");
	size_t decoded = backend.generic.get_ip_offset(state);
	for (size_t i = 0; i < decoded; ++i) {
		if(i)
			printf(" ");
		printf("%02x", buffer[i]);
	}
	printf("] ");

	string_t fmt = backend.generic.merge_rope(state, backend.decoder.pretty(state, insn));
	puts(fmt);

	printf("---------------------------\n");

	if(setjmp(*backend.generic.err_tgt(state))) {
		fprintf(stderr, "translate failed: %s\n", backend.generic.get_error_message(state));
		retval = 1;
		goto cleanup;
	}

	obj_t rreil = backend.translator.translate(state, insn);

	fmt = backend.generic.merge_rope(state, backend.translator.pretty(state, rreil));
	puts(fmt);

	cleanup:

	backend.generic.destroy(state);
	free(buffer);

	for (size_t i = 0; i < backends_count; ++i)
		free(backends[i]);
	free(backends);

	gdsl_multiplex_backend_close(&backend);

	return retval;
}

