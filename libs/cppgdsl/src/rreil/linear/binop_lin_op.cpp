#include "cppgdsl/rreil/linear/binop_lin_op.h"

namespace gdsl {
namespace rreil {

std::string bin_lin_op_to_string(binop_lin_op op) {
  switch (op) {
    case BIN_LIN_ADD: {
      return "+";
    }
    case BIN_LIN_SUB: {
      return "-";
    }
  }
}

}  // namespace rreil
}  // namespace gdsl
