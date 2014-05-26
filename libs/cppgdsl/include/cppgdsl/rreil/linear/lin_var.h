/*
 * lin_var.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/variable.h>
#include "linear.h"
#include <string>

namespace gdsl {
namespace rreil {

class lin_var : public linear {
private:
  variable *var;

  void put(std::ostream &out);
public:
  lin_var(variable *var);
  ~lin_var();

  variable *get_var() const {
    return var;
  }

  void accept(linear_visitor &v);
};

}  // namespace rreil
} // namespace gdsl
