package gdsl.asm.operand;

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
}
