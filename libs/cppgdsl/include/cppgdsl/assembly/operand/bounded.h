/*
 * The file contains all definitions for a bounded operand ASM
 * AST node. A bounded operand has a size and, possibly, an offset.
 */

#pragma once
#include <string>

#include "cppgdsl/assembly/boundary/boundary.h"
#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

class bounded final : public operand {
 private:
  std::unique_ptr<boundary> boundary_;
  std::unique_ptr<operand> operand_;

  void put(std::ostream& out) const override;

 public:
  bounded(std::unique_ptr<boundary> boundary_arg,
          std::unique_ptr<operand> operand_arg)
      : boundary_(std::move(boundary_arg)), operand_(std::move(operand_arg)) {}

  boundary const& get_boundary() const { return *boundary_; }

  operand const& get_operand() const { return *operand_; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_bounded(
    std::unique_ptr<boundary> _boundary, std::unique_ptr<operand> operand_arg) {
  return std::unique_ptr<operand>(
      new bounded(std::move(_boundary), std::move(operand_arg)));
}

std::unique_ptr<operand> make_bounded(std::unique_ptr<operand> operand_arg,
                                      int_t size, int_t offset = 0);

}  // namespace assembly
}  // namespace gdsl
