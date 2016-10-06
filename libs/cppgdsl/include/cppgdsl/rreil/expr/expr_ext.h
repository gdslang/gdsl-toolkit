/*
 * The file contains all definitions for an extension expression RReil AST
 * node. An extension is used to change the bit size of integers by either
 * prepending zeros (in case of zero extension) or the sign bit (in case of
 * a sign extension).
 */

#pragma once
#include <string>

#include "cppgdsl/rreil/expr/expr.h"
#include "cppgdsl/rreil/linear/linear.h"
#include "gdsl_generic.h"

namespace gdsl {
namespace rreil {

enum ext_op { EXT_SX, EXT_ZX };

std::string ext_op_to_string(ext_op op);

class expr_ext final : public expr {
 private:
  ext_op op;
  int_t fromsize;
  std::unique_ptr<linear> operand_;

  void put(std::ostream& out) const;

 public:
  expr_ext(ext_op op, int_t fromsize, std::unique_ptr<linear> operand_arg);
  expr_ext(expr_ext const& e)
      : expr(e), op(e.op), fromsize(e.fromsize), operand_(e.operand_->copy()) {}
  expr_ext& operator=(expr_ext const&) = default;

  int_t get_fromsize() const { return fromsize; }

  ext_op get_op() const { return op; }

  linear const& get_operand() const { return *operand_; }

  std::unique_ptr<expr> copy() const override;
  void accept(expr_visitor& v) const override;
  bool operator==(expr const& o) const override;
};

inline std::unique_ptr<expr> make_expr(ext_op op, int_t fromsize,
                                       std::unique_ptr<linear> opnd) {
  return std::unique_ptr<expr>(new expr_ext(op, fromsize, std::move(opnd)));
}

inline std::unique_ptr<expr> make_expr_zx(int_t fromsize,
                                          std::unique_ptr<linear> opnd) {
  return std::unique_ptr<expr>(new expr_ext(EXT_ZX, fromsize, std::move(opnd)));
}

inline std::unique_ptr<expr> make_expr_sx(int_t fromsize,
                                          std::unique_ptr<linear> opnd) {
  return std::unique_ptr<expr>(new expr_ext(EXT_SX, fromsize, std::move(opnd)));
}

}  // namespace rreil
}  // namespace gdsl
