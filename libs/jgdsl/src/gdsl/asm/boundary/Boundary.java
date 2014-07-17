package gdsl.asm.boundary;

import gdsl.asm.Visitor;

public abstract class Boundary {
  @Override public abstract String toString ();
  public abstract void accept(Visitor v);
}
