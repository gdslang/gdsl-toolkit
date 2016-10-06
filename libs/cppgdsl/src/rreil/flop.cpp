#include "cppgdsl/rreil/flop.h"

namespace gdsl {
namespace rreil {

std::string flop_to_string(flop f) {
  switch (f) {
    case FLOP_FADD: {
      return ".+";
    }
    case FLOP_FSUB: {
      return ".-";
    }
    case FLOP_FMUL: {
      return ".*";
    }
  }
}

}  // namespace rreil
}  // namespace gdsl
