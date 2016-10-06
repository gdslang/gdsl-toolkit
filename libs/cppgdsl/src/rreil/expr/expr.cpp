#include "cppgdsl/rreil/expr/expr.h"

#include <sstream>

namespace gdsl {
namespace rreil {

std::ostream& operator<<(std::ostream& out, expr& _this) {
  _this.put(out);
  return out;
}

std::string expr::to_string() {
  std::stringstream o;
  o << *this;
  return o.str();
}

}  // namespace rreil
}  // namespace gdsl
