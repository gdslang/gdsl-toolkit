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

  void put(std::ostream &out);
public:
  _throw(exception *inner);
  ~_throw();

  exception const *get_inner() const {
    return inner;
  }

  void accept(statement_visitor &v);
};

}
}
