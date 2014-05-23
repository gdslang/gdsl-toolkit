/*
 * frontend.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/frontend/frontend.h>

gdsl::_frontend::~_frontend() {
  gdsl_multiplex_frontend_close(&frontend);
}

