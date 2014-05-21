/*
 * rreil_load.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "statement.h"
#include <cppgdsl/rreil/address.h>
#include <cppgdsl/rreil/linear/linear.h>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class store : public statement {
private:
  int_t size;
  address *_address;
  linear *rhs;

public:
  store(int_t size, address *_address, linear *rhs);
  ~store();

  int_t get_size() const {
    return size;
  }

  address const *get_address() const {
    return _address;
  }

  linear const *get_rhs() const {
    return rhs;
  }
};

}}
