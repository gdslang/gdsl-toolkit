module gdsl.frontend;

import std.stdio;
import gdsl.generated;
import gdsl.multiplex;
import gdsl.reference_manager;

class Frontend : IReferable {
  private gdsl.multiplex.frontend _native;
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
    _refManager = new ReferenceManager(this, 1);
    
    char result = gdsl_multiplex_frontend_get_by_lib_name(&_native, name.ptr);
    if(result != MultiplexError.none)
      throw new Exception(":-(");
    else
      valid = true;
  }
  
  override public void free() {
    if(valid) {
        writefln("Hallo a");
      gdsl_multiplex_frontend_close(&_native);
        writefln("Hallo b");
      valid = false;
    }
  }
  
  ~this() {
        writefln("Hallo c");
        if(_refManager !is null)
          _refManager.unreference();
        writefln("Hallo d");
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