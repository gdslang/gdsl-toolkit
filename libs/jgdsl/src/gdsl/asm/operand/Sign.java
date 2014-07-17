package gdsl.asm.operand;

import gdsl.asm.Signedness;
import gdsl.asm.Visitor;

public class Sign extends Operand {
  private Signedness signedness;
  
  public Signedness getSignedness() {
    return signedness;
  }
  
  private Operand operand;
  
  public Operand getOperand() {
    return operand;
  }

  /**
   * @param signedness
   * @param operand
   */
  public Sign (Signedness signedness, Operand operand) {
    super();
    this.signedness = signedness;
    this.operand = operand;
  }

  @Override public String toString () {
    return "(" + signedness + " " + operand + ")";
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
