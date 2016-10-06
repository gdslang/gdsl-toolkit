/*
 * The file contains all definitions for an immediate operand ASM
 * AST node. An immediate operand is an integer.
 */

#pragma once

#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

class immediate final : public operand {
 private:
  int_t imm;

  void put(std::ostream& out) const override;

 public:
  immediate(int_t imm) : imm(imm) {}

  int_t get_imm() const { return imm; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_immediate(int_t const_arg) {
  return std::unique_ptr<operand>(new immediate(const_arg));
}

}  // namespace assembly
}  // namespace gdsl
