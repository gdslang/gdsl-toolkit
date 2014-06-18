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

gdsl::block::~block() {
  delete instructions;
}

int_t gdsl::block::length() {
  int_t r = 0;
  for (size_t i = 0; i < instructions->size(); ++i)
    r += instructions->at(i).length();
  return r;
}
