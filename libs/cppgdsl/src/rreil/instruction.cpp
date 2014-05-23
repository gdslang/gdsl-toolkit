/*
 * instruction.cpp
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/instruction.h>

gdsl::instruction::instruction(gdsl::gdsl *g, obj_t native) {
  this->g = g;
  this->native = native;
}

gdsl::instruction::~instruction() {
}

std::string gdsl::instruction::to_string() {
  return g->pretty_instruction(native);
}

int_t gdsl::instruction::length() {
  return g->insn_length(native);
}

std::vector<gdsl::rreil::statement*>* gdsl::instruction::translate() {
  return g->translate(native);
}

ostream& gdsl::operator <<(ostream& out, instruction& _this) {
  out << _this.to_string();
  return out;
}
