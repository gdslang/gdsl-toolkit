/*
 * The file contains a class to represent a bare front-end. A bare
 * front-end is defined by the name of the corresponding shared object
 * library.
 */

#pragma once
#include <string>

#include "cppgdsl/frontend/frontend.h"

namespace gdsl {

class bare_frontend : public _frontend {
 public:
  bare_frontend(std::string const& name);
};

}  // namespace gdsl
