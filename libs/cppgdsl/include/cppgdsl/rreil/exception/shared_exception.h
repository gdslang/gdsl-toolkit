/*
 * shared_exception.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "exception.h"

namespace gdsl {
namespace rreil {

enum shared_exception_type {
  TYPE_DIVISION_BY_ZERO
};

std::string shared_exception_type_to_string(shared_exception_type t);

class shared_exception : public exception {
private:
  shared_exception_type type;
public:
  shared_exception(shared_exception_type type);

  shared_exception_type get_type() const {
    return type;
  }

  std::string to_string();
};

}  // namespace rreil
}  // namespace gdsl
