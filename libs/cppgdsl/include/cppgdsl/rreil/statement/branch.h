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

  address const *get_target() const {
    return target;
  }

  branch_hint get_hint() const {
    return hint;
  }

  std::string to_string();
  void accept(statement_visitor &v);
};

}}
