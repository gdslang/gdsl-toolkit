/*
 * frontend.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/frontend/frontend.h>
#include <stdio.h>

gdsl::_frontend::~_frontend() {
  if(initialized) gdsl_multiplex_frontend_close(&frontend);
}

