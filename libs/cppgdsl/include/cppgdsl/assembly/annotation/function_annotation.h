/*
 * The file contains all definitions for a function annotation ASM
 * AST node. A function annotation can be used to annotate an object
 * with the result of a function or procedure invocation.
 */

#pragma once

#include <string>

#include "cppgdsl/assembly/annotation/annotation.h"
#include "cppgdsl/assembly/operand/operand.h"
#include "cppgdsl/iterator.h"

namespace gdsl {
namespace assembly {

class function_annotation final : public annotation {
 private:
  std::string name;
  operands_t args;

  void put(std::ostream& out) const override;

 public:
  function_annotation(std::string name, operands_t args)
      : name(std::move(name)), args(std::move(args)) {}

  iterable<operand> get_args() const { return iterable<operand>(args); }

  void accept(annotation_visitor& av) const override { av.visit(this); }
  bool operator==(annotation const& o) const override;
};

inline std::unique_ptr<annotation> make_function_annotation(std::string name,
                                                            operands_t args) {
  return std::unique_ptr<annotation>(
      new function_annotation(std::move(name), std::move(args)));
}

}  // namespace assembly
}  // namespace gdsl
