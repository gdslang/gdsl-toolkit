/*
 * main.c
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint-gcc.h>
#include <sys/mman.h>
#include <time.h>
#include <dis.h>
#include <gdrr.h>
#include <rreil/rreil.h>
#include <rreil_gdrr_builder.h>
#include <simulator_regacc.h>
#include <simulator.h>
#include <simulator_tracking.h>
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
//		blob[0] = 0x48;
//		blob[1] = 0x83;
//		blob[2] = 0xc4;
//		blob[3] = 0x42;

//add    $0x42,%ecx
//	blob[0] = 0x83;
//	blob[1] = 0xc1;
//	blob[2] = 0x42;

//		blob[0] = 0x04;
//		blob[1] = 0x42;

//shl
	blob[0] = 0x48;
	blob[1] = 0xc1;
	blob[2] = 0xe0;
	blob[3] = 0x2a;

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

			srand(time(NULL));

			rreil_statements_print(statements);

			struct simulator_context *context = simulator_context_init();

//			uint64_t value = 0x2b3481cfef1194ba;
//			uint64_t value = 0x2b3481cfef1194ba;
//			uint64_t value = 22;
//			struct rreil_id id;
//			id.type = RREIL_ID_TYPE_X86;
//			id.x86 = RREIL_ID_X86_AX;
//			simulator_register_write_64(context, &id, value, 0);
//
//			value = 0;
//			id.x86 = RREIL_ID_X86_FLAGS;
//			simulator_register_write_64(context, &id, value, 0);
//
//			value = 0x1100000000000052;
//			id.x86 = RREIL_ID_X86_CX;
//			simulator_register_write_64(context, &id, value, 0);
//
//			simulator_context_x86_print(context);

			struct simulator_trace *trace = simulator_trace_init();
			rreil_statements_trace(trace, statements);

			printf("------------------\n");
			simulator_trace_print(trace);

			void access_init(struct register_access *access, int (*k)(void)) {
				for(size_t i = 0; i < access->indices_length; ++i) {
					size_t index = access->indices[i];
					enum rreil_id_x86 reg = (enum rreil_id_x86)index;

					size_t length = rreil_x86_amd64_sizeof(reg);
					uint32_t *data = (uint32_t*)malloc(4 * (length / (8 * 4) + 1));
					for(size_t i = 0; i < length / (8 * 4) + 1; ++i)
						data[i] = rand();

					simulator_register_generic_write(&context->x86_registers[reg],
							(uint8_t*)data, length, 0);

					free(data);
				}
			}

			int zero() {
				return 0;
			}

			access_init(&trace->written, &rand);
			access_init(&trace->read, &rand);

			struct simulator_context *context_rreil = simulator_context_copy(context);

			/*
			 * Clean up RFLAGS
			 */
			uint64_t rflags_mask = 0x0000000000244cd5;
			uint8_t *rflags_mask_ptr = (uint8_t*)&rflags_mask;
			void clean_rflags(struct simulator_context *context) {
				for(size_t i = 0;
						i < context->x86_registers[RREIL_ID_X86_FLAGS].data_bit_length / 8;
						++i) {
					context->x86_registers[RREIL_ID_X86_FLAGS].data[i] &=
							rflags_mask_ptr[i];
				}
			}
			clean_rflags(context);
			clean_rflags(context_rreil);

			printf("------------------\n");
			simulator_context_x86_print(context);

			rreil_statements_simulate(context_rreil, statements);

			uint8_t *buffer;
			size_t buffer_size = tester_code_generate(&buffer, blob, i, trace,
					context);

			void *mem_exec = mmap(NULL, buffer_size,
					PROT_READ | PROT_WRITE | PROT_EXEC, MAP_PRIVATE | MAP_ANONYMOUS, 0,
					0);

			memcpy(mem_exec, buffer, buffer_size);
			free(buffer);

			void (*f)(void) = (void (*)(void))mem_exec;

			f();
			munmap(mem_exec, buffer_size);

			clean_rflags(context);

			printf("------------------\n");
			printf("CPU:\n");
			simulator_context_x86_print(context);
			printf("Rreil simulator:\n");
			simulator_context_x86_print(context_rreil);

			printf("------------------\n");
			printf("Failing Registers:\n");

			char found = 0;
			for(size_t i = 0; i < trace->written.indices_length; ++i) {
				size_t index = trace->written.indices[i];
				enum rreil_id_x86 reg = (enum rreil_id_x86)index;

				struct register_ *reg_cpu = &context->x86_registers[index];
				struct register_ *reg_rreil = &context_rreil->x86_registers[index];

				for(size_t j = 0; j < reg_cpu->data_bit_length / 8; ++j)
					if(reg_cpu->data[j] != reg_rreil->data[j]) {
						if(found)
							printf(", ");
						rreil_id_x86_print(reg);
						found = 1;
						break;
					}
			}
			if(!found)
				printf("None\n");
			else
				printf("\n");

			simulator_trace_free(trace);

			simulator_context_free(context);
			simulator_context_free(context_rreil);

			rreil_statements_free(statements);
		}
	}
	return 0;
}
