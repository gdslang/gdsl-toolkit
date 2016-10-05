/*
 * expr_binop.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "binop_op.h"
#include <cppgdsl/rreil/expr/expr.h>
#include <cppgdsl/rreil/linear/linear.h>

namespace gdsl {
namespace rreil {

class expr_binop : public expr {
private:
  binop_op op;
  linear *opnd1;
  linear *opnd2;

  void put(std::ostream &out);
public:
  expr_binop(binop_op op, linear *opnd1, linear *opnd2);
  ~expr_binop();

  binop_op get_op() {
    return op;
  }

  linear *get_opnd1() {
    return opnd1;
  }

  linear *get_opnd2() {
    return opnd2;
  }

  void accept(expr_visitor &v);
};

}  // namespace rreil
} // namespace gdsl
