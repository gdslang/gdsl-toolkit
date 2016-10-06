/*
 * The file contains all definitions to wrap a linear expression
 * RReil AST node in a simple expression.
 */

#pragma once

#include "cppgdsl/rreil/linear/linear.h"
#include "cppgdsl/rreil/sexpr/sexpr.h"

namespace gdsl {
namespace rreil {

class sexpr_lin final : public sexpr {
 private:
  std::unique_ptr<linear> inner;

  void put(std::ostream& out) const override;

 public:
  sexpr_lin(std::unique_ptr<linear> inner);
  sexpr_lin(sexpr_lin const& s) : sexpr(s), inner(s.inner->copy()) {}
  sexpr_lin& operator=(sexpr_lin const&) = delete;

  linear const& get_lin() const { return *inner; }

  std::unique_ptr<sexpr> copy() const override;
  void accept(sexpr_visitor& v) const override;
  bool operator==(sexpr const& o) const override;
};

inline std::unique_ptr<sexpr> make_sexpr(std::unique_ptr<linear> inner) {
  return std::unique_ptr<sexpr>(new sexpr_lin(std::move(inner)));
}

std::unique_ptr<sexpr> make_sexpr(int_t const_arg);

std::unique_ptr<sexpr> make_sexpr(std::unique_ptr<rreil::id> id_arg,
                                  int_t offset = 0);

}  // namespace rreil
}  // namespace gdsl
