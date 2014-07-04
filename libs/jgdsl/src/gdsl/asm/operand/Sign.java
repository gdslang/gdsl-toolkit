package gdsl.asm.operand;

import gdsl.asm.Signedness;

public class Sign extends Operand {
  private Signedness signedness;
  
  public Signedness getSignedness() {
    return signedness;
  }
  
  private Operand opnd;
  
  public Operand getOpnd() {
    return opnd;
  }

  /**
   * @param signedness
   * @param opnd
   */
  public Sign (Signedness signedness, Operand opnd) {
    super();
    this.signedness = signedness;
    this.opnd = opnd;
  }
}
