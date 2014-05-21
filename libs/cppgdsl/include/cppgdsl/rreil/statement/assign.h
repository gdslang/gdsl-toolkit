/*
 * rreil_assign.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

extern "C" {
#include <gdsl_generic.h>
}
#include <rreil_statement.h>

namespace gdsl {
namespace rreil {

class assign : public statement {
  int_t size;
};

}}
