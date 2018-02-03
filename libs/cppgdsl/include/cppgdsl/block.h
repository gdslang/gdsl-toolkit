/*
 * The file contains a container definition for a block
 * translation result. A block contains a list of internally
 * represented instruction objects and the corresponding RReil
 * statements.
 */

#pragma once
#include <memory>
#include <vector>

#include "cppgdsl/instruction.h"
#include "cppgdsl/rreil/statement/statement.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {

class block {
 private:
  std::vector<instruction> instructions;
  rreil::statements_t statements;

 public:
  block(std::vector<instruction> instructions, rreil::statements_t statements);

  block(const block&) = delete;
  block(block&&) = default;
  block& operator= (const block&) = delete;
  block& operator= (block&&) = default;

  std::vector<instruction> const& get_instructions() const {
    return instructions;
  }

  rreil::statements_t retrieve_statements() {
    return std::move(statements);
  }
};

}  // namespace gdsl
