/*
 * bare_frontend.h
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <string>
#include <cppgdsl/frontend/frontend.h>

namespace gdsl {

class bare_frontend : public _frontend {
public:
  bare_frontend(std::string name);
};

}
