/*
 * gdsl.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/block.h>
#include <cppgdsl/gdsl.h>
#include <cppgdsl/instruction.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <cppgdsl/rreil_builder.h>
#include <vector>

using gdsl::block;
using gdsl::instruction;

extern "C" {
#include <gdsl_generic.h>
}

std::vector<gdsl::rreil::statement*> *gdsl::gdsl::convert(obj_t rreil) {
  rreil_builder builder(this);
  return builder.convert(rreil);
}

gdsl::gdsl::gdsl(_frontend *frontend) {
  this->frontend = frontend;
  this->gdsl_state = frontend->native().generic.init();
}

int_t gdsl::gdsl::get_ip_offset() {
  return frontend->native().generic.get_ip_offset(gdsl_state);
}

void gdsl::gdsl::set_code(char *buffer, uint64_t size, uint64_t base) {
  frontend->native().generic.set_code(gdsl_state, buffer, size, base);
}

instruction gdsl::gdsl::decode() {
  obj_t native = frontend->native().decoder.decode(gdsl_state, frontend->native().decoder.config_default(gdsl_state));
  return instruction(this, native);
}

std::string gdsl::gdsl::pretty_instruction(obj_t insn) {
  obj_t rope = frontend->native().decoder.pretty(gdsl_state, insn);
  return std::string(frontend->native().generic.merge_rope(gdsl_state, rope));
}

std::vector<gdsl::rreil::statement*> *gdsl::gdsl::translate(obj_t insn) {
  obj_t rreil = frontend->native().translator.translate(gdsl_state, insn);
  return convert(rreil);
}

struct gdsl_insns {
  gdsl::gdsl *_this;
  std::vector<instruction> *instructions;
};

static obj_t insn_cb(state_t s, obj_t cls, obj_t next) {
  gdsl_insns *cls_typed = (gdsl_insns*)cls;
  cls_typed->instructions->push_back(instruction(cls_typed->_this, next));
  return cls;
}

block gdsl::gdsl::decode_translate_block() {
  gdsl_insns cls = { this, new std::vector<instruction>() };
  obj_t rreil = frontend->native().translator.decode_translate_block_optimized_int_insncb(gdsl_state,
      frontend->native().decoder.config_default(gdsl_state), 4 * 1024 * 1024, 0, &cls, insn_cb)->rreil;
  std::vector<rreil::statement*> *statements = convert(rreil);
  return block(cls.instructions, statements);
}


