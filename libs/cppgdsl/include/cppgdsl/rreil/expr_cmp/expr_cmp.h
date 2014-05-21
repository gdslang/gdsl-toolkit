/*
 * expr_cmp.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/linear/linear.h>

namespace gdsl {
namespace rreil {

class expr_cmp {
protected:
  linear *opnd1;
  linear *opnd2;

public:
  expr_cmp(linear *opnd1, linear *opnd2);
  ~expr_cmp();

  linear *get_opnd1() const {
    return opnd1;
  }

  linear *get_opnd2() const {
    return opnd2;
  }
};

}
}
