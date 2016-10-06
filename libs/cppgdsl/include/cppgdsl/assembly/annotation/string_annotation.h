/*
 * The file contains all definitions for a string annotation ASM
 * AST node. A string annotation offers the most generic way of
 * annotation - it allows to add arbitrary strings to an object.
 * String annotations are used for syntactic objects that cannot be
 * expressed any other way using the generic assembly classes.
 */

#pragma once
#include <iostream>
#include <string>

#include "cppgdsl/assembly/annotation/annotation.h"

namespace gdsl {
namespace assembly {

class string_annotation final : public annotation {
 private:
  std::string annotation_;

  void put(std::ostream& out) const override;

 public:
  string_annotation(std::string annotation_arg)
      : annotation_(std::move(annotation_arg)) {}

  std::string get_annotation() const { return annotation_; }

  void accept(annotation_visitor& av) const override { av.visit(this); }
  bool operator==(annotation const& o) const override;
};

inline std::unique_ptr<annotation> make_string_annotation(
    std::string annotation_arg) {
  return std::unique_ptr<annotation>(
      new assembly::string_annotation(std::move(annotation_arg)));
}

}  // namespace assembly
}  // namespace gdsl
