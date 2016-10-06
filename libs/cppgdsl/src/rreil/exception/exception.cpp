#include "cppgdsl/rreil/exception/exception.h"

#include <sstream>

std::string gdsl::rreil::exception::to_string() const {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream& gdsl::rreil::operator<<(std::ostream& out,
                                      exception const& _this) {
  _this.put(out);
  return out;
}
