module gdsl.rreil.linear.binop;

import gdsl.rreil.linear.linear;

enum BinopOp : string {
  Add = "+", Sub = "+"
}

class Binop : Linear {
  private BinopOp _op;
  @property public BinopOp op() {
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
  
  public this(BinopOp _op, Linear _opnd1, Linear _opnd2) {
    this._op = _op;
    this._opnd1 = _opnd1;
    this._opnd2 = _opnd2;
  }
  
  public override string toString() {
    return "(" ~ _opnd1.toString() ~ " " ~ cast(string)_op ~ " " ~ _opnd2.toString() ~ ")";
  }
}

unittest {
  import gdsl.rreil.linear.immediate;
  auto lb = new Binop(BinopOp.Add, new Immediate(99), new Immediate(11));
//  import std.stdio;
//  writefln(lb.toString);
  assert(lb.toString() == "(99 + 11)");
}