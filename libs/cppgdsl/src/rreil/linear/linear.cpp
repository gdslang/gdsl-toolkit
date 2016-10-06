#include "cppgdsl/rreil/linear/linear.h"

#include <sstream>

namespace gdsl {
namespace rreil {

std::string linear::to_string() const {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream& operator<<(std::ostream& out, linear const& _this) {
  _this.put(out);
  return out;
}

}  // namespace rreil
}  // namespace gdsl
