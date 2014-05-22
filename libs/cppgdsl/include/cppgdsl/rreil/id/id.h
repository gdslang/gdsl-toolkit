/*
 * rreil_id.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

class id {
public:
  virtual ~id() {
  }

  virtual std::string to_string() = 0;
};

}
}
