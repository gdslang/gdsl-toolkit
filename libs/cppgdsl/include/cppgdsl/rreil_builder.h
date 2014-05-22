/*
 * rreil_builder.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/frontend/frontend.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <vector>

namespace gdsl {

class rreil_builder {
private:
  state_t gdsl_state;
  _frontend *frontend;
public:
  rreil_builder(state_t gdsl_state, _frontend *frontend);

  std::vector<rreil::statement*> *convert(obj_t rreil);
};

}
