module gdsl.rreil.id.virt_id;

import gdsl.multiplex.gdsl_generic;
import gdsl.rreil.id.id;
import std.conv;

class VirtId : Id {
  private int_t _t;
  
  @property public int_t t() {
    return _t;
  }
  
  public this(int_t _t) {
    this._t = _t;
  }
  
  public override string opCast(T : string)() const {
    return "t" ~ to!(string)(_t);
  }
}