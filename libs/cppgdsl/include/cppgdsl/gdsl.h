/*
 * The file contains the context class that represents an
 * instance of a GDSL program and the corresponding front-end.
 */

#pragma once
#include <memory>
#include <vector>

#include "cppgdsl/assembly/instruction.h"
#include "cppgdsl/frontend/frontend.h"
#include "cppgdsl/optimization.h"
#include "cppgdsl/rreil/statement/statement.h"
extern "C" {
#include "gdsl_multiplex.h"
}

namespace gdsl {

class instruction;
class block;

class gdsl {
 private:
  size_t size;
  uint64_t base;

  state_t gdsl_state = nullptr;
  _frontend* frontend = nullptr;

  rreil::statements_t convert(obj_t rreil);

 public:
  explicit gdsl(_frontend* frontend);
  gdsl(gdsl const&) = delete;
  gdsl(gdsl &&g)
      : size(g.size),
        base(g.base),
        gdsl_state(g.gdsl_state),
        frontend(g.frontend) {
    g.size = 0;
    g.base = 0;
    g.gdsl_state = nullptr;
    g.frontend = nullptr;
  }
  gdsl& operator=(gdsl const&) = delete;
  gdsl& operator=(gdsl &&g) {
    size = g.size;
    base = g.base;
    gdsl_state = g.gdsl_state;
    frontend = g.frontend;
    g.size = 0;
    g.base = 0;
    g.gdsl_state = nullptr;
    g.frontend = nullptr;
    return *this;
  }
  ~gdsl();
  size_t bytes_left();

  /*
   * generic
   */
  uint64_t get_ip();
  void set_code(const unsigned char* buffer, size_t size, uint64_t base);
  bool seek(uint64_t ip);
  void reset_heap();

  /*
   * decoder
   */
  instruction decode();
  std::string pretty_instruction(obj_t insn);
  assembly::instruction generic_assembly(obj_t insn);

  /*
   * translator
   */
  rreil::statements_t translate(obj_t insn);
  block decode_translate_block(optimization_configuration oc, int_t limit);

  state_t get_state() const {
    return gdsl_state;
  }

  _frontend const* get_frontend() const {
    return frontend;
  }
};

}  // namespace gdsl
