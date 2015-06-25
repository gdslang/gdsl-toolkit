/*
 * block.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <cppgdsl/instruction.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <vector>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {

class block {
private:
  std::vector<instruction> *instructions;
  std::vector<rreil::statement*> *statements;

public:
  block(block const &o) = delete;
  block(block &&o);
  block(std::vector<instruction> *instructions, std::vector<rreil::statement*> *statements);
  ~block();

  block operator=(block const &o) = delete;

  std::vector<instruction> const *get_instructions() const {
    return instructions;
  }

  std::vector<rreil::statement*> *get_statements() const {
    return statements;
  }
};

}
