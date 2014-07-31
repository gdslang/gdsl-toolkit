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

  void put(std::ostream &out);
public:
  prim(std::string op, std::vector<variable_limited*> lhs, std::vector<variable_limited*> rhs);
  ~prim();

  std::string get_op() {
    return op;
  }

  std::vector<variable_limited*> const &get_lhs() {
    return lhs;
  }

  std::vector<variable_limited*> const &get_rhs() {
    return rhs;
  }

  void accept(statement_visitor &v);
};

}
}
