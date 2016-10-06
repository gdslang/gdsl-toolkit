#include "cppgdsl/rreil/branch_hint.h"

namespace gdsl {
namespace rreil {

std::string branch_hint_to_string(branch_hint hint) {
  switch (hint) {
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

}  // namespace rreil
}  // namespace gdsl
