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

  void put(std::ostream &out) const override;
public:
  prim(std::string op, std::vector<variable_limited*> lhs, std::vector<variable_limited*> rhs);
  ~prim() override;

  std::string get_op() const {
    return op;
  }

  const std::vector<variable_limited*> &get_lhs() const {
    return lhs;
  }

  const std::vector<variable_limited*> &get_rhs() const {
    return rhs;
  }

  void accept(statement_visitor &v) override;
};

}  //namespace rreil
}  //namespace gdsl
