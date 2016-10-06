/*
 * The file contains all definitions for a memory operand ASM
 * AST node. A memory operand is a pointer.
 */

#pragma once

#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

class memory final : public operand {
 private:
  std::unique_ptr<operand> operand_;

  void put(std::ostream& out) const override;

 public:
  memory(std::unique_ptr<operand> operand_arg)
      : operand_(std::move(operand_arg)) {}

  operand const& get_operand() const { return *operand_; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_memory(
    std::unique_ptr<operand> operand_arg) {
  return std::unique_ptr<operand>(new memory(std::move(operand_arg)));
}

}  // namespace assembly
}  // namespace gdsl
