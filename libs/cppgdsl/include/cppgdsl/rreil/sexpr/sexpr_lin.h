/*
 * sexpr_lin.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <cppgdsl/rreil/linear/linear.h>
#include "sexpr.h"

namespace gdsl {
namespace rreil {

class sexpr_lin : public sexpr {
private:
  linear *lin;

public:
  sexpr_lin(linear *lin);
  ~sexpr_lin();

  linear *get_lin() const {
    return lin;
  }
};

}
}
