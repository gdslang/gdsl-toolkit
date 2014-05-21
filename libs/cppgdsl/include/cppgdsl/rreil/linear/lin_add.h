/*
 * lin_add.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "linear.h"

namespace gdsl {
namespace rreil {

class lin_add : public linear {
private:
  linear *opnd1;
  linear *opnd2;

public:
  lin_add(linear *opnd1, linear *opnd2);
  ~lin_add();

  linear *get_opnd1() const {
    return opnd1;
  }

  linear *get_opnd2() const {
    return opnd2;
  }
};

}}
