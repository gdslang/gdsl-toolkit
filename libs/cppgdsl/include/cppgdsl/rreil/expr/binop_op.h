/*
 * This file contains an enumeration of all binary
 * operations supported by RReil.
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

enum binop_op {
  BIN_MUL,
  BIN_DIV,
  BIN_DIVS,
  BIN_MOD,
  BIN_MODS,
  BIN_SHL,
  BIN_SHR,
  BIN_SHRS,
  BIN_AND,
  BIN_OR,
  BIN_XOR
};

std::string binop_op_to_string(binop_op op);

}  // namespace rreil
}  // namespace gdsl
