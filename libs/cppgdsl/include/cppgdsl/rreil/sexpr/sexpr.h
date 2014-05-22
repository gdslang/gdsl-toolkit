/*
 * sexpr.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

class sexpr {
public:
  virtual ~sexpr() {
  }

  virtual std::string to_string() = 0;
};

}
}
