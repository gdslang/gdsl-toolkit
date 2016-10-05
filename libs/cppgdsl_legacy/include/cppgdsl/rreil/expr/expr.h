/*
 * expr.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>
#include <iosfwd>
#include "expr_visitor.h"

namespace gdsl {
namespace rreil {

class expr {
private:
  virtual void put(std::ostream &out) = 0;
public:
  virtual ~expr() {
  }

  std::string to_string();
  friend std::ostream &operator<< (std::ostream &out, expr &_this);

  virtual void accept(expr_visitor &v) = 0;
};

std::ostream& operator<<(std::ostream &out, expr &_this);

}
}

#include "binop_op.h"
#include "expr_binop.h"
#include "expr_ext.h"
#include "expr_sexpr.h"
#include "expr_visitor.h"
