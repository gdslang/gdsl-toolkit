/*
 * branch.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "statement.h"
#include <cppgdsl/rreil/address.h>
#include <cppgdsl/rreil/branch_hint.h>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class branch : public statement {
private:
  address *target;
  branch_hint hint;

  void put(std::ostream &out);
public:
  branch(address *target, branch_hint hint);
  ~branch();

  address *get_target() {
    return target;
  }

  branch_hint get_hint() {
    return hint;
  }

  void accept(statement_visitor &v);
};

}}
