/*
 * This file contains all definitions for a binary operator used
 * in linear RReil expressions.
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

enum binop_lin_op { BIN_LIN_ADD, BIN_LIN_SUB };

std::string bin_lin_op_to_string(binop_lin_op op);

}  // namespace rreil
}  // namespace gdsl
