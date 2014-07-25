/*
 * branch_hint.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/branch_hint.h>

std::string gdsl::rreil::branch_hint_to_string(branch_hint hint) {
  switch(hint) {
    case BRANCH_HINT_JUMP: {
      return "JUMP";
    }
    case BRANCH_HINT_CALL: {
      return "CALL";
    }
    case BRANCH_HINT_RET: {
      return "RET";
    }
  }
}
