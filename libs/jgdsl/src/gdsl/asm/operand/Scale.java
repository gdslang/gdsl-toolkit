package gdsl.asm.operand;

import gdsl.asm.Visitor;

public class Scale extends Operand {
  private long factor;
  
  public long getFactor() {
    return factor;
  }
  
  private Operand rhs;
  
  public Operand getRhs() {
    return rhs;
  }

  /**
   * @param lhs
   * @param rhs
   */
  public Scale (long factor, Operand rhs) {
    super();
    this.factor = factor;
    this.rhs = rhs;
  }

  @Override public String toString () {
    return factor + "*(" + rhs + ")";
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
