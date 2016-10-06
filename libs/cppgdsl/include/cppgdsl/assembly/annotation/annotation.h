/*
 * This file contains the base class for all ASM annotation AST nodes.
 * An annotation is used to add additional data to, for example, an
 * operand that cannot be expressed otherwise.
 */

#pragma once

#include <iostream>
#include <memory>
#include <vector>

#include "cppgdsl/assembly/annotation/annotation_visitor.h"

extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace assembly {

class annotation {
 private:
  virtual void put(std::ostream& out) const = 0;

 public:
  virtual ~annotation() = default;
  virtual void accept(annotation_visitor& av) const = 0;
  /*
   * This operator recursively compares for syntactic equality.
   */
  virtual bool operator==(annotation const& o) const = 0;
  bool operator!=(annotation const& o) const { return !(*this == o); }

  friend std::ostream& operator<<(std::ostream& out, annotation const& _this);
};

std::ostream& operator<<(std::ostream& out, annotation const& _this);

using annotations_t = std::vector<std::unique_ptr<annotation>>;

}  // namespace assembly
}  // namespace gdsl
