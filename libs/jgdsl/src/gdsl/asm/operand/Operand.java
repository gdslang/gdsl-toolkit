package gdsl.asm.operand;

import gdsl.asm.Visitor;

public abstract class Operand {
  @Override public abstract String toString ();
  public abstract void accept(Visitor v);
}
