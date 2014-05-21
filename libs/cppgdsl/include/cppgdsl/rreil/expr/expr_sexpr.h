/*
 * expr_sexpr.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/sexpr/sexpr.h>
#include <cppgdsl/rreil/expr/expr.h>

namespace gdsl {
namespace rreil {

class expr_sexpr : public expr {
private:
  sexpr *inner;

public:
  expr_sexpr(sexpr *inner);
  ~expr_sexpr();

  sexpr *get_inner() const {
    return inner;
  }
};

}  // namespace rreil
} // namespace gdsl
