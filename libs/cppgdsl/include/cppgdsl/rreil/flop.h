/*
 * flop.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>

namespace gdsl {
namespace rreil {

enum flop {
  FLOP_FADD, FLOP_FSUB, FLOP_FMUL
};

std::string flop_to_string(flop f);

}
}
