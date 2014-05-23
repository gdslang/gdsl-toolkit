/*
 * expr.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>

#include "expr_visitor.h"

namespace gdsl {
namespace rreil {

class expr {
public:
  virtual ~expr() {
  }

  virtual std::string to_string() = 0;
  virtual void accept(expr_visitor &v) = 0;
};

}
}
