/*
 * rreil_builder.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/frontend/frontend.h>
#include <cppgdsl/gdsl.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <vector>

namespace gdsl {

class rreil_builder {
private:
  gdsl *g;
public:
  rreil_builder(gdsl *g);

  std::vector<rreil::statement*> *convert(obj_t rreil);
};

}
