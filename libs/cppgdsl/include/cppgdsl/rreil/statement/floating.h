/*
 * floating.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "statement.h"
#include <cppgdsl/rreil/flop.h>
#include <cppgdsl/rreil/variable.h>
#include <cppgdsl/rreil/variable_limited.h>
#include <vector>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class floating : public statement {
private:
  flop op;
  variable *flags;
  variable_limited *lhs;
  std::vector<variable_limited*> rhs;

  void put(std::ostream &out);
public:
  floating(flop op, variable *flags, variable_limited *lhs, std::vector<variable_limited*> rhs);
  ~floating();

  flop get_op() {
    return op;
  }

  variable *get_flags() {
    return flags;
  }

  variable_limited *get_lhs() {
    return lhs;
  }

  std::vector<variable_limited*> const &get_rhs() {
    return rhs;
  }

  void accept(statement_visitor &v);
};

}
}
