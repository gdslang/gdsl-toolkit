/*
 * The file contains all definitions for an RReil AST node that is
 * a linear expression of the form a * EXPR where a is an immediate.
 */

#pragma once
#include <memory>

#include "cppgdsl/rreil/linear/linear.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class lin_scale final : public linear {
 private:
  int_t const_;
  std::unique_ptr<linear> operand_;

  void put(std::ostream& out) const override;

 public:
  lin_scale(int_t const_arg, std::unique_ptr<linear> operand_arg);
  lin_scale(lin_scale const& ls)
      : linear(ls), const_(ls.const_), operand_(ls.operand_->copy()) {}
  lin_scale& operator=(lin_scale const&) = delete;

  int_t get_const() const { return const_; }

  linear const& get_operand() const { return *operand_; }

  std::unique_ptr<linear> copy() const override;
  void accept(linear_visitor& v) const override;
  bool operator==(linear const& o) const override;
};

inline std::unique_ptr<linear> make_linear(
    int_t const_arg, std::unique_ptr<linear> operand_arg) {
  return std::unique_ptr<linear>(
      new lin_scale(const_arg, std::move(operand_arg)));
}

}  // namespace rreil
}  // namespace gdsl
