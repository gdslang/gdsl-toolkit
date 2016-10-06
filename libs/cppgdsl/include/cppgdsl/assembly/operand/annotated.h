/*
 * The file contains all definitions for an annotated operand ASM
 * AST node. Such an operand allows to add an annotation to an arbitrary
 * operand.
 */

#pragma once
#include <string>

#include "cppgdsl/assembly/annotation/annotation.h"
#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

class annotated final : public operand {
 private:
  std::unique_ptr<annotation> annotation_;
  std::unique_ptr<operand> operand_;

  void put(std::ostream& out) const override;

 public:
  annotated(std::unique_ptr<annotation> _annotation,
            std::unique_ptr<operand> operand_arg)
      : annotation_(std::move(_annotation)), operand_(std::move(operand_arg)) {}

  annotation const& get_annotation() const { return *annotation_; }

  operand const& get_operand() const { return *operand_; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_annotated(
    std::unique_ptr<annotation> _annotation,
    std::unique_ptr<operand> operand_arg) {
  return std::unique_ptr<operand>(
      new annotated(std::move(_annotation), std::move(operand_arg)));
}

std::unique_ptr<operand> make_annotated(std::string annotation_arg,
                                        std::unique_ptr<operand> operand_arg);

}  // namespace assembly
}  // namespace gdsl
