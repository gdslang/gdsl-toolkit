/*
 * block.cpp
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/block.h>

gdsl::block::block(std::vector<instruction> *instructions, std::vector<rreil::statement*> *statements) {
  this->instructions = instructions;
  this->statements = statements;
}

gdsl::block::block(block &&o) : instructions(o.instructions), statements(o.statements) {
  o.instructions = NULL;
}

gdsl::block::~block() {
  delete instructions;
}
