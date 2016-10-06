/*
 * The file contains all definitions for a register operand ASM
 * AST node.
 */

#pragma once
#include <string>

#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

class register_ final : public operand {
 private:
  std::string name;

  void put(std::ostream& out) const override;

 public:
  register_(std::string name) : name(std::move(name)) {}

  std::string const& get_name() const { return name; }

  void accept(operand_visitor& ov) const override;
  bool operator==(operand const& o) const override;
};

inline std::unique_ptr<operand> make_register(std::string name) {
  return std::unique_ptr<operand>(new register_(std::move(name)));
}

}  // namespace assembly
}  // namespace gdsl
