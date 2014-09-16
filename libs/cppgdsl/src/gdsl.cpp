/*
 * gdsl.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/block.h>
#include <cppgdsl/gdsl.h>
#include <cppgdsl/gdsl_exception.h>
#include <cppgdsl/instruction.h>
#include <cppgdsl/preservation.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <cppgdsl/rreil_builder.h>
#include <vector>
#include <string>

using gdsl::block;
using gdsl::instruction;
using namespace std;

extern "C" {
#include <gdsl_generic.h>
#include <setjmp.h>
}

std::vector<gdsl::rreil::statement*> *gdsl::gdsl::convert(obj_t rreil) {
  rreil_builder builder(this);
  return builder.convert(rreil);
}

gdsl::gdsl::gdsl(_frontend *frontend) {
  this->frontend = frontend;
  this->gdsl_state = frontend->native().generic.init();
}

gdsl::gdsl::~gdsl() {
  if(setjmp(*frontend->native().generic.err_tgt(gdsl_state))) throw gdsl_exception("destructor failed",
      string(frontend->native().generic.get_error_message(gdsl_state)));

  if(gdsl_state) frontend->native().generic.destroy(gdsl_state);
}

int_t gdsl::gdsl::get_ip() {
  if(setjmp(*frontend->native().generic.err_tgt(gdsl_state))) throw gdsl_exception("get_ip() failed",
      string(frontend->native().generic.get_error_message(gdsl_state)));

  return frontend->native().generic.get_ip(gdsl_state);
}

void gdsl::gdsl::set_code(unsigned char *buffer, uint64_t size, uint64_t base) {
  if(setjmp(*frontend->native().generic.err_tgt(gdsl_state))) throw gdsl_exception("set_code() failed",
      string(frontend->native().generic.get_error_message(gdsl_state)));
  frontend->native().generic.set_code(gdsl_state, buffer, size, base);
}

bool gdsl::gdsl::seek(int_t ip) {
  if(setjmp(*frontend->native().generic.err_tgt(gdsl_state))) throw gdsl_exception("seek() failed",
      string(frontend->native().generic.get_error_message(gdsl_state)));

  return frontend->native().generic.seek(gdsl_state, ip);
}

void gdsl::gdsl::reset_heap() {
  frontend->native().generic.reset_heap(gdsl_state);
}

instruction gdsl::gdsl::decode() {
  if(setjmp(*frontend->native().generic.err_tgt(gdsl_state))) throw gdsl_exception("decode() failed",
      string(frontend->native().generic.get_error_message(gdsl_state)));

  obj_t native = frontend->native().decoder.decode(gdsl_state, frontend->native().decoder.config_default(gdsl_state));
  return instruction(this, native);
}

std::string gdsl::gdsl::pretty_instruction(obj_t insn) {
  if(setjmp(*frontend->native().generic.err_tgt(gdsl_state))) throw gdsl_exception("pretty_instruction() failed",
      string(frontend->native().generic.get_error_message(gdsl_state)));

  obj_t rope = frontend->native().decoder.pretty(gdsl_state, insn);
  return std::string(frontend->native().generic.merge_rope(gdsl_state, rope));
}

std::vector<gdsl::rreil::statement*> *gdsl::gdsl::translate(obj_t insn) {
  if(setjmp(*frontend->native().generic.err_tgt(gdsl_state))) throw gdsl_exception("translate() failed",
      string(frontend->native().generic.get_error_message(gdsl_state)));

  obj_t rreil = frontend->native().translator.translate(gdsl_state, insn);
  return convert(rreil);
}

struct gdsl_insns {
  gdsl::gdsl *_this;
  std::vector<instruction> *instructions;
};

static obj_t insn_cb(state_t s, obj_t cls, obj_t next) {
  gdsl_insns *cls_typed = (gdsl_insns*) cls;
  cls_typed->instructions->push_back(instruction(cls_typed->_this, next));
  return cls;
}

block gdsl::gdsl::decode_translate_block(preservation pres, int_t limit) {
  if(setjmp(*frontend->native().generic.err_tgt(gdsl_state))) throw gdsl_exception("decode_translate_block() failed",
      string(frontend->native().generic.get_error_message(gdsl_state)));

  gdsl_insns cls = { this, new std::vector<instruction>() };

  opt_result_t opt_result = frontend->native().translator.decode_translate_block_optimized(gdsl_state,
      frontend->native().decoder.config_default(gdsl_state), limit, pres);
  frontend->native().translator.traverse_insn_list(gdsl_state, opt_result->insns, &cls, &insn_cb);
  std::vector<rreil::statement*> *statements = convert(opt_result->rreil);
  return block(cls.instructions, statements);
}
