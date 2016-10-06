/*
 * cppgdsl-demo.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <stddef.h>
#include <stdio.h>
#include <climits>
#include <cstdint>
#include <functional>
#include <iostream>
#include <memory>
#include <string>
#include <vector>

#include "cppgdsl/assembly/arch/x86/factory.h"
#include "cppgdsl/assembly/assembly.h"
#include "cppgdsl/block.h"
#include "cppgdsl/frontend/bare_frontend.h"
#include "cppgdsl/gdsl.h"
#include "cppgdsl/instruction.h"
#include "cppgdsl/optimization.h"
#include "cppgdsl/rreil/arch/x86/factory.h"
#include "cppgdsl/rreil/rreil.h"
#include "cppgdsl/rreil/visitor.h"
#include "gdsl_generic.h"

using gdsl::assembly::bounded;
using gdsl::assembly::operand_visitor;
using gdsl::assembly::register_;
using gdsl::block;
using gdsl::rreil::assign;
using gdsl::rreil::binop_lin_op;
using gdsl::rreil::lin_binop;
using gdsl::rreil::lin_imm;
using gdsl::rreil::lin_var;
using gdsl::rreil::linear_visitor;
using gdsl::rreil::load;
using gdsl::rreil::make_id;
using gdsl::rreil::statement_visitor;
using gdsl::rreil::variable;
using gdsl::rreil::visitor;
using std::cout;
using std::endl;

struct example_visitor : public statement_visitor {
  void visit(assign* s) { printf("Size of assignment: %lld\n", s->get_size()); }

  void _default() { printf("No assignment :-(\n"); }
};

void demo_single(gdsl::gdsl& g) {
  // First example: ADD BYTE PTR [RAX], AL
  // uint16_t buffer = 0x0000;

  // Second example: ADD RSP, 8
  uint32_t buffer = 0x08c48348;

  g.set_code((unsigned char*)&buffer, sizeof(buffer), 0);

  gdsl::instruction insn = g.decode();

  printf("Instruction: %s\n", insn.to_string().c_str());
  printf("---------------------------------\n");

  gdsl::assembly::instruction ginsn = insn.generic_assembly();
  printf("Generic ASM: ");
  cout << ginsn << endl;
  operand_visitor ov(true);
  ov._([&](register_ const* r) {
    cout << "We have a register operand!" << endl;
  });
  ov._([&](bounded const* b) { cout << "We have a bounded operand!" << endl; });
  for (auto const& opnd : ginsn.get_operands()) opnd.accept(ov);

  printf("---------------------------------\n");

  gdsl::rreil::statements_t rreil = insn.translate();

  g.reset_heap();

  printf("RReil:\n");
  for (auto const& s : rreil) printf("%s\n", s->to_string().c_str());

  printf("\n---------------------------------\n");
  printf("Sizes of assignments:\n");
  for (auto const& s : rreil) {
    example_visitor v;
    s->accept(v);
  }
  printf("Sizes of assignments and loads:\n");
  for (auto const& s : rreil) {
    bool ip = false;
    int_t ip_offset;

    statement_visitor v;
    v._([&](assign const* a) {
      visitor* ev = new visitor();
      ((linear_visitor*)ev)->_([&](lin_binop const* a) {
        if (a->get_op() == gdsl::rreil::BIN_LIN_ADD) {
          linear_visitor lv;
          lv._([&](lin_var const* v) {
            if (v->get_var().get_id().to_string() == "IP") {
              ip = true;
            }
          });
          a->get_lhs().accept(lv);
          lv._([&](lin_imm const* i) { ip_offset = i->get_imm(); });
          a->get_rhs().accept(lv);
        }
      });
      a->accept(*ev);
      printf("Size of assignment: %lld\n", a->get_size());

      delete ev;
    });

    v._([&](load const* l) { printf("Size of load: %lld\n", l->get_size()); });
    s->accept(v);

    if (ip) {
      printf("IP added offset: %llu\n", ip_offset);
    }
  }
  printf("Counting variables...\n");
  size_t vars = 0;
  for (auto const& s : rreil) {
    visitor* v = new visitor();
    ((statement_visitor*)v)->_([&](assign const* a) {
      printf("Assignment\n");
    });

    v->_((std::function<void(variable const*)>)([&](variable const* a) {
      std::cout << (*a == *a ? "The variable equals itself" : ":-(")
                << std::endl;
      vars++;
      printf("Variable!\n");
    }));
    s->accept(*v);
    delete v;
  }
  printf("Number of variables: %zu\n", vars);
}

void demo_block(gdsl::gdsl& g) {
  uint8_t buffer[] = {0x00, 0x00, 0x00, 0x00, 0xc3};
  g.set_code(buffer, sizeof(buffer), 0);

  block b =
      g.decode_translate_block(gdsl::optimization_configuration::BLOCK |
                                   gdsl::optimization_configuration::LIVENESS,
                               LONG_MAX);

  std::vector<gdsl::instruction> const& insns = b.get_instructions();

  g.reset_heap();

  printf("---------------------------------\n");

  auto rreil = b.retrieve_statements();

  printf("RReil:\n");
  for (auto const& s : rreil)
    // printf("%s\n", s->to_string().c_str());
    std::cout << *s << std::endl;

  std::cout << "<<<< RReil output complete" << std::endl;
}

int main(void) {
  try {
    // gdsl::bare_frontend f("x86");
    gdsl::bare_frontend f("x86-rreil");
    gdsl::gdsl g(&f);

    demo_single(g);

    demo_block(g);
  } catch (std::string& s) {
    printf("Exception: %s\n", s.c_str());
  }

  auto _id = make_id("S0");
  cout << *_id << endl;
}
