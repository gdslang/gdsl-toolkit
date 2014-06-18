/*
 * rreil_load.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "statement.h"
#include <cppgdsl/rreil/address.h>
#include <cppgdsl/rreil/variable.h>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class load : public statement {
private:
  int_t size;
  variable *lhs;
  address *_address;

  void put(std::ostream &out);
public:
  load(int_t size, variable *lhs, address *_address);
  ~load();

  int_t get_size() {
    return size;
  }

  variable *get_lhs() {
    return lhs;
  }

  address *get_address() {
    return _address;
  }

  void accept(statement_visitor &v);
};

}}
