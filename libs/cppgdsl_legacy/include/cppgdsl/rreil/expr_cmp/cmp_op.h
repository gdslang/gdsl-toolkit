/*
 * cmp_op.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

enum cmp_op {
  CMP_EQ, CMP_NEQ, CMP_LES, CMP_LEU, CMP_LTS, CMP_LTU
};

std::string cmp_op_to_string(cmp_op op);

}
}
