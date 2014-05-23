/*
 * gdsl.h
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/frontend/frontend.h>
#include <cppgdsl/rreil/statement/statement.h>
#include "preservation.h"
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
  state_t gdsl_state;
  _frontend *frontend;

  std::vector<rreil::statement*> *convert(obj_t rreil);
public:
  gdsl(_frontend *frontend);
  ~gdsl();

  /*
   * generic
   */
  int_t get_ip_offset();
  void set_code(char *buffer, uint64_t size, uint64_t base);

  /*
   * decoder
   */
  instruction decode();
  std::string pretty_instruction(obj_t insn);
  int_t insn_length(obj_t insn);

  /*
   * translator
   */
  std::vector<rreil::statement*> *translate(obj_t insn);
  block decode_translate_block(preservation pres, int_t limit);

  state_t get_state() const {
    return gdsl_state;
  }

  _frontend const *get_frontend() const {
    return frontend;
  }
};

}
