/*
 * statement.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "statement_visitor.h"
#include <iosfwd>
#include <string>

namespace gdsl {
namespace rreil {

class statement {
private:
  virtual void put(std::ostream &out) = 0;
public:
  virtual ~statement() {
  }

  virtual std::string to_string();
  friend std::ostream& operator<< (std::ostream &out, statement &_this);

  virtual void accept(statement_visitor &v) = 0;
};

std::ostream& operator<<(std::ostream &out, statement &_this);

}
}
