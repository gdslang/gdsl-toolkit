/*
 * expr_cmp.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "cmp_op.h"
#include <cppgdsl/rreil/linear/linear.h>

namespace gdsl {
namespace rreil {

class expr_cmp {
private:
  void put(std::ostream &out);

protected:
  cmp_op op;
  linear *opnd1;
  linear *opnd2;

public:
  expr_cmp(cmp_op op, linear *opnd1, linear *opnd2);
  ~expr_cmp();

  cmp_op get_op() const {
    return op;
  }

  linear *get_opnd1() const {
    return opnd1;
  }

  linear *get_opnd2() const {
    return opnd2;
  }

  std::string to_string();
  friend std::ostream &operator<< (std::ostream &out, expr_cmp &_this);
};

std::ostream& operator<<(std::ostream &out, expr_cmp &_this);

}
}
