/*
 * The file contains all definitions for an RReil AST node that is
 * a binary linear expression.
 */

#pragma once
#include <memory>

#include "cppgdsl/rreil/linear/binop_lin_op.h"
#include "cppgdsl/rreil/linear/linear.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class lin_binop final : public linear {
 private:
  binop_lin_op op;
  std::unique_ptr<linear> lhs;
  std::unique_ptr<linear> rhs;

  void put(std::ostream& out) const override;

 public:
  lin_binop(binop_lin_op op, std::unique_ptr<linear> lhs,
            std::unique_ptr<linear> rhs);
  ~lin_binop();
  lin_binop(lin_binop const& o)
      : linear(o), op(o.op), lhs(o.lhs->copy()), rhs(o.rhs->copy()) {}
  lin_binop& operator=(lin_binop const& l) = delete;

  binop_lin_op get_op() const { return op; }

  linear const& get_lhs() const { return *lhs; }

  linear const& get_rhs() const { return *rhs; }

  std::unique_ptr<linear> copy() const override;
  void accept(linear_visitor& v) const override;
  bool operator==(linear const& o) const override;
};

class variable;
std::unique_ptr<linear> make_linear(std::unique_ptr<variable> linear_arg);
std::unique_ptr<linear> make_linear(int_t linear_arg);

template <typename T, typename U>
inline std::unique_ptr<linear> make_linear(binop_lin_op op, T lhs, U rhs) {
  return std::unique_ptr<linear>(new lin_binop(op, make_linear(std::move(lhs)),
                                               make_linear(std::move(rhs))));
}

}  // namespace rreil
}  // namespace gdsl
