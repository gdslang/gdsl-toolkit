#include "cppgdsl/gdsl.h"

#include <string>
#include <vector>

#include "cppgdsl/asm_builder.h"
#include "cppgdsl/block.h"
#include "cppgdsl/gdsl_exception.h"
#include "cppgdsl/instruction.h"
#include "cppgdsl/optimization.h"
#include "cppgdsl/rreil/statement/statement.h"
#include "cppgdsl/rreil_builder.h"

using gdsl::block;
using gdsl::instruction;
using namespace std;

namespace gdsl {

extern "C" {
#include "gdsl_generic.h"
#include "setjmp.h"
}

rreil::statements_t gdsl::convert(obj_t rreil) {
  rreil_builder builder(this);
  return builder.convert(rreil);
}

gdsl::gdsl(_frontend* frontend) {
  this->frontend = frontend;

  this->gdsl_state = frontend->native().generic.init();

  this->size = 0;
  this->base = 0;
}

size_t gdsl::bytes_left() {
  return size - (get_ip() - base);
}

gdsl::~gdsl() {
  if(!frontend)
    return;
  if (setjmp(*frontend->native().generic.err_tgt(gdsl_state)))
    throw gdsl_exception(
        "destructor failed",
        std::string(frontend->native().generic.get_error_message(gdsl_state)));

  if (gdsl_state)
    frontend->native().generic.destroy(gdsl_state);
}

uint64_t gdsl::get_ip() {
  if (setjmp(*frontend->native().generic.err_tgt(gdsl_state)))
    throw gdsl_exception(
        "get_ip() failed",
        std::string(frontend->native().generic.get_error_message(gdsl_state)));

  return frontend->native().generic.get_ip(gdsl_state);
}

void gdsl::set_code(const unsigned char* buffer, size_t size, uint64_t base) {
  if (setjmp(*frontend->native().generic.err_tgt(gdsl_state)))
    throw gdsl_exception(
        "set_code() failed",
        std::string(frontend->native().generic.get_error_message(gdsl_state)));
  frontend->native().generic.set_code(gdsl_state, buffer, size, base);
  this->size = size;
  this->base = base;
}

bool gdsl::seek(uint64_t ip) {
  if (setjmp(*frontend->native().generic.err_tgt(gdsl_state)))
    throw gdsl_exception(
        "seek() failed",
        std::string(frontend->native().generic.get_error_message(gdsl_state)));

  return frontend->native().generic.seek(gdsl_state, ip);
}

void gdsl::reset_heap() {
  frontend->native().generic.reset_heap(gdsl_state);
}

instruction gdsl::decode() {
  if (setjmp(*frontend->native().generic.err_tgt(gdsl_state)))
    throw gdsl_exception(
        "decode() failed",
        std::string(frontend->native().generic.get_error_message(gdsl_state)));

  obj_t native = frontend->native().decoder.decode(
      gdsl_state, frontend->native().decoder.config_default(gdsl_state));
  return instruction(this, native);
}

std::string gdsl::pretty_instruction(obj_t insn) {
  if (setjmp(*frontend->native().generic.err_tgt(gdsl_state)))
    throw gdsl_exception(
        "pretty_instruction() failed",
        std::string(frontend->native().generic.get_error_message(gdsl_state)));

  obj_t rope = frontend->native().decoder.pretty(gdsl_state, insn);
  return std::string(frontend->native().generic.merge_rope(gdsl_state, rope));
}

assembly::instruction gdsl::generic_assembly(obj_t insn) {
  if (setjmp(*frontend->native().generic.err_tgt(gdsl_state)))
    throw gdsl_exception(
        "generic_assembly() failed",
        std::string(frontend->native().generic.get_error_message(gdsl_state)));
  asm_builder builder(this);

  auto ginsn = (asm_insn_t) frontend->native().decoder.generalize(gdsl_state,
                                                                  insn);
  return builder.convert(ginsn);
}

rreil::statements_t gdsl::translate(obj_t insn) {
  if (setjmp(*frontend->native().generic.err_tgt(gdsl_state)))
    throw gdsl_exception(
        "translate() failed",
        std::string(frontend->native().generic.get_error_message(gdsl_state)));

  obj_t rreil = frontend->native().translator.translate(gdsl_state, insn);
  return convert(rreil);
}

struct gdsl_insns {
  gdsl* _this;
  std::vector<instruction> instructions;
};

static obj_t insn_cb(state_t s, obj_t cls, obj_t next) {
  gdsl_insns* cls_typed = (gdsl_insns*) cls;
  cls_typed->instructions.push_back(instruction(cls_typed->_this, next));
  return cls;
}

block gdsl::decode_translate_block(optimization_configuration oc, int_t limit) {
  if (setjmp(*frontend->native().generic.err_tgt(gdsl_state)))
    throw gdsl_exception(
        "decode_translate_block() failed",
        std::string(frontend->native().generic.get_error_message(gdsl_state)));

  gdsl_insns cls = {this, std::vector<instruction>()};

  opt_result_t opt_result = frontend->native().translator
      .decode_translate_block_optimized(
      gdsl_state, frontend->native().decoder.config_default(gdsl_state), limit,
      oc);
  frontend->native().translator.traverse_insn_list(gdsl_state,
                                                   opt_result->insns, &cls,
                                                   &insn_cb);
  auto statements = convert(opt_result->rreil);
  return block(move(cls.instructions), move(statements));
}

}  // namespace gdsl
