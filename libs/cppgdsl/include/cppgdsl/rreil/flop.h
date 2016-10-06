/*
 * This file contains all definitions for a floating point operator used
 * in RReil floating point statements.
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

enum flop { FLOP_FADD, FLOP_FSUB, FLOP_FMUL };

std::string flop_to_string(flop f);

}  // namespace rreil
}  // namespace gdsl
