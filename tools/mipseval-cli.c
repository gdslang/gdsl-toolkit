/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <unistd.h>
#include <getopt.h>
#include <readhex.h>
#include <gdsl.h>

// evaluation paramters
#define NUM_OF_CYCLES					0x1000		// 4096
#define START_CYCLE						0			// of 4096
#define INSNS_PER_CYCLE					0x00100000  // 1'048'576

// intput/output defines
#define ELF_TEXT_SECTION_OFFSET			0x40
#define ASSEMBLER_TEXT_INPUT_FILE		"asinput.txt"
#define ASSEMBLER_BINARY_OUTPUT_FILE	"asoutput.out"

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

	const unsigned int cycle_interval = INSNS_PER_CYCLE;
	const unsigned int max_cycles = NUM_OF_CYCLES;
	const unsigned int round_offset = START_CYCLE;
	const unsigned int start_offset = round_offset * cycle_interval + 0x00000000;

	unsigned int cur_insn = start_offset;
	const unsigned int inst_block_size = sizeof(uint32_t) * cycle_interval * 3;
	uint32_t *inst_buf = (uint32_t*) malloc(inst_block_size);
	for (unsigned int rounds = round_offset; rounds < max_cycles; rounds++) {

		printf("\tnew cycle: %d/%d  : %08X => %08X", rounds+1, max_cycles, invInsn(cur_insn), cur_insn);

		state_t state = gdsl_init();

		FILE *f;
		f = fopen(ASSEMBLER_TEXT_INPUT_FILE, "w");

		unsigned int inst_buf_entries = 0;
		for (unsigned int pew = 0; pew < cycle_interval; pew++, cur_insn++)
		{
			gdsl_set_code(state, (char*)&cur_insn, sizeof(uint32_t), 0);
			if(setjmp(*gdsl_err_tgt(state)))
			{
				fprintf(stderr, "decode nailed: %s\n", gdsl_get_error_message(state));
				return 1;
			}

			obj_t insn = gdsl_decode(state, gdsl_config_default(state));
			string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn));

			// check for successful decoding
			if (isInsn("UNDEFINED", fmt) || isInsn("UNPREDICTABLE", fmt))
				continue;

			// add instruction to decoded list in order to verify it later on
			inst_buf[inst_buf_entries++] = cur_insn;

			// special case div; as catches division by zero; additional operand $zero prevents this
			char div[512] = "";
			if (isInsn("DIV", fmt)) {
				snprintf(div, sizeof(div), "DIV $zero, %s", fmt+4);
				fmt = div;
			}
			if (isInsn("DIVU", fmt)) {
				snprintf(div, sizeof(div), "DIVU $zero, %s", fmt+5);
				fmt = div;
			}

			// all branches and jumps reorder instructions. insertion of a nop prevents this
			if (isInsn("JR", fmt) || isInsn("JALR", fmt) || isInsn("JALR.HB", fmt) || isInsn("JR.HB", fmt)
					|| isInsn("JALX", fmt) || isInsn("JAL", fmt) || isInsn("J", fmt)
					|| isInsn("BEQ", fmt) || isInsn("BGEZ", fmt) || isInsn("BGEZAL", fmt)
					|| isInsn("BGTZ", fmt) || isInsn("BLEZ", fmt)
					|| isInsn("BLTZ", fmt) || isInsn("BLTZAL", fmt) || isInsn("BNE", fmt)
					|| isInsn("BC1F", fmt) || isInsn("BC1T", fmt)
					|| isInsn("BC2F", fmt) || isInsn("BC2T", fmt)
				) {
				fwrite("nop\n", 1, sizeof("nop\n")-1, f);
				inst_buf[inst_buf_entries++] = 0x00000000;
			}
			if (isInsn("BEQL", fmt) || isInsn("BGEZALL", fmt)
					|| isInsn("BGEZL", fmt) || isInsn("BGTZL", fmt) || isInsn("BLEZL", fmt)
					|| isInsn("BLTZALL", fmt) || isInsn("BLTZL", fmt) || isInsn("BNEL", fmt)
					|| isInsn("BC1FL", fmt) || isInsn("BC1TL", fmt)
					|| isInsn("BC2FL", fmt) || isInsn("BC2TL", fmt)
				) {
				inst_buf[inst_buf_entries++] = 0x00000000;
			}

			fwrite(fmt, 1, strlen(fmt), f);
			fwrite("\n", 1, sizeof("\n")-1, f);
		}

		printf("\n");
		fclose(f);
		gdsl_destroy(state);

		// in case of an empty block
		if (inst_buf_entries == 0) {
			printf("\tempty block...succeeded\n\n");
			continue;
		}

		// assembly
		printf("\tassembling...");
		if (system("/home/rupert/carambola2/staging_dir/toolchain-mips_r2_gcc-4.7-linaro_uClibc-0.9.33.2/initial/mips-openwrt-linux-uclibc/bin/as -mips32r2 -no-warn -o " ASSEMBLER_BINARY_OUTPUT_FILE " " ASSEMBLER_TEXT_INPUT_FILE)) {
			printf("\n\n\tfailed at: %d/%d  : %08X => %08X\n\n", rounds+1, max_cycles, invInsn(cur_insn), cur_insn);
			break;
		}

		// compare files:
		printf("comparing...");
		f = fopen(ASSEMBLER_BINARY_OUTPUT_FILE, "rb");

		char *as_buf = (char*) malloc(inst_block_size);

		// skip elf header and go straight to the .text section
		fread(as_buf, 1, ELF_TEXT_SECTION_OFFSET, f);

		int bSucc = 1;
		int rb = fread(as_buf, inst_buf_entries * sizeof(uint32_t), 1, f);
		if (rb != 1) {
			// couldnt read data, not enough data
			printf("case 1\n");
			bSucc = 0;
		} else if (feof(f)) {
			// theres still data, more than expected
			printf("case 2\n");
			bSucc = 0;
		} else if (memcmp(as_buf, inst_buf, inst_buf_entries * sizeof(uint32_t))) {
			// read data is different to the expected one
			printf("case 3\n");

			uint32_t *peep = (uint32_t*)as_buf;
			for (unsigned int t = 0; t < inst_buf_entries; t++) {
				if (inst_buf[t] != peep[t]) {
					printf("\t\tmiss at 0x%X (0x%X, %d):  %08X  %08X\n", t*4, t, t, invInsn(inst_buf[t]), invInsn(peep[t]));
					break;
				}
			}
			bSucc = 0;
		}

		free(as_buf);
		fclose(f);

		printf("%s\n\n", (bSucc == 1)?"succeeded":"failed");

		if (bSucc != 1)
			break;
	}
	free(inst_buf);

	return 0;
}

