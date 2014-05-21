/*
 * arch_exception.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "exception"
#include <string>

namespace gdsl {
namespace rreil {

class arch_exception : public exception {
private:
  std::string name;

public:
  arch_exception(std::string name);

  std::string get_name();
};

}  // namespace rreil
}  // namespace gdsl
