/*
 * main.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/block.h>
#include <cppgdsl/frontend/bare_frontend.h>
#include <cppgdsl/frontend/frontend.h>
#include <cppgdsl/rreil/linear/lin_imm.h>
#include <cppgdsl/instruction.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <cppgdsl/rreil_builder.h>
#include <cppgdsl/gdsl.h>
#include <cppgdsl/rreil/statement/load.h>
#include <cppgdsl/rreil/visitor.h>

#include <cppgdsl/preservation.h>
#include <cppgdsl/rreil/linear/lin_var.h>

#include <cppgdsl/rreil/linear/lin_binop.h>

#include <cppgdsl/rreil/statement/assign.h>
#include <cppgdsl/rreil/statement/statement_visitor.h>
#include <stdio.h>
#include <climits>
#include <stdlib.h>
#include <iostream>
#include <string>

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

  g.reset_heap();

  printf("RReil:\n");
  for(statement *s : *rreil)
    printf("%s\n", s->to_string().c_str());

  printf("\n---------------------------------\n");
  printf("Sizes of assignments:\n");
  for(statement *s : *rreil) {
    example_visitor v;
    s->accept(v);
  }
  printf("Sizes of assignments and loads:\n");
  for(statement *s : *rreil) {

    bool ip = false;
    int_t ip_offset;

    statement_visitor v;
    v._([&](assign *a) {
      visitor *ev = new visitor();
      ((linear_visitor*)ev)->_([&](lin_binop *a) {
        if(a->get_op() == BIN_LIN_ADD) {
          linear_visitor lv;
          lv._([&](lin_var *v) {
            if(v->get_var()->get_id()->to_string() == "IP") {
              ip = true;
            }
          });
          a->get_opnd1()->accept(lv);
          lv._([&](lin_imm *i) {
            ip_offset = i->get_imm();
          });
          a->get_opnd2()->accept(lv);
        }
       });
      a->accept(*ev);
      printf("Size of assignment: %lld\n", a->get_size());

      delete ev;
    });

    v._([&](load *l) {
      printf("Size of load: %lld\n", l->get_size());
    });
    s->accept(v);

    if(ip) {
      printf("IP added offset: %llu\n", ip_offset);
    }
  }
  printf("Counting variables...\n");
  size_t vars = 0;
  for(statement *s : *rreil) {
    visitor *v = new visitor();
    ((statement_visitor*)v)->_([&](assign *a) {
      printf("Assignment\n");
    });

    v->_([&](variable *a) {
      vars++;
      printf("Variable!\n");
    });
    s->accept(*v);
    delete v;
  }
  printf("Number of variables: %zu\n", vars);

  // Cleanup
  for(statement *s : *rreil)
    delete s;
  delete rreil;
}

void demo_block(gdsl::gdsl &g) {
  uint8_t buffer[] = {0x00, 0x00, 0x00, 0x00, 0xc3};
  g.set_code((char*)buffer, sizeof(buffer), 0);

  block b = g.decode_translate_block(gdsl::preservation::BLOCK, LONG_MAX);

  auto insns = b.get_instructions();

//  printf("Instructions (total length: %lld):\n", b.length());
//  for(gdsl::instruction i : *insns)
//    printf("%s /length: %lld\n", i.to_string().c_str(), i.length());

  g.reset_heap();

  printf("---------------------------------\n");

  auto rreil = b.get_statements();

  printf("RReil:\n");
  for(statement *s : *rreil)
    //printf("%s\n", s->to_string().c_str());
    std::cout << *s << std::endl;

  // Cleanup
  for(statement *s : *rreil)
    delete s;
  delete rreil;
}

int main(void) {
  try {
    gdsl::bare_frontend f("x86");
    gdsl::gdsl g(&f);

    demo_single(g);

    printf("\n###############################\n\n");

    demo_block(g);
  }
  catch(std::string &s) {
    printf("Exception: %s\n", s.c_str());
  }
}
