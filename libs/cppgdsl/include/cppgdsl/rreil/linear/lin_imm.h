/*
 * lin_imm.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "linear.h"
#include <string>

extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class lin_imm : public linear {
private:
  int_t _const;

  void put(std::ostream &out);
public:
  lin_imm(int_t _const);

  int_t get_imm() const {
    return _const;
  }

  void accept(linear_visitor &v);
};

}}
