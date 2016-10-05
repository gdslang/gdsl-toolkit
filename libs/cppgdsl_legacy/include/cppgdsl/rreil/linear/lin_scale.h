/*
 * lin_scale.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "linear.h"
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class lin_scale : public linear {
private:
  int_t _const;
  linear *opnd;

  void put(std::ostream &out);
public:
  lin_scale(int_t _const, linear *opnd);
  ~lin_scale();

  int_t get_const() {
    return _const;
  }

  linear *get_opnd() {
    return opnd;
  }

  void accept(linear_visitor &v);
};

}}
