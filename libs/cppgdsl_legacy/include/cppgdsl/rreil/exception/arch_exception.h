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

  void put(std::ostream &out);
public:
  arch_exception(std::string name);

  const std::string &get_name() {
    return name;
  }

  void accept(exception_visitor &v);
};

}  // namespace rreil
}  // namespace gdsl
