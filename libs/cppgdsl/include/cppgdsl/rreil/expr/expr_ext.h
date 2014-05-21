/*
 * expr_ext.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/expr/expr.h>
#include <cppgdsl/rreil/linear/linear.h>
#include <gdsl_generic.h>

namespace gdsl {
namespace rreil {

enum ext_op {
  EXT_SX, EXT_ZX
};

class expr_ext : public expr {
private:
  ext_op op;
  int_t fromsize;
  linear *opnd;

public:
  expr_ext(ext_op op, int_t fromsize, linear *opnd);
  ~expr_ext();

  int_t get_fromsize() const {
    return fromsize;
  }

  ext_op get_op() const {
    return op;
  }

  linear *get_opnd() const {
    return opnd;
  }
};

}
}
