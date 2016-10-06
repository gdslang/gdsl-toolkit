#include "cppgdsl/frontend/bare_frontend.h"

#include <stdexcept>

namespace gdsl {

bare_frontend::bare_frontend(std::string const& name) {
  char err = gdsl_multiplex_frontend_get_by_lib_name(&frontend, name.c_str());
  if (err != GDSL_MULTIPLEX_ERROR_NONE)
    throw std::runtime_error("Unable to open frontend");
  initialized = true;
}

}  // namespace gdsl
