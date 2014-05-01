module gdsl.frontend;

import std.stdio;
import gdsl.multiplex.multiplex;
import gdsl.reference_manager;

class Frontend : IReferable {
  private gdsl.multiplex.multiplex.frontend _native;
  private bool valid = false;
  
  private ReferenceManager _refManager;
  
//  //Todo: immutable
//  @property public ref auto native() {
//    return _native;
//  }
  
  @property public ReferenceManager refManager() {
    return _refManager;
  }
  
  this(string name) {
    _refManager = new ReferenceManager(this);
    
    char result = gdsl_multiplex_frontend_get_by_lib_name(&_native, (name ~ '\0').ptr);
    if(result != MultiplexError.none)
      throw new Exception(":-(");
    else
      valid = true;
  }
  
  override public void free() {
//    writefln("Freeing frontend");
    if(valid) {
      gdsl_multiplex_frontend_close(&_native);
      valid = false;
    }
  }
  
  ~this() {
    free();
  }
  
  package state_t init() {
    return _native.generic.init();
  }
  
  package void destroyGdsl(state_t gdslState) {
    _native.generic.destroy(gdslState);
  }
  
  package void resetHeap(state_t gdslState) {
    _native.generic.reset_heap(gdslState);
  }
}

unittest {
  Frontend f = new Frontend("x86");
  clear(f);
}