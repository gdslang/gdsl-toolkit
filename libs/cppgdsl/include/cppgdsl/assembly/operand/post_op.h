/*
 * The file contains all definitions for a post-operation operand ASM
 * AST node. This operand allows for specifying an expression to update
 * the operand after it's being read, i.e. to implement the following:
 *
 * x = opnd;  // read operand
 * opnd = expr(opnd);  // update operand using expr *after* reading
 * return x;  // continue instruction execution using value read
 */

#pragma once

#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

class post_op final : public operand {
 private:
  std::unique_ptr<operand> expr;
  std::unique_ptr<operand> operand_;

  void put(std::ostream& out) const override;

 public:
  post_op(std::unique_ptr<operand> expr, std::unique_ptr<operand> operand_arg)
      : operand_(std::move(operand_arg)) {}

  operand const& get_expr() const { return *expr; }

  operand const& get_operand() const { return *operand_; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_post_op(
    std::unique_ptr<operand> expr, std::unique_ptr<operand> operand_arg) {
  return std::unique_ptr<operand>(
      new post_op(std::move(expr), std::move(operand_arg)));
}

}  // namespace assembly
}  // namespace gdsl
