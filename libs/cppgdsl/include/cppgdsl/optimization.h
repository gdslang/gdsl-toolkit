/*
 * optimization.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <gdsl_generic.h>

namespace gdsl {

enum optimization_configuration {
  EVERYWHERE = PRESERVATION_EVERYWHERE,
  BLOCK = PRESERVATION_BLOCK,
  CONTEXT = PRESERVATION_CONTEXT,
  LIVENESS = OC_LIVENESS,
  FSUBST = OC_FSUBST
};

inline optimization_configuration operator|(optimization_configuration a, optimization_configuration b) {
  return static_cast<optimization_configuration>(static_cast<unsigned>(a) | static_cast<unsigned>(b));
}

}  // namespace gdsl
