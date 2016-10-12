/*
 * The file contains all definitions for a binary expression RReil AST node.
 */

#pragma once

#include "cppgdsl/rreil/expr/binop_op.h"
#include "cppgdsl/rreil/expr/expr.h"
#include "cppgdsl/rreil/linear/linear.h"

namespace gdsl {
namespace rreil {

class expr_binop final : public expr {
 private:
  binop_op op;
  std::unique_ptr<linear> lhs;
  std::unique_ptr<linear> rhs;

  void put(std::ostream& out) const override;

 public:
  expr_binop(binop_op op, std::unique_ptr<linear> lhs,
             std::unique_ptr<linear> rhs);
  expr_binop(expr_binop const& e)
      : expr(e), op(e.op), lhs(e.lhs->copy()), rhs(e.rhs->copy()) {}
  expr_binop& operator=(expr_binop const&);

  binop_op get_op() const { return op; }

  linear const& get_lhs() const { return *lhs; }

  linear const& get_rhs() const { return *rhs; }

  std::unique_ptr<expr> copy() const override;
  void accept(expr_visitor& v) const override;
  bool operator==(expr const& o) const override;
};

inline std::unique_ptr<expr> make_expr(binop_op op, std::unique_ptr<linear> lhs,
                                       std::unique_ptr<linear> rhs) {
  return std::unique_ptr<expr>(
      new expr_binop(op, std::move(lhs), std::move(rhs)));
}

}  // namespace rreil
}  // namespace gdsl
