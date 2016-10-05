/*
 * exception.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "exception_visitor.h"
#include <iosfwd>
#include <string>

namespace gdsl {
namespace rreil {

class exception {
private:
  virtual void put(std::ostream &out) = 0;
public:
  virtual ~exception() {
  }

  std::string to_string();
  friend std::ostream &operator<< (std::ostream &out, exception &_this);

  virtual void accept(exception_visitor &v) = 0;
};

std::ostream &operator<<(std::ostream &out, exception &_this);

}  // namespace rreil
}  // namespace gdsl
