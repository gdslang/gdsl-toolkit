module gdsl.gdsl;

import std.stdio;
import gdsl.reference_manager;
import gdsl.frontend;
import gdsl.multiplex.multiplex;

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
    this._frontend.refManager.reference();
    this._gdslState = frontend.init();
  }
  
  ~this() {
    if(_gdslState != null) {
      _frontend.destroyGdsl(_gdslState);
      _frontend.refManager.unreference();
      _gdslState = null;
    }
  }
  
  override void free() {
    _frontend.resetHeap(_gdslState);
  }
}

unittest {
  for(uint i = 0; i < 10; i++) {
    Frontend f = new Frontend("current");
    Gdsl gdsl = new Gdsl(f);
  }
  import core.memory;
  GC.collect();
}