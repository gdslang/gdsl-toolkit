/*
 * address.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <cppgdsl/rreil/linear/linear.h>
#include <gdsl_generic.h>

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
};

}
}
