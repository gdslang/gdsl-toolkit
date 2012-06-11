/*
 * main.c
 *
 *  Created on: May 28, 2012
 *      Author: jucs
 */

#include <stdlib.h>
#include <opdis/opdis.h>
#include <opdis/types.h>
#include <bfd.h>
#include <readhex.h>

void disassemble_mem(void * src, size_t length) {
	opdis_t o;

	opdis_buf_t buf = opdis_buf_alloc(length, (opdis_vma_t)src);
	opdis_buf_fill(buf, 0, src, length);

	o = opdis_init();

	//opdis_set_arch(o, bfd_arch_k1om, bfd_mach_k1om, NULL);
	//const bfd_arch_info_type *arch_info = bfd_scan_arch("i386:x86-64");
	opdis_set_arch(o, bfd_arch_i386, bfd_mach_x86_64, print_insn_i386_att);

	opdis_disasm_linear(o, buf, (opdis_vma_t)src, length);
	
	opdis_buf_free(buf);

	opdis_term(o);
}

int main(int argc, char **argv) {
	char *buffer;
	size_t length = readhex_hex_read(stdin, &buffer);

	disassemble_mem(buffer, length);

	free(buffer);

	return 0;
}
