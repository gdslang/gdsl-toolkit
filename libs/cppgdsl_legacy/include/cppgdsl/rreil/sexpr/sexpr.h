/*
 * sexpr.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "sexpr_visitor.h"
#include <iosfwd>
#include <string>

namespace gdsl {
namespace rreil {

class sexpr {
private:
  virtual void put(std::ostream &out) = 0;
public:
  virtual ~sexpr() {
  }

  std::string to_string();
  friend std::ostream &operator<< (std::ostream &out, sexpr &_this);

  virtual void accept(sexpr_visitor &v) = 0;
};

std::ostream &operator<<(std::ostream &out, sexpr &_this);

}
}

#include "arbitrary.h"
#include "sexpr_cmp.h"
#include "sexpr_lin.h"
#include "sexpr_visitor.h"
