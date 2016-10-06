#include "cppgdsl/assembly/operand/operand.h"

namespace gdsl {
namespace assembly {

std::ostream& operator<<(std::ostream& out, const operand& _this) {
  _this.put(out);
  return out;
}

}  // namespace assembly
}  // namespace gdsl
