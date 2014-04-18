module gdsl.frontend;

import gdsl.multiplex;

class Frontend {
  private frontend _frontend;
  
  this(string name) {
    char result = gdsl_multiplex_frontend_get_by_lib_name(&_frontend, name.ptr);
  }
}