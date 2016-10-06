#include "cppgdsl/rreil/sexpr/sexpr.h"

#include <sstream>

namespace gdsl {
namespace rreil {

std::string sexpr::to_string() const {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream& operator<<(std::ostream& out, sexpr const& _this) {
  _this.put(out);
  return out;
}

}  // namespace rreil
}  // namespace gdsl
