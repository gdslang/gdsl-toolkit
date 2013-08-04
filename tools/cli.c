/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <gdsl-x86.h>

int main(int argc, char** argv) {
	void fatal(char *msg) {
		fprintf(stderr, "%s", msg);
		exit(1);
	}

	char blob[15];
	int_t sz = 15;
	int i, c;
	for(i = 0; i < sz; i++) {
		int x = fscanf(stdin, "%x", &c);
		switch(x) {
			case EOF:
				goto done;
			case 0:
				fatal("invalid input; should be in hex form: '0f 0b ..'");
		}
		blob[i] = c & 0xff;
	}
	done: ;
	state_t state = gdsl_init();
	gdsl_set_code(state, blob, i, 0);

	if(setjmp(*gdsl_err_tgt(state)))
		fatal("decode failed");
	obj_t insn = x86_decode(state);

	string_t fmt = x86_pretty(state, insn);
	puts(fmt);

	printf("---------------------------\n");

	if(setjmp(*gdsl_err_tgt(state)))
		fatal("translate failed");

	obj_t rreil = x86_translate(state, insn);

	fmt = x86_rreil_pretty(state, rreil);
	puts(fmt);

	gdsl_destroy(state);

	return 1;
}

