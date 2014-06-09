module gdsl.rreil.linear.lin_scale;

import gdsl.rreil.linear.linear;
import gdsl.multiplex.gdsl_generic;
import std.conv;

class LinearScale : Linear {
  private int_t _scale;
  @property public int_t scale() {
    return _scale;
  }
  
  private Linear _opnd;
  @property Linear opnd() {
    return _opnd;
  }
  
  public this(int_t scale, Linear opnd) {
    this._scale = scale;
    this._opnd = opnd;
  }
  
  public override string toString() {
    return to!string(_scale) ~ "*(" ~ opnd.toString() ~ ")";
  }
}

unittest {
  import gdsl.rreil.linear.lin_imm;
  auto ls = new LinearScale(22, new LinImm(32));
  assert(ls.toString == "22*(32)");
}