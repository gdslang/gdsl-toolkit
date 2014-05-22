/*
 * lin_imm.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <gdsl_generic.h>
#include "linear.h"
#include <string>

namespace gdsl {
namespace rreil {

class lin_imm : public linear {
private:
  int_t _const;

public:
  lin_imm(int_t _const);

  int_t get_imm() const {
    return _const;
  }

  std::string to_string();
};

}}
