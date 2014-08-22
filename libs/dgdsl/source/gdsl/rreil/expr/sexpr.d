module gdsl.rreil.expr.sexpr;

import gdsl.rreil.expr.expr;
import sexpr = gdsl.rreil.sexpr.sexpr;

class Sexpr : Expression {
  private sexpr.Sexpr _inner;
  
  @property public sexpr.Sexpr inner() {
    return _inner;
  }
  
  public this(sexpr.Sexpr inner) {
    _inner = inner;
  }
  
  public override string toString() {
    return _inner.toString();
  }
}

unittest {
  import gdsl.rreil.sexpr.arbitrary;
  Sexpr s = new Sexpr(new Arbitrary());
  assert(s.toString == "arbitrary");
}