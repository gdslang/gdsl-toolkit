/*
 * The file contains all definitions to wrap a comparison expression
 * RReil AST node in a simple expression.
 */

#pragma once
#include <memory>

#include "cppgdsl/rreil/expr_cmp/expr_cmp.h"
#include "cppgdsl/rreil/sexpr/sexpr.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class sexpr_cmp final : public sexpr {
 private:
  int_t size;
  std::unique_ptr<expr_cmp> inner;

  void put(std::ostream& out) const override;

 public:
  sexpr_cmp(int_t size, std::unique_ptr<expr_cmp> inner);
  sexpr_cmp(sexpr_cmp const& s)
      : sexpr(s), size(s.size), inner(s.inner->copy()) {}
  sexpr_cmp& operator=(sexpr_cmp const&) = delete;

  int_t get_size() const { return size; }

  expr_cmp const& get_inner() const { return *inner; }

  std::unique_ptr<sexpr> copy() const override;
  void accept(sexpr_visitor& v) const override;
  bool operator==(sexpr const& o) const override;
};

inline std::unique_ptr<sexpr> make_sexpr(int_t size,
                                         std::unique_ptr<expr_cmp> inner) {
  return std::unique_ptr<sexpr>(new sexpr_cmp(size, std::move(inner)));
}

}  // namespace rreil
}  // namespace gdsl
