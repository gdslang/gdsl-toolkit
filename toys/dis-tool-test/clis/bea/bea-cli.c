/*
 * bea-cli.c
 *
 *  Created on: May 29, 2012
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#define BEA_ENGINE_STATIC  /* specify the usage of a static version of BeaEngine */
#define BEA_USE_STDCALL    /* specify the usage of a stdcall version of BeaEngine */
#include <beaengine/BeaEngine.h>
#include <readhex.h>

int main(int argc, char* argv[]) {

	/* ============================= Init datas */
	DISASM MyDisasm;
	int len, i = 0;
	int Error = 0;

	/* ===================== display the version and revision used */
	(void)printf("Version : %s\n", BeaEngineVersion());
	(void)printf("Revision : %s\n", BeaEngineRevision());
	/* ============================= Init the Disasm structure (important !)*/
	(void)memset(&MyDisasm, 0, sizeof(DISASM));

	/* ============================= Init EIP */
	char *buffer;
	size_t length = readhex_hex_read(stdin, &buffer);
	MyDisasm.EIP = (UIntPtr)buffer;

	MyDisasm.Archi = 64;

//	/* ============================= Select Display Option */
//	MyDisasm.Options = Tabulation + NasmSyntax + PrefixedNumeral + ShowSegmentRegs;

	/* ============================= Loop for Disasm */
	while(!Error) {
		len = Disasm(&MyDisasm);
		if(len != UNKNOWN_OPCODE) {
			(void)puts(MyDisasm.CompleteInstr);
			MyDisasm.EIP = MyDisasm.EIP + (UIntPtr)len;
			if((char*)MyDisasm.EIP >= buffer + length)
				break;
			i++;
		} else
			Error = 1;
	};

	free(buffer);

	return 0;

}
