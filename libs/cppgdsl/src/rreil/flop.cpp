/*
 * flop.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/flop.h>

std::string gdsl::rreil::flop_to_string(flop f) {
  switch(f) {
    case FLOP_FADD: {
      return ".+";
    }
    case FLOP_FSUB: {
      return ".-";
    }
    case FLOP_FMUL: {
      return ".*";
    }
  }
}
