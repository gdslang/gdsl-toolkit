package gdsl.asm.operand;

import gdsl.asm.Visitor;

public class Sum extends Operand {
  private Operand lhs;
  
  public Operand getLhs() {
    return lhs;
  }
  
  private Operand rhs;
  
  public Operand getRhs() {
    return rhs;
  }

  /**
   * @param lhs
   * @param rhs
   */
  public Sum (Operand lhs, Operand rhs) {
    super();
    this.lhs = lhs;
    this.rhs = rhs;
  }

  @Override public String toString () {
    return "(" + lhs + " + " + rhs + ")";
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
