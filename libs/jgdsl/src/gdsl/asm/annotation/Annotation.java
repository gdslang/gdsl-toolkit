package gdsl.asm.annotation;

import gdsl.asm.Visitor;

public abstract class Annotation {
  @Override public abstract String toString ();
  public abstract void accept(Visitor v);
}
