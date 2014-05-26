/*
 * address.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <cppgdsl/rreil/linear/linear.h>
#include <string>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class address {
private:
  int_t size;
  linear *lin;

public:
  address(int_t size, linear *lin);
  ~address();

  linear *get_lin() const {
    return lin;
  }

  int_t get_size() const {
    return size;
  }

  std::string to_string();
  friend std::ostream &operator<< (std::ostream &out, address &_this);
};

std::ostream &operator<<(std::ostream &out, address &_this);

}
}
