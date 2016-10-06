/*
 * The file contains all definitions for an instruction generic assembly (ASM)
 * AST node.
 */

#pragma once
#include <string>

#include "cppgdsl/assembly/annotation/annotation.h"
#include "cppgdsl/assembly/operand/operand.h"
#include "cppgdsl/iterator.h"

namespace gdsl {
namespace assembly {

class instruction {
 private:
  int_t length;
  std::string mnemonic;
  annotations_t annotations;
  operands_t operands;

 public:
  instruction(int_t length, std::string mnemonic, annotations_t annotations,
              operands_t operands)
      : length(length),
        mnemonic(std::move(mnemonic)),
        annotations(std::move(annotations)),
        operands(std::move(operands)) {}
  instruction(instruction const&) = delete;
  instruction& operator=(instruction const&) = delete;

  instruction(instruction&&) = default;
  instruction& operator=(instruction&&) = default;

  int_t get_length() const { return length; }

  std::string get_mnemonic() const { return mnemonic; }

  iterable<annotation> get_annotations() const {
    return iterable<annotation>(annotations);
  }

  iterable<operand> get_operands() const { return iterable<operand>(operands); }

  /*
   * This operator recursively compares for syntactic equality.
   */
  bool operator==(instruction const& o) const;
  bool operator!=(instruction const& o) const { return !(*this == o); }
};

std::ostream& operator<<(std::ostream& out, instruction const& _this);

using instructions_t = std::vector<instruction>;

inline instruction make_instruction(int_t length, std::string mnemonic,
                                    annotations_t annotations,
                                    operands_t operands) {
  return instruction(length, std::move(mnemonic), std::move(annotations),
                     std::move(operands));
}

}  // namespace assembly
}  // namespace gdsl
