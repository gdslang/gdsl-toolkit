/*
 * The file contains all definitions for an operand annotation ASM
 * AST node. An operand annotation allows to annotate objects using a
 * named operand list.
 */

#pragma once

#include <string>

#include "cppgdsl/assembly/annotation/annotation.h"
#include "cppgdsl/assembly/operand/operand.h"
#include "cppgdsl/iterator.h"

namespace gdsl {
namespace assembly {

class operand_annotation final : public annotation {
 private:
  std::string name;
  operands_t operands;

  void put(std::ostream& out) const override;

 public:
  operand_annotation(std::string name, operands_t operands)
      : name(std::move(name)), operands(std::move(operands)) {}

  std::string const& get_name() const { return name; }

  iterable<operand> get_operands() const { return iterable<operand>(operands); }

  void accept(annotation_visitor& av) const override { av.visit(this); }
  bool operator==(annotation const& o) const override;
};

inline std::unique_ptr<annotation> make_operand_annotation(
    std::string name, operands_t operands) {
  return std::unique_ptr<annotation>(
      new operand_annotation(std::move(name), std::move(operands)));
}

}  // namespace assembly
}  // namespace gdsl
