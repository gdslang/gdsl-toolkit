/*
 * gdsl.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/gdsl.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <cppgdsl/rreil_builder.h>
#include <vector>

extern "C" {
#include <gdsl_generic.h>
}

gdsl::gdsl::gdsl(_frontend *frontend) {
  this->gdsl_state = frontend->native().generic.init();
}

int_t gdsl::gdsl::get_ip_offset() {
  return frontend->native().generic.get_ip_offset(gdsl_state);
}

obj_t gdsl::gdsl::decode() {
  return frontend->native().decoder.decode(gdsl_state,
      frontend->native().decoder.config_default(gdsl_state));
}

obj_t gdsl::gdsl::translate(obj_t insn) {
  return frontend->native().translator.translate(gdsl_state, insn);
}

obj_t gdsl::gdsl::decode_translate_block() {
  return frontend->native().translator.decode_translate_block_optimized_int_insncb(gdsl_state,
      frontend->native().decoder.config_default(gdsl_state), 4 * 1024 * 1024 * 1024, 0, NULL, NULL);
}

std::vector<gdsl::rreil::statement*> *gdsl::gdsl::convert(obj_t rreil) {
  rreil_builder builder(gdsl_state, frontend);
  return builder.convert(rreil);
}
