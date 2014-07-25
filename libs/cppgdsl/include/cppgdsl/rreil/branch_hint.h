/*
 * branch_hint.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

enum branch_hint {
  BRANCH_HINT_JUMP, BRANCH_HINT_CALL, BRANCH_HINT_RET
};

std::string branch_hint_to_string(branch_hint hint);

}
}
