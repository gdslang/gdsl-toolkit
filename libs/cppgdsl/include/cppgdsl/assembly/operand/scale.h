/*
 * The file contains all definitions for a scaled operand ASM
 * AST node. A scaled operand has the form f*o, where a f is
 * an integer factor and o is an operand.
 */

#pragma once

#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

class scale final : public operand {
 private:
  int_t factor;
  std::unique_ptr<operand> operand_;

  void put(std::ostream& out) const override;

 public:
  scale(int_t factor, std::unique_ptr<operand> operand_arg)
      : factor(factor), operand_(std::move(operand_arg)) {}

  int_t get_factor() const { return factor; }

  operand const& get_operand() const { return *operand_; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_scale(
    int_t factor, std::unique_ptr<operand> operand_arg) {
  return std::unique_ptr<operand>(new scale(factor, std::move(operand_arg)));
}

}  // namespace assembly
}  // namespace gdsl
