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
  block(std::vector<instruction> *instructions, std::vector<rreil::statement*> *statements);

  int_t length();

  std::vector<instruction> const *get_instructions() const {
    return instructions;
  }

  std::vector<rreil::statement*> *get_statements() const {
    return statements;
  }
};

}
