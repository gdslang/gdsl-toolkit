/*
 * virtual.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <gdsl_generic.h>
#include "id.h"

namespace gdsl {
namespace rreil {

class _virtual : public id {
private:
  int_t t;

public:
  _virtual(int_t t);

  int_t get_t();
};

}  // namespace rreil
} // namespace gdsl
