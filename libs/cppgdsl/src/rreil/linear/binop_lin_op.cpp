/*
 * binop_lin_op.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/linear/binop_lin_op.h>

std::string gdsl::rreil::bin_lin_op_to_string(binop_lin_op op) {
  switch(op) {
    case BIN_LIN_ADD: {
      return "+";
    }
    case BIN_LIN_SUB: {
      return "-";
    }
  }
}
