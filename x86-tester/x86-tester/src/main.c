/*
 * main.c
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint-gcc.h>
#include <dis.h>
#include <gdrr.h>
#include <rreil/rreil.h>
#include <rreil/gdrr_builder.h>
#include "tester.h"

int main(void) {
//	struct register_ reg;
//	reg.data = NULL;
//	reg.data_length = 0;
//	reg.data_size = 0;
//
//	uint8_t x = 0x42;
//	simulator_register_generic_write(&reg, &x, 8, 0);
//	x = 0x99;
//	simulator_register_generic_write(&reg, &x, 8, 8);
//
//	x = 0b10110;
//	simulator_register_generic_write(&reg, &x, 5, 5);

	__char blob[15];
	char fmt[1024];
//	__word sz = 15;
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
	int i = 4;
//	blob[0] = 0x48;
//	blob[1] = 0x8b;
//	blob[2] = 0x03;

//add    $0x8,%rsp
		blob[0] = 0x48;
		blob[1] = 0x83;
		blob[2] = 0xc4;
		blob[3] = 0x42;

//add    $0x42,%ecx
//	blob[0] = 0x83;
//	blob[1] = 0xc1;
//	blob[2] = 0x42;

//	add    %r8, %rsp
//		blob[0] = 0x4c;
//		blob[1] = 0x01;
//		blob[2] = 0xc4;

//	blob[0] = 0x66;
//	blob[1] = 0x01;
//	blob[2] = 0xfc;

	// pand mm0, mm1
//		blob[0] = 0x0f;
//		blob[1] = 0xdb;
//		blob[2] = 0xc1;

//		blob[0] = 0x04;
//		blob[1] = 0x42;

//shl
//	blob[0] = 0x48;
//	blob[1] = 0xc1;
//	blob[2] = 0xe0;
//	blob[3] = 0x2a;

//	typedef uint8_t xmm_t __attribute__ ((vector_size (16)));
//
//	register xmm_t hugo asm ("xmm0");
//
//	hugo[0] = 0x1122334455667788;
//	hugo[1] = 0xaabbccddeeff1122;
//
//	hugo = {3, 4} ;

//	hugo = {0x1122334455667788, 0x1122334455667788} ;

//shr
//	blob[0] = 0x48;
//	blob[1] = 0xc1;
//	blob[2] = 0xe8;
//	blob[3] = 0x2c;

//shrs
//	blob[0] = 0x48;
//	blob[1] = 0xc1;
//	blob[2] = 0xf8;
//	blob[3] = 0x2c;

//movzx
//	blob[0] = 0x48;
//	blob[1] = 0x0f;
//	blob[2] = 0xb7;
//	blob[3] = 0xd8;

//movsx
//	blob[0] = 0x48;
//	blob[1] = 0x0f;
//	blob[2] = 0xbf;
//	blob[3] = 0xd8;

//add %rax, %rbx
//	blob[0] = 0x48;
//	blob[1] = 0x01;
//	blob[2] = 0xc3;

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
//			__pretty(__rreil_pretty__, r, fmt, 1024);
//			puts(fmt);

			struct gdrr_config *config = rreil_gdrr_builder_config_get();
			struct rreil_statements *statements =
					(struct rreil_statements*)gdrr_convert(r, config);
			free(config);

			tester_test(statements, blob, i);

			rreil_statements_free(statements);
		}
	}
	return 0;
}
