module gdsl.rreil.linear.binop;

import gdsl.rreil.linear.linear;

enum LinearBinopOp {
  Add, Sub
}

class LinearBinop : Linear {
  private LinearBinopOp _op;
  @property public LinearBinopOp op() {
    return _op;
  }
  
  private Linear _opnd1;
  @property public Linear opnd1() {
    return _opnd1;
  }
  
  private Linear _opnd2;
  @property Linear opnd2() {
    return _opnd2;
  }
  
  public this(LinearBinopOp _op, Linear _opnd1, Linear _opnd2) {
    this._op = _op;
    this._opnd1 = _opnd1;
    this._opnd2 = _opnd2;
  }
}