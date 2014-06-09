module gdsl.rreil.linear.immediate;

import gdsl.rreil.linear.linear;
import gdsl.multiplex.gdsl_generic;
import std.conv;

class Immediate : Linear {
  private int_t _inner;
  
  @property public int_t inner() {
    return _inner;
  }
  
  public this(int_t _inner) {
    this._inner = _inner;
  }
  
  public override string toString() {
    return to!string(_inner);
  }
}

unittest {
  Immediate li = new Immediate(88);
  assert(li.toString == "88");
}