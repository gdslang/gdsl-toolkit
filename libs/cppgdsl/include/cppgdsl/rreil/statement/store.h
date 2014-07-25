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

  void put(std::ostream &out);
public:
  store(int_t size, address *_address, linear *rhs);
  ~store();

  int_t get_size() {
    return size;
  }

  address *get_address() {
    return _address;
  }

  linear *get_rhs() {
    return rhs;
  }

  void accept(statement_visitor &v);
};

}}
