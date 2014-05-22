/*
 * arch_exception.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/exception/exception.h>
#include <string>

namespace gdsl {
namespace rreil {

class arch_exception : public exception {
private:
  std::string name;

public:
  arch_exception(std::string name);

  const std::string& get_name() const {
    return name;
  }

  std::string to_string();
};

}  // namespace rreil
}  // namespace gdsl
