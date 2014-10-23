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

int isInsn(char *mnemonic, char *fmt)
{
	return strlen(fmt) >= strlen(mnemonic) && !memcmp(mnemonic, fmt, strlen(mnemonic)) && (fmt[strlen(mnemonic)] == ' ' || fmt[strlen(mnemonic)] == '\0');
}

uint32_t bitInv(uint32_t insn)
{
	uint32_t res = 0x00000000;
	for (int i = 0; i < 32; i++) {
		res <<= 1;
		res += (insn >> i) & 0x00000001;
	}
	return res;
}

uint32_t invInsn(uint32_t insn)
{
	uint32_t res;
	char *src = (char*) &insn, *dst = (char*) &res;

	dst[0] = src[3];
	dst[1] = src[2];
	dst[2] = src[1];
	dst[3] = src[0];

	return res;
}

int main(int argc, char** argv) {

	char retval = 0;

	const unsigned int cycle_interval = 0x00100000;
	const unsigned int max_cycles = 0x1000;
	const unsigned int round_offset = 2728;
	const unsigned int start_offset = round_offset * cycle_interval + 0x00000000;

	unsigned int cur_insn = start_offset;//invInsn(start_offset);
	const unsigned int inst_block_size = sizeof(uint32_t) * cycle_interval * 3;
	uint32_t *inst_buf = (uint32_t*) malloc(inst_block_size);
	for (unsigned int rounds = round_offset; rounds < max_cycles; rounds++) {

		printf("\tnew cycle: %d/%d  : %08X => %08X", rounds+1, max_cycles, invInsn(cur_insn), cur_insn);

		state_t state = gdsl_init();

		FILE *f;
		f = fopen("snackipack.txt", "w");

		unsigned int inst_buf_entries = 0;
		for (unsigned int pew = 0; pew < cycle_interval; pew++, cur_insn++)//cur_insn = invInsn(invInsn(cur_insn)+1))
		{
			inst_buf[inst_buf_entries++] = cur_insn;

			gdsl_set_code(state, (char*)&cur_insn, sizeof(uint32_t), 0);
			char conv[512];
			snprintf(conv, sizeof(conv), ".long 0x%08X\n", invInsn(cur_insn));
			if(setjmp(*gdsl_err_tgt(state)))
			{
				fwrite(conv, 1, strlen(conv), f);
				if (!strcmp(gdsl_get_error_message(state), "DecodeSequenceMatchFailure")) {
				} else if (!strcmp(gdsl_get_error_message(state), "unsatisfiable guards at specifications/mips/mips.ml:371.4-9")
						|| !strcmp(gdsl_get_error_message(state), "unsatisfiable guards at specifications/mips/mips.ml:396.4-10")
						|| !strcmp(gdsl_get_error_message(state), "unsatisfiable guards at specifications/mips/mips.ml:401.4-10")
						|| !strcmp(gdsl_get_error_message(state), "unsatisfiable guards at specifications/mips/mips.ml:289.4-10")
						|| !strcmp(gdsl_get_error_message(state), "unsatisfiable guards at specifications/mips/mips.ml:294.4-10")
						) {
					//printf("  guard prob!\n");
				} else {
					fprintf(stderr, "decode nailed: %s\n", gdsl_get_error_message(state));
					//printf("\n\n\tfailed at: %d/%d  : %08X => %08X\n\n", rounds+1, max_cycles, invInsn(cur_insn), cur_insn);
					retval = 1;
					return retval;
				}
				continue;
			}

			obj_t insn = gdsl_decode(state, gdsl_config_default(state));

			string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn));

			// special cases
			if (isInsn("BREAK", fmt)								// code20 is limited to 10 bits; code10 endianess is swapped?
					|| isInsn("PAUSE", fmt) || isInsn("TLBINV", fmt)
					|| isInsn("TLBINVF", fmt)						// unknown op, but only single pattern
					|| isInsn("DIV", fmt) || isInsn("DIVU", fmt)	// as catches division by zero ...
					|| isInsn("BC2F", fmt) || isInsn("BC2T", fmt) || isInsn("BC2F", fmt) || isInsn("BC2FL", fmt)
					|| isInsn("BC2T", fmt) || isInsn("BC2TL", fmt)	// assembler syntax?
					|| isInsn("LWXC1", fmt)							// index(base) ...
					|| isInsn("LB", fmt) || isInsn("LBE", fmt) || isInsn("LBU", fmt) || isInsn("LBUE", fmt)
					|| isInsn("LDC1", fmt) || isInsn("LDC2", fmt) || isInsn("LDXC1", fmt)
					|| isInsn("LH", fmt) || isInsn("LHE", fmt) || isInsn("LHU", fmt) || isInsn("LHUE", fmt)
					|| isInsn("LL", fmt) || isInsn("LLE", fmt) || isInsn("LUXC1", fmt)
					|| isInsn("LW", fmt) || isInsn("LWE", fmt) || isInsn("LWL", fmt) || isInsn("LWLE", fmt)
					|| isInsn("LWR", fmt) || isInsn("LWRE", fmt) || isInsn("LWXC1", fmt)
					|| isInsn("LWC1", fmt) || isInsn("LWC2", fmt)	// index(base), offset(base)
					|| isInsn("SB", fmt) || isInsn("SBE", fmt) || isInsn("SC", fmt) || isInsn("SCE", fmt)
					|| isInsn("SDC1", fmt) || isInsn("SDC2", fmt) || isInsn("SDXC1", fmt)
					|| isInsn("SH", fmt) || isInsn("SHE", fmt) || isInsn("SUXC1", fmt)
					|| isInsn("SW", fmt) || isInsn("SWE", fmt) || isInsn("SWC1", fmt) || isInsn("SWC2", fmt)
					|| isInsn("SWL", fmt) || isInsn("SWLE", fmt) || isInsn("SWR", fmt) || isInsn("SWRE", fmt)
					|| isInsn("SWXC1", fmt)							// index(base), offset(base)
					|| isInsn("CACHE", fmt) || isInsn("CACHEE", fmt)// index(base), offset(base)
					|| isInsn("PREF", fmt) || isInsn("PREFE", fmt)
					|| isInsn("PREFX", fmt) || isInsn("SYNCI", fmt)	// index(base), offset(base)
					|| isInsn("MTC1", fmt) || isInsn("CTC1", fmt)
					|| isInsn("MTHC1", fmt)							// swapped dest and source; rt and fs
					|| isInsn("MTC2", fmt) || isInsn("MFC2", fmt)
					|| isInsn("CFC2", fmt) || isInsn("CTC2", fmt)	// impl field is in as just 0-31
					|| isInsn("INS", fmt)							// operands depend on each other (msb, lsb) ... size/pos
					) {
				fwrite(conv, 1, strlen(conv), f);
				continue;
			}
			// all branches and jumps reorder instructions, so a nop is inserted to prevent this
			if (isInsn("JR", fmt) || isInsn("JALR", fmt) || isInsn("JALR.HB", fmt) || isInsn("JR.HB", fmt) || isInsn("JALX", fmt) || isInsn("JAL", fmt) || isInsn("J", fmt)
					|| isInsn("BEQ", fmt) || isInsn("BGEZ", fmt) || isInsn("BGEZAL", fmt)
					|| isInsn("BGTZ", fmt) || isInsn("BLEZ", fmt)
					|| isInsn("BLTZ", fmt) || isInsn("BLTZAL", fmt) || isInsn("BNE", fmt)
					|| isInsn("BC1F", fmt) || isInsn("BC1T", fmt)
				) {
				fwrite("nop\n", 1, sizeof("nop\n")-1, f);
				inst_buf[inst_buf_entries++] = 0x00000000;
			}
			if (isInsn("BEQL", fmt) || isInsn("BGEZALL", fmt)
					|| isInsn("BGEZL", fmt) || isInsn("BGTZL", fmt) || isInsn("BLEZL", fmt)
					|| isInsn("BLTZALL", fmt) || isInsn("BLTZL", fmt) || isInsn("BNEL", fmt)
					|| isInsn("BC1FL", fmt) || isInsn("BC1TL", fmt)
				) {
				inst_buf[inst_buf_entries++] = 0x00000000;
			}

			fwrite(fmt, 1, strlen(fmt), f);
			fwrite("\n", 1, sizeof("\n")-1, f);
		}

		printf("\n");
		fclose(f);

		// assembly
		printf("\tassembling...");
		if (system("/home/rupert/carambola2/staging_dir/toolchain-mips_r2_gcc-4.7-linaro_uClibc-0.9.33.2/initial/mips-openwrt-linux-uclibc/bin/as -mips32r2 -mhard-float -no-warn --no-trap --no-break -o snacki.out snackipack.txt")) {
			printf("\n\n\tfailed at: %d/%d  : %08X => %08X\n\n", rounds+1, max_cycles, invInsn(cur_insn), cur_insn);
			break;
		}

		// compare files:
		printf("comparing...");
		f = fopen("snacki.out", "rb");

		char *as_buf = (char*) malloc(inst_block_size);

		// .text section offset is 0x40 in as elf files
		fread(as_buf, 1, 0x40, f);

		int bSucc = 1;
		int rb = fread(as_buf, inst_buf_entries * sizeof(uint32_t), 1, f);
		if (rb != 1) {
			printf("case 1\n");
			bSucc = 0;
		} else if (feof(f)) {
			printf("case 2\n");
			bSucc = 0;
		} else if (memcmp(as_buf, inst_buf, inst_buf_entries * sizeof(uint32_t))) {
			printf("case 3\n");

			uint32_t *peep = (uint32_t*)as_buf;
			for (int t = 0; t < inst_buf_entries; t++) {
				if (inst_buf[t] != peep[t]) {
					//printf("  at %d:  %08X  %08X\n", t-1, inst_buf[t-1], peep[t-1]);
					printf("\t\tmiss at 0x%X (0x%X, %d):  %08X  %08X\n", t*4, t, t, invInsn(inst_buf[t]), invInsn(peep[t]));
					//printf("  at %d:  %08X  %08X\n", t+1, inst_buf[t+1], peep[t+1]);
					break;
				}
			}

			/*
			for (int t = 0; t < inst_buf_entries; t++) {
				if (printf("  %08X\n", inst_buf[t]);
			}
			for (int t = 0; t < inst_buf_entries; t++)
				printf("  %08X\n", peep[t]);
			*/				//printf("  %08X  %08X\n", *(((uint32_t*)as_buf)+4*t), *(((uint32_t*)inst_buf)+4*t));
			bSucc = 0;
		}

		free(as_buf);
		fclose(f);
		gdsl_destroy(state);

		printf("%s\n\n", (bSucc == 1)?"succeeded":"failed");

		if (bSucc != 1)
			break;
	}
	free(inst_buf);

	return retval;
}

