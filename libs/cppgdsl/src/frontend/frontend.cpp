#include "cppgdsl/frontend/frontend.h"
#include <stdio.h>

namespace gdsl {

_frontend::~_frontend() {
  if (initialized) gdsl_multiplex_frontend_close(&frontend);
}

}  // namespace gdsl
