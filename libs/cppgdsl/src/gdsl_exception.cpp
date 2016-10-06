#include "cppgdsl/gdsl_exception.h"

#include <iostream>

namespace gdsl {

gdsl_exception::gdsl_exception(std::string cppgdsl_message,
                               std::string gdsl_message)
    : cppgdsl_message(std::move(cppgdsl_message)),
      gdsl_message(std::move(gdsl_message)) {}

std::ostream& operator<<(std::ostream& out, gdsl_exception& _this) {
  out << "gdsl exception, original gdsl message: " << _this.gdsl_message
      << ", cppgdsl message: " << _this.cppgdsl_message;
  return out;
}

}  // namespace gdsl
