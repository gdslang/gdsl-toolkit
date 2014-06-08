/*
 * frontend.h
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#pragma once
extern "C" {
#include <gdsl_multiplex.h>
}

namespace gdsl {

class _frontend {
protected:
  struct frontend frontend;
protected:
  virtual ~_frontend();

public:
  const struct frontend &native() const {
    return frontend;
  }
};

}  // namespace gdsl
