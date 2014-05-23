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

int_t gdsl::block::length() {
  throw "Unimplemented";
}
