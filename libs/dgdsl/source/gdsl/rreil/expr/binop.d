module gdsl.rreil.expr.binop;

import gdsl.rreil.expr.expr;
import gdsl.rreil.linear.linear;

enum BinopType : string {
  MUL = "*",
  DIV = "/u",
  DIVS = "/s",
  MOD = "%u",
  MODS = "%s",
  SHL = "<<",
  SHR = ">>u",
  SHRS = ">>s",
  AND = "&",
  OR = "|",
  XOR = "^"
}

class Binop : Expression {
  private BinopType _type;
  @property public BinopType type() {
    return _type;
  }
  
  private Linear _opnd1;
  @property public Linear opnd1() {
    return _opnd1;
  }
  
  private Linear _opnd2;
  @property public Linear opnd2() {
    return _opnd2;
  }
  
  public this(BinopType type, Linear opnd1, Linear opnd2) {
    this._type = type;
    this._opnd1 = opnd1;
    this._opnd2 = opnd2;
  }
  
  public override string toString() {
    return _opnd1.toString ~ " " ~ cast(string)_type ~ " " ~ _opnd2.toString();
  }
}

unittest {
  import gdsl.rreil.linear.immediate;
  auto bep = new Binop(BinopType.AND, new Immediate(42), new Immediate(123));
  assert(bep.toString == "42 & 123");
}