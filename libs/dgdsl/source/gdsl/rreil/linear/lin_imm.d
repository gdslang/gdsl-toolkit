module gdsl.rreil.linear.lin_imm;

import gdsl.rreil.linear.linear;
import gdsl.multiplex.gdsl_generic;
import std.conv;

class LinImm : Linear {
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
  LinImm li = new LinImm(88);
  assert(li.toString == "88");
}