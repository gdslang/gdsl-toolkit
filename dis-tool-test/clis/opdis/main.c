/*
 * main.c
 *
 *  Created on: May 28, 2012
 *      Author: jucs
 */

#include <opdis/opdis.h>
#include <opdis/types.h>
#include <bfd.h>

void disassemble_mem(void * src, size_t length) {
	opdis_t o;

	opdis_buf_t buf = opdis_buf_alloc(length, (opdis_vma_t)src);
	opdis_buf_fill(buf, 0, src, length);

	o = opdis_init();

	//opdis_set_arch(o, bfd_arch_k1om, bfd_mach_k1om, NULL);
	const bfd_arch_info_type *arch_info = bfd_scan_arch("i386:x86-64");
	opdis_set_arch(o, arch_info->arch, arch_info->mach, NULL );

	opdis_disasm_linear(o, buf, (opdis_vma_t)src, length);
	opdis_term(o);
}

int main() {
	char x[] = { 0x48, 0x8b, 0x05, 0xf9, 0x27, 0x20, 0x00 };
	disassemble_mem(x, 7);

	return 0;
}
