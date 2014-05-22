/*
 * prim.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "statement.h"
#include <cppgdsl/rreil/variable.h>
#include <cppgdsl/rreil/variable_limited.h>
#include <string>
#include <vector>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class prim : public statement {
private:
  std::string op;
  std::vector<variable_limited*> lhs;
  std::vector<variable_limited*> rhs;

public:
  prim(std::string op, std::vector<variable_limited*> lhs, std::vector<variable_limited*> rhs);
  ~prim();

  std::string get_op() const {
    return op;
  }

  std::vector<variable_limited*> const &get_lhs() const {
    return lhs;
  }

  std::vector<variable_limited*> const &get_rhs() const {
    return rhs;
  }

  std::string to_string();
};

}
}
