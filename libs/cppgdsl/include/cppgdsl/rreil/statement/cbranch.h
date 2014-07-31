/*
 * cbranch.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "statement.h"
#include <cppgdsl/rreil/sexpr/sexpr.h>
#include <cppgdsl/rreil/address.h>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class cbranch : public statement {
private:
  sexpr *cond;
  address *target_true;
  address *target_false;

  void put(std::ostream &out);
public:
  cbranch(sexpr *cond, address *target_true, address *target_false);
  ~cbranch();

  sexpr *get_cond() {
    return cond;
  }

  address *get_target_false() {
    return target_false;
  }

  address *get_target_true() {
    return target_true;
  }

  void accept(statement_visitor &v);
};

}}
