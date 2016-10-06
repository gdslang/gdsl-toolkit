/*
 * The file contains all definitions for a sum operand ASM
 * AST node. A sum operand has the form (lhs + rhs), where
 * lhs and rhs are operands.
 */

#pragma once

#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

class sum final : public operand {
 private:
  std::unique_ptr<operand> lhs;
  std::unique_ptr<operand> rhs;

  void put(std::ostream& out) const override;

 public:
  sum(std::unique_ptr<operand> lhs, std::unique_ptr<operand> rhs)
      : lhs(std::move(lhs)), rhs(std::move(rhs)) {}

  operand const& get_lhs() const { return *lhs; }

  operand const& get_rhs() const { return *rhs; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_sum(std::unique_ptr<operand> lhs,
                                         std::unique_ptr<operand> rhs) {
  return std::unique_ptr<operand>(new sum(std::move(lhs), std::move(rhs)));
}

}  // namespace assembly
}  // namespace gdsl
