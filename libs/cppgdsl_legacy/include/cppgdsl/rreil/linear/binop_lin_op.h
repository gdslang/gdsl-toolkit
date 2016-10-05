/*
 * binop_lin_op.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

enum binop_lin_op {
  BIN_LIN_ADD, BIN_LIN_SUB
};

std::string bin_lin_op_to_string(binop_lin_op op);

}
}
