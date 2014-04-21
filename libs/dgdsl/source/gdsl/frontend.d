module gdsl.frontend;

import std.stdio;
import std.string;
import gdsl.generated;
import gdsl.multiplex;
import gdsl.reference_manager;

import core.memory;

class Frontend : IReferable {
  private gdsl.multiplex.frontend _native;
  private bool valid = false;
  
//  //Todo: immutable
//  @property public ref auto native() {
//    return _native;
//  }
  
//  @property public ReferenceManager refManager() {
//    return _refManager;
//  }
  
  this(string name) {
//    _refManager = new ReferenceManager(this, 1);
    
    ubyte result = gdsl_multiplex_frontend_get_by_lib_name(&_native, name.ptr);
    if(result != MultiplexError.none)
      throw new Exception(format(":-( %s", result));
    else
      valid = true;
      
//    GC.setAttr(cast(void*)this, GC.BlkAttr.NO_MOVE);
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
    free();
        writefln("Hallo c");
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
//  Frontend f = new Frontend("x86");
//  clear(f);
}