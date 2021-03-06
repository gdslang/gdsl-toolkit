/*
 * gdsl.h
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/frontend/frontend.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <cppgdsl/optimization.h>
#include <vector>

namespace gdsl {

class instruction;
class block;

extern "C" {
#include <gdsl_multiplex.h>
#include <gdsl_generic.h>
}

class gdsl {
private:
  uint64_t size;
  uint64_t base;

  state_t gdsl_state = NULL;
  _frontend *frontend = NULL;

  std::vector<rreil::statement*> *convert(obj_t rreil);
public:
  gdsl(_frontend *frontend);
  ~gdsl();
  size_t bytes_left();

  /*
   * generic
   */
  int_t get_ip();
  void set_code(unsigned char *buffer, uint64_t size, uint64_t base);
  bool seek(int_t ip);
  void reset_heap();

  /*
   * decoder
   */
  instruction decode();
  std::string pretty_instruction(obj_t insn);

  /*
   * translator
   */
  std::vector<rreil::statement*> *translate(obj_t insn);
  block decode_translate_block(optimization_configuration oc, int_t limit);

  state_t get_state() const {
    return gdsl_state;
  }

  _frontend const *get_frontend() const {
    return frontend;
  }
};

}
