/*
 * gdsl.h
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/frontend/frontend.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <vector>

namespace gdsl {

extern "C" {
#include <gdsl_multiplex.h>
#include <gdsl_generic.h>
}

class gdsl {
private:
  state_t gdsl_state;
  _frontend *frontend;

public:
  gdsl(_frontend *frontend);

  /*
   * generic
   */
  int_t get_ip_offset();

  /*
   * decoder
   */
  obj_t decode();

  /*
   * translator
   */
  obj_t translate(obj_t insn);
  obj_t decode_translate_block();
  std::vector<rreil::statement*> *convert(obj_t rreil);
};

}
