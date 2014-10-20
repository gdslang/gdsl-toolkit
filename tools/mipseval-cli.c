/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <unistd.h>
#include <getopt.h>
#include <readhex.h>
//#include <fstream>
//#include <iostream>
#include <gdsl.h>

int main(int argc, char** argv) {
	char retval = 0;

	size_t size = 8;
	uint8_t *buffer = (uint8_t*) malloc(size);
	uint32_t randVal = random();
	*(uint32_t*)buffer = 0xFFFFFFFF;
	*(((uint32_t*)buffer)+1) = random();

	//size_t size = sizeof(uint32_t);//readhex_hex_read(stdin, &buffer);

	state_t state = gdsl_init();

	FILE *f;
	f = fopen("snackipack.txt", "w");

	/*ofstream out("snackipack.txt");
	if (!out) {
		printf("FATAL ERROR: COULDNT OPEN FILE");
		return 1;
	}*/

	for (int pew = 0; pew < 8; pew++)
	{
		uint32_t randi = pew;
		printf("%s%08X", (randi==0)?"":"\n", randi);
		gdsl_set_code(state, (char*)&randi, sizeof(uint32_t), 0);
		if(setjmp(*gdsl_err_tgt(state))) {
			if (!strcmp(gdsl_get_error_message(state), "DecodeSequenceMatchFailure")) {
				char conv[512];
				snprintf(conv, sizeof(conv), ".long 0x%08X\n", randi);
				fwrite(conv, 1, strlen(conv), f);
			} else {
				fprintf(stderr, "decode nailed: %s\n", gdsl_get_error_message(state));
				retval = 1;
				goto cleanup;
			}
			continue;
		}

		obj_t insn = gdsl_decode(state, gdsl_config_default(state));

		string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn));
		fwrite(fmt, 1, strlen(fmt), f);
		fwrite("\n", 1, sizeof("\n")-1, f);
		printf("    %s", fmt);
	}
  //obj_t insn_asm = gdsl_generalize(state, insn);
  //string_t asm_gen_str = gdsl_merge_rope(state, gdsl_asm_pretty(state, insn_asm));
	//puts(asm_gen_str);

	cleanup:

	printf("\n");
	gdsl_destroy(state);
	free(buffer);
	fclose(f);

	return retval;
}

