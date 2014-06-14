module gdsl.rreil.expr.extension;

import gdsl.rreil.expr.expr;
import gdsl.rreil.linear.linear;
import gdsl.multiplex.gdsl_generic;

import std.conv;

enum ExtensionOp : string {
  Sx = "s",
  Zx = "z"
}

class Extension : Expression {
  private ExtensionOp _op;
  @property public ExtensionOp op() {
    return _op;
  }
  
  private int_t _fromSize;
  @property public int_t fromSize() {
    return _fromSize;
  }
  
  private Linear _opnd;
  @property Linear opnd() {
    return _opnd;
  }
  
  public this(ExtensionOp op, int_t fromSize, Linear opnd) {
    this._op = op;
    this._fromSize = fromSize;
    this._opnd = opnd;
  }
  
  public override string toString() {
    //return "[" ~ to!string(fromSize) ~ "->" ~ cast(string)_op ~ "]" ~ _opnd.toString();
    return "[" ~ to!string(_fromSize) ~ "->" ~ cast(string)_op ~ "]" ~ _opnd.toString();
  }
}

unittest {
  import gdsl.rreil.linear.immediate;
  auto ext = new Extension(ExtensionOp.Sx, 16, new Immediate(42));
  assert(ext.toString() == "[16->s]42");
}