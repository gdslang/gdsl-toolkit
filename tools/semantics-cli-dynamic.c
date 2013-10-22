/*
 * dectran-cli-generic.c
 *
 *  Created on: Sep 11, 2013
 *      Author: jucs
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <readhex.h>
#include <gdsl_multiplex.h>
#include <gdsl.h>

int main(int argc, char** argv) {
	char retval = 0;

	struct frontend_desc *frontends;
	size_t frontends_count = gdsl_multiplex_frontends_list(&frontends);

	size_t frontend_ind = 0;
	if(!frontends_count) {
		fprintf(stderr, "No frontends available.\n");
		return 1;
	}
	if(frontends_count > 1) {
		printf("Available frontends:\n");
		for(size_t i = 0; i < frontends_count; ++i)
			printf("\t[%zu] %s\n", i, frontends[i].name);
		printf("Your choice? ");
		scanf("%zu", &frontend_ind);
	}

	if(frontend_ind >= frontends_count) {
		fprintf(stderr, "Frontend %zu is invalid.\n", frontend_ind);
		return 1;
	}

	printf("Using frontend %s...\n", frontends[frontend_ind].name);

//	__fpurge(stdin);

	uint8_t *buffer;
	size_t size = readhex_hex_read(stdin, &buffer);

	struct frontend backend;
	if(gdsl_multiplex_frontend_get(&backend, frontends[frontend_ind])) {
		fprintf(stderr, "Unable to open frontend.\n");
		return 1;
	}

	state_t state = backend.generic.init();
	backend.generic.set_code(state, (char*)buffer, size, 0);

	if(setjmp(*backend.generic.err_tgt(state))) {
		fprintf(stderr, "decode failed: %s\n", backend.generic.get_error_message(state));
		retval = 1;
		goto cleanup;
	}
	obj_t insn = backend.decoder.decode(state, backend.decoder.config_default(state));

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

//	for (size_t i = 0; i < frontends_count; ++i)
//		free(frontends[i]);
//	free(frontends);

	gdsl_multiplex_frontend_close(&backend);

	return retval;
}

