/*
 * assign.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "statement.h"
#include <cppgdsl/rreil/expr/expr.h>
#include <cppgdsl/rreil/variable.h>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class assign : public statement {
private:
  int_t size;
  variable *lhs;
  expr *rhs;

  void put(std::ostream &out);
public:
  assign(int_t size, variable *lhs, expr *rhs);
  ~assign();

  int_t get_size() const {
    return size;
  }

  variable *get_lhs() const {
    return lhs;
  }

  expr *get_rhs() const {
    return rhs;
  }

  void accept(statement_visitor &v);
};

}}
