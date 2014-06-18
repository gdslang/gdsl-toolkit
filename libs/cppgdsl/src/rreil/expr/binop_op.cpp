/*
 * binop_op.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/expr/binop_op.h>

std::string gdsl::rreil::binop_op_to_string(binop_op op) {
  switch(op) {
    case BIN_MUL: {
      return "*";
    }
    case BIN_DIV: {
      return "/";
    }
    case BIN_DIVS: {
      return "/s";
    }
    case BIN_MOD: {
      return "%";
    }
    case BIN_MODS: {
      return "%s";
    }
    case BIN_SHL: {
      return "<<";
    }
    case BIN_SHR: {
      return ">>u";
    }
    case BIN_SHRS: {
      return ">>s";
    }
    case BIN_AND: {
      return "&";
    }
    case BIN_OR: {
      return "|";
    }
    case BIN_XOR: {
      return "^";
    }
  }
}
