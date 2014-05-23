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

public:
  floating(flop op, variable *flags, variable_limited *lhs, std::vector<variable_limited*> rhs);
  ~floating();

  flop get_op() const {
    return op;
  }

  variable const *get_flags() const {
    return flags;
  }

  variable_limited const *get_lhs() const {
    return lhs;
  }

  std::vector<variable_limited*> const &get_rhs() const {
    return rhs;
  }

  std::string to_string();
  void accept(statement_visitor &v);
};

}
}
