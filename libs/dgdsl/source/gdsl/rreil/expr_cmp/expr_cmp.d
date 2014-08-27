module gdsl.rreil.expr_cmp.expr_cmp;

import gdsl.rreil.linear.linear;

enum CompareOpType : string {
  CMPEQ = "==",
  CMPNEQ = "!=",
  CMPLES = "<=s",
  CMPLEU = "<=u",
  CMPLTS = "<s",
  CMPLTU = "<u"
}

class CompareExpression {
  private CompareOpType _op;
  
  @property public CompareOpType op() {
    return op;
  }
  
  private Linear _opnd1;
  
  @property public Linear opnd1() {
    return _opnd1;
  }
  
  private Linear _opnd2;
  
  @property public Linear opnd2() {
    return _opnd2;
  }
  
  public this(CompareOpType op, Linear opnd1, Linear opnd2) {
    this._op = op;
    this._opnd1 = opnd1;
    this._opnd2 = opnd2;
  }
  
  public override string toString() {
    return _opnd1.toString() ~ " " ~ cast(string)_op ~ _opnd2.toString();
  }
}
