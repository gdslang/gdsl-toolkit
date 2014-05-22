/*
 * rreil_builder.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/statement/statement.h>
#include <vector>

namespace gdsl {

class rreil_builder {
public:
  std::vector<rreil::statement*> *translate();
};

}
