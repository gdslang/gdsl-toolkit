module gdsl.rreil.sexpr.linear;

import gdsl.rreil.sexpr.sexpr;
import linear = gdsl.rreil.linear.linear;

class Linear : Sexpr {
  private linear.Linear _inner;
  
  @property public linear.Linear inner() {
    return _inner;
  }
  
  public this(linear.Linear inner) {
    this._inner = inner;
  }
  
  public override string toString() {
    return _inner.toString();
  }
}

unittest {
  import gdsl.rreil.linear.immediate;
  Linear l = new Linear(new Immediate(99));
  assert(l.toString() == "99");
}