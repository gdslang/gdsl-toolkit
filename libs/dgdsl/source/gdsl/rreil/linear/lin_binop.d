module gdsl.rreil.linear.lin_binop;

import gdsl.rreil.linear.linear;

enum LinearBinopOp : string {
  Add = "+", Sub = "+"
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
  
  public override string toString() {
    return "(" ~ _opnd1.toString() ~ " " ~ cast(string)_op ~ " " ~ _opnd2.toString() ~ ")";
  }
}

unittest {
  import gdsl.rreil.linear.lin_imm;
  auto lb = new LinearBinop(LinearBinopOp.Add, new LinImm(99), new LinImm(11));
//  import std.stdio;
//  writefln(lb.toString);
  assert(lb.toString() == "(99 + 11)");
}