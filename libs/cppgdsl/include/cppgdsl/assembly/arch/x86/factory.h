/*
 * This file defines factory functions for x86 specific assembly
 * registers.
 */

#pragma once
#include <memory>

#include "cppgdsl/arch/x86.h"
#include "cppgdsl/assembly/operand/register.h"

namespace gdsl {
namespace assembly {

std::unique_ptr<operand> make_register(x86_rreil_register r) {
  return std::unique_ptr<operand>(new register_(to_string(r)));
}

}  // namespace assembly
}  // namespace gdsl
