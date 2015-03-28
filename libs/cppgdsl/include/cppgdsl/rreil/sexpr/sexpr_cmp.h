/*
 * sexpr_cmp.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <cppgdsl/rreil/expr_cmp/expr_cmp.h>
#include "sexpr.h"
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class sexpr_cmp : public sexpr {
private:
  int_t size;
  expr_cmp *inner;

  void put(std::ostream &out);
public:
  sexpr_cmp(int_t size, expr_cmp *inner);
  ~sexpr_cmp();

  int_t get_size() {
    return size;
  }

  expr_cmp *get_inner() {
    return inner;
  }

  void accept(sexpr_visitor &v);
};

}
}
