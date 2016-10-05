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

  void put(std::ostream &out) const override;
public:
  store(int_t size, address *_address, linear *rhs);
  ~store() override;

  int_t get_size() const {
    return size;
  }

  address *get_address() const {
    return _address;
  }

  linear *get_rhs() const {
    return rhs;
  }

  void accept(statement_visitor &v) override;
};

}  //namespace rreil
}  //namespace gdsl
