/*
 * preservation.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <gdsl_generic.h>

namespace gdsl {

enum preservation {
  EVERYWHERE = PRESERVATION_EVERYWHERE,
  BLOCK = PRESERVATION_BLOCK,
  CONTEXT = PRESERVATION_CONTEXT
};

}  // namespace gdsl
