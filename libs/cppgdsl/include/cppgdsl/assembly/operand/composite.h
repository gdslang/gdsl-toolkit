/*
 * The file contains all definitions for a composite operand ASM
 * AST node. A composite operand is an operand consisting of a list
 * of operands.
 */

#pragma once
#include <string>

#include "cppgdsl/assembly/operand/operand.h"
#include "cppgdsl/iterator.h"

namespace gdsl {
namespace assembly {

class composite final : public operand {
 private:
  operands_t operands;

  void put(std::ostream& out) const override;

 public:
  composite(operands_t operands) : operands(std::move(operands)) {}

  iterable<operand> get_operands() const { return iterable<operand>(operands); }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_composite(operands_t operands) {
  return std::unique_ptr<operand>(new composite(std::move(operands)));
}

}  // namespace assembly
}  // namespace gdsl
