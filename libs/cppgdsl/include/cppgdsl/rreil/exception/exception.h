/*
 * exception.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "exception_visitor.h"
#include <string>

namespace gdsl {
namespace rreil {

class exception {
public:
  virtual ~exception() {
  }

  virtual std::string to_string() = 0;
  virtual void accept(exception_visitor &v) = 0;
};

}  // namespace rreil
}  // namespace gdsl
