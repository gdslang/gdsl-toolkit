/*
 * statement.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "statement_visitor.h"
#include <string>

namespace gdsl {
namespace rreil {

class statement {
public:
  virtual ~statement() {
  }

  virtual std::string to_string() = 0;

  virtual void accept(statement_visitor &v) = 0;
};

}
}
