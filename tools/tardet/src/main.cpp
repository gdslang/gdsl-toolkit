/*
 * main.cpp
 *
 *  Created on: 22.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
extern "C" {
#include <gdsl.h>
#include <gdsl-x86.h>
#include <rreil/rreil.h>
#include <rreil/gdrr_builder.h>
#include <readhex.h>
#include "igdrr.h"
}
#include "itree.h"
#include "expression/binary_expression.h"
#include "analyzer.h"

int main(void) {
	uint8_t data[] = { 0x48, 0xc7, 0xc0, 0xe7, 0x03, 0x00, 0x00, 0x48, 0x83, 0xc0,
			0x2a, 0xb4, 0x3e, 0xff, 0xe0 };
	size_t data_size = sizeof(data);

	state_t state = gdsl_init();
	gdsl_set_code(state, (char*)data, data_size, 0);

//	__obj insn;
////	__word features;
//	if(gdsl_decode(&insn, &state)) {
//		printf("Decode failed\n");
//		fflush(stderr);
//		fflush(stdout);
//		exit(1);
//	}
//
//	data_size = gdsl_decoded(&state);
////	features = gdsl_features_get(insn);
//
//	printf("Instruction bytes:");
//	for(size_t i = 0; i < data_size; ++i)
//		printf(" %02x", (int)(data[i]) & 0xff);
//	printf("\n");
//
//	char *str = gdsl_x86_pretty(insn, GDSL_X86_PRINT_MODE_FULL);
//	if(str)
//		puts(str);
//	else
//		printf("NULL\n");
//	free(str);
//
//	printf("---------------------------\n");
//
//	__obj rreil;
//	if(gdsl_translate(&rreil, insn, &state)) {
//		printf("Translate failed\n");
//		fflush(stderr);
//		fflush(stdout);
//		exit(1);
//	}

	obj_t rreil;
	if(gdsl_translate_block(state, &rreil)) {
		printf("Translate block failed\n");
		fflush(stderr);
		fflush(stdout);
		gdsl_destroy(state);
		exit(1);
	}

	struct rreil_statements *statements = statements_get(state, rreil);

	gdsl_destroy(state);

	rreil_statements_print(statements);
//
//	printf("\n");

//	shared_ptr<class expression> a(new subtraction(new immediate(7), new immediate(12)));
//	shared_ptr<class expression> b(new addition(new immediate(9), new immediate(2)));
//	shared_ptr<class expression> c(new subtraction(new immediate(5), new immediate(1)));
//	shared_ptr<class expression> d(new subtraction(new immediate(33), new immediate(12)));
//	shared_ptr<class expression> e(new addition(new immediate(99), new immediate(44)));
//	shared_ptr<class expression> f(new subtraction(new immediate(0), new immediate(66)));
//
//	itree_leaf_node *root = new itree_leaf_node(a, 0, 63);
//
//	shared_ptr<class expression>k[] = { a, b, a };
//	size_t s[] = { 3, 27 };
//	itree_inner_node *inner = root->split(k, s, 3);
//
//	shared_ptr<class expression>k1[] = { c, e, c };
//	size_t s1[] = { 5, 15 };
//
//	itree_node **children = inner->children_get();
//	itree_node *one_new = ((itree_leaf_node*)children[1])->split(k1, s1, 3);
//	delete children[1];
//	children[1] = one_new;
//
//	inner->print();
//
//	delete root;
//	delete inner;

//	struct itree_node *root = itree_root("x", 0, 63);
//	char *k[] = { "x", "7", "x" };
//	size_t s[] = { 3, 27 };
//	itree_split(root, k, s, 3);
//
//	char *k1[] = { "y", "10", "y" };
//	size_t s1[] = { 5, 15 };
//	itree_split(&root->children[1], k1, s1, 3);
//
//	itree_print(root);

	printf("----------------------------\n");

	itree *tree = analyze(statements);
	tree->print();

	uint64_t evaluated;
	char evalable = tree->evaluate(&evaluated);
	if(evalable)
		printf("Evaluated: %lu\n", evaluated);
	else
		printf("Unable to evaluate :-(.\n");

	delete tree;
	rreil_statements_free(statements);

	return 0;
}
