/*
 * lin_add.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "linear.h"
#include "binop_lin_op.h"

namespace gdsl {
namespace rreil {

class lin_binop : public linear {
private:
  binop_lin_op op;
  linear *opnd1;
  linear *opnd2;

  void put(std::ostream &out);
public:
  lin_binop(binop_lin_op op, linear *opnd1, linear *opnd2);
  ~lin_binop();

  binop_lin_op get_op() const {
    return op;
  }

  linear *get_opnd1() const {
    return opnd1;
  }

  linear *get_opnd2() const {
    return opnd2;
  }

  void accept(linear_visitor &v);
};

}
}
