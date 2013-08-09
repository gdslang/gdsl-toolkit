/*
 * main.cpp
 *
 *  Created on: 22.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <memory>
#include <string.h>
#include <unistd.h>
extern "C" {
#include <gdsl.h>
#include <gdsl-x86.h>
#include <rreil/rreil.h>
#include <rreil/gdrr_builder.h>
#include <context.h>
#include <simulator/simulator.h>
#include <simulator/regacc.h>
#include <readhex.h>
#include "igdrr.h"
}
#include "expression/expressions.h"
#include "analyzer.h"
#include "bbgraph/bbgraph.h"
#include "bbgraph/bbgraph_id.h"
#include "bbgraph/bbgraph_node.h"

using namespace std;

enum mode {
	MODE_NONE, MODE_CLI, MODE_CODE, MODE_CMDLINE, MODE_FILE
};

struct options {
	enum mode mode;
	char const *parameter;
};

static char args_parse(int argc, char **argv, struct options *options) {
	options->mode = MODE_NONE;

	while(1) {
		char c = getopt(argc, argv, "cpm:f:");
		switch(c) {
			case 'c': {
				options->mode = MODE_CLI;
				break;
			}
			case 'p': {
				options->mode = MODE_CODE;
				break;
			}
			case 'm': {
				options->mode = MODE_CMDLINE;
				options->parameter = optarg;
				break;
			}
			case 'f': {
				options->mode = MODE_FILE;
				options->parameter = optarg;
				break;
			}
			default: {
				goto end;
			}
		}
	}
	end: ;

	return 0;
}

//void load(uint8_t **buffer, uint8_t *address, uint64_t address_size,
//		uint64_t access_size) {
//
//}
//void store(uint8_t *buffer, uint8_t *address, uint64_t address_size,
//		uint64_t access_size) {
//
//}
void jump(uint8_t *address, uint64_t address_size) {
//	for (size_t i = 0; i < 8; ++i)
//		printf("%02x", address[i]);
//	printf("\n");
	printf("%lu\n", *((uint64_t*)address));
}

static void ip_set(struct context *context,
		void *next_instruction_address) {
	struct data insn_address;
	insn_address.data = (uint8_t*)&next_instruction_address;
	insn_address.bit_length = sizeof(next_instruction_address) * 8;
	context_data_define(&insn_address);

	simulator_register_generic_write(&context->x86_registers[X86_ID_IP],
			insn_address, 0);

	free(insn_address.defined);
}

static size_t code(uint8_t **buffer) {
	uint8_t data[] = { 0x48, 0xc7, 0xc0, 0xe7, 0x03, 0x00, 0x00, 0x48, 0x83, 0xc0,
			0x2a, 0xb4, 0x3e, 0xff, 0xe0 };
	size_t data_size = sizeof(data);

	*buffer = (uint8_t*)malloc(data_size);
	memcpy(*buffer, data, data_size);

	return data_size;
}

int main(int argc, char **argv) {
	struct options options;
	args_parse(argc, argv, &options);

	uint8_t *data;
	size_t data_size;

//	shared_ptr<bbgraph_node> root = shared_ptr<bbgraph_node>(new bbgraph_node(new bbgraph_id(1000, 0)));
//
//	auto a = shared_ptr<bbgraph_node>(new bbgraph_node(new bbgraph_id(1001, 0)));
//	root->add_child(a);
//
//	auto b = shared_ptr<bbgraph_node>(new bbgraph_node(new bbgraph_id(1002, 0)));
//	root->add_child(b);
//	b->add_child(shared_ptr<bbgraph_node>(new bbgraph_node(new bbgraph_id(1002, 1))));
//
//	bbgraph *tree = new bbgraph(root);
//
//	tree->print_dot();

//	exit(0);

	switch(options.mode) {
		case MODE_NONE: {
			printf("Usage ... :-P\n");
			exit(1);
		}
		case MODE_CLI: {
			data_size = readhex_hex_read(stdin, (char**)&data);
			break;
		}
		case MODE_CMDLINE: {
			FILE *stream = fmemopen((void*)options.parameter,
					strlen(options.parameter) + 1, "r");
			data_size = readhex_hex_read(stream, (char**)&data);
			fclose(stream);
			break;
		}
		case MODE_FILE: {
			FILE *f = fopen(options.parameter, "r");
			size_t chunk = 32;
			size_t data_length = 0;
			data_size = 4*chunk;
			data = (uint8_t*)malloc(data_size);
			while(!feof(f)) {
				if(data_length + chunk > data_size) {
					data_size <<= 1;
					data = (uint8_t*)realloc(data, data_size);
				}
				data_length += fread(data + data_length, chunk, 1, f);
			}
			fclose(f);
			break;
		}
		case MODE_CODE: {
			data_size = code(&data);
			break;
		}
	}

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

	shared_ptr<bbgraph_node> root;
	tie(root, ignore) = bbgraph::from_rreil_statements(statements, 1000);
	bbgraph *g = new bbgraph(root);
	g->print_dot();
	delete g;

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

	shared_ptr<expression> exp = analyze(statements);

	printf("----------------------------\n");

	exp->print();
	printf("\n");

	uint64_t evaluated;
	char evalable = exp->evaluate(&evaluated);
	if(evalable) {
		printf("Evaluated: %lu\n", evaluated);

		struct context *context = context_init(NULL, NULL, &jump);
		ip_set(context, NULL);

		printf("Simulator: ");
		simulator_statements_simulate(context, statements);

		context_free(context);

	} else
		printf("Unable to evaluate :-(.\n");

	rreil_statements_free(statements);
	free(data);

	return 0;
}
