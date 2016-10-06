/*
 * This file contains the base class for all ASM operand AST nodes.
 */

#pragma once
#include <iostream>
#include <memory>
#include <vector>

#include "cppgdsl/assembly/operand/operand_visitor.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace assembly {

class operand_visitor;

class operand {
 private:
  virtual void put(std::ostream& out) const = 0;

 public:
  virtual ~operand() = default;

  virtual void accept(operand_visitor& ov) const = 0;
  /*
   * This operator recursively compares for syntactic equality.
   */
  virtual bool operator==(operand const& o) const = 0;
  bool operator!=(operand const& o) const { return !(*this == o); }

  friend std::ostream& operator<<(std::ostream& out, operand const& _this);
};

std::ostream& operator<<(std::ostream& out, operand const& _this);

using operands_t = std::vector<std::unique_ptr<operand>>;

}  // namespace assembly
}  // namespace gdsl
