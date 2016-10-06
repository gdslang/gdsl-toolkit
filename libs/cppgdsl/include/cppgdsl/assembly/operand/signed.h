/*
 * The file contains all definitions for a signed operand ASM
 * AST node. A signed operand is an operand with a hint on whether
 * the operand is meant to be interpreted as signed or unsigned.
 */

#pragma once
#include <string>

#include "cppgdsl/assembly/operand/operand.h"
#include "cppgdsl/assembly/signedness.h"

namespace gdsl {
namespace assembly {

class signed_ final : public operand {
 private:
  signedness signedness_;
  std::unique_ptr<operand> operand_;

  void put(std::ostream& out) const override;

 public:
  signed_(signedness signedness_arg, std::unique_ptr<operand> operand_arg)
      : signedness_(signedness_arg), operand_(std::move(operand_arg)) {}

  signedness const& get_signedness() const { return signedness_; }
  operand const& get_operand() const { return *operand_; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_signed(
    std::unique_ptr<operand> operand_arg) {
  return std::unique_ptr<operand>(
      new signed_(signedness::SIGNED, std::move(operand_arg)));
}

inline std::unique_ptr<operand> make_unsigned(
    std::unique_ptr<operand> operand_arg) {
  return std::unique_ptr<operand>(
      new signed_(signedness::UNSIGNED, std::move(operand_arg)));
}

}  // namespace assembly
}  // namespace gdsl
