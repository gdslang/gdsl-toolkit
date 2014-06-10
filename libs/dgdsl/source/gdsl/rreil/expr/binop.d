module gdsl.rreil.expr.binop;

import gdsl.rreil.expr.expr;

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
  
  private Expression _opnd1;
  @property public Expression opnd1() {
    return _opnd1;
  }
  
  private Expression _opnd2;
  @property public Expression opnd2() {
    return _opnd2;
  }
  
  public this(BinopType type, Expression opnd1, Expression opnd2) {
    this._type = type;
    this._opnd1 = opnd1;
    this._opnd2 = opnd2;
  }
  
  public override string toString() {
    return _opnd1.toString ~ " " ~ cast(string)_type ~ " " ~ _opnd2.toString();
  }
}

unittest {
  
}