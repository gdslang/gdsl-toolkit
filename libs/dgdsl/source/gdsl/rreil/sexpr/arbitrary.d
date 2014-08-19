module gdsl.rreil.sexpr.arbitrary;

import gdsl.rreil.sexpr.sexpr;

class Arbitrary : Sexpr {
  public override string toString() {
    return "arbitrary";
  }
}

unittest {
  Arbitrary a = new Arbitrary();
  assert(a.toString == "arbitrary");
}