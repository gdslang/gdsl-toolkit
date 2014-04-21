module gdsl.gdsl;

import std.stdio;
import gdsl.reference_manager;
import gdsl.generated;
import gdsl.frontend;
import gdsl.generated;
import gdsl.multiplex;

import core.memory;

class Gdsl : IReferable {
  private state_t _gdslState;
  private Frontend _frontend;
  private ReferenceManager heapManager;
  
  @property Frontend frontend() {
    return _frontend;
  }
  
  this(Frontend frontend) {
    this.heapManager = new ReferenceManager(this);
    this._frontend = frontend;
//    this._frontend.refManager.reference();
    GC.addRoot(cast(void*)this._frontend);
    this._gdslState = frontend.init();
  }
  
  ~this() {
    if(_gdslState != null) {
      _frontend.destroyGdsl(_gdslState);
      GC.removeRoot(cast(void*)this._frontend);
//      _frontend.refManager.unreference();
      _gdslState = null;
    }
  }
  
  override void free() {
    _frontend.resetHeap(_gdslState);
  }
}

unittest {
  for(int i = 0; i < 10000; i++) {
    Frontend f = new Frontend("x86");
    Gdsl gdsl = new Gdsl(f);
  }
}