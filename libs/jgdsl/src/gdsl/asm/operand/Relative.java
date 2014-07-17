package gdsl.asm.operand;

import gdsl.asm.Visitor;

public class Relative extends Operand {
  private Operand operand;
  
  public Operand getOperand() {
    return operand;
  }

  /**
   * @param operand
   */
  public Relative (Operand operand) {
    super();
    this.operand = operand;
  }

  @Override public String toString () {
    return "(? + " + operand  + ")";
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
