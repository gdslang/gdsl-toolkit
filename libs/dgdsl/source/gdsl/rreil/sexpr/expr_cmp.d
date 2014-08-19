module gdsl.rreil.sexpr.expr_cmp;

import gdsl.rreil.sexpr.sexpr;
import expr_cmp = gdsl.rreil.expr_cmp.expr_cmp;

class CompareExpression : Sexpr {
  private expr_cmp.CompareExpression _inner;
  
  @property public expr_cmp.CompareExpression inner() {
    return _inner;
  }
  
  public this(expr_cmp.CompareExpression inner) {
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