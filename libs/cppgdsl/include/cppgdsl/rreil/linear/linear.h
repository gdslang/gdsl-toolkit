/*
 * linear.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "linear_visitor.h"
#include <string>

namespace gdsl {
namespace rreil {

class linear {
public:
  virtual ~linear() {
  }

  virtual std::string to_string() = 0;
  virtual void accept(linear_visitor &v) = 0;
};

}
}
