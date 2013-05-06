/*
 * main.c
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <dis.h>
#include <gdrr.h>
#include <rreil/rreil.h>
#include <rreil_gdrr_builder.h>

int main(void) {
	__char blob[15];
	char fmt[1024];
	__word sz = 15;
//	int i, c;
//	for(i = 0; i < sz; i++) {
//		int x = fscanf(stdin, "%x", &c);
//		switch(x) {
//			case EOF:
//				goto done;
//			case 0: {
//				__fatal("invalid input; should be in hex form: '0f 0b ..'");
//				break;
//			}
//		}
//		blob[i] = c & 0xff;
//	}
//	done: ;
	int i = 3;
	blob[0] = 0x48;
	blob[1] = 0x8b;
	blob[2] = 0x03;
	__obj state = __createState(blob, i, 0, 0);
	__obj insn = __runMonadicNoArg(__decode__, &state);

	if(___isNil(insn))
		__fatal("decode failed");
	else {
		__pretty(__pretty__, insn, fmt, 1024);
		puts(fmt);

		printf("---------------------------\n");

		__obj r = __runMonadicOneArg(__translate__, &state, insn);
		if(___isNil(r))
			__fatal("translate failed");
		else {
			__pretty(__rreil_pretty__, r, fmt, 1024);
			puts(fmt);

			struct gdrr_config *config = rreil_gdrr_builder_config_get();

			struct rreil_statements *statements = (struct rreil_statements*)gdrr_convert(r, config);

			rreil_statements_free(statements);
		}
	}
	return 0;
}
