#include "cppgdsl/assembly/annotation/annotation.h"

namespace gdsl {
namespace assembly {

std::ostream& operator<<(std::ostream& out, const annotation& _this) {
  _this.put(out);
  return out;
}

}  // namespace assembly
}  // namespace gdsl
