package gdsl.asm.operand;

import gdsl.asm.Visitor;

public class Register extends Operand {
  private String register;
  
  public String getRegister() {
    return register;
  }

  /**
   * @param register
   */
  public Register (String register) {
    super();
    this.register = register;
  }

  @Override public String toString () {
    return register;
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
