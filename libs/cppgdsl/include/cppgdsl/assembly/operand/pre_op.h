/*
 * The file contains all definitions for a pre-operation operand ASM
 * AST node. This operand allows to specify an expression to update
 * the operand before it's being read, i.e. to implement the following:
 *
 * opnd = expr(opnd);  // update operand using expr *before* reading
 * return opnd;  // continue instruction execution using the updated value
 */

#pragma once

#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

class pre_op final : public operand {
 private:
  std::unique_ptr<operand> expr;
  std::unique_ptr<operand> operand_;

  void put(std::ostream& out) const override;

 public:
  pre_op(std::unique_ptr<operand> expr, std::unique_ptr<operand> operand_arg)
      : operand_(std::move(operand_arg)) {}

  operand const& get_expr() const { return *expr; }

  operand const& get_operand() const { return *operand_; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_pre_op(
    std::unique_ptr<operand> expr, std::unique_ptr<operand> operand_arg) {
  return std::unique_ptr<operand>(
      new pre_op(std::move(expr), std::move(operand_arg)));
}

}  // namespace assembly
}  // namespace gdsl
