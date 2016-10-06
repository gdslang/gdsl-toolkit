#include "cppgdsl/rreil/id/id.h"

#include <sstream>

namespace gdsl {
namespace rreil {

size_t id::subclass_counter = 0;

std::ostream& operator<<(std::ostream& out, id const& _this) {
  _this.put(out);
  return out;
}

std::string id::to_string() const {
  std::stringstream o;
  o << *this;
  return o.str();
}

}  // namespace rreil
}  // namespace gdsl
