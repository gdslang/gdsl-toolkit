/*
 * main.c
 *
 *  Created on: 22.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <gdsl.h>
#include <dis.h>
#include <gdrr.h>
#include <rreil/rreil.h>
#include <rreil/gdrr_builder.h>
#include "itree.h"

int main(void) {
	__char data[] = { 0x48, 0x83, 0xc4, 0x08 };
	size_t data_size = sizeof(data);

	__obj state = gdsl_create_state(data, data_size);

	__obj insn;
//	__word features;
	if(gdsl_decode(&insn, &state)) {
		printf("Decode failed\n");
		fflush(stderr);
		fflush(stdout);
		exit(1);
	}

	data_size = gdsl_decoded(&state);
//	features = gdsl_features_get(insn);

	printf("Instruction bytes:");
	for(size_t i = 0; i < data_size; ++i)
		printf(" %02x", (int)(data[i]) & 0xff);
	printf("\n");

	char *str = gdsl_x86_pretty(insn, GDSL_X86_PRINT_MODE_FULL);
	if(str)
		puts(str);
	else
		printf("NULL\n");
	free(str);

	printf("---------------------------\n");

	__obj rreil;
	if(gdsl_translate(&rreil, insn, &state)) {
		printf("Translate failed\n");
		fflush(stderr);
		fflush(stdout);
		exit(1);
	}

	struct gdrr_config *config = rreil_gdrr_builder_config_get();
	struct rreil_statements *statements = (struct rreil_statements*)gdrr_convert(
			rreil, config);
	free(config);

	rreil_statements_print(statements);

	printf("\n");

	struct itree_node *root = itree_root("x", 0, 63);
	char *k[] = { "x", "7", "x" };
	size_t s[] = { 3, 27 };
	itree_split(root, k, s, 3);

	char *k1[] = { "y", "10", "y" };
	size_t s1[] = { 5, 15 };
	itree_split(&root->children[1], k1, s1, 3);

	itree_print(root);

	return 0;
}
