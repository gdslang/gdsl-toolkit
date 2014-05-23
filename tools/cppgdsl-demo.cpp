/*
 * main.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/block.h>
#include <cppgdsl/frontend/bare_frontend.h>
#include <cppgdsl/frontend/frontend.h>
#include <cppgdsl/instruction.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <cppgdsl/rreil_builder.h>
#include <cppgdsl/gdsl.h>
#include <cppgdsl/rreil/statement/assign.h>
#include <cppgdsl/rreil/statement/statement_visitor.h>
#include <stdio.h>

using gdsl::block;

using namespace gdsl::rreil;

struct example_visitor : public statement_visitor {
  void visit(assign *s) {
    printf("Size of assignment: %lld\n", s->get_size());
  }

  void _default() {
    printf("No assignment :-(\n");
  }
};

void demo_single(gdsl::gdsl &g) {
  uint16_t buffer = 0x0000;
  g.set_code((char*)&buffer, sizeof(buffer), 0);

  gdsl::instruction insn = g.decode();

  printf("Instruction: %s\n", insn.to_string().c_str());
  printf("---------------------------------\n");

  auto rreil = insn.translate();

  printf("RReil:\n");
  for(statement *s : *rreil)
    printf("%s\n", s->to_string().c_str());

  printf("\n---------------------------------\n");
  printf("Sizes of assignments:\n");
  for(statement *s : *rreil) {
    example_visitor v;
    s->accept(v);
  }

  // Cleanup
  for(statement *s : *rreil)
    delete s;
  delete rreil;
}

void demo_block(gdsl::gdsl &g) {
  uint8_t buffer[] = {0x00, 0x00, 0xc3};
  g.set_code((char*)buffer, sizeof(buffer), 0);

  block b = g.decode_translate_block();

  auto insns = b.get_instructions();

  printf("Instructions:\n");
  for(gdsl::instruction i : *insns)
    printf("%s\n", i.to_string().c_str());

  printf("---------------------------------\n");

  auto rreil = b.get_statements();

  printf("RReil:\n");
  for(statement *s : *rreil)
    printf("%s\n", s->to_string().c_str());

  // Cleanup
  for(statement *s : *rreil)
    delete s;
  delete rreil;
}

int main(void) {
  gdsl::bare_frontend f("x86");
  gdsl::gdsl g(&f);

  demo_single(g);

  printf("\n###############################\n\n");

  demo_block(g);
}
