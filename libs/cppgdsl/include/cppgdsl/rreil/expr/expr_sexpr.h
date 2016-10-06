/*
 * The file contains all definitions to wrap a simple expression
 * RReil AST node in an expression. See sexpr/sexpr.h for details
 * about simple expressions.
 */

#pragma once
#include "cppgdsl/rreil/expr/expr.h"
#include "cppgdsl/rreil/sexpr/sexpr.h"

namespace gdsl {
namespace rreil {

class expr_sexpr final : public expr {
 private:
  std::unique_ptr<sexpr> inner;

  void put(std::ostream& out) const override;

 public:
  expr_sexpr(std::unique_ptr<sexpr> inner);
  expr_sexpr(expr_sexpr const& e) : expr(e), inner(e.inner->copy()) {}
  expr_sexpr& operator=(expr_sexpr const&) = default;

  sexpr const& get_inner() const { return *inner; }

  std::unique_ptr<expr> copy() const override;
  void accept(expr_visitor& v) const override;
  bool operator==(expr const& o) const override;
};

inline std::unique_ptr<expr> make_expr(std::unique_ptr<sexpr> inner) {
  return std::unique_ptr<expr>(new expr_sexpr(std::move(inner)));
}

std::unique_ptr<rreil::expr> make_expr(std::unique_ptr<rreil::linear> inner);

std::unique_ptr<rreil::expr> make_expr(int_t const_arg);

std::unique_ptr<rreil::expr> make_expr(std::unique_ptr<rreil::id> id_arg,
                                       int_t offset = 0);

}  // namespace rreil
}  // namespace gdsl
