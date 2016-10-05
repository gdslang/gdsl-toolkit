/*
 * binop_op.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

enum binop_op {
  BIN_MUL, BIN_DIV, BIN_DIVS, BIN_MOD, BIN_MODS, BIN_SHL, BIN_SHR, BIN_SHRS, BIN_AND, BIN_OR, BIN_XOR
};

std::string binop_op_to_string(binop_op op);

}
}
