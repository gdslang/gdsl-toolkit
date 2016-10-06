#include "cppgdsl/rreil/expr_cmp/cmp_op.h"

namespace gdsl {
namespace rreil {

std::string cmp_op_to_string(cmp_op op) {
  switch (op) {
    case CMP_EQ: {
      return "==";
    }
    case CMP_NEQ: {
      return "!=";
    }
    case CMP_LES: {
      return "<=s";
    }
    case CMP_LEU: {
      return "<=u";
    }
    case CMP_LTS: {
      return "<s";
    }
    case CMP_LTU: {
      return "<u";
    }
  }
}

}  // namespace rreil
}  // namespace gdsl
