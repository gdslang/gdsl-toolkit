/*
 * instruction.cpp
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/instruction.h>
#include <iostream>
#include <sstream>

using namespace std;

gdsl::instruction::instruction(gdsl *g, obj_t native) {
  this->g = g;
  this->native = native;
}

gdsl::instruction::~instruction() {
}

std::string gdsl::instruction::to_string() {
  stringstream s;
  s << *this;
  return s.str();
}

std::vector<gdsl::rreil::statement*>* gdsl::instruction::translate() {
  return g->translate(native);
}

ostream &gdsl::operator <<(ostream& out, instruction& _this) {
  out << _this.g->pretty_instruction(_this.native);
  return out;
}
