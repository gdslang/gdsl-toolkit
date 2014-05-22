/*
 * throw.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "statement.h"
#include <cppgdsl/rreil/exception/exception.h>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class _throw : public statement {
private:
  exception *inner;

public:
  _throw(exception *inner);
  ~_throw();

  exception const *get_inner() const {
    return inner;
  }

  std::string to_string();
};

}
}
