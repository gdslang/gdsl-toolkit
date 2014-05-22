/*
 * linear.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

class linear {
public:
  virtual ~linear() {
  }

  virtual std::string to_string() = 0;
};

}
}
