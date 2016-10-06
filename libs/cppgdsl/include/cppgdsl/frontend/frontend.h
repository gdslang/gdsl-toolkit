/*
 * The file contains a class to represent GDSL front-ends.
 * A front-end represents a GDSL implementation for a specific
 * machine architecture.
 */

#pragma once

extern "C" {
#include "gdsl_multiplex.h"
}

namespace gdsl {

class _frontend {
 protected:
  struct frontend frontend;
  bool initialized = false;

 public:
  _frontend() = default;
  _frontend(_frontend const&) = delete;
  _frontend(_frontend &&) = delete;
  virtual ~_frontend();
  _frontend& operator=(_frontend const&) = delete;
  _frontend& operator=(_frontend &&) = delete;

  const struct frontend& native() const { return frontend; }
};

}  // namespace gdsl
