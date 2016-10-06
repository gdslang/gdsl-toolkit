/*
 * The file contains all definitions for the generic assembly builder. It
 * can be used to convert the internal GDSL format of a generic assembly
 * instruction into its C++ representation.
 */

#pragma once
#include <memory>

#include "cppgdsl/assembly/instruction.h"
#include "cppgdsl/gdsl.h"

namespace gdsl {

class asm_builder {
 private:
  gdsl* g;

 public:
  asm_builder(gdsl* g) : g(g) {}

  assembly::instruction convert(asm_insn_t ginsn);
};

}  // namespace gdsl
