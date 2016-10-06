/*
 * This file defines factory functions for x86 specific RReil IDs and
 * variables.
 */

#pragma once
#include <memory>

#include "cppgdsl/arch/x86.h"
#include "cppgdsl/rreil/rreil.h"

using gdsl::rreil::id;

namespace gdsl {
namespace rreil {

inline std::unique_ptr<id> make_id(x86_rreil_register r) {
  return std::unique_ptr<id>(new arch_id(to_string(r)));
}

inline std::unique_ptr<variable> make_variable(x86_register frag,
                                               int_t bit_offset = 0) {
  auto desc = desc_of(frag);
  return std::unique_ptr<variable>(
      new variable(make_id(desc.register_), desc.bit_offset + bit_offset));
}

inline std::unique_ptr<variable> make_variable_limited(x86_register frag,
                                                       int_t bit_offset = 0) {
  auto desc = desc_of(frag);
  return std::unique_ptr<variable>(new variable_limited(
      make_id(desc.register_), desc.bit_offset + bit_offset, desc.bit_size));
}

}  // namespace assembly
}  // namespace gdsl
