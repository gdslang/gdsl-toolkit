/*
 * bare_frontend.cpp
 *
 *  Created on: May 22, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/frontend/bare_frontend.h>

using namespace std;

gdsl::bare_frontend::bare_frontend(string name) {
  char err = gdsl_multiplex_frontend_get_by_lib_name(&frontend, name.c_str());
  if(err != GDSL_MULTIPLEX_ERROR_NONE)
    throw string("Unable to open frontend");
}
