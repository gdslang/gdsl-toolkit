/*
 * The file contains all definitions for a relative operand ASM
 * AST node. For a given operand o, the relative operand has the
 * value (o + IP), where IP is the value of instruction pointer
 * register during the execution of the instruction. Whether the
 * register's value denotes the beginning or the end of the decoded
 * instruction is architecture dependent.
 */

#pragma once

#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

class rel final : public operand {
 private:
  std::unique_ptr<operand> operand_;

  void put(std::ostream& out) const override;

 public:
  rel(std::unique_ptr<operand> operand_arg)
      : operand_(std::move(operand_arg)) {}

  operand const& get_operand() const { return *operand_; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_rel(std::unique_ptr<operand> operand_arg) {
  return std::unique_ptr<operand>(new rel(std::move(operand_arg)));
}

}  // namespace assembly
}  // namespace gdsl
