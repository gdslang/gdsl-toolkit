/*
 * lin_scale.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <gdsl_generic.h>
#include "linear.h"

namespace gdsl {
namespace rreil {

class lin_scale : public linear {
private:
  int_t _const;
  linear *opnd;

public:
  lin_scale(int_t _const, linear *opnd);
  ~lin_scale();

  int_t get_const() const {
    return _const;
  }

  linear *get_opnd() const {
    return opnd;
  }
};

}}
